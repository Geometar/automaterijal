package com.automaterijal.application.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
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
public class ProviderAvailabilityDto {
  String brand;
  String provider;
  String articleNumber;
  Boolean available;
  Integer totalQuantity;
  String warehouse;
  String warehouseName;
  Integer warehouseQuantity;
  BigDecimal purchasePrice;
  BigDecimal price;
  BigDecimal coreCharge;
  String currency;
  Integer packagingUnit;
  Integer minOrderQuantity;
  Integer leadTimeBusinessDays;
  Integer deliveryToCustomerBusinessDaysMin;
  Integer deliveryToCustomerBusinessDaysMax;
  String expectedDelivery;
  String nextDispatchCutoff;
  String providerProductId;
  String providerStockToken;
  Boolean providerNoReturnable;
  Boolean realtimeChecked;
  String realtimeCheckedAt;
}
