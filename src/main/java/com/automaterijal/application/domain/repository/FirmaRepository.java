package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmaRepository extends JpaRepository<Firma, Long> {
}
