package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.entity.roba.Roba;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {

  Roba findByKatbrAndProizvodjacProidInAndStanjeGreaterThan(
      String katBr, List<String> proids, double stanje);

  List<Roba> findByRobaidIn(List<Long> robaId);
}
