package com.automaterijal.application.services.roba.processor;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaBrojeviDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaExpandedDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
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

  @NonNull final RobaDatabaseService robaDatabaseService;
  @NonNull final RobaCeneService robaCeneService;
  @NonNull final RobaMapper mapper;
  @NonNull final TecDocService tecDocService;

  public void postaviCenuIRabat(RobaLightDto robaLightDto, Partner partner) {
    robaLightDto.setCena(
        robaCeneService.vratiCenuRobePoRobiId(
            robaLightDto.getRobaid(),
            robaLightDto.getGrupa(),
            robaLightDto.getProizvodjac().getProid(),
            partner));

    robaLightDto.setRabat(
        robaCeneService.vratiRabatPartneraNaArtikal(
            robaLightDto.getProizvodjac().getProid(), robaLightDto.getGrupa(), partner));
  }

  private void postaviSlikuIzAtributa(
      RobaLightDto robaLightDto, List<TecDocAtributi> tecDocAtributi) {
    // Byte-based TecDoc images are no longer propagated; rely on filesystem lookup instead.
  }

  public void processMainArticle(
      MainArticlesRecord mainArticlesRecord, Partner partner, List<RobaLightDto> asociraniArtikli) {
    robaDatabaseService
        .pronadjiRobuPoKataloskomBroju(mainArticlesRecord.getArticleNumber())
        .stream()
        .map(mapper::map)
        .filter(this::isValidProizvodjac)
        .forEach(robaDto -> handleRobaDto(robaDto, partner, asociraniArtikli));
  }

  private boolean isValidProizvodjac(RobaLightDto robaLightDto) {
    return TecDocProizvodjaci.pronadjiPoNazivu(robaLightDto.getProizvodjac().getProid()) != null;
  }

  public void handleRobaDto(
      RobaLightDto robaLightDto, Partner partner, List<RobaLightDto> asociraniArtikli) {
    List<TecDocAtributi> tecDocAtributi =
        tecDocService.vratiTecDocAtributePrekoRobeId(robaLightDto.getRobaid());

    if (tecDocAtributi.isEmpty()) {
      tecDocService.batchVracanjeICuvanjeTDAtributa(Collections.singletonList(robaLightDto));
      tecDocAtributi = tecDocService.vratiTecDocAtributePrekoRobeId(robaLightDto.getRobaid());
    }

    postaviSlikuIzAtributa(robaLightDto, tecDocAtributi);
    postaviCenuIRabat(robaLightDto, partner);
    asociraniArtikli.add(robaLightDto);
  }

  public void setujSliku(RobaExpandedDto detaljiDto, List<RobaBrojeviDto> tdBrojevi) {
    List<TecDocAtributi> tecDocAtributi =
        tecDocService.vratiTecDocAtributePrekoRobeId(detaljiDto.getRobaid());
    // When TecDoc provides inline images we no longer stream raw bytes—fall back to filesystem.
  }
}
