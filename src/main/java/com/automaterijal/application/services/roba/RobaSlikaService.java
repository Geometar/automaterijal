package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.entity.roba.RobaSlika;
import com.automaterijal.application.domain.repository.roba.RobaSlikaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaSlikaService {

    @NonNull
    final private RobaSlikaRepository slikaRepository;

    public Optional<RobaSlika> pronadjiPutanjuSlikePoId(Long id) {
        return slikaRepository.findById(id);
    }
}
