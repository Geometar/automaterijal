package com.automaterijal.application.integration.shared;

import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaBrojeviDto;
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
public class ProviderDetailsResult {
  String provider;
  String brand;
  String articleNumber;
  String name;
  String description;
  List<String> imageUrls;
  List<RobaTehnickiOpisDto> technicalDetails;
  List<RobaBrojeviDto> numbers;
  ProviderAvailabilityDto availability;
  String groupId;
  String groupName;
  Integer subGroupId;
  String subGroupName;
}
