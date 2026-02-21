package com.automaterijal.application.integration.providers.gazela;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.time.Duration;
import java.util.ArrayList;
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
public class GazelaApiClient {

  private final GazelaProperties properties;
  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  public GazelaApiClient(
      GazelaProperties properties,
      RestTemplateBuilder restTemplateBuilder,
      ObjectMapper objectMapper) {
    this.properties = properties;
    this.objectMapper = objectMapper;

    GazelaProperties.Api api = properties.getApi();
    Duration connect = Duration.ofMillis(valueOrDefault(api.getConnectTimeoutMs(), 10000));
    Duration read = Duration.ofMillis(valueOrDefault(api.getReadTimeoutMs(), 10000));
    this.restTemplate = restTemplateBuilder.setConnectTimeout(connect).setReadTimeout(read).build();
  }

  public List<GazelaBrand> fetchBrands() {
    JsonNode root = get("/Brands");
    return convertArray(root, GazelaBrand.class);
  }

  public List<GazelaBranch> fetchBranches() {
    JsonNode root = get("/Poslovnice");
    return convertArray(root, GazelaBranch.class);
  }

  public GazelaAvailabilityResponse fetchAvailability(
      List<GazelaAvailabilityArticleRequest> articles) {
    if (articles == null || articles.isEmpty()) {
      return new GazelaAvailabilityResponse(null, List.of(), null);
    }

    GazelaAvailabilityRequest request =
        new GazelaAvailabilityRequest(resolveUser(), articles, null);
    JsonNode root = post("/GetRaspolozivost", request);
    try {
      GazelaAvailabilityResponse response =
          objectMapper.convertValue(root, GazelaAvailabilityResponse.class);
      return response != null ? response : new GazelaAvailabilityResponse(null, List.of(), null);
    } catch (IllegalArgumentException ex) {
      throw new ProviderUnavailableException("Invalid Gazela availability response", ex);
    }
  }

