package com.automaterijal.application.domain.entity.external;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PartnerB2bProizvodjacId implements Serializable {
    Integer ppid;
    String proid;
}
