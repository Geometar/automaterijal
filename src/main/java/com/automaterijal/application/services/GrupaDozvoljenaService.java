package com.automaterijal.application.services;

import com.automaterijal.application.domain.entity.GrupaDozvoljena;
import com.automaterijal.application.domain.repository.GrupaDozvoljenaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class GrupaDozvoljenaService {

    @NonNull
    final GrupaDozvoljenaRepository repository;

    public List<String> pronadjiSveDozvoljeneGrupe() {
        return repository.findAll()
                .stream()
                .map(GrupaDozvoljena::getGrupaId)
                .collect(Collectors.toList());
    }
}
