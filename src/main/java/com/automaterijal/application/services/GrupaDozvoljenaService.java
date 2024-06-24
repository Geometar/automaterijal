package com.automaterijal.application.services;

import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.GrupaDozvoljena;
import com.automaterijal.application.domain.repository.GrupaDozvoljenaRepository;
import com.automaterijal.application.services.roba.grupe.GrupaService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class GrupaDozvoljenaService {

  @NonNull
  final GrupaDozvoljenaRepository repository;

  @NonNull
  final GrupaService grupaService;

  public List<GrupaDozvoljena> pronadjiSveDozvoljeneGrupe() {
    return repository.findAllByOrderByNaziv();
  }

  public void izbrisiGrupu(String grupaId) {
    repository.deleteById(grupaId);
  }

  public void dodajGrupu(GrupaDozvoljena grupaDozvoljena) {
    if (repository.findById(grupaDozvoljena.getGrupaid()).isPresent()) {
      repository.save(grupaDozvoljena);
    }
  }

  public List<Grupa> vratiSveGrupeKojeNisuDozvoljene() {
    List<Grupa> grupe = grupaService.vratiSveGrupe();
    List<String> sveDozvoljeneGrupeId = pronadjiSveDozvoljeneGrupe().stream()
        .map(GrupaDozvoljena::getGrupaid).collect(Collectors.toList());
    return grupe.stream().filter(grupa -> !sveDozvoljeneGrupeId.contains(grupa.getGrupaid()))
        .collect(Collectors.toList());
  }
}
