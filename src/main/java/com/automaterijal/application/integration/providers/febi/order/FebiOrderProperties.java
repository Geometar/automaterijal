package com.automaterijal.application.integration.providers.febi.order;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "integration.febi.order")
public class FebiOrderProperties {

  public enum OrderMode {
    DISABLED,
    MOCK,
    LIVE
  }

  private OrderMode mode = OrderMode.MOCK;
  private String baseUrl =
      "https://bis1.prod.apimanagement.eu20.hana.ondemand.com/p/v1/order-api/api/v1";
  private String deliveryParty;
  private String shippingCondition;
  private Integer requestedDeliveryOffsetDays = 1;
  private boolean simulateBeforeCreate = false;
  private boolean requireAvailability = true;
  private String customerOrderPrefix = "WEB-";
}
