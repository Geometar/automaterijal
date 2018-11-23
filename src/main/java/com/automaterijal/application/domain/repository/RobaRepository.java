package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Roba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {

    Page<Roba> findByStanjeGreaterThan(double stanje, Pageable pageable);

    Page<Roba> findByRobaidIn(Collection<Long> ids, Pageable pageable);
    Page<Roba> findByRobaidInAndPodgrupaidIn(Collection<Long> ids, Collection<Integer> podGrupe, Pageable pageable);
    Page<Roba> findByRobaidInAndPodgrupaidInAndStanjeGreaterThan(Collection<Long> ids, Collection<Integer> podGrupe, double stanje, Pageable pageable);
    Page<Roba> findByRobaidInAndProid(Collection<Long> ids, String proId, Pageable pageable);
    Page<Roba> findByRobaidInAndProidAndPodgrupaidIn(Collection<Long> ids, String proId, Collection<Integer> podGrupe, Pageable pageable);
    Page<Roba> findByRobaidInAndProidAndPodgrupaidInAndStanjeGreaterThan(Collection<Long> ids, String proId, Collection<Integer> podGrupe, double stanje, Pageable pageable);
    Page<Roba> findByRobaidInAndStanjeGreaterThan(Collection<Long> ids, double stanje, Pageable pageable);
    Page<Roba> findByRobaidInAndStanjeGreaterThanAndProid(Collection<Long> ids, double stanje, String proId, Pageable pageable);

    List<Roba> findByKatbrIn(Collection<String> katBr);
    List<Roba> findByKatbrContainingOrKatbrproContaining(String katbr, String katbrpro);

    List<Roba> findByProid(String proId);

    //
    List<Roba> findByGrupaidIn(Collection<String> ids);
    Page<Roba> findByGrupaidInAndStanjeGreaterThan(Collection<String> ids, double stanje, Pageable pageable);
    List<Roba> findByGrupaidInAndStanjeGreaterThan(Collection<String> ids, double stanje);
    Page<Roba> findByRobaidInAndProidAndGrupaidIn(Collection<Long> ids, String proId, Collection<String> grupeId, Pageable pageable);
    Page<Roba> findByRobaidInAndGrupaidIn(Collection<Long> ids, Collection<String> podGrupe, Pageable pageable);
    Page<Roba> findByRobaidInAndProidAndGrupaidInAndStanjeGreaterThan(Collection<Long> ids, String proId, Collection<String> grupeId, double stanje, Pageable pageable);
    Page<Roba> findByRobaidInAndGrupaidInAndStanjeGreaterThan(Collection<Long> ids, Collection<String> grupeId, double stanje, Pageable pageable);

    List<Roba> findByPodgrupaidIn(Collection<Integer> ids);
    Page<Roba> findByPodgrupaidInAndStanjeGreaterThan(Collection<Integer> ids, double stanje, Pageable pageable);
    List<Roba> findByPodgrupaidInAndStanjeGreaterThan(Collection<Integer> ids, double stanje);
}

