package com.automaterijal.application.services.logic;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.services.tecdoc.TecDocAttributeService;
import com.automaterijal.application.services.tecdoc.TecDocDocumentService;
import com.automaterijal.application.services.tecdoc.TecDocImageService;
import com.automaterijal.application.services.tecdoc.TecDocSearchService;
import com.automaterijal.application.tecdoc.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocLogicService {
  @Autowired TecDocClient tecDocClient;
  @Autowired TecDocImageService tecDocImageService;
  @Autowired TecDocSearchService tecDocSearchService;
  @Autowired TecDocAttributeService tecDocAttributeService;
  @Autowired TecDocDocumentService tecDocDocumentService;

  public void fetchAndSaveTecDocAttributes(List<RobaLightDto> robaLightDtos) {
    List<Long> artikliBezSacuvanihPodataka = new ArrayList<>();

    // Priprema podataka
    prepareData(robaLightDtos, artikliBezSacuvanihPodataka);

    // Obrada artikala bez sačuvanih podataka
    if (!artikliBezSacuvanihPodataka.isEmpty()) {
      processArtikliBezSacuvanihPodataka(artikliBezSacuvanihPodataka, robaLightDtos);
    }
  }

  private void prepareData(
      List<RobaLightDto> robaLightDtos, List<Long> artikliBezSacuvanihPodataka) {
    List<Long> ids = robaLightDtos.stream().map(RobaLightDto::getRobaid).toList();
    final List<TecDocAtributi> data = tecDocAttributeService.findByRobaIds(ids);

    for (RobaLightDto dto : robaLightDtos) {
      TecDocProizvodjaci tdProizvodjaci =
          TecDocProizvodjaci.pronadjiPoNazivu(dto.getProizvodjac().getProid());
      if (tdProizvodjaci != null) {
        String katBr =
            TecDocProizvodjaci.restoreOriginalCatalogNumber(
                tdProizvodjaci.isUseAlternativeNumber() && dto.getKatbrpro() != null
                    ? dto.getKatbrpro()
                    : dto.getKatbr(),
                tdProizvodjaci);

        boolean tecDocDataMissing = shouldFetchTecDocData(data, dto.getRobaid());
        if (tecDocDataMissing) {
          fetchTecDocData(dto, tdProizvodjaci, katBr, artikliBezSacuvanihPodataka);
        }
      }
    }
  }

  private boolean shouldFetchTecDocData(List<TecDocAtributi> data, Long requiredRobaId) {
    return data.stream()
        .filter(tecDocAtributi -> tecDocAtributi.getRobaId().equals(requiredRobaId))
        .toList()
        .isEmpty();
  }

  private void fetchTecDocData(
      RobaLightDto robaLightDto,
      TecDocProizvodjaci tdProizvodjaci,
      String katBr,
      List<Long> artikliBezSacuvanihPodataka) {

    Long tdArticleId = tecDocSearchService.searchArticle(robaLightDto, tdProizvodjaci, katBr);

    if (tdArticleId != null) {
      artikliBezSacuvanihPodataka.add(tdArticleId);
    } else {
      saveEmptyTecDocRecord(robaLightDto);
    }
  }

  private void saveEmptyTecDocRecord(RobaLightDto robaLightDto) {
    TecDocAtributi atributi = new TecDocAtributi();
    atributi.setRobaId(robaLightDto.getRobaid());
    atributi.setKatbr(robaLightDto.getKatbr());
    tecDocAttributeService.saveAttribute(atributi);
    log.info(
        "Artikal katBr {} - proizvodjac {} ne postoji u TD",
        robaLightDto.getKatbr(),
        robaLightDto.getProizvodjac().getProid());
  }

  private void processArtikliBezSacuvanihPodataka(
      List<Long> artikliBezSacuvanihPodataka, List<RobaLightDto> robaLightDtos) {
    for (int i = 0; i < artikliBezSacuvanihPodataka.size(); i += 24) {
      List<Long> artiklId =
          artikliBezSacuvanihPodataka.subList(
              i, Math.min(i + 24, artikliBezSacuvanihPodataka.size()));
      List<ArticlesByIds6Record> detaljiArtikala = tecDocClient.vratiDetaljeArtikla(artiklId);

      detaljiArtikala.forEach(detalji -> processArticleDetails(detalji, robaLightDtos));
    }
  }

  private void processArticleDetails(
      ArticlesByIds6Record detalji, List<RobaLightDto> robaLightDtos) {
    if (detalji.getDirectArticle() != null) {
      ArticleDirectSearchById3Record directArticle = detalji.getDirectArticle();
      List<String> alternativeManufactureNumber =
          detalji.getUsageNumbers2() != null
              ? detalji.getUsageNumbers2().getArray().stream()
                  .map(UsageNumbers2Record::getUsageNumber)
                  .toList()
              : List.of();
      Optional<RobaLightDto> dtoOptional =
          tecDocSearchService.findMatchingRoba(
              directArticle, robaLightDtos, alternativeManufactureNumber);

      dtoOptional.ifPresent(
          robaDto -> processArticleAttributesAndImages(detalji, directArticle, robaDto));
    }
  }

  private void processArticleAttributesAndImages(
      ArticlesByIds6Record details,
      ArticleDirectSearchById3Record directArticle,
      RobaLightDto robaLightDto) {
    saveArticleAttributes(details, robaLightDto, directArticle);
    saveArticleImageIfAvailable(details, robaLightDto, directArticle);
  }

  private void saveArticleAttributes(
      ArticlesByIds6Record details,
      RobaLightDto robaLightDto,
      ArticleDirectSearchById3Record directArticle) {
    tecDocAttributeService.saveAttributes(
        details.getArticleAttributes(), robaLightDto, directArticle);
  }

  private void saveArticleImageIfAvailable(
      ArticlesByIds6Record details,
      RobaLightDto robaLightDto,
      ArticleDirectSearchById3Record directArticle) {
    ThumbnailByArticleIdRecordSeq thumbnails = details.getArticleThumbnails();

    if (thumbnails != null
        && !thumbnails.getArray().isEmpty()
        && thumbnails.getArray().get(0).getThumbDocId() != null) {

      String docId = thumbnails.getArray().get(0).getThumbDocId();
      byte[] document = tecDocDocumentService.getDocument(docId, 0);

      tecDocImageService.saveImage(thumbnails, robaLightDto, directArticle, document);
    }
  }
}
