package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.LogWebDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.LogWebService;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogWebController {

  @NonNull final LogWebService logWebService;

  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;

  @GetMapping
  public ResponseEntity<Page<LogWebDto>> vratiSveLogovePartnera(
      @RequestParam(required = false) Integer ppid,
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) Integer pageSize,
      Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isInternal(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nije Admin");
    }
    var iPage = page == null ? 0 : page;
    var iPageSize = pageSize == null ? 10 : pageSize;
    Pageable pageable = PageRequest.of(iPage, iPageSize);
    return ResponseEntity.ok(logWebService.vratiLogove(ppid, pageable));
  }
}
