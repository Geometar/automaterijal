package com.automaterijal.application.domain.entity.tecdoc;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Persistirana mapa iz TecDoc {@code generic_article_id} u internu {@code podgrupa_id}.
 *
 * <p>Namena: omogućava da external-only artikli (koji nisu u našoj bazi) dobiju interne kategorije
 * (grupa/podgrupa) radi filtriranja i prikaza na FE.
 *
 * <p>Napomena: tabela je namerno bez foreign key ograničenja (ERP je izvor podgrupa), pa se ovde čuvaju
 * samo ključevi i status mapiranja.
 */
@Entity
@Table(name = "tecdoc_generic_article_mapping")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocGenericArticleMapping {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "generic_article_id", nullable = false, unique = true)
  Long genericArticleId;

  @Column(name = "tecdoc_category_name")
  String tecdocCategoryName;

  @Column(name = "podgrupa_id")
  Integer podgrupaId;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  Status status = Status.PENDING;

  @Enumerated(EnumType.STRING)
  @Column(name = "source", nullable = false)
  Source source = Source.AUTO;

  @Column(name = "confidence_count", nullable = false)
  Integer confidenceCount = 0;

  @Column(name = "last_seen_at")
  LocalDateTime lastSeenAt;

  @Column(name = "created_by")
  String createdBy;

  @Column(name = "updated_by")
  String updatedBy;

  @Column(name = "note")
  String note;

  public enum Status {
    ACTIVE,
    PENDING,
    CONFLICT
  }

  public enum Source {
    AUTO,
    MANUAL
  }
}
