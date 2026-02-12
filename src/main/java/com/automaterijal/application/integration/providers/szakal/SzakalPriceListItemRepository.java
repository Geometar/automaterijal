package com.automaterijal.application.integration.providers.szakal;

import com.automaterijal.application.integration.providers.szakal.model.SzakalPriceListItem;
import com.automaterijal.application.integration.providers.szakal.model.SzakalPriceListItemId;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SzakalPriceListItemRepository
    extends JpaRepository<SzakalPriceListItem, SzakalPriceListItemId> {
  List<SzakalPriceListItem> findByGlidIn(Collection<String> glids);
}
