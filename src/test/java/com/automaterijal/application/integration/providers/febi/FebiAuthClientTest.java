package com.automaterijal.application.integration.providers.febi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.providers.febi.model.FebiTokenResponse;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class FebiAuthClientTest {

  @Mock private RestTemplateBuilder restTemplateBuilder;
  @Mock private RestTemplate restTemplate;

  private FebiProperties properties;
  private FebiAuthClient client;

  @BeforeEach
  void setUp() {
    properties = new FebiProperties();
    properties.setEnabled(true);
    properties.setTokenSkew(Duration.ZERO);
    properties.setClientId("client");
    properties.setClientSecret("secret");
    properties.setTokenUrl("https://febi.example/token");

    when(restTemplateBuilder.setConnectTimeout(any())).thenReturn(restTemplateBuilder);
    when(restTemplateBuilder.setReadTimeout(any())).thenReturn(restTemplateBuilder);
    when(restTemplateBuilder.build()).thenReturn(restTemplate);

    client = new FebiAuthClient(properties, restTemplateBuilder);
  }

  @Test
  void disabledProviderThrowsUnavailable() {
    properties.setEnabled(false);

    assertThatThrownBy(() -> client.getAccessToken())
        .isInstanceOf(ProviderUnavailableException.class)
        .hasMessageContaining("disabled");
  }

  @Test
  void missingCredentialsThrowsAuthenticationException() {
    properties.setClientSecret(null);

    assertThatThrownBy(() -> client.getAccessToken())
        .isInstanceOf(ProviderAuthenticationException.class)
        .hasMessageContaining("not configured");
  }

  @Test
  void cachesTokenUntilExpiry() {
    FebiTokenResponse tokenResponse = FebiTokenResponse.builder().accessToken("abc").expiresIn(3600L).build();
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenReturn(ResponseEntity.ok(tokenResponse));

    String first = client.getAccessToken();
    String second = client.getAccessToken();

    assertThat(first).isEqualTo("abc");
    assertThat(second).isEqualTo("abc");
    verify(restTemplate, times(1)).postForEntity(anyString(), any(), any(Class.class));
  }

  @Test
  void authHttpErrorMapsToAuthenticationException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(HttpClientErrorException.create(org.springframework.http.HttpStatus.UNAUTHORIZED, "Unauthorized", null, null, null));

    assertThatThrownBy(() -> client.getAccessToken())
        .isInstanceOf(ProviderAuthenticationException.class)
        .hasMessageContaining("Could not fetch Febi token");
  }
}
