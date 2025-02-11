package com.automaterijal.application.services;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import com.automaterijal.application.tecdoc.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
public class TecDocService {

  @Autowired TecDocClient tecDocClient;

  @Autowired TecDocAtributiRepository tecDocAtributiRepository;

  @Autowired TecDocBrandsRepository tecDocBrandsRepository;

  @Autowired TecDocMapper tecDocMapper;

  @Value("${roba.slika.tdPrefix}")
  String putDoSlike;

  //    ******************** TecDoc Pretraga  ********************

  public List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocPretragaPoTrazenojReci(
      String trazenaRec, Integer brandId, Integer numbertype) {
    return tecDocClient.tecDocPretraga(trazenaRec, brandId, numbertype);
  }

  public List<ArticlesByIds6Record> vratiDetaljeArtikla(Long articleId) {
    return tecDocClient.vratiDetaljeArtikla(Arrays.asList(articleId));
  }

  //    ******************** TecDoc Atributi  ********************

  public List<TecDocAtributi> vratiTecDocAtributePrekoRobeId(Long robaId) {
    return tecDocAtributiRepository.findByRobaId(robaId);
  }

  public List<TecDocAtributi> vratiTecDocAtributePrekoRobeIds(List<Long> robaIds) {
    return tecDocAtributiRepository.findByRobaIdIn(robaIds);
  }

  public byte[] vratiDokument(String dokumentId, Integer tipSlike) {
    return tecDocClient.vratiDokument(dokumentId, tipSlike);
  }

  public void sacuvajTecDocAtribute(TecDocAtributi atributi) {
    tecDocAtributiRepository.save(atributi);
  }

  //    ******************** TecDoc Brendovi  ********************

  public Optional<TecDocBrands> vratiTecDocBrendovePrekoProId(String proId) {
    return tecDocBrandsRepository.findById(proId);
  }

  //    ******************** TecDoc Logika  ********************
  public void batchVracanjeICuvanjeTDAtributa(List<RobaDto> robaDtos) {
    List<Long> artikliBezSacuvanihPodataka = new ArrayList<>();

    // Priprema podataka
    prepareData(robaDtos, artikliBezSacuvanihPodataka);

    // Obrada artikala bez sačuvanih podataka
    if (!artikliBezSacuvanihPodataka.isEmpty()) {
      processArtikliBezSacuvanihPodataka(artikliBezSacuvanihPodataka, robaDtos);
    }
  }

  // 1. Priprema podataka
  private void prepareData(List<RobaDto> robaDtos, List<Long> artikliBezSacuvanihPodataka) {
    final List<TecDocAtributi> data =
        tecDocAtributiRepository.findByRobaIdIn(robaDtos.stream().map(RobaDto::getRobaid).toList());
    robaDtos.forEach(
        robaDto -> {
          TecDocProizvodjaci tdProizvodjaci =
              TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid());
          if (tdProizvodjaci != null) {
            String katBr = getKataloskiBroj(robaDto.getKatbr(), tdProizvodjaci);
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
      RobaDto robaDto,
      TecDocProizvodjaci tdProizvodjaci,
      String katBr,
      List<Long> artikliBezSacuvanihPodataka) {
    List<ArticleDirectSearchAllNumbersWithStateRecord> directSearch =
        tecDocClient.tecDocPretraga(katBr, tdProizvodjaci.getTecDocId(), 0);

    if (directSearch.isEmpty()) {
      directSearch = fallbackSearch(katBr, tdProizvodjaci);
    }

    processDirectSearch(directSearch, katBr, artikliBezSacuvanihPodataka, robaDto);
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
      RobaDto robaDto) {
    if (!directSearch.isEmpty()) {
      Long tdArticleId = findMatchingArticleId(directSearch, katBr);
      if (tdArticleId != null) {
        artikliBezSacuvanihPodataka.add(tdArticleId);
      }
    } else {
      saveEmptyTecDocRecord(robaDto);
    }
  }

  // 6. Pronalaženje odgovarajućeg artikla
  private Long findMatchingArticleId(
      List<ArticleDirectSearchAllNumbersWithStateRecord> directSearch, String katBr) {
    return directSearch.stream()
        .filter(
            rekord ->
                daLiSeBrojeviPodudaraju(katBr, rekord.getArticleNo(), null)
                    || rekord.getNumberType() == 2
                    || rekord.getNumberType() == 0)
        .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
        .findFirst()
        .orElse(null);
  }

  // 7. Čuvanje praznog TecDoc zapisa
  private void saveEmptyTecDocRecord(RobaDto robaDto) {
    TecDocAtributi atributi = new TecDocAtributi();
    atributi.setRobaId(robaDto.getRobaid());
    atributi.setKatbr(robaDto.getKatbr());
    sacuvajTecDocAtribute(atributi);
    log.info(
        "Artikal katBr {} - proizvodjac {} ne postoji u TD",
        robaDto.getKatbr(),
        robaDto.getProizvodjac().getProid());
  }

  // 8. Obrada artikala bez sačuvanih podataka
  private void processArtikliBezSacuvanihPodataka(
      List<Long> artikliBezSacuvanihPodataka, List<RobaDto> robaDtos) {
    for (int i = 0; i < artikliBezSacuvanihPodataka.size(); i += 24) {
      List<Long> artiklId =
          artikliBezSacuvanihPodataka.subList(
              i, Math.min(i + 24, artikliBezSacuvanihPodataka.size()));
      List<ArticlesByIds6Record> detaljiArtikala = tecDocClient.vratiDetaljeArtikla(artiklId);

      detaljiArtikala.forEach(detalji -> processArticleDetails(detalji, robaDtos));
    }
  }

  // 9. Obrada detalja artikla
  private void processArticleDetails(ArticlesByIds6Record detalji, List<RobaDto> robaDtos) {
    if (detalji.getDirectArticle() != null) {
      ArticleDirectSearchById3Record directArticle = detalji.getDirectArticle();
      List<String> alternativeManufactureNumber =
          detalji.getUsageNumbers2() != null
              ? detalji.getUsageNumbers2().getArray().stream()
                  .map(UsageNumbers2Record::getUsageNumber)
                  .toList()
              : List.of();
      Optional<RobaDto> dtoOptional =
          findMatchingRobaDto(directArticle, robaDtos, alternativeManufactureNumber);

      dtoOptional.ifPresent(
          robaDto -> processArticleAttributesAndImages(detalji, directArticle, robaDto));
    }
  }

  // 10. Pronalaženje odgovarajućeg RobaDto
  private Optional<RobaDto> findMatchingRobaDto(
      ArticleDirectSearchById3Record directArticle,
      List<RobaDto> robaDtos,
      List<String> alternativeManufactureNumber) {
    return robaDtos.stream()
        .filter(
            robaDto ->
                daLiSeBrojeviPodudaraju(
                    robaDto.getKatbr(),
                    directArticle.getArticleNo().replace(" ", ""),
                    TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid())))
        .findFirst()
        .or(
            () ->
                robaDtos.stream()
                    .filter(
                        robaDto ->
                            alternativeManufactureNumber.stream()
                                .anyMatch(
                                    katBr ->
                                        daLiSeBrojeviPodudaraju(
                                            robaDto.getKatbr(),
                                            katBr.replace(" ", ""),
                                            TecDocProizvodjaci.pronadjiPoNazivu(
                                                robaDto.getProizvodjac().getProid()))))
                    .findFirst());
  }

  // 11. Obrada atributa i slika
  private void processArticleAttributesAndImages(
      ArticlesByIds6Record detalji, ArticleDirectSearchById3Record directArticle, RobaDto robaDto) {
    saveAttributes(detalji.getArticleAttributes(), robaDto, directArticle);
    saveImages(detalji.getArticleThumbnails(), robaDto, directArticle);
  }

  // 12. Čuvanje atributa
  private void saveAttributes(
      AssignedArticleAttributs2RecordSeq attributes,
      RobaDto robaDto,
      ArticleDirectSearchById3Record directArticle) {
    if (attributes != null && attributes.getArray() != null) {
      attributes
          .getArray()
          .forEach(
              att -> {
                TecDocAtributi atributi =
                    tecDocMapper.map(
                        att,
                        robaDto,
                        directArticle.getArticleId(),
                        TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid())
                            .getTecDocId());
                sacuvajTecDocAtribute(atributi);
              });
    }
  }

