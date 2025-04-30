package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.RobaTekst;
import com.automaterijal.application.services.LogWebService;
import com.automaterijal.application.services.roba.RobaGlavniService;
import com.automaterijal.application.services.roba.RobaSearchService;
import com.automaterijal.application.services.roba.RobaTekstService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import com.automaterijal.application.utils.RobaSpringBeanUtils;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/roba")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaController {

  @NonNull final RobaGlavniService robaGlavniService;
  @NonNull final RobaSearchService robaSearchService;
  @NonNull final RobaTekstService robaTekstService;
  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;
  @NonNull final RobaSpringBeanUtils robaSpringBeanUtils;
  @NonNull final LogWebService logWebService;

  @GetMapping
  public ResponseEntity<MagacinDto> pronadjiSvuRobu(
      @RequestParam(required = false) Optional<Integer> page,
      @RequestParam(required = false) Optional<Integer> pageSize,
      @RequestParam(required = false) List<String> proizvodjaci,
      @RequestParam(required = false) List<String> grupe,
      @RequestParam(required = false) List<String> mandatoryProid,
      @RequestParam(required = false) Optional<Boolean> naStanju,
      @RequestParam(required = false) List<Integer> podgrupe,
      @RequestParam(required = false) Optional<String> searchTerm,
      Authentication authentication) {

    var univerzalniParametri =
        robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(
            page,
            pageSize,
            proizvodjaci,
            grupe,
            mandatoryProid,
            naStanju,
            searchTerm,
            podgrupe,
            false);
    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    logWebService.log(uPartner, univerzalniParametri);
    MagacinDto magacinDto = robaSearchService.pretrazi(univerzalniParametri, uPartner);

    return ResponseEntity.ok().headers(createHeaders(uPartner)).body(magacinDto);
  }

  @GetMapping(value = "/{robaID}")
  public ResponseEntity<RobaDetaljiDto> vratiRobuPojedinacno(
      @PathVariable("robaID") Long robaId, Authentication authentication) {
    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    return robaGlavniService
        .pronadjiRobuPoRobaId(robaId, uPartner)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping(value = "/{robaID}")
  public ResponseEntity<Object> sacuvajTekst(
      @PathVariable("robaID") Long robaId,
      @RequestBody(required = false) String tekst,
      Authentication authentication) {
    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (uPartner != null && uPartner.getPrivilegije() == 2047) {
      log.info("Sacuvan tekst za robu {}", robaId);
      robaTekstService.sacuvajTekst(new RobaTekst(robaId, tekst));
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
      log.error("Odbijen zahtev da sacuva tekst za robu {}", robaId);
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
  }

  private HttpHeaders createHeaders(Partner partner) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("AuthenticatedUser", partner != null ? "true" : "false");
    headers.add("Access-Control-Expose-Headers", "AuthenticatedUser");
    return headers;
  }
}
