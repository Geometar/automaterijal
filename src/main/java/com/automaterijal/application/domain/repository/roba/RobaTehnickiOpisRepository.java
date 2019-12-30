package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.entity.roba.RobaOpis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobaTehnickiOpisRepository extends JpaRepository<RobaOpis, Integer> {
    List<RobaOpis> findByRobaId(Integer robaId);
}
