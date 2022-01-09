package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
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
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.GrupaDozvoljenaService;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.SlikeService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.tecdoc.*;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaGlavniService {

    @NonNull
    final RobaService robaService;
    @NonNull
    final RobaJooqRepository jooqRepository;
    @NonNull
    final RobaCeneService robaCeneService;
    @NonNull
    final RobaTehnickiOpisServis tehnickiOpisServis;
    @NonNull
    final RobaBrojeviServis brojeviServis;
    @NonNull
    final RobaAplikacijeServis aplikacijeServis;
    @NonNull
    final SlikeService slikeService;
    @NonNull
    final ProizvodjacService proizvodjacService;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaTekstService robaTekstService;
    @NonNull
    final GrupaDozvoljenaService grupaDozvoljenaService;
    @NonNull
    final RobaMapper mapper;
    @NonNull
    final TecDocMapper tecDocMapper;
    @NonNull
    final TecDocService tecDocService;

    private static final Integer VRSTA_ORIGINALNI = 3;
    private static final Integer VRSTA_PROIZVODJACI = 4;

    /**
     * Ulazna metoda iz kontrolera
     */
    public MagacinDto pronadjiRobuPoPretrazi(UniverzalniParametri parametri, Partner ulogovaniPartner) {
        MagacinDto magacinDto;
        log.info("Partner {} trazi robu na stranici {} po kataloskom broju {} i prozivodjacu {}",
                ulogovaniPartner != null ? ulogovaniPartner.getNaziv() : "anoniman",
                parametri.getRobaKategorije() != null ? parametri.getRobaKategorije().getFieldName() : " - ",
                parametri.getTrazenaRec() != null ? parametri.getTrazenaRec() : "-",
                parametri.getProizvodjac() != null ? parametri.getProizvodjac() : "-"
        );

        if (parametri.getTrazenaRec() == null && parametri.getProizvodjac() == null && parametri.getGrupa() == null && parametri.getPodgrupaZaPretragu() == null) {
            magacinDto = logikaZaMagacinBezFiltera(parametri, ulogovaniPartner);
        } else {
            magacinDto = logikaZaMagacinSaFilterom(parametri, ulogovaniPartner);
        }
        return magacinDto;
    }

    private MagacinDto logikaZaMagacinBezFiltera(UniverzalniParametri parametri, Partner ulogovaniPartner) {
        var magacinDto = new MagacinDto();
        var pageable = PageRequest.of(
                parametri.getPage(), parametri.getPageSize(), Sort.by(Sort.Direction.DESC, RobaSortiranjePolja.STANJE.getFieldName())
        );

        Page<RobaDto> robaDto = vratiSvuRobuUZavisnostiOdTrazenogStanja(parametri, pageable, ulogovaniPartner);
        if (parametri.getRobaKategorije() == null) {
            magacinDto.setPodgrupe(podGrupaService.vratiSveGrupeNazive());
        } else if (parametri.getRobaKategorije() != null) {
            magacinDto.setPodgrupe(vratiSvePodgrupePoNazivu(parametri));
        }
        magacinDto.setProizvodjaci(proizvodjacService.pronadjiSveProizvodjaceZaVrstu(parametri));
        magacinDto.setRobaDto(robaDto);

        return magacinDto;
    }

    private List<String> vratiSvePodgrupePoNazivu(UniverzalniParametri parametri) {
        Set<String> podGrupeSet = new HashSet<>();
        if (!parametri.getPodGrupe().isEmpty()) {
            List<String> podGrupe = parametri.getPodGrupe().stream().map(PodGrupa::getNaziv).collect(Collectors.toList());
            podGrupeSet = podGrupaService.vratiSvePodGrupePoNazivima(podGrupe).stream().map(PodGrupa::getNaziv).map(String::toUpperCase).collect(Collectors.toSet());
        } else {
            podGrupaService.vratiSvePodGrupePoGrupi(parametri.getGrupa());
        }
        return new ArrayList<>(podGrupeSet).stream().sorted().collect(Collectors.toList());
    }

    private MagacinDto logikaZaMagacinSaFilterom(UniverzalniParametri parametri, Partner ulogovaniPartner) {
        var magacinDto = new MagacinDto();
        if (parametri.getTrazenaRec() != null) {
            magacinDto = logikaZaMagacinSaTrazenomRecju(parametri, ulogovaniPartner);
        } else {
            magacinDto = jooqRepository.pronadjiPoTrazenojReci(parametri, parametri.getTrazenaRec());
        }

        if (!magacinDto.getRobaDto().isEmpty()) {
            magacinDto.getRobaDto().forEach(dto -> setujZaTabelu(dto, parametri, ulogovaniPartner));
        }
        return magacinDto;
    }

    private MagacinDto logikaZaMagacinSaTrazenomRecju(UniverzalniParametri parametri, Partner ulogovaniPartner) {
        MagacinDto retVal = new MagacinDto();
        String pregragaPoTacnojReciLike = "%" + parametri.getTrazenaRec() + "%";
        String trazenaRecLike = "%" + parametri.getTrazenaRec().replaceAll("\\s+", "") + "%";
        String tacnaRec = parametri.getTrazenaRec().replaceAll("\\s+", "");

        Set<String> kataloskiBrojevi = new HashSet<>();
        Set<Integer> robaId = new HashSet<>();
        boolean daLiJeTrazenaRecNaziv = jooqRepository.pomocniKveriPoRobi(trazenaRecLike, pregragaPoTacnojReciLike, kataloskiBrojevi, robaId);
        if (!daLiJeTrazenaRecNaziv) {
            List<ArticleDirectSearchAllNumbersWithStateRecord> response = tecDocService.tecDocPretragaPoTrazenojReci(tacnaRec, null, 10);
            parametri.setKesiranDirectArticleSearch(response);
            kataloskiBrojevi = response
                    .stream()
                    .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleNo)
                    .collect(Collectors.toSet());
            kataloskiBrojevi.add(tacnaRec);
            jooqRepository.pomocniKveriPoRobiOld(pregragaPoTacnojReciLike, kataloskiBrojevi);
        }
        if (kataloskiBrojevi.isEmpty()) {
            retVal = jooqRepository.pronadjiPoTrazenojReci(parametri, tacnaRec);
        } else {
            retVal = jooqRepository.vratiArtikleIzTecDoca(parametri, kataloskiBrojevi, daLiJeTrazenaRecNaziv ? pregragaPoTacnojReciLike : null);
        }

        return retVal;
    }

    /**
     * Roba koja je na stanju, rezultat zavisi od vrste i od filtera da li je na stanju
     */
    private Page<RobaDto> vratiSvuRobuUZavisnostiOdTrazenogStanja(UniverzalniParametri parametri, Pageable pageable, Partner ulogovaniPartner) {
        Page<Roba> roba;
        boolean naStanju = parametri.isNaStanju();
        if (parametri.getRobaKategorije() == null) {
            roba = robaService.pronadjiSvuRobu(naStanju, pageable);
        } else if (parametri.getRobaKategorije().isGrupaPretraga()) {
            roba = robaService.pronadjiSvuRobuPoGrupiIdNaStanju(parametri.getRobaKategorije().getFieldName(), naStanju, pageable);
        } else if (parametri.getRobaKategorije().isPodgrupaPretraga()) {
            if (parametri.getPodgrupaZaPretragu() != null) {
                List<PodGrupa> podGrupaList = parametri.getPodGrupe().stream().filter(podGrupa -> podGrupa.getNaziv().equals(parametri.getPodgrupaZaPretragu())).collect(Collectors.toList());
                roba = jooqRepository.pronadjiSvuRobuPoPodgrupama(podGrupaList, naStanju, pageable);
            } else {
                roba = jooqRepository.pronadjiSvuRobuPoPodgrupama(parametri.getPodGrupe(), naStanju, pageable);
            }
        } else {
            roba = null;
            log.error("Ne definisana roba!");
        }

        List<RobaDto> dto = roba.stream().map(robaEntitet -> {
            RobaDto robaDto = mapper.map(robaEntitet);
            setujZaTabelu(robaDto, parametri, ulogovaniPartner);
            return robaDto;
        }).collect(Collectors.toList());

        return new PageImpl<>(dto, roba.getPageable(), roba.getTotalElements());
    }

    /**
     * Metoda za setovanje cena i tehnickog opisa u dto-u
     */
    private void setujZaTabelu(RobaDto robaDto, UniverzalniParametri parametri, Partner partner) {
//        ******************  Deo za dodavanje tehnickog opisa ************************************
        List<RobaTehnickiOpisDto> tehnickiOpisi = new ArrayList<>();
        final TecDocProizvodjaci tecDocProizvodjaci = TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid());
        if (tecDocProizvodjaci != null) {
            tecDocService.vratiTecDocBrendovePrekoProId(robaDto.getProizvodjac().getProid()).ifPresent(tecDocBrands -> {
                robaDto.setProizvodjacLogo(tecDocBrands.getBrand());
            });
            List<TecDocAtributi> tecDocAtributi = tecDocService.vratiTecDocAtributePrekoRobeId(robaDto.getRobaid());
            if (tecDocAtributi.isEmpty()) {
                if (parametri != null && parametri.getKesiranDirectArticleSearch() != null) {
                    tehnickiOpisi = vratiTehnickeDetalje(robaDto, parametri.getKesiranDirectArticleSearch(), tecDocProizvodjaci);
                } else {
                    List<ArticleDirectSearchAllNumbersWithStateRecord> records = tecDocService.tecDocPretragaPoTrazenojReci(robaDto.getKatbr(), tecDocProizvodjaci.getTecDocId(), 0);
                    tehnickiOpisi = vratiTehnickeDetalje(robaDto, records, tecDocProizvodjaci);
                }
            } else {
                for (TecDocAtributi dto : tecDocAtributi) {
                    if (dto.getTecDocArticleId() != null) {
                        if (dto.getDokumentId() == null && dto.getAttrType().equals("N")) {
                            RobaTehnickiOpisDto tehnickiOpisDto = new RobaTehnickiOpisDto();
                            tehnickiOpisDto.setOznaka(dto.getAttrShortName());
                            tehnickiOpisDto.setJedinica(dto.getAttrUnit());
                            tehnickiOpisDto.setVrednost(dto.getAttrValue());
                            tehnickiOpisi.add(tehnickiOpisDto);
                        } else {
                            robaDto.setDokumentSlikaId(dto.getDokumentId());
                            robaDto.setDokument(dto.getDokument());
                        }
                    }
                }
            }
        }
        if (tehnickiOpisi.isEmpty()) {
            tehnickiOpisi = tehnickiOpisServis.vratiTehnickiOpisPoIdRobe(robaDto.getRobaid());
        }
