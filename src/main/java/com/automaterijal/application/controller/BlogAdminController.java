package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.blog.*;
import com.automaterijal.application.services.blog.BlogAdminService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/blog")
@Validated
@RequiredArgsConstructor
public class BlogAdminController {

  private final BlogAdminService blogAdminService;

  @GetMapping("/categories")
  public List<BlogCategoryDto> listCategories() {
    return blogAdminService.listCategories();
  }

  @PostMapping("/categories")
  public ResponseEntity<BlogCategoryDto> createCategory(@Valid @RequestBody BlogCategoryRequest request) {
    BlogCategoryDto created = blogAdminService.createCategory(request);
    return ResponseEntity.created(URI.create("/api/v1/admin/blog/categories/" + created.getId())).body(created);
  }

  @PutMapping("/categories/{id}")
  public BlogCategoryDto updateCategory(
      @PathVariable Long id, @Valid @RequestBody BlogCategoryRequest request) {
    return blogAdminService.updateCategory(id, request);
  }

  @DeleteMapping("/categories/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    blogAdminService.deleteCategory(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/tags")
  public List<BlogTagDto> listTags() {
    return blogAdminService.listTags();
  }

  @PostMapping("/tags")
  public ResponseEntity<BlogTagDto> createTag(@Valid @RequestBody BlogTagRequest request) {
    BlogTagDto created = blogAdminService.createTag(request);
    return ResponseEntity.created(URI.create("/api/v1/admin/blog/tags/" + created.getId())).body(created);
  }

  @PutMapping("/tags/{id}")
  public BlogTagDto updateTag(@PathVariable Long id, @Valid @RequestBody BlogTagRequest request) {
    return blogAdminService.updateTag(id, request);
  }

  @DeleteMapping("/tags/{id}")
  public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
    blogAdminService.deleteTag(id);
    return ResponseEntity.noContent().build();
  }
}
