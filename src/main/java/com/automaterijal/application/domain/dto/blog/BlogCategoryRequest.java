package com.automaterijal.application.domain.dto.blog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogCategoryRequest {

  @NotBlank
  @Size(max = 120)
  String name;

  @Size(max = 160)
  String slug;

  @Size(max = 320)
  String description;
}
