package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.LogWeb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogWebRepository extends JpaRepository<LogWeb, Long> {

    Page<LogWeb> findByPpidOrderByVremePretrageDescIdDesc(Integer ppid, Pageable pageable);

}
