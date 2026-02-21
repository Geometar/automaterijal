package com.automaterijal.application.integration.providers.gazela;

import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaBrand;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaBranch;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class GazelaReferenceDataService {

  private static final Pattern NON_ALNUM = Pattern.compile("[^A-Z0-9]");
  private static final int MIN_FUZZY_PREFIX_LENGTH = 4;

  private final GazelaApiClient apiClient;
  private final GazelaProperties properties;

  private volatile Cache<List<GazelaBrand>> brandsCache;
  private volatile Cache<List<GazelaBranch>> branchesCache;

  public Optional<GazelaBrand> findBrand(String brandCode) {
    if (!StringUtils.hasText(brandCode)) {
      return Optional.empty();
    }
    String normalized = normalizeBrandKey(brandCode);
    if (!StringUtils.hasText(normalized)) {
      return Optional.empty();
    }

    List<GazelaBrand> brands = getBrands();
    for (GazelaBrand brand : brands) {
      if (brand == null || brand.dlNr() == null || !StringUtils.hasText(brand.ime())) {
        continue;
      }
      String candidate = normalizeBrandKey(brand.ime());
      if (normalized.equals(candidate)) {
        return Optional.of(brand);
      }
    }

    List<GazelaBrand> fuzzyCandidates = new ArrayList<>();
    for (GazelaBrand brand : brands) {
      if (brand == null || brand.dlNr() == null || !StringUtils.hasText(brand.ime())) {
        continue;
      }
      String candidate = normalizeBrandKey(brand.ime());
      if (!isSafePrefixMatch(normalized, candidate)) {
        continue;
      }
      fuzzyCandidates.add(brand);
    }

    if (fuzzyCandidates.size() == 1) {
      return Optional.of(fuzzyCandidates.get(0));
    }

    return Optional.empty();
  }

  public Optional<String> resolveBrandKey(String tecDocBrandName) {
    return findBrand(tecDocBrandName)
        .map(GazelaBrand::ime)
        .filter(StringUtils::hasText)
        .map(value -> value.trim().toUpperCase(Locale.ROOT));
  }

  public Optional<GazelaBrand> findBrandByDlNr(Integer dlNr) {
    if (dlNr == null) {
      return Optional.empty();
    }
    for (GazelaBrand brand : getBrands()) {
      if (brand == null || brand.dlNr() == null) {
        continue;
      }
      if (dlNr.equals(brand.dlNr())) {
        return Optional.of(brand);
      }
    }
    return Optional.empty();
  }

  public Optional<String> resolveBrandKeyByDlNr(Integer dlNr) {
    return findBrandByDlNr(dlNr)
        .map(GazelaBrand::ime)
        .filter(StringUtils::hasText)
        .map(value -> value.trim().toUpperCase(Locale.ROOT));
  }

  public List<GazelaBrand> getBrands() {
    Cache<List<GazelaBrand>> cache = brandsCache;
    long now = System.currentTimeMillis();
    if (cache != null && cache.expiresAtMs() > now) {
      return cache.value();
    }

    List<GazelaBrand> fetched = new ArrayList<>(apiClient.fetchBrands());
    fetched.sort(Comparator.comparingInt(brand -> brand != null && brand.dlNr() != null ? brand.dlNr() : 0));
    List<GazelaBrand> immutable = List.copyOf(fetched);
    brandsCache = new Cache<>(immutable, now + resolveCacheTtlMs());
    return immutable;
  }

  public List<GazelaBranch> getBranches() {
    Cache<List<GazelaBranch>> cache = branchesCache;
    long now = System.currentTimeMillis();
    if (cache != null && cache.expiresAtMs() > now) {
      return cache.value();
    }

    List<GazelaBranch> fetched = new ArrayList<>(apiClient.fetchBranches());
    fetched.sort(
        Comparator.comparingInt(branch -> branch != null && branch.id() != null ? branch.id() : Integer.MAX_VALUE));
    List<GazelaBranch> immutable = List.copyOf(fetched);
    branchesCache = new Cache<>(immutable, now + resolveCacheTtlMs());
    return immutable;
  }

  private long resolveCacheTtlMs() {
    GazelaProperties.Api api = properties.getApi();
    Long ttl = api != null ? api.getReferenceCacheTtlMs() : null;
    return ttl != null && ttl > 0 ? ttl : 86_400_000L;
  }

  private String normalizeBrandKey(String value) {
    if (!StringUtils.hasText(value)) {
      return "";
    }
    String normalized = value.trim().toUpperCase(Locale.ROOT);
    return NON_ALNUM.matcher(normalized).replaceAll("");
  }

  private boolean isSafePrefixMatch(String normalizedInput, String normalizedCandidate) {
    if (!StringUtils.hasText(normalizedInput) || !StringUtils.hasText(normalizedCandidate)) {
      return false;
    }
    int shorterLength = Math.min(normalizedInput.length(), normalizedCandidate.length());
    if (shorterLength < MIN_FUZZY_PREFIX_LENGTH) {
      return false;
    }
    return normalizedCandidate.startsWith(normalizedInput)
        || normalizedInput.startsWith(normalizedCandidate);
  }

  private record Cache<T>(T value, long expiresAtMs) {}
}
