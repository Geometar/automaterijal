package com.automaterijal.application.integration.shared;

import java.math.BigDecimal;
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
public class AvailabilityItem {
  String brand;
  String articleNumber;
  AvailabilityStatus status;
  Integer totalQuantity;
  List<WarehouseAvailability> warehouses;
  BigDecimal purchasePrice;
  BigDecimal sellingPrice;
  String currency;
  Integer leadTimeBusinessDays;
  Integer deliveryToCustomerBusinessDaysMin;
  Integer deliveryToCustomerBusinessDaysMax;
  String nextDispatchCutoff;
}
