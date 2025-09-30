package com.automaterijal.application.services.blog;

import com.automaterijal.application.domain.constants.BlogPostStatus;
import com.automaterijal.application.domain.dto.blog.*;
import com.automaterijal.application.domain.dto.common.PageMetaDto;
import com.automaterijal.application.domain.dto.common.PagedResponse;
import com.automaterijal.application.domain.entity.blog.BlogCategory;
import com.automaterijal.application.domain.entity.blog.BlogComment;
import com.automaterijal.application.domain.entity.blog.BlogPost;
import com.automaterijal.application.domain.entity.blog.BlogTag;
import com.automaterijal.application.domain.mapper.BlogMapper;
import com.automaterijal.application.domain.repository.blog.BlogCategoryRepository;
import com.automaterijal.application.domain.repository.blog.BlogCommentRepository;
import com.automaterijal.application.domain.repository.blog.BlogPostRepository;
import com.automaterijal.application.domain.repository.blog.BlogTagRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.HtmlUtils;

import com.automaterijal.application.utils.SlugUtil;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BlogPostService {

  static final int MAX_PAGE_SIZE = 50;

  BlogPostRepository blogPostRepository;
  BlogCategoryRepository blogCategoryRepository;
  BlogTagRepository blogTagRepository;
  BlogCommentRepository blogCommentRepository;
  BlogImageService blogImageService;
  BlogMapper blogMapper;
  ObjectMapper objectMapper;

  @Transactional(readOnly = true)
  public PagedResponse<BlogPostPreviewDto> getPosts(BlogPostFilter filter) {
    Pageable pageable = filter.toPageable();

    Specification<BlogPost> specification =
        resolveStatusSpecification(filter.status(), filter.includeAll());

    specification = combine(specification, BlogPostSpecifications.hasCategory(filter.categorySlug()));
    specification = combine(specification, BlogPostSpecifications.hasTag(filter.tagSlug()));
    specification = combine(specification, BlogPostSpecifications.textSearch(filter.search()));

    Page<BlogPost> page =
        specification == null
            ? blogPostRepository.findAll(pageable)
            : blogPostRepository.findAll(specification, pageable);

    List<BlogPostPreviewDto> items =
        page.getContent().stream()
            .map(
                post -> {
                  BlogImageService.ImagePayload imagePayload = loadCoverImagePayload(post);
                  return blogMapper.toPreview(
                      post,
                      imagePayload == null ? null : imagePayload.base64(),
                      imagePayload == null ? null : imagePayload.contentType());
                })
            .toList();

    PageMetaDto meta =
        PageMetaDto.builder()
            .page(pageable.getPageNumber())
            .size(pageable.getPageSize())
            .totalElements(page.getTotalElements())
            .totalPages(page.getTotalPages())
            .hasNext(page.hasNext())
            .hasPrevious(page.hasPrevious())
            .build();

    return PagedResponse.<BlogPostPreviewDto>builder().items(items).meta(meta).build();
  }

  @Transactional(readOnly = true)
  public List<BlogTagDto> getAllTags() {
    return blogTagRepository.findAllByOrderByNameAsc().stream()
        .map(blogMapper::toTag)
        .toList();
  }

  @Transactional(readOnly = true)
  public BlogPostDetailDto getPublishedPost(String slugOrId) {
    BlogPost post = findPostOrThrow(slugOrId);
    ensurePublished(post);
    return toDetailDto(post);
  }

  @Transactional(readOnly = true)
  public BlogPostDetailDto getPostIncludingDrafts(String slugOrId) {
    BlogPost post = findPostOrThrow(slugOrId);
    return toDetailDto(post);
  }

  @Transactional(readOnly = true)
  public List<BlogCategoryDto> getAllCategories() {
    Map<String, Long> counts = computeCategoryCounts();
    return blogCategoryRepository.findAll().stream()
        .map(category -> blogMapper.toCategory(category, counts.getOrDefault(category.getSlug(), 0L)))
        .sorted(Comparator.comparing(BlogCategoryDto::getName, String.CASE_INSENSITIVE_ORDER))
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public List<BlogCommentDto> getApprovedComments(String slugOrId) {
    BlogPost post = findPostOrThrow(slugOrId);
    ensurePublished(post);
    List<BlogComment> comments = blogCommentRepository.findByPostAndApprovedTrueOrderByCreatedAtDesc(post);
    return blogMapper.toCommentList(comments);
  }

  @Transactional
  public BlogCommentDto addComment(String slugOrId, BlogCommentRequest request) {
    BlogPost post = findPostOrThrow(slugOrId);
    ensurePublished(post);

    BlogComment comment = new BlogComment();
    comment.setPost(post);
    comment.setAuthorName(request.getAuthorName().trim());
    if (StringUtils.hasText(request.getAuthorEmail())) {
      comment.setAuthorEmail(request.getAuthorEmail().trim());
    }
    comment.setContent(sanitizeContent(request.getContent()));
    comment.setApproved(Boolean.TRUE);

    blogCommentRepository.save(comment);

    return blogMapper.toComment(comment);
  }

  @Transactional(readOnly = true)
  public BlogAiSuggestionResponse suggestTopics(BlogAiSuggestionRequest request) {
    List<String> keywords =
        Optional.ofNullable(request.getKeywords()).orElseGet(Collections::emptyList).stream()
            .filter(StringUtils::hasText)
            .map(String::trim)
            .toList();

    List<String> existingTags =
        blogTagRepository.findAll().stream()
            .map(tag -> tag.getName().toLowerCase())
            .toList();

    List<String> suggestions = new ArrayList<>();
    String base = request.getTopic().trim();
    suggestions.add(String.format("%s: kompletan vodič", base));
    if (!keywords.isEmpty()) {
      suggestions.add(String.format("%s kroz prizmu %s", base, String.join(", ", keywords)));
    }
    existingTags.stream()
        .filter(tag -> base.toLowerCase().contains(tag) || tag.contains(base.toLowerCase()))
        .findFirst()
        .ifPresent(tag -> suggestions.add(base + " i trendovi za " + tag));

    if (suggestions.size() < 3) {
      suggestions.add(base + " – najčešća pitanja i odgovori");
    }

    return BlogAiSuggestionResponse.builder().suggestions(suggestions).build();
  }

  @Transactional
  public BlogPostDetailDto createPost(BlogPostRequest request) {
    BlogPost post = new BlogPost();
    applyRequest(post, request, true);
    BlogPost saved = blogPostRepository.save(post);
    return toDetailDto(saved);
  }

  @Transactional
  public BlogPostDetailDto updatePost(String slugOrId, BlogPostRequest request) {
    BlogPost post = findPostOrThrow(slugOrId);
    applyRequest(post, request, false);
    BlogPost saved = blogPostRepository.save(post);
    return toDetailDto(saved);
  }

  @Transactional
  public void deletePost(String slugOrId, boolean hardDelete) {
    BlogPost post = findPostOrThrow(slugOrId);
    if (hardDelete) {
      blogImageService.deleteCoverImage(post.getCoverImageUrl());
      blogPostRepository.delete(post);
    } else {
      post.setStatus(BlogPostStatus.ARCHIVED);
      blogPostRepository.save(post);
    }
  }

  @Transactional
  public void removeCoverImage(String slugOrId) {
    BlogPost post = findPostOrThrow(slugOrId);
    blogImageService.deleteCoverImage(post.getCoverImageUrl());
    post.setCoverImageUrl(null);
    blogPostRepository.save(post);
  }

  private BlogPost findPostOrThrow(String slugOrId) {
    if (StringUtils.hasText(slugOrId)) {
      String identifier = slugOrId.trim();
      Optional<BlogPost> postOptional = blogPostRepository.findBySlug(identifier);
      if (postOptional.isPresent()) {
        return postOptional.get();
      }
      if (identifier.matches("\\d+")) {
        return blogPostRepository
            .findById(Long.parseLong(identifier))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
      }
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
  }

  private void ensurePublished(BlogPost post) {
    if (post.getStatus() != BlogPostStatus.PUBLISHED
        || post.getPublishedAt() == null
        || post.getPublishedAt().isAfter(LocalDateTime.now())) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
    }
  }

  private String sanitizeContent(String content) {
    String trimmed = content.trim();
    return HtmlUtils.htmlEscape(trimmed);
  }

  private Map<String, Long> computeCategoryCounts() {
    return blogCategoryRepository.computePublishedCounts().stream()
        .filter(arr -> arr.length == 2)
        .collect(
            Collectors.toMap(
                arr -> (String) arr[0],
                arr -> arr[1] == null ? 0L : ((Number) arr[1]).longValue()));
  }

  public record BlogPostFilter(
      int page,
      int size,
      String sort,
      String categorySlug,
      String tagSlug,
      String search,
      BlogPostStatus status,
      boolean includeAll) {

    Pageable toPageable() {
      int sanitizedSize = Math.min(Math.max(size, 1), MAX_PAGE_SIZE);
      Sort sortSpec = parseSort(sort);
      return PageRequest.of(Math.max(page, 0), sanitizedSize, sortSpec);
    }

    String cacheKey() {
      return String.join(
          "|",
          String.valueOf(page),
          String.valueOf(size),
          defaultString(sort),
          defaultString(categorySlug),
          defaultString(tagSlug),
          defaultString(search),
          includeAll ? "ALL" : status == null ? "PUBLISHED" : status.name());
    }

    boolean isCacheable() {
      return !includeAll && (status == null || status == BlogPostStatus.PUBLISHED);
    }

    private Sort parseSort(String sort) {
      if (!StringUtils.hasText(sort)) {
        return Sort.by(Sort.Direction.DESC, "publishedAt");
      }
      String[] parts = sort.split(",");
      String property = parts[0];
      Sort.Direction direction = Sort.Direction.DESC;
      if (parts.length > 1) {
        try {
          direction = Sort.Direction.fromString(parts[1]);
        } catch (IllegalArgumentException ignored) {
        }
      }
      if (!StringUtils.hasText(property)) {
        property = "publishedAt";
      }
      String normalizedProperty = switch (property) {
        case "title" -> "title";
        case "createdAt" -> "createdAt";
        case "publishedAt" -> "publishedAt";
        default -> "publishedAt";
      };
      return Sort.by(direction, normalizedProperty);
    }

    private String defaultString(String value) {
      return StringUtils.hasText(value) ? value : "_";
    }
  }

  private Specification<BlogPost> combine(
      Specification<BlogPost> base, Specification<BlogPost> addition) {
    if (addition == null) {
      return base;
    }
    return base == null ? Specification.where(addition) : base.and(addition);
  }

  private BlogPostDetailDto toDetailDto(BlogPost post) {
    BlogImageService.ImagePayload imagePayload = loadCoverImagePayload(post);
    return blogMapper.toDetail(
        post,
        imagePayload == null ? null : imagePayload.base64(),
        imagePayload == null ? null : imagePayload.contentType());
  }

  private BlogImageService.ImagePayload loadCoverImagePayload(BlogPost post) {
    return blogImageService.loadCoverImage(post.getCoverImageUrl()).orElse(null);
  }

  private void applyShowcase(BlogPost post, BlogPostRequest request) {
    post.setShowcase(request.isShowcaseEnabled());
    post.setShowcasePayload(serializeShowcasePayload(request.getShowcasePayload()));
  }

  private Specification<BlogPost> resolveStatusSpecification(BlogPostStatus status, boolean includeAll) {
    if (includeAll) {
      return null;
    }
    if (status == null || status == BlogPostStatus.PUBLISHED) {
      return BlogPostSpecifications.published();
    }
    return BlogPostSpecifications.hasStatus(status);
  }

  private void applyRequest(BlogPost post, BlogPostRequest request, boolean isNew) {
    post.setTitle(request.getTitle().trim());
    String desiredSlug = StringUtils.hasText(request.getSlug()) ? request.getSlug() : request.getTitle();
    String uniqueSlug = generateUniqueSlug(desiredSlug, isNew ? null : post.getId());
    post.setSlug(uniqueSlug);
    post.setExcerpt(StringUtils.hasText(request.getExcerpt()) ? request.getExcerpt().trim() : null);
    post.setContent(request.getContent());
    post.setMetaTitle(StringUtils.hasText(request.getMetaTitle()) ? request.getMetaTitle().trim() : null);
    post.setMetaDescription(
        StringUtils.hasText(request.getMetaDescription()) ? request.getMetaDescription().trim() : null);
    post.setCanonicalUrl(StringUtils.hasText(request.getCanonicalUrl()) ? request.getCanonicalUrl().trim() : null);
    post.setMetaKeywords(StringUtils.hasText(request.getMetaKeywords()) ? request.getMetaKeywords().trim() : null);

    applyCoverImage(post, request);

    BlogPostStatus status = Optional.ofNullable(request.getStatus()).orElse(BlogPostStatus.DRAFT);
    post.setStatus(status);
    applyShowcase(post, request);

    if (status == BlogPostStatus.PUBLISHED) {
      LocalDateTime publishedAt =
          request.getPublishedAt() != null
              ? request.getPublishedAt()
              : Optional.ofNullable(post.getPublishedAt()).orElse(LocalDateTime.now());
      post.setPublishedAt(publishedAt);
    } else if (status == BlogPostStatus.ARCHIVED) {
      // keep existing publishedAt if present
      if (request.getPublishedAt() != null) {
        post.setPublishedAt(request.getPublishedAt());
      }
    } else {
      post.setPublishedAt(request.getPublishedAt());
    }

    Set<BlogCategory> categories = resolveCategories(request.getCategories());
    if (post.getCategories() == null) {
      post.setCategories(new HashSet<>(categories));
    } else {
      post.getCategories().clear();
      post.getCategories().addAll(categories);
    }

    Set<BlogTag> tags = resolveTags(request.getTags());
    if (post.getTags() == null) {
      post.setTags(new HashSet<>(tags));
    } else {
      post.getTags().clear();
      post.getTags().addAll(tags);
    }
  }

  private void applyCoverImage(BlogPost post, BlogPostRequest request) {
    String previousPath = post.getCoverImageUrl();

    if (request.getCoverImageBytes() != null) {
      if (!StringUtils.hasText(request.getCoverImageBytes())) {
        blogImageService.deleteCoverImage(previousPath);
        post.setCoverImageUrl(null);
      } else {
        BlogImageService.StoredImage stored =
            blogImageService.saveCoverImage(
                post.getSlug(), request.getCoverImageBytes(), request.getCoverImageContentType(), previousPath);
        post.setCoverImageUrl(stored.relativePath());
      }
      return;
    }

    if (request.getCoverImageUrl() != null) {
      String trimmed =
          StringUtils.hasText(request.getCoverImageUrl()) ? request.getCoverImageUrl().trim() : null;
      if (!Objects.equals(previousPath, trimmed) && StringUtils.hasText(previousPath)) {
        blogImageService.deleteCoverImage(previousPath);
      }
      post.setCoverImageUrl(trimmed);
    }
  }

  private String serializeShowcasePayload(JsonNode payload) {
    if (payload == null || payload.isNull()) {
      return null;
    }
    try {
      return objectMapper.writeValueAsString(payload);
    } catch (JsonProcessingException ex) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid showcase payload", ex);
    }
  }

  private Set<BlogCategory> resolveCategories(List<String> categorySlugs) {
    if (categorySlugs == null || categorySlugs.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "At least one category is required");
    }

    return categorySlugs.stream()
        .map(slug -> {
          String sanitized = slug.trim();
          return blogCategoryRepository
              .findBySlug(sanitized)
              .orElseThrow(
                  () ->
                      new ResponseStatusException(
                          HttpStatus.BAD_REQUEST, "Unknown category: " + sanitized));
        })
        .collect(Collectors.toSet());
  }

  private Set<BlogTag> resolveTags(List<String> tagValues) {
    if (tagValues == null || tagValues.isEmpty()) {
      return new HashSet<>();
    }

    Set<BlogTag> tags = new HashSet<>();
    for (String value : tagValues) {
      if (!StringUtils.hasText(value)) {
        continue;
      }
      String trimmed = value.trim();
      String slug = SlugUtil.toSlug(trimmed);
      if (!StringUtils.hasText(slug)) {
        continue;
      }
      BlogTag tag =
          blogTagRepository.findBySlug(slug)
              .orElseGet(
                  () -> {
                    BlogTag newTag = new BlogTag();
                    newTag.setName(trimmed);
                    newTag.setSlug(slug);
                    return blogTagRepository.save(newTag);
                  });
      tags.add(tag);
    }
    return tags;
  }

  private String generateUniqueSlug(String value, Long ignoreId) {
    String base = SlugUtil.toSlug(value);
    if (!StringUtils.hasText(base)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Slug cannot be empty");
    }

    String candidate = base;
    int suffix = 1;
    while (true) {
      Optional<BlogPost> existing = blogPostRepository.findBySlug(candidate);
      if (existing.isEmpty() || (ignoreId != null && existing.get().getId().equals(ignoreId))) {
        return candidate;
      }
      candidate = base + "-" + suffix++;
    }
  }
}
