package com.automaterijal.application.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.automaterijal.application.controller.GazelaController.GazelaBranchDto;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaBranch;
import com.automaterijal.application.integration.providers.gazela.GazelaReferenceDataService;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
class GazelaControllerTest {

  @Mock private GazelaReferenceDataService referenceDataService;

  private GazelaController controller;

  @BeforeEach
  void setUp() {
    controller = new GazelaController(referenceDataService);
  }

  @Test
  void getBranches_mapsApiBranchesToDto() {
    when(referenceDataService.getBranches())
        .thenReturn(List.of(new GazelaBranch(null, 9, null, "sabac", null, "Adresa 1", null, "a@g.rs")));

    List<GazelaBranchDto> result = controller.getBranches();

    assertThat(result).hasSize(1);
    assertThat(result.get(0).id()).isEqualTo(9);
    assertThat(result.get(0).name()).isEqualTo("sabac");
    assertThat(result.get(0).address()).isEqualTo("Adresa 1");
    assertThat(result.get(0).email()).isEqualTo("a@g.rs");
  }

  @Test
  void getBranches_mapsRateLimitTo429() {
    when(referenceDataService.getBranches()).thenThrow(new ProviderRateLimitException("slow down"));

    ResponseStatusException ex =
        assertThrows(ResponseStatusException.class, () -> controller.getBranches());

    assertThat(ex.getStatusCode()).isEqualTo(HttpStatus.TOO_MANY_REQUESTS);
    assertThat(ex.getReason()).isEqualTo("Gazela API rate limit exceeded");
  }

  @Test
  void getBranches_mapsAuthenticationTo401() {
    when(referenceDataService.getBranches()).thenThrow(new ProviderAuthenticationException("bad creds"));

    ResponseStatusException ex =
        assertThrows(ResponseStatusException.class, () -> controller.getBranches());

    assertThat(ex.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    assertThat(ex.getReason()).isEqualTo("Gazela API authentication failed");
  }

  @Test
  void getBranches_mapsUnavailableTo503() {
    when(referenceDataService.getBranches()).thenThrow(new ProviderUnavailableException("down"));

    ResponseStatusException ex =
        assertThrows(ResponseStatusException.class, () -> controller.getBranches());

    assertThat(ex.getStatusCode()).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);
    assertThat(ex.getReason()).isEqualTo("Gazela API is currently unavailable");
  }

  @Test
  void getBranches_mapsUnexpectedErrorTo500() {
    when(referenceDataService.getBranches()).thenThrow(new RuntimeException("boom"));

    ResponseStatusException ex =
        assertThrows(ResponseStatusException.class, () -> controller.getBranches());

    assertThat(ex.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    assertThat(ex.getReason()).isEqualTo("Unable to load Gazela branches");
  }
}
