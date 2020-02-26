package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.entity.roba.RobaMotor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobaMotorRepository extends JpaRepository<RobaMotor, Integer> {
}
