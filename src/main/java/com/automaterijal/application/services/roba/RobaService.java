package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.repository.roba.RobaRepository;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaService {

  @NonNull final RobaRepository robaRepository;

  public Optional<Roba> pronadjiRobuPoPrimarnomKljucu(Long id) {
    return robaRepository.findById(id);
  }

  public List<Roba> pronadjiRobuPoPrimarnomKljucuBatch(List<Long> ids) {
    return robaRepository.findByRobaidIn(ids);
  }

  public Page<Roba> pronadjiSvuRobu(boolean naStanju, Pageable pageable) {
    if (naStanju) {
      return robaRepository.findByStanjeGreaterThan(0, pageable);
    } else {
      return robaRepository.findAll(pageable);
    }
  }

  public Page<Roba> pronadjiSvuRobuPoProizvodjacima(
      List<String> proizvodjaci, boolean naStanju, Pageable pageable) {
    if (naStanju) {
      return robaRepository.findByProizvodjacProidInAndStanjeGreaterThan(proizvodjaci, 0, pageable);
    } else {
      return robaRepository.findByProizvodjacProidIn(proizvodjaci, pageable);
    }
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
}
