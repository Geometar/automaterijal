package com.automaterijal.application.domain.repository.external;

import com.automaterijal.application.domain.entity.external.PartnerB2bProizvodjac;
import com.automaterijal.application.domain.entity.external.PartnerB2bProizvodjacId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerB2bProizvodjacRepository extends JpaRepository<PartnerB2bProizvodjac, PartnerB2bProizvodjacId> {

    List<PartnerB2bProizvodjac> findByProizvodjacKljuceviPpid(Integer ppid);

}
