package com.automaterijal.application.domain.dto.blog;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BlogCategoryDto {
  Long id;
  String name;
  String slug;
  String description;
  long postCount;
}
