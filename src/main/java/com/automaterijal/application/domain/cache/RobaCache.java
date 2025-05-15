package com.automaterijal.application.domain.cache;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaCache implements Serializable {
  Long robaid;
  String katbr;
  String katbrpro;
  String naziv;
}
