package com.automaterijal.application.domain.dto.blog;

import com.automaterijal.application.domain.constants.BlogPostStatus;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BlogPostDetailDto {
  Long id;
  String title;
  String slug;
  String content;
  String excerpt;
  String coverImageUrl;
  String coverImageBytes;
  String coverImageContentType;
  LocalDateTime publishedAt;
  String metaTitle;
  String metaDescription;
  String canonicalUrl;
  String metaKeywords;
  List<BlogCategoryDto> categories;
  List<BlogTagDto> tags;
  long commentCount;
  BlogPostStatus status;
  JsonNode showcase;
}
