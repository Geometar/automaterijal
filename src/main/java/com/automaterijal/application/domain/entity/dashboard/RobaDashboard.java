package com.automaterijal.application.domain.entity.dashboard;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "roba_dashboard")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDashboard {

    @Id
    @Column(name = "roba_id")
    Long robaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "grupa")
    DashbaordGrupa grupa;
}
