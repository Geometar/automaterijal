package com.automaterijal.application.services.roba.grupe;

import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.repository.GrupaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class GrupaService {

    @NonNull
    final GrupaRepository grupaRepository;

    public List<Grupa> pronadjiSveGrupe() {
       return grupaRepository.findAll();
    }

    public List<String> vratiSveIdGrupePoNazivu(final String naziv) {
        return grupaRepository.findByNaziv(naziv)
                .stream()
                .map(Grupa::getGrupaid)
                .collect(Collectors.toList());
    }

    public String vratiNazivGrupePoId(final String id) {
        String retVal = null;
        final Optional<Grupa> grupa =  grupaRepository.findById(id);
        if(grupa.isPresent()) {
            retVal = grupa.get().getNaziv();
        }
        return retVal;
    }
}
