package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.entity.roba.RobaTekst;
import com.automaterijal.application.domain.repository.roba.RobaTextRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaTekstService {

    @NonNull
    final RobaTextRepository repository;

    public Optional<RobaTekst> pronadjiTextPoRobiId(Long robaId) {
        return repository.findById(robaId);
    }

    public void sacuvajTekst(RobaTekst robaTekst) {
        log.info("Sacuvan tekst za robu {}", robaTekst.getRobaid());
        repository.save(robaTekst);
    }

}
