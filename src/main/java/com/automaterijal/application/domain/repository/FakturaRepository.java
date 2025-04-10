package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.Faktura;
import java.sql.Timestamp;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Integer> {

    Page<Faktura> findByDataSentGreaterThanAndDataSentLessThanOrderByDataSentDesc(Pageable pageable, Timestamp vremeOd, Timestamp vremeDo);

    Page<Faktura> findByPpidAndDataSentGreaterThanAndDataSentLessThanOrderByDataSentDesc(Integer ppid, Pageable pageable, Timestamp vremeOd, Timestamp vremeDo);

    Optional<Faktura> findByPpidAndId(Integer ppid, Integer id);

    Optional<Faktura> findFirstByPpidOrderByOrderIdDesc(Integer ppid);
}
