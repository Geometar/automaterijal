package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UljaService {
    @NonNull
    final RobaService robaService;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    public Page<RobaDto> pronadjiSvaUlja(final UniverzalniParametri parametri,
                                         final String vrstaUlja,
                                         final Partner ulogovaniPartner) {
        final Page<Roba> roba;
        final List<Integer> svePodGrupeUlja = new ArrayList<>();
        pronadjiSvePodGrupeUZavisnostiOdVrste(svePodGrupeUlja, vrstaUlja);
        final Pageable pageable = PageRequest.of(
                parametri.getPage(), parametri.getPageSize(), new Sort(parametri.getDirection(), parametri.getSortiranjePolja().getFieldName())
        );
        if (parametri.getTrazenKatBroj() == null && parametri.getProizvodjac() == null) {
            roba = vratiSvuRobuUZavisnostiOdTrazenogStanja(parametri.getNaStanju(), svePodGrupeUlja, pageable);
        } else {
            roba = vratiRobuUZavisnostiOdKriterijuma(parametri, svePodGrupeUlja, pageable);
        }

        return roba.map(artikli -> robaSpringBeanUtils.pretvoriUDTO(artikli, ulogovaniPartner));
    }

    private void pronadjiSvePodGrupeUZavisnostiOdVrste(final List<Integer> svePodGrupeUlja, final String vrstaUlja) {
        final String[] vrsteUlja = RobaStaticUtils.pronadjiSveVrsteUlja(vrstaUlja);
        Arrays.stream(vrsteUlja)
                .filter(str -> str != null)
                .forEach(vrsta -> svePodGrupeUlja.addAll(podGrupaService.vratiSvePodGrupeIdPoNazivu(vrsta)));
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

    private Page<Roba> vratiRobuUZavisnostiOdKriterijuma(final UniverzalniParametri parametri, final List<Integer> svePodGrupeUlja, final Pageable pageable) {
        final List<String> kataloskiBrojevi;
        if (parametri.getTrazenKatBroj() != null) {
            kataloskiBrojevi = robaSpringBeanUtils.vratiSveKataloskeBrojevePoTrazenojReciIPodGrupi(parametri.getTrazenKatBroj(), svePodGrupeUlja);
        } else {
            kataloskiBrojevi = robaSpringBeanUtils.vratiSveKataloskeBrojevePoPodGrupi(svePodGrupeUlja);
        }
        return robaSpringBeanUtils.pronadjiRobuPoIzvucenimKatBrojevima(
                kataloskiBrojevi,
                svePodGrupeUlja,
                parametri.getProizvodjac(),
                parametri.getNaStanju(),
                pageable);
    }
}
