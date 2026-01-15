package com.automaterijal.application.domain.repository.weborder;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.dto.admin.ProviderActivityRow;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WebOrderItemRepository extends JpaRepository<WebOrderItem, Integer> {
  List<WebOrderItem> findByHeaderId(Integer webOrderId);

  List<WebOrderItem> findByItemSource(OrderItemSource itemSource);

  @Query(
      "select "
          + "i.providerKey as providerKey, "
          + "max(i.insertDatetime) as lastItemAt, "
          + "sum(case when i.insertDatetime >= :since then 1 else 0 end) as last10dCount, "
          + "sum(case when i.insertDatetime >= :since and i.providerBackorder = true then 1 else 0 end) "
          + "as backorderCount10d, "
          + "sum(case when i.insertDatetime >= :since and i.providerMessage is not null "
          + "and i.providerMessage <> '' then 1 else 0 end) as messageCount10d "
          + "from WebOrderItem i "
          + "where i.providerKey is not null and i.providerKey <> '' and i.insertDatetime >= :since "
          + "group by i.providerKey")
  List<ProviderActivityRow> fetchProviderActivity(@Param("since") Timestamp since);
}
