package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.entity.roba.Roba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {

    Page<Roba> findByStanjeGreaterThan(double stanje, Pageable pageable);

    List<Roba> findByStanjeGreaterThan(double stanje);

    Page<Roba> findByGrupaidInAndStanjeGreaterThan(Collection<String> ids, double stanje, Pageable pageable);

    List<Roba> findByGrupaidInAndStanjeGreaterThan(Collection<String> ids, double stanje);

    List<Roba> findByPodgrupaidInAndStanjeGreaterThan(Collection<Integer> ids, double stanje);

    List<Roba> findByPodgrupaidIn(Collection<Integer> ids);

    Roba findByKatbrAndProizvodjacProidInAndStanjeGreaterThan(String katBr, List<String> proids, double stanje);

    List<Roba> findByKatbr(String katBr);
}

