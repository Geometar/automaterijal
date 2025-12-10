package com.automaterijal.application.integration.providers.febi.price;

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
public class FebiPriceRecord {
  String brand;
  String rawArticleNumber;
  String normalizedArticleNumber;
  String normalizedArticleNumberNoLeadingZeros;
  String level3;
  BigDecimal netPrice;
  String currency;
}
