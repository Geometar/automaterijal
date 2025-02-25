package com.automaterijal.application.services;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.tecdoc.AssemblyGroupWrapper;
import com.automaterijal.application.domain.dto.tecdoc.Manufcatures;
import com.automaterijal.application.domain.dto.tecdoc.Model;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import com.automaterijal.application.services.logic.TecDocLogicService;
import com.automaterijal.application.tecdoc.*;
import java.util.Arrays;
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
public class TecDocService {

  @Autowired TecDocClient tecDocClient;

  @Autowired TecDocAtributiRepository tecDocAtributiRepository;

  @Autowired TecDocBrandsRepository tecDocBrandsRepository;

  @Autowired TecDocMapper tecDocMapper;

  @Autowired TecDocLogicService tecDocLogicService;

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
    return tecDocAtributiRepository.findByRobaId(robaId);
  }

  public List<TecDocAtributi> vratiTecDocAtributePrekoRobeIds(List<Long> robaIds) {
    return tecDocAtributiRepository.findByRobaIdIn(robaIds);
  }

  public byte[] vratiDokument(String dokumentId, Integer tipSlike) {
    return tecDocLogicService.vratiDokument(dokumentId, tipSlike);
  }

  public Optional<TecDocBrands> vratiTecDocBrendovePrekoProId(String proId) {
    return tecDocBrandsRepository.findById(proId);
  }

  public List<Manufcatures> getAllManufactures() {
    return tecDocMapper.mapToManufcatures(tecDocClient.getManufactures());
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

  public void batchVracanjeICuvanjeTDAtributa(List<RobaDto> robaDtos) {
    tecDocLogicService.batchVracanjeICuvanjeTDAtributa(robaDtos);
  }
}
