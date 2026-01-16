package com.automaterijal.application.integration.providers.febi;

import com.automaterijal.application.integration.providers.febi.model.FebiStockRequest;
import com.automaterijal.application.integration.providers.febi.model.FebiStockResponse;
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
public class FebiStockClient {

  private final FebiProperties properties;
  private final RestTemplate restTemplate;

  public FebiStockClient(FebiProperties properties, RestTemplateBuilder restTemplateBuilder) {
    this.properties = properties;
    this.restTemplate =
        restTemplateBuilder
            .setConnectTimeout(properties.getConnectTimeout())
            .setReadTimeout(properties.getReadTimeout())
            .build();
  }

  public FebiStockResponse fetchStock(FebiStockRequest request, String accessToken) {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setBearerAuth(accessToken);
      headers.setContentType(MediaType.APPLICATION_JSON);

      HttpEntity<FebiStockRequest> entity = new HttpEntity<>(request, headers);
      ResponseEntity<FebiStockResponse> response =
          restTemplate.postForEntity(properties.getBaseUrl() + "/stock", entity, FebiStockResponse.class);

      return response.getBody();
    } catch (HttpStatusCodeException ex) {
      if (ex.getStatusCode().value() == 429) {
        throw new ProviderRateLimitException("Febi rate limited", ex);
      }
      if (ex.getStatusCode().value() == 401) {
        throw new ProviderAuthenticationException("Febi token rejected", ex);
      }
      log.warn("Febi stock call failed with {} {}", ex.getStatusCode(), ex.getResponseBodyAsString());
      throw new ProviderUnavailableException("Febi stock endpoint error", ex);
    } catch (RuntimeException ex) {
      throw new ProviderUnavailableException("Unexpected Febi stock call failure", ex);
    }
  }
}
