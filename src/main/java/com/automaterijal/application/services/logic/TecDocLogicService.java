package com.automaterijal.application.services.logic;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.tecdoc.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocLogicService {

  @Autowired TecDocMapper tecDocMapper;

  @Autowired TecDocAtributiRepository tecDocAtributiRepository;

  @Autowired TecDocClient tecDocClient;

  @Value("${roba.slika.tdPrefix}")
  String putDoSlike;

  public void batchVracanjeICuvanjeTDAtributa(List<RobaLightDto> robaLightDtos) {
    List<Long> artikliBezSacuvanihPodataka = new ArrayList<>();

    // Priprema podataka
    prepareData(robaLightDtos, artikliBezSacuvanihPodataka);

    // Obrada artikala bez sačuvanih podataka
    if (!artikliBezSacuvanihPodataka.isEmpty()) {
      processArtikliBezSacuvanihPodataka(artikliBezSacuvanihPodataka, robaLightDtos);
    }
  }

  // 1. Priprema podataka
  private void prepareData(
      List<RobaLightDto> robaLightDtos, List<Long> artikliBezSacuvanihPodataka) {
    final List<TecDocAtributi> data =
        tecDocAtributiRepository.findByRobaIdIn(
            robaLightDtos.stream().map(RobaLightDto::getRobaid).toList());
    robaLightDtos.forEach(
        robaDto -> {
          TecDocProizvodjaci tdProizvodjaci =
              TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid());
          if (tdProizvodjaci != null) {
            String katBr =
                TecDocProizvodjaci.restoreOriginalCatalogNumber(
                    tdProizvodjaci.isUseAlternativeNumber() && robaDto.getKatbrpro() != null
                        ? robaDto.getKatbrpro()
                        : robaDto.getKatbr(),
                    tdProizvodjaci);
            if (shouldFetchTecDocData(data, robaDto.getRobaid())) {
              fetchTecDocData(robaDto, tdProizvodjaci, katBr, artikliBezSacuvanihPodataka);
            }
          }
        });
  }

  // 2. Provera da li treba dohvatiti TecDoc podatke
  private boolean shouldFetchTecDocData(List<TecDocAtributi> data, Long requiredRobaId) {
    return data.stream()
        .filter(tecDocAtributi -> tecDocAtributi.getRobaId().equals(requiredRobaId))
        .toList()
        .isEmpty();
  }

  // 3. Dohvatanje TecDoc podataka
  private void fetchTecDocData(
      RobaLightDto robaLightDto,
      TecDocProizvodjaci tdProizvodjaci,
      String katBr,
      List<Long> artikliBezSacuvanihPodataka) {

    List<ArticleDirectSearchAllNumbersWithStateRecord> directSearch =
        TecDocProizvodjaci.getAllTecDocIdsByName(robaLightDto.getProizvodjac().getProid()).stream()
            .flatMap(tdId -> tecDocClient.tecDocPretraga(katBr, tdId, 0).stream())
            .collect(Collectors.toList());

    if (directSearch.isEmpty()) {
      directSearch = fallbackSearch(katBr, tdProizvodjaci);
    }

    processDirectSearch(directSearch, katBr, artikliBezSacuvanihPodataka, robaLightDto);
  }

  // 4. Fallback pretraga za TecDoc podatke
  private List<ArticleDirectSearchAllNumbersWithStateRecord> fallbackSearch(
      String katBr, TecDocProizvodjaci tdProizvodjaci) {
    return tdProizvodjaci != TecDocProizvodjaci.HP
        ? tecDocClient.tecDocPretraga(katBr, tdProizvodjaci.getTecDocId(), 2)
        : tecDocClient.tecDocPretraga(katBr, tdProizvodjaci.getTecDocId(), 1);
  }

  // 5. Obrada rezultata pretrage
  private void processDirectSearch(
      List<ArticleDirectSearchAllNumbersWithStateRecord> directSearch,
      String katBr,
      List<Long> artikliBezSacuvanihPodataka,
      RobaLightDto robaLightDto) {
    if (!directSearch.isEmpty()) {
      Long tdArticleId = findMatchingArticleId(directSearch, katBr);
      if (tdArticleId != null) {
        artikliBezSacuvanihPodataka.add(tdArticleId);
      }
    } else {
      saveEmptyTecDocRecord(robaLightDto);
    }
  }

  // 6. Pronalaženje odgovarajućeg artikla
  private Long findMatchingArticleId(
      List<ArticleDirectSearchAllNumbersWithStateRecord> directSearch, String katBr) {
    // Step 1: Filter articles based on number matching and number type
    List<ArticleDirectSearchAllNumbersWithStateRecord> filtered =
        directSearch.stream()
            .filter(
                rekord ->
                    daLiSeBrojeviPodudaraju(katBr, rekord.getArticleNo(), null)
                        || rekord.getNumberType() == 2
                        || rekord.getNumberType() == 0)
            .toList();

    // Step 2: Extract articles with stateId = 1
    List<ArticleDirectSearchAllNumbersWithStateRecord> state1 =
        filtered.stream().filter(article -> article.getArticleStateId() == 1).toList();

    // Step 3: Return first match from state1, or fallback to first match from filtered list
    return state1.stream()
        .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
        .findFirst()
        .orElseGet(
            () ->
                filtered.stream()
                    .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
                    .findFirst()
                    .orElse(null));
  }

  // 7. Čuvanje praznog TecDoc zapisa
  private void saveEmptyTecDocRecord(RobaLightDto robaLightDto) {
    TecDocAtributi atributi = new TecDocAtributi();
    atributi.setRobaId(robaLightDto.getRobaid());
    atributi.setKatbr(robaLightDto.getKatbr());
    sacuvajTecDocAtribute(atributi);
    log.info(
        "Artikal katBr {} - proizvodjac {} ne postoji u TD",
        robaLightDto.getKatbr(),
        robaLightDto.getProizvodjac().getProid());
  }

  // 8. Obrada artikala bez sačuvanih podataka
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

  // 9. Obrada detalja artikla
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
          findMatchingRobaDto(directArticle, robaLightDtos, alternativeManufactureNumber);

      dtoOptional.ifPresent(
          robaDto -> processArticleAttributesAndImages(detalji, directArticle, robaDto));
    }
  }

  // 10. Pronalaženje odgovarajućeg RobaLightDto
  private Optional<RobaLightDto> findMatchingRobaDto(
      ArticleDirectSearchById3Record directArticle,
      List<RobaLightDto> robaLightDtos,
      List<String> alternativeManufactureNumber) {
    return robaLightDtos.stream()
        .filter(
            robaDto -> {
              TecDocProizvodjaci tecDocProizvodjaci =
                  TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid());

              if (tecDocProizvodjaci == null) {
                return false;
              }

              return daLiSeBrojeviPodudaraju(
                  tecDocProizvodjaci.isUseAlternativeNumber() && robaDto.getKatbrpro() != null
                      ? robaDto.getKatbrpro()
                      : robaDto.getKatbr(),
                  directArticle.getArticleNo().replace(" ", ""),
                  tecDocProizvodjaci);
            })
        .findFirst()
        .or(
            () ->
                robaLightDtos.stream()
                    .filter(
                        robaDto ->
                            alternativeManufactureNumber.stream()
                                .anyMatch(
                                    katBr -> {
                                      TecDocProizvodjaci tecDocProizvodjaci =
                                          TecDocProizvodjaci.pronadjiPoNazivu(
                                              robaDto.getProizvodjac().getProid());

                                      if (tecDocProizvodjaci == null) {
                                        return false;
                                      }

                                      return daLiSeBrojeviPodudaraju(
                                          tecDocProizvodjaci.isUseAlternativeNumber()
                                                  && robaDto.getKatbrpro() != null
                                              ? robaDto.getKatbrpro()
                                              : robaDto.getKatbr(),
                                          katBr.replace(" ", ""),
                                          TecDocProizvodjaci.pronadjiPoNazivu(
                                              robaDto.getProizvodjac().getProid()));
                                    }))
                    .findFirst());
  }

  // 11. Obrada atributa i slika
  private void processArticleAttributesAndImages(
      ArticlesByIds6Record detalji,
      ArticleDirectSearchById3Record directArticle,
      RobaLightDto robaLightDto) {
    saveAttributes(detalji.getArticleAttributes(), robaLightDto, directArticle);
    saveImages(detalji.getArticleThumbnails(), robaLightDto, directArticle);
  }

  // 12. Čuvanje atributa
  private void saveAttributes(
      AssignedArticleAttributs2RecordSeq attributes,
      RobaLightDto robaLightDto,
      ArticleDirectSearchById3Record directArticle) {
    if (attributes != null && attributes.getArray() != null) {
      attributes
          .getArray()
          .forEach(
              att -> {
                TecDocAtributi atributi =
                    tecDocMapper.map(
                        att,
                        robaLightDto,
                        directArticle.getArticleId(),
                        TecDocProizvodjaci.pronadjiPoNazivu(
                                robaLightDto.getProizvodjac().getProid())
                            .getTecDocId());
                sacuvajTecDocAtribute(atributi);
              });
    }
  }

  // 13. Čuvanje slika
  private void saveImages(
      ThumbnailByArticleIdRecordSeq thumbnails,
      RobaLightDto robaLightDto,
      ArticleDirectSearchById3Record directArticle) {
    if (thumbnails != null && thumbnails.getArray() != null && !thumbnails.getArray().isEmpty()) {
      ThumbnailByArticleIdRecord thumbnail = thumbnails.getArray().get(0);
      if (thumbnail.getThumbDocId() != null) {
        byte[] dokumentSlike = vratiDokument(thumbnail.getThumbDocId(), 0);
        BufferedImage bImage = readImage(dokumentSlike);
        if (bImage != null) {
          saveImageFile(bImage, robaLightDto.getRobaid());
          cacheImageInDatabase(robaLightDto, thumbnail, dokumentSlike, directArticle);
        }
      }
    }
  }

  // 14. Čitanje slike iz bajtova
  private BufferedImage readImage(byte[] dokumentSlike) {
    try (ByteArrayInputStream bis = new ByteArrayInputStream(dokumentSlike)) {
      return ImageIO.read(bis);
    } catch (IOException e) {
      log.error("Error reading image", e);
      return null;
    }
  }

  // 15. Čuvanje slike u fajl
  private void saveImageFile(BufferedImage image, Long robaId) {
    try {
      ImageIO.write(image, "jpg", new File(putDoSlike + robaId + ".jpg"));
    } catch (IOException e) {
      log.error("Error saving image file", e);
    }
  }

  // 16. Kesiranje slike u bazi
  private void cacheImageInDatabase(
      RobaLightDto robaLightDto,
      ThumbnailByArticleIdRecord thumbnail,
      byte[] dokumentSlike,
      ArticleDirectSearchById3Record directArticle) {
    TecDocAtributi atributi =
        tecDocMapper.map(
            thumbnail,
            robaLightDto,
            directArticle.getArticleId(),
            TecDocProizvodjaci.pronadjiPoNazivu(robaLightDto.getProizvodjac().getProid())
                .getTecDocId());
    sacuvajTecDocAtribute(atributi);

    SlikaDto slikaDto = new SlikaDto();
    slikaDto.setSlikeByte(dokumentSlike);
    slikaDto.setUrl(false);
    robaLightDto.setSlika(slikaDto);
  }

  private boolean daLiSeBrojeviPodudaraju(
      String katBr, String tecDocKatBr, TecDocProizvodjaci tecDocProizvodjaci) {
    if (katBr == null || tecDocKatBr == null) {
      return false;
    }
    katBr = TecDocProizvodjaci.restoreOriginalCatalogNumber(katBr, tecDocProizvodjaci);
    tecDocKatBr = tecDocKatBr.replace("[-,./]", "").replace("\\s+", "");
    return katBr.equalsIgnoreCase(tecDocKatBr);
  }

  public byte[] vratiDokument(String dokumentId, Integer tipSlike) {
    return tecDocClient.vratiDokument(dokumentId, tipSlike);
  }

  public void sacuvajTecDocAtribute(TecDocAtributi atributi) {
    tecDocAtributiRepository.save(atributi);
  }
}
