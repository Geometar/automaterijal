package com.automaterijal.application.domain.entity.valuehelp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Status {

    @Id
    @GeneratedValue
    @Column
    Integer id;

    @Column
    String opis;
}
