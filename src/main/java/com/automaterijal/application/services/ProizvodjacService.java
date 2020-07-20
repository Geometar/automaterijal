package com.automaterijal.application.services;


import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.services.roba.grupe.GrupaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
        if (parametri.getPodgrupaZaPretragu() == null && parametri.getTrazenaRec() == null) {
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
        List<Proizvodjac> proizvodjaci = null;

        if (parametri.getRobaKategorije() == null) {
            proizvodjaci = pronadjiSve();
        } else if (parametri.getRobaKategorije().isGrupaPretraga() == true) {
            proizvodjaci = proizvodjaciKateogrija(parametri.getPodGrupe());
        } else if (parametri.getRobaKategorije().isPodgrupaPretraga() == true) {
            proizvodjaci = proizvodjaciKateogrija(parametri.getPodGrupe());
        } else {
            proizvodjaci = new ArrayList<>();
        }
        return proizvodjaci;
    }

    private List<Proizvodjac> pronadjiSve() {
        List<Proizvodjac> proizvodjaci = proizvodjacRepository.findAllByOrderByNazivAsc()
                .stream()
                .filter(proizvodjac -> !proizvodjac.getNaziv().equals("0"))
                .collect(Collectors.toList());
        return proizvodjaci;
    }

    public List<Proizvodjac> proizvodjaciKateogrija(List<PodGrupa> podgrupe) {
        Set<String> filterRoba = robaService.pronadjiSvuRobuPoPodGrupiIdListaSvaStanja(podgrupe.stream().map(PodGrupa::getPodGrupaId).collect(Collectors.toList()))
                .stream()
                .map(robaEnitet -> robaEnitet.getProizvodjac().getProid())
                .collect(Collectors.toSet());
        List<Proizvodjac> proizvodjaci = proizvodjacRepository.findByProidIn(filterRoba)
                .stream()
                .sorted(Comparator.comparing(Proizvodjac::getNaziv))
                .collect(Collectors.toList());
        return proizvodjaci;
    }


    public Optional<Proizvodjac> vratiProizvodjacaPoPk(String id) {
        return proizvodjacRepository.findById(id);
    }
}
