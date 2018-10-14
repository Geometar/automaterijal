package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Roba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {

    List<Roba> findByKatbrContainingOrKatbrproContaining(String katbr, String katbrpro);
    List<Roba> findByKatbrIn(Collection<String> katBr);
    Page<Roba> findByRobaidIn(Collection<Long> ids, Pageable pageable);
    Page<Roba> findByRobaidInAndProid(Collection<Long> ids, String proId, Pageable pageable);
    Page<Roba> findByRobaidInAndStanjeGreaterThan(Collection<Long> ids, double stanje, Pageable pageable);
    Page<Roba> findByRobaidInAndStanjeGreaterThanAndProid(Collection<Long> ids, double stanje, String proId, Pageable pageable);
}

