package com.automaterijal.application.domain.dto.blog;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BlogAiSuggestionResponse {
  List<String> suggestions;
}
