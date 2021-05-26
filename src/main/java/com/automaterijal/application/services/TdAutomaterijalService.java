package com.automaterijal.application.services;

import com.automaterijal.application.domain.entity.external.TdAutomaterijal;
import com.automaterijal.application.domain.repository.external.TdAutomaterijalRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TdAutomaterijalService {

    @NonNull
    final TdAutomaterijalRepository tdAutomaterijalRepository;

    public Optional<String> vratiNasProIdIzTecDoca(Integer brandID) {
        Optional<String> retVal = Optional.empty();
        Optional<TdAutomaterijal> tdAutomaterijalOpt = tdAutomaterijalRepository.findById(brandID);
        if (!tdAutomaterijalOpt.isEmpty()) {
            retVal = Optional.of(tdAutomaterijalOpt.get().getProid());
        }
        return retVal;
    }

}
