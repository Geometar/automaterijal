package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaBrojeviDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.dto.tecdoc.TecDocDokumentacija;
import com.automaterijal.application.domain.entity.GrupaDozvoljena;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.roba.RobaCene;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.patterns.factory.PretragaRobeFactory;
import com.automaterijal.application.patterns.strategy.roba.PretragaRobeStrategija;
import com.automaterijal.application.services.GrupaDozvoljenaService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.tecdoc.*;
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
public class RobaGlavniService {

  @NonNull final RobaService robaService;
  @NonNull final RobaCeneService robaCeneService;
  @NonNull final RobaAplikacijeServis aplikacijeServis;
  @NonNull final PodGrupaService podGrupaService;
  @NonNull final RobaTekstService robaTekstService;
  @NonNull final GrupaDozvoljenaService grupaDozvoljenaService;
  @NonNull final RobaMapper mapper;
  @NonNull final TecDocMapper tecDocMapper;
  @NonNull final TecDocService tecDocService;
  @NonNull final PretragaRobeFactory pretragaRobeFactory;
  @NonNull final RobaHelper robaHelper;

  /** Ulazna metoda iz kontrolera */
  public MagacinDto pronadjiRobuPoPretrazi(
      UniverzalniParametri parametri, Partner ulogovaniPartner) {
    // Koristimo fabriku da bismo dobili pravu strategiju
    PretragaRobeStrategija strategija = pretragaRobeFactory.getPretragaStrategija(parametri);
    return strategija.pretrazi(parametri, ulogovaniPartner);
  }

  public List<RobaDto> vratiIzdvajamoIzPonudeRobu(List<Long> robaIds, Partner partner) {
    List<Roba> robas = robaService.pronadjiRobuPoPrimarnomKljucuBatch(robaIds);
    List<RobaDto> retVal = robas.stream().map(mapper::map).toList();
    if (!retVal.isEmpty()) {
      setujZaTabeluDashboard(retVal, partner);
    }
    return retVal;
  }

  public Optional<RobaDetaljiDto> pronadjiRobuPoRobaId(Long robaId, Partner ulogovaniPartner) {
    Optional<RobaDetaljiDto> retVal = Optional.empty();
    Optional<Roba> roba = robaService.pronadjiRobuPoPrimarnomKljucu(robaId);
    if (roba.isPresent()) {
      RobaDetaljiDto detaljnoDto = mapper.mapujDetaljno(roba.get());
      setujZaDetalje(detaljnoDto, ulogovaniPartner);
      retVal = Optional.of(detaljnoDto);
    }
    return retVal;
  }

  /** Metoda za setovanje cena i tehnickog opisa u dto-u */
  private void setujZaTabeluDashboard(List<RobaDto> robaDtos, Partner partner) {
    List<String> dozvoljeneGrupeKljucevi =
        grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe().stream()
            .map(GrupaDozvoljena::getGrupaid)
            .toList();

    List<Long> robaIds = robaDtos.stream().map(RobaDto::getRobaid).toList();
    List<RobaCene> robaCenes = robaCeneService.pronadjiCeneZaRobuBatch(robaIds);
    robaDtos.forEach(
        robaDto -> {
          robaHelper.setCenuRobeTabela(robaDto, robaCenes, partner);
          robaDto.setSlika(robaHelper.vratiSliku(robaDto.getRobaid(), robaDto.getSlika()));
        });
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
    detaljnoDto.setSlika(robaHelper.vratiSliku(detaljnoDto.getRobaid(), detaljnoDto.getSlika()));

    if (detaljnoDto.getTehnickiOpis() == null) {
      detaljnoDto.setTehnickiOpis(
          setupTehnickeAtribute(
              tecDocService.vratiTecDocAtributePrekoRobeId(detaljnoDto.getRobaid())));
    }

    robaTekstService
        .pronadjiTextPoRobiId(detaljnoDto.getRobaid())
        .ifPresent(robaTekst -> detaljnoDto.setTekst(robaTekst.getTekst()));
    podGrupaService
        .vratiPodgrupuPoKljucu(Integer.valueOf(detaljnoDto.getPodGrupa()))
        .ifPresent(podGrupa -> detaljnoDto.setPodGrupa(podGrupa.getNaziv()));
  }

