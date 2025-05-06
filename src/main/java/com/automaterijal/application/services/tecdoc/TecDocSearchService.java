package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleDirectSearchById3Record;
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
    int searchType = manufacturer != TecDocProizvodjaci.HP ? 2 : 1;
    return tecDocClient.tecDocPretraga(catalogNumber, manufacturer.getTecDocId(), searchType);
  }

  private Long findMatchingArticleId(
      List<ArticleDirectSearchAllNumbersWithStateRecord> results, String catalogNumber) {
    List<ArticleDirectSearchAllNumbersWithStateRecord> filtered =
        results.stream()
            .filter(
                record ->
                    record
                            .getArticleNo()
                            .replace(" ", "")
                            .equalsIgnoreCase(catalogNumber.replace(" ", ""))
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
        .or(() -> findByAlternativeNumbers(altNumbers, robaList));
  }

  private Optional<RobaLightDto> findByExactArticleNo(
      ArticleDirectSearchById3Record article, List<RobaLightDto> robaList) {
    String cleanedArticleNo = article.getArticleNo().replace(" ", "");

    return robaList.stream()
        .filter(
            dto -> {
              TecDocProizvodjaci td =
                  TecDocProizvodjaci.pronadjiPoNazivu(dto.getProizvodjac().getProid());
              if (td == null) return false;

              String localNumber =
                  td.isUseAlternativeNumber() && dto.getKatbrpro() != null
                      ? dto.getKatbrpro()
                      : dto.getKatbr();

              return numbersMatch(localNumber, cleanedArticleNo, td);
            })
        .findFirst();
  }

  private Optional<RobaLightDto> findByAlternativeNumbers(
      List<String> altNumbers, List<RobaLightDto> robaList) {
    return robaList.stream()
        .filter(
            dto -> {
              TecDocProizvodjaci td =
                  TecDocProizvodjaci.pronadjiPoNazivu(dto.getProizvodjac().getProid());
              if (td == null) return false;

              String localNumber =
                  td.isUseAlternativeNumber() && dto.getKatbrpro() != null
                      ? dto.getKatbrpro()
                      : dto.getKatbr();

              return altNumbers.stream()
                  .map(n -> n.replace(" ", ""))
                  .anyMatch(alt -> numbersMatch(localNumber, alt, td));
            })
        .findFirst();
  }

  private boolean numbersMatch(String katBr, String tecDocKatBr, TecDocProizvodjaci td) {
    if (katBr == null || tecDocKatBr == null) return false;
    katBr = TecDocProizvodjaci.restoreOriginalCatalogNumber(katBr, td);
    tecDocKatBr = tecDocKatBr.replaceAll("[-,./\\s]", "");
    return katBr.equalsIgnoreCase(tecDocKatBr);
  }
}
