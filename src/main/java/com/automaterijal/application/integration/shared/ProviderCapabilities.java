package com.automaterijal.application.integration.shared;

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
public class ProviderCapabilities {
  boolean inventory;
  boolean ordering;
  boolean orderHistory;
  boolean enabled;

  public static ProviderCapabilities inventoryOnly() {
    return ProviderCapabilities.builder().inventory(true).enabled(true).build();
  }
}
