package com.automaterijal.application.integration.providers.febi.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class FebiAddressDto {
  @JsonProperty("account_number")
  String accountNumber;

  String city;

  @JsonProperty("company_name")
  String companyName;

  String country;

  @JsonProperty("first_name")
  String firstName;

  @JsonProperty("last_name")
  String lastName;

  @JsonProperty("postal_code")
  String postalCode;

  String street;
}
