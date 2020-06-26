package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.dashboard.DashbaordGrupa;
import com.automaterijal.application.domain.entity.dashboard.RobaDashboard;
import com.automaterijal.application.domain.entity.roba.Roba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobaDashboardRepository extends JpaRepository<RobaDashboard, Long> {
    List<RobaDashboard> findByGrupa(DashbaordGrupa dashbaordGrupa);
}
