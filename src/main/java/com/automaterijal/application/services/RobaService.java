package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.repository.RobaRepository;
import com.automaterijal.application.services.constants.GrupaService;
import com.automaterijal.application.services.constants.ProizvodjacService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaService {

    @NonNull
    final
    ProizvodjacService proizvodjacService;

    @NonNull
    final
    GrupaService grupaService;

    @NonNull
    final
    RobaRepository robaRepository;

    public Page<Roba> findAll(final Integer page, final Integer pageSize) {
        final List<RobaDto> robaDtos = new ArrayList<>();
        final Page<Roba> roba = robaRepository.findAll(PageRequest.of(page, pageSize));
        roba.getContent().forEach(robaElement -> {
            final Grupa grupa = grupaService.findById(robaElement.getGrupaid());
            final Proizvodjac proizvodjac = proizvodjacService.findById(robaElement.getProid());
        });
        return null;
    }
}
