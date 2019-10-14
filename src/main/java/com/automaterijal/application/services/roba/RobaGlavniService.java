package com.automaterijal.application.services.roba;

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

    public Page<RobaDto> pronadjiRobuPoPretrazi(final UniverzalniParametri parametri, final Partner ulogovaniPartner) {

        final var pageable = PageRequest.of(
                parametri.getPage(), parametri.getPageSize(), new Sort(parametri.getDirection(), parametri.getSortiranjePolja().getFieldName())
        );
        final Page<Roba> roba;

        log.info("Partner {} trazi sve artikle po kataloskom broju {} i prozivodjacu {}",
                ulogovaniPartner != null ? ulogovaniPartner.getNaziv() : "anoniman",
                parametri.getTrazenKatBroj() != null ? parametri.getTrazenKatBroj() : "-",
                parametri.getProizvodjac() != null ? parametri.getProizvodjac() : "-"
        );

        if (parametri.getTrazenKatBroj() == null && parametri.getProizvodjac()== null) {
            roba = robaService.pronadjiSvuRobu(parametri.getNaStanju(), pageable);
        } else {
            roba = vratiRobuUZavisnostiOdKriterijuma(parametri, pageable);
        }

        return roba.map(artikli -> robaSpringBeanUtils.pretvoriUDTO(artikli, ulogovaniPartner));
    }

    private Page<Roba> vratiRobuUZavisnostiOdKriterijuma(final UniverzalniParametri parametri, final Pageable pageable) {
        final List<String> kataloskiBrojevi;
        if (!StringUtils.isEmpty(parametri.getTrazenKatBroj())) {
            kataloskiBrojevi = vratiSveKataloskeBrojevePoTrazenojReci(parametri.getTrazenKatBroj());
        } else {
            kataloskiBrojevi = vratiSveKataloskeBrojeve(parametri.getProizvodjac());
        }
        return pronadjiRobuPoIzvucenimKatBrojevima(
                kataloskiBrojevi,
                parametri.getProizvodjac(),
                parametri.getNaStanju(),
                pageable);
    }

    private List<String> vratiSveKataloskeBrojeve(final String proizvodjacId) {
        final List<String> katBrojevi;
        if(proizvodjacId == null) {
            final List<Roba> katBr = robaService.pronadjiSvuRobu();
            final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiSve();
            katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, katBrProLista);
        } else {
            final List<Roba> katBr = robaService.pronadjiSvuRobuPoProId(proizvodjacId);
            final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiSve();
            katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, katBrProLista);
        }
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    private List<String> vratiSveKataloskeBrojevePoTrazenojReci(final String searchTerm) {
        final List<Roba> katBr = pronadjuSvuRobuPoPretrazi(searchTerm);
        final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiPoPretrazi(searchTerm);
        final List<String> katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, katBrProLista);
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    private List<Roba> pronadjuSvuRobuPoPretrazi(final String searchTerm) {
        return robaService.pronadjuSvuRobuPoPretrazi(searchTerm);
    }

    private Page<Roba> pronadjiRobuPoIzvucenimKatBrojevima(final List<String> katBrojevi, final String filterProizvodjac, final Boolean filterRaspolozivostfinal, final Pageable pageable) {
        final Set<Long> robaId = new HashSet<>();
        robaId.addAll(robaService.pronadjiRobuPoKatBrojevima(katBrojevi).stream().map(Roba::getRobaid).collect(Collectors.toSet()));
        robaId.addAll(robaKatBrProService.pronadjuKatBrProPoKataloskimBrojevima(katBrojevi).stream().map(RobaKatBrPro::getRobaid).collect(Collectors.toSet()));

        return robaService.pronadjiRobuPoKljucevima(robaId, filterProizvodjac, filterRaspolozivostfinal, pageable);
    }
}
