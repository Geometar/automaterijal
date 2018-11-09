package com.automaterijal.application.services;


import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.services.constants.PodGrupaService;
import com.automaterijal.application.utils.RobaSpringBeanUtils;
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
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class FilterService {

    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaService robaService;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    public Page<RobaDto> pronadjiSveFiltere(
            final Integer page,
            final Integer pageSize,
            final RobaSortiranjePolja sortiranjePolja,
            final Sort.Direction direction,
            final String searchTerm,
            final String proizvodjacId,
            final Boolean naStanju
    ) {
        final Page<Roba> roba;
        final List<Integer> sveFilterPodGrupeId = podGrupaService.vratiSvePodGrupeIdPoNazivu(GrupeKonstante.FILTER);
        final Pageable pageable = PageRequest.of(page, pageSize, new Sort(direction, sortiranjePolja.getFieldName()));
        if (searchTerm == null && proizvodjacId == null) {
            roba = vratiSvuRobuUZavisnostiOdTrazenogStanja(naStanju, sveFilterPodGrupeId, pageable);
        } else {
            roba = vratiRobuUZavisnostiOdKriterijuma(searchTerm, sveFilterPodGrupeId, proizvodjacId, naStanju, pageable);
        }

        return roba.map(robaSpringBeanUtils::pretvoriUDTO);
    }

    private Page<Roba> vratiRobuUZavisnostiOdKriterijuma(final String searchTerm, final List<Integer> sveFilterPodGrupeId, final String proizvodjacId, final Boolean naStanju, final Pageable pageable) {
        final List<String> kataloskiBrojevi;
        if (searchTerm != null) {
            kataloskiBrojevi = robaSpringBeanUtils.vratiSveKataloskeBrojevePoTrazenojReciIPodGrupi(searchTerm, sveFilterPodGrupeId);
        } else {
            kataloskiBrojevi = robaSpringBeanUtils.vratiSveKataloskeBrojevePoPodGrupi(sveFilterPodGrupeId);
        }
        return robaSpringBeanUtils.pronadjiRobuPoIzvucenimKatBrojevima(
                kataloskiBrojevi,
                sveFilterPodGrupeId,
                proizvodjacId,
                naStanju,
                pageable);
    }

    private Page<Roba> vratiSvuRobuUZavisnostiOdTrazenogStanja(final Boolean naStanju, final List<Integer> sveFilterPodGrupeId, final Pageable pageable) {
        final Page<Roba> roba;
        if (naStanju) {
            roba = robaService.pronadjiSvuRobuPoPodGrupiIdNaStanju(sveFilterPodGrupeId, pageable);
        } else {
            roba = robaService.pronadjiSvuRobuPoPodGrupiId(sveFilterPodGrupeId, pageable);
        }
        return roba;
    }
}
