package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.DashboardDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
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
    final FakturaService fakturaService;

    public DashboardDto vracanjeSvihDashboardSpecifikacija() {
        DashboardDto dashboardDto = robaJooqRepository.vracanjePodatakaZaDashboard();
        dashboardDto.setBrojFaktura(fakturaService.vratiSveFakture().size() + 10000);
        return dashboardDto;
    }

    public List<RobaDto> vratiIzdvajamoIzPonudeRobu(List<Long> robaIds, Partner partner) {
        return robaGlavniService.vratiIzdvajamoIzPonudeRobu(robaIds, partner)
                .stream()
                .filter(robaDto -> robaDto.getStanje() > 0)
                .map(robaDto -> setujTextNaRazumnuDuzinu(robaDto))
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
}
