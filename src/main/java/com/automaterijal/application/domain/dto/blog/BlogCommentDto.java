package com.automaterijal.application.domain.dto.blog;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BlogCommentDto {
  Long id;
  String authorName;
  String content;
  LocalDateTime createdAt;
}
