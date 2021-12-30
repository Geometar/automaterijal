package com.automaterijal.application.services.roba;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.GrupaDozvoljena;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.GrupaDozvoljenaService;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.SlikeService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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
    final TecDocClient tecDocClient;

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
        if(parametri.getTrazenaRec() != null) {
            magacinDto = logikaZaMagacinSaTrazenomRecju(parametri, ulogovaniPartner);
        } else {
            magacinDto = jooqRepository.pronadjiPoTrazenojReci(parametri, parametri.getTrazenaRec());
        }

        if(!magacinDto.getRobaDto().isEmpty()) {
            magacinDto.getRobaDto().forEach(dto -> setujZaTabelu(dto, ulogovaniPartner));
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
        if(!daLiJeTrazenaRecNaziv) {
            kataloskiBrojevi = tecDocClient.tecDocPretraga(tacnaRec, null, 10)
                    .stream()
                    .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleNo)
                    .collect(Collectors.toSet());
            kataloskiBrojevi.add(tacnaRec);
            jooqRepository.pomocniKveriPoRobiOld(pregragaPoTacnojReciLike, kataloskiBrojevi);
        }
        if(kataloskiBrojevi.isEmpty()) {
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
        } else if (parametri.getRobaKategorije().isGrupaPretraga() == true) {
            roba = robaService.pronadjiSvuRobuPoGrupiIdNaStanju(parametri.getRobaKategorije().getFieldName(), naStanju, pageable);
        } else if (parametri.getRobaKategorije().isPodgrupaPretraga() == true) {
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
            setujZaTabelu(robaDto, ulogovaniPartner);
            return robaDto;
        }).collect(Collectors.toList());

        return new PageImpl<>(dto, roba.getPageable(), roba.getTotalElements());
    }

    /**
     * Metoda za setovanje cena i tehnickog opisa u dto-u
     */
    private void setujZaTabelu(RobaDto robaDto, Partner partner) {
        robaDto.setCena(robaCeneService.vratiCenuRobePoRobiId(robaDto.getRobaid(), robaDto.getGrupa(), robaDto.getProizvodjac().getProid(), partner));
        robaDto.setRabat(robaCeneService.vratiRabatPartneraNaArtikal(robaDto.getProizvodjac().getProid(), robaDto.getGrupa(), partner));
        Set<RobaTehnickiOpisDto> tehnickiOpisi = tehnickiOpisServis.vratiTehnickiOpisPoIdRobe(robaDto.getRobaid());
        if (tehnickiOpisi.size() > 5) {
            robaDto.setTehnickiOpis(tehnickiOpisi.stream().limit(4).collect(Collectors.toSet()));
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

        robaDto.setSlika(slikeService.vratiPutanjuDoSlike(robaDto.getProizvodjac().getProid(), robaDto.getKatbr(), robaDto.getRobaid()));
        podGrupaService.vratiPodgrupuPoKljucu(robaDto.getPodGrupa()).ifPresent(podGrupa -> robaDto.setPodGrupaNaziv(podGrupa.getNaziv()));
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

    private void setujZaDetalje(RobaDetaljiDto detaljnoDto, Partner partner) {
        if (detaljnoDto != null) {
            detaljnoDto.setCena(robaCeneService.vratiCenuRobePoRobiId(detaljnoDto.getRobaid(), detaljnoDto.getGrupa(), detaljnoDto.getProizvodjac().getProid(), partner));
            detaljnoDto.setRabat(robaCeneService.vratiRabatPartneraNaArtikal(detaljnoDto.getProizvodjac().getProid(), detaljnoDto.getGrupa(), partner));
            detaljnoDto.setTehnickiOpis(tehnickiOpisServis.vratiTehnickiOpisPoIdRobe(detaljnoDto.getRobaid()));
            detaljnoDto.setTdBrojevi(brojeviServis.vratiSveBrojeveZaRobidIVrsti(detaljnoDto.getRobaid(), VRSTA_ORIGINALNI));
            detaljnoDto.setAplikacije(aplikacijeServis.vratiAplikacijeZaDetalje(detaljnoDto.getRobaid()));

            detaljnoDto.setSlika(slikeService.vratiPutanjuDoSlike(detaljnoDto.getProizvodjac().getProid(), detaljnoDto.getKatbr(), detaljnoDto.getRobaid()));

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

    public List<RobaDto> vratiIzdvajamoIzPonudeRobu(List<Long> robaIds, Partner partner) {
        List<RobaDto> retVal = new ArrayList<>();
        robaIds.forEach(robaId -> {
            RobaDto roba = mapper.map(
                    robaService.pronadjiRobuPoPrimarnomKljucu(robaId).get()
            );
            setujZaTabelu(roba, partner);
            retVal.add(roba);
        });
        return retVal;
    }
}
