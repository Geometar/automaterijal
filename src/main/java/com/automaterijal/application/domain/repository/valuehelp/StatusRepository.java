package com.automaterijal.application.domain.repository.valuehelp;

import com.automaterijal.application.domain.entity.valuehelp.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
