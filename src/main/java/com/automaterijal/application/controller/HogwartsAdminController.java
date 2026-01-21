package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.admin.HogwartsOverviewResponse;
import com.automaterijal.application.domain.dto.admin.HogwartsRevenueOverviewResponse;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.providers.szakal.SzakalImportService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  @NonNull final SzakalImportService szakalImportService;
  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;

  @GetMapping("/overview")
  public ResponseEntity<HogwartsOverviewResponse> overview(Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(hogwartsAdminService.fetchOverview());
  }

  @GetMapping("/revenue-overview")
  public ResponseEntity<HogwartsRevenueOverviewResponse> revenueOverview(
      Authentication authentication,
      @RequestParam(name = "days", required = false) Integer days,
      @RequestParam(name = "years", required = false) Integer years) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(hogwartsAdminService.fetchRevenueOverview(days, years));
  }

  @PostMapping("/szakal/import")
  public ResponseEntity<SzakalImportService.ImportSummary> importSzakal(
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(szakalImportService.importAll());
  }

  @PostMapping("/szakal/import/master")
  public ResponseEntity<SzakalImportService.ImportSummary> importSzakalMaster(
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(szakalImportService.importMasterOnly());
  }

  @PostMapping("/szakal/import/pricelists")
  public ResponseEntity<SzakalImportService.ImportSummary> importSzakalPricelists(
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(szakalImportService.importPriceListsOnly());
  }

  @PostMapping("/szakal/import/barcodes")
  public ResponseEntity<SzakalImportService.ImportResult> importSzakalBarcodes(
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(szakalImportService.importBarcodesOnly());
  }

  @GetMapping("/szakal/status")
  public ResponseEntity<SzakalImportService.StatusSummary> szakalStatus(
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(szakalImportService.status());
  }

  @GetMapping("/szakal/files")
  public ResponseEntity<SzakalImportService.FilesSummary> szakalFiles(
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(szakalImportService.files());
  }
}
