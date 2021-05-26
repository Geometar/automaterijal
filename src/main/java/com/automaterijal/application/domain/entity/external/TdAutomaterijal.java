package com.automaterijal.application.domain.entity.external;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "td_automaterijal")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TdAutomaterijal {

    @Id
    @Column
    Integer id;

    @Column(name = "td_naziv ")
    String tdN;

    @Column(name = "proid")
    String proid;

}
