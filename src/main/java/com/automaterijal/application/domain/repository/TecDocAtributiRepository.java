package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecDocAtributiRepository extends JpaRepository<TecDocAtributi, Integer> {

    List<TecDocAtributi> findByRobaId(Long robaId);

}
