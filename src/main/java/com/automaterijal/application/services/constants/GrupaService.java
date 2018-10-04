package com.automaterijal.application.services.constants;

import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.repository.GrupaRepository;
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
public class GrupaService {

    @NonNull
    final GrupaRepository grupaRepository;
    List<Grupa> grupe;

    public void pronadjiSveGrupe() {
        grupe = grupaRepository.findAll();
    }

    public String vratiNazivGrupePoId(final String id) {
        return grupe.stream()
                .filter(grupa -> grupa.getGrupaid().equals(id))
                .map(Grupa::getNaziv)
                .findFirst()
                .get();
    }

}
