package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocBrandService {

  @NonNull TecDocBrandsRepository tecDocBrandsRepository;

  @Cacheable(cacheNames = "tecdocBrandByProid", key = "#proId")
  public Optional<TecDocBrands> findById(String proId) {
    if (!StringUtils.hasText(proId)) {
      return Optional.empty();
    }
    return tecDocBrandsRepository.findById(proId);
  }

  @Cacheable(cacheNames = "tecdocProidByBrandId", key = "#brandId")
  public Optional<String> findProidByBrandId(Long brandId) {
    if (brandId == null) {
      return Optional.empty();
    }
    return tecDocBrandsRepository.findFirstByBrandId(brandId).map(TecDocBrands::getProid);
  }

  public Map<Long, String> findProidsByBrandIds(Collection<Long> brandIds) {
    if (brandIds == null || brandIds.isEmpty()) {
      return Map.of();
    }
    List<Long> normalized =
        brandIds.stream().filter(Objects::nonNull).distinct().toList();
    if (normalized.isEmpty()) {
      return Map.of();
    }

    Map<Long, String> mapped = new LinkedHashMap<>();
    List<TecDocBrands> brands = tecDocBrandsRepository.findByBrandIdIn(normalized);
    if (brands == null || brands.isEmpty()) {
      return Collections.emptyMap();
    }
    for (TecDocBrands brand : brands) {
      if (brand == null || brand.getBrandId() == null || !StringUtils.hasText(brand.getProid())) {
        continue;
      }
      mapped.putIfAbsent(brand.getBrandId(), brand.getProid());
    }
    return mapped;
  }

  public TecDocBrands save(TecDocBrands brands) {
    return tecDocBrandsRepository.saveAndFlush(brands);
  }

  public List<TecDocBrands> findAll() {
    return tecDocBrandsRepository.findAll();
  }

  public void deleteByProid(String proid) {
    if (proid == null || proid.isBlank()) {
      return;
    }
    tecDocBrandsRepository.deleteById(proid);
  }
}
