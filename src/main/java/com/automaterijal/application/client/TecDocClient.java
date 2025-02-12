package com.automaterijal.application.client;

import com.automaterijal.application.tecdoc.*;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Service
public class TecDocClient {

  private static final String URL =
      "https://webservice.tecalliance.services/pegasus-3-0/info/proxy/services/TecdocToCatDLB.jsonEndpoint";
  private static final String API_KEY = "2BeBXg6H4zCj4FxGFqKmmC3KRw6cswMmT4NP4WBu8ytLTTqzkwmw";

  @Autowired WebClient webClient;

  /** Genericna tecDoc pretraga po trazenom broju */
  public List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocPretraga(
      String searchNumber, Integer brandId, Integer numbertype) {
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
                stateRecord.setArticleNo(stateRecord.getArticleNo().replaceAll("\\s+", "")))
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
  public List<Manufacturers2Record> getManufactures() {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("linkingTargetType", "PO");
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
  public List<VehicleIdsByCriteriaRecord> getVehiclesId(
      Integer manuId, Integer modelId, String type) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("carType", type);
    body.put("manuId", manuId);
    body.put("modId", modelId);
    body.put("countriesCarSelection", "rs");
    request.put("getVehicleIdsByCriteria", body);

    VehicleIdsByCriteriaResponse result = vratiOdgovor(request, VehicleIdsByCriteriaResponse.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getData() != null
                ? response.getData().getArray()
                : List.of());
  }

  /** Vracanje TecDoc vehicle detalja */
  public List<VehicleByIds4Record> getVehiclesByIds(List<Long> carIds) {
    JSONObject request = new JSONObject();
    JSONObject body = kreirajStandardniObjekat();
    body.put("carIds", carIds);
    body.put("countriesCarSelection", "rs");
    body.put("motorCodes", true);

    JSONObject arrayCarIds = new JSONObject();
    arrayCarIds.put("array", carIds);
    body.put("carIds", arrayCarIds);
    request.put("getVehicleByIds4", body);

    VehicleByIds4Response result = vratiOdgovor(request, VehicleByIds4Response.class);
    return extractListFromResponse(
        result,
        response ->
            response != null && response.getData() != null
                ? response.getData().getArray()
                : List.of());
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
    HttpHeaders headers = new HttpHeaders();
    headers.set("x-api-key", API_KEY);
    log.info("Request se salje {}", request.toString().trim());

    try {
      return webClient
          .post()
          .uri(URL)
          .header(HttpHeaders.CONTENT_TYPE, "application/json")
          .header(HttpHeaders.ACCEPT, "application/json")
          .headers(httpHeaders -> httpHeaders.addAll(headers))
          .bodyValue(request.toString().trim())
          .retrieve()
          .bodyToMono(responseKlasa)
          .block(); // Blocking for synchronous response, remove if using reactive
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

    return webClient
        .get()
        .uri(url)
        .header(
            HttpHeaders.ACCEPT,
            MediaType.APPLICATION_OCTET_STREAM_VALUE) // Expecting byte[] response
        .retrieve() // Fetches the response
        .bodyToMono(byte[].class) // Convert response to byte[]
        .block(); // Block for the response (useful in non-reactive environments)
  }
}
