package com.automaterijal.application.controller;

import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaBranch;
import com.automaterijal.application.integration.providers.gazela.GazelaReferenceDataService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/gazela")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class GazelaController {

  private static final String BRANCHES_RATE_LIMIT_MESSAGE = "Gazela API rate limit exceeded";
  private static final String BRANCHES_AUTH_MESSAGE = "Gazela API authentication failed";
  private static final String BRANCHES_UNAVAILABLE_MESSAGE = "Gazela API is currently unavailable";
  private static final String BRANCHES_INTERNAL_ERROR_MESSAGE = "Unable to load Gazela branches";

  @NonNull final GazelaReferenceDataService referenceDataService;

  @GetMapping("/branches")
  public List<GazelaBranchDto> getBranches() {
    try {
      return referenceDataService.getBranches().stream().map(this::mapBranch).toList();
    } catch (ProviderRateLimitException ex) {
      log.warn("Gazela branches request rate limited: {}", ex.getMessage());
      throw new ResponseStatusException(
          HttpStatus.TOO_MANY_REQUESTS, BRANCHES_RATE_LIMIT_MESSAGE, ex);
    } catch (ProviderAuthenticationException ex) {
      log.warn("Gazela branches authentication failed: {}", ex.getMessage());
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, BRANCHES_AUTH_MESSAGE, ex);
    } catch (ProviderUnavailableException ex) {
      log.warn("Gazela branches provider unavailable: {}", ex.getMessage());
      throw new ResponseStatusException(
          HttpStatus.SERVICE_UNAVAILABLE, BRANCHES_UNAVAILABLE_MESSAGE, ex);
    } catch (RuntimeException ex) {
      log.warn("Unexpected error while loading Gazela branches", ex);
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, BRANCHES_INTERNAL_ERROR_MESSAGE, ex);
    }
  }

  private GazelaBranchDto mapBranch(GazelaBranch branch) {
    if (branch == null) {
      return new GazelaBranchDto(null, null, null, null);
    }
    return new GazelaBranchDto(branch.id(), branch.ime(), branch.adresa(), branch.email());
  }

  public record GazelaBranchDto(Integer id, String name, String address, String email) {}
}
