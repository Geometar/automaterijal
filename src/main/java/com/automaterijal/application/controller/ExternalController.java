package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.ExternalRobaDto;
import com.automaterijal.application.domain.entity.external.PartnerB2bId;
import com.automaterijal.application.services.PartnerExternalService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ExternalAccess")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ExternalController {

    @NonNull
    final PartnerExternalService partnerExternalService;

    private final static String GRESKA = "SecurityId not exists or ItemNo is empty";

    @GetMapping(value = "/GetItemDetails")
    public ExternalRobaDto pronadjiSvuRobu(
            @RequestParam(required = false) String ItemNo,
            @RequestParam(required = false) String SecurityId,
            @RequestParam(required = false) Integer BrandID
    ) {
        ExternalRobaDto retVal;
        Optional<PartnerB2bId> partnerB2bId = partnerExternalService.pronadjiPartneraPoUuid(SecurityId);
        if (partnerB2bId.isPresent() && ItemNo != null) {
            retVal = partnerExternalService.pronadjiRobu(partnerB2bId.get().getPpid(), ItemNo, BrandID);
        } else {
            log.info("Vracena greska jer itemNo {} ili secId {} je nula", ItemNo, SecurityId);
            retVal = new ExternalRobaDto();
            retVal.setErrorMessage(GRESKA);
        }
        return retVal;
    }

}
