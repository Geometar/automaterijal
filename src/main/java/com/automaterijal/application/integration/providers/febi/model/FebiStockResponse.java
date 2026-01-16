package com.automaterijal.application.integration.providers.febi.model;

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
public class FebiStockResponse {
  @JsonProperty("destination_country")
  String destinationCountry;

  @JsonProperty("primary_warehouse")
  String primaryWarehouse;

  String timestamp;

  @JsonProperty("number_of_items")
  Integer numberOfItems;

  List<FebiStockResponseItem> items;
}
