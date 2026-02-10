package com.automaterijal.application.integration.registry;

import static org.assertj.core.api.Assertions.assertThat;

import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderCapabilities;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ProviderRoutingPolicyTest {

  @Test
  void allowsWhenNoRulesConfigured() {
    ProviderRoutingProperties properties = new ProviderRoutingProperties();
    ProviderRoutingPolicy policy = new ProviderRoutingPolicy(properties);

    boolean allowed =
        policy.allows(
            provider("szakal", 10),
            InventoryQuery.builder().brand("BOSCH").build(),
            ProviderRoutingContext.builder().purpose(ProviderRoutingPurpose.EXTERNAL_OFFER).build());

    assertThat(allowed).isTrue();
  }

  @Test
  void purposeAndBrandAndGroupRuleMustMatch() {
    ProviderRoutingProperties properties = new ProviderRoutingProperties();
    ProviderRoutingProperties.Rule rule = new ProviderRoutingProperties.Rule();
    rule.setProvider("szakal");
    rule.setEnabled(true);
    rule.setPriority(70);
    rule.setPurposes(Set.of(ProviderRoutingPurpose.EXTERNAL_OFFER));
    rule.setBrands(Set.of("BOSCH"));
    rule.setGroups(Set.of("ALTERNATIVA OE"));
    rule.setMinLocalAvailableCount(0);
    rule.setMaxLocalAvailableCount(2);
    properties.setRules(List.of(rule));

    ProviderRoutingPolicy policy = new ProviderRoutingPolicy(properties);

    ProviderRoutingContext matchingContext =
        ProviderRoutingContext.builder()
            .purpose(ProviderRoutingPurpose.EXTERNAL_OFFER)
            .groups(Set.of("ALTERNATIVA OE"))
            .localAvailableCount(1)
            .build();
    ProviderRoutingContext nonMatchingContext =
        ProviderRoutingContext.builder()
            .purpose(ProviderRoutingPurpose.DETAILS)
            .groups(Set.of("ALTERNATIVA OE"))
            .localAvailableCount(1)
            .build();

    assertThat(
            policy.allows(
                provider("szakal", 10), InventoryQuery.builder().brand("BOSCH").build(), matchingContext))
        .isTrue();
    assertThat(
            policy.allows(
                provider("szakal", 10),
                InventoryQuery.builder().brand("BOSCH").build(),
                nonMatchingContext))
        .isFalse();
  }

  @Test
  void priorityUsesHighestConfiguredRuleForMatch() {
    ProviderRoutingProperties properties = new ProviderRoutingProperties();

    ProviderRoutingProperties.Rule low = new ProviderRoutingProperties.Rule();
    low.setProvider("febi-stock");
    low.setPriority(20);
    low.setEnabled(true);
    low.setPurposes(Set.of(ProviderRoutingPurpose.EXTERNAL_OFFER));

    ProviderRoutingProperties.Rule high = new ProviderRoutingProperties.Rule();
    high.setProvider("febi-stock");
    high.setPriority(80);
    high.setEnabled(true);
    high.setPurposes(Set.of(ProviderRoutingPurpose.EXTERNAL_OFFER));

    properties.setRules(List.of(low, high));
    ProviderRoutingPolicy policy = new ProviderRoutingPolicy(properties);

    int priority =
        policy.priorityFor(
            provider("febi-stock", 5),
            InventoryQuery.builder().brand("FEBI").build(),
            ProviderRoutingContext.builder().purpose(ProviderRoutingPurpose.EXTERNAL_OFFER).build());

    assertThat(priority).isEqualTo(80);
  }

  @Test
  void nonMatchingRulesFallBackToProviderPriority() {
    ProviderRoutingProperties properties = new ProviderRoutingProperties();

    ProviderRoutingProperties.Rule onlyDetails = new ProviderRoutingProperties.Rule();
    onlyDetails.setProvider("febi-stock");
    onlyDetails.setPriority(99);
    onlyDetails.setEnabled(true);
    onlyDetails.setPurposes(Set.of(ProviderRoutingPurpose.DETAILS));
    properties.setRules(List.of(onlyDetails));

    ProviderRoutingPolicy policy = new ProviderRoutingPolicy(properties);

    int priority =
        policy.priorityFor(
            provider("febi-stock", 12),
            InventoryQuery.builder().brand("FEBI").build(),
            ProviderRoutingContext.builder().purpose(ProviderRoutingPurpose.EXTERNAL_OFFER).build());

    assertThat(priority).isEqualTo(12);
  }

  private static InventoryProvider provider(String name, int priority) {
    return new InventoryProvider() {
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
        return ProviderCapabilities.inventoryOnly();
      }

      @Override
      public boolean supportsBrand(String brand) {
        return true;
      }

      @Override
      public com.automaterijal.application.integration.shared.AvailabilityResult checkAvailability(
          InventoryQuery query) {
        throw new UnsupportedOperationException("not used in routing policy tests");
      }
    };
  }
}
