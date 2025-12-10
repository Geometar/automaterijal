package com.automaterijal.application.integration.providers.febi;

import com.automaterijal.application.integration.providers.febi.model.FebiTokenResponse;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class FebiAuthClient {

  private final FebiProperties properties;
  private final RestTemplate restTemplate;

  private volatile String cachedToken;
  private volatile Instant expiresAt = Instant.EPOCH;

  public FebiAuthClient(FebiProperties properties, RestTemplateBuilder restTemplateBuilder) {
    this.properties = properties;
    this.restTemplate =
        restTemplateBuilder
            .setConnectTimeout(properties.getConnectTimeout())
            .setReadTimeout(properties.getReadTimeout())
            .build();
  }

  public synchronized String getAccessToken() {
    if (!properties.isEnabled()) {
      throw new ProviderUnavailableException("Febi provider is disabled via configuration");
    }

    Duration skew = Objects.requireNonNullElse(properties.getTokenSkew(), Duration.ofSeconds(60L));

    if (cachedToken != null && Instant.now().isBefore(expiresAt.minus(skew))) {
      return cachedToken;
    }

    return fetchToken();
  }

  public synchronized String refreshTokenNow() {
    cachedToken = null;
    expiresAt = Instant.EPOCH;
    return fetchToken();
  }

  private String fetchToken() {
    if (!hasCredentials()) {
      throw new ProviderAuthenticationException("Febi client-id or client-secret not configured");
    }

    try {
      FebiTokenResponse response = requestToken();
      cachedToken = response.getAccessToken();
      long ttlSeconds = response.getExpiresIn() != null ? response.getExpiresIn() : 3600L;
      expiresAt = Instant.now().plusSeconds(ttlSeconds);
      return cachedToken;
    } catch (HttpStatusCodeException ex) {
      log.warn("Febi token request failed with status {}: {}", ex.getStatusCode(), ex.getMessage());
      throw new ProviderAuthenticationException("Could not fetch Febi token", ex);
    } catch (RuntimeException ex) {
      throw new ProviderUnavailableException("Unexpected error during Febi token fetch", ex);
    }
  }

  private FebiTokenResponse requestToken() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
    body.add("grant_type", "client_credentials");
    body.add("client_id", properties.getClientId());
    body.add("client_secret", properties.getClientSecret());

    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

    ResponseEntity<FebiTokenResponse> response =
        restTemplate.postForEntity(properties.getTokenUrl(), request, FebiTokenResponse.class);

    if (response.getBody() == null || response.getBody().getAccessToken() == null) {
      throw new ProviderAuthenticationException("Febi token response missing access_token");
    }

    return response.getBody();
  }

  private boolean hasCredentials() {
    return properties.getClientId() != null && properties.getClientSecret() != null;
  }
}
