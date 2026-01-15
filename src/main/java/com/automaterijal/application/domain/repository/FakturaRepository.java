package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.dto.admin.HogwartsOrderRow;
import com.automaterijal.application.domain.dto.admin.HogwartsRevenueAggRow;
import com.automaterijal.application.domain.entity.Faktura;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Integer> {

    Page<Faktura> findByDataSentGreaterThanAndDataSentLessThanOrderByDataSentDesc(Pageable pageable, Timestamp vremeOd, Timestamp vremeDo);

    Page<Faktura> findByPpidAndDataSentGreaterThanAndDataSentLessThanOrderByDataSentDesc(Integer ppid, Pageable pageable, Timestamp vremeOd, Timestamp vremeDo);

    Optional<Faktura> findByPpidAndId(Integer ppid, Integer id);

    Optional<Faktura> findFirstByPpidOrderByOrderIdDesc(Integer ppid);

    long countByStatus(Integer status);

    long countByStatusAndLastUpdateAfter(Integer status, Timestamp lastUpdate);

    @Query(
        "select min(f.lastUpdate) from Faktura f "
            + "where f.status = :status and f.lastUpdate >= :since")
    Timestamp findOldestUpdateByStatusSince(
        @Param("status") Integer status, @Param("since") Timestamp since);

    @Query(
        "select f.lastUpdate from Faktura f "
            + "where f.status = :status and f.lastUpdate is not null and f.lastUpdate >= :since")
    List<Timestamp> findUpdatesByStatusSince(
        @Param("status") Integer status, @Param("since") Timestamp since);

    @Query(
        "select new com.automaterijal.application.domain.dto.admin.HogwartsOrderRow("
            + "f.id, f.orderId, f.ppid, f.status, f.lastUpdate, f.iznosNarucen) "
            + "from Faktura f "
            + "where f.status in :statuses and f.lastUpdate is not null and f.lastUpdate >= :since "
            + "order by f.lastUpdate asc")
    List<HogwartsOrderRow> findStuckOrders(
        @Param("statuses") List<Integer> statuses,
        @Param("since") Timestamp since,
        Pageable pageable);

    @Query(
        "select "
            + "count(f) as orders, "
            + "coalesce(sum(f.iznosNarucen), 0) as revenue, "
            + "count(distinct f.ppid) as activePartners "
            + "from Faktura f "
            + "where f.dataSent is not null and f.dataSent >= :from and f.dataSent < :to")
    HogwartsRevenueAggRow fetchRevenueAgg(@Param("from") Timestamp from, @Param("to") Timestamp to);
}
