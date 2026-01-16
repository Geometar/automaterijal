package com.automaterijal.application.integration.shared;

import java.util.Map;
import java.util.Set;
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
public class ProviderRoutingContext {
  Integer partnerId;
  Integer partnerAudit;
  ProviderRoutingPurpose purpose;
  Integer localAvailableCount;
  Integer localMatchCount;
  Set<String> groups;
  Map<String, String> attributes;
}
