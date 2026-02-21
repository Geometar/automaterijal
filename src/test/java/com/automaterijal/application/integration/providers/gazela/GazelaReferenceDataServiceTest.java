package com.automaterijal.application.integration.providers.gazela;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaBrand;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GazelaReferenceDataServiceTest {

  @Mock private GazelaApiClient apiClient;

  private GazelaReferenceDataService service;

  @BeforeEach
  void setUp() {
    GazelaProperties properties = new GazelaProperties();
    service = new GazelaReferenceDataService(apiClient, properties);
  }

  @Test
  void findBrand_returnsExactMatchWhenAvailable() {
    when(apiClient.fetchBrands())
        .thenReturn(List.of(brand(10, "BOSCH"), brand(11, "BOSCH AFTERMARKET")));

    var resolved = service.findBrand("BOSCH");

    assertThat(resolved).isPresent();
    assertThat(resolved.get().dlNr()).isEqualTo(10);
  }

  @Test
  void findBrand_returnsUniqueSafePrefixMatch() {
    when(apiClient.fetchBrands()).thenReturn(List.of(brand(10, "BOSCH"), brand(11, "MANN")));

    var resolved = service.findBrand("Bosch Aftermarket");

    assertThat(resolved).isPresent();
    assertThat(resolved.get().dlNr()).isEqualTo(10);
  }

  @Test
  void findBrand_returnsEmptyForAmbiguousPrefixMatches() {
    when(apiClient.fetchBrands())
        .thenReturn(List.of(brand(10, "BOSCH"), brand(11, "BOSCH PARTS")));

    var resolved = service.findBrand("BOSCHP");

    assertThat(resolved).isEmpty();
  }

  @Test
  void findBrand_doesNotMatchArbitrarySubstring() {
    when(apiClient.fetchBrands()).thenReturn(List.of(brand(10, "BOSCH"), brand(11, "MANN")));

    var resolved = service.findBrand("XXBOSCHYY");

    assertThat(resolved).isEmpty();
  }

  private GazelaBrand brand(int dlNr, String name) {
    return new GazelaBrand(null, dlNr, null, name);
  }
}

