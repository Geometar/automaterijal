package com.automaterijal.application.patterns.strategy.roba;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaHelper;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PretragaBezFilteraStrategija implements PretragaRobeStrategija {

  @NonNull final RobaService robaService;
  @NonNull final ProizvodjacService proizvodjacService;
  @NonNull final PodGrupaService podGrupaService;
  @NonNull final RobaMapper mapper;
  @NonNull final TecDocService tecDocService;
  @NonNull final RobaHelper robaHelper;

  @Override
  public MagacinDto pretrazi(UniverzalniParametri parametri, Partner ulogovaniPartner) {
    var magacinDto = new MagacinDto();
    var pageable =
        PageRequest.of(
            parametri.getPage(),
            parametri.getPageSize(),
            Sort.by(Sort.Direction.DESC, RobaSortiranjePolja.STANJE.getFieldName()));

    Page<RobaDto> robaDto =
        vratiSvuRobuUZavisnostiOdTrazenogStanja(parametri, pageable, ulogovaniPartner);

    magacinDto.setPodgrupe(podGrupaService.vratiSveGrupeNazive());
    magacinDto.setProizvodjaci(proizvodjacService.pronadjiSveProizvodjaceZaVrstu(parametri));
    magacinDto.setRobaDto(robaDto);

    return magacinDto;
  }

  private Page<RobaDto> vratiSvuRobuUZavisnostiOdTrazenogStanja(
      UniverzalniParametri parametri, Pageable pageable, Partner ulogovaniPartner) {
    Page<Roba> roba = pronadjiRobu(parametri, pageable);

    if (roba == null) {
      log.error("Ne definisana roba!");
      return Page.empty();
    }

    List<RobaDto> dto = mapirajRobu(roba);
    tecDocService.batchVracanjeICuvanjeTDAtributa(dto);
    postaviPodgrupuINaziv(dto);
    robaHelper.setujZaTabelu(dto, ulogovaniPartner);

    return new PageImpl<>(dto, roba.getPageable(), roba.getTotalElements());
  }

  private Page<Roba> pronadjiRobu(UniverzalniParametri parametri, Pageable pageable) {
    boolean naStanju = parametri.isNaStanju();

    if (parametri.getMandatoryProid() != null && !parametri.getMandatoryProid().isEmpty()) {
      return robaService.pronadjiSvuRobuPoProizvodjacima(
          parametri.getMandatoryProid(), naStanju, pageable);
    }

    return robaService.pronadjiSvuRobu(naStanju, pageable);
  }

  private List<RobaDto> mapirajRobu(Page<Roba> roba) {
    return roba.stream().map(mapper::map).toList();
  }

  private void postaviPodgrupuINaziv(List<RobaDto> dto) {
    List<PodgrupaDto> podgrupaDtos =
        podGrupaService.vratiSvePodgrupeZaKljuceve(
            dto.stream().map(RobaDto::getPodGrupa).collect(Collectors.toSet()));

    dto.forEach(
        robaDto ->
            podgrupaDtos.stream()
                .filter(podgrupaDto -> podgrupaDto.getId() == robaDto.getPodGrupa())
                .findAny()
                .ifPresent(podgrupaDto -> robaDto.setPodGrupaNaziv(podgrupaDto.getNaziv())));
  }
}
