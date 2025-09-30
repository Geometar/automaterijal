package com.automaterijal.application.domain.dto.common;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PagedResponse<T> {
  List<T> items;
  PageMetaDto meta;
}
