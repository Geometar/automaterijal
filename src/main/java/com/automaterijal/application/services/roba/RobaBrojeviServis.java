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

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaBrojeviServis {

    @NonNull
    final
    RobaTdBrojeviRepository brojeviRepository;

    @NonNull
    final
    RobaMapper mapper;

    public List<RobaBrojeviDto> vratiSveBrojeveZaRobudId(Long robaId) {
        List<RobaBrojevi> brojevi = brojeviRepository.findByIdRobaId(robaId);
        return mapper.mapBorjeve(brojevi);
    }
}
