package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.services.constants.PodGrupaService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UljaService {
    @NonNull
    final RobaService robaService;
    @NonNull
    final RobaKatBrProService robaKatBrProService;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    public Page<RobaDto> pronadjiSvaUlja(
            final String vrstaUlja,
            final Integer page,
            final Integer pageSize,
            final RobaSortiranjePolja sortiranjePolja,
            final Sort.Direction direction,
            final String searchTerm,
            final String proizvodjacId,
            final Boolean naStanju
    ) {
        final Page<Roba> roba;
        final List<Integer> svePodGrupeUlja = new ArrayList<>();
        pronadjiSvePodGrupeUZavisnostiOdVrste(svePodGrupeUlja, vrstaUlja);
        final Pageable pageable = PageRequest.of(page, pageSize, new Sort(direction, sortiranjePolja.getFieldName()));
        if (searchTerm == null && proizvodjacId == null) {
            roba = vratiSvuRobuUZavisnostiOdTrazenogStanja(naStanju, svePodGrupeUlja, pageable);
        } else {
            roba = vratiRobuUZavisnostiOdKriterijuma(searchTerm, svePodGrupeUlja, proizvodjacId, naStanju, pageable);
        }

        return roba.map(robaSpringBeanUtils::pretvoriUDTO);
    }

    private void pronadjiSvePodGrupeUZavisnostiOdVrste(final List<Integer> svePodGrupeUlja, final String vrstaUlja) {
        final String[] vrsteUlja = RobaStaticUtils.pronadjiSveVrsteUlja(vrstaUlja);
        Arrays.stream(vrsteUlja).forEach(vrsta -> {
            svePodGrupeUlja.addAll(podGrupaService.vratiSvePodGrupeIdPoNazivu(vrsta));
        });
    }

    private Page<Roba> vratiSvuRobuUZavisnostiOdTrazenogStanja(final Boolean naStanju, final List<Integer> svePodGrupeUlja, final Pageable pageable) {
        final Page<Roba> roba;
        if (naStanju) {
            roba = robaService.pronadjiSvuRobuPoPodGrupiIdNaStanju(svePodGrupeUlja, pageable);
        } else {
            roba = robaService.pronadjiSvuRobuPoPodGrupiId(svePodGrupeUlja, pageable);
        }
        return roba;
    }

    private Page<Roba> vratiRobuUZavisnostiOdKriterijuma(final String searchTerm, final List<Integer> svePodGrupeUlja, final String proizvodjacId, final Boolean naStanju, final Pageable pageable) {
        final List<String> kataloskiBrojevi;
        if (searchTerm != null) {
            kataloskiBrojevi = robaSpringBeanUtils.vratiSveKataloskeBrojevePoTrazenojReciIPodGrupi(searchTerm, svePodGrupeUlja);
        } else {
            kataloskiBrojevi = robaSpringBeanUtils.vratiSveKataloskeBrojevePoPodGrupi(svePodGrupeUlja);
        }
        return robaSpringBeanUtils.pronadjiRobuPoIzvucenimKatBrojevima(
                kataloskiBrojevi,
                svePodGrupeUlja,
                proizvodjacId,
                naStanju,
                pageable);
    }
}
