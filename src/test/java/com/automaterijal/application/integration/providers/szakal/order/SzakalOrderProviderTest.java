package com.automaterijal.application.integration.providers.szakal.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.OrderItem;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.OrderResponse;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.TokenOrderRequest;
import com.automaterijal.application.integration.providers.szakal.SzakalProperties;
import com.automaterijal.application.integration.providers.szakal.SzakalStockCheckService;
import com.automaterijal.application.integration.providers.szakal.SzakalStockCheckService.StockCheckResult;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderOrderRequest;
import com.automaterijal.application.integration.shared.ProviderOrderResult;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SzakalOrderProviderTest {

  @Mock private SzakalApiClient apiClient;
  @Mock private SzakalStockCheckService stockCheckService;

  private SzakalProperties properties;
  private SzakalOrderProvider provider;

  @BeforeEach
  void setUp() {
    properties = new SzakalProperties();
    properties.setEnabled(true);
    properties.getOrder().setMode(SzakalProperties.OrderMode.LIVE);
    provider = new SzakalOrderProvider(apiClient, properties, stockCheckService);
  }

  @Test
  void disabledModeReturnsErrorAndSkipsApiCalls() {
    properties.getOrder().setMode(SzakalProperties.OrderMode.DISABLED);

    ProviderOrderResult result = provider.placeOrder(buildRequest(buildItem(1, 1, "tok-1", "2-1"), false));

    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.ERROR);
    assertThat(result.getMessage()).contains("disabled");
    verifyNoInteractions(apiClient);
    verifyNoInteractions(stockCheckService);
  }

  @Test
  void mockModeReturnsMockConfirmationWithoutApiCall() {
    properties.getOrder().setMode(SzakalProperties.OrderMode.MOCK);

    ProviderOrderResult result = provider.placeOrder(buildRequest(buildItem(2, 2, "tok-2", "2-2"), false));

    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.SUCCESS);
    assertThat(result.isMocked()).isTrue();
    assertThat(result.getProviderOrderId()).isEqualTo("mock-szakal-123");
    assertThat(result.getLineResults()).hasSize(1);
    assertThat(result.getLineResults().get(0).getConfirmedQuantity()).isEqualTo(2);
    verifyNoInteractions(apiClient);
  }

  @Test
  void liveModeUsesRefreshedTokenFromStockCheck() {
    WebOrderItem item = buildItem(3, 1, "old-token", "2-3");
    StockCheckResult stockCheck =
        new StockCheckResult(
            "old-token",
            "2-3",
            1,
            true,
            4,
            2,
            1,
            false,
            "new-token",
            new BigDecimal("10.00"),
            new BigDecimal("15.00"),
            "2026-02-10T13:00:00Z",
            BigDecimal.ZERO,
            "RSD");

    when(stockCheckService.check(anyList(), any())).thenReturn(List.of(stockCheck));
    when(apiClient.orderByToken(any()))
        .thenReturn(new OrderResponse(List.of(new OrderItem("ORD-1", 1, null, false, null, null, null))));

    ProviderOrderResult result = provider.placeOrder(buildRequest(item, false));

    ArgumentCaptor<TokenOrderRequest> captor = ArgumentCaptor.forClass(TokenOrderRequest.class);
    verify(apiClient).orderByToken(captor.capture());
    assertThat(captor.getValue().stockToken()).isEqualTo("new-token");
    assertThat(item.getProviderStockToken()).isEqualTo("new-token");
    assertThat(item.getProviderPackagingUnit()).isEqualTo(2);
    assertThat(item.getProviderAvailable()).isTrue();
    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.SUCCESS);
    assertThat(result.getProviderOrderId()).isEqualTo("ORD-1");
  }

  @Test
  void missingTokenAndGlidFailsLineWithoutApiCall() {
    WebOrderItem item = buildItem(4, 1, null, null);

    ProviderOrderResult result = provider.placeOrder(buildRequest(item, false));

    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.ERROR);
    assertThat(result.getLineResults()).hasSize(1);
    assertThat(result.getLineResults().get(0).getMessage()).contains("Missing Szakal stock token");
    verifyNoInteractions(apiClient);
    verifyNoInteractions(stockCheckService);
  }

  @Test
  void packagingUnitMismatchFailsBeforeStockAndApiCalls() {
    WebOrderItem item = buildItem(5, 3, "tok-5", "2-5");
    item.setProviderPackagingUnit(5);

    ProviderOrderResult result = provider.placeOrder(buildRequest(item, false));

    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.ERROR);
    assertThat(result.getLineResults()).hasSize(1);
    assertThat(result.getLineResults().get(0).getMessage()).contains("multiple of packaging unit 5");
    verifyNoInteractions(apiClient);
    verifyNoInteractions(stockCheckService);
  }

  @Test
  void providerUnavailableMapsToUnavailableStatus() {
    WebOrderItem item = buildItem(6, 1, "tok-6", "2-6");
    StockCheckResult stockCheck =
        new StockCheckResult(
            "tok-6",
            "2-6",
            1,
            true,
            1,
            1,
            1,
            false,
            "tok-6",
            new BigDecimal("20.00"),
            new BigDecimal("30.00"),
            "2026-02-10T13:00:00Z",
            BigDecimal.ZERO,
            "RSD");

    when(stockCheckService.check(anyList(), any())).thenReturn(List.of(stockCheck));
    when(apiClient.orderByToken(any())).thenThrow(new ProviderUnavailableException("Szakal down"));

    ProviderOrderResult result = provider.placeOrder(buildRequest(item, false));

    assertThat(result.getStatus()).isEqualTo(ProviderCallStatus.UNAVAILABLE);
    assertThat(result.getLineResults()).hasSize(1);
    assertThat(result.getLineResults().get(0).getConfirmedQuantity()).isEqualTo(0);
    assertThat(result.getLineResults().get(0).getBackorder()).isTrue();
    assertThat(result.getLineResults().get(0).getMessage()).contains("Szakal down");
  }

  private static ProviderOrderRequest buildRequest(WebOrderItem item, boolean requestMock) {
    WebOrderHeader header = new WebOrderHeader();
    header.setOrderId(123);
    header.setItems(List.of(item));
    item.setHeader(header);

    return ProviderOrderRequest.builder().header(header).items(List.of(item)).mock(requestMock).build();
  }

  private static WebOrderItem buildItem(int id, int quantity, String token, String glid) {
    WebOrderItem item = new WebOrderItem();
    item.setId(id);
    item.setItemSource(OrderItemSource.PROVIDER);
    item.setProviderKey("szakal");
    item.setKolicina((double) quantity);
    item.setProviderStockToken(token);
    item.setProviderProductId(glid);
    item.setBrand("BOSCH");
    return item;
  }
}
