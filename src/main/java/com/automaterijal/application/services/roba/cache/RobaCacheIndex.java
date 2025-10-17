package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.utils.GeneralUtil;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

final class RobaCacheIndex {

  private static final int MIN_GRAM_LENGTH = 3;

  private final List<RobaCache> allItems;
  private final Map<Long, RobaCache> byId;
  private final Map<Long, String> normalizedNames;
  private final Map<Long, Integer> orderIndex;
  private final Map<String, Set<Long>> catalogExactIndex;
  private final Map<String, Set<Long>> catalogGramIndex;
  private final Map<String, Set<Long>> nameTokenIndex;
  private final Map<String, Set<Long>> nameGramIndex;

  private RobaCacheIndex(List<RobaCache> data) {
    this.allItems = Collections.unmodifiableList(new ArrayList<>(data));
    this.byId = allItems.stream().collect(Collectors.toMap(RobaCache::getRobaid, Function.identity()));
    this.orderIndex = new HashMap<>(allItems.size());
    this.normalizedNames = new HashMap<>(allItems.size());
    this.catalogExactIndex = new HashMap<>();
    this.catalogGramIndex = new HashMap<>();
    this.nameTokenIndex = new HashMap<>();
    this.nameGramIndex = new HashMap<>();

    for (int i = 0; i < allItems.size(); i++) {
      RobaCache cache = allItems.get(i);
      orderIndex.put(cache.getRobaid(), i);

      String katbr = defaultString(cache.getKatbr());
      String katbrPro = defaultString(cache.getKatbrpro());
      String normalizedKatbr = normalizeCatalog(katbr);
      String normalizedKatbrPro = normalizeCatalog(katbrPro);

      String normalizedName = normalizeName(defaultString(cache.getNaziv()));
      Set<String> nameTokens = tokenize(normalizedName);

      normalizedNames.put(cache.getRobaid(), normalizedName);

      indexCatalogValue(cache.getRobaid(), normalizedKatbr);
      indexCatalogValue(cache.getRobaid(), normalizedKatbrPro);

      indexCatalogNgrams(cache.getRobaid(), normalizedKatbr);
      indexCatalogNgrams(cache.getRobaid(), normalizedKatbrPro);

      indexNameTokens(cache.getRobaid(), nameTokens);
      indexNameNgrams(cache.getRobaid(), normalizedName);
    }
  }

  static RobaCacheIndex build(List<RobaCache> data) {
    return new RobaCacheIndex(data);
  }

  List<RobaCache> all() {
    return allItems;
  }

  List<RobaCache> searchByCatalogTerm(String term) {
    if (term == null || term.isBlank()) {
      return List.of();
    }
    String normalizedTerm = normalizeCatalog(term);
    if (normalizedTerm.length() < MIN_GRAM_LENGTH) {
      return allItems.stream()
          .filter(item -> catalogMatches(item, term))
          .collect(Collectors.toList());
    }

    Set<Long> candidateIds = collectCandidatesForCatalog(normalizedTerm);
    if (candidateIds.isEmpty()) {
      return List.of();
    }

    return toOrderedList(candidateIds).stream()
        .filter(item -> catalogMatches(item, term))
        .collect(Collectors.toList());
  }

  List<RobaCache> searchByCatalogTerms(Set<String> catalogNumbers) {
    if (catalogNumbers == null || catalogNumbers.isEmpty()) {
      return List.of();
    }
    Set<Long> ids = new HashSet<>();
    for (String value : catalogNumbers) {
      if (value == null) {
        continue;
      }
      String normalized = normalizeCatalog(value);
      Set<Long> mapped = catalogExactIndex.get(normalized);
      if (mapped != null) {
        ids.addAll(mapped);
      }
    }
    if (ids.isEmpty()) {
      return List.of();
    }

    return toOrderedList(ids).stream()
        .filter(item -> matchesExactCatalog(item, catalogNumbers))
        .collect(Collectors.toList());
  }

