package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Roba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {

    List<Roba> findByKatbrContainingOrKatbrproContaining(String katbr, String katbrpro);
    Page<Roba> findByStanjeGreaterThan(double stanje, Pageable pageable);
}

