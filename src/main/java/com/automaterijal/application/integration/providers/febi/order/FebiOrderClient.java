package com.automaterijal.application.integration.providers.febi.order;

import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderResponse;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class FebiOrderClient {

  private final FebiOrderProperties orderProperties;
  private final RestTemplate restTemplate;

  public FebiOrderClient(FebiOrderProperties orderProperties, RestTemplateBuilder restTemplateBuilder) {
    this.orderProperties = orderProperties;
    this.restTemplate = restTemplateBuilder.build();
  }

  public FebiOrderResponse simulateOrder(FebiOrderRequest request, String accessToken) {
    return submitOrder("simulate", request, accessToken);
  }

  public FebiOrderResponse createOrder(FebiOrderRequest request, String accessToken) {
    return submitOrder("create", request, accessToken);
  }

  private FebiOrderResponse submitOrder(String action, FebiOrderRequest request, String accessToken) {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setBearerAuth(accessToken);
      headers.setContentType(MediaType.APPLICATION_JSON);

      HttpEntity<FebiOrderRequest> entity = new HttpEntity<>(request, headers);
      ResponseEntity<FebiOrderResponse> response =
          restTemplate.postForEntity(
              orderProperties.getBaseUrl() + "/order/" + action, entity, FebiOrderResponse.class);

      return response.getBody();
    } catch (HttpStatusCodeException ex) {
      if (ex.getStatusCode().value() == 429) {
        throw new ProviderRateLimitException("Febi order rate limited", ex);
      }
      if (ex.getStatusCode().value() == 401) {
        throw new ProviderAuthenticationException("Febi order token rejected", ex);
      }
      log.warn("Febi order call failed with {} {}", ex.getStatusCode(), ex.getResponseBodyAsString());
      throw new ProviderUnavailableException("Febi order endpoint error", ex);
    } catch (RuntimeException ex) {
      throw new ProviderUnavailableException("Unexpected Febi order call failure", ex);
    }
  }
}
