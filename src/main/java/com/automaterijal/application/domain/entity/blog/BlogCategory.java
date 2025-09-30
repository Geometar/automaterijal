package com.automaterijal.application.domain.entity.blog;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "blog_category")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false, length = 120)
  String name;

  @Column(nullable = false, length = 160, unique = true)
  String slug;

  @Column(length = 320)
  String description;

  @Column(name = "created_at", nullable = false)
  LocalDateTime createdAt;

  @ManyToMany(mappedBy = "categories")
  Set<BlogPost> posts = new HashSet<>();

  @PrePersist
  void onCreate() {
    if (createdAt == null) {
      createdAt = LocalDateTime.now();
    }
  }
}
