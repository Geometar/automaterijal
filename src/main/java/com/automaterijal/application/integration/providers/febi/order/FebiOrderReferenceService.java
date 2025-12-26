package com.automaterijal.application.integration.providers.febi.order;

import com.automaterijal.application.integration.providers.febi.FebiAuthClient;
import com.automaterijal.application.integration.providers.febi.order.model.FebiAddressDto;
import com.automaterijal.application.integration.providers.febi.order.model.FebiShippingConditionDto;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FebiOrderReferenceService {

  FebiAuthClient authClient;
  FebiOrderClient orderClient;

  public List<FebiAddressDto> fetchShipToAddresses() {
    String token = authClient.getAccessToken();
    return orderClient.fetchShipToAddresses(token);
  }

  public List<FebiAddressDto> fetchSoldToAddresses() {
    String token = authClient.getAccessToken();
    return orderClient.fetchSoldToAddresses(token);
  }

  public List<FebiShippingConditionDto> fetchShippingConditions() {
    String token = authClient.getAccessToken();
    return orderClient.fetchShippingConditions(token);
  }
}
