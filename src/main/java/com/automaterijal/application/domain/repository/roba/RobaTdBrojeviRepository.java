package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.entity.roba.RobaBrojevi;
import com.automaterijal.application.domain.entity.roba.RobaBrojeviId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobaTdBrojeviRepository extends JpaRepository<RobaBrojevi, RobaBrojeviId> {

    List<RobaBrojevi> findByIdRobaId(Long robaId);
}
