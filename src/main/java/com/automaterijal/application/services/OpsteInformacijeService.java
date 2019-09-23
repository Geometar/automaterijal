package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.mapper.OpsteInformacijeMapper;
import com.automaterijal.application.domain.repository.valuehelp.NacinPlacanjaRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPrevozaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OpsteInformacijeService {

    @NonNull
    final NacinPlacanjaRepository nacinPlacanjaRepository;

    @NonNull
    final NacinPrevozaRepository nacinPrevozaRepository;

    @NonNull
    final OpsteInformacijeMapper mapper;

    public List<ValueHelpDto> vratiSveNacinePlacanja() {
        return nacinPlacanjaRepository.findAll().stream().map(mapper::map).collect(Collectors.toList());
    }
    public List<ValueHelpDto> vratiSveNacinePrevoza() {
        return nacinPrevozaRepository.findAll().stream().map(mapper::map).collect(Collectors.toList());
    }
}
