package com.automaterijal.application.domain.entity.external;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
