package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {

    List<Komentar> findByPodsetnik(Timestamp podsetnik);
}
