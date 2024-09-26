package com.automaterijal.application.domain.entity.valuehelp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;

@Entity
@Table(name = "nacisp")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NacinPrevoza {

    @Id
    @GeneratedValue
    @Column(name = "niid")
    Integer id;

    @Column
    String naziv;

}
