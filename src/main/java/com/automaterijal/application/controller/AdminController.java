package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.PartnerLogovanjeDto;
import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.GrupaDozvoljena;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.AdminService;
import com.automaterijal.application.services.GrupaDozvoljenaService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class AdminController {

  private static final String NIJE_ADMIN = "Nije Admin";

  @NonNull final AdminService adminService;

  @NonNull final GrupaDozvoljenaService grupaDozvoljenaService;

  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;

  @GetMapping(value = "/logs")
  public ResponseEntity<Page<PartnerLogovanjeDto>> vratiUlogovanogPartnera(
      @RequestParam Integer page, @RequestParam Integer pageSize, Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (partner.getPrivilegije() != 2047) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, NIJE_ADMIN);
    }
    return ResponseEntity.ok(adminService.vratiLogovanjePartnera(page, pageSize));
  }

  @GetMapping(value = "/dozvoljene_grupe")
  public ResponseEntity<List<GrupaDozvoljena>> vratiSveDozvoljeneGrupe(
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (partner.getPrivilegije() != 2047) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, NIJE_ADMIN);
    }
    return ResponseEntity.ok(grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe());
  }

  @PostMapping(value = "/dozvoljene_grupe")
  public ResponseEntity<List<GrupaDozvoljena>> vratiSveDozvoljeneGrupe(
      Authentication authentication, @RequestBody GrupaDozvoljena grupaDozvoljena) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (partner.getPrivilegije() != 2047) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, NIJE_ADMIN);
    }
    grupaDozvoljenaService.dodajGrupu(grupaDozvoljena);
    return ResponseEntity.ok(grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe());
  }

  @DeleteMapping(value = "/dozvoljene_grupe/{grupaId}")
  public ResponseEntity<List<GrupaDozvoljena>> izbrisiGrupu(
      @PathVariable String grupaId, Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (partner.getPrivilegije() != 2047) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, NIJE_ADMIN);
    }
    grupaDozvoljenaService.izbrisiGrupu(grupaId);
    return ResponseEntity.ok(grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe());
  }

  @GetMapping(value = "/grupe")
  public ResponseEntity<List<Grupa>> vratiSveGrupe(Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (partner.getPrivilegije() != 2047) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, NIJE_ADMIN);
    }
    return ResponseEntity.ok(grupaDozvoljenaService.vratiSveGrupeKojeNisuDozvoljene());
  }
}
