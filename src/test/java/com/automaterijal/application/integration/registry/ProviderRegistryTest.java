package com.automaterijal.application.integration.registry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderCapabilities;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProviderRegistryTest {

  @Mock private ProviderRoutingPolicy routingPolicy;

  private InventoryProvider febi;
  private InventoryProvider szakal;
  private ProviderRegistry registry;

  @BeforeEach
  void setUp() {
    febi = provider("febi-stock", 50, true, true, true);
    szakal = provider("szakal", 20, true, true, true);

    lenient().when(routingPolicy.priorityFor(eq(febi), any(), any())).thenReturn(100);
    lenient().when(routingPolicy.priorityFor(eq(szakal), any(), any())).thenReturn(20);
    lenient().when(routingPolicy.allows(any(InventoryProvider.class), any(), any())).thenReturn(true);

    registry = new ProviderRegistry(List.of(szakal, febi), routingPolicy);
  }

  @Test
  void findsInventoryProvidersByPriorityDescending() {
    List<InventoryProvider> providers =
        registry.findInventoryProviders(
            InventoryQuery.builder().brand("BOSCH").build(),
            ProviderRoutingContext.builder().purpose(ProviderRoutingPurpose.EXTERNAL_OFFER).build());

    assertThat(providers).extracting(InventoryProvider::providerName).containsExactly("febi-stock", "szakal");
  }

  @Test
  void excludesDisabledAndUnsupportedProviders() {
    InventoryProvider disabled = provider("disabled", 10, true, true, false);
    InventoryProvider notInventory = provider("order-only", 10, false, true, true);
    InventoryProvider unsupported = provider("unsupported", 10, true, false, true);
    when(routingPolicy.priorityFor(eq(disabled), any(), any())).thenReturn(90);
    when(routingPolicy.priorityFor(eq(notInventory), any(), any())).thenReturn(80);
    when(routingPolicy.priorityFor(eq(unsupported), any(), any())).thenReturn(70);

    ProviderRegistry local = new ProviderRegistry(List.of(disabled, notInventory, unsupported, febi), routingPolicy);

    List<InventoryProvider> providers =
        local.findInventoryProviders(InventoryQuery.builder().brand("FEBI").build(), null);

    assertThat(providers).extracting(InventoryProvider::providerName).containsExactly("febi-stock");
  }

  @Test
  void mapsProviderExceptionsToResultStatus() {
    InventoryProvider rateLimited =
        new BaseProvider("rate-limited", 10, true, true, true) {
          @Override
          public AvailabilityResult checkAvailability(InventoryQuery query) {
            throw new ProviderRateLimitException("slow down");
          }
        };
    InventoryProvider unavailable =
        new BaseProvider("down", 9, true, true, true) {
          @Override
          public AvailabilityResult checkAvailability(InventoryQuery query) {
            throw new ProviderUnavailableException("timeout");
          }
        };

    when(routingPolicy.priorityFor(eq(rateLimited), any(), any())).thenReturn(70);
    when(routingPolicy.priorityFor(eq(unavailable), any(), any())).thenReturn(60);

    ProviderRegistry local = new ProviderRegistry(List.of(rateLimited, unavailable), routingPolicy);

    List<AvailabilityResult> results =
        local.checkAvailability(InventoryQuery.builder().brand("ANY").build(), null);

    assertThat(results).hasSize(2);
    assertThat(results.get(0).getProvider()).isEqualTo("rate-limited");
    assertThat(results.get(0).getStatus()).isEqualTo(ProviderCallStatus.RATE_LIMITED);
    assertThat(results.get(1).getProvider()).isEqualTo("down");
    assertThat(results.get(1).getStatus()).isEqualTo(ProviderCallStatus.UNAVAILABLE);
  }

  @Test
  void resolveBrandKeyRespectsRoutingAndSupport() {
    InventoryProvider resolver =
        new BaseProvider("resolver", 10, true, true, true) {
          @Override
          public AvailabilityResult checkAvailability(InventoryQuery query) {
            return AvailabilityResult.builder()
                .provider("resolver")
                .providerType("inventory")
                .status(ProviderCallStatus.SUCCESS)
                .items(List.of())
                .build();
          }

          @Override
          public Optional<String> resolveBrandKey(Long tecDocBrandId, String tecDocBrandName) {
            return Optional.of("BOSCH");
          }

          @Override
          public boolean supports(InventoryQuery query, ProviderRoutingContext context) {
            return "BOSCH".equals(query.getBrand());
          }
        };

    when(routingPolicy.allows(eq(resolver), any(), any())).thenReturn(true);

    ProviderRegistry local = new ProviderRegistry(List.of(resolver), routingPolicy);

    Optional<String> resolved =
        local.resolveBrandKey(
            30L,
            "BOSCH",
            ProviderRoutingContext.builder().purpose(ProviderRoutingPurpose.EXTERNAL_OFFER).build());

    assertThat(resolved).contains("BOSCH");
  }

  private static InventoryProvider provider(
      String name, int priority, boolean inventory, boolean supportsBrand, boolean enabled) {
    return new BaseProvider(name, priority, inventory, supportsBrand, enabled) {
      @Override
      public AvailabilityResult checkAvailability(InventoryQuery query) {
        return AvailabilityResult.builder()
            .provider(name)
            .providerType("inventory")
            .status(ProviderCallStatus.SUCCESS)
            .items(List.of())
            .build();
      }
    };
  }

  private abstract static class BaseProvider implements InventoryProvider {

    private final String name;
    private final int priority;
    private final boolean inventory;
    private final boolean supportsBrand;
    private final boolean enabled;

    private BaseProvider(
        String name, int priority, boolean inventory, boolean supportsBrand, boolean enabled) {
      this.name = name;
      this.priority = priority;
      this.inventory = inventory;
      this.supportsBrand = supportsBrand;
      this.enabled = enabled;
    }

    @Override
    public String providerName() {
      return name;
    }

    @Override
    public int priority() {
      return priority;
    }

    @Override
    public ProviderCapabilities capabilities() {
      return ProviderCapabilities.builder()
          .inventory(inventory)
          .ordering(false)
          .orderHistory(false)
          .enabled(enabled)
          .build();
    }

    @Override
    public boolean supportsBrand(String brand) {
      return supportsBrand;
    }
  }
}
