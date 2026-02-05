package com.automaterijal.application.controller;

import com.automaterijal.application.integration.providers.szakal.SzakalStockCheckService;
import com.automaterijal.application.integration.providers.szakal.SzakalStockCheckService.StockCheckItem;
import com.automaterijal.application.integration.providers.szakal.SzakalStockCheckService.StockCheckResult;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/szakal")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class SzakalController {

  @NonNull final SzakalStockCheckService stockCheckService;
  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;

  @PostMapping("/stock-check")
  public List<StockCheckResult> checkStock(
      @RequestBody(required = false) StockCheckRequest request,
      Authentication authentication) {
    if (request == null || request.items == null || request.items.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "items list is required");
    }
    try {
      var partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
      return stockCheckService.check(request.items, partner);
    } catch (ProviderRateLimitException ex) {
      throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, ex.getMessage(), ex);
    } catch (ProviderAuthenticationException ex) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
    } catch (ProviderUnavailableException ex) {
      throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), ex);
    } catch (RuntimeException ex) {
      log.warn("Unexpected error while calling Szakal stock check", ex);
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
    }
  }

  public record StockCheckRequest(List<StockCheckItem> items) {}
}
