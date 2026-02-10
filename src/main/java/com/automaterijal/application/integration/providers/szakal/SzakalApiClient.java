package com.automaterijal.application.integration.providers.szakal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class SzakalApiClient {
  private final SzakalProperties properties;
  private final RestTemplate restTemplate;

  public SzakalApiClient(SzakalProperties properties, RestTemplateBuilder restTemplateBuilder) {
    this.properties = properties;
    SzakalProperties.Api api = properties.getApi();
    Duration connect = Duration.ofMillis(api.getConnectTimeoutMs());
    Duration read = Duration.ofMillis(api.getReadTimeoutMs());
    this.restTemplate = restTemplateBuilder.setConnectTimeout(connect).setReadTimeout(read).build();
  }

  public StockInfoResponse stockByToken(StockInfoTokenRequest request) {
    return post("/stock_info_by_token", request, StockInfoResponse.class);
  }

  public StockInfoResponse stockByGlid(StockInfoRequest request) {
    return post("/stock_info", request, StockInfoResponse.class);
  }

  public OrderResponse orderByToken(TokenOrderRequest request) {
    return post("/order_by_token", request, OrderResponse.class);
  }

  private <T> T post(String path, Object body, Class<T> type) {
    SzakalProperties.Api api = properties.getApi();
    if (!StringUtils.hasText(api.getBaseUrl())) {
      throw new ProviderUnavailableException("Szakal API baseUrl not configured");
    }
    if (!StringUtils.hasText(api.getUsername()) || !StringUtils.hasText(api.getPassword())) {
      throw new ProviderAuthenticationException("Szakal API credentials missing");
    }
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setBasicAuth(api.getUsername(), api.getPassword());
      headers.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<Object> entity = new HttpEntity<>(body, headers);
      ResponseEntity<T> response =
          restTemplate.postForEntity(api.getBaseUrl() + path, entity, type);
      return response.getBody();
    } catch (HttpStatusCodeException ex) {
      int status = ex.getStatusCode().value();
      String responseBody = StringUtils.hasText(ex.getResponseBodyAsString()) ? ex.getResponseBodyAsString().trim() : null;
      if (status == 401 || status == 403) {
        throw new ProviderAuthenticationException("Szakal API authentication failed", ex);
      }
      if (status == 429) {
        throw new ProviderRateLimitException("Szakal API rate limited", ex);
      }
      if (status == 404) {
        String message = StringUtils.hasText(responseBody) ? "Szakal not found: " + responseBody : "Szakal not found";
        throw new ProviderUnavailableException(message, ex);
      }
      log.warn("Szakal API call {} failed with {} {}", path, ex.getStatusCode(), responseBody);
      String message = StringUtils.hasText(responseBody) ? "Szakal API error " + status + ": " + responseBody : "Szakal API error " + status;
      throw new ProviderUnavailableException(message, ex);
    } catch (RuntimeException ex) {
      throw new ProviderUnavailableException("Unexpected Szakal API failure", ex);
    }
  }

  public record TokenOrderRequest(
      @JsonProperty("stock_token") String stockToken,
      @JsonProperty("quantity") Integer quantity,
      @JsonProperty("order_note") String orderNote) {}

  public record OrderResponse(
      @JsonProperty("orders") List<OrderItem> orders) {}

  public record OrderItem(
      @JsonProperty("order_id") String orderId,
      @JsonProperty("quantity") Integer quantity,
      @JsonProperty("unit_price") BigDecimal unitPrice,
      @JsonProperty("no_returnable") Boolean noReturnable,
      @JsonProperty("core_charge") BigDecimal coreCharge,
      @JsonProperty("expected_delivery") String expectedDelivery,
      @JsonProperty("product") OrderProduct product) {}

  public record OrderProduct(
      @JsonProperty("glid") String glid,
      @JsonProperty("code") String code,
      @JsonProperty("maker") String maker,
      @JsonProperty("name") String name) {}

  public record StockInfoRequest(
      @JsonProperty("glid") String glid,
      @JsonProperty("quantity") Integer quantity,
      @JsonProperty("search_order") String searchOrder,
      @JsonProperty("forbid_no_returnable") Boolean forbidNoReturnable,
      @JsonProperty("forbid_products_with_core_charge") Boolean forbidProductsWithCoreCharge) {}

  public record StockInfoTokenRequest(
      @JsonProperty("stock_token") String stockToken,
      @JsonProperty("quantity") Integer quantity,
      @JsonProperty("search_order") String searchOrder,
      @JsonProperty("forbid_no_returnable") Boolean forbidNoReturnable,
      @JsonProperty("forbid_products_with_core_charge") Boolean forbidProductsWithCoreCharge) {}

  public record StockInfoResponse(
      @JsonProperty("stocks") List<StockInfoItem> stocks) {}

  public record StockInfoItem(
      @JsonProperty("stock_order_token") String stockOrderToken,
      @JsonProperty("quantity") Integer quantity,
      @JsonProperty("expected_delivery") String expectedDelivery,
      @JsonProperty("no_returnable") Boolean noReturnable,
      @JsonProperty("order_quantum") Integer orderQuantum,
      @JsonProperty("moq") Integer moq,
      @JsonProperty("unit_price") BigDecimal unitPrice,
      @JsonProperty("core_charge") BigDecimal coreCharge) {}
}