  private List<RobaTehnickiOpisDto> setupTehnickeAtribute(List<TecDocAtributi> source) {
    List<RobaTehnickiOpisDto> tehnickiOpisi = new ArrayList<>();
    source.forEach(
        data -> {
          if (data.getTecDocArticleId() != null && data.getDokumentId() == null) {
            RobaTehnickiOpisDto tehnickiOpisDto = new RobaTehnickiOpisDto();
            tehnickiOpisDto.setOznaka(data.getAttrShortName());
            tehnickiOpisDto.setJedinica(data.getAttrUnit());
            tehnickiOpisDto.setVrednost(data.getAttrValue());
            tehnickiOpisi.add(tehnickiOpisDto);
          }
        });

    return tehnickiOpisi;
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
    Long tecDocArticleId = vratiTecDocArticleId(detaljiDto);
    if (tecDocArticleId != null) {
      tecDocDetalji = tecDocService.vratiDetaljeArtikla(tecDocArticleId);
    }

    // ***************** Setujemo brand tecdoca ako postoje *************************

    tecDocService
        .vratiTecDocBrendovePrekoProId(detaljiDto.getProizvodjac().getProid())
        .ifPresent(tecDocBrands -> detaljiDto.setProizvodjacLogo(tecDocBrands.getBrand()));

    // ***************** Setujemo atribute iz tecdoca ako postoje *************************
    setujTehnickeDetalje(detaljiDto, tecDocDetalji);

    // ***************** Setujemo originalne brojeve iz tecdoca ako postoje
    // *************************
    List<RobaBrojeviDto> tdBrojevi = setujOriginalneBrojeve(detaljiDto, tecDocDetalji);

    // ***************** Setujemo sliku iz tecdoca ako postoje *************************
    setujSliku(detaljiDto, tdBrojevi);

    // ***************** Setujemo dokumentaciju iz tecdoca ako postoje *************************

    setujDokumentaciju(detaljiDto, tecDocDetalji);

    // ***************** Setujemo asocirane artikle *************************

    final List<RobaDto> asociraniArtikli = new ArrayList<>();

    tecDocDetalji.stream()
        .filter(rekord -> rekord.getMainArticle() != null)
        .map(ArticlesByIds6Record::getMainArticle)
        .flatMap(recordSeq -> recordSeq.getArray().stream())
        .forEach(
            mainArticlesRecord ->
                processMainArticle(mainArticlesRecord, partner, asociraniArtikli));

    if (!asociraniArtikli.isEmpty()) {
      detaljiDto.setAsociraniArtikli(asociraniArtikli);
    }
  }

  private void processMainArticle(
      MainArticlesRecord mainArticlesRecord, Partner partner, List<RobaDto> asociraniArtikli) {
    robaService.pronadjiRobuPoKataloskomBroju(mainArticlesRecord.getArticleNumber()).stream()
        .map(mapper::map)
        .filter(this::isValidProizvodjac)
        .forEach(robaDto -> handleRobaDto(robaDto, partner, asociraniArtikli));
  }

  private void handleRobaDto(RobaDto robaDto, Partner partner, List<RobaDto> asociraniArtikli) {
    List<TecDocAtributi> tecDocAtributi =
        tecDocService.vratiTecDocAtributePrekoRobeId(robaDto.getRobaid());

    if (tecDocAtributi.isEmpty()) {
      tecDocService.batchVracanjeICuvanjeTDAtributa(Collections.singletonList(robaDto));
      tecDocAtributi = tecDocService.vratiTecDocAtributePrekoRobeId(robaDto.getRobaid());
    }

    postaviSlikuIzAtributa(robaDto, tecDocAtributi);
    postaviCenuIRabat(robaDto, partner);
    asociraniArtikli.add(robaDto);
  }

