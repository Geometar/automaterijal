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
public class FebiOrderResponse {

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
    Summary summary;
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

    @JsonProperty("erp_customer_order_number")
    String erpCustomerOrderNumber;

    String type;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Position {
    @JsonProperty("external_order_position")
    String externalOrderPosition;

    @JsonProperty("confirmed_quantity")
    Integer confirmedQuantity;

    Boolean backorder;
    List<Message> messages;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Message {
    String text;
    String type;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Summary {
    @JsonProperty("total_gross_value")
    String totalGrossValue;

    @JsonProperty("total_net_value")
    String totalNetValue;

    @JsonProperty("total_tax_value")
    String totalTaxValue;
  }
}
