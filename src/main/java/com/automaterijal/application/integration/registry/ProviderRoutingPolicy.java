package com.automaterijal.application.integration.registry;

import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.InventoryQueryItem;
import com.automaterijal.application.integration.shared.ProviderBulkMode;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class ProviderRoutingPolicy {

  private final ProviderRoutingProperties properties;

  public boolean allows(InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    if (provider == null) {
      return false;
    }
    List<ProviderRoutingProperties.Rule> rules = rulesForProvider(provider.providerName());
    if (rules.isEmpty()) {
      return true;
    }
    return rules.stream()
        .filter(rule -> rule.getEnabled() == null || rule.getEnabled())
        .anyMatch(rule -> matches(rule, query, context));
  }

  public int priorityFor(
      InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    if (provider == null) {
      return 0;
    }
    List<ProviderRoutingProperties.Rule> rules = rulesForProvider(provider.providerName());
    if (rules.isEmpty()) {
      return provider.priority();
    }

    Stream<ProviderRoutingProperties.Rule> matching =
        rules.stream()
            .filter(rule -> rule.getEnabled() == null || rule.getEnabled())
            .filter(rule -> matches(rule, query, context));

    OptionalInt configured =
        matching
            .map(ProviderRoutingProperties.Rule::getPriority)
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue)
            .max();

    return configured.orElse(provider.priority());
  }

  public ProviderBulkMode bulkModeFor(
      InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    if (provider == null) {
      return ProviderBulkMode.SAME_BRAND;
    }
    List<ProviderRoutingProperties.Rule> matching = matchingRules(provider.providerName(), query, context);
    for (ProviderRoutingProperties.Rule rule : matching) {
      if (rule.getBulkMode() != null) {
        return rule.getBulkMode();
      }
    }
    return provider.bulkMode();
  }

  public int maxBatchSizeFor(
      InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    if (provider == null) {
      return 20;
    }
    List<ProviderRoutingProperties.Rule> matching = matchingRules(provider.providerName(), query, context);
    for (ProviderRoutingProperties.Rule rule : matching) {
      if (rule.getMaxBatchSize() != null && rule.getMaxBatchSize() > 0) {
        return rule.getMaxBatchSize();
      }
    }
    int providerDefault = provider.maxArticlesPerRequest();
    return providerDefault > 0 ? providerDefault : 20;
  }

  public boolean allows(String providerName, String brand, ProviderRoutingContext context) {
    List<ProviderRoutingProperties.Rule> rules = rulesForProvider(providerName);
    if (rules.isEmpty()) {
      return true;
    }
    return rules.stream()
        .filter(rule -> rule.getEnabled() == null || rule.getEnabled())
        .anyMatch(rule -> matches(rule, brand, context));
  }

  public int priorityFor(
      String providerName, int fallbackPriority, String brand, ProviderRoutingContext context) {
    List<ProviderRoutingProperties.Rule> rules = rulesForProvider(providerName);
    if (rules.isEmpty()) {
      return fallbackPriority;
    }

    OptionalInt configured =
        rules.stream()
            .filter(rule -> rule.getEnabled() == null || rule.getEnabled())
            .filter(rule -> matches(rule, brand, context))
            .map(ProviderRoutingProperties.Rule::getPriority)
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue)
            .max();

    return configured.orElse(fallbackPriority);
  }

  private List<ProviderRoutingProperties.Rule> rulesForProvider(String providerName) {
    if (!StringUtils.hasText(providerName) || properties == null) {
      return List.of();
    }
    if (CollectionUtils.isEmpty(properties.getRules())) {
      return List.of();
    }
    String normalized = providerName.trim().toUpperCase(Locale.ROOT);
    return properties.getRules().stream()
        .filter(rule -> rule != null && StringUtils.hasText(rule.getProvider()))
        .filter(rule -> rule.getProvider().trim().toUpperCase(Locale.ROOT).equals(normalized))
        .toList();
  }

  private List<ProviderRoutingProperties.Rule> matchingRules(
      String providerName, InventoryQuery query, ProviderRoutingContext context) {
    return rulesForProvider(providerName).stream()
        .filter(rule -> rule.getEnabled() == null || rule.getEnabled())
        .filter(rule -> matches(rule, query, context))
        .sorted(
            Comparator.comparingInt(
                    (ProviderRoutingProperties.Rule rule) ->
                        rule.getPriority() != null ? rule.getPriority() : Integer.MIN_VALUE)
                .reversed())
        .toList();
  }

  private boolean matches(
      ProviderRoutingProperties.Rule rule, InventoryQuery query, ProviderRoutingContext context) {
    if (rule == null) {
      return false;
    }
    if (!matchesContextAndCounts(rule, context)) {
      return false;
    }
    if (CollectionUtils.isEmpty(rule.getBrands())) {
      return true;
    }
    if (query == null) {
      return false;
    }

    if (StringUtils.hasText(query.getBrand())) {
      return matchesConfiguredBrand(rule, query.getBrand());
    }

    if (CollectionUtils.isEmpty(query.getItems())) {
      return false;
    }
    return query.getItems().stream()
        .filter(Objects::nonNull)
        .map(InventoryQueryItem::getBrand)
        .filter(StringUtils::hasText)
        .anyMatch(brand -> matchesConfiguredBrand(rule, brand));
  }

  private boolean matches(
      ProviderRoutingProperties.Rule rule, String brand, ProviderRoutingContext context) {
    if (rule == null) {
      return false;
    }
    if (!matchesContextAndCounts(rule, context)) {
      return false;
    }
    return matchesConfiguredBrand(rule, brand);
  }

  private boolean matchesContextAndCounts(
      ProviderRoutingProperties.Rule rule, ProviderRoutingContext context) {
    if (!CollectionUtils.isEmpty(rule.getPurposes())) {
      if (context == null || context.getPurpose() == null) {
        return false;
      }
      if (!rule.getPurposes().contains(context.getPurpose())) {
        return false;
      }
    }
    if (!CollectionUtils.isEmpty(rule.getGroups())) {
      if (context == null || CollectionUtils.isEmpty(context.getGroups())) {
        return false;
      }
      boolean match =
          context.getGroups().stream()
              .filter(StringUtils::hasText)
              .map(value -> value.trim().toUpperCase(Locale.ROOT))
              .anyMatch(
                  group ->
                      rule.getGroups().stream()
                          .filter(StringUtils::hasText)
                          .map(value -> value.trim().toUpperCase(Locale.ROOT))
                          .anyMatch(group::equals));
      if (!match) {
        return false;
      }
    }

    if (!matchesRange(context != null ? context.getLocalMatchCount() : null,
        rule.getMinLocalMatchCount(), rule.getMaxLocalMatchCount())) {
      return false;
    }

    if (!matchesRange(context != null ? context.getLocalAvailableCount() : null,
        rule.getMinLocalAvailableCount(), rule.getMaxLocalAvailableCount())) {
      return false;
    }

    return true;
  }

  private boolean matchesConfiguredBrand(ProviderRoutingProperties.Rule rule, String brand) {
    if (CollectionUtils.isEmpty(rule.getBrands())) {
      return true;
    }
    if (!StringUtils.hasText(brand)) {
      return false;
    }
    String normalized = brand.trim().toUpperCase(Locale.ROOT);
    return rule.getBrands().stream()
        .filter(StringUtils::hasText)
        .map(value -> value.trim().toUpperCase(Locale.ROOT))
        .anyMatch(candidate -> candidate.equals(normalized));
  }

  private boolean matchesRange(Integer value, Integer min, Integer max) {
    if (min == null && max == null) {
      return true;
    }
    if (value == null) {
      return false;
    }
    if (min != null && value < min) {
      return false;
    }
    if (max != null && value > max) {
      return false;
    }
    return true;
  }
}
