package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.GrupaDozvoljena;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.roba.RobaSlika;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.GrupaDozvoljenaService;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    final RobaSlikaService robaSlikaService;
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

    @Value("${roba.slika.prefixTabela}")
    String prefixTabela;

    @Value("${roba.slika.prefixThumbs}")
    String prefixThumbs;

    private static final String SLIKA_NIJE_DOSTUPNA_URL = "assets/slike/ui/roba/slikanijedostupna.jpg";


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

        if (parametri.getTrazenaRec() == null && parametri.getProizvodjac() == null && parametri.getGrupa() == null) {
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
            magacinDto.setPodgrupe(vratiSvePodgrupePoNazivu(parametri.getPodGrupe().stream().map(PodGrupa::getNaziv).collect(Collectors.toList())));
        }
        magacinDto.setProizvodjaci(proizvodjacService.pronadjiSveProizvodjaceZaVrstu(parametri));
        magacinDto.setRobaDto(robaDto);

        return magacinDto;
    }

    private List<String> vratiSvePodgrupePoNazivu(List<String> podgrupe) {
        Set<String> podGrupeSet = podGrupaService.vratiSvePodGrupePoNazivima(podgrupe).stream().map(PodGrupa::getNaziv).map(String::toUpperCase).collect(Collectors.toSet());
        return new ArrayList<>(podGrupeSet).stream().sorted().collect(Collectors.toList());
    }

    private MagacinDto logikaZaMagacinSaFilterom(UniverzalniParametri parametri, Partner ulogovaniPartner) {
        var magacinDto = new MagacinDto();
        magacinDto = jooqRepository.pronadjiPoTrazenojReci(parametri, parametri.getTrazenaRec());
        magacinDto.getRobaDto().forEach(dto -> setujZaTabelu(dto, ulogovaniPartner));
        return magacinDto;
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
            roba = jooqRepository.pronadjiSvuRobuPoPodgrupama(parametri.getPodGrupe(), naStanju, pageable);
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

        Optional<RobaSlika> robaSlika = robaSlikaService.pronadjiPutanjuSlikePoId(robaDto.getRobaid());
        if (robaSlika.isPresent()) {
            robaDto.setSlika(prefixTabela + prefixThumbs + robaSlika.get().getSlika());
        } else {
            robaDto.setSlika(SLIKA_NIJE_DOSTUPNA_URL);
        }
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
            Optional<RobaSlika> robaSlika = robaSlikaService.pronadjiPutanjuSlikePoId(detaljnoDto.getRobaid());

            if (robaSlika.isPresent()) {
                detaljnoDto.setSlika(prefixTabela + prefixThumbs + robaSlika.get().getSlika());
            } else {
                detaljnoDto.setSlika(SLIKA_NIJE_DOSTUPNA_URL);
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
