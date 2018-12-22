package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, String> {
    List<Grupa> findByNaziv(String naziv);
}
