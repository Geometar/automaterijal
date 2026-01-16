package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.ProviderOrderOptionDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.ValueHelpDto;
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
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.utils.GeneralUtil;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FakturaService {

  private static final int WEB_ID_OFFSET = 1_000_000_000;

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

  public List<RobaLightDto> submitujFakturu(FakturaDto fakturaDto, Partner partner) {
    var now = Timestamp.valueOf(LocalDateTime.now());
    var nextOrderId = getNextOrderId(partner.getPpid());
    boolean internalOrder = PartnerPrivilegeUtils.isInternal(partner);

    List<RobaLightDto> outOfStockItems = new ArrayList<>();
    List<FakturaDetaljiDto> stockDetails = new ArrayList<>();

    for (var detalji : Optional.ofNullable(fakturaDto.getDetalji()).orElse(List.of())) {
      var source = determineItemSource(detalji, internalOrder);
      if (source == OrderItemSource.STOCK) {
        stockDetails.add(detalji);
      } else {
        if (detalji != null && detalji.getRobaId() != null) {
          robaDatabaseService
              .findByRobaId(detalji.getRobaId())
              .ifPresent(roba -> outOfStockItems.add(robaMapper.map(roba)));
        } else if (detalji != null) {
          RobaLightDto placeholder = new RobaLightDto();
          placeholder.setRobaid(null);
          placeholder.setTecDocArticleId(detalji.getTecDocArticleId());
          placeholder.setKatbr(detalji.getKataloskiBroj());
          placeholder.setNaziv(detalji.getNaziv());
          placeholder.setSlika(detalji.getSlika());
          placeholder.setProviderAvailability(detalji.getProviderAvailability());
          placeholder.setAvailabilityStatus(detalji.getAvailabilityStatus());
          placeholder.setCena(
              detalji.getCena() != null ? java.math.BigDecimal.valueOf(detalji.getCena()) : null);
          placeholder.setRabat(detalji.getRabat());
          if (detalji.getProizvodjac() != null) {
            ProizvodjacDTO p = new ProizvodjacDTO();
            p.setProizvodjac(detalji.getProizvodjac());
            placeholder.setProizvodjac(p);
          }
          outOfStockItems.add(placeholder);
        }
      }
    }

    WebOrderHeader webOrderHeader =
        saveWebOrder(fakturaDto, partner, nextOrderId, now, internalOrder);

    if (!stockDetails.isEmpty() && !internalOrder) {
      saveErpStockOrder(fakturaDto, partner, nextOrderId, stockDetails);
      webOrderHeader.setErpExported(1);
    }

    providerOrderService.placeOrders(webOrderHeader, partner);

    partnerService.povecanPartnerovOrderCount(partner);
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

  private OrderItemSource determineItemSource(
      FakturaDetaljiDto detalji, boolean forceProvider) {
    if (forceProvider) {
      return OrderItemSource.PROVIDER;
    }
    if (detalji == null || detalji.getRobaId() == null) {
      return OrderItemSource.PROVIDER;
    }
    Optional<Roba> robaOptional = robaDatabaseService.findByRobaId(detalji.getRobaId());
    if (robaOptional.isEmpty()) {
      return OrderItemSource.PROVIDER;
    }
    Roba roba = robaOptional.get();
    if (detalji.getKolicina() == null) {
      return OrderItemSource.PROVIDER;
    }
    return roba.getStanje() >= detalji.getKolicina()
        ? OrderItemSource.STOCK
        : OrderItemSource.PROVIDER;
  }

  private WebOrderHeader saveWebOrder(
      FakturaDto fakturaDto,
      Partner partner,
      Integer orderId,
      Timestamp now,
      boolean forceProvider) {
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

    Map<String, String> providerDeliveryParties =
        resolveProviderDeliveryParties(fakturaDto, partner);
    var orderDetails = Optional.ofNullable(fakturaDto.getDetalji()).orElse(List.of());
    List<WebOrderItem> items =
        orderDetails.stream()
            .map(
                detalji -> {
                  var source = determineItemSource(detalji, forceProvider);
                  WebOrderItem item = new WebOrderItem();
                  item.setHeader(header);
                  item.setPpid(partner.getPpid());
                  item.setRobaId(detalji.getRobaId());
                  item.setTecDocArticleId(detalji.getTecDocArticleId());
                  item.setBrand(
                      detalji.getProizvodjac() != null ? detalji.getProizvodjac().getProid() : null);
                  item.setBrandName(
                      detalji.getProizvodjac() != null ? detalji.getProizvodjac().getNaziv() : null);
                  item.setCatalogNumber(detalji.getKataloskiBroj());
                  item.setArticleName(detalji.getNaziv());
                  item.setMagacinId(source == OrderItemSource.STOCK ? 1 : 0);
                  item.setKolicina(detalji.getKolicina());
                  item.setPotvrdjenaKolicina(0.0);
                  item.setCena(detalji.getCena() != null ? detalji.getCena() : 0.0);
                  item.setStatus(StatusiKonstante.NIJE_UZETA_U_OBRADU.getFieldValue());
                  item.setKolicine(1);
                  item.setRabat(detalji.getRabat() != null ? detalji.getRabat() : 0.0);
                  item.setPdv(20.0);
                  item.setInsertDatetime(now);
                  item.setItemSource(source);
                  item.setProviderCode(source == OrderItemSource.PROVIDER ? "EXTERNAL" : null);

                  if (detalji.getProviderAvailability() != null) {
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
                    item.setProviderLeadTimeBusinessDays(a.getLeadTimeBusinessDays());
                    item.setProviderDeliveryToCustomerDaysMin(a.getDeliveryToCustomerBusinessDaysMin());
                    item.setProviderDeliveryToCustomerDaysMax(a.getDeliveryToCustomerBusinessDaysMax());
                    item.setProviderNextDispatchCutoff(a.getNextDispatchCutoff());
                  }
                  applyProviderDeliveryParty(item, providerDeliveryParties);

                  if (detalji.getSlika() != null) {
                    item.setImageUrl(detalji.getSlika().getSlikeUrl());
                    item.setImageIsUrl(detalji.getSlika().isUrl());
                    item.setImageRobaSlika(detalji.getSlika().getRobaSlika());
                  }
                  return item;
                })
            .collect(Collectors.toCollection(ArrayList::new));

    header.setItems(items);
    return webOrderHeaderRepository.save(header);
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
      merged.add(new DatedDto(webOrder.getDateSent(), obogatiWebDto(mapWebOrder(webOrder), partner)));
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
                            .leadTimeBusinessDays(item.getProviderLeadTimeBusinessDays())
                            .deliveryToCustomerBusinessDaysMin(item.getProviderDeliveryToCustomerDaysMin())
                            .deliveryToCustomerBusinessDaysMax(item.getProviderDeliveryToCustomerDaysMax())
                            .nextDispatchCutoff(item.getProviderNextDispatchCutoff())
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
