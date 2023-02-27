package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.entity.roba.RobaCene;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobaCeneRepository extends JpaRepository<RobaCene, Long> {

  Optional<RobaCene> findByMagacinidAndRobaid(Long magacinId, Long robaId);

  List<RobaCene> findByMagacinidAndRobaidIn(Long magacinId, List<Long> robaId);
}
