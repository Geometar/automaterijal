package com.automaterijal.application.services.blog;

import com.automaterijal.application.domain.dto.blog.*;
import com.automaterijal.application.domain.entity.blog.BlogCategory;
import com.automaterijal.application.domain.entity.blog.BlogTag;
import com.automaterijal.application.domain.mapper.BlogMapper;
import com.automaterijal.application.domain.repository.blog.BlogCategoryRepository;
import com.automaterijal.application.domain.repository.blog.BlogTagRepository;
import com.automaterijal.application.utils.SlugUtil;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogAdminService {

  private final BlogCategoryRepository blogCategoryRepository;
  private final BlogTagRepository blogTagRepository;
  private final BlogMapper blogMapper;

  public List<BlogCategoryDto> listCategories() {
    return blogCategoryRepository.findAll().stream()
        .sorted(Comparator.comparing(BlogCategory::getName, String.CASE_INSENSITIVE_ORDER))
        .map(blogMapper::toCategory)
        .toList();
  }

  public BlogCategoryDto createCategory(BlogCategoryRequest request) {
    BlogCategory category = new BlogCategory();
    applyCategory(category, request, null);
    BlogCategory saved = blogCategoryRepository.save(category);
    return blogMapper.toCategory(saved);
  }

  public BlogCategoryDto updateCategory(Long id, BlogCategoryRequest request) {
    BlogCategory existing =
        blogCategoryRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    applyCategory(existing, request, id);
    BlogCategory saved = blogCategoryRepository.save(existing);
    return blogMapper.toCategory(saved);
  }

  public void deleteCategory(Long id) {
    BlogCategory existing =
        blogCategoryRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    if (!existing.getPosts().isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Category cannot be deleted while it is assigned to posts");
    }
    blogCategoryRepository.delete(existing);
  }

  public List<BlogTagDto> listTags() {
    return blogTagRepository.findAllByOrderByNameAsc().stream().map(blogMapper::toTag).toList();
  }

  public BlogTagDto createTag(BlogTagRequest request) {
    BlogTag tag = new BlogTag();
    applyTag(tag, request, null);
    BlogTag saved = blogTagRepository.save(tag);
    return blogMapper.toTag(saved);
  }

  public BlogTagDto updateTag(Long id, BlogTagRequest request) {
    BlogTag existing =
        blogTagRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found"));
    applyTag(existing, request, id);
    BlogTag saved = blogTagRepository.save(existing);
    return blogMapper.toTag(saved);
  }

  public void deleteTag(Long id) {
    BlogTag existing =
        blogTagRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found"));
    if (!existing.getPosts().isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Tag cannot be deleted while it is assigned to posts");
    }
    blogTagRepository.delete(existing);
  }

  private void applyCategory(BlogCategory category, BlogCategoryRequest request, Long currentId) {
    category.setName(request.getName().trim());
    category.setDescription(
        StringUtils.hasText(request.getDescription()) ? request.getDescription().trim() : null);

    String slug = resolveSlug(request.getSlug(), request.getName());
    ensureUniqueCategorySlug(slug, currentId);
    category.setSlug(slug);
  }

  private void applyTag(BlogTag tag, BlogTagRequest request, Long currentId) {
    tag.setName(request.getName().trim());
    String slug = resolveSlug(request.getSlug(), request.getName());
    ensureUniqueTagSlug(slug, currentId);
    tag.setSlug(slug);
  }

  private String resolveSlug(String slugCandidate, String fallback) {
    String candidate = StringUtils.hasText(slugCandidate) ? slugCandidate : fallback;
    String slug = SlugUtil.toSlug(candidate);
    if (!StringUtils.hasText(slug)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Slug cannot be empty");
    }
    if (slug.length() > 160) {
      slug = slug.substring(0, 160);
    }
    return slug;
  }

  private void ensureUniqueCategorySlug(String slug, Long currentId) {
    blogCategoryRepository
        .findBySlug(slug)
        .ifPresent(
            existing -> {
              if (currentId == null || !Objects.equals(existing.getId(), currentId)) {
                throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Category slug already exists");
              }
            });
  }

  private void ensureUniqueTagSlug(String slug, Long currentId) {
    blogTagRepository
        .findBySlug(slug)
        .ifPresent(
            existing -> {
              if (currentId == null || !Objects.equals(existing.getId(), currentId)) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Tag slug already exists");
              }
            });
  }
}
