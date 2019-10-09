package com.automaterijal.application.schedulers;

import com.automaterijal.application.domain.constants.StatusiKonstante;
import com.automaterijal.application.domain.entity.Faktura;
import com.automaterijal.application.services.FakturaService;
import com.automaterijal.application.services.PartnerService;
import com.automaterijal.application.services.email.EmailService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * Ne ukljucivati scheduler do daljnjeg
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FakturaSchedulerService {

    @NonNull
    FakturaService fakturaService;

    @NonNull
    PartnerService partnerService;

    @NonNull
    EmailService emailService;

    public void proveriPromeneStatusaFakture() {
        final var timestamp  = Timestamp.valueOf(LocalDateTime.now().minusMinutes(10));
        final var fakture = fakturaService.vratiUpdejtovaneFakture(timestamp);

        fakture.forEach(faktura -> {
            boolean nedostajeRoba = false;
            if (faktura.getStatus() == StatusiKonstante.KONACNA.getFieldValue()) {
              nedostajeRoba = proveriDaLiJeSvaRobaPotvrdjena(faktura);
            }
            if (nedostajeRoba) {
                log.info("Parnteru {} potvrdjen manjak porucene robe na porudzbenici {}", faktura.getPpid(), faktura.getId());
                posaljiMail(faktura);
            }
        });
    }

    private boolean proveriDaLiJeSvaRobaPotvrdjena(final Faktura faktura) {
        final var faktureSaManjimKolicinama = faktura.getDetalji().stream()
                .filter(fD -> fD.getKolicina() > fD.getPotvrdjenaKolicina())
                .collect(Collectors.toList());

        return !faktureSaManjimKolicinama.isEmpty();
    }

    private void posaljiMail(final Faktura faktura) {
        final var partner = partnerService.pronadjiPartneraPoId(faktura.getPpid());
        final var fakturaDto = fakturaService.vratiFakuturuPojedinacno(partner, faktura.getId());
        emailService.posaljiMailONedovoljnimKolicinama(fakturaDto, partner);
    }
}
