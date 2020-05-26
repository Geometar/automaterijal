package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.FakturaService;
import com.automaterijal.application.utils.GeneralUtil;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/fakture")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class FakturaController {

    @NonNull
    final FakturaService fakturaService;

    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    @GetMapping(value = "/{ppid}")
    public ResponseEntity<Page<FakturaDto>> vratiSveFaktureKorisnika(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) BigDecimal dateFrom,
            @RequestParam(required = false) BigDecimal dateTo,
            @PathVariable(name = "ppid") Integer ppid,
            Authentication authentication
    ) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        var iPage = page == null ? 0 : page;
        var iPageSize = pageSize == null ? 10 : pageSize;
        var iVremeOd = dateFrom == null ? LocalDate.now().minusYears(5).atStartOfDay() : GeneralUtil.timestampToLDT(dateFrom.longValue()).atStartOfDay();
        var iVremeDo = dateTo == null ? LocalDate.now().atStartOfDay().plusDays(1) : GeneralUtil.timestampToLDT(dateTo.longValue()).atStartOfDay().plusDays(1);
        if (partner == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else if (ppid != null && ppid.intValue() != partner.getPpid().intValue()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Page<FakturaDto> fakture = fakturaService.vratiSveFaktureUlogovanogKorisnika(partner, iPage, iPageSize, iVremeOd, iVremeDo);
        return ResponseEntity.ok(fakture);
    }

    @PostMapping
    public ResponseEntity<List<RobaDto>> podnesiFakturu(@RequestBody FakturaDto fakturaDto, Authentication authentication) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        if (partner == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        log.info("Porudzbenica podneta: korisnik {}, iznos narucen = {}, broj stavki = {}",
                partner.getNaziv(),
                fakturaDto.getIznosNarucen(),
                fakturaDto.getDetalji().size());

        var response = fakturaService.submitujFakturu(fakturaDto, partner);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{ppid}/{id}")
    public ResponseEntity<FakturaDto> vratiFakturu(
            @PathVariable(name = "ppid") Integer ppid,
            @PathVariable(name = "id") Integer id,
            Authentication authentication
    ) {
        Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        if (partner == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else if (ppid != null && ppid.intValue() != partner.getPpid().intValue() && partner.getPrivilegije() != 2047) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        log.info("Partner {} trazi fakturu pojedinacnu sa brojem {}", partner.getNaziv(), id);
        FakturaDto fakture = fakturaService.vratiFakuturuPojedinacno(partner, id);
        if (fakture != null) {
            return ResponseEntity.ok(fakture);
        }
        return ResponseEntity.notFound().build();
    }
}
