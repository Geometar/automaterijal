package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.GrupaDozvoljena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupaDozvoljenaRepository extends JpaRepository<GrupaDozvoljena, String> {

    List<GrupaDozvoljena> findAllByOrderByNaziv();
}
