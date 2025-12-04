package com.automaterijal.application.services.roba.processor;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.services.roba.util.RobaHelper;
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
  @NonNull final RobaHelper robaHelper;

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
    robaHelper.markOutOfStockIfPriceMissing(robaLightDto);
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

    postaviCenuIRabat(robaLightDto, partner);
    asociraniArtikli.add(robaLightDto);
  }
}
