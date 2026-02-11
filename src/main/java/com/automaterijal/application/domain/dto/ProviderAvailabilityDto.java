package com.automaterijal.application.domain.dto;

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
  String currency;
  Integer packagingUnit;
  Integer minOrderQuantity;
  Integer leadTimeBusinessDays;
  Integer deliveryToCustomerBusinessDaysMin;
  Integer deliveryToCustomerBusinessDaysMax;
  String nextDispatchCutoff;
  String providerProductId;
  String providerStockToken;
  Boolean providerNoReturnable;
}
