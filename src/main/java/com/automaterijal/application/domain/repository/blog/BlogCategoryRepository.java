package com.automaterijal.application.domain.repository.blog;

import com.automaterijal.application.domain.entity.blog.BlogCategory;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {

  Optional<BlogCategory> findBySlug(String slug);

  @Query(
      "select c.slug, count(p) from BlogCategory c left join c.posts p "
          + "with p.status = com.automaterijal.application.domain.constants.BlogPostStatus.PUBLISHED "
          + "and p.publishedAt <= CURRENT_TIMESTAMP group by c.slug")
  java.util.List<Object[]> computePublishedCounts();
}
