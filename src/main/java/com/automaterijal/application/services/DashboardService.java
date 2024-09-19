package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.DashboardDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.dashboard.DashbaordGrupa;
import com.automaterijal.application.domain.entity.dashboard.RobaDashboard;
import com.automaterijal.application.domain.repository.RobaDashboardRepository;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.services.roba.RobaGlavniService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class DashboardService {

  @NonNull
  final RobaAdapterService robaJooqRepository;

  @NonNull
  final RobaGlavniService robaGlavniService;

  @NonNull
  final RobaDashboardRepository dashboardRepository;

  public DashboardDto vracanjeSvihDashboardSpecifikacija() {
    DashboardDto dashboardDto = robaJooqRepository.vracanjePodatakaZaDashboard();
    dashboardDto.setBrojFaktura(20000);
    return dashboardDto;
  }

  public List<RobaDto> vratiIzdvajamoIzPonudeRobu(DashbaordGrupa dashbaordGrupa, Partner partner) {
    List<Long> robaIds = vratiIzdvojenuRobu(dashbaordGrupa);
    return robaGlavniService.vratiIzdvajamoIzPonudeRobu(robaIds, partner)
        .stream()
        .filter(robaDto -> {
          if (partner == null || partner.getPrivilegije() != 2047) {
            return robaDto.getStanje() != 0;
          } else {
            return true;
          }
        })
        .collect(Collectors.toList());
  }

  private List<Long> vratiIzdvojenuRobu(DashbaordGrupa dashbaordGrupa) {
    return dashboardRepository.findByGrupa(dashbaordGrupa)
        .stream()
        .map(RobaDashboard::getRobaId)
        .collect(Collectors.toList());
  }

  public void updejtuj(Long staraRobaId, Long novaRobaiD, DashbaordGrupa dashbaordGrupa) {
    dashboardRepository.findById(staraRobaId).ifPresent(roba -> {
      if (roba.getGrupa() == dashbaordGrupa) {
        var robaDashboard = new RobaDashboard();
        robaDashboard.setRobaId(novaRobaiD);
        robaDashboard.setGrupa(dashbaordGrupa);
        dashboardRepository.delete(roba);
        dashboardRepository.save(robaDashboard);
      }
    });

  }
}