  private void postaviSlikuIzAtributa(RobaDto robaDto, List<TecDocAtributi> tecDocAtributi) {
    tecDocAtributi.stream()
        .filter(tdAtributi -> tdAtributi.getDokument() != null)
        .forEach(
            tdAtributi -> {
              SlikaDto slikaDto = new SlikaDto();
              slikaDto.setUrl(false);
              slikaDto.setSlikeByte(tdAtributi.getDokument());
              robaDto.setSlika(slikaDto);
            });
  }

  private void postaviCenuIRabat(RobaDto robaDto, Partner partner) {
    robaDto.setCena(
        robaCeneService.vratiCenuRobePoRobiId(
            robaDto.getRobaid(), robaDto.getGrupa(), robaDto.getProizvodjac().getProid(), partner));

    robaDto.setRabat(
        robaCeneService.vratiRabatPartneraNaArtikal(
            robaDto.getProizvodjac().getProid(), robaDto.getGrupa(), partner));
  }

  private boolean isValidProizvodjac(RobaDto robaDto) {
    return TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid()) != null;
  }

  private void setujDokumentaciju(
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
    }
    if (!dokumenta.isEmpty()) {
      mapaDokumentacije =
          dokumenta.stream().collect(Collectors.groupingBy(TecDocDokumentacija::getDocTypeName));

      mapaDokumentacije.remove("Slika");
    }
    if (!mapaDokumentacije.isEmpty()) {
      Set<String> kljuceviDokumenata = mapaDokumentacije.keySet();
      for (String kljuc : kljuceviDokumenata) {
        ListIterator<TecDocDokumentacija> iter = mapaDokumentacije.get(kljuc).listIterator();
        boolean hasMoreUrl = false;
        while (iter.hasNext()) {
          TecDocDokumentacija docDokumentacija = iter.next();
          if (docDokumentacija.getDocFileTypeName().toUpperCase().contains("URL") && !hasMoreUrl) {
            hasMoreUrl = true;
          } else if (docDokumentacija.getDocFileTypeName().toUpperCase().contains("URL")
              && hasMoreUrl) {
            iter.remove();
          }
        }
      }
      detaljiDto.setDokumentacija(mapaDokumentacije);
    }
  }

  private void setujSliku(RobaDetaljiDto detaljiDto, List<RobaBrojeviDto> tdBrojevi) {
    List<TecDocAtributi> tecDocAtributi =
        tecDocService.vratiTecDocAtributePrekoRobeId(detaljiDto.getRobaid());
    if (!tdBrojevi.isEmpty()) {
      for (TecDocAtributi dto : tecDocAtributi) {
        SlikaDto slikaDto = new SlikaDto();
        slikaDto.setUrl(false);
        slikaDto.setSlikeByte(dto.getDokument());
        detaljiDto.setSlika(slikaDto);
      }
    }
  }

  private static List<RobaBrojeviDto> setujOriginalneBrojeve(
      RobaDetaljiDto detaljiDto, List<ArticlesByIds6Record> tecDocDetalji) {
    Map<String, List<RobaBrojeviDto>> robaBrojeviMap = new HashMap<>();
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

  private static void setujTehnickeDetalje(
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

  private Long vratiTecDocArticleId(RobaDetaljiDto detaljiDto) {
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
      Optional<Integer> tecDocArticleIdOptional =
          tecDocAtributi.stream()
              .filter(atributi -> atributi.getTecDocArticleId() != null)
              .map(TecDocAtributi::getTecDocArticleId)
              .findFirst();
      if (tecDocArticleIdOptional.isPresent()) {
        tecDocArticleId = Long.valueOf(tecDocArticleIdOptional.get());
      }
    }
    return tecDocArticleId;
  }
}
