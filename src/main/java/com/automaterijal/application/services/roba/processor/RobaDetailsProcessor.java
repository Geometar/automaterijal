package com.automaterijal.application.services.roba.processor;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaBrojeviDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.repo.RobaRepositoryService;
import com.automaterijal.application.tecdoc.MainArticlesRecord;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaDetailsProcessor {

  @NonNull final RobaRepositoryService robaRepositoryService;
  @NonNull final RobaCeneService robaCeneService;
  @NonNull final RobaMapper mapper;
  @NonNull final TecDocService tecDocService;

  public void postaviCenuIRabat(RobaDto robaDto, Partner partner) {
    robaDto.setCena(
        robaCeneService.vratiCenuRobePoRobiId(
            robaDto.getRobaid(), robaDto.getGrupa(), robaDto.getProizvodjac().getProid(), partner));

    robaDto.setRabat(
        robaCeneService.vratiRabatPartneraNaArtikal(
            robaDto.getProizvodjac().getProid(), robaDto.getGrupa(), partner));
  }

  private void postaviSlikuIzAtributa(RobaDto robaDto, List<TecDocAtributi> tecDocAtributi) {
    tecDocAtributi.stream()
        .filter(tdAtributi -> tdAtributi.getDokument() != null)
        .forEach(
            tdAtributi -> {
              SlikaDto slikaDto = new SlikaDto();
              slikaDto.setUrl(false);
              slikaDto.setSlikeByte(tdAtributi.getDokument());
              robaDto.setSlika(slikaDto);
            });
  }

  public void processMainArticle(
      MainArticlesRecord mainArticlesRecord, Partner partner, List<RobaDto> asociraniArtikli) {
    robaRepositoryService
        .pronadjiRobuPoKataloskomBroju(mainArticlesRecord.getArticleNumber())
        .stream()
        .map(mapper::map)
        .filter(this::isValidProizvodjac)
        .forEach(robaDto -> handleRobaDto(robaDto, partner, asociraniArtikli));
  }

  private boolean isValidProizvodjac(RobaDto robaDto) {
    return TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid()) != null;
  }

  public void handleRobaDto(RobaDto robaDto, Partner partner, List<RobaDto> asociraniArtikli) {
    List<TecDocAtributi> tecDocAtributi =
        tecDocService.vratiTecDocAtributePrekoRobeId(robaDto.getRobaid());

    if (tecDocAtributi.isEmpty()) {
      tecDocService.batchVracanjeICuvanjeTDAtributa(Collections.singletonList(robaDto));
      tecDocAtributi = tecDocService.vratiTecDocAtributePrekoRobeId(robaDto.getRobaid());
    }

    postaviSlikuIzAtributa(robaDto, tecDocAtributi);
    postaviCenuIRabat(robaDto, partner);
    asociraniArtikli.add(robaDto);
  }

  public void setujSliku(RobaDetaljiDto detaljiDto, List<RobaBrojeviDto> tdBrojevi) {
    List<TecDocAtributi> tecDocAtributi =
        tecDocService.vratiTecDocAtributePrekoRobeId(detaljiDto.getRobaid());
    if (!tdBrojevi.isEmpty()) {
      for (TecDocAtributi dto : tecDocAtributi) {
        SlikaDto slikaDto = new SlikaDto();
        slikaDto.setUrl(false);
        slikaDto.setSlikeByte(dto.getDokument());
        detaljiDto.setSlika(slikaDto);
      }
    }
  }
}
