package com.automaterijal.application.client;

import com.automaterijal.application.tecdoc.*;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TecDocClient {

  @Value("${offline}")
  private boolean offline = false;

  private static final String URL =
      "https://webservice.tecalliance.services/pegasus-3-0/info/proxy/services/TecdocToCatDLB.jsonEndpoint";
  private static final String API_KEY = "2BeBXg6H4zCj4FxGFqKmmC3KRw6cswMmT4NP4WBu8ytLTTqzkwmw";

  @Autowired WebClient webClient;

  /** Genericna tecDoc pretraga po trazenom broju */
  public List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocPretraga(
      String searchNumber, Long brandId, Integer numbertype) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("articleNumber", searchNumber);
    body.put("numberType", numbertype);

    if (brandId != null) {
      body.put("brandId", brandId);
    }

    if (numbertype == 0) {
      body.put("searchExact", true);
    }

    request.put("getArticleDirectSearchAllNumbersWithState", body);

    ArticleDirectSearchAllNumbersWithStateResponse result =
        vratiOdgovor(request, ArticleDirectSearchAllNumbersWithStateResponse.class);
    List<ArticleDirectSearchAllNumbersWithStateRecord> data =
        extractListFromResponse(
            result,
            response ->
                response != null && response.getData() != null
                    ? response.getData().getArray()
                    : List.of());
    return data.stream()
        .peek(
            stateRecord ->
                stateRecord.setArticleNo(
                    CatalogNumberUtils.cleanPreserveSeparators(stateRecord.getArticleNo())))
        .toList();
  }

  /** Servis za vracanje detalja artikala, poput dokumenata, OE brojeva, atributa */
  public List<ArticlesByIds6Record> vratiDetaljeArtikla(List<Long> robaIds) {
    JSONObject request = new JSONObject();

    JSONObject body = kreirajStandardniObjekat();
    body.put("attributs", true);
    body.put("documents", true);
    body.put("oeNumbers", true);
    body.put("mainArticles", true);
    body.put("basicData", true);
    body.put("thumbnails", true);
    body.put("usageNumbers", true);

    JSONObject articleIds = new JSONObject();
    articleIds.put("array", robaIds);

    body.put("articleId", articleIds);

    request.put("getDirectArticlesByIds6", body);

    ArticlesByIds6Response result = vratiOdgovor(request, ArticlesByIds6Response.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getData() != null
                ? response.getData().getArray()
                : List.of());
  }

  /** Vracanje TecDoc brendova i njihovih slika */
  public List<AmBrandsRecord> vrateTecDocAmBrands() {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    request.put("getAmBrands", body);

    AmBrandsResponse result = vratiOdgovor(request, AmBrandsResponse.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getData() != null
                ? response.getData().getArray()
                : List.of());
  }

  /** Vracanje TecDoc proizvodjaca vozila */
  public List<Manufacturers2Record> getManufactures(String type) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("linkingTargetType", type);
    request.put("getManufacturers2", body);

    Manufacturers2Response result = vratiOdgovor(request, Manufacturers2Response.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getData() != null
                ? response.getData().getArray()
                : List.of());
  }

  /** Vracanje TecDoc modele proizvodjaca */
  public List<ModelSeries2Record> getModels(Integer manuId, String type) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("linkingTargetType", type);
    body.put("manuId", manuId);
    request.put("getModelSeries2", body);

    ModelSeries2Response result = vratiOdgovor(request, ModelSeries2Response.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getData() != null
                ? response.getData().getArray()
                : List.of());
  }

  /** Vracanje TecDoc vehicle identifikatore */
  public List<LinkageTargetDetails> getVehicleSubModels(
      Integer manuId, Integer modelId, String type) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();

    // Glavna polja
    body.put("linkageTargetCountry", "RS");
    body.put("linkageTargetCountryGroupFlag", false);
    body.put("linkageTargetType", type);
    body.put("mfrIds", manuId);
    body.put("vehicleModelSeriesIds", modelId);
    body.put("perPage", 100);

    // Sortiranje
    JSONArray sort = new JSONArray();
    sort.put(new JSONObject().put("field", "mfrName").put("direction", "asc"));
    sort.put(new JSONObject().put("field", "description").put("direction", "asc"));
    body.put("sort", sort);

    // Završno pakovanje
    request.put("getLinkageTargets", body);

    // Poziv i rezultat
    LinkageTargetsResponse result = vratiOdgovor(request, LinkageTargetsResponse.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getLinkageTargets() != null
                ? response.getLinkageTargets()
                : List.of());
  }

  /** Vracanje TecDoc vehicle detalja */
  public List<LinkageTargetDetails> getLinkageTargets(Integer id, String type) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("linkageTargetCountry", "RS");

    JSONObject linkageTargetIds = new JSONObject();
    linkageTargetIds.put("type", type);
    linkageTargetIds.put("id", id);

    body.put("linkageTargetIds", linkageTargetIds);

    request.put("getLinkageTargets", body);

    LinkageTargetsResponse result = vratiOdgovor(request, LinkageTargetsResponse.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getLinkageTargets() != null
                ? response.getLinkageTargets()
                : List.of());
  }

  /** Vracanje TecDoc vehicle identifikatore */
  public List<AssemblyGroupFacetCount> getAssemblyGroupsForVehicle(
      String type, Integer linkageTargetId) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("articleCountry", "RS");
    body.put("linkageTargetId", linkageTargetId);
    body.put("linkageTargetType", type);

    JSONObject enabled = new JSONObject();
    enabled.put("enabled", true);

    body.put("assemblyGroupFacetOptions", enabled);
    request.put("getArticles", body);

    ArticlesResponse result = vratiOdgovor(request, ArticlesResponse.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getAssemblyGroupFacets() != null
                ? response.getAssemblyGroupFacets().getCounts()
                : List.of());
  }

  /** Vracanje TecDoc artikala vezano za vozilo */
  public ArticlesResponse getAssociatedArticles(
      Integer linkageTargetId, String type, String assembleGroupId) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("articleCountry", "RS");
    body.put("linkageTargetId", linkageTargetId);
    body.put("linkageTargetType", type);
    body.put("includeGenericArticles", true);
    body.put("includeTradeNumbers", true);
    body.put("includeArticleCriteria", true);
    body.put("includeLinkages", true);
    body.put("includeImages", true);
    body.put("includeGenericArticleFacets", true);
    body.put("includeOEMNumbers", true);
    body.put("perPage", 1000);
    body.put("assemblyGroupNodeIds", List.of(assembleGroupId));
    request.put("getArticles", body);
    return vratiOdgovor(request, ArticlesResponse.class);
  }

  /** Vracanje generickih artikala vezano za vozilo */
  public List<GenericArticlesRecord> getGenericArticles(String type, Integer linkageTargetId) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("articleCountry", "RS");
    body.put("linkingTargetId", linkageTargetId);
    body.put("linkingTargetType", type);
    body.put("searchTreeNodes", true);
    body.put("linked", true);
    request.put("getGenericArticles", body);

    GenericArticlesResponse result = vratiOdgovor(request, GenericArticlesResponse.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getData() != null
                ? response.getData().getArray()
                : List.of());
  }

  /** Vraca povezane proizvodjace za zadati TecDoc artikal */
  public ArticleLinkedAllLinkingTargetManufacturer2Response
      getArticleLinkedAllLinkingTargetManufacturer2(Long articleId, String linkingTargetType) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("linkingTargetType", linkingTargetType);
    body.put("countryGroupFlag", false);
    body.put("articleId", articleId);
    request.put("getArticleLinkedAllLinkingTargetManufacturer2", body);

    return vratiOdgovor(request, ArticleLinkedAllLinkingTargetManufacturer2Response.class);
  }

  /** Setovanje standardnjih parametara poziva */
  private JSONObject kreirajStandardniObjekat() {
    JSONObject standardniObjekat = new JSONObject();
    standardniObjekat.put("articleCountry", "rs");
    standardniObjekat.put("country", "rs");
    standardniObjekat.put("lang", "sr");
    standardniObjekat.put("provider", 23009);
    return standardniObjekat;
  }

  private <T, R> List<T> extractListFromResponse(
      R response, java.util.function.Function<R, List<T>> extractor) {
    if (response != null) {
      return extractor.apply(response);
    }
    return Collections.emptyList();
  }

  /** Generecika metoda koja sluzi za REST poziv prema TECDOC-u */
  private <T> T vratiOdgovor(JSONObject request, Class<T> responseKlasa) {

    if (offline) {
      try {
        return responseKlasa.newInstance();
      } catch (InstantiationException e) {
        throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }

    HttpHeaders headers = new HttpHeaders();
    headers.set("x-api-key", API_KEY);

    try {
      T body =
          webClient
              .post()
              .uri(URL)
              .header(HttpHeaders.CONTENT_TYPE, "application/json")
              .header(HttpHeaders.ACCEPT, "application/json")
              .headers(httpHeaders -> httpHeaders.addAll(headers))
              .bodyValue(request.toString().trim())
              .retrieve()
              .bodyToMono(responseKlasa)
              .block(); // Blocking for synchronous response, remove if using reactive
      return body;
    } catch (WebClientResponseException e) {
      log.error("Error during REST call: {}, Status code: {}", e.getMessage(), e.getStatusCode());
      return null;
    } catch (Exception ex) {
      log.error("Unexpected error during REST call: {}", ex.getMessage());
      return null;
    }
  }

  /** Vrati dokument od tec doc servisa */
  public byte[] vratiDokument(String dokumentId, Integer tipSlike) {
    String url =
        String.format(
            "https://webservice.tecalliance.services/pegasus-3-0/documents/23009/%s/%d?api_key=%s",
            dokumentId, tipSlike, API_KEY);

    try {
      return webClient
          .get()
          .uri(url)
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_OCTET_STREAM_VALUE)
          .retrieve()
          .onStatus(
              HttpStatusCode::is4xxClientError,
              response -> {
                // Ako je 404, vratimo Mono.empty (bez greške); drugim 4xx možemo tretirati kao
                // grešku
                return response.statusCode().value() == 404
                    ? Mono.empty()
                    : response.createException();
              })
          .bodyToMono(byte[].class)
          .onErrorResume(
              WebClientResponseException.class,
              ex -> {
                // Ako je WebClient greška (npr. 404 koji nije pokriven gore), vratimo null
                if (ex.getRawStatusCode() == 404) {
                  return Mono.just(
                      new byte[0]); // ili Mono.empty() u zavisnosti šta želiš kao fallback
                }
                return Mono.error(ex);
              })
          .block();
    } catch (Exception ex) {
      log.error("Unexpected error during document REST call: {}", ex.getMessage(), ex);
      return null;
    }
  }
}
