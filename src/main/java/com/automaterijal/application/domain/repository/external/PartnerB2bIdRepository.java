package com.automaterijal.application.domain.repository.external;

import com.automaterijal.application.domain.entity.external.PartnerB2bId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerB2bIdRepository extends JpaRepository<PartnerB2bId, Integer> {

    Optional<PartnerB2bId> findByUuid(String uuid);

}
