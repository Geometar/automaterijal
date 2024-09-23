package com.automaterijal.application.patterns.strategy.roba;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaHelper;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PretragaBezFilteraStrategija implements PretragaRobeStrategija {

    @NonNull
    final RobaService robaService;
    @NonNull
    final RobaAdapterService jooqRepository;
    @NonNull
    final ProizvodjacService proizvodjacService;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaMapper mapper;
    @NonNull
    final TecDocService tecDocService;
    @NonNull
    final RobaHelper robaHelper;

    @Override
    public MagacinDto pretrazi(UniverzalniParametri parametri, Partner ulogovaniPartner) {
        var magacinDto = new MagacinDto();
        var pageable = PageRequest.of(
                parametri.getPage(), parametri.getPageSize(),
                Sort.by(Sort.Direction.DESC, RobaSortiranjePolja.STANJE.getFieldName())
        );

        Page<RobaDto> robaDto = vratiSvuRobuUZavisnostiOdTrazenogStanja(parametri, pageable,
                ulogovaniPartner);
        if (parametri.getRobaKategorije() == null) {
            magacinDto.setPodgrupe(podGrupaService.vratiSveGrupeNazive());
        } else if (parametri.getRobaKategorije() != null) {
            magacinDto.setPodgrupe(vratiSvePodgrupePoNazivu(parametri));
        }
        magacinDto.setProizvodjaci(proizvodjacService.pronadjiSveProizvodjaceZaVrstu(parametri));
        magacinDto.setRobaDto(robaDto);

        return magacinDto;
    }

    private Page<RobaDto> vratiSvuRobuUZavisnostiOdTrazenogStanja(UniverzalniParametri parametri,
                                                                  Pageable pageable, Partner ulogovaniPartner) {
        Page<Roba> roba = pronadjiRobu(parametri, pageable);

        if (roba == null) {
            log.error("Ne definisana roba!");
            return Page.empty();
        }

        List<RobaDto> dto = mapirajRobu(roba);
        tecDocService.batchVracanjeICuvanjeTDAtributa(dto);
        postaviPodgrupuINaziv(dto);
        robaHelper.setujZaTabelu(dto, ulogovaniPartner);

        return new PageImpl<>(dto, roba.getPageable(), roba.getTotalElements());
    }

    private Page<Roba> pronadjiRobu(UniverzalniParametri parametri, Pageable pageable) {
        boolean naStanju = parametri.isNaStanju();

        // Return all items if no category is set
        if (parametri.getRobaKategorije() == null) {
            return robaService.pronadjiSvuRobu(naStanju, pageable);
        }

        // Search by group ID if it's a group search
        if (parametri.getRobaKategorije().isGrupaPretraga()) {
            return robaService.pronadjiSvuRobuPoGrupiIdNaStanju(parametri.getRobaKategorije().getFieldName(), naStanju, pageable);
        }

        // Search by sub-group if it's a sub-group search
        if (parametri.getRobaKategorije().isPodgrupaPretraga()) {
            List<PodGrupa> podGrupaList = parametri.getPodgrupaZaPretragu() != null
                    ? parametri.getPodGrupe().stream()
                    .filter(podGrupa -> podGrupa.getNaziv().equals(parametri.getPodgrupaZaPretragu()))
                    .collect(Collectors.toList())
                    : parametri.getPodGrupe();

            return jooqRepository.pronadjiSvuRobuPoPodgrupama(podGrupaList, naStanju, pageable);
        }

        // Return null if none of the above conditions match
        return null;
    }

    private List<RobaDto> mapirajRobu(Page<Roba> roba) {
        return roba.stream().map(mapper::map).collect(Collectors.toList());
    }

    private void postaviPodgrupuINaziv(List<RobaDto> dto) {
        List<PodgrupaDto> podgrupaDtos = podGrupaService.vratiSvePodgrupeZaKljuceve(
                dto.stream().map(RobaDto::getPodGrupa).collect(Collectors.toSet()));

        dto.forEach(robaDto ->
                podgrupaDtos.stream()
                        .filter(podgrupaDto -> podgrupaDto.getId() == robaDto.getPodGrupa())
                        .findAny()
                        .ifPresent(podgrupaDto -> robaDto.setPodGrupaNaziv(podgrupaDto.getNaziv()))
        );
    }

    private List<String> vratiSvePodgrupePoNazivu(UniverzalniParametri parametri) {
        Set<String> podGrupeSet = new HashSet<>();
        if (!parametri.getPodGrupe().isEmpty()) {
            List<String> podGrupe = parametri.getPodGrupe().stream().map(PodGrupa::getNaziv)
                    .collect(Collectors.toList());
            podGrupeSet = podGrupaService.vratiSvePodGrupePoNazivima(podGrupe).stream()
                    .map(PodGrupa::getNaziv).map(String::toUpperCase).collect(Collectors.toSet());
        } else {
            podGrupaService.vratiSvePodGrupePoGrupi(parametri.getGrupa());
        }
        return new ArrayList<>(podGrupeSet).stream().sorted().collect(Collectors.toList());
    }
}
