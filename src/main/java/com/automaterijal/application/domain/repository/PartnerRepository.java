package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    Partner findByWebKorisnik(String webKorisnik);
    Optional<Partner> findByEmail(String email);
}
