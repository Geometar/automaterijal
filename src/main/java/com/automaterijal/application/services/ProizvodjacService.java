package com.automaterijal.application.services;


import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.services.roba.grupe.GrupaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.utils.RobaStaticUtils;
import lombok.AccessLevel;
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

    static final String SVI_PROIZVODJACI = "SVI";

    public List<Proizvodjac> pronadjiSveProizvodjace() {
        final List<Proizvodjac> proizvodjaci = proizvodjacRepository.findAllByOrderByNazivAsc();
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
        return proizvodjaci;
    }

    public List<Proizvodjac> proizvodjaciFiltera() {
        final List<Integer> podGrupeId = podGrupaService.vratiSvePodGrupeIdPoNazivu(GrupeKonstante.FILTER);
        final Set<String> filterRoba = robaService.pronadjiSvuRobuPoPodGrupiIdLista(podGrupeId)
                .stream()
                .map(Roba::getProid)
                .collect(Collectors.toSet());
        final List<Proizvodjac> proizvodjaci = pronadjiSveProizvodjace().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
        return proizvodjaci;
    }

    public List<Proizvodjac> proizvodjaciAkumulatora() {
        final List<String> grupeId = grupaService.vratiSveIdGrupePoNazivu(GrupeKonstante.AKUMULATOR);
        final Set<String> filterRoba = robaService.pronadjuSvuRobuPoGrupiIdNaStanju(grupeId)
                .stream()
                .map(Roba::getProid)
                .collect(Collectors.toSet());
        final List<Proizvodjac> proizvodjaci = proizvodjacRepository.findAllByOrderByNazivAsc().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
        return proizvodjaci;
    }

    public List<Proizvodjac> proizvodjaciUlja(final String vrstaUlja) {
        final List<Integer> svePodGrupeUlja = new ArrayList<>();
        pronadjiSvePodGrupeUZavisnostiOdVrste(svePodGrupeUlja, vrstaUlja);
        final Set<String> filterRoba = robaService.pronadjiSvuRobuPoPodGrupiIdLista(svePodGrupeUlja)
                .stream()
                .map(Roba::getProid)
                .collect(Collectors.toSet());
        final List<Proizvodjac> proizvodjaci = pronadjiSveProizvodjace().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
        return proizvodjaci;
    }

    public List<Proizvodjac> porizvodjacZaKategoriju(final List<String> podVrsta) {
        final List<Integer> svePodGrupeUlja = new ArrayList<>();
        podVrsta.forEach(naziv -> svePodGrupeUlja.addAll(podGrupaService.vratiSvePodGrupeIdPoNazivu(naziv)));
        final Set<String> roba = robaService.pronadjiSvuRobuPoPodGrupiIdLista(svePodGrupeUlja)
                .stream()
                .map(Roba::getProid)
                .collect(Collectors.toSet());
        final List<Proizvodjac> proizvodjaci = pronadjiSveProizvodjace().stream().filter(proizvodjac -> roba.contains(proizvodjac.getProid())).collect(Collectors.toList());
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
        final Optional<String> naziv = pronadjiSveProizvodjace().stream()
                .filter(grupa -> grupa.getProid().equals(id))
                .map(Proizvodjac::getNaziv)
                .findFirst();
        if (naziv.isPresent()) {
            retVal = naziv.get();
        }
        return retVal;
    }

    public Optional<Proizvodjac> vratiProizvodjacaPoPk(final String id) {
        return proizvodjacRepository.findById(id);
    }
}
