package com.automaterijal.application.services.roba.processor;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.services.SlikeService;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.CriteriaRecord;
import com.automaterijal.application.tecdoc.TradeNumberDetailsRecord;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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

  @Autowired SlikeService slikeService;

  public void filterIfNotMatchingWithTecDoc(List<ArticleRecord> articles, List<RobaDto> robaDtos) {
    List<RobaDto> removable =
        robaDtos.stream()
            .filter(robaDto -> isNotMatchingWithTecDoc(articles, robaDto))
            .collect(Collectors.toList());

    removable.forEach(
        robaDto ->
            log.error(
                "Artikal ne odgovara tekdoku "
                    + robaDto.getKatbr()
                    + " proizvodjac "
                    + robaDto.getProizvodjac()));

    robaDtos.removeAll(removable);
  }

  private boolean isNotMatchingWithTecDoc(List<ArticleRecord> articles, RobaDto robaDto) {
    return !isMatchingWithTecDoc(articles, robaDto);
  }

  private boolean isMatchingWithTecDoc(List<ArticleRecord> articles, RobaDto robaDto) {
    TecDocProizvodjaci tecDocProizvodjaci =
        TecDocProizvodjaci.findByName(robaDto.getProizvodjac().getProid());
    if (tecDocProizvodjaci == null) {
      return false; // Not a TecDoc article
    }

    String katBr =
        TecDocProizvodjaci.restoreOriginalCatalogNumber(robaDto.getKatbr(), tecDocProizvodjaci);
    List<Long> tdBrandIds =
        TecDocProizvodjaci.getAllTecDocIdsByName(robaDto.getProizvodjac().getProid());
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

  public void filterIfNotMatchingMainArticle(List<RobaDto> robaDtos) {
    // Partition RobaDtos into TecDoc-mapped and non-TecDoc-mapped lists
    Map<Boolean, List<RobaDto>> partitioned =
        robaDtos.stream()
            .collect(
                Collectors.partitioningBy(
                    robaDto ->
                        TecDocProizvodjaci.findByName(robaDto.getProizvodjac().getProid())
                            != null));

    List<RobaDto> tdRoba = partitioned.get(true); // TecDoc-mapped items
    List<RobaDto> notTdRoba = partitioned.get(false); // Items not mapped to TecDoc

    // Remove items that do not match a valid TecDoc-mapped alternative
    List<RobaDto> removable =
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

    robaDtos.removeAll(removable);
  }

  private boolean isNotMatchingMainArticle(List<RobaDto> tdRoba, RobaDto robaDto) {
    // Get all matching TecDoc-mapped items that have the same alternative catalog number
    List<RobaDto> matchedTdRoba =
        tdRoba.stream()
            .filter(
                data ->
                    data.getKatbrpro().equals(robaDto.getKatbr())
                        || data.getKatbr().equals(robaDto.getKatbr()))
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
          robaDto.getKatbr(),
          distinctManufacturers);
      return true; // Reject because it's ambiguous
    }

    // Ensure that at least one mapped TecDoc product has the same PodGrupa
    return matchedTdRoba.stream().noneMatch(data -> data.getPodGrupa() == robaDto.getPodGrupa());
  }

  public void addTecdocArticles(List<ArticleRecord> articles, List<RobaDto> roba) {
    List<RobaDto> tdArticles =
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
                      : RobaDto.fromTecdocArticle(articleRecord, tecDocProizvodjaci, slikeService);
                })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    roba.addAll(tdArticles);
  }

  public void enrichRobaDtoWithLinkageCriteria(
      List<RobaDto> robaDtos, List<ArticleRecord> articles) {
    robaDtos.forEach(
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

  private boolean isMatchingArticle(RobaDto robaDto, ArticleRecord articleRecord) {
    TecDocProizvodjaci tdProizvodjac =
        TecDocProizvodjaci.findByName(robaDto.getProizvodjac().getProid());
    if (tdProizvodjac == null) {
      return false;
    }

    return TecDocProizvodjaci.getAllTecDocIdsByName(robaDto.getProizvodjac().getProid())
            .contains(articleRecord.getDataSupplierId())
        && robaDto
            .getKatbr()
            .equals(
                TecDocProizvodjaci.generateAlternativeCatalogNumber(
                    articleRecord.getArticleNumber(), tdProizvodjac));
  }
}
