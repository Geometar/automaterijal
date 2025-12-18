package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaAtributesDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaExpandedDto;
import com.automaterijal.application.domain.dto.showcase.ShowcaseResponseDTO;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.RobaTekst;
import com.automaterijal.application.services.LogWebService;
import com.automaterijal.application.services.roba.RobaTekstService;
import com.automaterijal.application.services.roba.details.RobaDetailsService;
import com.automaterijal.application.services.roba.search.RobaSearchService;
import com.automaterijal.application.services.roba.showcase.ShowcaseService;
import com.automaterijal.application.services.tecdoc.TecDocAttributeService;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/roba")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaController {

  @NonNull final RobaDetailsService robaDetailsService;
  @NonNull final RobaSearchService robaSearchService;
  @NonNull final RobaTekstService robaTekstService;
  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;
  @NonNull final RobaSpringBeanUtils robaSpringBeanUtils;
  @NonNull final TecDocAttributeService tecDocAttributeService;
  @NonNull final LogWebService logWebService;
  @NonNull final ShowcaseService showcaseService;

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
      @RequestParam(required = false) Optional<String> filterBy,
      @RequestParam(required = false) boolean paged,
      @RequestParam(required = false) boolean showcase,
      @RequestParam(required = false, defaultValue = "false") boolean skipProvider,
      Authentication authentication) {

    var univerzalniParametri =
        robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(
            page,
            pageSize,
            proizvodjaci,
            grupe,
            mandatoryProid,
            naStanju,
            Optional.empty(),
            searchTerm,
            podgrupe,
            false,
            filterBy,
            paged,
            showcase);
    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    logWebService.log(uPartner, univerzalniParametri);
    MagacinDto magacinDto =
        robaSearchService.searchProducts(univerzalniParametri, uPartner, skipProvider);

    return ResponseEntity.ok().headers(createHeaders(uPartner)).body(magacinDto);
  }

  @GetMapping(value = "/{robaID}")
  public ResponseEntity<RobaExpandedDto> vratiRobuPojedinacno(
      @PathVariable("robaID") Long robaId, Authentication authentication) {
    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    return robaDetailsService
        .fetchRobaDetails(robaId, uPartner)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping(value = "/showcase")
  public ResponseEntity<ShowcaseResponseDTO> getShowcaseArticles(Authentication authentication) {
    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    return ResponseEntity.ok(showcaseService.buildShowcase(uPartner));
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

  @PostMapping("/{robaID}/image")
  public ResponseEntity<RobaExpandedDto> uploadSlikaZaRobu(
      @PathVariable("robaID") Long robaId,
      @RequestParam("file") MultipartFile file,
      Authentication authentication) {

    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (uPartner == null || uPartner.getPrivilegije() != 2047) {
      log.error("Neautorizovan pokusaj da se uploaduje slika za robu {}", robaId);
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }

    try {
      return robaDetailsService
          .uploadImg(robaId, file, uPartner)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (Exception e) {
      log.error("Greška pri uploadu slike za robu {}: {}", robaId, e.getMessage());
      return ResponseEntity.internalServerError().build();
    }
  }

  @DeleteMapping("/{robaID}/image")
  public ResponseEntity<Void> removeImage(
      @PathVariable("robaID") Long robaId, Authentication authentication) {

    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (uPartner == null || uPartner.getPrivilegije() != 2047) {
      log.error("Neautorizovan pokusaj da se uploaduje slika za robu {}", robaId);
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }

    try {
      robaDetailsService.deleteImg(robaId);
      return ResponseEntity.status(HttpStatus.OK).build();
    } catch (Exception e) {
      log.error("Greška pri uploadu slike za robu {}: {}", robaId, e.getMessage());
      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping("/{robaID}/atributi")
  public ResponseEntity<Void> sacuvajTecDocAtribute(
      @PathVariable("robaID") Long robaId,
      @RequestBody List<RobaAtributesDto> atributi,
      Authentication authentication) {

    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (uPartner == null || uPartner.getPrivilegije() != 2047) {
      log.error("Neautorizovan pokušaj čuvanja atribute za robu {}", robaId);
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }

    try {
      tecDocAttributeService.saveAttributesManually(atributi);
      log.info("Sačuvani atributi za robu {}", robaId);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception e) {
      log.error("Greška pri čuvanju atributa za robu {}: {}", robaId, e.getMessage());
      return ResponseEntity.internalServerError().build();
    }
  }

  @DeleteMapping("/{robaID}/atributi")
  public ResponseEntity<Void> removeAttributes(
      @PathVariable("robaID") Long robaId, Authentication authentication) {

    var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (uPartner == null || uPartner.getPrivilegije() != 2047) {
      log.error("Neautorizovan pokušaj čuvanja atribute za robu {}", robaId);
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }

    try {
      tecDocAttributeService.deleteAttributesForRobaId(robaId);
      log.info("Attributes removed for robaID: {}", robaId);
      return ResponseEntity.status(HttpStatus.OK).build();
    } catch (Exception e) {
      log.error("Something went wrong when deleting roba id: {}: {}", robaId, e.getMessage());
      return ResponseEntity.internalServerError().build();
    }
  }

  private HttpHeaders createHeaders(Partner partner) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("AuthenticatedUser", partner != null ? "true" : "false");
    headers.add("Access-Control-Expose-Headers", "AuthenticatedUser");
    return headers;
  }
}
