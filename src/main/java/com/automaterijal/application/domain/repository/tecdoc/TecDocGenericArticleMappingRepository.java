package com.automaterijal.application.domain.repository.tecdoc;

import com.automaterijal.application.domain.entity.tecdoc.TecDocGenericArticleMapping;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecDocGenericArticleMappingRepository
    extends JpaRepository<TecDocGenericArticleMapping, Long> {
  Optional<TecDocGenericArticleMapping> findByGenericArticleId(Long genericArticleId);

  List<TecDocGenericArticleMapping> findAllByGenericArticleIdIn(Collection<Long> genericArticleIds);
}
