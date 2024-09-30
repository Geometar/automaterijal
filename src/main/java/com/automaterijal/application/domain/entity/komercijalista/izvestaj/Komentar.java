package com.automaterijal.application.domain.entity.komercijalista.izvestaj;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Komentar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column String komentar;

  @Column Long firma;

  @Column LocalDateTime datumKreiranja;

  @Column LocalDateTime podsetnik;

  @Column Integer ppid;
}
