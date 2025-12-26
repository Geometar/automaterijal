package com.automaterijal.application.integration.providers.febi.order;

import com.automaterijal.application.integration.providers.febi.order.model.FebiAddressDto;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderBulkResponse;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderResponse;
import com.automaterijal.application.integration.providers.febi.order.model.FebiShippingConditionDto;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.core.ParameterizedTypeReference;
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
    return submitOrder("simulate", request, accessToken, FebiOrderResponse.class);
  }

  public FebiOrderResponse createOrder(FebiOrderRequest request, String accessToken) {
    return submitOrder("create", request, accessToken, FebiOrderResponse.class);
  }

  public FebiOrderBulkResponse createBulkOrder(FebiOrderRequest request, String accessToken) {
    return submitOrder("create/bulk", request, accessToken, FebiOrderBulkResponse.class);
  }

  public List<FebiAddressDto> fetchShipToAddresses(String accessToken) {
    return fetchList(
        "/ship-to/addresses",
        accessToken,
        new ParameterizedTypeReference<List<FebiAddressDto>>() {});
  }

  public List<FebiAddressDto> fetchSoldToAddresses(String accessToken) {
    return fetchList(
        "/sold-to/addresses",
        accessToken,
        new ParameterizedTypeReference<List<FebiAddressDto>>() {});
  }

  public List<FebiShippingConditionDto> fetchShippingConditions(String accessToken) {
    return fetchList(
        "/shipping/conditions",
        accessToken,
        new ParameterizedTypeReference<List<FebiShippingConditionDto>>() {});
  }

  private <T> T submitOrder(
      String action, FebiOrderRequest request, String accessToken, Class<T> responseType) {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setBearerAuth(accessToken);
      headers.setContentType(MediaType.APPLICATION_JSON);

      HttpEntity<FebiOrderRequest> entity = new HttpEntity<>(request, headers);
      ResponseEntity<T> response =
          restTemplate.postForEntity(
              orderProperties.getBaseUrl() + "/order/" + action, entity, responseType);

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

  private <T> List<T> fetchList(
      String path, String accessToken, ParameterizedTypeReference<List<T>> responseType) {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setBearerAuth(accessToken);
      headers.setContentType(MediaType.APPLICATION_JSON);

      HttpEntity<Void> entity = new HttpEntity<>(headers);
      ResponseEntity<List<T>> response =
          restTemplate.exchange(
              orderProperties.getBaseUrl() + path, HttpMethod.GET, entity, responseType);

      List<T> body = response.getBody();
      return body != null ? body : List.of();
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
