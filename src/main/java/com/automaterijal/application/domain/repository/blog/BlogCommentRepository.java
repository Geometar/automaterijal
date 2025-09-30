package com.automaterijal.application.domain.repository.blog;

import com.automaterijal.application.domain.entity.blog.BlogComment;
import com.automaterijal.application.domain.entity.blog.BlogPost;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {

  List<BlogComment> findByPostAndApprovedTrueOrderByCreatedAtDesc(BlogPost post);
}
