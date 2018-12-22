package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
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
public class RobaKategorijeService {
    @NonNull
    final RobaService robaService;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    public Page<RobaDto> pronadjiRobuIzKategorije(
            final UniverzalniParametri parametri,
            final List<String> podGrupe,
            final Partner ulogovaniPartner) {
        final Page<Roba> roba;
        final List<Integer> sveFilterPodGrupeId = podGrupaService.vratiSvePodGrupePoNazivima(podGrupe);
        final Pageable pageable = PageRequest.of(parametri.getPage(), parametri.getPageSize(), new Sort(parametri.getDirection(), parametri.getSortiranjePolja().getFieldName()));
        if (parametri.getTrazenKatBroj() == null && parametri.getProizvodjac() == null) {
            roba = vratiSvuRobuUZavisnostiOdTrazenogStanja(parametri.getNaStanju(), sveFilterPodGrupeId, pageable);
        } else {
            roba = vratiRobuUZavisnostiOdKriterijuma(parametri, sveFilterPodGrupeId, pageable);
        }

        return roba.map(artikli -> robaSpringBeanUtils.pretvoriUDTO(artikli, ulogovaniPartner));
    }

    private Page<Roba> vratiRobuUZavisnostiOdKriterijuma(final UniverzalniParametri parametri, final List<Integer> sveFilterPodGrupeId, final Pageable pageable) {
        final List<String> kataloskiBrojevi;
        if (parametri.getTrazenKatBroj() != null) {
            kataloskiBrojevi = robaSpringBeanUtils.vratiSveKataloskeBrojevePoTrazenojReciIPodGrupi(parametri.getTrazenKatBroj(), sveFilterPodGrupeId);
        } else {
            kataloskiBrojevi = robaSpringBeanUtils.vratiSveKataloskeBrojevePoPodGrupi(sveFilterPodGrupeId);
        }
        return robaSpringBeanUtils.pronadjiRobuPoIzvucenimKatBrojevima(
                kataloskiBrojevi,
                sveFilterPodGrupeId,
                parametri.getProizvodjac(),
                parametri.getNaStanju(),
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
