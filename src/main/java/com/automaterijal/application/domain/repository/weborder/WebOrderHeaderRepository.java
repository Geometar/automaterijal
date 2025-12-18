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

  long countByDateSentGreaterThanAndDateSentLessThanAndErpExported(
      Timestamp vremeOd, Timestamp vremeDo, Integer erpExported);

  Page<WebOrderHeader> findByPpidAndDateSentGreaterThanAndDateSentLessThanOrderByDateSentDesc(
      Integer ppid, Pageable pageable, Timestamp vremeOd, Timestamp vremeDo);

  long countByPpidAndDateSentGreaterThanAndDateSentLessThanAndErpExported(
      Integer ppid, Timestamp vremeOd, Timestamp vremeDo, Integer erpExported);

  Optional<WebOrderHeader> findByPpidAndId(Integer ppid, Integer id);

  Optional<WebOrderHeader> findFirstByPpidOrderByOrderIdDesc(Integer ppid);
}
