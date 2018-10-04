package com.automaterijal.application.services.constants;


import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ProizvodjacService {

    @NonNull
    final
    ProizvodjacRepository proizvodjacRepository;
    List<Proizvodjac> proizvodjaci;

    public void pronadjiSveProizvodjace() {
        proizvodjaci = proizvodjacRepository.findAll();
    }

    public String vrateNazivProizvodjacaPoId(final String id) {
        return proizvodjaci.stream()
                .filter(grupa -> grupa.getProid().equals(id))
                .map(Proizvodjac::getNaziv)
                .findFirst()
                .get();
    }

}
