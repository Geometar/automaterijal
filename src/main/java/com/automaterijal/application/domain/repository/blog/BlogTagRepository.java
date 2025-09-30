package com.automaterijal.application.domain.repository.blog;

import com.automaterijal.application.domain.entity.blog.BlogTag;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {

  Optional<BlogTag> findBySlug(String slug);

  List<BlogTag> findAllByOrderByNameAsc();
}
