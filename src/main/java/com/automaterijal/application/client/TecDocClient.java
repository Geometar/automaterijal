package com.automaterijal.application.client;

import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TecDocClient {

    private static final String URL = "https://webservice.tecalliance.services/pegasus-3-0/info/proxy/services/TecdocToCatDLB.jsonEndpoint";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

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
        return responseEntity.getBody().getData().getArray()
                .stream()
                .map(record -> {
                    record.setArticleNo(record.getArticleNo().replaceAll("\\s+", ""));
                    return record;
                }).collect(Collectors.toList());
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

        HttpEntity<Object> entityReq1 = new HttpEntity<>(request.toString(), headers);

        return REST_TEMPLATE.exchange(
                URL,
                HttpMethod.POST,
                entityReq1,
                responseKlasa
        );
    }

}
