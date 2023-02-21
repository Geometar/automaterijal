package com.automaterijal.application.domain.repository.tecdoc;

import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecDocAtributiRepository extends JpaRepository<TecDocAtributi, Integer> {

  List<TecDocAtributi> findByRobaId(Long robaId);

  List<TecDocAtributi> findByRobaIdIn(List<Long> robaId);

}
