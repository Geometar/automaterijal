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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<String, RobaAplikacijaDto> vratiAplikacijeZaDetalje(Long robaId) {
        Map<String, RobaAplikacijaDto> retVal = new HashMap<>();
        List<RobaAplikacija> aplikacije = repository.findByRobaId(robaId);
        if (!aplikacije.isEmpty()) {
            retVal = aplikacije.stream().collect(Collectors.toMap(RobaAplikacija::getProizvodjacNaziv, mapper::mapAplikacija));
        }
        return retVal;
    }
}
