package com.automaterijal.application.schedulers;

import com.automaterijal.application.domain.constants.StatusiKonstante;
import com.automaterijal.application.domain.entity.Faktura;
import com.automaterijal.application.services.FakturaService;
import com.automaterijal.application.services.PartnerService;
import com.automaterijal.application.services.email.EmailService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FakturaSchedulerService {

    @NonNull
    FakturaService fakturaService;

    @NonNull
    PartnerService partnerService;

    @NonNull
    EmailService emailService;

    @Scheduled(fixedDelayString = "${schedule.fakture.upadte}")
    public void proveriPromeneStatusaFakture() {
        final var timestamp  = Timestamp.valueOf(LocalDateTime.now().minusMinutes(10));
        final var fakture = fakturaService.vratiUpdejtovaneFakture(timestamp);

        fakture.forEach(faktura -> {
            boolean nedostajeRoba = false;
            if (faktura.getStatus() == StatusiKonstante.KONACNA.getFieldValue()) {
              nedostajeRoba = proveriDaLiJeSvaRobaPotvrdjena(faktura);
            }
            if (nedostajeRoba) {
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
