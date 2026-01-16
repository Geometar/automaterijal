package com.automaterijal.application.controller;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.providers.febi.order.FebiOrderReferenceService;
import com.automaterijal.application.integration.providers.febi.order.model.FebiAddressDto;
import com.automaterijal.application.integration.providers.febi.order.model.FebiShippingConditionDto;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import java.util.List;
import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(
    origins = {
      "https://automaterijal.com",
      "http://localhost:4200",
      "http://127.0.0.1:4200",
      "http://localhost:4000",
      "http://127.0.0.1:4000"
    })
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class FebiOrderAdminController {

  private static final String NIJE_ADMIN = "Nije Admin";

  FebiOrderReferenceService referenceService;
  PartnerSpringBeanUtils partnerSpringBeanUtils;

  @GetMapping("/ship-to/addresses")
  public List<FebiAddressDto> getShipToAddresses(Authentication authentication) {
    return execute(authentication, referenceService::fetchShipToAddresses);
  }

  @GetMapping("/sold-to/addresses")
  public List<FebiAddressDto> getSoldToAddresses(Authentication authentication) {
    return execute(authentication, referenceService::fetchSoldToAddresses);
  }

  @GetMapping("/shipping/conditions")
  public List<FebiShippingConditionDto> getShippingConditions(Authentication authentication) {
    return execute(authentication, referenceService::fetchShippingConditions);
  }

  private <T> T execute(Authentication authentication, Supplier<T> action) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (!PartnerPrivilegeUtils.isInternal(partner)) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, NIJE_ADMIN);
    }

    try {
      return action.get();
    } catch (ProviderRateLimitException ex) {
      throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, ex.getMessage(), ex);
    } catch (ProviderAuthenticationException ex) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
    } catch (ProviderUnavailableException ex) {
      throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), ex);
    } catch (RuntimeException ex) {
      log.warn("Unexpected error while calling Febi reference data", ex);
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
    }
  }
}
