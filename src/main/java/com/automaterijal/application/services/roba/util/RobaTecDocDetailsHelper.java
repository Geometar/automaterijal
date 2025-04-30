package com.automaterijal.application.services.roba.util;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaBrojeviDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.dto.tecdoc.TecDocDokumentacija;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleOENumbersRecord;
import com.automaterijal.application.tecdoc.ArticlesByIds6Record;
import com.automaterijal.application.tecdoc.AssignedArticleAttributs2Record;
import java.util.*;
import java.util.stream.Collectors;
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
public class RobaTecDocDetailsHelper {
  @NonNull final TecDocMapper tecDocMapper;
  @NonNull final TecDocService tecDocService;

  public static void setujTehnickeDetalje(
      RobaDetaljiDto detaljiDto, List<ArticlesByIds6Record> tecDocDetalji) {
    List<AssignedArticleAttributs2Record> atributiRecord =
        tecDocDetalji.stream()
            .filter(rekord -> rekord.getArticleAttributes() != null)
            .map(ArticlesByIds6Record::getArticleAttributes)
            .flatMap(recordSeq -> recordSeq.getArray().stream())
            .toList();

    List<RobaTehnickiOpisDto> tehnickiOpis = new ArrayList<>();
    for (AssignedArticleAttributs2Record rekord : atributiRecord) {
      RobaTehnickiOpisDto tehnickiOpisDto = new RobaTehnickiOpisDto();
      tehnickiOpisDto.setVrednost(rekord.getAttrValue());
      tehnickiOpisDto.setOznaka(rekord.getAttrShortName());
      tehnickiOpisDto.setJedinica(rekord.getAttrUnit());
      tehnickiOpis.add(tehnickiOpisDto);
    }

    if (!tehnickiOpis.isEmpty()) {
      detaljiDto.setTehnickiOpis(tehnickiOpis);
    }
  }

  public void setujDokumentaciju(
      RobaDetaljiDto detaljiDto, List<ArticlesByIds6Record> tecDocDetalji) {
    List<TecDocDokumentacija> dokumenta =
        tecDocDetalji.stream()
            .filter(rekord -> rekord.getArticleDocuments() != null)
            .map(ArticlesByIds6Record::getArticleDocuments)
            .filter(rekord -> rekord.getArray() != null)
            .flatMap(recordSeq -> recordSeq.getArray().stream())
            .filter(articleDocuments2Record -> articleDocuments2Record.getDocTypeId() != 1L)
            .map(tecDocMapper::map)
            .toList();
    Map<String, List<TecDocDokumentacija>> mapaDokumentacije = new HashMap<>();
    for (TecDocDokumentacija dokument : dokumenta) {
      if (dokument.getDocFileTypeName().contains("PDF")) {
        dokument.setDocId(dokument.getDocId());
      }
      if (dokument.getDocTypeName().equals("Tehnički crtež")) {
        dokument.setDokument(tecDocService.vratiDokument(dokument.getDocId(), 0));
      }
      if (dokument.getDocFileTypeName().equals("URL")) {
        dokument.setDocUrl(dokument.getDocUrl());
      }
    }
    if (!dokumenta.isEmpty()) {
      mapaDokumentacije =
          dokumenta.stream().collect(Collectors.groupingBy(TecDocDokumentacija::getDocTypeName));

      mapaDokumentacije.remove("Slika");
    }
    if (!mapaDokumentacije.isEmpty()) {
      mapaDokumentacije.replaceAll(
          (kljuc, dokumenti) -> {
            List<TecDocDokumentacija> result = new ArrayList<>();

            List<TecDocDokumentacija> urlDocs = new ArrayList<>();
            for (TecDocDokumentacija doc : dokumenti) {
              if (doc.getDocFileTypeName().toUpperCase().contains("URL")) {
                urlDocs.add(doc);
              } else {
                result.add(doc); // keep non-URL documents
              }
            }

            if (!urlDocs.isEmpty()) {
              TecDocDokumentacija selected =
                  urlDocs.stream()
                      .filter(
                          d -> {
                            String url = d.getDocUrl().toLowerCase();
                            return url.contains("sr")
                                || url.contains("serbian")
                                || url.contains("rs");
                          })
                      .findFirst()
                      .orElseGet(
                          () ->
                              urlDocs.stream()
                                  .filter(
                                      d -> {
                                        String url = d.getDocUrl().toLowerCase();
                                        return url.contains("en") || url.contains("english");
                                      })
                                  .findFirst()
                                  .orElse(urlDocs.get(0)) // fallback to first URL
                          );

              result.add(selected);
            }

            return result;
          });

      detaljiDto.setDokumentacija(mapaDokumentacije);
    }
  }

  public static List<RobaBrojeviDto> setujOriginalneBrojeve(
      RobaDetaljiDto detaljiDto, List<ArticlesByIds6Record> tecDocDetalji) {
    List<ArticleOENumbersRecord> oeNumbersRecords =
        tecDocDetalji.stream()
            .filter(rekord -> rekord.getOenNumbers() != null)
            .map(ArticlesByIds6Record::getOenNumbers)
            .flatMap(recordSeq -> recordSeq.getArray().stream())
            .toList();

    List<RobaBrojeviDto> tdBrojevi = new ArrayList<>();
    for (ArticleOENumbersRecord rekord : oeNumbersRecords) {
      RobaBrojeviDto dto = new RobaBrojeviDto();
      dto.setProizvodjac(rekord.getBrandName());
      dto.setFabrBroj(rekord.getOeNumber());
      tdBrojevi.add(dto);
    }

    if (!tdBrojevi.isEmpty()) {
      detaljiDto.setTdBrojevi(tdBrojevi);
    }
    return tdBrojevi;
  }

  public Long vratiTecDocArticleId(RobaDetaljiDto detaljiDto) {
    List<TecDocAtributi> tecDocAtributi =
        tecDocService.vratiTecDocAtributePrekoRobeId(detaljiDto.getRobaid());
    TecDocProizvodjaci tecDocProizvodjaci =
        TecDocProizvodjaci.pronadjiPoNazivu(detaljiDto.getProizvodjac().getProid());
    Long tecDocArticleId = null;
    if (tecDocAtributi.isEmpty() && tecDocProizvodjaci != null) {
      Optional<Long> tecDocArticleIdOptional =
          tecDocService
              .tecDocPretragaPoTrazenojReci(
                  detaljiDto.getKatbr(), tecDocProizvodjaci.getTecDocId(), 0)
              .stream()
              .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
              .findFirst();
      if (tecDocArticleIdOptional.isPresent()) {
        tecDocArticleId = tecDocArticleIdOptional.get();
      }
    } else if (!tecDocAtributi.isEmpty()) {
      Optional<Long> tecDocArticleIdOptional =
          tecDocAtributi.stream()
              .filter(atributi -> atributi.getTecDocArticleId() != null)
              .map(TecDocAtributi::getTecDocArticleId)
              .findFirst();
      if (tecDocArticleIdOptional.isPresent()) {
        tecDocArticleId = tecDocArticleIdOptional.get();
      }
    }
    return tecDocArticleId;
  }
}
