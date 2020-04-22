package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.entity.roba.RobaAplikacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobaAplikacijaRepository extends JpaRepository<RobaAplikacija, Long> {
    List<RobaAplikacija> findByRobaId(Long robaId);
}
