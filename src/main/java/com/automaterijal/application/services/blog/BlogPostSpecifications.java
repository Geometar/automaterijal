package com.automaterijal.application.services.blog;

import com.automaterijal.application.domain.constants.BlogPostStatus;
import com.automaterijal.application.domain.entity.blog.BlogPost;
import jakarta.persistence.criteria.JoinType;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class BlogPostSpecifications {

  private BlogPostSpecifications() {}

  public static Specification<BlogPost> published() {
    return (root, query, cb) ->
        cb.and(
            cb.equal(root.get("status"), BlogPostStatus.PUBLISHED),
            cb.lessThanOrEqualTo(root.get("publishedAt"), LocalDateTime.now()));
  }

  public static Specification<BlogPost> hasCategory(String categorySlug) {
    if (!StringUtils.hasText(categorySlug)) {
      return null;
    }
    return (root, query, cb) -> {
      query.distinct(true);
      var categories = root.join("categories", JoinType.INNER);
      categories.on(cb.equal(categories.get("slug"), categorySlug));
      return cb.conjunction();
    };
  }

  public static Specification<BlogPost> hasTag(String tagSlug) {
    if (!StringUtils.hasText(tagSlug)) {
      return null;
    }
    return (root, query, cb) -> {
      query.distinct(true);
      var tags = root.join("tags", JoinType.INNER);
      tags.on(cb.equal(tags.get("slug"), tagSlug));
      return cb.conjunction();
    };
  }

  public static Specification<BlogPost> textSearch(String search) {
    if (!StringUtils.hasText(search)) {
      return null;
    }
    String likeValue = "%" + search.trim().toLowerCase() + "%";
    return (root, query, cb) ->
        cb.or(
            cb.like(cb.lower(root.get("title")), likeValue),
            cb.like(cb.lower(root.get("content")), likeValue),
            cb.like(cb.lower(root.get("excerpt")), likeValue));
  }

  public static Specification<BlogPost> hasStatus(BlogPostStatus status) {
    if (status == null) {
      return null;
    }
    return (root, query, cb) -> cb.equal(root.get("status"), status);
  }
}
