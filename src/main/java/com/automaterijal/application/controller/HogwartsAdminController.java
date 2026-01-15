package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.admin.HogwartsOverviewResponse;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.admin.HogwartsAdminService;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/admin/hogwarts")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HogwartsAdminController {

  @NonNull final HogwartsAdminService hogwartsAdminService;
  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;

  @GetMapping("/overview")
  public ResponseEntity<HogwartsOverviewResponse> overview(Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(hogwartsAdminService.fetchOverview());
  }
}
