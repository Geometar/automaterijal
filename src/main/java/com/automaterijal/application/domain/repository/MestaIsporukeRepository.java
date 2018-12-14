package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.MestaIsporuke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MestaIsporukeRepository extends JpaRepository<MestaIsporuke, Integer> {
}
