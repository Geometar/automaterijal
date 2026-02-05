package com.automaterijal.application.controller;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.providers.febi.FebiProperties;
import com.automaterijal.application.integration.providers.febi.price.FebiPriceService;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import java.io.File;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/admin/febi/prices")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class FebiPriceAdminController {

  @NonNull final FebiPriceService priceService;
  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;
  @NonNull final FebiProperties febiProperties;

  @PostMapping
  public ResponseEntity<PriceReloadResponse> uploadAndReload(
      @RequestParam("file") MultipartFile file, Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    ensureSuperAdmin(partner);

    if (file == null || file.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fajl nije prosleđen");
    }

    File destination = resolveTargetFile();
    ensureParentExists(destination);

    try {
      file.transferTo(destination);
    } catch (IOException ex) {
      log.error(
          "Neuspešno čuvanje Febi price list fajla na {}: {}",
          destination.getAbsolutePath(),
          ex.getMessage());
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "Neuspešno čuvanje fajla");
    }

    var result = priceService.reload();
    return ResponseEntity.ok(
        new PriceReloadResponse(
            result.count(), result.path(), result.lastModified(), result.sizeBytes()));
  }

  @PostMapping("/reload")
  public ResponseEntity<PriceReloadResponse> reload(Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    ensureSuperAdmin(partner);

    File destination = resolveTargetFile();
    if (!destination.exists() || !destination.isFile()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Price list fajl ne postoji na disku");
    }

    var result = priceService.reload();
    return ResponseEntity.ok(
        new PriceReloadResponse(
            result.count(), result.path(), result.lastModified(), result.sizeBytes()));
  }

  @GetMapping("/meta")
  public ResponseEntity<PriceFileInfoResponse> meta(Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    ensureSuperAdmin(partner);

    return priceService
        .priceFileInfo()
        .map(
            info ->
                ResponseEntity.ok(
                    new PriceFileInfoResponse(info.path(), info.lastModified(), info.sizeBytes())))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
  }

  @GetMapping("/status")
  public ResponseEntity<PriceStatusResponse> status(Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    ensureSuperAdmin(partner);

    var dbStatus = priceService.dbStatus();
    var fileInfo = priceService.priceFileInfo().orElse(null);

    return ResponseEntity.ok(
        new PriceStatusResponse(
            dbStatus.count(),
            dbStatus.updatedAt(),
            fileInfo != null ? fileInfo.path() : null,
            fileInfo != null ? fileInfo.lastModified() : null,
            fileInfo != null ? fileInfo.sizeBytes() : null));
  }

  private File resolveTargetFile() {
    String path = febiProperties.getPriceListPath();
    if (!StringUtils.hasText(path)) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Nije podešena putanja do price list fajla");
    }
    return new File(path);
  }

  private void ensureParentExists(File destination) {
    File parent = destination.getParentFile();
    if (parent != null && !parent.exists() && !parent.mkdirs()) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "Ne mogu da napravim direktorijum za price list fajl");
    }
  }

  private void ensureSuperAdmin(Partner partner) {
    if (!PartnerPrivilegeUtils.isSuperAdmin(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
  }

  public record PriceReloadResponse(
      Integer count, String path, Long lastModified, Long sizeBytes) {}

  public record PriceFileInfoResponse(String path, Long lastModified, Long sizeBytes) {}

  public record PriceStatusResponse(
      Integer count, Long dbUpdatedAt, String path, Long lastModified, Long sizeBytes) {}
}
