package com.automaterijal.application.domain.dto.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PageMetaDto {
  long totalElements;
  int totalPages;
  int page;
  int size;
  boolean hasNext;
  boolean hasPrevious;
}
