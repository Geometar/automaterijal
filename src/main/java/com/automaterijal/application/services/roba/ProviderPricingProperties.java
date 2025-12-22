package com.automaterijal.application.services.roba;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pricing")
public class ProviderPricingProperties {

  private Margin margin = new Margin();

  @Data
  public static class Margin {
    private BigDecimal defaultPercent = new BigDecimal("0.65");
    private Map<String, BigDecimal> byGroup = new HashMap<>();
  }
}
