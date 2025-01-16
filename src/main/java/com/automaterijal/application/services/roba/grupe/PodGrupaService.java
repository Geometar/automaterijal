package com.automaterijal.application.services.roba.grupe;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.mapper.PodrgrupaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.PodGrupaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PodGrupaService {

  @NonNull final PodGrupaRepository podGrupaRepository;

  @NonNull final PodrgrupaMapper mapper;
  public static final String NEBITNA_GRUPA = "ZZZ";

  public List<PodgrupaDto> vratiSvePodgrupeZaKljuceve(Set<Integer> podgrupe) {
    return podGrupaRepository.findByPodGrupaIdIn(podgrupe).stream().map(mapper::map).toList();
  }

  public List<String> vratiSveGrupeNazive() {
    Set<String> podGrupe =
        podGrupaRepository.findAll().stream()
            .map(PodGrupa::getNaziv)
            .filter(StringUtils::isNotBlank)
            .filter(naziv -> !naziv.equals("0"))
            .map(String::trim)
            .map(String::toUpperCase)
            .collect(Collectors.toSet());
    return new ArrayList<>(podGrupe).stream().sorted().toList();
  }

  public List<PodGrupa> vratiSvePodgrupe() {
    return podGrupaRepository.findAll();
  }

  public List<PodGrupa> vratiSvePodGrupePoNazivima(List<String> nazivi) {
    return podGrupaRepository.findByNazivIn(nazivi);
  }

  public List<PodGrupa> vratiSvePodGrupePoGrupeIn(List<String> grupaId) {
    return podGrupaRepository.findByGrupaIdIn(grupaId).stream()
        .filter(podGrupa -> !podGrupa.getNaziv().isEmpty())
        .toList();
  }

  /** Metoda za popunjavanje svih grupa u zavisnosti od kriterijuma */
  public void popuniPodgrupe(
      MagacinDto magacinDto, UniverzalniParametri parametri, List<RobaDto> roba) {
    List<PodgrupaDto> podgrupaDtos;
    if (parametri.getTrazenaRec() == null && parametri.getProizvodjac() == null) {
      podgrupaDtos =
          podGrupaRepository.findAll().stream()
              .filter(podGrupa -> StringUtils.isNotBlank(podGrupa.getNaziv()))
              .map(mapper::map)
              .toList();

    } else {
      Set<Integer> sviKljucevi =
          roba.stream().map(RobaDto::getPodGrupa).collect(Collectors.toSet());
      podgrupaDtos = vratiSvePodgrupeZaKljuceve(sviKljucevi);
    }

    popuniSveNazivePodgrupa(roba, podgrupaDtos);
    Set<String> podGrupe =
        podgrupaDtos.stream()
            .map(PodgrupaDto::getNaziv)
            .map(String::trim)
            .map(String::toUpperCase)
            .collect(Collectors.toSet());
    magacinDto.setPodgrupe(new ArrayList<>(podGrupe).stream().sorted().toList());
  }

  private void popuniSveNazivePodgrupa(List<RobaDto> robaDtos, List<PodgrupaDto> podgrupaDtos) {
    for (RobaDto roba : robaDtos) {
      podgrupaDtos.stream()
          .filter(
              podgrupa ->
                  podgrupa.getId().intValue() == roba.getPodGrupa() || roba.getPodGrupa() == 0)
          .findFirst()
          .ifPresent(
              podgrupa -> {
                if (roba.getPodGrupa() != 0) {
                  roba.setPodGrupaNaziv(podgrupa.getNaziv());
                } else {
                  roba.setPodGrupaNaziv(NEBITNA_GRUPA);
                }
              });
    }
  }

  public Optional<PodGrupa> vratiPodgrupuPoKljucu(int kljuc) {
    return podGrupaRepository.findById(kljuc);
  }
}
