package com.automaterijal.application.integration.providers.febi.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FebiOrderRequest {

  @JsonProperty("customer_order")
  CustomerOrder customerOrder;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class CustomerOrder {
    Header header;
    List<Position> positions;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Header {
    @JsonProperty("customer_order_number")
    String customerOrderNumber;

    @JsonProperty("delivery_party")
    DeliveryParty deliveryParty;

    @JsonProperty("requested_date_of_delivery")
    String requestedDateOfDelivery;

    @JsonProperty("shipping_condition")
    String shippingCondition;

    String type;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DeliveryParty {
    @JsonProperty("partner_code")
    String partnerCode;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Position {
    @JsonProperty("article_number")
    String articleNumber;

    @JsonProperty("external_order_position")
    String externalOrderPosition;

    @JsonProperty("requested_quantity")
    Integer requestedQuantity;
  }
}
