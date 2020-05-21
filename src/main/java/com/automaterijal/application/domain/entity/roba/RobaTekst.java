package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaTekst {

    @Id
    @Column(name = "robaid")
    Long robaid;

    @Column(name = "tekst")
    String tekst;

}