//        *************************** Kraj dela za dodavanje tehnickog opisa ************************************

        robaDto.setCena(robaCeneService.vratiCenuRobePoRobiId(robaDto.getRobaid(), robaDto.getGrupa(), robaDto.getProizvodjac().getProid(), partner));
        robaDto.setRabat(robaCeneService.vratiRabatPartneraNaArtikal(robaDto.getProizvodjac().getProid(), robaDto.getGrupa(), partner));
        if (tehnickiOpisi.size() > 5) {
            robaDto.setTehnickiOpis(tehnickiOpisi.stream().limit(4).collect(Collectors.toList()));
        } else {
            robaDto.setTehnickiOpis(tehnickiOpisi);
        }

        List<String> dozvoljeneGrupeKljucevi = grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe().stream()
                .map(GrupaDozvoljena::getGrupaid)
                .collect(Collectors.toList());

        if (!dozvoljeneGrupeKljucevi.contains(robaDto.getGrupa())) {
            robaDto.setDozvoljenoZaAnonimusa(false);
        } else {
            robaDto.setDozvoljenoZaAnonimusa(true);
        }

        // Postoji dokument u tecDocu
        if (robaDto.getDokument() != null) {
            SlikaDto slikaDto = new SlikaDto();
            slikaDto.setSlikeByte(robaDto.getDokument());
            slikaDto.setUrl(false);
            robaDto.setSlika(slikaDto);
        } else {
            robaDto.setSlika(slikeService.vratiPutanjuDoSlike(robaDto.getProizvodjac().getProid(), robaDto.getKatbr(), robaDto.getRobaid()));
        }


        //Set brand logo
        podGrupaService.vratiPodgrupuPoKljucu(robaDto.getPodGrupa()).ifPresent(podGrupa -> robaDto.setPodGrupaNaziv(podGrupa.getNaziv()));
    }

    /**
     * Vrati tehnicke detalje iz TecDoca-a
     */
    public List<RobaTehnickiOpisDto> vratiTehnickeDetalje(RobaDto robaDto, List<ArticleDirectSearchAllNumbersWithStateRecord> articleRecords, TecDocProizvodjaci tecDocProizvodjaci) {
        List<RobaTehnickiOpisDto> retVal = new ArrayList<>();

        // Pronadjimo odgovarajuci record koji pase za robaDTO
        Optional<ArticleDirectSearchAllNumbersWithStateRecord> articleTecDoc = articleRecords.stream()
                .filter(articleRecord -> {
                    return articleRecord.getArticleNo().equals(robaDto.getKatbr()) && articleRecord.getBrandNo().intValue() == tecDocProizvodjaci.getTecDocId();
                })
                .findFirst();

        if (articleTecDoc.isPresent()) {
            setovanjeTecDocAtributa(articleTecDoc.get().getArticleId(), tecDocProizvodjaci, retVal, robaDto);
        } else {
            // Setuj prazar rekord, nema u tecdocu nema potrebe da se pretrazuje ponovo
            TecDocAtributi atributi = new TecDocAtributi();
            atributi.setRobaId(robaDto.getRobaid());
            atributi.setKatbr(robaDto.getKatbr());
            tecDocService.sacuvajTecDocAtribute(atributi);
        }
        return retVal;
    }

    private void setovanjeTecDocAtributa(Long articleTecDocId, TecDocProizvodjaci tecDocProizvodjaci, List<RobaTehnickiOpisDto> retVal, RobaDto robaDto) {
        // Setovanje tecdoc detalja
        List<ArticlesByIds6Record> records = tecDocService.vratiDetaljeArtikla(articleTecDocId);
        records.stream()
                .map(ArticlesByIds6Record::getArticleAttributes)
                .flatMap(record -> record.getArray().stream())
                .forEach(att -> {
                    if (att.getAttrType().equals("N")) {
                        RobaTehnickiOpisDto tehnickiOpisDto = new RobaTehnickiOpisDto();
                        tehnickiOpisDto.setVrednost(att.getAttrValue());
                        tehnickiOpisDto.setJedinica(att.getAttrUnit());
                        tehnickiOpisDto.setOznaka(att.getAttrShortName());
                        retVal.add(tehnickiOpisDto);
                    }
                    TecDocAtributi atributi = tecDocMapper.map(att, robaDto, articleTecDocId, tecDocProizvodjaci.getTecDocId());
                    tecDocService.sacuvajTecDocAtribute(atributi);
                });

        // Setovanje slike
        List<ArticleDocuments2Record> dokumentRekordi = records.stream()
                .filter(rekord -> rekord.getArticleDocuments() != null)
                .map(ArticlesByIds6Record::getArticleDocuments)
                .flatMap(record -> record.getArray().stream())
                .collect(Collectors.toList());

        for (ArticleDocuments2Record dokument : dokumentRekordi) {
            if (dokument.getDocTypeId() == 1L) {
                byte[] dokumentSlike = tecDocService.vratiDokument(dokument.getDocId(), 0);
                robaDto.setDokumentSlikaId(dokument.getDocId());
                robaDto.setDokument(dokumentSlike);

                // Kesiranje slike u bazi
                TecDocAtributi atributi = tecDocMapper.map(dokument, robaDto, articleTecDocId, tecDocProizvodjaci.getTecDocId());
                atributi.setDokument(dokumentSlike);
                tecDocService.sacuvajTecDocAtribute(atributi);
                break;
            }
        }
    }

    public List<RobaDto> vratiIzdvajamoIzPonudeRobu(List<Long> robaIds, Partner partner) {
        List<RobaDto> retVal = new ArrayList<>();
        robaIds.forEach(robaId -> {
            RobaDto roba = mapper.map(
                    robaService.pronadjiRobuPoPrimarnomKljucu(robaId).get()
            );
            setujZaTabelu(roba, null, partner);
            retVal.add(roba);
        });
        return retVal;
    }

    // ************************************ Vrati detalje za robu pojedinacno ***************************************************************

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

    private void setujZaDetalje(RobaDetaljiDto detaljnoDto, Partner partner) {
        if (detaljnoDto != null) {
            detaljnoDto.setCena(robaCeneService.vratiCenuRobePoRobiId(detaljnoDto.getRobaid(), detaljnoDto.getGrupa(), detaljnoDto.getProizvodjac().getProid(), partner));
            detaljnoDto.setRabat(robaCeneService.vratiRabatPartneraNaArtikal(detaljnoDto.getProizvodjac().getProid(), detaljnoDto.getGrupa(), partner));
            detaljnoDto.setAplikacije(aplikacijeServis.vratiAplikacijeZaDetalje(detaljnoDto.getRobaid()));

            popuniDetaljePrekoTecDoca(detaljnoDto, partner);

            if (detaljnoDto.getSlika() == null) {
                detaljnoDto.setSlika(slikeService.vratiPutanjuDoSlike(detaljnoDto.getProizvodjac().getProid(), detaljnoDto.getKatbr(), detaljnoDto.getRobaid()));
            }

            if (detaljnoDto.getTehnickiOpis() == null) {
                detaljnoDto.setTehnickiOpis(tehnickiOpisServis.vratiTehnickiOpisPoIdRobe(detaljnoDto.getRobaid()));
            }

            if (detaljnoDto.getTdBrojevi() == null) {
                detaljnoDto.setTdBrojevi(brojeviServis.vratiSveBrojeveZaRobidIVrsti(detaljnoDto.getRobaid(), VRSTA_ORIGINALNI));
            }

            List<String> dozvoljeneGrupeKljucevi = grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe().stream()
                    .map(GrupaDozvoljena::getGrupaid)
                    .collect(Collectors.toList());

            if (partner == null && !dozvoljeneGrupeKljucevi.contains(detaljnoDto.getGrupa())) {
                detaljnoDto.setDozvoljenoZaAnonimusa(false);
            } else {
                detaljnoDto.setDozvoljenoZaAnonimusa(true);
            }

            robaTekstService.pronadjiTextPoRobiId(detaljnoDto.getRobaid()).ifPresent(robaTekst -> detaljnoDto.setTekst(robaTekst.getTekst()));
            podGrupaService.vratiPodgrupuPoKljucu(detaljnoDto.getPodGrupa()).ifPresent(podGrupa -> detaljnoDto.setPodGrupa(podGrupa.getNaziv()));
        }
    }

    /**
     * Pozivamo servise tecdoca i punimo detalje
     */
    private void popuniDetaljePrekoTecDoca(RobaDetaljiDto detaljiDto, Partner partner) {
        TecDocProizvodjaci tecDocProizvodjaci = TecDocProizvodjaci.pronadjiPoNazivu(detaljiDto.getProizvodjac().getProid());
        if (tecDocProizvodjaci == null) {
            return;
        }
        List<ArticlesByIds6Record> tecDocDetalji = new ArrayList<>();
        Long tecDocArticleId = vratiTecDocArticleId(detaljiDto);
        if (tecDocArticleId != null) {
            tecDocDetalji = tecDocService.vratiDetaljeArtikla(tecDocArticleId);
        }

        //***************** Setujemo brand tecdoca ako postoje *************************

        tecDocService.vratiTecDocBrendovePrekoProId(detaljiDto.getProizvodjac().getProid()).ifPresent(tecDocBrands -> {
            detaljiDto.setProizvodjacLogo(tecDocBrands.getBrand());
        });

        //***************** Setujemo atribute iz tecdoca ako postoje *************************
        List<AssignedArticleAttributs2Record> atributiRecord = tecDocDetalji.stream()
                .map(ArticlesByIds6Record::getArticleAttributes)
                .flatMap(record -> record.getArray().stream())
                .collect(Collectors.toList());

        List<RobaTehnickiOpisDto> tehnickiOpis = new ArrayList<>();
        for (AssignedArticleAttributs2Record rekord : atributiRecord) {
            RobaTehnickiOpisDto tehnickiOpisDto = new RobaTehnickiOpisDto();
            tehnickiOpisDto.setVrednost(rekord.getAttrValue());
            tehnickiOpisDto.setOznaka(rekord.getAttrShortName());
            tehnickiOpisDto.setJedinica(rekord.getAttrValue());
            tehnickiOpis.add(tehnickiOpisDto);
        }

        if (!tehnickiOpis.isEmpty()) {
            detaljiDto.setTehnickiOpis(tehnickiOpis);
        }


        //***************** Setujemo originalne brojeve iz tecdoca ako postoje *************************
        Map<String, List<RobaBrojeviDto>> robaBrojeviMap = new HashMap<>();
        List<ArticleOENumbersRecord> oeNumbersRecords = tecDocDetalji.stream()
                .map(ArticlesByIds6Record::getOenNumbers)
                .flatMap(record -> record.getArray().stream())
                .collect(Collectors.toList());

        List<RobaBrojeviDto> tdBrojevi = new ArrayList<>();
        for (ArticleOENumbersRecord rekord : oeNumbersRecords) {
            RobaBrojeviDto dto = new RobaBrojeviDto();
            dto.setProizvodjac(rekord.getBrandName());
            dto.setFabrBroj(rekord.getOeNumber());
            tdBrojevi.add(dto);
        }

        if (!tdBrojevi.isEmpty()) {
            robaBrojeviMap = tdBrojevi.stream().collect(Collectors.groupingBy(RobaBrojeviDto::getProizvodjac));
        }
        if (!robaBrojeviMap.isEmpty()) {
            detaljiDto.setTdBrojevi(robaBrojeviMap);
        }


        //***************** Setujemo sliku iz tecdoca ako postoje *************************
        List<TecDocAtributi> tecDocAtributi = tecDocService.vratiTecDocAtributePrekoRobeId(detaljiDto.getRobaid());
        if (!tdBrojevi.isEmpty()) {
            for (TecDocAtributi dto : tecDocAtributi) {
                SlikaDto slikaDto = new SlikaDto();
                slikaDto.setUrl(false);
                slikaDto.setSlikeByte(dto.getDokument());
                detaljiDto.setSlika(slikaDto);
            }
        }

        //***************** Setujemo dokumentaciju iz tecdoca ako postoje *************************

        List<TecDocDokumentacija> dokumenta = tecDocDetalji.stream()
                .map(ArticlesByIds6Record::getArticleDocuments)
                .flatMap(record -> record.getArray().stream())
                .filter(record -> record.getDocTypeId() != 1L)
                .map(tecDocMapper::map)
                .collect(Collectors.toList());

        Map<String, List<TecDocDokumentacija>> mapaDokumentacije = new HashMap<>();
        dokumenta.forEach(dokument -> {
            if (dokument.getDocFileTypeName().contains("PDF")) {
                dokument.setDokument(tecDocService.vratiDokument(dokument.getDocId(), 1));
            }
        });
        if (!dokumenta.isEmpty()) {
            mapaDokumentacije = dokumenta.stream().collect(Collectors.groupingBy(TecDocDokumentacija::getDocTypeName));
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
                    } else if (docDokumentacija.getDocFileTypeName().toUpperCase().contains("URL") && hasMoreUrl) {
                        iter.remove();
                    }
                }
            }
            detaljiDto.setDokumentacija(mapaDokumentacije);
        }

        //***************** Setujemo asocirane artikle *************************

        final List<RobaDto> asociraniArtikli = new ArrayList<>();

        tecDocDetalji.stream().filter(rekord -> rekord.getMainArticle() != null).map(ArticlesByIds6Record::getMainArticle).flatMap(record -> record.getArray().stream()).forEach(mainArticlesRecord -> {
            robaService.pronadjiRobuPoKataloskomBroju(mainArticlesRecord.getArticleNumber()).stream()
                    .map(mapper::map)
                    .filter(robaDto -> TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid()) != null)
                    .forEach(robaDto -> {
                        List<TecDocAtributi> tecDocAtribut = tecDocService.vratiTecDocAtributePrekoRobeId(robaDto.getRobaid());
                        if (tecDocAtribut.isEmpty()) {
                            setovanjeTecDocAtributa(mainArticlesRecord.getArticleId(), TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid()), new ArrayList<>(), robaDto);
                            tecDocAtribut = tecDocService.vratiTecDocAtributePrekoRobeId(robaDto.getRobaid());
                        }
                        tecDocAtribut.forEach(tdAtributi -> {
                            if (tdAtributi.getDokument() != null) {
                                SlikaDto slikaDto = new SlikaDto();
                                slikaDto.setUrl(false);
                                slikaDto.setSlikeByte(tdAtributi.getDokument());
                                robaDto.setSlika(slikaDto);
                            }
                        });
                        robaDto.setCena(robaCeneService.vratiCenuRobePoRobiId(robaDto.getRobaid(), robaDto.getGrupa(), robaDto.getProizvodjac().getProid(), partner));
                        robaDto.setRabat(robaCeneService.vratiRabatPartneraNaArtikal(robaDto.getProizvodjac().getProid(), robaDto.getGrupa(), partner));
                        asociraniArtikli.add(robaDto);
                    });
        });

        if (!asociraniArtikli.isEmpty()) {
            detaljiDto.setAsociraniArtikli(asociraniArtikli);
        }
    }

    private Long vratiTecDocArticleId(RobaDetaljiDto detaljiDto) {
        List<TecDocAtributi> tecDocAtributi = tecDocService.vratiTecDocAtributePrekoRobeId(detaljiDto.getRobaid());
        TecDocProizvodjaci tecDocProizvodjaci = TecDocProizvodjaci.pronadjiPoNazivu(detaljiDto.getProizvodjac().getProid());
        Long tecDocArticleId = null;
        if (tecDocAtributi.isEmpty() && tecDocProizvodjaci != null) {
            Optional<Long> tecDocArticleIdOptional = tecDocService.tecDocPretragaPoTrazenojReci(detaljiDto.getKatbr(), tecDocProizvodjaci.getTecDocId(), 0)
                    .stream()
                    .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
                    .findFirst();
            if (tecDocArticleIdOptional.isPresent()) {
                tecDocArticleId = tecDocArticleIdOptional.get();
            }
        } else if (!tecDocAtributi.isEmpty()) {
            Optional<Integer> tecDocArticleIdOptional = tecDocAtributi.stream().map(TecDocAtributi::getTecDocArticleId).findFirst();
            if (tecDocArticleIdOptional.isPresent()) {
                tecDocArticleId = Long.valueOf(tecDocArticleIdOptional.get());
            }
        }
        return tecDocArticleId;
    }

    // ******************************************************************************************************************************
}
