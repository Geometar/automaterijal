package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.DashboardDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.DashboardService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dashboard")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class DashboardController {

    @NonNull
    final DashboardService service;

    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    @GetMapping("/specifikacije")
    public ResponseEntity<DashboardDto> vracanjeOsnovnihPodatakaZaDashboard() {
        return ResponseEntity.ok(service.vracanjeSvihDashboardSpecifikacija());
    }

    @GetMapping("/izdvajamo")
    public ResponseEntity<List<RobaDto>> vracanjeIzdvojeneRobeZaPonudu(Authentication authentication, @RequestParam List<Long> robaIds) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        return ResponseEntity.ok(service.vratiIzdvajamoIzPonudeRobu(robaIds, partner));
    }

}
