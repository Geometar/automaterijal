package com.automaterijal.application.services.constants;


import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import com.automaterijal.application.services.RobaService;
import com.automaterijal.application.utils.RobaStaticUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ProizvodjacService {

    @NonNull
    final ProizvodjacRepository proizvodjacRepository;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final GrupaService grupaService;
    @NonNull
    final RobaService robaService;

    @Getter
    List<Proizvodjac> proizvodjaci;

    static final String SVI_PROIZVODJACI = "SVI";

    public void pronadjiSveProizvodjace() {
        proizvodjaci = proizvodjacRepository.findAllByOrderByNazivAsc();
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
    }

    public List<Proizvodjac> proizvodjaciFiltera() {
        final List<Integer> podGrupeId = podGrupaService.vratiSvePodGrupeIdPoNazivu(GrupeKonstante.FILTER);
        final Set<String> filterRoba = robaService.pronadjiSvuRobu()
                .stream()
                .filter(r -> podGrupeId.contains(r.getPodgrupaid()))
                .filter(r -> r.getStanje() > 0)
                .map(Roba::getProid)
                .collect(Collectors.toSet());
        final List<Proizvodjac> proizvodjaci = getProizvodjaci().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
        return proizvodjaci;
    }

    public List<Proizvodjac> proizvodjaciAkumulatora() {
        final List<String> grupeId = grupaService.vratiSveIdGrupePoNazivu(GrupeKonstante.AKUMULATOR);
        final Set<String> filterRoba = robaService.pronadjiSvuRobu()
                .stream()
                .filter(r -> grupeId.contains(r.getGrupaid()))
                .filter(r -> r.getStanje() > 0)
                .map(Roba::getProid)
                .collect(Collectors.toSet());
        final List<Proizvodjac> proizvodjaci = getProizvodjaci().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
        return proizvodjaci;
    }

    public List<Proizvodjac> proizvodjaciUlja(final String vrstaUlja) {
        final List<Integer> svePodGrupeUlja = new ArrayList<>();
        pronadjiSvePodGrupeUZavisnostiOdVrste(svePodGrupeUlja, vrstaUlja);
        final Set<String> filterRoba = robaService.pronadjiSvuRobu()
                .stream()
                .filter(r -> svePodGrupeUlja.contains(r.getPodgrupaid()))
                .filter(r -> r.getStanje() > 0)
                .map(Roba::getProid)
                .collect(Collectors.toSet());
        final List<Proizvodjac> proizvodjaci = getProizvodjaci().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
        return proizvodjaci;
    }

    private void pronadjiSvePodGrupeUZavisnostiOdVrste(final List<Integer> svePodGrupeUlja, final String vrstaUlja) {
        final String[] vrsteUlja = RobaStaticUtils.pronadjiSveVrsteUlja(vrstaUlja);
        Arrays.stream(vrsteUlja).forEach(vrsta -> {
            svePodGrupeUlja.addAll(podGrupaService.vratiSvePodGrupeIdPoNazivu(vrsta));
        });
    }

    public String vrateNazivProizvodjacaPoId(final String id) {
        String retVal = null;
        final Optional<String> naziv = proizvodjaci.stream()
                .filter(grupa -> grupa.getProid().equals(id))
                .map(Proizvodjac::getNaziv)
                .findFirst();
        if (naziv.isPresent()) {
            retVal = naziv.get();
        }
        return retVal;
    }
}
