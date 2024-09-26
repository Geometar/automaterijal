package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.PartnerAkcije;
import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.dto.ResetovanjeSifreDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.PartnerService;
import com.automaterijal.application.services.security.UserDetailsService;
import com.automaterijal.application.services.security.UsersService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PartnerController {

  @NotNull
  final UserDetailsService service;

  @NonNull
  final UsersService usersService;

  @NonNull
  final PartnerService partnerService;

  @NonNull
  final PartnerSpringBeanUtils partnerSpringBeanUtils;

  /**
   * Kontroler za vracanje ulogovanog partnera iz spring security-ja
   */
  @GetMapping(value = "/read")
  public ResponseEntity<PartnerDto> vratiUlogovanogPartnera(
      final Authentication authentication,
      @RequestParam final boolean prviRequest) {

    final var dto = service.vratiUlogovanogKorisnika(authentication);
    if (dto != null && prviRequest) {
      log.info("Ulogovao se partner: {}", dto.getNaziv());
      usersService.logovanomUseruPovecajKolikoSePutaLogovao(dto.getPpid());
    }
    return ResponseEntity.ok(dto);
  }

  /**
   * Kontroler za updejtovanje informacija o partneru
   */
  @PutMapping(value = "/update")
  public ResponseEntity<PartnerDto> updejtujPartnera(
      @RequestBody final PartnerDto partnerDto,
      @RequestParam final PartnerAkcije vrstaPromene,
      final Authentication authentication) {
    final var partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

    if (partner == null || partner.getPpid().intValue() != partnerDto.getPpid().intValue()) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    final var response = partnerService.updejtPartnera(partnerDto, partner, vrstaPromene);

    if (response == null) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(response);
  }

  /**
   * Kontroler za promenu izgubljene sifre partnera ili kod prvog logovanja
   */
  @PutMapping(value = "/promena-sifre")
  public ResponseEntity<Object> promeniSifruPartnera(
      final Authentication authentication,
      @RequestBody final ResetovanjeSifreDto dto,
      @RequestParam final boolean isPrvaPromena) {
    final var partnerDto = service.vratiUlogovanogKorisnika(authentication);

    if ((!isPrvaPromena && !dto.getSifra().equals(dto.getPonovljenjaSifra())) && (
        isPrvaPromena && partnerDto == null || !dto.getSifra()
            .equals(dto.getPonovljenjaSifra()))) {
      return ResponseEntity.badRequest().build();
    }

    final var uspesnaPromena = partnerService.promeniSifruPartnera(dto, isPrvaPromena);
    if (uspesnaPromena) {
      log.info("Partner sa id {} je promenio sifru", dto.getPpid());
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping(value = "/komercijalsti")
  public ResponseEntity<List<Partner>> vratiSveKomercijaliste(final Authentication authentication) {
    final var partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (partner.getPrivilegije().intValue() != 2047) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    } else {
      return ResponseEntity.ok(partnerService.vratiSveKomercijaliste());
    }
  }

  @GetMapping(value = "/{ppid}")
  public ResponseEntity<Partner> vratiPartnera(
      @PathVariable("ppid") Integer ppid,
      final Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (partner.getPrivilegije() != 2047) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    return ResponseEntity.ok(partnerService.vratiPartnera(ppid));
  }
}
