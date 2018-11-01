package com.automaterijal.application.services;

import com.automaterijal.application.domain.entity.RobaCene;
import com.automaterijal.application.domain.repository.RobaCeneRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaCeneService {

    @NonNull
    final
    RobaCeneRepository robaCeneRepository;

    final Long GLAVNI_MAGACIN = 1L;

    public BigDecimal vratiCenuRobePoRobiId(final Long robaId) {
        BigDecimal retVal = null;
        final Long id = robaId;
        final Optional<RobaCene> robaCene = robaCeneRepository.findByMagacinidAndRobaid(GLAVNI_MAGACIN, id);
        if (robaCene.isPresent()) {
            retVal = robaCene.get().getDeviznacena()
                    .multiply(new BigDecimal(120))
                    .setScale(0, RoundingMode.CEILING);
        }
        return retVal;
    }
}
