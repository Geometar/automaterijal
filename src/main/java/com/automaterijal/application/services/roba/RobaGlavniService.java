package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
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
import java.util.Optional;
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
    final RobaMapper mapper;

    public static final String SLIKE_PREFIX = "assets/slike/ui/roba/";
    public static final String SLIKE_SUFIX = ".jpg";

    /**
     * Ulazna metoda iz kontrolera
     */
    public Page<RobaDto> pronadjiRobuPoPretrazi(UniverzalniParametri parametri, Partner ulogovaniPartner) {

        var pageable = PageRequest.of(
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
            roba.forEach(dto -> setujCenuITehnkickiOpis(dto, ulogovaniPartner));
        }
        return roba;
    }

    /**
     * Roba koja je na stanju, rezultat zavisi od vrste i od filtera da li je na stanju
     */
    private Page<RobaDto> vratiSvuRobuUZavisnostiOdTrazenogStanja(UniverzalniParametri parametri, Pageable pageable, Partner ulogovaniPartner) {
        Page<Roba> roba;
        boolean naStanju = parametri.isNaStanju();
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

        List<RobaDto> dto = roba.stream().map(robaEntitet -> {
            RobaDto robaDto = mapper.map(robaEntitet);
            setujCenuITehnkickiOpis(robaDto, ulogovaniPartner);
            return robaDto;
        }).collect(Collectors.toList());

        return new PageImpl<>(dto, roba.getPageable(), roba.getTotalElements());
    }

    /**
     * Metoda za setovanje cena i tehnickog opisa u dto-u
     */
    private void setujCenuITehnkickiOpis(RobaDto robaDto, Partner partner) {
        robaDto.setCena(robaCeneService.vratiCenuRobePoRobiId(robaDto.getRobaid(), robaDto.getGrupa(), robaDto.getProizvodjac().getProid(), partner));
        robaDto.setRabat(robaCeneService.vratiRabatPartneraNaArtikal(robaDto.getProizvodjac().getProid(), robaDto.getGrupa(), partner));
        robaDto.setTehnickiOpis(tehnickiOpisServis.vratiTehnickiOpisPoIdRobe(robaDto.getRobaid().intValue()));
        robaDto.setSlika(SLIKE_PREFIX + robaDto.getRobaid() + SLIKE_SUFIX);
    }

    public Optional<RobaDetaljiDto> pronadjiRobuPoRobaId(Long robaId, Partner ulogovaniPartner) {
        Optional<RobaDetaljiDto> retVal = Optional.empty();
        Optional<Roba> roba = robaService.pronadjiRobuPoPrimarnomKljucu(robaId);
        if (roba.isPresent()) {
            RobaDetaljiDto detaljnoDto = mapper.mapujDetaljno(roba.get());
            setujDetalje(detaljnoDto, ulogovaniPartner);
            retVal = Optional.of(detaljnoDto);
        }
        return retVal;
    }

    private void setujDetalje(RobaDetaljiDto detaljnoDto, Partner partner) {
        if (detaljnoDto != null) {
            detaljnoDto.setCena(robaCeneService.vratiCenuRobePoRobiId(detaljnoDto.getRobaId(), detaljnoDto.getGrupa(), detaljnoDto.getProizvodjac().getProid(), partner));
            detaljnoDto.setRabat(robaCeneService.vratiRabatPartneraNaArtikal(detaljnoDto.getProizvodjac().getProid(), detaljnoDto.getGrupa(), partner));
            detaljnoDto.setTehnickiOpis(tehnickiOpisServis.vratiTehnickiOpisPoIdRobe(detaljnoDto.getRobaId().intValue()));
            detaljnoDto.setTdBrojevi(brojeviServis.vratiSveBrojeveZaRobudId(detaljnoDto.getRobaId()));
            detaljnoDto.setAplikacije(aplikacijeServis.vratiAplikacijeZaDetalje(detaljnoDto.getRobaId()));
            detaljnoDto.setSlika(SLIKE_PREFIX + detaljnoDto.getRobaId() + SLIKE_SUFIX);
        }
    }
}
