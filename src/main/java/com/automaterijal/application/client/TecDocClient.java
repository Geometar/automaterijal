package com.automaterijal.application.client;

import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateResponse;
import com.automaterijal.application.tecdoc.ArticlesByIds6Record;
import com.automaterijal.application.tecdoc.ArticlesByIds6Response;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TecDocClient {

    private static final String URL = "https://webservice.tecalliance.services/pegasus-3-0/info/proxy/services/TecdocToCatDLB.jsonEndpoint";

    @Autowired()
    RestTemplate restTemplate;

    /**
     * Genericna tecDoc pretraga po trazenom broju
     */
    public List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocPretraga(String searchNumber, Integer brandId, Integer numbertype) {
        JSONObject request = new JSONObject();
        JSONObject body = kreirajStandardniObjekat();
        body.put("articleNumber", searchNumber);
        body.put("numberType", numbertype);

        if (brandId != null) {
            body.put("brandId", brandId);
        }

        request.put("getArticleDirectSearchAllNumbersWithState", body);

        ResponseEntity<ArticleDirectSearchAllNumbersWithStateResponse> responseEntity = vratiOdgovor(request, ArticleDirectSearchAllNumbersWithStateResponse.class);
        if (responseEntity != null) {
            return responseEntity.getBody().getData().getArray()
                    .stream()
                    .map(record -> {
                        record.setArticleNo(record.getArticleNo().replaceAll("\\s+", ""));
                        return record;
                    }).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Servis za vracanje detalja artikala, poput dokumenata, OE brojeva, atributa
     */
    public List<ArticlesByIds6Record> vratiDetaljeArtikla(Long robaId) {
        JSONObject request = new JSONObject();

        JSONObject body = kreirajStandardniObjekat();
        body.put("attributs", true);
        body.put("documents", true);
        body.put("oeNumbers", true);

        JSONObject articleIds = new JSONObject();

        JSONArray articleIdArray = new JSONArray();
        articleIdArray.put(robaId);
        articleIds.put("array", articleIdArray);

        body.put("articleId", articleIds);

        request.put("getDirectArticlesByIds6", body);

        ResponseEntity<ArticlesByIds6Response> responseEntity = vratiOdgovor(request, ArticlesByIds6Response.class);
        List<ArticlesByIds6Record> retVal = new ArrayList<>();
        if(responseEntity != null) {
            retVal = responseEntity.getBody().getData().getArray();
        }
        return retVal;
    }

    /**
     * Setovanje standardnjih parametara poziva
     */
    private JSONObject kreirajStandardniObjekat() {
        JSONObject standardniObjekat = new JSONObject();
        standardniObjekat.put("articleCountry", "rs");
        standardniObjekat.put("lang", "sr");
        standardniObjekat.put("provider", 23009);
        return standardniObjekat;
    }

    /**
     * Generecika metoda koja sluzi za REST poziv prema TECDOC-u
     */
    private ResponseEntity vratiOdgovor(JSONObject request, Class responseKlasa) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "2BeBXg6H4zCj4FxGFqKmmC3KRw6cswMmT4NP4WBu8ytLTTqzkwmw");
        log.info("JSON OBJECT {}", request.toString().trim());
        HttpEntity<String> entityReq1 = new HttpEntity<>(request.toString().trim(), headers);

        ResponseEntity response = null;
        try {
            response = restTemplate.exchange(
                    URL,
                    HttpMethod.POST,
                    entityReq1,
                    responseKlasa
            );
        } catch (Exception ex) {
            response = null;
        }
        return response;
    }

}
