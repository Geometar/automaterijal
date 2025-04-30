package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.tecdoc.*;
import com.automaterijal.application.utils.GeneralUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.SetUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaSearchService {
  @NonNull final RobaAdapterService robaAdapter;
  @NonNull final TecDocService tecDocService;
  @NonNull final RobaHelper robaHelper;
  @NonNull final RobaAdapterService robaAdapterService;

  public MagacinDto getAssociatedArticles(
      Integer id,
      String type,
      String assembleGroupId,
      UniverzalniParametri parametri,
      Partner ulogovaniPartner) {

    List<ArticleRecord> articles =
        tecDocService.getAssociatedArticles(id, type, assembleGroupId).getArticles();

    articles.forEach(
        articleRecord ->
            articleRecord.setArticleNumber(
                GeneralUtil.cleanArticleNumber(articleRecord.getArticleNumber())));

    Set<String> articleNumbers =
        processArticleRecords(
            articles, ArticleRecord::getArticleNumber, ArticleRecord::getDataSupplierId);

    articles.forEach(
        articleRecord -> {
          if (!TecDocProizvodjaci.pronadjiPoKljucu(articleRecord.getDataSupplierId())
              .isUseTradeNumber()) {
            return;
          }
          Set<TradeNumberDetailsRecord> records =
              articleRecord.getTradeNumbersDetails().stream()
                  .filter(TradeNumberDetailsRecord::isIsImmediateDisplay)
                  .collect(Collectors.toSet());
          if (!SetUtils.isEmpty(records)) {
            articleNumbers.addAll(
                records.stream()
                    .flatMap(
                        tradeNumberDetailsRecord ->
                            processArticleRecords(
                                articles,
                                tradeNumberDetailsRecord.getTradeNumber(),
                                articleRecord.getDataSupplierId())
                                .stream())
                    .collect(Collectors.toSet()));
          }
        });

    articles.forEach(
        articleRecord ->
            articleNumbers.addAll(
                articleRecord.getOemNumbers().stream()
                    .map(ArticleRefRecord::getArticleNumber)
                    .map(GeneralUtil::cleanArticleNumber)
                    .map(oe -> oe.concat("-OE"))
                    .collect(Collectors.toSet())));
    MagacinDto magacinDto =
        robaAdapterService.fetchRobaByTecDocArticles(articleNumbers, parametri, articles);
    if (!magacinDto.getRobaDto().isEmpty()) {
      tecDocService.batchVracanjeICuvanjeTDAtributa(magacinDto.getRobaDto().getContent());
      robaHelper.setujZaTabelu(magacinDto.getRobaDto().getContent(), ulogovaniPartner);
    }

    return magacinDto;
  }

  public MagacinDto pretrazi(UniverzalniParametri parametri, Partner ulogovaniPartner) {

    MagacinDto magacinDto =
        parametri.getTrazenaRec() != null
            ? logikaZaMagacinSaTrazenomRecju(parametri)
            : robaAdapter.vratiRobuFiltriranuBezPretrage(parametri);

    if (!magacinDto.getRobaDto().isEmpty()) {
      tecDocService.batchVracanjeICuvanjeTDAtributa(magacinDto.getRobaDto().getContent());
      robaHelper.setujZaTabelu(magacinDto.getRobaDto().getContent(), ulogovaniPartner);
    }

    return magacinDto;
  }

  private MagacinDto logikaZaMagacinSaTrazenomRecju(UniverzalniParametri parametri) {
    final Set<String> kataloskiBrojevi = new HashSet<>();
    Set<Long> robaId = new HashSet<>();

    robaAdapter.pronadjiPoKatBroju(kataloskiBrojevi, robaId, parametri);
    if (!kataloskiBrojevi.isEmpty()) {
      robaAdapter.pomocniKveriPoRobiOld(kataloskiBrojevi);
      robaAdapter.pronadjiPoKatBrojuIn(kataloskiBrojevi, robaId);
    }

    // Pokusaj pretrage pomocu naziva
    if (kataloskiBrojevi.isEmpty()) {
      boolean found = robaAdapter.pronadjiPoNazivu(parametri, kataloskiBrojevi, robaId);
      if (found) {
        return robaAdapter.pronadjiPoRobaId(parametri, robaId);
      }
    }

    // Ukljucujemo tecdoc u pretragu
    pretragaPomocuTecDoca(parametri, kataloskiBrojevi);

    return robaAdapter.vratiArtikleIzTecDoca(parametri, kataloskiBrojevi);
  }

  private void pretragaPomocuTecDoca(UniverzalniParametri parametri, Set<String> kataloskiBrojevi) {

    // TecDoc pretraga na osnovu tačne reči, tip pretrage je 10 (trazimo sve)
    List<ArticleDirectSearchAllNumbersWithStateRecord> response =
        tecDocService.tecDocPretragaPoTrazenojReci(parametri.getTrazenaRec(), null, 10);
    parametri.setKesiranDirectArticleSearch(response);

    // Process TecDoc search results
    kataloskiBrojevi.addAll(
        processArticleRecords(
            response,
            ArticleDirectSearchAllNumbersWithStateRecord::getArticleNo,
            ArticleDirectSearchAllNumbersWithStateRecord::getBrandNo));

    // Dodavanje tačne tražene reči kao kataloškog broja
    kataloskiBrojevi.add(parametri.getTrazenaRec());
  }

  /** Generic method to process article records and extract catalog numbers. */
  private <T> Set<String> processArticleRecords(
      List<T> records, Function<T, String> getArticleNo, Function<T, Long> getBrandNo) {
    return records.stream()
        .map(
            record -> {
              String katBr = getArticleNo.apply(record);
              return TecDocProizvodjaci.generateAlternativeCatalogNumber(
                  katBr, getBrandNo.apply(record));
            })
        .collect(Collectors.toSet());
  }

  private <T> Set<String> processArticleRecords(
      List<T> records, String articleNo, Long getBrandNo) {
    return records.stream()
        .map(
            record -> {
              return TecDocProizvodjaci.generateAlternativeCatalogNumber(articleNo, getBrandNo);
            })
        .collect(Collectors.toSet());
  }
}
