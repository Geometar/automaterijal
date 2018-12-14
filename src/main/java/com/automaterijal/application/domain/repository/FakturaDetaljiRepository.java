package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.FakturaDetalji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FakturaDetaljiRepository extends JpaRepository<FakturaDetalji, Integer> {

    List<FakturaDetalji> findByOrderId(Integer orderId);
    List<FakturaDetalji> findByPpidAndOrderId(Integer ppid, Integer orderId);
}
