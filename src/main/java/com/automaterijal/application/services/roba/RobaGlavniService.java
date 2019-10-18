package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.utils.RobaSpringBeanUtils;
import com.automaterijal.application.utils.RobaStaticUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaGlavniService {

    @NonNull
    final RobaService robaService;
    @NonNull
    final RobaKatBrProService robaKatBrProService;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    /**
     * Ulazna metoda iz kontrolera
     */
    public Page<RobaDto> pronadjiRobuPoPretrazi(final UniverzalniParametri parametri, final Partner ulogovaniPartner) {

        final var pageable = PageRequest.of(
                parametri.getPage(), parametri.getPageSize(), new Sort(parametri.getDirection(), parametri.getSortiranjePolja().getFieldName())
        );
        final Page<Roba> roba;
        log.info("Partner {} trazi sve artikle po kataloskom broju {} i prozivodjacu {}",
                ulogovaniPartner != null ? ulogovaniPartner.getNaziv() : "anoniman",
                parametri.getTrazenaRec() != null ? parametri.getTrazenaRec() : "-",
                parametri.getProizvodjac() != null ? parametri.getProizvodjac() : "-"
        );

        if (parametri.getTrazenaRec() == null && parametri.getProizvodjac() == null) {
            roba = vratiSvuRobuUZavisnostiOdTrazenogStanja(parametri, pageable);
        } else {
            roba = vratiRobuUZavisnostiOdKriterijuma(parametri, pageable);
        }

        return roba.map(artikli -> robaSpringBeanUtils.pretvoriUDTO(artikli, ulogovaniPartner));
    }

    /**
     * Roba koja je na stanju, rezultat zavisi od vrste i od filtera da li je na stanju
     */
    private Page<Roba> vratiSvuRobuUZavisnostiOdTrazenogStanja(final UniverzalniParametri parametri, final Pageable pageable) {
        final Page<Roba> roba;
        final boolean naStanju = parametri.getNaStanju();
        switch (parametri.getVrstaRobe()) {
            case SVE:
                roba = robaService.pronadjiSvuRobu(naStanju, pageable);
                break;
            case OSTALO:
            case ULJA:
            case FILTERI:
                roba = robaService.pronadjiSvuRobuPoPodGrupiId(parametri.getPodGrupeId(), naStanju, pageable);
                break;
            case AKUMULATORI:
                roba = robaService.pronadjiSvuRobuPoGrupiIdNaStanju(parametri.getGrupeId(), naStanju, pageable);
                break;
            default:
                roba = null;
                log.error("Ne definisana roba!");
        }

        return roba;
    }

    /**
     * Filtriraj po trazenoj reci ili partneru
     */
    private Page<Roba> vratiRobuUZavisnostiOdKriterijuma(final UniverzalniParametri parametri, final Pageable pageable) {
        final List<String> kataloskiBrojevi;
        if (!StringUtils.isEmpty(parametri.getTrazenaRec())) {
            final String trazenaRec = parametri.getTrazenaRec();
            if (VrstaRobe.SVE == parametri.getVrstaRobe()) {
                kataloskiBrojevi = vratiSveKataloskeBrojevePoTrazenojReci(parametri.getTrazenaRec());
            } else {
                kataloskiBrojevi = vratiSveKataloskeBrojevePoTrazenojIFilterIdu(parametri, trazenaRec);
            }
        } else {
            switch (parametri.getVrstaRobe()) {
                case SVE:
                    kataloskiBrojevi = vratiSveKataloskeBrojeveZaProizvodjaca(parametri.getProizvodjac());
                    break;
                case FILTERI:
                case ULJA:
                case OSTALO:
                    kataloskiBrojevi = vratiSveKataloskeBrojevePoPodGrupi(parametri.getPodGrupeId());
                    break;
                case AKUMULATORI:
                    kataloskiBrojevi = vratiSveKataloskeBrojevePoGrupiId(parametri.getGrupeId());
                    break;
                default:
                    kataloskiBrojevi = vratiSveKataloskeBrojeveZaProizvodjaca(parametri.getProizvodjac());
            }
        }
        return pronadjiRobuPoIzvucenimKatBrojevima(
                kataloskiBrojevi,
                parametri,
                pageable);
    }

    /**
     * Trazenje robe za sve kategorije
     *
     * @param searchTerm
     * @return
     */
    private List<String> vratiSveKataloskeBrojevePoTrazenojReci(final String searchTerm) {
        final List<Roba> katBr = pronadjuSvuRobuPoPretrazi(searchTerm);
        final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiPoPretrazi(searchTerm);

        final List<String> pretragaPoKatProizvodjacima = new ArrayList<>();
        katBrProLista.stream().map(RobaKatBrPro::getKatbr).filter(StringUtils::hasText).forEach(pretragaPoKatProizvodjacima::add);
        katBrProLista.stream().map(RobaKatBrPro::getKatbrpro).filter(StringUtils::hasText).forEach(pretragaPoKatProizvodjacima::add);
        katBr.addAll(robaService.pronadjiRobuPoKatBrojevima(pretragaPoKatProizvodjacima));

        final List<String> katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, katBrProLista);
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    /**
     * Trazenje robe za specificne katerogrije
     */
    private List<String> vratiSveKataloskeBrojevePoTrazenojIFilterIdu(final UniverzalniParametri parametri, final String trazenaRec) {
        final List<Roba> filtriranaRoba = new ArrayList<>();
        final List<Roba> svaRoba = pronadjuSvuRobuPoPretrazi(trazenaRec);
        if (VrstaRobe.FILTERI == parametri.getVrstaRobe()
                || VrstaRobe.ULJA == parametri.getVrstaRobe()
                || VrstaRobe.OSTALO == parametri.getVrstaRobe()) {
            svaRoba.stream().filter(roba -> parametri.getPodGrupeId().contains(roba.getPodgrupaid())).forEach(filtriranaRoba::add);
        } else {
            svaRoba.stream().filter(roba -> parametri.getGrupeId().contains(roba.getGrupaid())).forEach(filtriranaRoba::add);
        }

        final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiPoPretrazi(trazenaRec);
        final List<String> katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(filtriranaRoba, katBrProLista);
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    /**
     * Glavna privatna metoda za pretragu delova
     */
    private List<Roba> pronadjuSvuRobuPoPretrazi(final String searchTerm) {
        return robaService.pronadjuSvuRobuPoPretrazi(searchTerm);
    }

    private List<String> vratiSveKataloskeBrojevePoPodGrupi(final List<Integer> podGrupeId) {
        final List<Roba> robaPoPodGrupi = robaService.pronadjuSvuRobuPodGrupomId(podGrupeId);
        final List<String> katBrojevi = robaPoPodGrupi.stream().map(Roba::getKatbr).collect(Collectors.toList());
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    private List<String> vratiSveKataloskeBrojevePoGrupiId(final List<String> sveAkumulatorGrupeId) {
        final List<Roba> robaPoPodGrupi = robaService.pronadjuSvuRobuPoGrupiId(sveAkumulatorGrupeId);
        final List<String> katBrojevi = robaPoPodGrupi.stream().map(Roba::getKatbr).collect(Collectors.toList());
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    private List<String> vratiSveKataloskeBrojeveZaProizvodjaca(final String proizvodjacId) {
        final List<String> katBrojevi;
        if (proizvodjacId == null) {
            final List<Roba> katBr = robaService.pronadjiSvuRobu();
            katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, new ArrayList<>());
        } else {
            final List<Roba> katBr = robaService.pronadjiSvuRobuPoProId(proizvodjacId);
            katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, new ArrayList<>());
        }
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    private Page<Roba> pronadjiRobuPoIzvucenimKatBrojevima(final List<String> katBrojevi, final UniverzalniParametri parametri, final Pageable pageable) {
        final Set<Long> robaId = new HashSet<>();
        robaId.addAll(robaService.pronadjiRobuPoKatBrojevima(katBrojevi).stream().map(Roba::getRobaid).collect(Collectors.toSet()));

        Page<Roba> robas = null;
        switch (parametri.getVrstaRobe()) {
            case AKUMULATORI:
                robas = robaService.pronadjiRobuPoKljucevimaIGrupiId(robaId, parametri.getGrupeId(), parametri.getProizvodjac(), parametri.getNaStanju(), pageable);
                break;
            case FILTERI:
            case ULJA:
            case OSTALO:
                robas = robaService.pronadjiRobuPoKljucevimaIPodGrupi(robaId, parametri.getPodGrupeId(), parametri.getProizvodjac(), parametri.getNaStanju(), pageable);
                break;
            case SVE:
            default:
                robas = robaService.pronadjiRobuPoKljucevima(robaId, parametri.getProizvodjac(), parametri.getNaStanju(), pageable);
                break;
        }
        return robas;
    }
}
