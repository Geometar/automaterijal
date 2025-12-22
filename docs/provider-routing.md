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

Local counts are used to gate providers (e.g. `maxLocalMatchCount`).  
For external offers, counts come from the local results page (total matches + in‑stock count).

## Purpose (when a provider is allowed to run)
`purpose` is a tag for the current flow. If a rule defines `purposes`, the provider is allowed
only for those flows. If you omit `purposes`, the rule applies to all flows.

Current purposes:
- `INVENTORY_ENRICHMENT`: enrich local out-of-stock items with provider availability.
- `EXTERNAL_OFFER`: build external-only offers from TecDoc results.
- `DETAILS`: fetch full provider details (without TecDoc) for a single item.

## Merge/selection policy
If multiple providers return the same article:
1) **Available** beats **not available**.
2) If availability equal: **higher priority wins**.
3) If priority equal: **lower price wins**.
4) If price equal: higher quantity wins (fallback).

## Pricing for external providers
Backend computes the **final customer price** for provider items using:
1) **Base selling price**
   - If `purchasePrice` exists: `purchasePrice * margin`
   - Else: use `sellingPrice` from provider
2) **PDV**: `* 1.20`
3) **Partner multiplier** (from `RobaCeneService`)

Margin is configured in `src/main/resources/application.yml`:
```yaml
pricing:
  margin:
    default-percent: 0.65
    by-group:
      ZAM: 0.30
      AK: 0.30
```
Values are **percent as decimal** (e.g. `0.30` = 30%).
Logic lives in `ProviderPricingService` and is shared by list and details flows.

## Brand-specific vs store-like providers
### Brand-specific (manufacturer)
- `supportsBrand` should enforce brand list.
- `AvailabilityItem.brand` can be left as the query brand.
- Rule example uses `brands: [FEBI, BLUE]`.

### Store-like (many brands)
- `supports(...)` can ignore brand (or allow `brand == null`).
- **Must set** `AvailabilityItem.brand` from provider response.
- This lets the merge split by brand when brand is requested.

## Provider details (no TecDoc)
If a provider returns full details (name, images, specs), you can bypass TecDoc.
Skeleton is ready:
- `ProviderDetailsProvider` (interface)
- `ProviderDetailsRegistry` (routing + priority)
- `ExternalProviderDetailsService` (maps to `RobaExpandedDto`)

Usage idea:
```java
ProviderDetailsQuery query =
    ProviderDetailsQuery.builder().brand("BOSCH").articleNumber("1234").build();
Optional<RobaExpandedDto> dto =
    externalProviderDetailsService.fetchExternalDetails(query, partner);
```

## How to add a new provider (step by step)
1) **Create the provider class**
   - Implement `InventoryProvider`.
   - Add `@Component` so Spring picks it up.
   - Implement `providerName()`, `capabilities()`, `supportsBrand(...)`.
   - If you need TecDoc brand mapping, implement `resolveBrandKey(...)`.

2) **Map availability correctly**
   - In `checkAvailability`, call the external API and map to:
     - `AvailabilityResult` (provider name, status, destination, items)
     - `AvailabilityItem` (articleNumber, brand, status, warehouses, totalQuantity)
   - If provider returns multiple brands, **set `AvailabilityItem.brand` from response**.
   - Pricing fields:
     - `purchasePrice` = net/nabavna (if you have it)
     - `sellingPrice` = provider selling price (if you have it)
     - `ProviderPricingService` computes final customer price using
       `purchasePrice` + margin + PDV + partner multiplier (fallback to `sellingPrice`).

3) **Add routing rules**
   - Edit `src/main/resources/application.yml` and add:
     ```yaml
     integration:
       providers:
         rules:
           - provider: <providerName>
             enabled: true
             priority: 100
             purposes: [INVENTORY_ENRICHMENT, EXTERNAL_OFFER]
             brands: [BRAND1, BRAND2]   # optional
             groups: [ZAM, AK]         # optional
     ```
   - If you skip rules for a provider, it is allowed by default.

4) **(Optional) External details provider**
   - Implement `ProviderDetailsProvider` and return `ProviderDetailsResult`
     (name, images, specs, numbers, availability).
   - Add a rule with `purposes: [DETAILS]` so routing allows it.
   - Example query:
     ```java
     ProviderDetailsQuery query =
         ProviderDetailsQuery.builder().brand("BOSCH").articleNumber("1234").build();
     externalProviderDetailsService.fetchExternalDetails(query, partner);
     ```

5) **Quick validation**
   - Search an out-of-stock item (so provider availability kicks in).
   - Verify `providerAvailability.provider` + `providerAvailability.price` on FE/response.
   - If multi-brand provider, check that brand-specific filtering still works.

## Files to know
- Routing rules: `src/main/resources/application.yml`
- Policy logic: `src/main/java/com/automaterijal/application/integration/registry/ProviderRoutingPolicy.java`
- Provider registry: `src/main/java/com/automaterijal/application/integration/registry/ProviderRegistry.java`
- Inventory flow merge: `src/main/java/com/automaterijal/application/services/roba/ExternalAvailabilityService.java`
- Context model: `src/main/java/com/automaterijal/application/integration/shared/ProviderRoutingContext.java`
- Provider API: `src/main/java/com/automaterijal/application/integration/shared/InventoryProvider.java`
