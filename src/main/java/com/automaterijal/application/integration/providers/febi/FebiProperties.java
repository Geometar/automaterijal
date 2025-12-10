package com.automaterijal.application.integration.providers.febi;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "integration.febi")
public class FebiProperties {

  private boolean enabled = false;
  private String baseUrl =
      "https://bis1.prod.apimanagement.eu20.hana.ondemand.com/p/v2/stock-api/api/v2";
  private String tokenUrl =
      "https://sso.uhura.bilsteingroup.com/auth/realms/uhura/protocol/openid-connect/token";
  private String clientId;
  private String clientSecret;
  private String defaultDestinationCountry = "RS";
  private List<String> supportedBrands = new ArrayList<>(List.of("FEBI"));
  private Duration connectTimeout = Duration.ofSeconds(5);
  private Duration readTimeout = Duration.ofSeconds(10);
  private Duration tokenSkew = Duration.ofSeconds(60);
  private String priceListPath;
  private boolean bypassArticleErrors = true;
  private Integer leadTimeBusinessDays = 1;
  private Integer deliveryToCustomerBusinessDaysMin = 1;
  private Integer deliveryToCustomerBusinessDaysMax = 2;
  private String dispatchCutoff = "16:00";
}
