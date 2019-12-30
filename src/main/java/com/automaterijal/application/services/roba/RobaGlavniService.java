package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    final RobaJooqRepository jooqRepository;
    @NonNull
    final RobaCeneService robaCeneService;
    @NonNull
    final RobaMapper mapper;

    /**
     * Ulazna metoda iz kontrolera
     */
    public Page<RobaDto> pronadjiRobuPoPretrazi(final UniverzalniParametri parametri, final Partner ulogovaniPartner) {

        final var pageable = PageRequest.of(
                parametri.getPage(), parametri.getPageSize(), new Sort(parametri.getDirection(), parametri.getSortiranjePolja().getFieldName())
        );
        Page<RobaDto> roba = null;
        log.info("Partner {} trazi robu na stranici {} po kataloskom broju {} i prozivodjacu {}",
                ulogovaniPartner != null ? ulogovaniPartner.getNaziv() : "anoniman",
                parametri.getVrstaRobe() != null ? parametri.getVrstaRobe().toString().toLowerCase() : " - ",
                parametri.getTrazenaRec() != null ? parametri.getTrazenaRec() : "-",
                parametri.getProizvodjac() != null ? parametri.getProizvodjac() : "-"
        );

        if (parametri.getTrazenaRec() == null && parametri.getProizvodjac() == null) {
            roba = vratiSvuRobuUZavisnostiOdTrazenogStanja(parametri, pageable, ulogovaniPartner);
        } else {
            roba = jooqRepository.pronadjiPoTrazenojReci(parametri, parametri.getTrazenaRec());
            roba.forEach(dto -> setujCeneRobe(dto, ulogovaniPartner));
        }
        return  roba;
    }

    /**
     * Roba koja je na stanju, rezultat zavisi od vrste i od filtera da li je na stanju
     */
    private Page<RobaDto> vratiSvuRobuUZavisnostiOdTrazenogStanja(final UniverzalniParametri parametri, final Pageable pageable, final Partner ulogovaniPartner) {
        final Page<Roba> roba;
        final boolean naStanju = parametri.isNaStanju();
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

         final List<RobaDto> dto = roba.stream().map(robaEntitet -> {
             RobaDto robaDto = mapper.map(robaEntitet);
             setujCeneRobe(robaDto, ulogovaniPartner);
         return robaDto;
         }).collect(Collectors.toList());

        return new PageImpl<>(dto, roba.getPageable(), roba.getTotalElements());
    }

    private void setujCeneRobe(final RobaDto robaDto, final Partner partner) {
        robaDto.setCena(robaCeneService.vratiCenuRobePoRobiId(robaDto.getRobaid(), robaDto.getGrupa(), robaDto.getProizvodjac().getProid(), partner));
        robaDto.setRabat(robaCeneService.vratiRabatPartneraNaArtikal(robaDto.getProizvodjac().getProid(), robaDto.getGrupa(), partner));
    }
}
