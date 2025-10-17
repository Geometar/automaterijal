package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleDirectSearchById3Record;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocSearchService {

  @NonNull TecDocClient tecDocClient;

  public Long searchArticle(
      RobaLightDto robaLightDto, TecDocProizvodjaci manufacturer, String catalogNumber) {
    List<ArticleDirectSearchAllNumbersWithStateRecord> results =
        TecDocProizvodjaci.getAllTecDocIdsByName(robaLightDto.getProizvodjac().getProid()).stream()
            .flatMap(tecDocId -> tecDocClient.tecDocPretraga(catalogNumber, tecDocId, 0).stream())
            .collect(Collectors.toList());

    if (results.isEmpty()) {
      results = fallbackSearch(manufacturer, catalogNumber);
    }

    return findMatchingArticleId(results, catalogNumber);
  }

  private List<ArticleDirectSearchAllNumbersWithStateRecord> fallbackSearch(
      TecDocProizvodjaci manufacturer, String catalogNumber) {
    List<ArticleDirectSearchAllNumbersWithStateRecord> retVal =
        tecDocClient.tecDocPretraga(catalogNumber, manufacturer.getTecDocId(), 1);
    if (retVal.isEmpty() && manufacturer.isUseTradeNumber()) {
      retVal = tecDocClient.tecDocPretraga(catalogNumber, manufacturer.getTecDocId(), 2);
    }
    return retVal;
  }

  private Long findMatchingArticleId(
      List<ArticleDirectSearchAllNumbersWithStateRecord> results, String catalogNumber) {
    String catalogNumberCleaned = cleanedWithSeparators(catalogNumber);
    List<ArticleDirectSearchAllNumbersWithStateRecord> filtered =
        results.stream()
            .filter(
                record ->
                    cleanedWithSeparators(record.getArticleNo())
                            .equalsIgnoreCase(catalogNumberCleaned)
                        || record.getNumberType() == 2
                        || record.getNumberType() == 0)
            .toList();

    List<ArticleDirectSearchAllNumbersWithStateRecord> stateOne =
        filtered.stream().filter(article -> article.getArticleStateId() == 1).toList();

    return stateOne.stream()
        .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
        .findFirst()
        .orElseGet(
            () ->
                filtered.stream()
                    .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
                    .findFirst()
                    .orElse(null));
  }

  public Optional<RobaLightDto> findMatchingRoba(
      ArticleDirectSearchById3Record article,
      List<RobaLightDto> robaList,
      List<String> altNumbers) {
    return findByExactArticleNo(article, robaList)
        .or(() -> findByAlternativeNumbers(article, altNumbers, robaList));
  }

  private Optional<RobaLightDto> findByExactArticleNo(
      ArticleDirectSearchById3Record article, List<RobaLightDto> robaList) {
    String cleanedArticleNo = cleanedWithSeparators(article.getArticleNo());
    Long articleBrandId = article.getBrandNo();

    return robaList.stream()
        .filter(
            dto -> {
              TecDocProizvodjaci td =
                  TecDocProizvodjaci.pronadjiPoNazivu(dto.getProizvodjac().getProid());
              if (td == null) return false;
              if (articleBrandId == null || !articleBrandId.equals(td.getTecDocId())) return false;

              String localNumber =
                  td.isUseAlternativeNumber() && dto.getKatbrpro() != null
                      ? dto.getKatbrpro()
                      : dto.getKatbr();

              return numbersMatch(localNumber, cleanedArticleNo, td);
            })
        .findFirst();
  }

  private Optional<RobaLightDto> findByAlternativeNumbers(
      ArticleDirectSearchById3Record article,
      List<String> altNumbers,
      List<RobaLightDto> robaList) {
    Long articleBrandId = article.getBrandNo();

    return robaList.stream()
        .filter(
            dto -> {
              TecDocProizvodjaci td =
                  TecDocProizvodjaci.pronadjiPoNazivu(dto.getProizvodjac().getProid());
              if (td == null) return false;
              if (articleBrandId == null || !articleBrandId.equals(td.getTecDocId())) return false;

              String localNumber =
                  td.isUseAlternativeNumber() && dto.getKatbrpro() != null
                      ? dto.getKatbrpro()
                      : dto.getKatbr();

              return altNumbers.stream().anyMatch(alt -> numbersMatch(localNumber, alt, td));
            })
        .findFirst();
  }

  private boolean numbersMatch(String katBr, String tecDocKatBr, TecDocProizvodjaci td) {
    if (katBr == null || tecDocKatBr == null) return false;
    katBr = TecDocProizvodjaci.restoreOriginalCatalogNumber(katBr, td);
    return CatalogNumberUtils.equalsWhenCleaned(katBr, tecDocKatBr);
  }

  private String cleanedWithSeparators(String value) {
    String cleaned = CatalogNumberUtils.cleanPreserveSeparators(value);
    return cleaned != null ? cleaned : "";
  }
}
