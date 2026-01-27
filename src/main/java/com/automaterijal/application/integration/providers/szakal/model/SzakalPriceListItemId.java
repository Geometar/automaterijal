package com.automaterijal.application.integration.providers.szakal.model;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SzakalPriceListItemId implements Serializable {
  Integer listNo;
  String glid;
}
