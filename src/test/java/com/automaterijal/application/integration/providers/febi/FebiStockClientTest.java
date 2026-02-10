package com.automaterijal.application.integration.providers.febi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.providers.febi.model.FebiStockRequest;
import com.automaterijal.application.integration.providers.febi.model.FebiStockResponse;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class FebiStockClientTest {

  @Mock private RestTemplateBuilder restTemplateBuilder;
  @Mock private RestTemplate restTemplate;

  private FebiStockClient client;

  @BeforeEach
  void setUp() {
    FebiProperties properties = new FebiProperties();
    properties.setBaseUrl("https://febi.example");

    when(restTemplateBuilder.setConnectTimeout(any())).thenReturn(restTemplateBuilder);
    when(restTemplateBuilder.setReadTimeout(any())).thenReturn(restTemplateBuilder);
    when(restTemplateBuilder.build()).thenReturn(restTemplate);

    client = new FebiStockClient(properties, restTemplateBuilder);
  }

  @Test
  void maps429ToRateLimitException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(httpClientError(HttpStatus.TOO_MANY_REQUESTS, "slow down"));

    assertThatThrownBy(() -> client.fetchStock(request(), "token"))
        .isInstanceOf(ProviderRateLimitException.class)
        .hasMessageContaining("rate limited");
  }

  @Test
  void maps401ToAuthenticationException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(httpClientError(HttpStatus.UNAUTHORIZED, "bad token"));

    assertThatThrownBy(() -> client.fetchStock(request(), "token"))
        .isInstanceOf(ProviderAuthenticationException.class)
        .hasMessageContaining("token rejected");
  }

  @Test
  void mapsUnexpectedHttpStatusToUnavailable() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(
            HttpServerErrorException.create(HttpStatus.BAD_GATEWAY, "bad gateway", null, null, null));

    assertThatThrownBy(() -> client.fetchStock(request(), "token"))
        .isInstanceOf(ProviderUnavailableException.class)
        .hasMessageContaining("endpoint error");
  }

  @Test
  void returnsBodyOnSuccess() {
    FebiStockResponse response =
        FebiStockResponse.builder().destinationCountry("RS").numberOfItems(1).build();
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenReturn(ResponseEntity.ok(response));

    FebiStockResponse result = client.fetchStock(request(), "token");

    assertThat(result).isNotNull();
    assertThat(result.getDestinationCountry()).isEqualTo("RS");
    assertThat(result.getNumberOfItems()).isEqualTo(1);
  }

  private static FebiStockRequest request() {
    return FebiStockRequest.builder()
        .destinationCountry("RS")
        .items(List.of("A1"))
        .bypassArticleErrors(true)
        .build();
  }

  private static HttpClientErrorException httpClientError(HttpStatus status, String body) {
    return HttpClientErrorException.create(
        status, status.getReasonPhrase(), null, body.getBytes(), null);
  }
}
