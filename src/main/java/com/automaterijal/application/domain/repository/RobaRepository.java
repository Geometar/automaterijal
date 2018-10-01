package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Roba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {

}
