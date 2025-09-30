package com.automaterijal.application.domain.dto.blog;

import com.automaterijal.application.domain.constants.BlogPostStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogPostRequest {

  @NotBlank
  @Size(max = 200)
  String title;

  @Size(max = 200)
  String slug;

  @Size(max = 500)
  String excerpt;

  @NotBlank
  String content;

  @Size(max = 255)
  String coverImageUrl;

  @Size(max = 3000000, message = "Cover image payload is too large")
  String coverImageBytes;

  @Size(max = 100)
  String coverImageContentType;

  @Size(max = 255)
  String metaTitle;

  @Size(max = 320)
  String metaDescription;

  @Size(max = 255)
  String canonicalUrl;

  @Size(max = 255)
  String metaKeywords;

  @NotNull
  BlogPostStatus status = BlogPostStatus.DRAFT;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  LocalDateTime publishedAt;

  @NotNull
  @Size(min = 1, message = "At least one category is required")
  List<@NotBlank @Size(max = 160) String> categories;

  List<@NotBlank @Size(max = 160) String> tags;

  @JsonIgnore
  boolean showcaseEnabled = false;

  @JsonIgnore
  JsonNode showcasePayload;

  @JsonSetter("showcase")
  public void setShowcase(JsonNode node) {
    if (node == null || node.isNull()) {
      this.showcaseEnabled = false;
      this.showcasePayload = null;
      return;
    }

    boolean enabled;
    if (node.isBoolean()) {
      enabled = node.booleanValue();
    } else if (node.isTextual()) {
      enabled = Boolean.parseBoolean(node.textValue());
    } else if (node.isObject()) {
      if (node.has("enabled")) {
        enabled = node.get("enabled").asBoolean(true);
      } else if (node.has("value")) {
        enabled = node.get("value").asBoolean(true);
      } else {
        enabled = true;
      }
    } else {
      enabled = node.asBoolean(false);
    }

    if (!enabled) {
      this.showcaseEnabled = false;
      this.showcasePayload = null;
      return;
    }

    this.showcaseEnabled = true;
    this.showcasePayload = node.isBoolean() ? BooleanNode.valueOf(true) : node;
  }

  @JsonSetter("categoryIds")
  public void setCategoryIds(List<String> categoryIds) {
    this.categories = categoryIds;
  }

  @JsonSetter("tagIds")
  public void setTagIds(List<String> tagIds) {
    this.tags = tagIds;
  }
}
