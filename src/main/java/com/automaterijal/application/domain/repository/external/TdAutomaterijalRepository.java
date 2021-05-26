package com.automaterijal.application.domain.repository.external;

import com.automaterijal.application.domain.entity.external.TdAutomaterijal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TdAutomaterijalRepository extends JpaRepository<TdAutomaterijal, Integer> {
}
