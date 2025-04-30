package com.automaterijal.application.services.roba.details;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaBrojeviDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.services.SlikeService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaAplikacijeServis;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.RobaTekstService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.services.roba.processor.RobaDetailsProcessor;
import com.automaterijal.application.services.roba.repo.RobaRepositoryService;
import com.automaterijal.application.services.roba.util.RobaHelper;
import com.automaterijal.application.services.roba.util.RobaTecDocDetailsHelper;
import com.automaterijal.application.tecdoc.*;
import java.util.*;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
@Slf4j
public class RobaDetailsService {

  @NonNull final RobaRepositoryService robaRepositoryService;
  @NonNull final RobaCeneService robaCeneService;
  @NonNull final RobaAplikacijeServis aplikacijeServis;
  @NonNull final PodGrupaService podGrupaService;
  @NonNull final RobaTekstService robaTekstService;
  @NonNull final RobaMapper mapper;
  @NonNull final TecDocService tecDocService;
  @NonNull final RobaHelper robaHelper;
  @NonNull final RobaTecDocDetailsHelper robaTecDocDetailsHelper;
  @NonNull final SlikeService slikeService;
  @NonNull final RobaDetailsProcessor robaDetailsProcessor;

  public Optional<RobaDetaljiDto> pronadjiRobuPoRobaId(Long robaId, Partner ulogovaniPartner) {
    Optional<RobaDetaljiDto> retVal = Optional.empty();
    Optional<Roba> roba = robaRepositoryService.pronadjiRobuPoPrimarnomKljucu(robaId);
    if (roba.isPresent()) {
      RobaDetaljiDto detaljnoDto = mapper.mapujDetaljno(roba.get());
      setujZaDetalje(detaljnoDto, ulogovaniPartner);
      retVal = Optional.of(detaljnoDto);
    }
    return retVal;
  }

  // ************************************ Vrati detalje za robu pojedinacno
  // ***************************************************************

  private void setujZaDetalje(RobaDetaljiDto detaljnoDto, Partner partner) {
    detaljnoDto.setCena(
        robaCeneService.vratiCenuRobePoRobiId(
            detaljnoDto.getRobaid(),
            detaljnoDto.getGrupa(),
            detaljnoDto.getProizvodjac().getProid(),
            partner));
    detaljnoDto.setRabat(
        robaCeneService.vratiRabatPartneraNaArtikal(
            detaljnoDto.getProizvodjac().getProid(), detaljnoDto.getGrupa(), partner));
    detaljnoDto.setAplikacije(aplikacijeServis.vratiAplikacijeZaDetalje(detaljnoDto.getRobaid()));

    popuniDetaljePrekoTecDoca(detaljnoDto, partner);
    detaljnoDto.setSlika(robaHelper.resolveImage(detaljnoDto.getRobaid(), detaljnoDto.getSlika()));

    if (detaljnoDto.getTehnickiOpis() == null) {
      robaHelper.setupTechnicalAttributesForDetails(
          tecDocService.vratiTecDocAtributePrekoRobeId(detaljnoDto.getRobaid()), detaljnoDto);
    }

    robaTekstService
        .pronadjiTextPoRobiId(detaljnoDto.getRobaid())
        .ifPresent(robaTekst -> detaljnoDto.setTekst(robaTekst.getTekst()));
    podGrupaService
        .vratiPodgrupuPoKljucu(Integer.valueOf(detaljnoDto.getPodGrupa()))
        .ifPresent(podGrupa -> detaljnoDto.setPodGrupa(podGrupa.getNaziv()));
  }

  // ---------------------------------------- TECDOC -------------------------------- TECDOC
  // ----------------------------------------

  /** Pozivamo servise tecdoca i punimo detalje */
  private void popuniDetaljePrekoTecDoca(RobaDetaljiDto detaljiDto, Partner partner) {
    TecDocProizvodjaci tecDocProizvodjaci =
        TecDocProizvodjaci.pronadjiPoNazivu(detaljiDto.getProizvodjac().getProid());
    if (tecDocProizvodjaci == null) {
      return;
    }
    List<ArticlesByIds6Record> tecDocDetalji = new ArrayList<>();
    Long tecDocArticleId = robaTecDocDetailsHelper.vratiTecDocArticleId(detaljiDto);
    if (tecDocArticleId != null) {
      tecDocDetalji = tecDocService.vratiDetaljeArtikla(tecDocArticleId);
    }

    // ***************** Setujemo brand tecdoca ako postoje *************************

    tecDocService
        .vratiTecDocBrendovePrekoProId(detaljiDto.getProizvodjac().getProid())
        .ifPresent(
            tecDocBrands ->
                detaljiDto.setProizvodjacLogo(slikeService.getImageForBrandLogo(tecDocBrands)));

    // ***************** Setujemo atribute iz tecdoca ako postoje *************************
    robaTecDocDetailsHelper.setujTehnickeDetalje(detaljiDto, tecDocDetalji);

    // ***************** Setujemo originalne brojeve iz tecdoca ako postoje
    // *************************
    List<RobaBrojeviDto> tdBrojevi =
        robaTecDocDetailsHelper.setujOriginalneBrojeve(detaljiDto, tecDocDetalji);

    // ***************** Setujemo sliku iz tecdoca ako postoje *************************
    robaDetailsProcessor.setujSliku(detaljiDto, tdBrojevi);

    // ***************** Setujemo dokumentaciju iz tecdoca ako postoje *************************

    robaTecDocDetailsHelper.setujDokumentaciju(detaljiDto, tecDocDetalji);

    // ***************** Setujemo asocirane artikle *************************

    final List<RobaDto> asociraniArtikli = new ArrayList<>();

    tecDocDetalji.stream()
        .filter(rekord -> rekord.getMainArticle() != null)
        .map(ArticlesByIds6Record::getMainArticle)
        .flatMap(recordSeq -> recordSeq.getArray().stream())
        .forEach(
            mainArticlesRecord ->
                robaDetailsProcessor.processMainArticle(
                    mainArticlesRecord, partner, asociraniArtikli));

    if (!asociraniArtikli.isEmpty()) {
      detaljiDto.setAsociraniArtikli(asociraniArtikli);
    }
  }
}
