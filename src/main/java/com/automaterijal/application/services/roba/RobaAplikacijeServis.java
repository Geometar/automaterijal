package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.robadetalji.RobaAplikacijaDto;
import com.automaterijal.application.domain.entity.roba.RobaAplikacija;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.roba.RobaAplikacijaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaAplikacijeServis {

    @NonNull
    final RobaAplikacijaRepository repository;

    @NonNull
    final RobaMapper mapper;

    public Map<String, List<RobaAplikacijaDto>> vratiAplikacijeZaDetalje(Long robaId) {
        Map<String, List<RobaAplikacijaDto>> retVal = new HashMap<>();
        List<RobaAplikacija> aplikacije = repository.findByRobaId(robaId);
        if (!aplikacije.isEmpty()) {
            retVal = aplikacije.stream().map(mapper::mapAplikacija).collect(Collectors.groupingBy(RobaAplikacijaDto::getProizvodjacNaziv));
            retVal = retVal.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        }
        return retVal;
    }
}
