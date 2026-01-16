package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.BlogPostStatus;
import com.automaterijal.application.domain.dto.blog.*;
import com.automaterijal.application.domain.dto.common.PagedResponse;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.blog.BlogPostService;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(
    origins = {
      "https://automaterijal.com",
      "http://localhost:4200",
      "http://127.0.0.1:4200",
      "http://localhost:4000",
      "http://127.0.0.1:4000"
    })
@RequiredArgsConstructor
public class BlogController {

  private final BlogPostService blogPostService;
  private final PartnerSpringBeanUtils partnerSpringBeanUtils;

  @GetMapping("/posts")
  public PagedResponse<BlogPostPreviewDto> listPosts(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(required = false) String category,
      @RequestParam(required = false) String tag,
      @RequestParam(required = false) String search,
      @RequestParam(required = false, defaultValue = "publishedAt,desc") String sort,
      @RequestParam(required = false) String status) {

    ParsedStatus parsedStatus = parseStatus(status);
    BlogPostService.BlogPostFilter filter =
        new BlogPostService.BlogPostFilter(
            page,
            size,
            sort,
            category,
            tag,
            search,
            parsedStatus.status(),
            parsedStatus.includeAll());

    return blogPostService.getPosts(filter);
  }

  @GetMapping("/posts/{slug}")
  public BlogPostDetailDto getPost(@PathVariable String slug, Authentication authentication) {
    Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    boolean isAdmin = PartnerPrivilegeUtils.isInternal(partner);
    return isAdmin
        ? blogPostService.getPostIncludingDrafts(slug)
        : blogPostService.getPublishedPost(slug);
  }

  @GetMapping("/categories")
  public List<BlogCategoryDto> listCategories() {
    return blogPostService.getAllCategories();
  }

  @GetMapping("/tags")
  public List<BlogTagDto> listTags() {
    return blogPostService.getAllTags();
  }

  @GetMapping("/posts/{slug}/comments")
  public List<BlogCommentDto> listComments(@PathVariable String slug) {
    return blogPostService.getApprovedComments(slug);
  }

  @PostMapping("/posts/{slug}/comments")
  public ResponseEntity<BlogCommentDto> addComment(
      @PathVariable String slug, @Valid @RequestBody BlogCommentRequest request) {
    BlogCommentDto response = blogPostService.addComment(slug, request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PostMapping("/posts")
  public ResponseEntity<BlogPostDetailDto> createPost(@Valid @RequestBody BlogPostRequest request) {
    BlogPostDetailDto response = blogPostService.createPost(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping("/posts/{slug}")
  public BlogPostDetailDto updatePost(
      @PathVariable String slug, @Valid @RequestBody BlogPostRequest request) {
    return blogPostService.updatePost(slug, request);
  }

  @DeleteMapping("/posts/{slug}")
  public ResponseEntity<Void> deletePost(
      @PathVariable String slug, @RequestParam(defaultValue = "false") boolean hardDelete) {
    blogPostService.deletePost(slug, hardDelete);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/posts/{slug}/cover")
  public ResponseEntity<Void> deleteCoverImage(@PathVariable String slug) {
    blogPostService.removeCoverImage(slug);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/blog-ai-suggestions")
  public BlogAiSuggestionResponse suggest(
      @Valid @RequestBody BlogAiSuggestionRequest request) {
    return blogPostService.suggestTopics(request);
  }

  private ParsedStatus parseStatus(String status) {
    if (!StringUtils.hasText(status)) {
      return new ParsedStatus(BlogPostStatus.PUBLISHED, false);
    }
    String normalized = status.trim().toUpperCase();
    if ("ALL".equals(normalized)) {
      return new ParsedStatus(null, true);
    }
    try {
      return new ParsedStatus(BlogPostStatus.valueOf(normalized), false);
    } catch (IllegalArgumentException ex) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status value");
    }
  }

  private record ParsedStatus(BlogPostStatus status, boolean includeAll) {}
}
