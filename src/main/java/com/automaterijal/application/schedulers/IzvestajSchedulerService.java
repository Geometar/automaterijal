package com.automaterijal.application.schedulers;

import com.automaterijal.application.domain.dto.izvestaj.IzvestajDto;
import com.automaterijal.application.services.IzvestajService;
import com.automaterijal.application.services.PartnerService;
import com.automaterijal.application.services.email.EmailService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IzvestajSchedulerService {

    @NonNull
    IzvestajService izvestajService;

    @NonNull
    EmailService emailService;

    @NonNull
    PartnerService partnerService;

    @Scheduled(cron = "${schedule.izvestaj.podsetnik}")
    public void saljiMejloveZaIzvestaje() {
        log.info("Provera izvestaja i slanje podsetnika.");
        List<IzvestajDto> izvestaji = izvestajService.prinadjiIzvestajNaDanasnjiDan();
//        izvestaji.forEach(izvestajDto -> emailService.posaljiIzvestajEmail(izvestajDto));

    }

}
