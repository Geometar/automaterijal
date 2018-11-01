package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.services.constants.GrupaService;
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
public class AkumulatoriService {

    @NonNull
    final GrupaService grupaService;
    @NonNull
    final RobaService robaService;
    @NonNull
    final RobaKatBrProService robaKatBrProService;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    public Page<RobaDto> pronadjiSveAkumulatore(
            final Integer page,
            final Integer pageSize,
            final RobaSortiranjePolja sortiranjePolja,
            final Sort.Direction direction,
            final String searchTerm,
            final String proizvodjacId,
            final Boolean naStanju
    ) {
        final Page<Roba> roba;
        final List<String> sveAkumulatorGrupeId = grupaService.vratiSveIdGrupePoNazivu(GrupeKonstante.AKUMULATOR);
        final Pageable pageable = PageRequest.of(page, pageSize, new Sort(direction, sortiranjePolja.getFieldName()));

        if (searchTerm == null && proizvodjacId == null) {
            roba = vratiSvuRobuUZavisnostiOdTrazenogStanja(naStanju, sveAkumulatorGrupeId, pageable);
        } else {
            roba = vratiRobuUZavisnostiOdKriterijuma(searchTerm, sveAkumulatorGrupeId, proizvodjacId, naStanju, pageable);
        }

        return roba.map(robaSpringBeanUtils::pretvoriUDTO);
    }

    private Page<Roba> vratiSvuRobuUZavisnostiOdTrazenogStanja(final Boolean naStanju, final List<String> sveAkumulatorGrupeId, final Pageable pageable) {
        final Page<Roba> roba;
        if (naStanju) {
            roba = robaService.pronadjiSvuRobuPoGrupiIdNaStanju(sveAkumulatorGrupeId, pageable);
        } else {
            roba = robaService.pronadjiSvuRobuPoGrupiId(sveAkumulatorGrupeId, pageable);
        }
        return roba;
    }

    private Page<Roba> vratiRobuUZavisnostiOdKriterijuma(final String searchTerm, final List<String> sveAkumulatorGrupeId, final String proizvodjacId, final Boolean naStanju, final Pageable pageable) {
        final List<String> kataloskiBrojevi;
        if (searchTerm != null) {
            kataloskiBrojevi = vratiSveKataloskeBrojevePoTrazenojReci(searchTerm, sveAkumulatorGrupeId);
        } else {
            kataloskiBrojevi = vratiSveKataloskeBrojeve(sveAkumulatorGrupeId);
        }
        return pronadjiRobuPoIzvucenimKatBrojevima(
                kataloskiBrojevi,
                sveAkumulatorGrupeId,
                proizvodjacId,
                naStanju,
                pageable);
    }

    private Page<Roba> pronadjiRobuPoIzvucenimKatBrojevima(final List<String> kataloskiBrojevi, final List<String> sveAkumulatorGrupeId, final String proizvodjacId, final Boolean naStanju, final Pageable pageable) {
        final Set<Long> robaId = new HashSet<>();
        robaId.addAll(robaService.pronadjiRobuPoKatBrojevima(kataloskiBrojevi).stream().map(Roba::getRobaid).collect(Collectors.toSet()));
        robaId.addAll(robaKatBrProService.pronadjuKatBrProPoKataloskimBrojevima(kataloskiBrojevi).stream().map(RobaKatBrPro::getRobaid).collect(Collectors.toSet()));

        return robaService.pronadjiRobuPoKljucevimaIGrupiId(robaId, sveAkumulatorGrupeId, proizvodjacId, naStanju, pageable);

    }

    private List<String> vratiSveKataloskeBrojeve(final List<String> sveAkumulatorGrupeId) {
        final List<Roba> robaPoPodGrupi = robaService.pronadjuSvuRobuPoGrupiId(sveAkumulatorGrupeId);
        final List<String> katBrojevi = robaPoPodGrupi.stream().map(Roba::getKatbr).collect(Collectors.toList());
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    private List<String> vratiSveKataloskeBrojevePoTrazenojReci(final String searchTerm, final List<String> sveAkumulatorGrupeId) {
        final List<Roba> robaPoPodGrupi = robaService.pronadjuSvuRobuPoGrupiId(sveAkumulatorGrupeId);
        final List<Roba> katBr = robaPoPodGrupi.stream().filter(roba -> roba.getKatbr().contains(searchTerm) || roba.getKatbrpro().contains(searchTerm)).collect(Collectors.toList());
        final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiPoPretrazi(searchTerm);
        final List<String> katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, katBrProLista);
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }
}
