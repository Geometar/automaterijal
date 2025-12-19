package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.tecdoc.TecDocGenericArticleMappingService;
import com.automaterijal.application.services.tecdoc.TecDocPreviewService;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.GenericArticleRecord;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExternalOfferService {

  private static final int MAX_EXTERNAL_OFFERS = 50;
  private static final int TECDOC_NUMBER_TYPE_ALL = 10;
  private static final int TECDOC_ARTICLE_ID_RESOLVE_DEFAULT_LIMIT = 10;
  private static final int TECDOC_ARTICLE_ID_RESOLVE_MAX_LIMIT = 25;
  private static final int TECDOC_ARTICLE_ID_CACHE_MAX_SIZE = 5_000;
  private static final long TECDOC_ARTICLE_ID_CACHE_TTL_MS = 6 * 60 * 60 * 1000L;

  @NonNull ExternalAvailabilityService externalAvailabilityService;
  @NonNull TecDocGenericArticleMappingService mappingService;
  @NonNull ArticleSubGroupService articleSubGroupService;
  @NonNull ArticleGroupService articleGroupService;
  @NonNull TecDocPreviewService tecDocPreviewService;
  @NonNull ProviderBrandResolver providerBrandResolver;
  @NonNull TecDocService tecDocService;

  Map<String, TecDocArticleIdCacheEntry> tecDocArticleIdCache =
      Collections.synchronizedMap(
          new LinkedHashMap<>(128, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, TecDocArticleIdCacheEntry> eldest) {
              return size() > TECDOC_ARTICLE_ID_CACHE_MAX_SIZE;
            }
          });

  public List<RobaLightDto> buildFromTecDocSearch(
      List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocRecords,
      MagacinDto localResults,
      Partner partner,
      UniverzalniParametri parametri) {
    ProviderRoutingContext context = buildContext(partner);
    List<Candidate> candidates = mapTecDocSearchCandidates(tecDocRecords, context);
    return buildExternalOffers(candidates, localResults, partner, parametri);
  }

  public List<RobaLightDto> buildFromAssociatedTecDocArticles(
      List<ArticleRecord> articles,
      MagacinDto localResults,
      Partner partner,
      UniverzalniParametri parametri) {
    ProviderRoutingContext context = buildContext(partner);
    List<Candidate> candidates = mapAssociatedArticleCandidates(articles, context);
    return buildExternalOffers(candidates, localResults, partner, parametri);
  }

  private List<RobaLightDto> buildExternalOffers(
      List<Candidate> candidates,
      MagacinDto localResults,
      Partner partner,
      UniverzalniParametri parametri) {
    if (candidates == null || candidates.isEmpty()) {
      return List.of();
    }

    Set<String> localCatalogKeys =
        collectLocalCatalogKeys(localResults != null ? localResults.getRobaDto() : null);

    String wanted = parametri != null ? normalizeCatalog(parametri.getTrazenaRec()) : "";

    List<Candidate> prioritized = new ArrayList<>();
    List<Candidate> missing = new ArrayList<>();
    Set<String> seen = new HashSet<>();
    for (Candidate candidate : candidates) {
      if (candidate == null
          || !StringUtils.hasText(candidate.brand())
          || !StringUtils.hasText(candidate.providerArticleNumber())) {
        continue;
      }
      String brand = candidate.brand().trim().toUpperCase(Locale.ROOT);
      String providerKey = buildBrandKey(brand, candidate.providerArticleNumber());
      String localKey = buildBrandKey(brand, candidate.localCatalogKey());
      if (localCatalogKeys.contains(providerKey) || localCatalogKeys.contains(localKey)) {
        continue;
      }
      String key = candidate.brand() + ":" + candidate.providerArticleNumber();
      if (!seen.add(key)) {
        continue;
      }

      if (StringUtils.hasText(wanted)
          && normalizeCatalog(candidate.providerArticleNumber()).equalsIgnoreCase(wanted)) {
        prioritized.add(candidate);
        continue;
      }

      missing.add(candidate);
    }

    if (!prioritized.isEmpty()) {
      prioritized.addAll(missing);
      missing = prioritized;
    }

    if (missing.size() > MAX_EXTERNAL_OFFERS) {
      missing = missing.subList(0, MAX_EXTERNAL_OFFERS);
    }

    if (missing.isEmpty()) {
      return List.of();
    }

    List<Long> genericIds =
        missing.stream().map(Candidate::genericArticleId).filter(Objects::nonNull).distinct().toList();
    Map<Long, Integer> mappedPodgrupeByGeneric = mappingService.resolvePodgrupaIds(genericIds);
    Map<Long, InternalCategory> internalByGeneric =
        buildInternalCategories(mappedPodgrupeByGeneric);

    Map<String, List<RobaLightDto>> probesByBrand = new HashMap<>();
    Map<String, Candidate> candidateByProbeKey = new HashMap<>();

    List<Long> articleIds =
        missing.stream().map(Candidate::tecDocArticleId).filter(Objects::nonNull).distinct().toList();
    Map<Long, TecDocPreviewService.TecDocPreview> previewByArticleId =
        articleIds.isEmpty() ? Map.of() : tecDocPreviewService.previewsByArticleId(articleIds);

    int tecDocResolveRemaining = resolveTecDocArticleIdLimit(parametri);

    for (Candidate candidate : missing) {
      if (candidate.genericArticleId() != null) {
        mappingService.touch(candidate.genericArticleId(), candidate.category());
      }

      String brand = candidate.brand();
      String article = candidate.providerArticleNumber();
      String probeKey = brand + ":" + normalizeCatalog(article);

      RobaLightDto probe = new RobaLightDto();
      probe.setKatbr(article);
      probe.setKatbrpro(null);
      probe.setStanje(0);

      probe.setProizvodjac(buildManufacturer(candidate));

      probesByBrand.computeIfAbsent(brand, ignored -> new ArrayList<>()).add(probe);
      candidateByProbeKey.put(probeKey, candidate);
    }

    List<RobaLightDto> offers = new ArrayList<>();

    for (Map.Entry<String, List<RobaLightDto>> entry : probesByBrand.entrySet()) {
      List<RobaLightDto> probes = entry.getValue();
      if (probes == null || probes.isEmpty()) {
        continue;
      }

      externalAvailabilityService.populateExternalAvailability(probes, partner);

      for (RobaLightDto probe : probes) {
        if (probe == null || probe.getProviderAvailability() == null) {
          continue;
        }
        if (!Boolean.TRUE.equals(probe.getProviderAvailability().getAvailable())) {
          continue;
        }

        String probeKey = entry.getKey() + ":" + normalizeCatalog(probe.getKatbr());
        Candidate candidate = candidateByProbeKey.get(probeKey);
        if (candidate == null) {
          continue;
        }

        InternalCategory internal =
            candidate.genericArticleId() != null
                ? internalByGeneric.getOrDefault(candidate.genericArticleId(), fallbackCategory())
                : fallbackCategory();
        if (parametri != null && !matchesFilters(internal, candidate, parametri)) {
          continue;
        }

        TecDocPreviewService.TecDocPreview preview =
            candidate.tecDocArticle() != null
                ? tecDocPreviewService.fromArticleRecord(candidate.tecDocArticle())
                : (candidate.tecDocArticleId() != null
                    ? previewByArticleId.get(candidate.tecDocArticleId())
                    : null);

        Long tecDocArticleId = candidate.tecDocArticleId();
        if (tecDocArticleId == null && tecDocResolveRemaining > 0) {
          ResolvedTecDocArticleId resolved = resolveTecDocArticleId(candidate);
          tecDocArticleId = resolved.articleId();
          if (resolved.fetchedFromTecDoc()) {
            tecDocResolveRemaining--;
          }
        }

        RobaLightDto dto = new RobaLightDto();
        dto.setRobaid(null);
        dto.setTecDocArticleId(tecDocArticleId);
        dto.setKatbr(candidate.providerArticleNumber());
        dto.setKatbrpro(null);
        dto.setNaziv(candidate.articleName());

        dto.setProizvodjac(buildManufacturer(candidate));

        dto.setSlika(preview != null ? preview.slika() : null);
        dto.setTehnickiOpis(preview != null ? preview.tehnickiOpis() : null);

        dto.setStanje(0);
        dto.setProviderAvailability(probe.getProviderAvailability());
        dto.setAvailabilityStatus(ArticleAvailabilityStatus.AVAILABLE);
        if (probe.getProviderAvailability() != null) {
          dto.setCena(probe.getProviderAvailability().getPrice());
        }

        dto.setGrupa(internal.groupId());
        dto.setGrupaNaziv(internal.groupName());
        dto.setPodGrupa(internal.subGroupId() != null ? internal.subGroupId() : 0);
        dto.setPodGrupaNaziv(internal.subGroupName());

        offers.add(dto);
      }
    }

    return offers;
  }

  private int resolveTecDocArticleIdLimit(UniverzalniParametri parametri) {
    Integer requested = parametri != null ? parametri.getPageSize() : null;
    int limit =
        requested != null && requested > 0 ? requested : TECDOC_ARTICLE_ID_RESOLVE_DEFAULT_LIMIT;
    return Math.min(Math.max(0, limit), TECDOC_ARTICLE_ID_RESOLVE_MAX_LIMIT);
  }

  private record TecDocArticleIdCacheEntry(Long articleId, long expiresAtMs) {}

  private record ResolvedTecDocArticleId(Long articleId, boolean fetchedFromTecDoc) {}

  private ResolvedTecDocArticleId resolveTecDocArticleId(Candidate candidate) {
    if (candidate == null
        || candidate.tecDocBrandId() == null
        || !StringUtils.hasText(candidate.providerArticleNumber())) {
      return new ResolvedTecDocArticleId(null, false);
    }

    String key =
        candidate.tecDocBrandId()
            + ":"
            + normalizeCatalog(candidate.providerArticleNumber());

    long now = System.currentTimeMillis();
    TecDocArticleIdCacheEntry cached = tecDocArticleIdCache.get(key);
    if (cached != null) {
      if (cached.expiresAtMs() >= now) {
        return new ResolvedTecDocArticleId(cached.articleId(), false);
      }
      tecDocArticleIdCache.remove(key);
    }

    Long resolved = null;
    try {
      List<ArticleDirectSearchAllNumbersWithStateRecord> results =
          tecDocService.tecDocPretragaPoTrazenojReci(
              candidate.providerArticleNumber(), candidate.tecDocBrandId(), TECDOC_NUMBER_TYPE_ALL);
      if (results != null && !results.isEmpty()) {
        resolved =
            results.stream()
                .filter(Objects::nonNull)
                .filter(r -> r.getBrandNo() != null && r.getBrandNo().equals(candidate.tecDocBrandId()))
                .filter(r -> StringUtils.hasText(r.getArticleNo()))
                .filter(
                    r ->
                        CatalogNumberUtils.equalsWhenCleaned(
                            r.getArticleNo(), candidate.providerArticleNumber()))
                .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
      }
    } catch (Exception ignore) {
      resolved = null;
    }

    tecDocArticleIdCache.put(key, new TecDocArticleIdCacheEntry(resolved, now + TECDOC_ARTICLE_ID_CACHE_TTL_MS));
    return new ResolvedTecDocArticleId(resolved, true);
  }

  private Map<Long, InternalCategory> buildInternalCategories(Map<Long, Integer> mappedPodgrupeByGeneric) {
    if (mappedPodgrupeByGeneric == null || mappedPodgrupeByGeneric.isEmpty()) {
      return Map.of();
    }

    Set<Integer> podgrupaIds =
        mappedPodgrupeByGeneric.values().stream()
            .filter(Objects::nonNull)
            .filter(id -> id != 0)
            .collect(java.util.stream.Collectors.toSet());

    Map<Integer, PodgrupaDto> podgrupe = articleSubGroupService.loadPodgrupeWithGrupa(podgrupaIds);
    Map<String, String> groupNames = articleGroupService.groupNamesById();

    Map<Long, InternalCategory> internalByGeneric = new HashMap<>();
    for (Map.Entry<Long, Integer> entry : mappedPodgrupeByGeneric.entrySet()) {
      Long genericId = entry.getKey();
      Integer podgrupaId = entry.getValue();
      if (genericId == null || podgrupaId == null || podgrupaId == 0) {
        continue;
      }

      PodgrupaDto dto = podgrupe.get(podgrupaId);
      if (dto == null || !StringUtils.hasText(dto.getGrupa())) {
        continue;
      }

      String groupId = dto.getGrupa();
      String mappedName = groupNames.get(groupId);
      String groupName = StringUtils.hasText(mappedName) ? mappedName : groupId;
      internalByGeneric.putIfAbsent(
          genericId, new InternalCategory(groupId, groupName, podgrupaId, dto.getNaziv()));
    }

    return internalByGeneric;
  }

  private boolean matchesFilters(
      InternalCategory category, Candidate candidate, UniverzalniParametri parametri) {
    if (parametri == null) {
      return true;
    }
    if (parametri.getMandatoryProid() != null && !parametri.getMandatoryProid().isEmpty()) {
      if (candidate.brand() == null
          || !parametri.getMandatoryProid().contains(candidate.brand().toUpperCase(Locale.ROOT))) {
        return false;
      }
    }
    if (parametri.getProizvodjac() != null && !parametri.getProizvodjac().isEmpty()) {
      if (candidate.brand() == null
          || !parametri.getProizvodjac().contains(candidate.brand().toUpperCase(Locale.ROOT))) {
        return false;
      }
    }
    if (parametri.getGrupa() != null && !parametri.getGrupa().isEmpty()) {
      if (category == null || category.groupId() == null || !parametri.getGrupa().contains(category.groupId())) {
        return false;
      }
    }
    if (parametri.getPodgrupeZaPretragu() != null && !parametri.getPodgrupeZaPretragu().isEmpty()) {
      if (category == null || category.subGroupId() == null || !parametri.getPodgrupeZaPretragu().contains(category.subGroupId())) {
        return false;
      }
    }
    return true;
  }

  private InternalCategory fallbackCategory() {
    return new InternalCategory(
        ArticleSubGroupService.ANONIMNA_GRUPA,
        ArticleSubGroupService.ANONIMNA_GRUPA,
        0,
        ArticleSubGroupService.ANONIMNA_GRUPA);
  }

  private record InternalCategory(
      String groupId, String groupName, Integer subGroupId, String subGroupName) {}

  private List<Candidate> mapTecDocSearchCandidates(
      List<ArticleDirectSearchAllNumbersWithStateRecord> records, ProviderRoutingContext context) {
    if (records == null || records.isEmpty()) {
      return List.of();
    }

    List<Candidate> candidates = new ArrayList<>();

    for (ArticleDirectSearchAllNumbersWithStateRecord record : records) {
      if (record == null
          || !StringUtils.hasText(record.getArticleNo())
          || record.getBrandNo() == null) {
        continue;
      }

      String brand =
          providerBrandResolver
              .resolveInventoryBrand(record.getBrandNo(), record.getBrandName(), context)
              .orElse(null);
      if (!StringUtils.hasText(brand)) {
        continue;
      }
      String providerArticle = normalizeCatalog(record.getArticleNo());
      if (!StringUtils.hasText(providerArticle)) {
        continue;
      }

      String localKey =
          normalizeCatalog(
              TecDocProizvodjaci.generateAlternativeCatalogNumber(
                  providerArticle, record.getBrandNo()));

      candidates.add(
          new Candidate(
              brand,
              record.getBrandName(),
              providerArticle,
              localKey,
              record.getArticleName(),
              record.getArticleId(),
              record.getBrandNo(),
              record.getGenericArticleId(),
              record.getCategory(),
              null));
    }

    return candidates;
  }

  private List<Candidate> mapAssociatedArticleCandidates(
      List<ArticleRecord> articles, ProviderRoutingContext context) {
    if (articles == null || articles.isEmpty()) {
      return List.of();
    }

    List<Candidate> candidates = new ArrayList<>();

    for (ArticleRecord article : articles) {
      if (article == null || !StringUtils.hasText(article.getArticleNumber())) {
        continue;
      }

      String brand =
          providerBrandResolver
              .resolveInventoryBrand(article.getDataSupplierId(), article.getMfrName(), context)
              .orElse(null);
      if (!StringUtils.hasText(brand)) {
        continue;
      }
      String providerArticle = normalizeCatalog(article.getArticleNumber());
      if (!StringUtils.hasText(providerArticle)) {
        continue;
      }

      String localKey =
          normalizeCatalog(
              TecDocProizvodjaci.generateAlternativeCatalogNumber(
                  providerArticle, article.getDataSupplierId()));

      GenericArticleRecord generic =
          article.getGenericArticles() != null && !article.getGenericArticles().isEmpty()
              ? article.getGenericArticles().get(0)
              : null;

      candidates.add(
          new Candidate(
              brand,
              article.getMfrName(),
              providerArticle,
              localKey,
              generic != null ? generic.getGenericArticleDescription() : null,
              null,
              article.getDataSupplierId(),
              generic != null ? (long) generic.getGenericArticleId() : null,
              generic != null ? generic.getGenericArticleDescription() : null,
              article));
    }

    return candidates;
  }

  private Set<String> collectLocalCatalogKeys(Page<RobaLightDto> robaPage) {
    if (robaPage == null || robaPage.isEmpty()) {
      return Set.of();
    }

    Set<String> keys = new HashSet<>();
    for (RobaLightDto dto : robaPage.getContent()) {
      if (dto == null) {
        continue;
      }
      String brand =
          dto.getProizvodjac() != null && StringUtils.hasText(dto.getProizvodjac().getProid())
              ? dto.getProizvodjac().getProid().trim().toUpperCase(Locale.ROOT)
              : null;
      if (!StringUtils.hasText(brand)) {
        continue;
      }
      addIfPresent(keys, brand, dto.getKatbr());
      addIfPresent(keys, brand, dto.getKatbrpro());
    }
    return keys;
  }

  private void addIfPresent(Set<String> set, String brand, String value) {
    String normalized = normalizeCatalog(value);
    if (StringUtils.hasText(normalized)) {
      set.add(buildBrandKey(brand, normalized));
    }
  }

  private String buildBrandKey(String brand, String value) {
    if (!StringUtils.hasText(brand)) {
      return "";
    }
    String normalized = normalizeCatalog(value);
    return StringUtils.hasText(normalized)
        ? brand.trim().toUpperCase(Locale.ROOT) + ":" + normalized
        : "";
  }

  private String normalizeCatalog(String value) {
    return StringUtils.hasText(value)
        ? CatalogNumberUtils.cleanPreserveSeparators(value.trim())
        : "";
  }

  private ProizvodjacDTO buildManufacturer(Candidate candidate) {
    ProizvodjacDTO p = new ProizvodjacDTO();
    String proid =
        candidate != null && StringUtils.hasText(candidate.brand())
            ? candidate.brand().trim().toUpperCase(Locale.ROOT)
            : null;
    p.setProid(proid);
    p.setNaziv(
        candidate != null && StringUtils.hasText(candidate.brandName())
            ? candidate.brandName().trim()
            : proid);

    return p;
  }

  private ProviderRoutingContext buildContext(Partner partner) {
    return ProviderRoutingContext.builder()
        .partnerId(partner != null ? partner.getPpid() : null)
        .partnerAudit(partner != null ? partner.getAudit() : null)
        .purpose(ProviderRoutingPurpose.EXTERNAL_OFFER)
        .localAvailableCount(0)
        .localMatchCount(0)
        .build();
  }

  private record Candidate(
      String brand,
      String brandName,
      String providerArticleNumber,
      String localCatalogKey,
      String articleName,
      Long tecDocArticleId,
      Long tecDocBrandId,
      Long genericArticleId,
      String category,
      ArticleRecord tecDocArticle) {}
}
