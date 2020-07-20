package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.PodGrupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PodGrupaRepository extends JpaRepository<PodGrupa, Integer> {

    List<PodGrupa> findByPodGrupaIdIn(Collection<Integer> podGrupaKljucevi);

    List<PodGrupa> findByNazivIn(String naziv);

    List<PodGrupa> findByNazivIn(List<String> naziv);

    List<PodGrupa> findByGrupaId(String grupaId);

}