  List<RobaCache> searchByPrimaryCatalog(Set<String> catalogNumbers) {
    if (catalogNumbers == null || catalogNumbers.isEmpty()) {
      return List.of();
    }
    Set<Long> ids = new HashSet<>();
    for (String value : catalogNumbers) {
      if (value == null) {
        continue;
      }
      String normalized = normalizeCatalog(value);
      Set<Long> mapped = catalogExactIndex.get(normalized);
      if (mapped != null) {
        ids.addAll(mapped);
      }
    }
    if (ids.isEmpty()) {
      return List.of();
    }

    return toOrderedList(ids).stream()
        .filter(item -> primaryCatalogMatches(item, catalogNumbers))
        .collect(Collectors.toList());
  }

  List<RobaCache> searchByName(String searchTerm) {
    if (searchTerm == null || searchTerm.isBlank()) {
      return List.of();
    }

    String normalizedSearch = normalizeName(searchTerm);
    if (normalizedSearch.isEmpty()) {
      return List.of();
    }

    Set<String> tokens = tokenize(normalizedSearch);

    Set<Long> candidateIds =
        normalizedSearch.length() >= MIN_GRAM_LENGTH
            ? collectCandidatesForNameGram(normalizedSearch)
            : new HashSet<>();

    if ((candidateIds == null || candidateIds.isEmpty()) && !tokens.isEmpty()) {
      candidateIds = collectCandidatesForNameTokens(tokens);
    }

    if (candidateIds == null || candidateIds.isEmpty()) {
      candidateIds = new HashSet<>(byId.keySet());
    }

    final String finalSearch = normalizedSearch;
    final Set<String> requiredTokens = tokens;

    return toOrderedList(candidateIds).stream()
        .filter(item ->
            nameContains(item.getRobaid(), finalSearch)
                && (requiredTokens.isEmpty() || nameMatches(item.getRobaid(), requiredTokens)))
        .collect(Collectors.toList());
  }

  private boolean catalogMatches(RobaCache cache, String term) {
    String katbr = cache.getKatbr();
    String alt = cache.getKatbrpro();
    return (katbr != null && katbr.contains(term)) || (alt != null && alt.contains(term));
  }

  private boolean matchesExactCatalog(RobaCache cache, Set<String> catalogNumbers) {
    String katbr = cache.getKatbr();
    String alt = cache.getKatbrpro();
    return (katbr != null && catalogNumbers.contains(katbr))
        || (alt != null && catalogNumbers.contains(alt));
  }

  private boolean primaryCatalogMatches(RobaCache cache, Set<String> catalogNumbers) {
    String katbr = cache.getKatbr();
    return katbr != null && catalogNumbers.contains(katbr);
  }

  private boolean nameMatches(Long robaId, Set<String> tokens) {
    String normalizedName = normalizedNames.get(robaId);
    if (normalizedName == null) {
      return false;
    }
    for (String token : tokens) {
      if (!normalizedName.contains(token)) {
        return false;
      }
    }
    return true;
  }

  private Set<Long> collectCandidatesForCatalog(String normalizedTerm) {
    List<String> grams = toNgrams(normalizedTerm);
    if (grams.isEmpty()) {
      return Set.of();
    }

    Set<Long> candidateIds = null;
    for (String gram : grams) {
      Set<Long> ids = catalogGramIndex.get(gram);
      if (ids == null) {
        return Set.of();
      }
      if (candidateIds == null) {
        candidateIds = new HashSet<>(ids);
      } else {
        candidateIds.retainAll(ids);
        if (candidateIds.isEmpty()) {
          return Set.of();
        }
      }
    }
    return candidateIds == null ? Set.of() : candidateIds;
  }

  private List<RobaCache> toOrderedList(Set<Long> ids) {
    return ids.stream()
        .map(byId::get)
        .filter(Objects::nonNull)
        .sorted(Comparator.comparingInt(item -> orderIndex.getOrDefault(item.getRobaid(), Integer.MAX_VALUE)))
        .collect(Collectors.toList());
  }

