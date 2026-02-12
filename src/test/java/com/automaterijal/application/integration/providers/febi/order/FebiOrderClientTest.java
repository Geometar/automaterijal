package com.automaterijal.application.integration.providers.febi.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderResponse;
import com.automaterijal.application.integration.providers.febi.order.model.FebiShippingConditionDto;
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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class FebiOrderClientTest {

  @Mock private RestTemplateBuilder restTemplateBuilder;
  @Mock private RestTemplate restTemplate;

  private FebiOrderClient client;

  @BeforeEach
  void setUp() {
    FebiOrderProperties properties = new FebiOrderProperties();
    properties.setBaseUrl("https://febi-order.example");

    when(restTemplateBuilder.build()).thenReturn(restTemplate);
    client = new FebiOrderClient(properties, restTemplateBuilder);
  }

  @Test
  void maps401ToAuthenticationException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(httpClientError(HttpStatus.UNAUTHORIZED, "bad token"));

    assertThatThrownBy(() -> client.createOrder(minimalRequest(), "token"))
        .isInstanceOf(ProviderAuthenticationException.class)
        .hasMessageContaining("token rejected");
  }

  @Test
  void maps429ToRateLimitException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(httpClientError(HttpStatus.TOO_MANY_REQUESTS, "slow down"));

    assertThatThrownBy(() -> client.simulateOrder(minimalRequest(), "token"))
        .isInstanceOf(ProviderRateLimitException.class)
        .hasMessageContaining("rate limited");
  }

  @Test
  void maps5xxToUnavailableException() {
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenThrow(
            HttpServerErrorException.create(
                HttpStatus.BAD_GATEWAY, "bad gateway", null, null, null));

    assertThatThrownBy(() -> client.createBulkOrder(minimalRequest(), "token"))
        .isInstanceOf(ProviderUnavailableException.class)
        .hasMessageContaining("endpoint error");
  }

  @Test
  void returnsBodyOnCreateSuccess() {
    FebiOrderResponse response =
        FebiOrderResponse.builder()
            .customerOrder(
                FebiOrderResponse.CustomerOrder.builder()
                    .header(FebiOrderResponse.Header.builder().erpCustomerOrderNumber("FEBI-1").build())
                    .build())
            .build();
    when(restTemplate.postForEntity(anyString(), any(), any(Class.class)))
        .thenReturn(ResponseEntity.ok(response));

    FebiOrderResponse result = client.createOrder(minimalRequest(), "token");

    assertThat(result).isNotNull();
    assertThat(result.getCustomerOrder().getHeader().getErpCustomerOrderNumber()).isEqualTo("FEBI-1");
  }

  @Test
  void fetchShippingConditionsReturnsEmptyWhenBodyIsNull() {
    when(restTemplate.exchange(
            anyString(),
            any(HttpMethod.class),
            any(),
            any(ParameterizedTypeReference.class)))
        .thenReturn(ResponseEntity.ok(null));

    List<FebiShippingConditionDto> result = client.fetchShippingConditions("token");

    assertThat(result).isEmpty();
  }

  private static FebiOrderRequest minimalRequest() {
    return FebiOrderRequest.builder()
        .customerOrder(
            FebiOrderRequest.CustomerOrder.builder()
                .header(FebiOrderRequest.Header.builder().customerOrderNumber("TEST-1").type("create").build())
                .positions(List.of())
                .build())
        .build();
  }

  private static HttpClientErrorException httpClientError(HttpStatus status, String body) {
    return HttpClientErrorException.create(status, status.getReasonPhrase(), null, body.getBytes(), null);
  }
}