  private JsonNode get(String path) {
    String url = buildUrl(path);
    try {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);
      return response.getBody();
    } catch (HttpStatusCodeException ex) {
      throw mapException("GET", path, ex);
    } catch (RuntimeException ex) {
      throw new ProviderUnavailableException("Unexpected Gazela API failure", ex);
    }
  }

  private JsonNode post(String path, Object body) {
    String url = buildUrl(path);
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<Object> entity = new HttpEntity<>(body, headers);
      ResponseEntity<JsonNode> response = restTemplate.postForEntity(url, entity, JsonNode.class);
      return response.getBody();
    } catch (HttpStatusCodeException ex) {
      throw mapException("POST", path, ex);
    } catch (RuntimeException ex) {
      throw new ProviderUnavailableException("Unexpected Gazela API failure", ex);
    }
  }

  private RuntimeException mapException(String method, String path, HttpStatusCodeException ex) {
    int status = ex.getStatusCode().value();
    String responseBody =
        StringUtils.hasText(ex.getResponseBodyAsString()) ? ex.getResponseBodyAsString().trim() : null;

    if (status == 401 || status == 403) {
      return new ProviderAuthenticationException("Gazela API authentication failed", ex);
    }
    if (status == 429) {
      return new ProviderRateLimitException("Gazela API rate limited", ex);
    }

    log.warn("Gazela API {} {} failed with {} {}", method, path, ex.getStatusCode(), responseBody);
    String message =
        StringUtils.hasText(responseBody)
            ? "Gazela API error " + status + ": " + responseBody
            : "Gazela API error " + status;
    return new ProviderUnavailableException(message, ex);
  }

  private GazelaUser resolveUser() {
    GazelaProperties.Api api = properties.getApi();
    if (api == null || api.getUserId() == null || !StringUtils.hasText(api.getPassword())) {
      throw new ProviderAuthenticationException("Gazela API credentials missing");
    }
    return new GazelaUser(api.getUserId(), api.getPassword().trim());
  }

  private String buildUrl(String path) {
    GazelaProperties.Api api = properties.getApi();
    String baseUrl = api != null ? api.getBaseUrl() : null;
    if (!StringUtils.hasText(baseUrl)) {
      throw new ProviderUnavailableException("Gazela API baseUrl not configured");
    }

    String normalizedBase = baseUrl.trim();
    if (normalizedBase.endsWith("/")) {
      normalizedBase = normalizedBase.substring(0, normalizedBase.length() - 1);
    }

    if (!StringUtils.hasText(path)) {
      return normalizedBase;
    }
    if (path.startsWith("/")) {
      return normalizedBase + path;
    }
    return normalizedBase + "/" + path;
  }

  private <T> List<T> convertArray(JsonNode root, Class<T> type) {
    if (root == null || root.isNull()) {
      return List.of();
    }

    JsonNode arrayNode = root;
    if (!arrayNode.isArray() && arrayNode.isObject()) {
      arrayNode = firstArrayField(arrayNode);
    }
    if (arrayNode == null || !arrayNode.isArray()) {
      return List.of();
    }

    List<T> result = new ArrayList<>();
    for (JsonNode item : arrayNode) {
      try {
        T mapped = objectMapper.convertValue(item, type);
        if (mapped != null) {
          result.add(mapped);
        }
      } catch (IllegalArgumentException ex) {
        log.debug("Skipping invalid Gazela response item: {}", ex.getMessage());
      }
    }
    return result;
  }

  private JsonNode firstArrayField(JsonNode node) {
    if (node == null || !node.isObject()) {
      return null;
    }
    for (var fields = node.fields(); fields.hasNext(); ) {
      var entry = fields.next();
      if (entry.getValue() != null && entry.getValue().isArray()) {
        return entry.getValue();
      }
    }
    return null;
  }

  private int valueOrDefault(Integer value, int fallback) {
    return value != null && value > 0 ? value : fallback;
  }

  public record GazelaUser(@JsonProperty("id") Integer id, @JsonProperty("lozinka") String lozinka) {}

  public record GazelaAvailabilityRequest(
      @JsonProperty("korisnik") GazelaUser korisnik,
      @JsonProperty("artikli") List<GazelaAvailabilityArticleRequest> artikli,
      @JsonProperty("errMsg") String errMsg) {}

  public record GazelaAvailabilityArticleRequest(
      @JsonProperty("katBr") String katBr,
      @JsonProperty("artNr") String artNr,
      @JsonProperty("dlNr") Integer dlNr) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record GazelaAvailabilityResponse(
      @JsonProperty("korisnik") GazelaUser korisnik,
      @JsonProperty("artikli") List<GazelaAvailabilityArticle> artikli,
      @JsonProperty("errMsg") String errMsg) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record GazelaAvailabilityArticle(
      @JsonProperty("katBr") String katBr,
      @JsonProperty("artNr") String artNr,
      @JsonProperty("dlNr") Integer dlNr,
      @JsonProperty("vpCena") java.math.BigDecimal vpCena,
      @JsonProperty("magacini") List<GazelaWarehouseStock> magacini,
      @JsonProperty("errMsg") String errMsg) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record GazelaWarehouseStock(
      @JsonProperty("id") Integer id,
      @JsonProperty("ime") String ime,
      @JsonProperty("stanje") String stanje,
      @JsonProperty("napomena") String napomena) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record GazelaBrand(
      @JsonProperty("DlNr") Integer dlNrUpper,
      @JsonProperty("dlNr") Integer dlNrLower,
      @JsonProperty("Ime") String imeUpper,
      @JsonProperty("ime") String imeLower) {

    public Integer dlNr() {
      return dlNrLower != null ? dlNrLower : dlNrUpper;
    }

    public String ime() {
      return StringUtils.hasText(imeLower) ? imeLower : imeUpper;
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record GazelaBranch(
      @JsonProperty("ID") Integer idUpper,
      @JsonProperty("id") Integer idLower,
      @JsonProperty("Ime") String imeUpper,
      @JsonProperty("ime") String imeLower,
      @JsonProperty("Adresa") String adresaUpper,
      @JsonProperty("adresa") String adresaLower,
      @JsonProperty("Email") String emailUpper,
      @JsonProperty("email") String emailLower) {

    public Integer id() {
      return idLower != null ? idLower : idUpper;
    }

    public String ime() {
      return StringUtils.hasText(imeLower) ? imeLower : imeUpper;
    }

    public String adresa() {
      return StringUtils.hasText(adresaLower) ? adresaLower : adresaUpper;
    }

    public String email() {
      return StringUtils.hasText(emailLower) ? emailLower : emailUpper;
    }
  }
}
