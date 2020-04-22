package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Popusti;
import com.automaterijal.application.domain.entity.roba.RobaCene;
import com.automaterijal.application.domain.repository.roba.RobaCeneRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaCeneService {

    @NonNull
    final RobaCeneRepository robaCeneRepository;
    @NonNull
    final EntityManager manager;

    final Long GLAVNI_MAGACIN = 1L;

    public BigDecimal vratiCenuRobePoRobiId(final Long robaId, final String grupaId, final String proID, final Partner partner) {
        manager.clear();
        BigDecimal retVal = null;
        Double popust = 1.0;
        if (partner != null) {
            popust = preracunajPopustNaArtkalZaUlogovanogPartnera(grupaId, proID, partner);
        }
        final Optional<RobaCene> robaCene = robaCeneRepository.findByMagacinidAndRobaid(GLAVNI_MAGACIN, robaId);
        if (robaCene.isPresent()) {
            if (partner == null) {
                retVal = robaCene.get().getDeviznacena()
                        .multiply(new BigDecimal(popust))
                        .multiply(new BigDecimal(120))
                        .setScale(0, RoundingMode.CEILING);
            } else {
                retVal = robaCene.get().getDeviznacena()
                        .multiply(new BigDecimal(popust))
                        .multiply(new BigDecimal(120));
            }
        }
        return retVal;
    }

    public Double vratiRabatPartneraNaArtikal(final String proId, final String grupaId, final Partner partner) {
        manager.clear();
        Double popust = 0.0;
        if (partner != null) {
            popust = preracunajPopustNaArtkalZaUlogovanogPartnera(proId, grupaId, partner);
            if (popust > 0) {
                popust = popust * 100 - 100;
            }
        }
        return Math.abs(popust);
    }

    private Double preracunajPopustNaArtkalZaUlogovanogPartnera(final String proId, final String grupaId, final Partner partner) {
        Optional<Double> retVal = Optional.empty();
        if (partner.getPopustiList() != null) {
            retVal = partner.getPopustiList().stream()
                    .filter(
                            popusti -> grupaId.equals(popusti.getGrupaid()) && proId.equals(popusti.getProid())
                    )
                    .map(Popusti::getProcenat)
                    .findFirst();
            if (!retVal.isPresent()) {
                retVal = partner.getPopustiList().stream()
                        .filter(
                                popusti -> grupaId.equals(popusti.getGrupaid()) || proId.equals(popusti.getProid())
                        )
                        .map(Popusti::getProcenat)
                        .findFirst();
            }
        }

        return retVal.isPresent() ? 1 + retVal.get() / 100 : 1 + partner.getProcpc() / 100;
    }
}
