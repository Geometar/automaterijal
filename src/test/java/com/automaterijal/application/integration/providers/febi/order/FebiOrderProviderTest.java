package com.automaterijal.application.integration.providers.febi.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import com.automaterijal.application.integration.providers.febi.FebiAuthClient;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderResponse;
import com.automaterijal.application.integration.providers.febi.price.FebiPriceService;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderOrderRequest;
import com.automaterijal.application.integration.shared.ProviderOrderResult;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

@ExtendWith(MockitoExtension.class)
class FebiOrderProviderTest {

  @Mock private FebiAuthClient authClient;
  @Mock private FebiOrderClient orderClient;
  @Mock private FebiPriceService priceService;
  @Mock private Environment environment;

  private FebiOrderProperties properties;
  private FebiOrderProvider provider;

  @BeforeEach
  void setUp() {
    properties = new FebiOrderProperties();
    properties.setMode(FebiOrderProperties.OrderMode.LIVE);
    properties.setDeliveryParty("0001001983");
    properties.setPickupDeliveryParty("0001003023");
    properties.setShippingCondition("S9");

    provider = new FebiOrderProvider(authClient, orderClient, properties, priceService, environment);
  }

  @Test
  void noItemsReturnsError() {
    ProviderOrderResult result = provider.placeOrder(ProviderOrderRequest.builder().items(List.of()).build());

    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.ERROR);
    assertThat(result.getMessage()).contains("No items");
    verifyNoInteractions(authClient);
    verifyNoInteractions(orderClient);
  }

  @Test
  void liveModePlacesOrderAndAppliesPackagingUnitRounding() {
    WebOrderItem item = febiItem(1, "A-100", 3.0);
    when(authClient.getAccessToken()).thenReturn("token");
    when(priceService.findPackagingUnit("A-100")).thenReturn(java.util.Optional.of(5));

    FebiOrderResponse response =
        FebiOrderResponse.builder()
            .customerOrder(
                FebiOrderResponse.CustomerOrder.builder()
                    .header(FebiOrderResponse.Header.builder().erpCustomerOrderNumber("FEBI-1001").build())
                    .positions(
                        List.of(
                            FebiOrderResponse.Position.builder()
                                .externalOrderPosition("1")
                                .confirmedQuantity(5)
                                .backorder(false)
                                .messages(List.of(FebiOrderResponse.Message.builder().text("ok").build()))
                                .build()))
                    .build())
            .build();
    when(orderClient.createOrder(any(FebiOrderRequest.class), any(String.class))).thenReturn(response);

    ProviderOrderResult result = provider.placeOrder(buildRequest(item, false));

    ArgumentCaptor<FebiOrderRequest> captor = ArgumentCaptor.forClass(FebiOrderRequest.class);
    verify(orderClient).createOrder(captor.capture(), any(String.class));
    FebiOrderRequest.Position position = captor.getValue().getCustomerOrder().getPositions().get(0);
    assertThat(position.getArticleNumber()).isEqualTo("A-100");
    assertThat(position.getRequestedQuantity()).isEqualTo(5);
    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.SUCCESS);
    assertThat(result.getProviderOrderId()).isEqualTo("FEBI-1001");
    assertThat(result.getLineResults()).hasSize(1);
    assertThat(result.getLineResults().get(0).getConfirmedQuantity()).isEqualTo(5);
    assertThat(result.getLineResults().get(0).getMessage()).isEqualTo("ok");
  }

  @Test
  void requestMockUsesSimulateAndMarksResultMocked() {
    WebOrderItem item = febiItem(2, "A-200", 2.0);
    when(authClient.getAccessToken()).thenReturn("token");
    when(priceService.findPackagingUnit("A-200")).thenReturn(java.util.Optional.of(1));

    FebiOrderResponse response =
        FebiOrderResponse.builder()
            .customerOrder(
                FebiOrderResponse.CustomerOrder.builder()
                    .header(FebiOrderResponse.Header.builder().erpCustomerOrderNumber("SIM-1").build())
                    .positions(
                        List.of(
                            FebiOrderResponse.Position.builder()
                                .externalOrderPosition("1")
                                .confirmedQuantity(2)
                                .backorder(false)
                                .build()))
                    .build())
            .build();
    when(orderClient.simulateOrder(any(FebiOrderRequest.class), any(String.class))).thenReturn(response);

    ProviderOrderResult result = provider.placeOrder(buildRequest(item, true));

    verify(orderClient).simulateOrder(any(FebiOrderRequest.class), any(String.class));
    assertThat(result.isMocked()).isTrue();
    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.SUCCESS);
  }

  @Test
  void rateLimitFromClientIsMappedToRateLimitedStatus() {
    WebOrderItem item = febiItem(3, "A-300", 1.0);
    when(authClient.getAccessToken()).thenReturn("token");
    when(priceService.findPackagingUnit("A-300")).thenReturn(java.util.Optional.of(1));
    when(orderClient.createOrder(any(FebiOrderRequest.class), any(String.class)))
        .thenThrow(new ProviderRateLimitException("too many requests"));

    ProviderOrderResult result = provider.placeOrder(buildRequest(item, false));

    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.RATE_LIMITED);
    assertThat(result.getMessage()).contains("too many requests");
  }

  private static ProviderOrderRequest buildRequest(WebOrderItem item, boolean mock) {
    WebOrderHeader header = new WebOrderHeader();
    header.setOrderId(9001);
    header.setItems(List.of(item));
    item.setHeader(header);

    return ProviderOrderRequest.builder().header(header).items(List.of(item)).mock(mock).build();
  }

  private static WebOrderItem febiItem(int id, String article, double quantity) {
    WebOrderItem item = new WebOrderItem();
    item.setId(id);
    item.setItemSource(OrderItemSource.PROVIDER);
    item.setProviderKey("febi-stock");
    item.setProviderArticleNumber(article);
    item.setCatalogNumber(article);
    item.setKolicina(quantity);
    item.setProviderAvailable(true);
    item.setProviderTotalQuantity(10);
    return item;
  }
}
