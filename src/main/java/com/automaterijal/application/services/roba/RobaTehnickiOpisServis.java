package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.roba.RobaTehnickiOpisRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RobaTehnickiOpisServis {

    @NonNull
    RobaTehnickiOpisRepository repository;

    @NonNull
    RobaMapper mapper;

    public Set<RobaTehnickiOpisDto> vratiTehnickiOpisPoIdRobe(Long robaId) {
        List<RobaTehnickiOpisDto> tehnickiOpisi = mapper.map(repository.findByRobaId(robaId));
        return new HashSet<>(tehnickiOpisi);
    }
}
