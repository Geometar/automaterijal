package com.automaterijal.application.services.roba.details;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.robadetalji.RobaExpandedDto;
import com.automaterijal.application.domain.dto.tecdoc.TecDocLinkedManufacturerDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.services.ImageService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaEnrichmentService;
import com.automaterijal.application.services.roba.RobaTekstService;
import com.automaterijal.application.services.roba.ProviderBrandResolver;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.services.roba.util.RobaTecDocDetailsHelper;
import com.automaterijal.application.services.tecdoc.TecDocBrandService;
import com.automaterijal.application.services.tecdoc.TecDocGenericArticleMappingService;
import com.automaterijal.application.services.tecdoc.TecDocPreviewService;
import com.automaterijal.application.tecdoc.*;
import com.automaterijal.application.utils.SlugUtil;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import jakarta.persistence.EntityNotFoundException;
import java.util.*;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
@Slf4j
public class RobaDetailsService {

  private static final String DEFAULT_LINKING_TARGET_TYPE = "VOLB";

  @NonNull final RobaDatabaseService robaDatabaseService;
  @NonNull final ArticleSubGroupService articleSubGroupService;
  @NonNull final ArticleGroupService articleGroupService;
  @NonNull final RobaTekstService robaTekstService;
  @NonNull final RobaMapper mapper;
  @NonNull final TecDocService tecDocService;
  @NonNull final TecDocBrandService tecDocBrandService;
  @NonNull final TecDocPreviewService tecDocPreviewService;
  @NonNull final TecDocGenericArticleMappingService tecDocGenericArticleMappingService;
  @NonNull final ProviderBrandResolver providerBrandResolver;
  @NonNull final RobaEnrichmentService robaEnrichmentService;
  @NonNull final RobaTecDocDetailsHelper robaTecDocDetailsHelper;
  @NonNull final ImageService imageService;

  public Optional<String> findSlugPathById(Long robaId) {
    return robaDatabaseService
        .findByRobaId(robaId)
        .map(roba -> robaId + "-" + SlugUtil.toSlug(roba.getNaziv()));
  }

  public Optional<RobaExpandedDto> fetchRobaDetails(Long robaId, Partner ulogovaniPartner) {
    Optional<RobaExpandedDto> retVal = Optional.empty();
    Optional<Roba> roba = robaDatabaseService.findByRobaId(robaId);
    if (roba.isPresent()) {
      RobaExpandedDto detaljnoDto = mapper.mapujDetaljno(roba.get());
      setupDetails(detaljnoDto, ulogovaniPartner);
      retVal = Optional.of(detaljnoDto);
    }
    return retVal;
  }

  public Optional<RobaExpandedDto> fetchExternalRobaDetailsByTecDocArticleId(
      Long tecDocArticleId, Partner ulogovaniPartner) {
    if (tecDocArticleId == null) {
      return Optional.empty();
    }

    List<ArticlesByIds6Record> tecDocDetalji = tecDocService.vratiDetaljeArtikla(tecDocArticleId);
    if (tecDocDetalji == null || tecDocDetalji.isEmpty()) {
      return Optional.empty();
    }

    ArticlesByIds6Record record = tecDocDetalji.get(0);
    ArticleDirectSearchById3Record direct = record != null ? record.getDirectArticle() : null;
    if (direct == null || direct.getArticleId() == null) {
      return Optional.empty();
    }

    RobaExpandedDto dto = new RobaExpandedDto();
    dto.setRobaid(null);
    dto.setTecDocArticleId(direct.getArticleId());
    dto.setKatbr(direct.getArticleNo());
    dto.setKatbrpro(null);
    dto.setNaziv(buildArticleName(direct.getArticleName(), direct.getArticleAddName()));
    dto.setStanje(0);

    ProviderRoutingContext context = buildContext(ulogovaniPartner);
    String resolvedProid =
        providerBrandResolver
            .resolveInventoryBrand(direct.getBrandNo(), direct.getBrandName(), context)
            .or(() -> tecDocBrandService.findProidByBrandId(direct.getBrandNo()))
            .orElse(null);

    if (resolvedProid != null && !resolvedProid.isBlank()) {
      var p = new com.automaterijal.application.domain.dto.ProizvodjacDTO();
      p.setProid(resolvedProid);
      p.setNaziv(
          direct.getBrandName() != null && !direct.getBrandName().isBlank()
              ? direct.getBrandName()
              : resolvedProid);
      dto.setProizvodjac(p);
    } else if (direct.getBrandName() != null && !direct.getBrandName().isBlank()) {
      var p = new com.automaterijal.application.domain.dto.ProizvodjacDTO();
      String proid = direct.getBrandName().trim().toUpperCase(Locale.ROOT);
      p.setProid(proid);
      p.setNaziv(direct.getBrandName().trim());
      dto.setProizvodjac(p);
    }

    if (dto.getProizvodjac() != null && dto.getProizvodjac().getProid() != null) {
      tecDocService
          .vratiTecDocBrendovePrekoProId(dto.getProizvodjac().getProid())
          .ifPresent(
              tecDocBrands -> dto.setProizvodjacLogo(imageService.getImageForBrandLogo(tecDocBrands)));
    }

    dto.setLinkedManufacturers(
        tecDocService.getLinkedManufacturersByArticleId(direct.getArticleId(), DEFAULT_LINKING_TARGET_TYPE));

    // TecDoc content (tech details, OE, docs)
    RobaTecDocDetailsHelper.setujTehnickeDetalje(dto, tecDocDetalji);
    RobaTecDocDetailsHelper.setujOriginalneBrojeve(dto, tecDocDetalji);
    robaTecDocDetailsHelper.setujDokumentaciju(dto, tecDocDetalji);

    // Preview image (and fallback tech list if needed)
    TecDocPreviewService.TecDocPreview preview = tecDocPreviewService.fromDetailsRecord(record);
    if (preview != null) {
      dto.setSlika(preview.slika());
      if ((dto.getTehnickiOpis() == null || dto.getTehnickiOpis().isEmpty())
          && preview.tehnickiOpis() != null
          && !preview.tehnickiOpis().isEmpty()) {
        dto.setTehnickiOpis(preview.tehnickiOpis());
      }
    }

    // Map internal category from TecDoc genericArticleId when available
    Long genericArticleId = direct.getGenericArticleId();
    if (genericArticleId != null) {
      tecDocGenericArticleMappingService
          .resolvePodgrupaId(genericArticleId)
          .ifPresent(
              podgrupaId -> {
                dto.setPodGrupa(podgrupaId);
                articleSubGroupService
                    .vratiPodgrupuPoKljucu(podgrupaId)
                    .ifPresent(
                        podgrupa -> {
                          dto.setPodGrupaNaziv(podgrupa.getNaziv());
                          dto.setGrupa(podgrupa.getGrupaId());
                          Map<String, String> groupNames = articleGroupService.groupNamesById();
                          dto.setGrupaNaziv(groupNames.get(podgrupa.getGrupaId()));
                        });
              });
    }

    // Provider-backed availability/price for partner (when supported)
    robaEnrichmentService.applyPriceOnly(List.of(dto), ulogovaniPartner);

    return Optional.of(dto);
  }

