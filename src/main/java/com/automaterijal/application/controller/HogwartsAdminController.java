package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.admin.HogwartsOverviewResponse;
import com.automaterijal.application.domain.dto.admin.HogwartsRevenueOverviewResponse;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.providers.szakal.SzakalImportService;
import com.automaterijal.application.integration.providers.szakal.SzakalOeSearchService;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.services.admin.HogwartsAdminService;
import com.automaterijal.application.services.tecdoc.TecDocBrandService;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import java.util.List;
import java.util.Objects;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.util.StringUtils;

@RestController
@RequestMapping("/api/admin/hogwarts")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HogwartsAdminController {

  @NonNull final HogwartsAdminService hogwartsAdminService;
  @NonNull final SzakalImportService szakalImportService;
  @NonNull final SzakalOeSearchService szakalOeSearchService;
  @NonNull final TecDocBrandService tecDocBrandService;
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

  @PostMapping("/szakal/import/oe-links")
  public ResponseEntity<SzakalImportService.ImportResult> importSzakalOeLinks(
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return ResponseEntity.ok(szakalImportService.importOeOnly());
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

  @GetMapping("/szakal/oe-search")
  public ResponseEntity<List<SzakalOeSearchService.OeSearchResult>> szakalOeSearch(
      @RequestParam(name = "oe") String oeNumber,
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    if (!StringUtils.hasText(oeNumber)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "OE is required");
    }
    return ResponseEntity.ok(szakalOeSearchService.searchByOe(oeNumber));
  }

  @GetMapping("/tecdoc-brand-mappings/{proid}")
  public ResponseEntity<TecDocBrandMappingResponse> tecdocBrandMapping(
      @PathVariable String proid, Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    return tecDocBrandService
        .findById(proid)
        .map(this::mapBrandMapping)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/tecdoc-brand-mappings")
  public ResponseEntity<List<TecDocBrandMappingResponse>> tecdocBrandMappings(
      @RequestParam(name = "q", required = false) String query,
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    String needle = query != null ? query.trim().toLowerCase() : "";
    List<TecDocBrandMappingResponse> result =
        tecDocBrandService.findAll().stream()
            .filter(Objects::nonNull)
            .filter(
                mapping -> {
                  if (!StringUtils.hasText(needle)) {
                    return true;
                  }
                  String proid = mapping.getProid() != null ? mapping.getProid().toLowerCase() : "";
                  String brandId =
                      mapping.getBrandId() != null ? mapping.getBrandId().toString() : "";
                  return proid.contains(needle) || brandId.contains(needle);
                })
            .map(this::mapBrandMapping)
            .toList();
    return ResponseEntity.ok(result);
  }

  @PutMapping("/tecdoc-brand-mappings/{proid}")
  public ResponseEntity<TecDocBrandMappingResponse> upsertTecdocBrandMapping(
      @PathVariable String proid,
      @RequestBody TecDocBrandMappingRequest request,
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    if (request == null || request.brandId == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BrandId is required");
    }
    TecDocBrands brands =
        tecDocBrandService.findById(proid).orElseGet(TecDocBrands::new);
    brands.setProid(proid);
    brands.setBrandId(request.brandId);
    if (request.brandLogoId != null) {
      brands.setBrandLogoID(request.brandLogoId);
    }
    TecDocBrands saved = tecDocBrandService.save(brands);
    return ResponseEntity.ok(mapBrandMapping(saved));
  }

  @DeleteMapping("/tecdoc-brand-mappings/{proid}")
  public ResponseEntity<Void> deleteTecdocBrandMapping(
      @PathVariable String proid, Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    tecDocBrandService.deleteByProid(proid);
    return ResponseEntity.noContent().build();
  }

  private TecDocBrandMappingResponse mapBrandMapping(TecDocBrands brands) {
    if (brands == null) {
      return null;
    }
    return new TecDocBrandMappingResponse(
        brands.getProid(), brands.getBrandId(), brands.getBrandLogoID());
  }

  public record TecDocBrandMappingRequest(Long brandId, String brandLogoId) {}

  public record TecDocBrandMappingResponse(String proid, Long brandId, String brandLogoId) {}
}
