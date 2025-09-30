package com.automaterijal.application.domain.entity.blog;

import com.automaterijal.application.domain.constants.BlogPostStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "blog_post")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogPost {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false, length = 200)
  String title;

  @Column(nullable = false, length = 200, unique = true)
  String slug;

  @Column(length = 500)
  String excerpt;

  @Column(name = "cover_image_url", length = 255)
  String coverImageUrl;

  @Lob
  @Column(nullable = false)
  String content;

  @Column(name = "meta_title", length = 255)
  String metaTitle;

  @Column(name = "meta_description", length = 320)
  String metaDescription;

  @Column(name = "canonical_url", length = 255)
  String canonicalUrl;

  @Column(name = "meta_keywords", length = 255)
  String metaKeywords;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  BlogPostStatus status = BlogPostStatus.DRAFT;

  @Column(name = "showcase", nullable = false)
  boolean showcase = false;

  @Lob
  @Column(name = "showcase_payload")
  String showcasePayload;

  @Column(name = "published_at")
  LocalDateTime publishedAt;

  @Column(name = "created_at", nullable = false)
  LocalDateTime createdAt;

  @Column(name = "updated_at")
  LocalDateTime updatedAt;

  @ManyToMany
  @JoinTable(
      name = "blog_post_categories",
      joinColumns = @JoinColumn(name = "post_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  Set<BlogCategory> categories = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "blog_post_tags",
      joinColumns = @JoinColumn(name = "post_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id"))
  Set<BlogTag> tags = new HashSet<>();

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  Set<BlogComment> comments = new LinkedHashSet<>();

  @PrePersist
  void onCreate() {
    LocalDateTime now = LocalDateTime.now();
    if (createdAt == null) {
      createdAt = now;
    }
    if (updatedAt == null) {
      updatedAt = now;
    }
  }

  @PreUpdate
  void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
