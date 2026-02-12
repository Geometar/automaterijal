package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.ProviderOrderOptionDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.dto.checkout.CheckoutConflictDetailsDto;
import com.automaterijal.application.domain.dto.checkout.CheckoutConflictItemDto;
import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.constants.StatusiKonstante;
import com.automaterijal.application.domain.entity.Faktura;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.FakturaMapper;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.FakturaDetaljiRepository;
import com.automaterijal.application.domain.repository.FakturaRepository;
import com.automaterijal.application.domain.repository.MestaIsporukeRepository;
import com.automaterijal.application.domain.repository.weborder.WebOrderHeaderRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPlacanjaRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPrevozaRepository;
import com.automaterijal.application.domain.repository.valuehelp.StatusRepository;
import com.automaterijal.application.exception.CheckoutConflictException;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.utils.GeneralUtil;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FakturaService {

  private static final int WEB_ID_OFFSET = 1_000_000_000;
  private static final int MAGACIN_SABAC_ID = 1;
  private static final String FEBI_PROVIDER_KEY = "febi-stock";

  @NonNull final FakturaRepository fakturaRepository;
  @NonNull final FakturaDetaljiRepository fakturaDetaljiRepository;
  @NonNull final StatusRepository statusRepository;
  @NonNull final NacinPlacanjaRepository nacinPlacanjaRepository;
  @NonNull final NacinPrevozaRepository nacinPrevozaRepository;
  @NonNull final MestaIsporukeRepository mestaIsporukeRepository;
  @NonNull final RobaDatabaseService robaDatabaseService;
  @NonNull final RobaCeneService robaCeneService;
  @NonNull final ProizvodjacService proizvodjacService;
  @NonNull final PartnerService partnerService;
  @NonNull final ProviderOrderService providerOrderService;
  @NonNull final WebOrderHeaderRepository webOrderHeaderRepository;
  @NonNull final FakturaMapper mapper;
  @NonNull final RobaMapper robaMapper;
  @NonNull final ImageService imageService;

  private static final class SplitAllocation {
    private final FakturaDetaljiDto detail;
    private final double stockQuantity;
    private final double providerQuantity;

    private SplitAllocation(FakturaDetaljiDto detail, double stockQuantity, double providerQuantity) {
      this.detail = detail;
      this.stockQuantity = stockQuantity;
      this.providerQuantity = providerQuantity;
    }

    private boolean hasStockQuantity() {
      return stockQuantity > 0d;
    }

    private boolean hasProviderQuantity() {
      return providerQuantity > 0d;
    }
  }

  @Transactional
  public List<RobaLightDto> submitujFakturu(FakturaDto fakturaDto, Partner partner) {
    var now = Timestamp.valueOf(LocalDateTime.now());
    boolean internalOrder = PartnerPrivilegeUtils.isInternal(partner);
    String requestKey = normalizeRequestKey(fakturaDto != null ? fakturaDto.getIdempotencyKey() : null);
    if (requestKey != null) {
      Optional<WebOrderHeader> existing =
          webOrderHeaderRepository.findByPpidAndRequestKey(partner.getPpid(), requestKey);
      if (existing.isPresent()) {
        return resumeIdempotentSubmission(existing.get(), fakturaDto, partner, internalOrder);
      }
    }

    var nextOrderId = getNextOrderId(partner.getPpid());

    List<FakturaDetaljiDto> orderDetails = Optional.ofNullable(fakturaDto.getDetalji()).orElse(List.of());
    List<SplitAllocation> allocations = allocateDetails(orderDetails, internalOrder);
    List<FakturaDetaljiDto> stockDetails = extractStockDetails(allocations);
    List<RobaLightDto> outOfStockItems = extractProviderItems(allocations);

    WebOrderHeader webOrderHeader;
    try {
      webOrderHeader =
          saveWebOrder(fakturaDto, partner, nextOrderId, now, internalOrder, allocations, requestKey);
    } catch (DataIntegrityViolationException ex) {
      if (requestKey == null) {
        throw ex;
      }
      Optional<WebOrderHeader> existing =
          webOrderHeaderRepository.findByPpidAndRequestKey(partner.getPpid(), requestKey);
      if (existing.isPresent()) {
        return resumeIdempotentSubmission(existing.get(), fakturaDto, partner, internalOrder);
      }
      throw ex;
    }

    providerOrderService.preflightOrders(webOrderHeader, partner);
    validateProviderConfirmation(webOrderHeader);
    providerOrderService.clearProcessingMarkers(webOrderHeader);
    providerOrderService.placeOrders(webOrderHeader, partner);
    validateProviderConfirmation(webOrderHeader);

    if (!stockDetails.isEmpty() && !internalOrder) {
      saveErpStockOrder(fakturaDto, partner, nextOrderId, stockDetails);
      webOrderHeader.setErpExported(1);
    }

    partnerService.povecanPartnerovOrderCount(partner);
    sanitizeProviderPurchasePrice(outOfStockItems, partner);
    return outOfStockItems;
  }

  private List<RobaLightDto> resumeIdempotentSubmission(
      WebOrderHeader existingHeader, FakturaDto fakturaDto, Partner partner, boolean internalOrder) {
    providerOrderService.placeOrders(existingHeader, partner);
    validateProviderConfirmation(existingHeader);

    if (!internalOrder && (existingHeader.getErpExported() == null || existingHeader.getErpExported() != 1)) {
      List<FakturaDetaljiDto> stockDetails = extractStockDetailsFromHeader(existingHeader);
      if (!stockDetails.isEmpty()) {
        Integer orderId =
            existingHeader.getOrderId() != null
                ? existingHeader.getOrderId()
                : getNextOrderId(partner.getPpid());
        saveErpStockOrder(fakturaDto, partner, orderId, stockDetails);
        existingHeader.setErpExported(1);
      }
    }

    List<RobaLightDto> outOfStockItems = extractProviderItemsFromHeader(existingHeader);
    sanitizeProviderPurchasePrice(outOfStockItems, partner);
    return outOfStockItems;
  }

  private Integer getNextOrderId(Integer ppid) {
    var erpLast =
        fakturaRepository
            .findFirstByPpidOrderByOrderIdDesc(ppid)
            .map(Faktura::getOrderId)
            .orElse(0);
    var webLast =
        webOrderHeaderRepository
            .findFirstByPpidOrderByOrderIdDesc(ppid)
            .map(WebOrderHeader::getOrderId)
            .orElse(0);
    return Math.max(erpLast, webLast) + 1;
  }

  private WebOrderHeader saveWebOrder(
      FakturaDto fakturaDto,
      Partner partner,
      Integer orderId,
      Timestamp now,
      boolean forceProvider,
      List<SplitAllocation> allocations,
      String requestKey) {
    WebOrderHeader header = new WebOrderHeader();
    header.setPpid(partner.getPpid());
    header.setOrderId(orderId);
    header.setLastUpdate(now);
    header.setDateSent(now);
    header.setStatus(StatusiKonstante.NIJE_UZETA_U_OBRADU.getFieldValue());
    header.setNuid(mapper.map(fakturaDto.getNacinPlacanja()));
    header.setNiid(mapper.map(fakturaDto.getNacinPrevoza()));
    header.setPrid(1);
    header.setBackOrder(0);
    header.setRealizovati(1);
    header.setCreatedByPpid(partner.getPpid());
    header.setMestoIsporuke(fakturaDto.getAdresa() != null ? fakturaDto.getAdresa().getId() : 0);
    header.setNapomena(fakturaDto.getNapomena());
    header.setIznosNaruceno(fakturaDto.getIznosNarucen());
    header.setIznosPotvrdjeno(0.0);
    header.setErpExported(0);
    header.setInternalOrder(forceProvider ? 1 : 0);
    header.setRequestKey(requestKey);

    Map<String, String> providerDeliveryParties =
        resolveProviderDeliveryParties(fakturaDto, partner);
    List<WebOrderItem> items = new ArrayList<>();
    for (SplitAllocation allocation : allocations) {
      if (allocation == null || allocation.detail == null) {
        continue;
      }
      if (allocation.hasStockQuantity()) {
        items.add(
            buildWebOrderItem(
                header,
                partner,
                allocation.detail,
                allocation.stockQuantity,
                OrderItemSource.STOCK,
                now,
                providerDeliveryParties));
      }
      if (allocation.hasProviderQuantity()) {
        items.add(
            buildWebOrderItem(
                header,
                partner,
                allocation.detail,
                allocation.providerQuantity,
                OrderItemSource.PROVIDER,
                now,
                providerDeliveryParties));
      }
    }

    header.setItems(items);
    return webOrderHeaderRepository.save(header);
  }

  private String normalizeRequestKey(String requestKey) {
    if (!StringUtils.hasText(requestKey)) {
      return null;
    }
    String normalized = requestKey.trim();
    if (normalized.length() <= 64) {
      return normalized;
    }
    return sha256Hex(normalized);
  }

  private String sha256Hex(String input) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
      StringBuilder sb = new StringBuilder(hash.length * 2);
      for (byte b : hash) {
        sb.append(String.format("%02x", b));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
      throw new IllegalStateException("SHA-256 is not available", ex);
    }
  }

  private WebOrderItem buildWebOrderItem(
      WebOrderHeader header,
      Partner partner,
      FakturaDetaljiDto detalji,
      double quantity,
      OrderItemSource source,
      Timestamp now,
      Map<String, String> providerDeliveryParties) {
    WebOrderItem item = new WebOrderItem();
    item.setHeader(header);
    item.setPpid(partner.getPpid());
    item.setRobaId(detalji.getRobaId());
    item.setTecDocArticleId(detalji.getTecDocArticleId());
    item.setBrand(detalji.getProizvodjac() != null ? detalji.getProizvodjac().getProid() : null);
    item.setBrandName(detalji.getProizvodjac() != null ? detalji.getProizvodjac().getNaziv() : null);
    item.setCatalogNumber(detalji.getKataloskiBroj());
    item.setArticleName(detalji.getNaziv());
    item.setMagacinId(source == OrderItemSource.STOCK ? MAGACIN_SABAC_ID : 0);
    item.setKolicina(quantity);
    item.setPotvrdjenaKolicina(0.0);
    item.setCena(detalji.getCena() != null ? detalji.getCena() : 0.0);
    item.setStatus(StatusiKonstante.NIJE_UZETA_U_OBRADU.getFieldValue());
    item.setKolicine(1);
    item.setRabat(detalji.getRabat() != null ? detalji.getRabat() : 0.0);
    item.setPdv(20.0);
    item.setInsertDatetime(now);
    item.setItemSource(source);
    item.setProviderCode(source == OrderItemSource.PROVIDER ? "EXTERNAL" : null);

    if (source == OrderItemSource.PROVIDER && detalji.getProviderAvailability() != null) {
      var a = detalji.getProviderAvailability();
      item.setProviderKey(a.getProvider());
      item.setProviderArticleNumber(a.getArticleNumber());
      item.setProviderAvailable(a.getAvailable());
      item.setProviderTotalQuantity(a.getTotalQuantity());
      item.setProviderWarehouse(a.getWarehouse());
      item.setProviderWarehouseName(a.getWarehouseName());
      item.setProviderWarehouseQuantity(a.getWarehouseQuantity());
      item.setProviderPurchasePrice(a.getPurchasePrice());
      item.setProviderPrice(a.getPrice());
      item.setProviderCurrency(a.getCurrency());
      item.setProviderPackagingUnit(a.getPackagingUnit());
      item.setProviderLeadTimeBusinessDays(a.getLeadTimeBusinessDays());
      item.setProviderDeliveryToCustomerDaysMin(a.getDeliveryToCustomerBusinessDaysMin());
      item.setProviderDeliveryToCustomerDaysMax(a.getDeliveryToCustomerBusinessDaysMax());
      item.setProviderNextDispatchCutoff(a.getNextDispatchCutoff());
      item.setProviderProductId(a.getProviderProductId());
      item.setProviderStockToken(a.getProviderStockToken());
      item.setProviderNoReturnable(a.getProviderNoReturnable());
      item.setProviderCoreCharge(a.getCoreCharge());
    }
    applyProviderDeliveryParty(item, providerDeliveryParties);

    if (detalji.getSlika() != null) {
      item.setImageUrl(detalji.getSlika().getSlikeUrl());
      item.setImageIsUrl(detalji.getSlika().isUrl());
      item.setImageRobaSlika(detalji.getSlika().getRobaSlika());
    }
    return item;
  }

  private List<SplitAllocation> allocateDetails(
      List<FakturaDetaljiDto> details, boolean forceProvider) {
    if (details == null || details.isEmpty()) {
      return List.of();
    }

    Map<Long, Double> stockByRobaId = new HashMap<>();
    List<SplitAllocation> out = new ArrayList<>();
    for (FakturaDetaljiDto detalji : details) {
      SplitAllocation allocation = allocateDetail(detalji, forceProvider, stockByRobaId);
      if (allocation == null) {
        continue;
      }
      if (allocation.hasStockQuantity() || allocation.hasProviderQuantity()) {
        out.add(allocation);
      }
    }
    return out;
  }

  private SplitAllocation allocateDetail(
      FakturaDetaljiDto detalji, boolean forceProvider, Map<Long, Double> stockByRobaId) {
    if (detalji == null) {
      return null;
    }
    double requested = sanitizeQuantity(detalji.getKolicina());
    if (requested <= 0d) {
      return new SplitAllocation(detalji, 0d, 0d);
    }

    if (forceProvider) {
      return new SplitAllocation(detalji, 0d, requested);
    }
    if (detalji.getRobaId() == null) {
      return new SplitAllocation(detalji, 0d, requested);
    }

    double localStock = resolveLocalStock(detalji.getRobaId(), stockByRobaId);
    if (localStock >= requested) {
      stockByRobaId.put(detalji.getRobaId(), Math.max(0d, localStock - requested));
      return new SplitAllocation(detalji, requested, 0d);
    }

    if (!isFebiAvailability(detalji)) {
      return new SplitAllocation(detalji, 0d, requested);
    }

    int packagingUnit = resolveProviderPackagingUnit(detalji);
    int minOrderQuantity = resolveProviderMinOrderQuantity(detalji, packagingUnit);
    double localAllocation;
    double providerRequested;
    if (shouldPreferProviderOnlyAllocation(
        requested,
        localStock,
        packagingUnit,
        minOrderQuantity)) {
      localAllocation = 0d;
      providerRequested = requested;
    } else {
      localAllocation = Math.min(localStock, requested);
      providerRequested = Math.max(0d, requested - localAllocation);
    }

    stockByRobaId.put(detalji.getRobaId(), Math.max(0d, localStock - localAllocation));
    if (providerRequested <= 0d) {
      return new SplitAllocation(detalji, localAllocation, 0d);
    }

    validateFebiSnapshotAvailability(
        detalji,
        requested,
        localAllocation,
        providerRequested);
    return new SplitAllocation(detalji, localAllocation, providerRequested);
  }

  private boolean shouldPreferProviderOnlyAllocation(
      double requestedQty,
      double localStock,
      int packagingUnit,
      int minOrderQuantity) {
    int requested = toRequestedQuantity(requestedQty);
    int local = toRequestedQuantity(localStock);
    if (requested <= local) {
      return false;
    }
    boolean constrainedExternal = packagingUnit > 1 || minOrderQuantity > 1;
    if (!constrainedExternal) {
      return false;
    }
    boolean packagingCompatible = packagingUnit <= 1 || requested % packagingUnit == 0;
    boolean minimumCompatible = requested >= minOrderQuantity;
    return packagingCompatible && minimumCompatible;
  }

  private List<FakturaDetaljiDto> extractStockDetails(List<SplitAllocation> allocations) {
    List<FakturaDetaljiDto> stockDetails = new ArrayList<>();
    for (SplitAllocation allocation : allocations) {
      if (allocation == null || allocation.detail == null || !allocation.hasStockQuantity()) {
        continue;
      }
      stockDetails.add(copyDetailWithQuantity(allocation.detail, allocation.stockQuantity));
    }
    return stockDetails;
  }

  private List<RobaLightDto> extractProviderItems(List<SplitAllocation> allocations) {
    List<RobaLightDto> outOfStockItems = new ArrayList<>();
    for (SplitAllocation allocation : allocations) {
      if (allocation == null || allocation.detail == null || !allocation.hasProviderQuantity()) {
        continue;
      }
      FakturaDetaljiDto detalji = allocation.detail;
      if (detalji.getRobaId() != null) {
        robaDatabaseService
            .findByRobaId(detalji.getRobaId())
            .ifPresent(roba -> outOfStockItems.add(robaMapper.map(roba)));
        continue;
      }

      RobaLightDto placeholder = new RobaLightDto();
      placeholder.setRobaid(null);
      placeholder.setTecDocArticleId(detalji.getTecDocArticleId());
      placeholder.setKatbr(detalji.getKataloskiBroj());
      placeholder.setNaziv(detalji.getNaziv());
      placeholder.setSlika(detalji.getSlika());
      placeholder.setProviderAvailability(detalji.getProviderAvailability());
      placeholder.setAvailabilityStatus(detalji.getAvailabilityStatus());
      placeholder.setCena(detalji.getCena() != null ? java.math.BigDecimal.valueOf(detalji.getCena()) : null);
      placeholder.setRabat(detalji.getRabat());
      if (detalji.getProizvodjac() != null) {
        ProizvodjacDTO p = new ProizvodjacDTO();
        p.setProizvodjac(detalji.getProizvodjac());
        placeholder.setProizvodjac(p);
      }
      outOfStockItems.add(placeholder);
    }
    return outOfStockItems;
  }

  private FakturaDetaljiDto copyDetailWithQuantity(FakturaDetaljiDto source, double quantity) {
    FakturaDetaljiDto copy = new FakturaDetaljiDto();
    copy.setRobaId(source.getRobaId());
    copy.setTecDocArticleId(source.getTecDocArticleId());
    copy.setSlika(source.getSlika());
    copy.setKataloskiBroj(source.getKataloskiBroj());
    copy.setKataloskiBrojProizvodjaca(source.getKataloskiBrojProizvodjaca());
    copy.setNaziv(source.getNaziv());
    copy.setProizvodjac(source.getProizvodjac());
    copy.setKolicina(quantity);
    copy.setPotvrdjenaKolicina(source.getPotvrdjenaKolicina());
    copy.setCena(source.getCena());
    copy.setStatus(source.getStatus());
    copy.setRabat(source.getRabat());
    copy.setVremePorucivanja(source.getVremePorucivanja());
    copy.setIzvor(source.getIzvor());
    copy.setProviderAvailability(source.getProviderAvailability());
    copy.setAvailabilityStatus(source.getAvailabilityStatus());
    copy.setProviderBackorder(source.getProviderBackorder());
    copy.setProviderMessage(source.getProviderMessage());
    copy.setProviderDeliveryParty(source.getProviderDeliveryParty());
    return copy;
  }

  private double sanitizeQuantity(Double quantity) {
    if (quantity == null || !Double.isFinite(quantity)) {
      return 0d;
    }
    return Math.max(0d, quantity);
  }

  private double resolveLocalStock(Long robaId, Map<Long, Double> stockByRobaId) {
    if (robaId == null) {
      return 0d;
    }
    Double cached = stockByRobaId.get(robaId);
    if (cached != null) {
      return cached;
    }

    double stock =
        robaDatabaseService
            .findByRobaId(robaId)
            .map(Roba::getStanje)
            .map(s -> Double.isFinite(s) ? Math.max(0d, s) : 0d)
            .orElse(0d);
    stockByRobaId.put(robaId, stock);
    return stock;
  }

  private boolean isFebiAvailability(FakturaDetaljiDto detalji) {
    if (detalji == null || detalji.getProviderAvailability() == null) {
      return false;
    }
    String provider = detalji.getProviderAvailability().getProvider();
    return FEBI_PROVIDER_KEY.equalsIgnoreCase(normalizeProviderKey(provider));
  }

  private int resolveProviderSnapshotQuantity(FakturaDetaljiDto detalji) {
    if (detalji == null || detalji.getProviderAvailability() == null) {
      return 0;
    }
    Integer warehouseQty = detalji.getProviderAvailability().getWarehouseQuantity();
    Integer totalQty = detalji.getProviderAvailability().getTotalQuantity();
    int best = Math.max(warehouseQty != null ? warehouseQty : 0, totalQty != null ? totalQty : 0);
    return Math.max(0, best);
  }

  private int resolveProviderPackagingUnit(FakturaDetaljiDto detalji) {
    if (detalji == null || detalji.getProviderAvailability() == null) {
      return 1;
    }
    Integer raw = detalji.getProviderAvailability().getPackagingUnit();
    return raw != null && raw > 1 ? raw : 1;
  }

  private int resolveProviderMinOrderQuantity(FakturaDetaljiDto detalji, int packagingUnit) {
    if (detalji == null || detalji.getProviderAvailability() == null) {
      return Math.max(1, packagingUnit);
    }
    Integer raw = detalji.getProviderAvailability().getMinOrderQuantity();
    int normalized = raw != null && raw > 0 ? raw : 1;
    if (packagingUnit > 1) {
      return Math.max(packagingUnit, ((normalized + packagingUnit - 1) / packagingUnit) * packagingUnit);
    }
    return normalized;
  }

  private void validateFebiSnapshotAvailability(
      FakturaDetaljiDto detalji,
      double requestedTotalQty,
      double localAllocationQty,
      double providerRequestedQty) {
    if (detalji == null) {
      return;
    }
    int providerRequested = toRequestedQuantity(providerRequestedQty);
    if (providerRequested <= 0) {
      return;
    }
    boolean available =
        detalji.getProviderAvailability() != null
            && Boolean.TRUE.equals(detalji.getProviderAvailability().getAvailable());
    int snapshotQty = resolveProviderSnapshotQuantity(detalji);

    int requestedTotal = toRequestedQuantity(requestedTotalQty);
    int localAllocation = toRequestedQuantity(localAllocationQty);
    int packagingUnit = resolveProviderPackagingUnit(detalji);
    int minOrderQuantity = resolveProviderMinOrderQuantity(detalji, packagingUnit);
    int providerMaxOrderable =
        packagingUnit > 1 ? (snapshotQty / packagingUnit) * packagingUnit : snapshotQty;
    boolean constrainedExternal = packagingUnit > 1 || minOrderQuantity > 1;
    int maxOrderable =
        constrainedExternal
            ? Math.max(0, Math.max(localAllocation, providerMaxOrderable))
            : Math.max(0, localAllocation + providerMaxOrderable);
    boolean packagingCompatible = packagingUnit <= 1 || providerRequested % packagingUnit == 0;
    boolean minimumCompatible = providerRequested >= minOrderQuantity;
    if (available && snapshotQty >= providerRequested && packagingCompatible && minimumCompatible) {
      return;
    }
    CheckoutConflictItemDto item =
        CheckoutConflictItemDto.builder()
            .robaId(detalji.getRobaId())
            .tecDocArticleId(detalji.getTecDocArticleId())
            .catalogNumber(detalji.getKataloskiBroj())
            .articleName(detalji.getNaziv())
            .providerKey(FEBI_PROVIDER_KEY)
            .requestedQuantity(requestedTotal)
            .confirmedQuantity(Math.min(requestedTotal, localAllocation))
            .maxOrderableQuantity(maxOrderable)
            .message(
                !minimumCompatible
                    ? "Minimalna dodatna kolicina iz magacina Beograd je " + minOrderQuantity + "."
                    : (packagingCompatible
                        ? "Nema dovoljno stanja u magacinu Beograd za trazenu dodatnu kolicinu."
                        : "Dodatna kolicina iz magacina Beograd mora biti u koraku pakovanja: "
                            + packagingUnit
                            + "."))
            .build();
    throwCheckoutConflict(
        "Nije moguce potvrditi dostupnost iz eksternog magacina.",
        List.of(item));
  }

  private void validateProviderConfirmation(WebOrderHeader header) {
    if (header == null || header.getItems() == null || header.getItems().isEmpty()) {
      return;
    }
    Map<String, Integer> stockAllocationsByKey = resolveStockAllocationsByItemKey(header);
    List<CheckoutConflictItemDto> failed = new ArrayList<>();
    for (WebOrderItem item : header.getItems()) {
      if (item == null || item.getItemSource() != OrderItemSource.PROVIDER) {
        continue;
      }
      int requested = toRequestedQuantity(item.getKolicina());
      if (requested <= 0) {
        continue;
      }
      int confirmed = toRequestedQuantity(item.getPotvrdjenaKolicina());
      boolean explicitUnavailable =
          Boolean.TRUE.equals(item.getProviderBackorder())
              || Boolean.FALSE.equals(item.getProviderAvailable());
      boolean hasProviderResponse =
          confirmed > 0
              || item.getProviderBackorder() != null
              || StringUtils.hasText(item.getProviderMessage())
              || explicitUnavailable;
      if (hasProviderResponse && confirmed < requested) {
        int localAllocation = stockAllocationsByKey.getOrDefault(buildConflictItemKey(item), 0);
        failed.add(buildProviderConflictItem(item, requested, confirmed, localAllocation));
      }
    }

    if (failed.isEmpty()) {
      return;
    }

    throwCheckoutConflict(
        "Nije moguce potvrditi dostupnost iz eksternog magacina.",
        failed);
  }

  private String buildItemLabel(String katalog, String naziv) {
    if (StringUtils.hasText(katalog)) {
      return katalog.trim();
    }
    if (StringUtils.hasText(naziv)) {
      return naziv.trim();
    }
    return "stavku";
  }

  private CheckoutConflictItemDto buildProviderConflictItem(
      WebOrderItem item, int requestedProvider, int confirmedProvider, int localAllocation) {
    int requestedTotal = Math.max(0, requestedProvider) + Math.max(0, localAllocation);
    int maxOrderable = Math.max(0, localAllocation) + Math.max(0, confirmedProvider);
    int confirmedTotal = Math.min(requestedTotal, maxOrderable);
    return CheckoutConflictItemDto.builder()
        .robaId(item.getRobaId())
        .tecDocArticleId(item.getTecDocArticleId())
        .catalogNumber(item.getCatalogNumber())
        .articleName(item.getArticleName())
        .providerKey(normalizeProviderKey(item.getProviderKey()))
        .requestedQuantity(requestedTotal)
        .confirmedQuantity(confirmedTotal)
        .maxOrderableQuantity(maxOrderable)
        .message(resolveProviderConflictMessage(item))
        .build();
  }

  private Map<String, Integer> resolveStockAllocationsByItemKey(WebOrderHeader header) {
    Map<String, Integer> byKey = new HashMap<>();
    if (header == null || header.getItems() == null || header.getItems().isEmpty()) {
      return byKey;
    }
    for (WebOrderItem item : header.getItems()) {
      if (item == null || item.getItemSource() != OrderItemSource.STOCK) {
        continue;
      }
      int qty = toRequestedQuantity(item.getKolicina());
      if (qty <= 0) {
        continue;
      }
      byKey.merge(buildConflictItemKey(item), qty, Integer::sum);
    }
    return byKey;
  }

  private String buildConflictItemKey(WebOrderItem item) {
    if (item == null) {
      return "item";
    }
    if (item.getRobaId() != null) {
      return "roba:" + item.getRobaId();
    }
    if (item.getTecDocArticleId() != null) {
      return "tecdoc:" + item.getTecDocArticleId();
    }
    if (StringUtils.hasText(item.getCatalogNumber())) {
      return "catalog:" + item.getCatalogNumber().trim().toLowerCase(Locale.ROOT);
    }
    if (StringUtils.hasText(item.getArticleName())) {
      return "name:" + item.getArticleName().trim().toLowerCase(Locale.ROOT);
    }
    return "item:" + (item.getId() != null ? item.getId() : 0);
  }

  private String resolveProviderConflictMessage(WebOrderItem item) {
    if (item == null) {
      return "Eksterni magacin nije potvrdio trazenu kolicinu.";
    }
    if (StringUtils.hasText(item.getProviderMessage())) {
      return item.getProviderMessage().trim();
    }
    return "Eksterni magacin nije potvrdio trazenu kolicinu.";
  }

  private void throwCheckoutConflict(String summary, List<CheckoutConflictItemDto> items) {
    List<CheckoutConflictItemDto> sanitized = items != null ? items : List.of();
    String listed =
        sanitized.stream()
            .limit(3)
            .map(i -> buildItemLabel(i.getCatalogNumber(), i.getArticleName()))
            .collect(Collectors.joining(", "));
    String preview =
        StringUtils.hasText(listed)
            ? " " + listed + (sanitized.size() > 3 ? " (+" + (sanitized.size() - 3) + ")" : "")
            : "";
    CheckoutConflictDetailsDto details =
        CheckoutConflictDetailsDto.builder()
            .code("CHECKOUT_PROVIDER_UNAVAILABLE")
            .action("ADJUST_CART_AND_RETRY")
            .items(sanitized)
            .build();
    throw new CheckoutConflictException(
        summary + preview + ". Izmenite kolicinu ili uklonite stavku pa potvrdite ponovo.",
        details);
  }

  private int toRequestedQuantity(Double quantity) {
    if (quantity == null || !Double.isFinite(quantity)) {
      return 0;
    }
    return (int) Math.ceil(Math.max(0d, quantity));
  }

  private List<FakturaDetaljiDto> extractStockDetailsFromHeader(WebOrderHeader header) {
    if (header == null || header.getItems() == null || header.getItems().isEmpty()) {
      return List.of();
    }
    List<FakturaDetaljiDto> details = new ArrayList<>();
    for (WebOrderItem item : header.getItems()) {
      if (item == null || item.getItemSource() != OrderItemSource.STOCK) {
        continue;
      }
      int quantity = toRequestedQuantity(item.getKolicina());
      if (quantity <= 0) {
        continue;
      }
      FakturaDetaljiDto detail = new FakturaDetaljiDto();
      detail.setRobaId(item.getRobaId());
      detail.setTecDocArticleId(item.getTecDocArticleId());
      detail.setKataloskiBroj(item.getCatalogNumber());
      detail.setNaziv(item.getArticleName());
      detail.setKolicina((double) quantity);
      detail.setPotvrdjenaKolicina(item.getPotvrdjenaKolicina());
      detail.setCena(item.getCena());
      detail.setRabat(item.getRabat());
      detail.setIzvor(OrderItemSource.STOCK.name());
      if (StringUtils.hasText(item.getBrand()) || StringUtils.hasText(item.getBrandName())) {
        detail.setProizvodjac(
            com.automaterijal.application.domain.entity.Proizvodjac.builder()
                .proid(item.getBrand())
                .naziv(item.getBrandName())
                .build());
      }
      if (item.getImageUrl() != null || item.getImageRobaSlika() != null) {
        com.automaterijal.application.domain.dto.SlikaDto image =
            new com.automaterijal.application.domain.dto.SlikaDto();
        image.setSlikeUrl(item.getImageUrl());
        image.setUrl(Boolean.TRUE.equals(item.getImageIsUrl()));
        image.setRobaSlika(item.getImageRobaSlika());
        detail.setSlika(image);
      }
      details.add(detail);
    }
    return details;
  }

  private List<RobaLightDto> extractProviderItemsFromHeader(WebOrderHeader header) {
    if (header == null || header.getItems() == null || header.getItems().isEmpty()) {
      return List.of();
    }
    List<RobaLightDto> out = new ArrayList<>();
    for (WebOrderItem item : header.getItems()) {
      if (item == null || item.getItemSource() != OrderItemSource.PROVIDER) {
        continue;
      }
      if (toRequestedQuantity(item.getKolicina()) <= 0) {
        continue;
      }
      if (item.getRobaId() != null) {
        robaDatabaseService
            .findByRobaId(item.getRobaId())
            .ifPresent(roba -> out.add(robaMapper.map(roba)));
        continue;
      }
      RobaLightDto placeholder = new RobaLightDto();
      placeholder.setRobaid(null);
      placeholder.setTecDocArticleId(item.getTecDocArticleId());
      placeholder.setKatbr(item.getCatalogNumber());
      placeholder.setNaziv(item.getArticleName());
      if (item.getImageUrl() != null || item.getImageRobaSlika() != null) {
        com.automaterijal.application.domain.dto.SlikaDto image =
            new com.automaterijal.application.domain.dto.SlikaDto();
        image.setSlikeUrl(item.getImageUrl());
        image.setUrl(Boolean.TRUE.equals(item.getImageIsUrl()));
        image.setRobaSlika(item.getImageRobaSlika());
        placeholder.setSlika(image);
      }
      if (StringUtils.hasText(item.getBrand()) || StringUtils.hasText(item.getBrandName())) {
        ProizvodjacDTO p = new ProizvodjacDTO();
        p.setProizvodjac(
            com.automaterijal.application.domain.entity.Proizvodjac.builder()
                .proid(item.getBrand())
                .naziv(item.getBrandName())
                .build());
        placeholder.setProizvodjac(p);
      }
      if (item.getProviderKey() != null || item.getProviderArticleNumber() != null) {
        placeholder.setProviderAvailability(
            com.automaterijal.application.domain.dto.ProviderAvailabilityDto.builder()
                .brand(item.getBrand())
                .provider(item.getProviderKey())
                .articleNumber(item.getProviderArticleNumber())
                .available(item.getProviderAvailable())
                .totalQuantity(item.getProviderTotalQuantity())
                .warehouse(item.getProviderWarehouse())
                .warehouseName(item.getProviderWarehouseName())
                .warehouseQuantity(item.getProviderWarehouseQuantity())
                .purchasePrice(item.getProviderPurchasePrice())
                .price(item.getProviderPrice())
                .currency(item.getProviderCurrency())
                .packagingUnit(item.getProviderPackagingUnit())
                .leadTimeBusinessDays(item.getProviderLeadTimeBusinessDays())
                .deliveryToCustomerBusinessDaysMin(item.getProviderDeliveryToCustomerDaysMin())
                .deliveryToCustomerBusinessDaysMax(item.getProviderDeliveryToCustomerDaysMax())
                .nextDispatchCutoff(item.getProviderNextDispatchCutoff())
                .providerProductId(item.getProviderProductId())
                .providerStockToken(item.getProviderStockToken())
                .providerNoReturnable(item.getProviderNoReturnable())
                .coreCharge(item.getProviderCoreCharge())
                .build());
        placeholder.setAvailabilityStatus(
            Boolean.TRUE.equals(item.getProviderAvailable())
                ? com.automaterijal.application.domain.dto.ArticleAvailabilityStatus.AVAILABLE
                : com.automaterijal.application.domain.dto.ArticleAvailabilityStatus.OUT_OF_STOCK);
      }
      placeholder.setCena(item.getCena() != null ? java.math.BigDecimal.valueOf(item.getCena()) : null);
      placeholder.setRabat(item.getRabat());
      out.add(placeholder);
    }
    return out;
  }

  private Map<String, String> resolveProviderDeliveryParties(
      FakturaDto fakturaDto, Partner partner) {
    if (fakturaDto == null || !PartnerPrivilegeUtils.isInternal(partner)) {
      return Map.of();
    }
    List<ProviderOrderOptionDto> options =
        Optional.ofNullable(fakturaDto.getProviderOptions()).orElse(List.of());
    if (options.isEmpty()) {
      return Map.of();
    }
    Map<String, String> resolved = new HashMap<>();
    for (ProviderOrderOptionDto option : options) {
      if (option == null) {
        continue;
      }
      String providerKey = normalizeProviderKey(option.getProviderKey());
      if (!StringUtils.hasText(providerKey)) {
        continue;
      }
      String deliveryParty = option.getDeliveryParty();
      if (!StringUtils.hasText(deliveryParty)) {
        continue;
      }
      resolved.put(providerKey, deliveryParty.trim());
    }
    return resolved;
  }

  private void applyProviderDeliveryParty(
      WebOrderItem item, Map<String, String> providerDeliveryParties) {
    if (item == null || providerDeliveryParties == null || providerDeliveryParties.isEmpty()) {
      return;
    }
    String providerKey = normalizeProviderKey(item.getProviderKey());
    if (!StringUtils.hasText(providerKey)) {
      return;
    }
    String deliveryParty = providerDeliveryParties.get(providerKey);
    if (!StringUtils.hasText(deliveryParty)) {
      return;
    }
    item.setProviderDeliveryParty(deliveryParty.trim());
  }

  private String normalizeProviderKey(String providerKey) {
    if (!StringUtils.hasText(providerKey)) {
      return null;
    }
    return providerKey.trim().toLowerCase(Locale.ROOT);
  }

  private void saveErpStockOrder(
      FakturaDto fakturaDto,
      Partner partner,
      Integer orderId,
      List<FakturaDetaljiDto> stockDetails) {
    FakturaDto erpDto = new FakturaDto();
    erpDto.setNacinPlacanja(fakturaDto.getNacinPlacanja());
    erpDto.setNacinPrevoza(fakturaDto.getNacinPrevoza());
    erpDto.setAdresa(fakturaDto.getAdresa());
    erpDto.setNapomena(fakturaDto.getNapomena());
    erpDto.setDetalji(stockDetails);

    double stockTotalAmount = 0.0;
    for (var dto : stockDetails) {
      if (dto.getCena() != null && dto.getKolicina() != null) {
        stockTotalAmount += dto.getCena() * dto.getKolicina();
      }
    }
    erpDto.setIznosNarucen(stockTotalAmount);

    Faktura faktura = mapper.map(erpDto);
    mapper.popuniFakuturu(faktura, partner, orderId);
    faktura.getDetalji().forEach(fakturaDetaljiRepository::save);
    fakturaRepository.save(faktura);
  }

  @Transactional(readOnly = true)
  public Page<FakturaDto> vratiSveFaktureUlogovanogKorisnika(
      Partner partner,
      Integer page,
      Integer pageSize,
      LocalDateTime vremeOd,
      LocalDateTime vremeDo) {
    return vratiSveFaktureUlogovanogKorisnika(partner, page, pageSize, vremeOd, vremeDo, null);
  }

  @Transactional(readOnly = true)
  public Page<FakturaDto> vratiSveFaktureUlogovanogKorisnika(
      Partner partner,
      Integer page,
      Integer pageSize,
      LocalDateTime vremeOd,
      LocalDateTime vremeDo,
      Boolean internalOrder) {
    var iPage = page == null ? 0 : page;
    var iPageSize = pageSize == null ? 10 : pageSize;
    var limit = Math.max(1, (iPage + 1) * iPageSize);

    var vremeOdTs = GeneralUtil.ldtToTimestamp(vremeOd);
    var vremeDoTs = GeneralUtil.ldtToTimestamp(vremeDo);

    var erpRequest = PageRequest.of(0, limit);
    var webRequest = PageRequest.of(0, limit);

    Page<Faktura> erpPage;
    Page<WebOrderHeader> webPage;
    Set<String> erpMirrorKeys = new HashSet<>();
    boolean internalOnly = Boolean.TRUE.equals(internalOrder);
    boolean externalOnly = Boolean.FALSE.equals(internalOrder);
    if (PartnerPrivilegeUtils.isInternal(partner)) {
      if (internalOnly) {
        erpPage = new PageImpl<>(List.of(), erpRequest, 0);
        webPage =
            webOrderHeaderRepository
                .findByDateSentGreaterThanAndDateSentLessThanAndInternalOrderOrderByDateSentDesc(
                    webRequest, vremeOdTs, vremeDoTs, 1);
      } else {
        erpPage =
            fakturaRepository.findByDataSentGreaterThanAndDataSentLessThanOrderByDataSentDesc(
                erpRequest, vremeOdTs, vremeDoTs);
        if (externalOnly) {
          webPage =
              webOrderHeaderRepository
                  .findByDateSentGreaterThanAndDateSentLessThanAndInternalOrderOrderByDateSentDesc(
                      webRequest, vremeOdTs, vremeDoTs, 0);
        } else {
          webPage =
              webOrderHeaderRepository.findByDateSentGreaterThanAndDateSentLessThanOrderByDateSentDesc(
                  webRequest, vremeOdTs, vremeDoTs);
        }
      }
      for (var h : webPage.getContent()) {
        if (h != null
            && h.getErpExported() != null
            && h.getErpExported() == 1
            && h.getPpid() != null
            && h.getOrderId() != null) {
          erpMirrorKeys.add(h.getPpid() + ":" + h.getOrderId());
        }
      }
    } else {
      erpPage =
          fakturaRepository.findByPpidAndDataSentGreaterThanAndDataSentLessThanOrderByDataSentDesc(
              partner.getPpid(), erpRequest, vremeOdTs, vremeDoTs);
      if (internalOnly) {
        webPage =
            webOrderHeaderRepository
                .findByPpidAndDateSentGreaterThanAndDateSentLessThanAndInternalOrderOrderByDateSentDesc(
                    partner.getPpid(), webRequest, vremeOdTs, vremeDoTs, 1);
      } else if (externalOnly) {
        webPage =
            webOrderHeaderRepository
                .findByPpidAndDateSentGreaterThanAndDateSentLessThanAndInternalOrderOrderByDateSentDesc(
                    partner.getPpid(), webRequest, vremeOdTs, vremeDoTs, 0);
      } else {
        webPage =
            webOrderHeaderRepository
                .findByPpidAndDateSentGreaterThanAndDateSentLessThanOrderByDateSentDesc(
                    partner.getPpid(), webRequest, vremeOdTs, vremeDoTs);
      }
      for (var h : webPage.getContent()) {
        if (h != null
            && h.getErpExported() != null
            && h.getErpExported() == 1
            && h.getPpid() != null
            && h.getOrderId() != null) {
          erpMirrorKeys.add(h.getPpid() + ":" + h.getOrderId());
        }
      }
    }

    record DatedDto(Timestamp dateSent, FakturaDto dto) {}

    List<DatedDto> merged = new ArrayList<>(erpPage.getNumberOfElements() + webPage.getNumberOfElements());
    for (var faktura : erpPage.getContent()) {
      if (faktura != null
          && faktura.getPpid() != null
          && faktura.getOrderId() != null
          && erpMirrorKeys.contains(faktura.getPpid() + ":" + faktura.getOrderId())) {
        continue;
      }
      FakturaDto dto = mapper.map(faktura);
      merged.add(new DatedDto(faktura.getDataSent(), obogatiDto(dto, partner)));
    }
    for (var webOrder : webPage.getContent()) {
      var dto = obogatiWebDto(mapWebOrder(webOrder), partner);
      overrideStatusFromErp(webOrder, dto);
      merged.add(new DatedDto(webOrder.getDateSent(), dto));
    }

    merged.sort(
        (a, b) -> {
          if (a.dateSent() == null && b.dateSent() == null) {
            return 0;
          }
          if (a.dateSent() == null) {
            return 1;
          }
          if (b.dateSent() == null) {
            return -1;
          }
          return b.dateSent().compareTo(a.dateSent());
        });

    var start = iPage * iPageSize;
    var end = Math.min(start + iPageSize, merged.size());
    List<FakturaDto> content =
        start >= merged.size()
            ? List.of()
            : merged.subList(start, end).stream().map(DatedDto::dto).toList();

    long exportedCount;
    if (internalOnly) {
      exportedCount = 0;
    } else if (PartnerPrivilegeUtils.isInternal(partner)) {
      exportedCount =
          externalOnly
              ? webOrderHeaderRepository
                  .countByDateSentGreaterThanAndDateSentLessThanAndErpExportedAndInternalOrder(
                      vremeOdTs, vremeDoTs, 1, 0)
              : webOrderHeaderRepository.countByDateSentGreaterThanAndDateSentLessThanAndErpExported(
                  vremeOdTs, vremeDoTs, 1);
    } else {
      exportedCount =
          externalOnly
              ? webOrderHeaderRepository
                  .countByPpidAndDateSentGreaterThanAndDateSentLessThanAndErpExportedAndInternalOrder(
                      partner.getPpid(), vremeOdTs, vremeDoTs, 1, 0)
              : webOrderHeaderRepository
                  .countByPpidAndDateSentGreaterThanAndDateSentLessThanAndErpExported(
                      partner.getPpid(), vremeOdTs, vremeDoTs, 1);
    }
    long total =
        Math.max(0, erpPage.getTotalElements() + webPage.getTotalElements() - exportedCount);
    return new PageImpl<>(content, PageRequest.of(iPage, iPageSize), total);
  }

  private FakturaDto obogatiDto(FakturaDto fakturaDto, Partner partner) {
    var brojStavki = fakturaDetaljiRepository.findByOrderId(fakturaDto.getId()).size();
    return obogatiDtoCommon(fakturaDto, partner, brojStavki);
  }

  private FakturaDto obogatiWebDto(FakturaDto fakturaDto, Partner partner) {
    var brojStavki =
        fakturaDto.getDetalji() == null ? 0 : fakturaDto.getDetalji().size();
    return obogatiDtoCommon(fakturaDto, partner, brojStavki);
  }

  private FakturaDto obogatiDtoCommon(FakturaDto fakturaDto, Partner partner, int brojStavki) {
    if (fakturaDto.getProviderCall() == null) {
      // Legacy/ERP rows do not carry provider-call metadata; treat as no call.
      fakturaDto.setProviderCall(false);
    }
    if (fakturaDto.getInternalOrder() == null) {
      fakturaDto.setInternalOrder(0);
    }
    if (fakturaDto.getStatus() != null && fakturaDto.getStatus().getId() != null) {
      statusRepository
          .findById(fakturaDto.getStatus().getId())
          .ifPresent(status -> mapper.map(fakturaDto, status));
    }
    if (fakturaDto.getNacinPlacanja() != null && fakturaDto.getNacinPlacanja().getId() != null) {
      nacinPlacanjaRepository
          .findById(fakturaDto.getNacinPlacanja().getId())
          .ifPresent(nacinPlacanja -> mapper.map(fakturaDto, nacinPlacanja));
    }
    if (fakturaDto.getNacinPrevoza() != null && fakturaDto.getNacinPrevoza().getId() != null) {
      nacinPrevozaRepository
          .findById(fakturaDto.getNacinPrevoza().getId())
          .ifPresent(nacinPrevoza -> mapper.map(fakturaDto, nacinPrevoza));
    }
    if (fakturaDto.getAdresa() != null && fakturaDto.getAdresa().getId() != null) {
      mestaIsporukeRepository
          .findById(fakturaDto.getAdresa().getId())
          .ifPresent(adresa -> mapper.map(fakturaDto, adresa));
    }
    fakturaDto.setPartner(
        partnerService
            .pronadjiPartneraPoId(Integer.valueOf(fakturaDto.getPartner()))
            .getMestaIsporuke()
            .getNaziv());
    fakturaDto.setBrojStavki(brojStavki);
    if (fakturaDto.getDetalji() != null && !fakturaDto.getDetalji().isEmpty()) {
      fakturaDto.getDetalji().stream()
          .forEach(fakturaDetaljiDto -> obogatiDetalje(fakturaDetaljiDto, partner));
    }
    formatirajCenuFakture(fakturaDto);
    return fakturaDto;
  }

  private FakturaDto mapWebOrder(WebOrderHeader header) {
    FakturaDto dto = new FakturaDto();
    dto.setId(header.getId() + WEB_ID_OFFSET);
    dto.setOrderId(header.getOrderId());
    dto.setInternalOrder(header.getInternalOrder());
    dto.setVremePorucivanja(header.getDateSent() != null ? header.getDateSent().toString() : null);
    dto.setStatus(vh(header.getStatus()));
    dto.setNacinPlacanja(vh(header.getNuid()));
    dto.setNacinPrevoza(vh(header.getNiid()));
    dto.setAdresa(vh(header.getMestoIsporuke()));
    dto.setNapomena(header.getNapomena());
    dto.setIznosNarucen(header.getIznosNaruceno());
    dto.setIznosPotvrdjen(header.getIznosPotvrdjeno());
    dto.setPartner(String.valueOf(header.getPpid()));
    dto.setProviderCall(ProviderCallResolver.hasProviderCall(header));

    var details =
        Optional.ofNullable(header.getItems()).orElse(List.of()).stream()
            .map(
	                item -> {
	                  FakturaDetaljiDto d = new FakturaDetaljiDto();
                  d.setRobaId(item.getRobaId());
                  d.setTecDocArticleId(item.getTecDocArticleId());
                  d.setKataloskiBroj(item.getCatalogNumber());
                  d.setNaziv(item.getArticleName());
                  if (StringUtils.hasText(item.getBrand()) || StringUtils.hasText(item.getBrandName())) {
                    String brandId = item.getBrand();
                    String brandName = null;
                    if (StringUtils.hasText(brandId)) {
                      var local = proizvodjacService.vratiProizvodjacaPoPk(brandId);
                      if (local.isPresent()) {
                        brandId = local.get().getProid();
                        brandName = local.get().getNaziv();
                      }
                    }
                    if (!StringUtils.hasText(brandName)) {
                      brandName =
                          StringUtils.hasText(item.getBrandName()) ? item.getBrandName() : brandId;
                    }
                    d.setProizvodjac(
                        com.automaterijal.application.domain.entity.Proizvodjac.builder()
                            .proid(brandId)
                            .naziv(brandName)
                            .build());
                  }
                  if (item.getImageUrl() != null || item.getImageRobaSlika() != null) {
                    com.automaterijal.application.domain.dto.SlikaDto s =
                        new com.automaterijal.application.domain.dto.SlikaDto();
                    s.setSlikeUrl(item.getImageUrl());
                    s.setUrl(Boolean.TRUE.equals(item.getImageIsUrl()));
                    s.setRobaSlika(item.getImageRobaSlika());
                    d.setSlika(s);
                  }
                  d.setKolicina(item.getKolicina());
                  d.setPotvrdjenaKolicina(item.getPotvrdjenaKolicina());
                  d.setCena(item.getCena());
                  d.setStatus(vh(item.getStatus()));
                  d.setRabat(item.getRabat());
                  d.setVremePorucivanja(
                      item.getInsertDatetime() != null ? item.getInsertDatetime().toString() : null);
                  d.setIzvor(item.getItemSource() != null ? item.getItemSource().name() : null);

                  if (item.getProviderKey() != null || item.getProviderArticleNumber() != null) {
                    d.setProviderAvailability(
                        com.automaterijal.application.domain.dto.ProviderAvailabilityDto.builder()
                            .brand(item.getBrand())
                            .provider(item.getProviderKey())
                            .articleNumber(item.getProviderArticleNumber())
                            .available(item.getProviderAvailable())
                            .totalQuantity(item.getProviderTotalQuantity())
                            .warehouse(item.getProviderWarehouse())
                            .warehouseName(item.getProviderWarehouseName())
                            .warehouseQuantity(item.getProviderWarehouseQuantity())
                            .purchasePrice(item.getProviderPurchasePrice())
                            .price(item.getProviderPrice())
                            .currency(item.getProviderCurrency())
                            .packagingUnit(item.getProviderPackagingUnit())
                            .leadTimeBusinessDays(item.getProviderLeadTimeBusinessDays())
                            .deliveryToCustomerBusinessDaysMin(item.getProviderDeliveryToCustomerDaysMin())
                            .deliveryToCustomerBusinessDaysMax(item.getProviderDeliveryToCustomerDaysMax())
                            .nextDispatchCutoff(item.getProviderNextDispatchCutoff())
                            .providerProductId(item.getProviderProductId())
                            .providerStockToken(item.getProviderStockToken())
                            .providerNoReturnable(item.getProviderNoReturnable())
                .coreCharge(item.getProviderCoreCharge())
                            .build());
                    d.setAvailabilityStatus(
                        Boolean.TRUE.equals(item.getProviderAvailable())
                            ? com.automaterijal.application.domain.dto.ArticleAvailabilityStatus.AVAILABLE
                            : com.automaterijal.application.domain.dto.ArticleAvailabilityStatus.OUT_OF_STOCK);
                  }
                  d.setProviderBackorder(item.getProviderBackorder());
                  d.setProviderMessage(item.getProviderMessage());
                  d.setProviderDeliveryParty(item.getProviderDeliveryParty());
                  return d;
                })
            .toList();
    dto.setDetalji(details);
    return dto;
  }

  private void overrideStatusFromErp(WebOrderHeader header, FakturaDto dto) {
    if (header == null || dto == null) {
      return;
    }
    if (header.getErpExported() == null || header.getErpExported() != 1) {
      return;
    }
    if (header.getPpid() == null || header.getOrderId() == null) {
      return;
    }
    fakturaRepository
        .findByPpidAndOrderId(header.getPpid(), header.getOrderId())
        .map(Faktura::getStatus)
        .ifPresent(
            erpStatusId -> {
              dto.setStatus(vh(erpStatusId));
              statusRepository.findById(erpStatusId).ifPresent(status -> mapper.map(dto, status));
            });
  }

  private ValueHelpDto vh(Integer id) {
    ValueHelpDto dto = new ValueHelpDto();
    dto.setId(id);
    return dto;
  }

  private void formatirajCenuFakture(FakturaDto fakturaDto) {
    var formater = new DecimalFormat("#.##");
    formater.setRoundingMode(RoundingMode.UP);
    BigDecimal bigDecimal = new BigDecimal(0);
    for (FakturaDetaljiDto dto : fakturaDto.getDetalji()) {
      if (dto.getPotvrdjenaKolicina() > 0) {
        double ukupnaCenaDela = dto.getPotvrdjenaKolicina() * dto.getCena();
        bigDecimal = bigDecimal.add(BigDecimal.valueOf(ukupnaCenaDela));
      }
      dto.setCena(dto.getCena());
    }

    var iznosNarucen = fakturaDto.getIznosNarucen();
    fakturaDto.setIznosNarucen(iznosNarucen);
    fakturaDto.setIznosPotvrdjen(bigDecimal.doubleValue());
  }

  private void obogatiDetalje(FakturaDetaljiDto dto, Partner partner) {
    if (dto.getIzvor() == null) {
      dto.setIzvor(OrderItemSource.STOCK.name());
    }
    if (!PartnerPrivilegeUtils.isInternal(partner)
        && dto.getProviderAvailability() != null) {
      dto.getProviderAvailability().setPurchasePrice(null);
    }
    if (dto.getStatus() != null && dto.getStatus().getId() != null) {
      statusRepository.findById(dto.getStatus().getId()).ifPresent(status -> mapper.map(dto, status));
    }

    // Snapshot behavior: for PROVIDER items keep stored fields (price/image/name/etc).
    if (OrderItemSource.PROVIDER.name().equalsIgnoreCase(dto.getIzvor())) {
      return;
    }

    // External-only stavke nemaju robaId; ostavljamo podatke iz web order-a i preskačemo DB enrichment.
    if (dto.getRobaId() == null) {
      return;
    }
    robaDatabaseService
        .findByRobaId(dto.getRobaId())
        .ifPresent(
            roba -> {
              mapper.map(dto, roba);
              proizvodjacService
                  .vratiProizvodjacaPoPk(roba.getProizvodjac().getProid())
                  .ifPresent(proizvodjac -> mapper.map(dto, proizvodjac));
              dto.setCena(
                  robaCeneService
                      .vratiCenuRobePoRobiId(
                          roba.getRobaid(),
                          roba.getGrupaid(),
                          roba.getProizvodjac().getProid(),
                          partner)
                      .doubleValue());
            });
    setSlikeRobaTabelaDetalji(dto);

    if (dto.getSlika() == null) {
      setSlikeRobaTabelaDetalji(dto);
    }
  }

  private void sanitizeProviderPurchasePrice(List<RobaLightDto> items, Partner partner) {
    if (PartnerPrivilegeUtils.isInternal(partner)) {
      return;
    }
    if (items == null || items.isEmpty()) {
      return;
    }
    for (RobaLightDto dto : items) {
      if (dto == null || dto.getProviderAvailability() == null) {
        continue;
      }
      dto.getProviderAvailability().setPurchasePrice(null);
    }
  }

  private void setSlikeRobaTabelaDetalji(FakturaDetaljiDto fakturaDetaljiDto) {
    if (fakturaDetaljiDto == null || fakturaDetaljiDto.getRobaId() == null) {
      return;
    }
    if (fakturaDetaljiDto.getSlika() != null && fakturaDetaljiDto.getSlika().isUrl()) {
      return;
    }
    String robaSlika =
        fakturaDetaljiDto.getSlika() != null ? fakturaDetaljiDto.getSlika().getRobaSlika() : null;
    String url =
        StringUtils.hasText(robaSlika)
            ? robaSlika
            : fakturaDetaljiDto.getRobaId().toString();
    fakturaDetaljiDto.setSlika(imageService.fetchImageFromFileSystem(url));
  }

  @Transactional(readOnly = true)
  public FakturaDto vratiFakuturuPojedinacno(Partner partner, Integer id) {
    FakturaDto fakturaDto = null;
    if (id != null && id >= WEB_ID_OFFSET) {
      var webId = id - WEB_ID_OFFSET;
      Optional<WebOrderHeader> webOrder;
      if (PartnerPrivilegeUtils.isInternal(partner)) {
        webOrder = webOrderHeaderRepository.findById(webId);
      } else {
        webOrder = webOrderHeaderRepository.findByPpidAndId(partner.getPpid(), webId);
      }
      if (webOrder.isPresent()) {
        fakturaDto = obogatiWebDto(mapWebOrder(webOrder.get()), partner);
        overrideStatusFromErp(webOrder.get(), fakturaDto);
      }
      return fakturaDto;
    }

    Optional<Faktura> faktura;
    if (PartnerPrivilegeUtils.isInternal(partner)) {
      faktura = fakturaRepository.findById(id);
    } else {
      faktura = fakturaRepository.findByPpidAndId(partner.getPpid(), id);
    }
    if (faktura.isPresent()) {
      fakturaDto = faktura.map(mapper::map).map(dto -> obogatiDto(dto, partner)).orElse(null);
    }
    return fakturaDto;
  }

  @Transactional(readOnly = true)
  public Integer vratiPoslednjiIdFakturuKorisnikaPovecan(Integer ppid) {
    Integer orderId = 1;
    Optional<Faktura> faktura = fakturaRepository.findFirstByPpidOrderByOrderIdDesc(ppid);
    if (faktura.isPresent()) {
      orderId = faktura.get().getOrderId();
      ++orderId;
    }
    return orderId;
  }
}
