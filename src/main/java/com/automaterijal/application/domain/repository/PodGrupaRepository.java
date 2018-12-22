package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.PodGrupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PodGrupaRepository extends JpaRepository<PodGrupa, Long> {

    Optional<PodGrupa> findByPodGrupaIdAndGrupaId(final int podGrupaId, final String grupaId);
    List<PodGrupa> findByNazivIn(final String naziv);
    List<PodGrupa> findByNazivIn(final List<String> naziv);
}
