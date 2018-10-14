package com.automaterijal.application.services.constants;


import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ProizvodjacService {

    @NonNull
    final ProizvodjacRepository proizvodjacRepository;

    @Getter
    List<Proizvodjac> proizvodjaci;

    static final String SVI_PROIZVODJACI = "SVI";

    public void pronadjiSveProizvodjace() {
        proizvodjaci = proizvodjacRepository.findAllByOrderByNazivAsc();
        proizvodjaci.add(0, new Proizvodjac("-99", SVI_PROIZVODJACI));
    }

    public String vrateNazivProizvodjacaPoId(final String id) {
        String retVal = null;
        final Optional<String> naziv =  proizvodjaci.stream()
                .filter(grupa -> grupa.getProid().equals(id))
                .map(Proizvodjac::getNaziv)
                .findFirst();
        if(naziv.isPresent()) {
            retVal = naziv.get();
        }
        return retVal;
    }

    public String vratiProizvodjacaPoNazivu(final String naziv) {
        String retVal = null;
        final Optional<String> proid = getProizvodjaci().stream().filter(proizvodjac -> proizvodjac.getNaziv().equals(naziv)).map(Proizvodjac::getProid).findAny();
        if(proid.isPresent()) {
            retVal = proid.get();
        }
        return retVal;
    }
}