  // *** Vrati detalje za robu pojedinacno ***
  private void setupDetails(RobaExpandedDto detaljnoDto, Partner partner) {
    popuniDetaljePrekoTecDoca(detaljnoDto);

    robaEnrichmentService.enrichDetails(detaljnoDto, partner);
    robaEnrichmentService.addManualDocuments(detaljnoDto);

    robaTekstService
        .pronadjiTextPoRobiId(detaljnoDto.getRobaid())
        .ifPresent(robaTekst -> detaljnoDto.setTekst(robaTekst.getTekst()));

    articleSubGroupService
        .vratiPodgrupuPoKljucu(Integer.valueOf(detaljnoDto.getPodGrupa()))
        .ifPresent(podGrupa -> detaljnoDto.setPodGrupaNaziv(podGrupa.getNaziv()));
  }

  private ProviderRoutingContext buildContext(Partner partner) {
    return ProviderRoutingContext.builder()
        .partnerId(partner != null ? partner.getPpid() : null)
        .partnerAudit(partner != null ? partner.getAudit() : null)
        .purpose(ProviderRoutingPurpose.DETAILS)
        .build();
  }

  // ---------------------------------------- TECDOC -------------------------------- TECDOC
  // ----------------------------------------

  /** Pozivamo servise tecdoca i punimo detalje */
  private void popuniDetaljePrekoTecDoca(RobaExpandedDto detaljiDto) {
    TecDocProizvodjaci tecDocProizvodjaci =
        TecDocProizvodjaci.pronadjiPoNazivu(detaljiDto.getProizvodjac().getProid());
    if (tecDocProizvodjaci == null) {
      return;
    }

    List<ArticlesByIds6Record> tecDocDetalji = new ArrayList<>();
    detaljiDto.setLinkedManufacturers(List.of());

    // *****************  Setuj linked manuf *************************
    Long tecDocArticleId = robaTecDocDetailsHelper.vratiTecDocArticleId(detaljiDto);
    if (tecDocArticleId != null) {
      detaljiDto.setTecDocArticleId(tecDocArticleId);
      tecDocDetalji = tecDocService.vratiDetaljeArtikla(tecDocArticleId);
      List<TecDocLinkedManufacturerDto> linkedManufacturers =
          tecDocService.getLinkedManufacturersByArticleId(
              tecDocArticleId, DEFAULT_LINKING_TARGET_TYPE);
      detaljiDto.setLinkedManufacturers(linkedManufacturers);
    }

    // ***************** Setujemo brand tecdoca ako postoje *************************
    tecDocService
        .vratiTecDocBrendovePrekoProId(detaljiDto.getProizvodjac().getProid())
        .ifPresent(
            tecDocBrands ->
                detaljiDto.setProizvodjacLogo(imageService.getImageForBrandLogo(tecDocBrands)));

    // ***************** Setujemo atribute iz tecdoca ako postoje *************************
    robaTecDocDetailsHelper.setujTehnickeDetalje(detaljiDto, tecDocDetalji);

    // ***************** Setujemo originalne brojeve iz tecdoca ako postoje
    // *************************
    robaTecDocDetailsHelper.setujOriginalneBrojeve(detaljiDto, tecDocDetalji);

    // ***************** Setujemo dokumentaciju iz tecdoca ako postoje *************************
    robaTecDocDetailsHelper.setujDokumentaciju(detaljiDto, tecDocDetalji);
  }

  private String buildArticleName(String name, String addName) {
    String base = name != null ? name.trim() : "";
    String add = addName != null ? addName.trim() : "";
    if (base.isBlank()) {
      return add.isBlank() ? null : add;
    }
    if (add.isBlank()) {
      return base;
    }
    return base + " " + add;
  }

  public Optional<RobaExpandedDto> uploadImg(Long robaId, MultipartFile file, Partner partner) {
    robaDatabaseService
        .findByRobaId(robaId)
        .orElseThrow(() -> new EntityNotFoundException("Article not found: " + robaId));

    imageService.saveImage(robaId, file);
    return fetchRobaDetails(robaId, partner);
  }

  public void deleteImg(Long robaId) {
    robaDatabaseService
        .findByRobaId(robaId)
        .orElseThrow(() -> new EntityNotFoundException("Article not found: " + robaId));

    imageService.deleteImage(robaId);
  }
}
