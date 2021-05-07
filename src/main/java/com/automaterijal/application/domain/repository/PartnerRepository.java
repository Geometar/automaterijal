package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    Optional<Partner> findByWebKorisnikAndWebStatusGreaterThan(String webKorisnik, Integer webStatus);

    Optional<Partner> findByWebKorisnik(String webKorisnik);

    Optional<Partner> findByEmail(String email);

    Optional<Partner> findByPpid(Integer ppid);

    List<Partner> findByPrivilegijeGreaterThanOrderByNazivAsc(Integer privilergije);

    Page<Partner> findAllByOrderByUsersLastLoginDesc(PageRequest pageRequest);
}
