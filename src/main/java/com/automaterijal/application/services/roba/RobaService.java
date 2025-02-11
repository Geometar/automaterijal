package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.roba.RobaRepository;
import com.automaterijal.application.services.roba.cache.CachedRobaService;
import java.util.List;
import java.util.Optional;
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
public class RobaService {

  @NonNull final RobaRepository robaRepository;
  @NonNull final CachedRobaService cachedRobaService;
  @NonNull final RobaMapper mapper;

  public Optional<Roba> pronadjiRobuPoPrimarnomKljucu(Long id) {
    return robaRepository.findById(id);
  }

  public List<RobaDto> pronadjiRobuPoPrimarnomKljucu(List<Long> robaIds) {
    return mapper.map(robaRepository.findByRobaidIn(robaIds));
  }

  public List<Roba> pronadjiRobuPoPrimarnomKljucuBatch(List<Long> ids) {
    return robaRepository.findByRobaidIn(ids);
  }

  public List<Roba> pronadjiSvuRobuPoPodGrupiIdListaSvaStanja(List<Integer> podGrupaId) {
    return robaRepository.findByPodgrupaidIn(podGrupaId);
  }

  public Roba pronadjiPoPretaziIProizvodjacima(String katBr, List<String> proizvodjaci) {
    return robaRepository.findByKatbrAndProizvodjacProidInAndStanjeGreaterThan(
        katBr, proizvodjaci, 0);
  }

  public List<Roba> pronadjiRobuPoKataloskomBroju(String katBr) {
    return robaRepository.findByKatbr(katBr);
  }

  public List<RobaCache> getAllRobaFilteredByKatBr(String searchTerm) {
    return cachedRobaService.getAllRoba().stream()
        .filter(
            robaCache ->
                robaCache.getKatbr().contains(searchTerm)
                    || robaCache.getKatbrpro().contains(searchTerm))
        .toList();
  }

  public List<RobaCache> getAllRobaByNaizvLike(String searchTerm) {
    return cachedRobaService.getAllRoba().stream()
        .filter(robaCache -> robaCache.getNaziv().contains(searchTerm))
        .toList();
  }

  public List<RobaCache> getAllRobaByKatBrIn(Set<String> katBr) {
    return cachedRobaService.getAllRoba().stream()
        .filter(robaCache -> katBr.contains(robaCache.getKatbr()))
        .toList();
  }

  public List<RobaCache> getAllRobaFilteredByKatBr(Set<String> katBr) {
    return cachedRobaService.getAllRoba().stream()
        .filter(
            robaCache ->
                katBr.contains(robaCache.getKatbr()) || katBr.contains(robaCache.getKatbrpro()))
        .toList();
  }
}
