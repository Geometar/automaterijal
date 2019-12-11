package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.roba.RobaCene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RobaCeneRepository extends JpaRepository<RobaCene, Long> {

    Optional<RobaCene> findByMagacinidAndRobaid(Long magacinId, Long robaId);
}
