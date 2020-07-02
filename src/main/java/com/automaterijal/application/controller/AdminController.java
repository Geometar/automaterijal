package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.PartnerLogovanjeDto;
import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.GrupaDozvoljena;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.AdminService;
import com.automaterijal.application.services.GrupaDozvoljenaService;
import com.automaterijal.application.services.roba.grupe.GrupaService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class AdminController {

    @NonNull
    final AdminService adminService;

    @NonNull
    final GrupaDozvoljenaService grupaDozvoljenaService;

    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    @GetMapping(value = "/logovanja")
    public ResponseEntity<Page<PartnerLogovanjeDto>> vratiUlogovanogPartnera(@RequestParam Integer page, @RequestParam Integer pageSize, Authentication authentication) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if (partner.getPrivilegije() != 2047) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(adminService.vratiLogovanjePartnera(page, pageSize));
    }

    @GetMapping(value = "/dozvoljene_grupe")
    public ResponseEntity<List<GrupaDozvoljena>> vratiSveDozvoljeneGrupe(Authentication authentication) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if (partner.getPrivilegije() != 2047) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe());
    }

    @PostMapping(value = "/dozvoljene_grupe")
    public ResponseEntity<List<GrupaDozvoljena>> vratiSveDozvoljeneGrupe(
            Authentication authentication,
            @RequestBody GrupaDozvoljena grupaDozvoljena) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if (partner.getPrivilegije() != 2047) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        grupaDozvoljenaService.dodajGrupu(grupaDozvoljena);
        return ResponseEntity.ok(grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe());
    }

    @DeleteMapping(value = "/dozvoljene_grupe/{grupaId}")
    public ResponseEntity<List<GrupaDozvoljena>>  izbrisiGrupu(@PathVariable String grupaId, Authentication authentication) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if (partner.getPrivilegije() != 2047) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        grupaDozvoljenaService.izbrisiGrupu(grupaId);
        return ResponseEntity.ok(grupaDozvoljenaService.pronadjiSveDozvoljeneGrupe());
    }


    @GetMapping(value = "/grupe")
    public ResponseEntity<List<Grupa>> vratiSveGrupe(Authentication authentication) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if (partner.getPrivilegije() != 2047) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(grupaDozvoljenaService.vratiSveGrupeKojeNisuDozvoljene());
    }
}
