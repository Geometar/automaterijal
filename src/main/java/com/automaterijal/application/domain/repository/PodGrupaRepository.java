package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.PodGrupa;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodGrupaRepository extends JpaRepository<PodGrupa, Integer> {

  List<PodGrupa> findByPodGrupaIdIn(Collection<Integer> podGrupaKljucevi);
}
