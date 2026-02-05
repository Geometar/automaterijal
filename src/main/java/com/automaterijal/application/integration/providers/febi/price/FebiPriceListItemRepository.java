package com.automaterijal.application.integration.providers.febi.price;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FebiPriceListItemRepository
    extends JpaRepository<FebiPriceListItem, String> {
  List<FebiPriceListItem>
      findByNormalizedArticleNumberInOrNormalizedArticleNumberNoLeadingZerosIn(
          Collection<String> normalized, Collection<String> normalizedNoZeros);
}
