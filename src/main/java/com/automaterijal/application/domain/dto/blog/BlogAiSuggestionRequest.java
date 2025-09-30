package com.automaterijal.application.domain.dto.blog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogAiSuggestionRequest {

  @NotBlank
  @Size(max = 200)
  String topic;

  List<@Size(max = 60) String> keywords;
}
