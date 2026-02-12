package com.automaterijal.application.integration.providers.febi.price;

import com.automaterijal.application.integration.providers.febi.FebiProperties;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class FebiPriceService {

  private static final int BATCH_SIZE = 2000;

  private final FebiProperties properties;
  private final FebiPriceListLoader loader;
  private final JdbcTemplate jdbcTemplate;
  private final FebiPriceListItemRepository repository;

  public ReloadResult reload() {
    if (!StringUtils.hasText(properties.getPriceListPath())) {
      log.warn("integration.febi.price-list-path not configured; prices will be empty");
      return new ReloadResult(0, null, null, null);
    }

    File priceList = new File(properties.getPriceListPath());
    if (!priceList.exists() || !priceList.isFile()) {
      log.warn("Febi price list file not found: {}", priceList.getAbsolutePath());
      return new ReloadResult(0, priceList.getAbsolutePath(), null, null);
    }

    Map<String, FebiPriceRecord> loaded = loader.load(priceList);
    Map<String, FebiPriceRecord> unique = uniqueByNormalized(loaded);
    replaceAll(unique.values());
    return new ReloadResult(
        unique.size(),
        priceList.getAbsolutePath(),
        priceList.exists() ? priceList.lastModified() : null,
        priceList.exists() ? priceList.length() : null);
  }

  public Optional<PriceFileInfo> priceFileInfo() {
    if (!StringUtils.hasText(properties.getPriceListPath())) {
      return Optional.empty();
    }
    File priceList = new File(properties.getPriceListPath());
    if (!priceList.exists() || !priceList.isFile()) {
      return Optional.empty();
    }
    return Optional.of(
        new PriceFileInfo(
            priceList.getAbsolutePath(), priceList.lastModified(), priceList.length()));
  }

  public DbStatus dbStatus() {
    try {
      Integer count =
          jdbcTemplate.queryForObject("select count(*) from febi_pricelist_items", Integer.class);
      Timestamp updatedAt =
          jdbcTemplate.queryForObject(
              "select max(updated_at) from febi_pricelist_items", Timestamp.class);
      return new DbStatus(
          count != null ? count : 0, updatedAt != null ? updatedAt.getTime() : null);
    } catch (DataAccessException ex) {
      log.warn("Failed to load Febi price list DB status: {}", ex.getMessage());
      return new DbStatus(0, null);
    }
  }

  public Optional<PriceQuote> findPrice(String articleNumber) {
    return findPrice(articleNumber, buildLookup(List.of(articleNumber)));
  }

  public Optional<Integer> findPackagingUnit(String articleNumber) {
    return findPackagingUnit(articleNumber, buildLookup(List.of(articleNumber)));
  }

  public PriceLookup buildLookup(Collection<String> articleNumbers) {
    if (articleNumbers == null || articleNumbers.isEmpty()) {
      return PriceLookup.empty();
    }
    HashSet<String> normalizedKeys = new HashSet<>();
    HashSet<String> normalizedNoZerosKeys = new HashSet<>();
    for (String article : articleNumbers) {
      if (!StringUtils.hasText(article)) {
        continue;
      }
      String normalized = normalize(article, false);
      String normalizedNoZeros = normalize(article, true);
      if (StringUtils.hasText(normalized)) {
        normalizedKeys.add(normalized);
      }
      if (StringUtils.hasText(normalizedNoZeros)) {
        normalizedNoZerosKeys.add(normalizedNoZeros);
      }
    }
    if (normalizedKeys.isEmpty() && normalizedNoZerosKeys.isEmpty()) {
      return PriceLookup.empty();
    }

    Collection<String> normalizedParam =
        normalizedKeys.isEmpty() ? List.of("__no_match__") : normalizedKeys;
    Collection<String> normalizedNoZerosParam =
        normalizedNoZerosKeys.isEmpty() ? List.of("__no_match__") : normalizedNoZerosKeys;

    List<FebiPriceListItem> records =
        repository.findByNormalizedArticleNumberInOrNormalizedArticleNumberNoLeadingZerosIn(
            normalizedParam, normalizedNoZerosParam);

    Map<String, FebiPriceListItem> index = new HashMap<>();
    for (FebiPriceListItem record : records) {
      if (record == null) continue;
      if (StringUtils.hasText(record.getNormalizedArticleNumber())) {
        index.put(record.getNormalizedArticleNumber(), record);
      }
      if (StringUtils.hasText(record.getNormalizedArticleNumberNoLeadingZeros())) {
        index.put(record.getNormalizedArticleNumberNoLeadingZeros(), record);
      }
    }
    return new PriceLookup(index);
  }

  public Optional<PriceQuote> findPrice(String articleNumber, PriceLookup lookup) {
    if (!StringUtils.hasText(articleNumber)) {
      return Optional.empty();
    }
    FebiPriceListItem record = resolveRecord(articleNumber, lookup);
    if (record == null || record.getNetPrice() == null) {
      return Optional.empty();
    }

    BigDecimal purchase = record.getNetPrice();
    BigDecimal selling = applyMargin(purchase, record.getLevel3());

    return Optional.of(
        new PriceQuote(
            record.getRawArticleNumber(),
            purchase.setScale(2, RoundingMode.HALF_UP),
            selling.setScale(2, RoundingMode.HALF_UP),
            record.getCurrency()));
  }

  public Optional<Integer> findPackagingUnit(String articleNumber, PriceLookup lookup) {
    if (!StringUtils.hasText(articleNumber)) {
      return Optional.empty();
    }
    FebiPriceListItem record = resolveRecord(articleNumber, lookup);
    if (record == null || record.getPackagingUnit() == null || record.getPackagingUnit() <= 0) {
      return Optional.empty();
    }
    return Optional.of(record.getPackagingUnit());
  }

  private BigDecimal applyMargin(BigDecimal purchasePrice, String level3) {
    if (purchasePrice == null) return BigDecimal.ZERO;
    BigDecimal factor =
        (level3 != null && level3.equalsIgnoreCase("Hemijski proizvodi"))
            ? new BigDecimal("1.50")
            : new BigDecimal("1.65");
    return purchasePrice.multiply(factor);
  }

  private String normalize(String article, boolean removeLeadingZeros) {
    String normalized = article.replace(" ", "").trim().toUpperCase();
    if (removeLeadingZeros) {
      normalized = normalized.replaceFirst("^0+(?!$)", "");
    }
    return normalized;
  }

  private Map<String, FebiPriceRecord> uniqueByNormalized(Map<String, FebiPriceRecord> loaded) {
    Map<String, FebiPriceRecord> unique = new HashMap<>();
    if (loaded == null || loaded.isEmpty()) {
      return unique;
    }
    for (FebiPriceRecord record : loaded.values()) {
      if (record == null || !StringUtils.hasText(record.getNormalizedArticleNumber())) {
        continue;
      }
      unique.put(record.getNormalizedArticleNumber(), record);
    }
    return unique;
  }

  private void replaceAll(Collection<FebiPriceRecord> records) {
    jdbcTemplate.update("delete from febi_pricelist_items");
    if (records == null || records.isEmpty()) {
      return;
    }
    List<FebiPriceRecord> list = new ArrayList<>(records);
    Timestamp now = Timestamp.from(Instant.now());
    String sql =
        "insert into febi_pricelist_items (normalized_article, normalized_article_no_zeros, "
            + "raw_article, brand, level3, net_price, currency, packaging_unit, updated_at) "
            + "values (?,?,?,?,?,?,?,?,?)";

    for (int i = 0; i < list.size(); i += BATCH_SIZE) {
      List<FebiPriceRecord> batch = list.subList(i, Math.min(i + BATCH_SIZE, list.size()));
      jdbcTemplate.batchUpdate(
          sql,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(java.sql.PreparedStatement ps, int idx)
                throws java.sql.SQLException {
              FebiPriceRecord record = batch.get(idx);
              ps.setString(1, record.getNormalizedArticleNumber());
              ps.setString(2, record.getNormalizedArticleNumberNoLeadingZeros());
              ps.setString(3, record.getRawArticleNumber());
              ps.setString(4, record.getBrand());
              ps.setString(5, record.getLevel3());
              ps.setBigDecimal(6, record.getNetPrice());
              ps.setString(7, record.getCurrency());
              if (record.getPackagingUnit() != null) {
                ps.setInt(8, record.getPackagingUnit());
              } else {
                ps.setNull(8, java.sql.Types.INTEGER);
              }
              ps.setTimestamp(9, now);
            }

            @Override
            public int getBatchSize() {
              return batch.size();
            }
          });
    }
  }

  private FebiPriceListItem resolveRecord(String articleNumber, PriceLookup lookup) {
    if (lookup == null || lookup.index() == null) {
      return null;
    }
    String normalized = normalize(articleNumber, false);
    String normalizedNoZeros = normalize(articleNumber, true);
    FebiPriceListItem record = lookup.index().get(normalized);
    if (record == null) {
      record = lookup.index().get(normalizedNoZeros);
    }
    return record;
  }

  public record PriceQuote(
      String articleNumber, BigDecimal purchasePrice, BigDecimal sellingPrice, String currency) {}

  public record ReloadResult(Integer count, String path, Long lastModified, Long sizeBytes) {}

  public record PriceFileInfo(String path, Long lastModified, Long sizeBytes) {}

  public record DbStatus(Integer count, Long updatedAt) {}

  public record PriceLookup(Map<String, FebiPriceListItem> index) {
    public static PriceLookup empty() {
      return new PriceLookup(Map.of());
    }
  }
}
