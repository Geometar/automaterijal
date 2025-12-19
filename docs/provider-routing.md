# Provider Routing (Inventory + External Offers)

This system routes inventory/external-offer calls to multiple providers and merges results in a
deterministic, scalable way.

## Quick mental model
- Providers can be **brand-specific** (manufacturer API) or **store-like** (returns many brands).
- Routing is **rules-driven** via YAML (priority, purpose, brands, groups).
- Selection of same article is **availability -> priority -> price**.

## Where rules live
Rules are in `src/main/resources/application.yml`:
```yaml
integration:
  providers:
    rules:
      - provider: febi-stock
        enabled: true
        priority: 100
        purposes: [INVENTORY_ENRICHMENT, EXTERNAL_OFFER]
        brands: [FEBI, BLUE]
      - provider: store-x
        enabled: true
        priority: 50
        purposes: [EXTERNAL_OFFER]
        maxLocalMatchCount: 0
```

## Routing flow (high level)
1) Build `ProviderRoutingContext` (purpose, local counts, groups, partner info).  
2) `ProviderRegistry` filters providers by:
   - capability (enabled + inventory)
   - YAML policy (`ProviderRoutingPolicy`)
   - provider `supports(query, context)`  
3) Providers are **sorted by priority**, then name for determinism.
4) All matching providers are called; results are merged.

## Merge/selection policy
If multiple providers return the same article:
1) **Available** beats **not available**.
2) If availability equal: **higher priority wins**.
3) If priority equal: **lower price wins**.
4) If price equal: higher quantity wins (fallback).

## Brand-specific vs store-like providers
### Brand-specific (manufacturer)
- `supportsBrand` should enforce brand list.
- `AvailabilityItem.brand` can be left as the query brand.
- Rule example uses `brands: [FEBI, BLUE]`.

### Store-like (many brands)
- `supports(...)` can ignore brand (or allow `brand == null`).
- **Must set** `AvailabilityItem.brand` from provider response.
- This lets the merge split by brand when brand is requested.

## How to add a new provider (5 steps)
1) Implement `InventoryProvider`.
2) In `checkAvailability`, map to `AvailabilityResult` + `AvailabilityItem`.
3) If multi-brand: set `AvailabilityItem.brand`.
4) Optional: override `supports(query, context)` for conditional routing.
5) Add YAML rule under `integration.providers.rules`.

## Files to know
- Routing rules: `src/main/resources/application.yml`
- Policy logic: `src/main/java/com/automaterijal/application/integration/registry/ProviderRoutingPolicy.java`
- Provider registry: `src/main/java/com/automaterijal/application/integration/registry/ProviderRegistry.java`
- Inventory flow merge: `src/main/java/com/automaterijal/application/services/roba/ExternalAvailabilityService.java`
- Context model: `src/main/java/com/automaterijal/application/integration/shared/ProviderRoutingContext.java`
- Provider API: `src/main/java/com/automaterijal/application/integration/shared/InventoryProvider.java`
