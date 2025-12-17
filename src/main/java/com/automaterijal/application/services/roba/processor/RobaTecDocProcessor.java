package com.automaterijal.application.services.roba.processor;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.services.tecdoc.TecDocPreviewService;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.CriteriaRecord;
import com.automaterijal.application.tecdoc.TradeNumberDetailsRecord;
import java.util.*;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaTecDocProcessor {

  @Autowired TecDocPreviewService tecDocPreviewService;

  public void filterIfNotMatchingWithTecDoc(
      List<ArticleRecord> articles, List<RobaLightDto> robaLightDtos) {
    List<RobaLightDto> removable =
        robaLightDtos.stream()
            .filter(robaDto -> isNotMatchingWithTecDoc(articles, robaDto))
            .collect(Collectors.toList());

    removable.forEach(
        robaDto ->
            log.error(
                "Artikal ne odgovara tekdoku "
                    + robaDto.getKatbr()
                    + " proizvodjac "
                    + robaDto.getProizvodjac()));

    robaLightDtos.removeAll(removable);
  }

  private boolean isNotMatchingWithTecDoc(List<ArticleRecord> articles, RobaLightDto robaLightDto) {
    return !isMatchingWithTecDoc(articles, robaLightDto);
  }

  private boolean isMatchingWithTecDoc(List<ArticleRecord> articles, RobaLightDto robaLightDto) {
    TecDocProizvodjaci tecDocProizvodjaci =
        TecDocProizvodjaci.findByName(robaLightDto.getProizvodjac().getProid());
    if (tecDocProizvodjaci == null) {
      return false; // Not a TecDoc article
    }

    String katBr =
        TecDocProizvodjaci.restoreOriginalCatalogNumber(
            robaLightDto.getKatbr(), tecDocProizvodjaci);
    List<Long> tdBrandIds =
        TecDocProizvodjaci.getAllTecDocIdsByName(robaLightDto.getProizvodjac().getProid());
    return articles.stream()
        .anyMatch(
            articleRecord -> {
              if (!tdBrandIds.contains(articleRecord.getDataSupplierId())) {
                return false;
              }

              if (articleRecord.getArticleNumber().equals(katBr)) {
                return true;
              }

              return tecDocProizvodjaci.isUseTradeNumber()
                  && articleRecord.getTradeNumbersDetails().stream()
                      .filter(TradeNumberDetailsRecord::isIsImmediateDisplay)
                      .map(TradeNumberDetailsRecord::getTradeNumber)
                      .anyMatch(katBr::equals);
            });
  }

  public void filterIfNotMatchingMainArticle(List<RobaLightDto> robaLightDtos) {
    // Partition RobaDtos into TecDoc-mapped and non-TecDoc-mapped lists
    Map<Boolean, List<RobaLightDto>> partitioned =
        robaLightDtos.stream()
            .collect(
                Collectors.partitioningBy(
                    robaDto ->
                        TecDocProizvodjaci.findByName(robaDto.getProizvodjac().getProid())
                            != null));

    List<RobaLightDto> tdRoba = partitioned.get(true); // TecDoc-mapped items
    List<RobaLightDto> notTdRoba = partitioned.get(false); // Items not mapped to TecDoc

    // Remove items that do not match a valid TecDoc-mapped alternative
    List<RobaLightDto> removable =
        notTdRoba.stream()
            .filter(robaDto -> isNotMatchingMainArticle(tdRoba, robaDto))
            .collect(Collectors.toList());

    // Remove if its not found by original number
    removable =
        removable.stream()
            .filter(robaDto -> !robaDto.getKatbr().contains("-OE"))
            .collect(Collectors.toList());

    removable.forEach(
        robaDto ->
            log.error(
                "Artikal alternativa ne dogovara katbr "
                    + robaDto.getKatbr()
                    + " proizvodjac "
                    + robaDto.getProizvodjac()));

    robaLightDtos.removeAll(removable);
  }

  private boolean isNotMatchingMainArticle(List<RobaLightDto> tdRoba, RobaLightDto robaLightDto) {
    // Get all matching TecDoc-mapped items that have the same alternative catalog number
    List<RobaLightDto> matchedTdRoba =
        tdRoba.stream()
            .filter(
                data ->
                    data.getKatbrpro().equals(robaLightDto.getKatbr())
                        || data.getKatbr().equals(robaLightDto.getKatbr()))
            .collect(Collectors.toList());

    // If no matches, reject this alternative item
    if (matchedTdRoba.isEmpty()) {
      return true;
    }

    // Check if multiple different TecDoc manufacturers exist
    Set<String> distinctManufacturers =
        matchedTdRoba.stream()
            .map(data -> data.getProizvodjac().getProid())
            .collect(Collectors.toSet());

    if (distinctManufacturers.size() > 1) {
      log.warn(
          "Alternative catalog number {} matches multiple TecDoc manufacturers: {}",
          robaLightDto.getKatbr(),
          distinctManufacturers);
      return true; // Reject because it's ambiguous
    }

    // Ensure that at least one mapped TecDoc product has the same PodGrupa
    return matchedTdRoba.stream()
        .noneMatch(data -> data.getPodGrupa() == robaLightDto.getPodGrupa());
  }

  public void addTecdocArticles(List<ArticleRecord> articles, List<RobaLightDto> roba) {
    List<RobaLightDto> tdArticles =
        articles.stream()
            .map(
                articleRecord -> {
                  TecDocProizvodjaci tecDocProizvodjaci =
                      TecDocProizvodjaci.pronadjiPoKljucu(articleRecord.getDataSupplierId());
                  String katBr =
                      TecDocProizvodjaci.generateAlternativeCatalogNumber(
                          articleRecord.getArticleNumber(), tecDocProizvodjaci);

                  boolean articleInDB =
                      roba.stream()
                          .anyMatch(
                              robaDto ->
                                  robaDto
                                          .getProizvodjac()
                                          .getProid()
                                          .equals(tecDocProizvodjaci.getCleanName())
                                      && robaDto.getKatbr().equals(katBr));

                  return articleInDB
                      ? null
                      : generateRobaLightDto(articleRecord, tecDocProizvodjaci);
                })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    roba.addAll(tdArticles);
  }

  public void enrichRobaDtoWithLinkageCriteria(
      List<RobaLightDto> robaLightDtos, List<ArticleRecord> articles) {
    robaLightDtos.forEach(
        robaDto -> {
          List<RobaTehnickiOpisDto> criteriaList =
              articles.stream()
                  .filter(article -> isMatchingArticle(robaDto, article))
                  .flatMap(article -> article.getLinkages().stream())
                  .flatMap(linkage -> linkage.getLinkageCriteria().stream())
                  .filter(CriteriaRecord::isImmediateDisplay)
                  .map(
                      criteria -> {
                        RobaTehnickiOpisDto opisDto = new RobaTehnickiOpisDto();
                        opisDto.setType(criteria.getCriteriaType());
                        opisDto.setVrednost(criteria.getFormattedValue());
                        opisDto.setOznaka(criteria.getCriteriaDescription());
                        return opisDto;
                      })
                  .collect(Collectors.toList());

          if (!criteriaList.isEmpty()) {
            robaDto.setTdLinkageCriteria(criteriaList);
          }
        });
  }

  private boolean isMatchingArticle(RobaLightDto robaLightDto, ArticleRecord articleRecord) {
    TecDocProizvodjaci tdProizvodjac =
        TecDocProizvodjaci.findByName(robaLightDto.getProizvodjac().getProid());
    if (tdProizvodjac == null) {
      return false;
    }

    return TecDocProizvodjaci.getAllTecDocIdsByName(robaLightDto.getProizvodjac().getProid())
            .contains(articleRecord.getDataSupplierId())
        && robaLightDto
            .getKatbr()
            .equals(
                TecDocProizvodjaci.generateAlternativeCatalogNumber(
                    articleRecord.getArticleNumber(), tdProizvodjac));
  }

  private RobaLightDto generateRobaLightDto(
      ArticleRecord articleRecord, TecDocProizvodjaci tecDocProizvodjaci) {
    String katBr =
        TecDocProizvodjaci.generateAlternativeCatalogNumber(
            articleRecord.getArticleNumber(), tecDocProizvodjaci);

    RobaLightDto data = new RobaLightDto();
    data.setKatbr(katBr);
    data.setNaziv(articleRecord.getGenericArticles().get(0).getGenericArticleDescription());

    ProizvodjacDTO proizvodjacDTO = new ProizvodjacDTO();
    proizvodjacDTO.setProid(tecDocProizvodjaci.getCleanName());
    data.setProizvodjac(proizvodjacDTO);

    TecDocPreviewService.TecDocPreview preview = tecDocPreviewService.fromArticleRecord(articleRecord);
    if (preview != null) {
      data.setSlika(preview.slika());
      data.setTehnickiOpis(preview.tehnickiOpis());
    }

    return data;
  }
}
