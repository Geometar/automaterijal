package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.entity.roba.Roba;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {

  Page<Roba> findByStanjeGreaterThan(double stanje, Pageable pageable);
  
  Page<Roba> findByGrupaidInAndStanjeGreaterThan(Collection<String> ids, double stanje,
      Pageable pageable);

  List<Roba> findByPodgrupaidIn(Collection<Integer> ids);

  Roba findByKatbrAndProizvodjacProidInAndStanjeGreaterThan(String katBr, List<String> proids,
      double stanje);

  List<Roba> findByKatbr(String katBr);

  List<Roba> findByRobaidIn(List<Long> robaId);

  Page<Roba> findByRobaidIn(Set<Long> robaId, Pageable pageable);
}

