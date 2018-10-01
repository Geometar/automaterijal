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

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ProizvodjacService {

    @NonNull
    ProizvodjacRepository proizvodjacRepository;

    public Proizvodjac findById(final String id) {
        final Proizvodjac proizvodjac = proizvodjacRepository.getOne(id);
        return proizvodjac;
    }

}
