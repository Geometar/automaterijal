package com.automaterijal.application.domain.dto.checkout;

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
public class CheckoutConflictItemDto {
  Long robaId;
  Long tecDocArticleId;
  String catalogNumber;
  String articleName;
  String providerKey;
  Integer requestedQuantity;
  Integer confirmedQuantity;
  Integer maxOrderableQuantity;
  String message;
}
