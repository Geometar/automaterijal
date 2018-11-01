package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.entity.RobaKatBrPro;
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

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
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
    final RobaKatBrProService robaKatBrProService;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    public Page<RobaDto> pronadjiRobuPoPretrazi(
            final Integer page,
            final Integer pageSize,
            final RobaSortiranjePolja sortiranjePolja,
            final Sort.Direction direction,
            final String searchTerm,
            final String proizvodjacId,
            final Boolean naStanju
    ) {

        final Pageable pageable = PageRequest.of(page, pageSize, new Sort(direction, sortiranjePolja.getFieldName()));
        final Page<Roba> roba;
        if (searchTerm == null && proizvodjacId == null) {
            roba = robaService.pronadjiSvuRobu(naStanju, pageable);
        } else {
            roba = vratiRobuUZavisnostiOdKriterijuma(searchTerm, proizvodjacId, naStanju, pageable);
        }

        return roba.map(robaSpringBeanUtils::pretvoriUDTO);
    }

    private Page<Roba> vratiRobuUZavisnostiOdKriterijuma(final String searchTerm, final String proizvodjacId, final Boolean naStanju, final Pageable pageable) {
        final List<String> kataloskiBrojevi;
        if (searchTerm != null) {
            kataloskiBrojevi = vratiSveKataloskeBrojevePoTrazenojReci(searchTerm);
        } else {
            kataloskiBrojevi = vratiSveKataloskeBrojeve(proizvodjacId);
        }
        return pronadjiRobuPoIzvucenimKatBrojevima(
                kataloskiBrojevi,
                proizvodjacId,
                naStanju,
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
        final List<Roba> katBr = robaService.pronadjuSvuRobuPoPretrazi(searchTerm);
        final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiPoPretrazi(searchTerm);
        final List<String> katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, katBrProLista);
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    private Page<Roba> pronadjiRobuPoIzvucenimKatBrojevima(final List<String> katBrojevi, final String filterProizvodjac, final Boolean filterRaspolozivostfinal, final Pageable pageable) {
        final Set<Long> robaId = new HashSet<>();
        robaId.addAll(robaService.pronadjiRobuPoKatBrojevima(katBrojevi).stream().map(Roba::getRobaid).collect(Collectors.toSet()));
        robaId.addAll(robaKatBrProService.pronadjuKatBrProPoKataloskimBrojevima(katBrojevi).stream().map(RobaKatBrPro::getRobaid).collect(Collectors.toSet()));

        return robaService.pronadjiRobuPoKljucevima(robaId, filterProizvodjac, filterRaspolozivostfinal, pageable);
    }
}
