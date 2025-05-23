package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.izvestaj.IzvestajDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Firma;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.KreirajIzvestaj;
import com.automaterijal.application.services.IzvestajService;
import com.automaterijal.application.utils.GeneralUtil;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/sales-reports")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class IzvestajController {

  @NonNull final IzvestajService izvestajService;

  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;

  @GetMapping
  public ResponseEntity<Page<IzvestajDto>> sviIzvestaji(
      @RequestParam(required = false) Optional<Integer> page,
      @RequestParam(required = false) Optional<Integer> pageSize,
      @RequestParam(required = false) BigDecimal dateFrom,
      @RequestParam(required = false) BigDecimal dateTo,
      @RequestParam(required = false) String searchTerm,
      @RequestParam(required = false) Integer komercijalista,
      Authentication authentication) {
    var iPage = page.isPresent() ? page.get() : 0;
    var iPageSize = pageSize.isPresent() ? pageSize.get() : 10;
    var iVremeOd =
        dateFrom == null
            ? LocalDate.now().minusYears(5).atStartOfDay()
            : GeneralUtil.timestampToLDT(dateFrom.longValue()).atStartOfDay();
    var iVremeDo =
        dateTo == null
            ? LocalDate.now().atStartOfDay().plusDays(1)
            : GeneralUtil.timestampToLDT(dateTo.longValue()).atStartOfDay().plusDays(1);
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    Page<IzvestajDto> izvestajDto =
        izvestajService.vratiSveIzvestaje(
            partner, searchTerm, iPage, iPageSize, iVremeOd, iVremeDo, komercijalista);
    return ResponseEntity.ok(izvestajDto);
  }

  @GetMapping(path = "/details/{id}")
  public ResponseEntity<IzvestajDto> vratiDetaljeIzvestaja(
      @PathVariable(name = "id") Long id, Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    Optional<IzvestajDto> izvestajDto = izvestajService.vratiIzvestajPojedinacno(id, partner);

    return izvestajDto
        .map(ResponseEntity::ok)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nije pronađen izveštaj"));
  }

  @PutMapping(path = "/details/{id}")
  public ResponseEntity<IzvestajDto> updateSalesReport(
      @PathVariable(name = "id") Long id,
      @RequestBody IzvestajDto izvestajDto,
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    Optional<IzvestajDto> optionalDto = izvestajService.update(id, izvestajDto, partner);

    return optionalDto
        .map(ResponseEntity::ok)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nije pronađen izveštaj"));
  }

  @GetMapping(path = "/companies")
  public ResponseEntity<List<Firma>> vratiSveFirme() {
    return ResponseEntity.ok(izvestajService.vratiSveFirme());
  }

  @PostMapping
  public HttpStatus kreirajIzvestaj(
      @RequestBody KreirajIzvestaj kreirajIzvestaj, Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    izvestajService.kreirajIzvestaj(partner, kreirajIzvestaj);
    return HttpStatus.CREATED;
  }
}
