package com.automaterijal.application.domain.repository.weborder;

import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import java.sql.Timestamp;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebOrderHeaderRepository extends JpaRepository<WebOrderHeader, Integer> {

  Page<WebOrderHeader> findByDateSentGreaterThanAndDateSentLessThanOrderByDateSentDesc(
      Pageable pageable, Timestamp vremeOd, Timestamp vremeDo);

  Page<WebOrderHeader> findByDateSentGreaterThanAndDateSentLessThanAndInternalOrderOrderByDateSentDesc(
      Pageable pageable, Timestamp vremeOd, Timestamp vremeDo, Integer internalOrder);

  long countByDateSentGreaterThanAndDateSentLessThanAndErpExported(
      Timestamp vremeOd, Timestamp vremeDo, Integer erpExported);

  long countByDateSentGreaterThanAndDateSentLessThanAndErpExportedAndInternalOrder(
      Timestamp vremeOd, Timestamp vremeDo, Integer erpExported, Integer internalOrder);

  Page<WebOrderHeader> findByPpidAndDateSentGreaterThanAndDateSentLessThanOrderByDateSentDesc(
      Integer ppid, Pageable pageable, Timestamp vremeOd, Timestamp vremeDo);

  Page<WebOrderHeader>
      findByPpidAndDateSentGreaterThanAndDateSentLessThanAndInternalOrderOrderByDateSentDesc(
          Integer ppid, Pageable pageable, Timestamp vremeOd, Timestamp vremeDo, Integer internalOrder);

  long countByPpidAndDateSentGreaterThanAndDateSentLessThanAndErpExported(
      Integer ppid, Timestamp vremeOd, Timestamp vremeDo, Integer erpExported);

  long countByPpidAndDateSentGreaterThanAndDateSentLessThanAndErpExportedAndInternalOrder(
      Integer ppid, Timestamp vremeOd, Timestamp vremeDo, Integer erpExported, Integer internalOrder);

  Optional<WebOrderHeader> findByPpidAndId(Integer ppid, Integer id);

  Optional<WebOrderHeader> findFirstByPpidOrderByOrderIdDesc(Integer ppid);
}
