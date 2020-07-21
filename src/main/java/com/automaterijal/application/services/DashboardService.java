package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.DashboardDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.dashboard.DashbaordGrupa;
import com.automaterijal.application.domain.entity.dashboard.RobaDashboard;
import com.automaterijal.application.domain.repository.RobaDashboardRepository;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.roba.RobaGlavniService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class DashboardService {

    @NonNull
    final RobaJooqRepository robaJooqRepository;

    @NonNull
    final RobaGlavniService robaGlavniService;

    @NonNull
    final RobaDashboardRepository dashboardRepository;

    @NonNull
    final FakturaService fakturaService;

    public DashboardDto vracanjeSvihDashboardSpecifikacija() {
        DashboardDto dashboardDto = robaJooqRepository.vracanjePodatakaZaDashboard();
        dashboardDto.setBrojFaktura(fakturaService.vratiSveFakture().size() + 10000);
        return dashboardDto;
    }

    public List<RobaDto> vratiIzdvajamoIzPonudeRobu(DashbaordGrupa dashbaordGrupa, Partner partner) {
        List<Long> robaIds = vratiIzdvojenuRobu(dashbaordGrupa);
        return robaGlavniService.vratiIzdvajamoIzPonudeRobu(robaIds, partner)
                .stream()
                .filter(robaDto -> {
                    if(partner == null || partner.getPrivilegije() != 2047) {
                        return robaDto.getStanje() != 0;
                    } else {
                        return true;
                    }
                })
                .map(robaDto -> setujTextNaRazumnuDuzinu(robaDto))
                .collect(Collectors.toList());
    }

    private List<Long> vratiIzdvojenuRobu(DashbaordGrupa dashbaordGrupa) {
        return dashboardRepository.findByGrupa(dashbaordGrupa)
                .stream()
                .map(RobaDashboard::getRobaId)
                .collect(Collectors.toList());
    }

    private RobaDto setujTextNaRazumnuDuzinu(RobaDto robaDto) {
        if (robaDto.getNaziv().length() > 29) {
            StringBuilder noviText = new StringBuilder();
            String textNiz[] = robaDto.getNaziv().split(" ");
            for (int i = 0; i < textNiz.length - 1; i++) {
                noviText.append(textNiz[i] + " ");
                if (noviText.length() + textNiz[i].length() > 29) {
                    robaDto.setNaziv(noviText.toString());
                    break;
                }
            }
        }
        return robaDto;
    }

    public void updejtuj(Long staraRobaId, Long novaRobaiD, DashbaordGrupa dashbaordGrupa) {
        dashboardRepository.findById(staraRobaId).ifPresent(roba -> {
            if(roba.getGrupa() == dashbaordGrupa) {
                var robaDashboard = new RobaDashboard();
                robaDashboard.setRobaId(novaRobaiD);
                robaDashboard.setGrupa(dashbaordGrupa);
                dashboardRepository.delete(roba);
                dashboardRepository.save(robaDashboard);
            }
        });

    }
}
