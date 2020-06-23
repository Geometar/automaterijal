package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.DashboardDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.roba.RobaGlavniService;
import com.automaterijal.application.services.roba.RobaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Value;
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
        dashboardDto.setBrojFaktura(fakturaService.vratiSveFakture().size());
        return dashboardDto;
    }

    public List<RobaDto> vratiIzdvajamoIzPonudeRobu(List<Long> robaIds, Partner partner) {
        return robaGlavniService.vratiIzdvajamoIzPonudeRobu(robaIds, partner)
                .stream()
                .filter(robaDto -> robaDto.getStanje() > 0)
                .collect(Collectors.toList());
    }

}
