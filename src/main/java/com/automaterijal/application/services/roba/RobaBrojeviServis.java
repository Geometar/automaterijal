package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.robadetalji.RobaBrojeviDto;
import com.automaterijal.application.domain.entity.roba.RobaBrojevi;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.roba.RobaTdBrojeviRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaBrojeviServis {

    @NonNull
    final
    RobaTdBrojeviRepository brojeviRepository;

    @NonNull
    final RobaMapper mapper;

    public Map<String, List<RobaBrojeviDto>> vratiSveBrojeveZaRobidIVrsti(Long robaId, Integer vrsta) {
        List<RobaBrojevi> robaBrojevi = brojeviRepository.findByIdRobaIdAndVrsta(robaId, vrsta);
        Map<String, List<RobaBrojeviDto>> mapa = robaBrojevi.stream().map(mapper::map).collect(Collectors.groupingBy(RobaBrojeviDto::getProizvodjac));
        return mapa.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

    }
}
