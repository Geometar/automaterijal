package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Proizvodjac;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProizvodjacRepository extends JpaRepository<Proizvodjac, String> {
  List<Proizvodjac> findAllByOrderByNazivAsc();

  List<Proizvodjac> findByProidIn(Collection<String> kljucevi);
}