  // 13. Čuvanje slika
  private void saveImages(
      ThumbnailByArticleIdRecordSeq thumbnails,
      RobaDto robaDto,
      ArticleDirectSearchById3Record directArticle) {
    if (thumbnails != null && thumbnails.getArray() != null && !thumbnails.getArray().isEmpty()) {
      ThumbnailByArticleIdRecord thumbnail = thumbnails.getArray().get(0);
      if (thumbnail.getThumbDocId() != null) {
        byte[] dokumentSlike = vratiDokument(thumbnail.getThumbDocId(), 0);
        BufferedImage bImage = readImage(dokumentSlike);
        if (bImage != null) {
          saveImageFile(bImage, robaDto.getRobaid());
          cacheImageInDatabase(robaDto, thumbnail, dokumentSlike, directArticle);
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
      RobaDto robaDto,
      ThumbnailByArticleIdRecord thumbnail,
      byte[] dokumentSlike,
      ArticleDirectSearchById3Record directArticle) {
    TecDocAtributi atributi =
        tecDocMapper.map(
            thumbnail,
            robaDto,
            directArticle.getArticleId(),
            TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid()).getTecDocId());
    sacuvajTecDocAtribute(atributi);

    SlikaDto slikaDto = new SlikaDto();
    slikaDto.setSlikeByte(dokumentSlike);
    slikaDto.setUrl(false);
    robaDto.setSlika(slikaDto);
  }

  private String getKataloskiBroj(String katBr, TecDocProizvodjaci tdProizvodjaci) {
    if (tdProizvodjaci != null && tdProizvodjaci.getDodatak() != null) {
      return katBr.replaceAll(tdProizvodjaci.getDodatak(), "");
    }
    return katBr;
  }

  private boolean daLiSeBrojeviPodudaraju(
      String katBr, String tecDocKatBr, TecDocProizvodjaci tecDocProizvodjaci) {
    if (katBr == null || tecDocKatBr == null) {
      return false;
    }
    if (tecDocProizvodjaci != null && tecDocProizvodjaci.getDodatak() != null) {
      katBr = katBr.replaceAll(tecDocProizvodjaci.getDodatak(), "");
    }
    katBr = katBr.replace("[-,./]", "").replace("\\s+", "").replace("-LUČ", "");
    tecDocKatBr = tecDocKatBr.replace("[-,./]", "").replace("\\s+", "");
    return katBr.equalsIgnoreCase(tecDocKatBr);
  }
}
