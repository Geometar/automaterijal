package com.automaterijal.application.domain.entity.external;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partner_b2b_id")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerB2bId {
    @Id
    Integer ppid;
    @Column
    String uuid;
}
