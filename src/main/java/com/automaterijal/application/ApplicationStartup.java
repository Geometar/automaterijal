package com.automaterijal.application;

import com.automaterijal.application.services.constants.GrupaService;
import com.automaterijal.application.services.constants.PodGrupaService;
import com.automaterijal.application.services.constants.ProizvodjacService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @NonNull
    GrupaService grupaService;
    @NonNull
    PodGrupaService podGrupaService;
    @NonNull
    ProizvodjacService proizvodjacService;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        grupaService.pronadjiSveGrupe();
        podGrupaService.pronadjiSvePodGrupe();
        proizvodjacService.pronadjiSveProizvodjace();
    }
}
