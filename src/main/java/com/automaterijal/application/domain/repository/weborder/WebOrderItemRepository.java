package com.automaterijal.application.domain.repository.weborder;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebOrderItemRepository extends JpaRepository<WebOrderItem, Integer> {
  List<WebOrderItem> findByHeaderId(Integer webOrderId);

  List<WebOrderItem> findByItemSource(OrderItemSource itemSource);
}
