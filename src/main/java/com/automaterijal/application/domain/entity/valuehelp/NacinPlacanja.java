package com.automaterijal.application.domain.entity.valuehelp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "nacupl")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NacinPlacanja {

    @Id
    @GeneratedValue
    @Column(name = "nuid")
    Integer id;

    @Column
    String naziv;
}
