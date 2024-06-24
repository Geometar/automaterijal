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

  @NonNull
  final PodGrupaRepository podGrupaRepository;

  @NonNull
  final PodrgrupaMapper mapper;

  public static final String SVE = "SVE KATEGORIJE";
  public static final String NEBITNA_GRUPA = "ZZZ";

  public List<PodgrupaDto> vratiSvePodgrupeZaKljuceve(Set<Integer> podgrupe) {
    return podGrupaRepository.findByPodGrupaIdIn(podgrupe)
        .stream()
        .map(mapper::map)
        .collect(Collectors.toList());
  }

  public List<String> vratiSveGrupeNazive() {
    Set<String> podGrupe = podGrupaRepository.findAll()
        .stream()
        .map(PodGrupa::getNaziv)
        .filter(StringUtils::isNotBlank)
        .filter(naziv -> !naziv.equals("0"))
        .map(String::trim)
        .map(String::toUpperCase)
        .collect(Collectors.toSet());
    List<String> grupeSortirano = new ArrayList<>(podGrupe).stream().sorted()
        .collect(Collectors.toList());
    grupeSortirano.add(0, SVE);
    return grupeSortirano;
  }

  public List<PodGrupa> vratiSvePodgrupe() {
    return podGrupaRepository.findAll();
  }

  public List<PodGrupa> vratiSvePodGrupePoNazivu(String naziv) {
    return podGrupaRepository.findByNazivLike(naziv)
        .stream()
        .collect(Collectors.toList());
  }

  public List<PodGrupa> vratiSvePodGrupePoNazivima(List<String> nazivi) {
    return podGrupaRepository.findByNazivIn(nazivi);
  }

  public List<PodGrupa> vratiSvePodGrupePoGrupi(String grupaId) {
    return podGrupaRepository.findByGrupaId(grupaId).stream()
        .filter(podGrupa -> !podGrupa.getNaziv().isEmpty()).collect(Collectors.toList());
  }

  /**
   * Metoda za popunjavanje svih grupa u zavisnosti od kriterijuma
   */
  public void popuniPodgrupe(MagacinDto magacinDto, UniverzalniParametri parametri,
      List<RobaDto> roba) {
    List<PodgrupaDto> podgrupaDtos;
    if (parametri.getTrazenaRec() == null && parametri.getProizvodjac() == null) {
      if (parametri.getRobaKategorije() == null) {
        podgrupaDtos = podGrupaRepository.findAll().stream()
            .filter(podGrupa -> StringUtils.isNotBlank(podGrupa.getNaziv()))
            .map(mapper::map)
            .collect(Collectors.toList());
      } else {
        podgrupaDtos = podGrupaRepository.findByPodGrupaIdIn(
                parametri.getPodGrupe().stream().map(PodGrupa::getPodGrupaId)
                    .collect(Collectors.toList()))
            .stream()
            .filter(podGrupa -> StringUtils.isNotBlank(podGrupa.getNaziv()))
            .map(mapper::map)
            .collect(Collectors.toList());
      }
    } else {
      Set<Integer> sviKljucevi = roba.stream().map(RobaDto::getPodGrupa)
          .collect(Collectors.toSet());
      podgrupaDtos = vratiSvePodgrupeZaKljuceve(sviKljucevi);
    }

    popuniSveNazivePodgrupa(roba, podgrupaDtos);
    Set<String> podGrupe = podgrupaDtos.stream().map(PodgrupaDto::getNaziv).map(String::trim)
        .map(String::toUpperCase).collect(Collectors.toSet());
    List<String> sveGrupe = new ArrayList<>(podGrupe).stream().sorted()
        .collect(Collectors.toList());

    sveGrupe.add(0, PodGrupaService.SVE);
    magacinDto.setPodgrupe(sveGrupe);
  }

  private void popuniSveNazivePodgrupa(List<RobaDto> robaDtos, List<PodgrupaDto> podgrupaDtos) {
    for (RobaDto roba : robaDtos) {
      podgrupaDtos.stream().filter(
              podgrupa -> podgrupa.getId().intValue() == roba.getPodGrupa()
                  || roba.getPodGrupa() == 0)
          .findFirst().ifPresent(podgrupa -> {
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
