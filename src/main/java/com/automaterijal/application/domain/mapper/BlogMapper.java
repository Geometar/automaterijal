package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.blog.*;
import com.automaterijal.application.domain.entity.blog.BlogCategory;
import com.automaterijal.application.domain.entity.blog.BlogComment;
import com.automaterijal.application.domain.entity.blog.BlogPost;
import com.automaterijal.application.domain.entity.blog.BlogTag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BlogMapper {

  private final ObjectMapper objectMapper;

  public BlogPostPreviewDto toPreview(BlogPost post) {
    return toPreview(post, null, null);
  }

  public BlogPostPreviewDto toPreview(
      BlogPost post, String coverImageBase64, String coverImageContentType) {
    return BlogPostPreviewDto.builder()
        .id(post.getId())
        .title(post.getTitle())
        .slug(post.getSlug())
        .excerpt(post.getExcerpt())
        .coverImageUrl(post.getCoverImageUrl())
        .coverImageBytes(coverImageBase64)
        .coverImageContentType(coverImageContentType)
        .publishedAt(post.getPublishedAt())
        .metaTitle(post.getMetaTitle())
        .metaDescription(post.getMetaDescription())
        .canonicalUrl(post.getCanonicalUrl())
        .metaKeywords(post.getMetaKeywords())
        .categories(toCategoryList(post.getCategories()))
        .tags(toTagList(post.getTags()))
        .status(post.getStatus())
        .showcase(buildShowcaseNode(post))
        .build();
  }

  public BlogPostDetailDto toDetail(BlogPost post) {
    return toDetail(post, null, null);
  }

  public BlogPostDetailDto toDetail(
      BlogPost post, String coverImageBase64, String coverImageContentType) {
    return BlogPostDetailDto.builder()
        .id(post.getId())
        .title(post.getTitle())
        .slug(post.getSlug())
        .content(post.getContent())
        .excerpt(post.getExcerpt())
        .coverImageUrl(post.getCoverImageUrl())
        .coverImageBytes(coverImageBase64)
        .coverImageContentType(coverImageContentType)
        .publishedAt(post.getPublishedAt())
        .metaTitle(post.getMetaTitle())
        .metaDescription(post.getMetaDescription())
        .canonicalUrl(post.getCanonicalUrl())
        .metaKeywords(post.getMetaKeywords())
        .categories(toCategoryList(post.getCategories()))
        .tags(toTagList(post.getTags()))
        .commentCount(post.getComments() == null ? 0 : post.getComments().size())
        .status(post.getStatus())
        .showcase(buildShowcaseNode(post))
        .build();
  }

  public BlogCategoryDto toCategory(BlogCategory category, long postCount) {
    return BlogCategoryDto.builder()
        .id(category.getId())
        .name(category.getName())
        .slug(category.getSlug())
        .description(category.getDescription())
        .postCount(postCount)
        .build();
  }

  public BlogCategoryDto toCategory(BlogCategory category) {
    return toCategory(category, 0);
  }

  public BlogCommentDto toComment(BlogComment comment) {
    return BlogCommentDto.builder()
        .id(comment.getId())
        .authorName(comment.getAuthorName())
        .content(comment.getContent())
        .createdAt(comment.getCreatedAt())
        .build();
  }

  public BlogTagDto toTag(BlogTag tag) {
    return BlogTagDto.builder().id(tag.getId()).name(tag.getName()).slug(tag.getSlug()).build();
  }

  public List<BlogCommentDto> toCommentList(List<BlogComment> comments) {
    if (comments == null) {
      return Collections.emptyList();
    }
    return comments.stream().map(this::toComment).collect(Collectors.toList());
  }

  public List<BlogCategoryDto> toCategoryList(Set<BlogCategory> categories) {
    if (categories == null || categories.isEmpty()) {
      return Collections.emptyList();
    }
    return categories.stream().map(this::toCategory).collect(Collectors.toList());
  }

  public List<BlogTagDto> toTagList(Set<BlogTag> tags) {
    if (tags == null || tags.isEmpty()) {
      return Collections.emptyList();
    }
    return tags.stream().map(this::toTag).collect(Collectors.toList());
  }

  private JsonNode buildShowcaseNode(BlogPost post) {
    String payload = post.getShowcasePayload();
    if (payload == null || payload.isBlank()) {
      return post.isShowcase() ? BooleanNode.TRUE : NullNode.instance;
    }
    try {
      JsonNode node = objectMapper.readTree(payload);
      if (node == null || node.isMissingNode()) {
        return post.isShowcase() ? BooleanNode.TRUE : NullNode.instance;
      }
      return node;
    } catch (JsonProcessingException ex) {
      log.warn("Failed to parse showcase payload for post {}", post.getId(), ex);
      return post.isShowcase() ? BooleanNode.TRUE : NullNode.instance;
    }
  }
}
