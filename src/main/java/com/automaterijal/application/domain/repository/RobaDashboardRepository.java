package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.dashboard.DashbaordGrupa;
import com.automaterijal.application.domain.entity.dashboard.RobaDashboard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobaDashboardRepository extends JpaRepository<RobaDashboard, Long> {

  List<RobaDashboard> findByGrupa(DashbaordGrupa dashbaordGrupa);
}
