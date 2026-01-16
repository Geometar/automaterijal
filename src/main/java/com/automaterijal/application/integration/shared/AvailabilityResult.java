package com.automaterijal.application.integration.shared;

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
public class AvailabilityResult {
  String provider;
  String providerType;
  String destinationCountry;
  ProviderCallStatus status;
  String errorMessage;
  List<AvailabilityItem> items;
}
