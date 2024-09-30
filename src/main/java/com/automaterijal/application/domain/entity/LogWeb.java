package com.automaterijal.application.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogWeb {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Integer ppid;

    @Column
    String proizvodjac;

    @Column
    String filter;

    @Column
    String pretraga;

    @Column
    LocalDateTime vremePretrage;
}
