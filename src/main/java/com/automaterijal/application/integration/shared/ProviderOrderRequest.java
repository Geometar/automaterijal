package com.automaterijal.application.integration.shared;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
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
public class ProviderOrderRequest {
  WebOrderHeader header;
  Partner partner;
  List<WebOrderItem> items;
  boolean mock;
}
