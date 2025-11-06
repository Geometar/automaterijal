package com.automaterijal.application.services;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.tecdoc.AssemblyGroupWrapper;
import com.automaterijal.application.domain.dto.tecdoc.Manufcatures;
import com.automaterijal.application.domain.dto.tecdoc.Model;
import com.automaterijal.application.domain.dto.tecdoc.TecDocLinkedManufacturerTargetsDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.services.logic.TecDocLogicService;
import com.automaterijal.application.services.tecdoc.TecDocAttributeService;
import com.automaterijal.application.services.tecdoc.TecDocBrandService;
import com.automaterijal.application.services.tecdoc.TecDocDocumentService;
import com.automaterijal.application.tecdoc.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocService {

  @Autowired TecDocClient tecDocClient;
  @Autowired TecDocAttributeService tecDocAttributeService;
  @Autowired TecDocMapper tecDocMapper;
  @Autowired TecDocLogicService tecDocLogicService;
  @Autowired TecDocBrandService tecDocBrandService;
  @Autowired TecDocDocumentService tecDocDocumentService;

  //    ******************** TecDoc Pretraga  ********************

  public List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocPretragaPoTrazenojReci(
      String trazenaRec, Long brandId, Integer numbertype) {
    return tecDocClient.tecDocPretraga(trazenaRec, brandId, numbertype);
  }

  public List<ArticlesByIds6Record> vratiDetaljeArtikla(Long articleId) {
    return tecDocClient.vratiDetaljeArtikla(Arrays.asList(articleId));
  }

  //    ******************** TecDoc Atributi  ********************

  public List<TecDocAtributi> vratiTecDocAtributePrekoRobeId(Long robaId) {
    return tecDocAttributeService.findByRobaId(robaId);
  }

  public List<TecDocAtributi> vratiTecDocAtributePrekoRobeIds(List<Long> robaIds) {
    return tecDocAttributeService.findByRobaIds(robaIds);
  }

  public byte[] vratiDokument(String dokumentId, Integer tipSlike) {
    return tecDocDocumentService.getDocument(dokumentId, tipSlike);
  }

  public Optional<TecDocBrands> vratiTecDocBrendovePrekoProId(String proId) {
    return tecDocBrandService.findById(proId);
  }

  public List<Manufcatures> getAllManufactures(String type) {
    return tecDocMapper.mapToManufcatures(tecDocClient.getManufactures(type));
  }

  public List<Model> getModelsForModeId(Integer manuId, String type) {
    return tecDocMapper.mapToModel(tecDocClient.getModels(manuId, type));
  }

  public List<LinkageTargetDetails> getModelSubTypes(Integer manuId, Integer modelId, String type) {
    return tecDocClient.getVehicleSubModels(manuId, modelId, type);
  }

  public List<LinkageTargetDetails> getLinkageTargetDetails(Integer id, String type) {
    return tecDocClient.getLinkageTargets(id, type);
  }

  public ArticlesResponse getAssociatedArticles(Integer id, String type, String assembleGroupId) {
    return tecDocClient.getAssociatedArticles(id, type, assembleGroupId);
  }

  public AssemblyGroupWrapper getAssemblyGroupsForVehicle(String type, Integer linkedTargetType) {
    List<GenericArticlesRecord> genericArticles =
        tecDocClient.getGenericArticles(type, linkedTargetType);
    List<AssemblyGroupFacetCount> assemblyGroupFacetCounts =
        tecDocClient.getAssemblyGroupsForVehicle(type, linkedTargetType);
    AssemblyGroupWrapper response = new AssemblyGroupWrapper();
    response.setGenericArticles(genericArticles);
    response.setAssemblyGroupFacetCounts(assemblyGroupFacetCounts);
    return response;
  }

  public void batchVracanjeICuvanjeTDAtributa(List<RobaLightDto> robaLightDtos) {
    tecDocLogicService.fetchAndSaveTecDocAttributes(robaLightDtos);
  }

  public Optional<ArticleLinkedAllLinkingTargetManufacturer2Response>
      getArticleLinkedManufacturers(Long robaId, String linkingTargetType) {
    if (linkingTargetType == null || linkingTargetType.isBlank()) {
      return Optional.empty();
    }

    String sanitizedType = linkingTargetType.trim().toUpperCase(Locale.ROOT);

    return tecDocAttributeService
        .findTecDocArticleIdByRobaId(robaId)
        .flatMap(
            articleId ->
                Optional.ofNullable(
                    tecDocClient.getArticleLinkedAllLinkingTargetManufacturer2(
                        articleId, sanitizedType)));
  }

  public Optional<List<TecDocLinkedManufacturerTargetsDto>> getArticleLinkedTargets(
      Long robaId, String linkingTargetType) {
    if (linkingTargetType == null || linkingTargetType.isBlank()) {
      return Optional.empty();
    }

    String sanitizedType = linkingTargetType.trim().toUpperCase(Locale.ROOT);

    return tecDocAttributeService
        .findTecDocArticleIdByRobaId(robaId)
        .flatMap(articleId -> Optional.of(fetchLinkedManufacturersWithTargets(articleId, sanitizedType)));
  }

  private List<TecDocLinkedManufacturerTargetsDto> fetchLinkedManufacturersWithTargets(
      Long articleId, String linkingTargetType) {

    ArticleLinkedAllLinkingTargetManufacturer2Response manufacturersResponse =
        tecDocClient.getArticleLinkedAllLinkingTargetManufacturer2(articleId, linkingTargetType);

    if (manufacturersResponse == null
        || manufacturersResponse.getData() == null
        || manufacturersResponse.getData().getArray() == null) {
      return List.of();
    }

    List<ArticleLinkedAllLinkingTargetManufacturer2Record> manufacturers =
        manufacturersResponse.getData().getArray().stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    List<TecDocLinkedManufacturerTargetsDto> result = new ArrayList<>();

    for (ArticleLinkedAllLinkingTargetManufacturer2Record manufacturer : manufacturers) {
      Long manuId = manufacturer.getManuId();
      if (manuId == null) {
        continue;
      }

      ArticleLinkedAllLinkingTarget4Response linkedTargetsResponse =
          tecDocClient.getArticleLinkedAllLinkingTarget4(articleId, manuId, linkingTargetType);

      List<ArticleLinkedAllLinkingTargetDetailsRecord> details =
          extractLinkingTargetDetails(linkedTargetsResponse);

      if (details.isEmpty()) {
        continue;
      }

      List<ArticleLinkedAllLinkingTargetsByIds3Record> aggregatedTargets =
          fetchLinkedTargetsByIds(articleId, linkingTargetType, details);

      if (!aggregatedTargets.isEmpty()) {
        result.add(
            new TecDocLinkedManufacturerTargetsDto(
                manuId, manufacturer.getManuName(), aggregatedTargets));
      }
    }

    return result;
  }

  private List<ArticleLinkedAllLinkingTargetDetailsRecord> extractLinkingTargetDetails(
      ArticleLinkedAllLinkingTarget4Response response) {
    if (response == null || response.getData() == null || response.getData().getArray() == null) {
      return List.of();
    }

    List<ArticleLinkedAllLinkingTargetDetailsRecord> details = new ArrayList<>();
    Set<String> seenPairs = new LinkedHashSet<>();

    for (ArticleLinkedAllLinkingTarget4Record record :
        response.getData().getArray().stream().filter(Objects::nonNull).toList()) {
      if (record.getArticleLinkages() == null || record.getArticleLinkages().getArray() == null) {
        continue;
      }

      for (ArticleLinkedAllLinkingTargetDetailsRecord linkage :
          record.getArticleLinkages().getArray().stream().filter(Objects::nonNull).toList()) {
        if (linkage.getArticleLinkId() == null || linkage.getLinkingTargetId() == null) {
          continue;
        }

        String key = linkage.getArticleLinkId() + ":" + linkage.getLinkingTargetId();
        if (seenPairs.add(key)) {
          details.add(linkage);
        }
      }
    }

    return details;
  }

  private List<ArticleLinkedAllLinkingTargetsByIds3Record> fetchLinkedTargetsByIds(
      Long articleId,
      String linkingTargetType,
      List<ArticleLinkedAllLinkingTargetDetailsRecord> details) {

    List<ArticleLinkedAllLinkingTargetsByIds3Record> aggregated = new ArrayList<>();

    final int batchSize = 25;
    for (int index = 0; index < details.size(); index += batchSize) {
      List<ArticleLinkedAllLinkingTargetDetailsRecord> batch =
          details.subList(index, Math.min(details.size(), index + batchSize));

      ArticleLinkedAllLinkingTargetsByIds3Response response =
          tecDocClient.getArticleLinkedAllLinkingTargetsByIds3(
              articleId, linkingTargetType, batch);

      if (response == null
          || response.getData() == null
          || response.getData().getArray() == null) {
        continue;
      }

      aggregated.addAll(
          response.getData().getArray().stream().filter(Objects::nonNull).collect(Collectors.toList()));
    }

    return aggregated;
  }
}
