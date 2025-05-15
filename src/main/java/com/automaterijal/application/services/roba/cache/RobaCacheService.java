package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.cache.RobaCache;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaCacheService {
  @NonNull final RobaCachedService robaCachedService;

  public List<RobaCache> getAllRobaFilteredByKatBr(String searchTerm) {
    return robaCachedService.getAllRoba().stream()
        .filter(
            robaCache ->
                robaCache.getKatbr().contains(searchTerm)
                    || robaCache.getKatbrpro().contains(searchTerm))
        .toList();
  }

  public List<RobaCache> getAllRobaByNazivLike(String searchTerm) {
    String[] searchTerms = searchTerm.split(" ");
    return robaCachedService.getAllRoba().stream()
        .filter(
            robaCache ->
                Arrays.stream(searchTerms)
                    .allMatch(
                        term -> robaCache.getNaziv().toLowerCase().contains(term.toLowerCase())))
        .toList();
  }

  public List<RobaCache> getAllRobaByKatBrIn(Set<String> katBr) {
    return robaCachedService.getAllRoba().stream()
        .filter(robaCache -> katBr.contains(robaCache.getKatbr()))
        .toList();
  }

  public List<RobaCache> getAllRobaFilteredByKatBr(Set<String> katBr) {
    return robaCachedService.getAllRoba().stream()
        .filter(
            robaCache ->
                katBr.contains(robaCache.getKatbr()) || katBr.contains(robaCache.getKatbrpro()))
        .toList();
  }
}
