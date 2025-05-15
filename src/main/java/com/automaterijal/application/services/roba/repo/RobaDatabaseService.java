package com.automaterijal.application.services.roba.repo;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.roba.RobaRepository;
import java.util.List;
import java.util.Optional;
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
public class RobaDatabaseService {

  @NonNull final RobaRepository robaRepository;
  @NonNull final RobaMapper mapper;

  public Optional<Roba> pronadjiRobuPoPrimarnomKljucu(Long id) {
    return robaRepository.findById(id);
  }

  public List<RobaLightDto> pronadjiRobuPoPrimarnomKljucu(List<Long> robaIds) {
    return mapper.map(robaRepository.findByRobaidIn(robaIds));
  }

  public Roba pronadjiPoPretaziIProizvodjacima(String katBr, List<String> proizvodjaci) {
    return robaRepository.findByKatbrAndProizvodjacProidInAndStanjeGreaterThan(
        katBr, proizvodjaci, 0);
  }

  public List<Roba> pronadjiRobuPoKataloskomBroju(String katBr) {
    return robaRepository.findByKatbr(katBr);
  }

  public List<RobaLightDto> findByManufacturer(String proid) {
    return mapper.map(robaRepository.findByProizvodjacProid(proid));
  }
}
