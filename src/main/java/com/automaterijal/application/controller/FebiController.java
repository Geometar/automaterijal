package com.automaterijal.application.controller;

import com.automaterijal.application.integration.providers.febi.FebiInventoryProvider;
import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/febi")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class FebiController {

  @NonNull final FebiInventoryProvider febiInventoryProvider;

  @GetMapping("/stock")
  public AvailabilityResult checkStockGet(@RequestParam(value = "item") List<String> items) {
    if (items == null || items.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "item list is required");
    }
    return executeLookup(items);
  }

  @PostMapping("/stock")
  public AvailabilityResult checkStock(@RequestBody(required = false) FebiStockLookupRequest request) {
    if (request == null || request.items == null || request.items.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "items list is required");
    }
    return executeLookup(request.items);
  }

  private AvailabilityResult executeLookup(List<String> items) {
    InventoryQuery query = InventoryQuery.builder().brand("FEBI").articleNumbers(items).build();

    try {
      return febiInventoryProvider.checkAvailability(query);
    } catch (ProviderRateLimitException ex) {
      throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, ex.getMessage(), ex);
    } catch (ProviderAuthenticationException ex) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
    } catch (ProviderUnavailableException ex) {
      throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), ex);
    } catch (RuntimeException ex) {
      log.warn("Unexpected error while calling Febi stock", ex);
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
    }
  }

  public record FebiStockLookupRequest(List<String> items) {}
}
