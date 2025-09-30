package com.automaterijal.application.domain.entity.blog;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "blog_comment")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogComment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  BlogPost post;

  @Column(name = "author_name", nullable = false, length = 120)
  String authorName;

  @Column(name = "author_email", length = 180)
  String authorEmail;

  @Column(nullable = false, length = 2048)
  String content;

  @Column(nullable = false)
  Boolean approved = Boolean.TRUE;

  @Column(name = "created_at", nullable = false)
  LocalDateTime createdAt;

  @PrePersist
  void onCreate() {
    if (createdAt == null) {
      createdAt = LocalDateTime.now();
    }
  }
}
