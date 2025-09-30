package com.automaterijal.application.domain.repository.blog;

import com.automaterijal.application.domain.entity.blog.BlogPost;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface BlogPostRepository
    extends JpaRepository<BlogPost, Long>, JpaSpecificationExecutor<BlogPost> {

  @EntityGraph(attributePaths = {"categories", "tags"})
  Optional<BlogPost> findBySlug(String slug);

  @Override
  @EntityGraph(attributePaths = {"categories", "tags"})
  Optional<BlogPost> findById(Long id);

  @Override
  @EntityGraph(attributePaths = {"categories", "tags"})
  Page<BlogPost> findAll(Specification<BlogPost> spec, Pageable pageable);

  @Query(
      "select p from BlogPost p where p.status = com.automaterijal.application.domain.constants.BlogPostStatus.PUBLISHED and p.publishedAt <= CURRENT_TIMESTAMP order by p.publishedAt desc")
  Stream<BlogPost> streamPublishedOrdered();

  @Query(
      "select p.publishedAt from BlogPost p where p.status = com.automaterijal.application.domain.constants.BlogPostStatus.PUBLISHED and p.publishedAt is not null and p.publishedAt <= CURRENT_TIMESTAMP order by p.publishedAt desc")
  Stream<java.time.LocalDateTime> streamLatestPublishedAt();
}
