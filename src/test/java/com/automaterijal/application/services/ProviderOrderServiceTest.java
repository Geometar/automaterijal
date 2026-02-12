package com.automaterijal.application.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import com.automaterijal.application.integration.registry.ProviderOrderRegistry;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderOrderLineResult;
import com.automaterijal.application.integration.shared.ProviderOrderProvider;
import com.automaterijal.application.integration.shared.ProviderOrderRequest;
import com.automaterijal.application.integration.shared.ProviderOrderResult;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class ProviderOrderServiceTest {

  @Test
  void nonAdminSzakalFailedLineIsMarkedUnavailableAndMessageIsGeneric() {
    ProviderOrderResult result =
        ProviderOrderResult.builder()
            .status(ProviderCallStatus.ERROR)
            .providerOrderId("sz-100")
            .lineResults(
                List.of(
                    ProviderOrderLineResult.builder()
                        .webOrderItemId(11)
                        .confirmedQuantity(0)
                        .backorder(true)
                        .message("Szakal token invalid / not found")
                        .build()))
            .build();

    ProviderOrderService service =
        new ProviderOrderService(new ProviderOrderRegistry(List.of(new FixedProvider("szakal", result))));

    WebOrderItem item = buildProviderItem(11, "szakal");
    item.setProviderAvailable(true);
    item.setProviderTotalQuantity(7);
    item.setProviderWarehouseQuantity(7);

    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    service.placeOrders(header, buildPartner(false));

    assertThat(header.getExtOrderId()).isEqualTo("sz-100");
    assertThat(item.getPotvrdjenaKolicina()).isEqualTo(0.0);
    assertThat(item.getProviderBackorder()).isTrue();
    assertThat(item.getProviderAvailable()).isFalse();
    assertThat(item.getProviderTotalQuantity()).isZero();
    assertThat(item.getProviderWarehouseQuantity()).isZero();
    assertThat(item.getProviderMessage()).isEqualTo("Artikal trenutno nije dostupan u eksternom magacinu.");
  }

  @Test
  void adminSzakalKeepsRawProviderMessage() {
    ProviderOrderResult result =
        ProviderOrderResult.builder()
            .status(ProviderCallStatus.ERROR)
            .lineResults(
                List.of(
                    ProviderOrderLineResult.builder()
                        .webOrderItemId(12)
                        .confirmedQuantity(0)
                        .backorder(true)
                        .message("Szakal token invalid / not found")
                        .build()))
            .build();

    ProviderOrderService service =
        new ProviderOrderService(new ProviderOrderRegistry(List.of(new FixedProvider("szakal", result))));

    WebOrderItem item = buildProviderItem(12, "szakal");
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    service.placeOrders(header, buildPartner(true));

    assertThat(item.getProviderMessage()).isEqualTo("Szakal token invalid / not found");
  }

  @Test
  void nonAdminNonSzakalKeepsRawProviderMessage() {
    ProviderOrderResult result =
        ProviderOrderResult.builder()
            .status(ProviderCallStatus.ERROR)
            .lineResults(
                List.of(
                    ProviderOrderLineResult.builder()
                        .webOrderItemId(13)
                        .confirmedQuantity(0)
                        .backorder(true)
                        .message("Febi unavailable")
                        .build()))
            .build();

    ProviderOrderService service =
        new ProviderOrderService(new ProviderOrderRegistry(List.of(new FixedProvider("febi-stock", result))));

    WebOrderItem item = buildProviderItem(13, "febi-stock");
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    service.placeOrders(header, buildPartner(false));

    assertThat(item.getProviderMessage()).isEqualTo("Febi unavailable");
  }

  @Test
  void nonAdminSzakalPartialConfirmationGetsGenericPartialMessage() {
    ProviderOrderResult result =
        ProviderOrderResult.builder()
            .status(ProviderCallStatus.SUCCESS)
            .lineResults(
                List.of(
                    ProviderOrderLineResult.builder()
                        .webOrderItemId(14)
                        .confirmedQuantity(1)
                        .backorder(true)
                        .message("Partial confirmation 1/2")
                        .build()))
            .build();

    ProviderOrderService service =
        new ProviderOrderService(new ProviderOrderRegistry(List.of(new FixedProvider("szakal", result))));

    WebOrderItem item = buildProviderItem(14, "szakal");
    item.setKolicina(2.0);
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    service.placeOrders(header, buildPartner(false));

    assertThat(item.getPotvrdjenaKolicina()).isEqualTo(1.0);
    assertThat(item.getProviderBackorder()).isTrue();
    assertThat(item.getProviderMessage()).isEqualTo("Delimicno potvrdjeno iz eksternog magacina.");
  }

  @Test
  void existingExtOrderIdIsNotOverwritten() {
    ProviderOrderResult result =
        ProviderOrderResult.builder()
            .status(ProviderCallStatus.SUCCESS)
            .providerOrderId("new-provider-id")
            .lineResults(
                List.of(
                    ProviderOrderLineResult.builder()
                        .webOrderItemId(15)
                        .confirmedQuantity(1)
                        .backorder(false)
                        .message("Ordered")
                        .build()))
            .build();

    ProviderOrderService service =
        new ProviderOrderService(new ProviderOrderRegistry(List.of(new FixedProvider("szakal", result))));

    WebOrderItem item = buildProviderItem(15, "szakal");
    WebOrderHeader header = new WebOrderHeader();
    header.setExtOrderId("existing-id");
    header.setItems(List.of(item));

    service.placeOrders(header, buildPartner(false));

    assertThat(header.getExtOrderId()).isEqualTo("existing-id");
    assertThat(item.getProviderMessage()).isEqualTo("Porudzbina je potvrdjena iz eksternog magacina.");
  }

  @Test
  void successWithoutLineResultsAndNoEligibleMessageMarksProviderItemsAsUnavailable() {
    ProviderOrderResult result =
        ProviderOrderResult.builder()
            .status(ProviderCallStatus.SUCCESS)
            .message("No eligible order positions for provider")
            .lineResults(List.of())
            .build();

    ProviderOrderService service =
        new ProviderOrderService(new ProviderOrderRegistry(List.of(new FixedProvider("febi-stock", result))));

    WebOrderItem item = buildProviderItem(16, "febi-stock");
    item.setProviderAvailable(true);
    item.setProviderTotalQuantity(8);
    item.setProviderWarehouseQuantity(8);
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    service.placeOrders(header, buildPartner(false));

    assertThat(item.getPotvrdjenaKolicina()).isEqualTo(0.0);
    assertThat(item.getProviderBackorder()).isTrue();
    assertThat(item.getProviderAvailable()).isFalse();
    assertThat(item.getProviderTotalQuantity()).isZero();
    assertThat(item.getProviderWarehouseQuantity()).isZero();
    assertThat(item.getProviderMessage()).isEqualTo("Eksterni magacin nije potvrdio trazene stavke.");
  }

  @Test
  void successWithoutLineResultsMarksRequestedAsConfirmed() {
    ProviderOrderResult result =
        ProviderOrderResult.builder()
            .status(ProviderCallStatus.SUCCESS)
            .message("Order accepted")
            .lineResults(List.of())
            .build();

    ProviderOrderService service =
        new ProviderOrderService(new ProviderOrderRegistry(List.of(new FixedProvider("szakal", result))));

    WebOrderItem item = buildProviderItem(17, "szakal");
    item.setKolicina(2.0);
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    service.placeOrders(header, buildPartner(false));

    assertThat(item.getPotvrdjenaKolicina()).isEqualTo(2.0);
    assertThat(item.getProviderBackorder()).isFalse();
    assertThat(item.getProviderMessage()).isEqualTo("Porudzbina je potvrdjena iz eksternog magacina.");
  }

  @Test
  void secondSubmitSkipsAlreadyProcessedProviderItems() {
    ProviderOrderResult result =
        ProviderOrderResult.builder()
            .status(ProviderCallStatus.SUCCESS)
            .lineResults(
                List.of(
                    ProviderOrderLineResult.builder()
                        .webOrderItemId(18)
                        .confirmedQuantity(1)
                        .backorder(false)
                        .message("ok")
                        .build()))
            .build();

    CountingProvider provider = new CountingProvider("febi-stock", result);
    ProviderOrderService service =
        new ProviderOrderService(new ProviderOrderRegistry(List.of(provider)));

    WebOrderItem item = buildProviderItem(18, "febi-stock");
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    service.placeOrders(header, buildPartner(false));
    service.placeOrders(header, buildPartner(false));

    assertThat(provider.callCount()).isEqualTo(1);
    assertThat(item.getPotvrdjenaKolicina()).isEqualTo(1.0);
  }

  private static WebOrderItem buildProviderItem(int id, String providerKey) {
    WebOrderItem item = new WebOrderItem();
    item.setId(id);
    item.setItemSource(OrderItemSource.PROVIDER);
    item.setProviderKey(providerKey);
    item.setKolicina(1.0);
    return item;
  }

  private static Partner buildPartner(boolean internal) {
    Partner partner = new Partner();
    partner.setPpid(internal ? 3456 : 9999);
    partner.setPrivilegije(internal ? PartnerPrivilegeUtils.ADMIN_PRIVILEGIJE : 0);
    return partner;
  }

  private static final class FixedProvider implements ProviderOrderProvider {

    private final String name;
    private final ProviderOrderResult result;

    private FixedProvider(String name, ProviderOrderResult result) {
      this.name = name;
      this.result = result;
    }

    @Override
    public String providerName() {
      return name;
    }

    @Override
    public ProviderOrderResult placeOrder(ProviderOrderRequest request) {
      return result;
    }
  }

  private static final class CountingProvider implements ProviderOrderProvider {

    private final String name;
    private final ProviderOrderResult result;
    private final AtomicInteger calls = new AtomicInteger();

    private CountingProvider(String name, ProviderOrderResult result) {
      this.name = name;
      this.result = result;
    }

    int callCount() {
      return calls.get();
    }

    @Override
    public String providerName() {
      return name;
    }

    @Override
    public ProviderOrderResult placeOrder(ProviderOrderRequest request) {
      calls.incrementAndGet();
      return result;
    }
  }
}
