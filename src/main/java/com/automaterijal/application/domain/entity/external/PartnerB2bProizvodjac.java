package com.automaterijal.application.domain.entity.external;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "partner_b2b_proizvodjac")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerB2bProizvodjac {

    @EmbeddedId
    PartnerB2bProizvodjacId proizvodjacKljucevi;

}
