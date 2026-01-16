package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.repository.tecdoc.TecDocGenericArticleMappingRepository;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocGenericArticleMapping;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.ArticleRefRecord;
import com.automaterijal.application.tecdoc.GenericArticleRecord;
import com.automaterijal.application.tecdoc.TradeNumberDetailsRecord;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Servis za mapiranje TecDoc {@code genericArticleId -> interna podgrupaId}.
 *
 * <p>Zašto postoji: external-only artikli (dobavljivi kod providera, ali nisu u našoj bazi) nemaju
 * {@code robaId} i nemaju naše interne kategorije. Da bi FE imao jedan jedinstven filter (grupa/podgrupa),
 * održavamo mapu iz TecDoc generičke kategorije (generic article) u internu {@code podgrupaId}.
 *
 * <p>Kako se tabela puni:
 *
 * <ul>
 *   <li><b>Auto-observation</b> (dokaz kroz lokalnu robu): kada u istom rezultatu imamo TecDoc artikal sa
 *       {@code genericArticleId} i lokalni artikal koji se poklapa po proizvođaču/broju i ima internu
 *       {@code podGrupa != 0}, pozivamo {@link #observe(Long, String, Integer)} i mapu postavljamo na {@code ACTIVE}.
 *       Ovo se radi iz oba flow-a:
 *       <ul>
 *         <li>pretraga po vozilu: {@link #observeFromAssociatedArticles(List, List)}
 *         <li>pretraga po searchTerm-u: {@link #observeFromDirectSearch(List, List)}
 *       </ul>
 *   <li><b>Touch</b> (videli smo genericId, ali još nemamo mapu): {@link #touch(Long, String)} upsertuje red kao
 *       {@code PENDING} i povećava {@code confidence_count}, da bismo kasnije mogli ručno popuniti najčešće slučajeve.
 *   <li><b>Ručno</b>: kada se ručno upiše mapiranje ({@code source=MANUAL}), automatsko mapiranje ga ne pregazi.
 * </ul>
 *
 * <p>Statusi:
 * <ul>
 *   <li>{@code ACTIVE} – koristi se za kategorizaciju (external-only dobija internu podgrupu/grupu).
 *   <li>{@code PENDING} – viđen, ali bez pouzdane interne podgrupe (fallback je {@code OSTALO}).
 *   <li>{@code CONFLICT} – primećeno više različitih podgrupa za isti genericId (zahteva ručnu odluku).
 * </ul>
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TecDocGenericArticleMappingService {

  @NonNull TecDocGenericArticleMappingRepository repository;

  public Optional<Integer> resolvePodgrupaId(Long genericArticleId) {
    if (genericArticleId == null) {
      return Optional.empty();
    }
    return repository
        .findByGenericArticleId(genericArticleId)
        .filter(m -> m.getPodgrupaId() != null)
        .filter(m -> m.getStatus() == TecDocGenericArticleMapping.Status.ACTIVE)
        .map(TecDocGenericArticleMapping::getPodgrupaId);
  }

  public Map<Long, Integer> resolvePodgrupaIds(List<Long> genericArticleIds) {
    if (genericArticleIds == null || genericArticleIds.isEmpty()) {
      return Map.of();
    }

    List<Long> ids = genericArticleIds.stream().filter(Objects::nonNull).distinct().toList();
    if (ids.isEmpty()) {
      return Map.of();
    }

    Map<Long, Integer> resolved = new HashMap<>();
    for (TecDocGenericArticleMapping mapping : repository.findAllByGenericArticleIdIn(ids)) {
      if (mapping == null
          || mapping.getGenericArticleId() == null
          || mapping.getPodgrupaId() == null
          || mapping.getStatus() != TecDocGenericArticleMapping.Status.ACTIVE) {
        continue;
      }
      resolved.putIfAbsent(mapping.getGenericArticleId(), mapping.getPodgrupaId());
    }
    return resolved;
  }

  @Transactional
  public void touch(Long genericArticleId, String tecdocCategoryName) {
    if (genericArticleId == null) {
      return;
    }
    TecDocGenericArticleMapping mapping =
        repository.findByGenericArticleId(genericArticleId).orElseGet(() -> {
          TecDocGenericArticleMapping created = new TecDocGenericArticleMapping();
          created.setGenericArticleId(genericArticleId);
          created.setStatus(TecDocGenericArticleMapping.Status.PENDING);
          created.setSource(TecDocGenericArticleMapping.Source.AUTO);
          created.setConfidenceCount(0);
          return created;
        });

    mapping.setLastSeenAt(LocalDateTime.now());
    if (StringUtils.hasText(tecdocCategoryName)) {
      mapping.setTecdocCategoryName(tecdocCategoryName.trim());
    }
    mapping.setConfidenceCount(
        mapping.getConfidenceCount() != null ? mapping.getConfidenceCount() + 1 : 1);
    repository.save(mapping);
  }

  @Transactional
  public void observe(Long genericArticleId, String tecdocCategoryName, Integer podgrupaId) {
    if (genericArticleId == null || podgrupaId == null || podgrupaId == 0) {
      touch(genericArticleId, tecdocCategoryName);
      return;
    }

    TecDocGenericArticleMapping mapping =
        repository.findByGenericArticleId(genericArticleId).orElseGet(() -> {
          TecDocGenericArticleMapping created = new TecDocGenericArticleMapping();
          created.setGenericArticleId(genericArticleId);
          created.setStatus(TecDocGenericArticleMapping.Status.PENDING);
          created.setSource(TecDocGenericArticleMapping.Source.AUTO);
          created.setConfidenceCount(0);
          return created;
        });

    mapping.setLastSeenAt(LocalDateTime.now());
    if (StringUtils.hasText(tecdocCategoryName)) {
      mapping.setTecdocCategoryName(tecdocCategoryName.trim());
    }

    if (mapping.getSource() == TecDocGenericArticleMapping.Source.MANUAL
        && mapping.getPodgrupaId() != null
        && mapping.getPodgrupaId() != 0) {
      mapping.setConfidenceCount(
          mapping.getConfidenceCount() != null ? mapping.getConfidenceCount() + 1 : 1);
      repository.save(mapping);
      return;
    }

    Integer existing = mapping.getPodgrupaId();
    if (existing == null) {
      mapping.setPodgrupaId(podgrupaId);
      mapping.setStatus(TecDocGenericArticleMapping.Status.ACTIVE);
    } else if (existing.equals(podgrupaId)) {
      mapping.setStatus(TecDocGenericArticleMapping.Status.ACTIVE);
    } else {
      mapping.setStatus(TecDocGenericArticleMapping.Status.CONFLICT);
    }

    mapping.setConfidenceCount(
        mapping.getConfidenceCount() != null ? mapping.getConfidenceCount() + 1 : 1);
    repository.save(mapping);
  }

  @Transactional
  public void observeFromAssociatedArticles(List<ArticleRecord> articles, List<RobaLightDto> local) {
    if (articles == null || articles.isEmpty() || local == null || local.isEmpty()) {
      return;
    }

    Map<String, GenericInfo> index = buildGenericIndex(articles);
    if (index.isEmpty()) {
      return;
    }

    for (RobaLightDto dto : local) {
      if (dto == null || dto.getProizvodjac() == null || !StringUtils.hasText(dto.getProizvodjac().getProid())) {
        continue;
      }
      int podgrupaId = dto.getPodGrupa();
      if (podgrupaId == 0) {
        continue;
      }

      TecDocProizvodjaci manufacturer =
          TecDocProizvodjaci.findByName(dto.getProizvodjac().getProid().trim().toUpperCase(Locale.ROOT));

      GenericInfo info = find(index, manufacturer, dto.getKatbr());
      if (info == null) {
        info = find(index, manufacturer, dto.getKatbrpro());
      }
      if (info == null) {
        continue;
      }

      observe(info.genericArticleId(), info.categoryName(), podgrupaId);
    }
  }

  @Transactional
  public void observeFromDirectSearch(
      List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocRecords, List<RobaLightDto> local) {
    if (tecDocRecords == null
        || tecDocRecords.isEmpty()
        || local == null
        || local.isEmpty()) {
      return;
    }

    Map<String, GenericInfo> index = buildGenericIndexFromDirectSearch(tecDocRecords);
    if (index.isEmpty()) {
      return;
    }

    for (RobaLightDto dto : local) {
      if (dto == null
          || dto.getProizvodjac() == null
          || !StringUtils.hasText(dto.getProizvodjac().getProid())) {
        continue;
      }

      int podgrupaId = dto.getPodGrupa();
      if (podgrupaId == 0) {
        continue;
      }

      TecDocProizvodjaci manufacturer =
          TecDocProizvodjaci.findByName(
              dto.getProizvodjac().getProid().trim().toUpperCase(Locale.ROOT));

      GenericInfo info = find(index, manufacturer, dto.getKatbr());
      if (info == null) {
        info = find(index, manufacturer, dto.getKatbrpro());
      }
      if (info == null) {
        continue;
      }

      observe(info.genericArticleId(), info.categoryName(), podgrupaId);
    }
  }

  private GenericInfo find(Map<String, GenericInfo> index, TecDocProizvodjaci manufacturer, String number) {
    String cleaned = CatalogNumberUtils.cleanPreserveSeparators(number);
    if (!StringUtils.hasText(cleaned)) {
      return null;
    }

    if (manufacturer != null) {
      GenericInfo byMan = index.get(buildKey(manufacturer.getCleanName(), cleaned));
      if (byMan != null) {
        return byMan;
      }
    }

    return index.get(cleaned);
  }

  private Map<String, GenericInfo> buildGenericIndex(List<ArticleRecord> articles) {
    Map<String, GenericInfo> index = new HashMap<>();

    for (ArticleRecord article : articles.stream().filter(Objects::nonNull).toList()) {
      GenericInfo generic = extractGenericInfo(article);
      if (generic == null) {
        continue;
      }

      TecDocProizvodjaci manufacturer =
          TecDocProizvodjaci.pronadjiPoKljucu(article.getDataSupplierId());

      addNumber(index, manufacturer, generic, TecDocProizvodjaci.generateAlternativeCatalogNumber(article.getArticleNumber(), article.getDataSupplierId()));

      if (manufacturer != null && manufacturer.isUseTradeNumber()) {
        List<TradeNumberDetailsRecord> tradeDetails = article.getTradeNumbersDetails();
        if (tradeDetails != null) {
          tradeDetails.stream()
              .filter(Objects::nonNull)
              .filter(TradeNumberDetailsRecord::isIsImmediateDisplay)
              .map(TradeNumberDetailsRecord::getTradeNumber)
              .forEach(
                  tradeNumber ->
                      addNumber(
                          index,
                          manufacturer,
                          generic,
                          TecDocProizvodjaci.generateAlternativeCatalogNumber(
                              tradeNumber, article.getDataSupplierId())));
        }
      }

      List<ArticleRefRecord> oemNumbers = article.getOemNumbers();
      if (oemNumbers != null) {
        oemNumbers.stream()
            .filter(Objects::nonNull)
            .map(ArticleRefRecord::getArticleNumber)
            .filter(StringUtils::hasText)
            .map(CatalogNumberUtils::cleanPreserveSeparators)
            .map(oe -> oe.concat("-OE"))
            .forEach(oeNumber -> addNumber(index, manufacturer, generic, oeNumber));
      }
    }

    return index;
  }

  private Map<String, GenericInfo> buildGenericIndexFromDirectSearch(
      List<ArticleDirectSearchAllNumbersWithStateRecord> records) {
    Map<String, GenericInfo> index = new HashMap<>();

    for (ArticleDirectSearchAllNumbersWithStateRecord record : records) {
      if (record == null || !StringUtils.hasText(record.getArticleNo())) {
        continue;
      }
      if (record.getGenericArticleId() == null || record.getGenericArticleId() == 0) {
        continue;
      }

      TecDocProizvodjaci manufacturer =
          record.getBrandNo() != null ? TecDocProizvodjaci.pronadjiPoKljucu(record.getBrandNo()) : null;

      GenericInfo generic = new GenericInfo(record.getGenericArticleId(), record.getCategory());

      String providerNumber = CatalogNumberUtils.cleanPreserveSeparators(record.getArticleNo());
      addNumber(index, manufacturer, generic, providerNumber);

      if (manufacturer != null && StringUtils.hasText(providerNumber)) {
        String localKey =
            TecDocProizvodjaci.generateAlternativeCatalogNumber(providerNumber, manufacturer.getTecDocId());
        addNumber(index, manufacturer, generic, localKey);
      }
    }

    return index;
  }

  private void addNumber(
      Map<String, GenericInfo> index,
      TecDocProizvodjaci manufacturer,
      GenericInfo generic,
      String rawNumber) {
    String cleaned = CatalogNumberUtils.cleanPreserveSeparators(rawNumber);
    if (!StringUtils.hasText(cleaned)) {
      return;
    }

    index.putIfAbsent(cleaned, generic);
    if (manufacturer != null) {
      index.putIfAbsent(buildKey(manufacturer.getCleanName(), cleaned), generic);
    }
  }

  private GenericInfo extractGenericInfo(ArticleRecord article) {
    List<GenericArticleRecord> genericArticles = article.getGenericArticles();
    if (genericArticles == null || genericArticles.isEmpty() || genericArticles.get(0) == null) {
      return null;
    }

    GenericArticleRecord primary = genericArticles.get(0);
    long genericId = primary.getGenericArticleId();
    if (genericId == 0) {
      return null;
    }

    String categoryName =
        StringUtils.hasText(primary.getGenericArticleDescription())
            ? primary.getGenericArticleDescription()
            : null;

    return new GenericInfo(genericId, categoryName);
  }

  private String buildKey(String manufacturer, String number) {
    return manufacturer + "|" + number;
  }

  private record GenericInfo(long genericArticleId, String categoryName) {}
}