  private void indexCatalogValue(Long robaId, String normalizedValue) {
    if (normalizedValue.isEmpty()) {
      return;
    }
    catalogExactIndex.computeIfAbsent(normalizedValue, key -> new HashSet<>()).add(robaId);
  }

  private void indexCatalogNgrams(Long robaId, String normalizedValue) {
    if (normalizedValue.length() < MIN_GRAM_LENGTH) {
      return;
    }
    Set<String> grams = new HashSet<>(toNgrams(normalizedValue));
    for (String gram : grams) {
      catalogGramIndex.computeIfAbsent(gram, key -> new HashSet<>()).add(robaId);
    }
  }

  private void indexNameTokens(Long robaId, Set<String> tokens) {
    for (String token : tokens) {
      nameTokenIndex.computeIfAbsent(token, key -> new HashSet<>()).add(robaId);
    }
  }

  private void indexNameNgrams(Long robaId, String normalizedName) {
    if (normalizedName.length() < MIN_GRAM_LENGTH) {
      return;
    }
    Set<String> grams = new HashSet<>(toNgrams(normalizedName));
    for (String gram : grams) {
      nameGramIndex.computeIfAbsent(gram, key -> new HashSet<>()).add(robaId);
    }
  }

  private Set<Long> collectCandidatesForNameGram(String normalizedTerm) {
    List<String> grams = toNgrams(normalizedTerm);
    if (grams.isEmpty()) {
      return new HashSet<>();
    }

    Set<Long> candidateIds = null;
    for (String gram : grams) {
      Set<Long> ids = nameGramIndex.get(gram);
      if (ids == null) {
        return new HashSet<>();
      }
      if (candidateIds == null) {
        candidateIds = new HashSet<>(ids);
      } else {
        candidateIds.retainAll(ids);
        if (candidateIds.isEmpty()) {
          return candidateIds;
        }
      }
    }

    return candidateIds == null ? new HashSet<>() : candidateIds;
  }

  private Set<Long> collectCandidatesForNameTokens(Set<String> tokens) {
    Set<Long> candidateIds = null;
    for (String token : tokens) {
      Set<Long> ids = nameTokenIndex.get(token);
      if (ids == null) {
        return new HashSet<>();
      }
      if (candidateIds == null) {
        candidateIds = new HashSet<>(ids);
      } else {
        candidateIds.retainAll(ids);
        if (candidateIds.isEmpty()) {
          return candidateIds;
        }
      }
    }
    return candidateIds == null ? new HashSet<>() : candidateIds;
  }

  private boolean nameContains(Long robaId, String normalizedSearch) {
    String normalizedName = normalizedNames.get(robaId);
    return normalizedName != null && normalizedName.contains(normalizedSearch);
  }

  private static String normalizeCatalog(String value) {
    String cleaned = CatalogNumberUtils.cleanPreserveSeparators(value);
    return cleaned == null ? "" : cleaned;
  }

  private static String normalizeName(String value) {
    String normalized =
        Normalizer.normalize(GeneralUtil.cyrillicToLatinic(defaultString(value)), Normalizer.Form.NFD)
            .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
            .toLowerCase();
    return normalized.trim();
  }

  private static Set<String> tokenize(String value) {
    if (value.isBlank()) {
      return Set.of();
    }
    return Arrays.stream(value.split("\\s+"))
        .filter(token -> !token.isBlank())
        .collect(Collectors.toSet());
  }

  private static List<String> toNgrams(String value) {
    if (value.length() < MIN_GRAM_LENGTH) {
      return List.of();
    }
    List<String> grams = new ArrayList<>(value.length() - MIN_GRAM_LENGTH + 1);
    for (int i = 0; i <= value.length() - MIN_GRAM_LENGTH; i++) {
      grams.add(value.substring(i, i + MIN_GRAM_LENGTH));
    }
    return grams;
  }

  private static String defaultString(String value) {
    return value == null ? "" : value;
  }

}
