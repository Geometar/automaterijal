package com.automaterijal.application.services;


import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.model.UniverzalniParametri;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
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

    static final String SVI_PROIZVODJACI = "Svi proizvodjači";

    /**
     * Popunjavanje proizvodjaca u zavistosti od kriterijuma
     */
    public void popuniProizvodjace(List<RobaDto> robaDtos, MagacinDto magacinDto, UniverzalniParametri parametri) {
        List<Proizvodjac> proizvodjaci;
        if (parametri.getGrupa() == null && parametri.getTrazenaRec() == null) {
            proizvodjaci = pronadjiSveProizvodjaceZaVrstu(parametri);
        } else {
            Set<String> proizKljuc = robaDtos.stream().map(RobaDto::getProizvodjac).map(Proizvodjac::getProid).collect(Collectors.toSet());
            proizvodjaci = proizvodjacRepository.findByProidIn(proizKljuc);
        }
        getPopuniProizvodjaceURobi(robaDtos, proizvodjaci);

        if (parametri.getProizvodjac() != null) {
            boolean trazeniProizvodjacPostoji = proizvodjaci.stream().filter(proizvodjac -> proizvodjac.getProid().equals(parametri.getProizvodjac())).findFirst().isPresent();
            if (!trazeniProizvodjacPostoji) {
                proizvodjacRepository.findById(parametri.getProizvodjac()).ifPresent(proizvodjac -> proizvodjaci.add(0, proizvodjac));
            }
        }
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
        magacinDto.setProizvodjaci(proizvodjaci);
    }

    private void getPopuniProizvodjaceURobi(List<RobaDto> robaDtos, List<Proizvodjac> proizvodjaci) {
        for (RobaDto roba : robaDtos) {
            proizvodjaci.stream().filter(proizvodjac -> proizvodjac.getProid().equals(roba.getProizvodjac().getProid())).findFirst().ifPresent(proizvodjac -> {
                roba.setProizvodjac(proizvodjac);
            });
        }
    }

    public List<Proizvodjac> pronadjiSveProizvodjaceZaVrstu(UniverzalniParametri parametri) {
        List<Proizvodjac> proizvodjaci;
        switch (parametri.getVrstaRobe()) {
            case SVE:
                proizvodjaci = pronadjiSve();
                break;
            case ULJA:
                proizvodjaci = proizvodjaciUlja(parametri.getVrstaUlja());
                break;
            case FILTERI:
                proizvodjaci = proizvodjaciFiltera();
                break;
            case AKUMULATORI:
                proizvodjaci = proizvodjaciAkumulatora();
                break;
            case OSTALO:
                proizvodjaci = porizvodjacZaKategoriju(parametri.getNaziviGrupe());
                break;
            default:
                proizvodjaci = new ArrayList<>();
        }
        return proizvodjaci;
    }

    private List<Proizvodjac> pronadjiSve() {
        List<Proizvodjac> proizvodjaci = proizvodjacRepository.findAllByOrderByNazivAsc();
        return proizvodjaci;
    }

    private List<Proizvodjac> proizvodjaciFiltera() {
        List<Integer> podGrupeId = podGrupaService.vratiSvePodGrupeIdPoNazivu(GrupeKonstante.FILTER);
        Set<String> filterRoba = robaService.pronadjiSvuRobuPoPodGrupiIdLista(podGrupeId)
                .stream()
                .map(robaEnitet -> robaEnitet.getProizvodjac().getProid())
                .collect(Collectors.toSet());
        List<Proizvodjac> proizvodjaci = pronadjiSve().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        return proizvodjaci;
    }

    private List<Proizvodjac> proizvodjaciAkumulatora() {
        List<String> grupeId = grupaService.vratiSveIdGrupePoNazivu(GrupeKonstante.AKUMULATOR);
        Set<String> filterRoba = robaService.pronadjuSvuRobuPoGrupiIdNaStanju(grupeId)
                .stream()
                .map(robaEnitet -> robaEnitet.getProizvodjac().getProid())
                .collect(Collectors.toSet());
        List<Proizvodjac> proizvodjaci = proizvodjacRepository.findAllByOrderByNazivAsc().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        return proizvodjaci;
    }

    public List<Proizvodjac> proizvodjaciUlja(String vrstaUlja) {
        List<Integer> svePodGrupeUlja = new ArrayList<>();
        pronadjiSvePodGrupeUZavisnostiOdVrste(svePodGrupeUlja, vrstaUlja);
        Set<String> filterRoba = robaService.pronadjiSvuRobuPoPodGrupiIdListaSvaStanja(svePodGrupeUlja)
                .stream()
                .map(robaEnitet -> robaEnitet.getProizvodjac().getProid())
                .collect(Collectors.toSet());
        List<Proizvodjac> proizvodjaci = pronadjiSve().stream().filter(proizvodjac -> filterRoba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        return proizvodjaci;
    }

    private List<Proizvodjac> porizvodjacZaKategoriju(List<String> podVrsta) {
        List<Integer> svePodGrupeUlja = new ArrayList<>();
        podVrsta.forEach(naziv -> svePodGrupeUlja.addAll(podGrupaService.vratiSvePodGrupeIdPoNazivu(naziv)));
        Set<String> roba = robaService.pronadjiSvuRobuPoPodGrupiIdLista(svePodGrupeUlja)
                .stream()
                .map(robaEnitet -> robaEnitet.getProizvodjac().getProid())
                .collect(Collectors.toSet());
        List<Proizvodjac> proizvodjaci = pronadjiSve().stream().filter(proizvodjac -> roba.contains(proizvodjac.getProid())).collect(Collectors.toList());
        return proizvodjaci;
    }

    private void pronadjiSvePodGrupeUZavisnostiOdVrste(List<Integer> svePodGrupeUlja, String vrstaUlja) {
        RobaStaticUtils.pronadjiSveVrsteUlja(vrstaUlja).stream()
                .filter(str -> str != null)
                .forEach(vrsta -> svePodGrupeUlja.addAll(podGrupaService.vratiSvePodGrupeIdPoNazivu(vrsta)));
    }

    public Proizvodjac vrateNazivProizvodjacaPoId(String id) {
        Proizvodjac retVal = null;
        Optional<Proizvodjac> naziv = pronadjiSve().stream()
                .filter(grupa -> grupa.getProid().equals(id))
                .findFirst();
        if (naziv.isPresent()) {
            retVal = naziv.get();
        }
        return retVal;
    }

    public Optional<Proizvodjac> vratiProizvodjacaPoPk(String id) {
        return proizvodjacRepository.findById(id);
    }
}
