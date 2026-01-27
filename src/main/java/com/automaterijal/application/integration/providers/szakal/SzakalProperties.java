package com.automaterijal.application.integration.providers.szakal;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "integration.szakal")
public class SzakalProperties {
  private boolean enabled = false;
  private String dataDir;
  private String currency = "RSD";
  private Integer leadTimeList0 = 1;
  private Integer leadTimeList1 = 2;
  private Integer leadTimeList2 = 3;
  private Integer leadTimeList3 = 5;
  private Integer deliveryToCustomerBusinessDaysMin;
  private Integer deliveryToCustomerBusinessDaysMax;
  private String warehouseName = "SZAKAL";
}
