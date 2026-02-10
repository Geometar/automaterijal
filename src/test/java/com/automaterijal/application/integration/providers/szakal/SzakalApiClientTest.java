package com.automaterijal.application.integration.providers.szakal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class SzakalApiClientTest {

  @Mock private RestTemplateBuilder restTemplateBuilder;
  @Mock private RestTemplate restTemplate;

  private SzakalProperties properties;
  private SzakalApiClient client;

  @BeforeEach
  void setUp() {
    properties = new SzakalProperties();
    properties.getApi().setBaseUrl("https://example.test");
    properties.getApi().setUsername("user");
    properties.getApi().setPassword("pass");

    when(restTemplateBuilder.setConnectTimeout(any())).thenReturn(restTemplateBuilder);
    when(restTemplateBuilder.setReadTimeout(any())).thenReturn(restTemplateBuilder);
    when(restTemplateBuilder.build()).thenReturn(restTemplate);

    client = new SzakalApiClient(properties, restTemplateBuilder);
  }

  @Test
  void maps401ToAuthenticationException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(httpError(HttpStatus.UNAUTHORIZED, "unauthorized"));

    assertThatThrownBy(() -> client.stockByGlid(new SzakalApiClient.StockInfoRequest("2-1", 1, "fastest_first", false, false)))
        .isInstanceOf(ProviderAuthenticationException.class)
        .hasMessageContaining("authentication failed");
  }

  @Test
  void maps403ToAuthenticationException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(httpError(HttpStatus.FORBIDDEN, "forbidden"));

    assertThatThrownBy(() -> client.stockByToken(new SzakalApiClient.StockInfoTokenRequest("tok", 1, "fastest_first", false, false)))
        .isInstanceOf(ProviderAuthenticationException.class);
  }

  @Test
  void maps429ToRateLimitedException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(httpError(HttpStatus.TOO_MANY_REQUESTS, "rate"));

    assertThatThrownBy(() -> client.orderByToken(new SzakalApiClient.TokenOrderRequest("tok", 1, null)))
        .isInstanceOf(ProviderRateLimitException.class)
        .hasMessageContaining("rate limited");
  }

  @Test
  void maps404ToUnavailableWithBody() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(httpError(HttpStatus.NOT_FOUND, "token not found"));

    assertThatThrownBy(() -> client.orderByToken(new SzakalApiClient.TokenOrderRequest("tok", 1, null)))
        .isInstanceOf(ProviderUnavailableException.class)
        .hasMessageContaining("not found")
        .hasMessageContaining("token not found");
  }

  @Test
  void missingCredentialsThrowsAuthenticationBeforeCall() {
    properties.getApi().setUsername(null);
    client = new SzakalApiClient(properties, restTemplateBuilder);

    assertThatThrownBy(() -> client.stockByGlid(new SzakalApiClient.StockInfoRequest("2-1", 1, "fastest_first", false, false)))
        .isInstanceOf(ProviderAuthenticationException.class)
        .hasMessageContaining("credentials missing");
  }

  private HttpClientErrorException httpError(HttpStatus status, String body) {
    return HttpClientErrorException.create(status, status.getReasonPhrase(), null, body.getBytes(), null);
  }
}
