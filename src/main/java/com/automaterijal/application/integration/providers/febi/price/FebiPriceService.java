package com.automaterijal.application.integration.providers.febi.price;

import com.automaterijal.application.integration.providers.febi.FebiProperties;
import jakarta.annotation.PostConstruct;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class FebiPriceService {

  private final FebiProperties properties;
  private final FebiPriceListLoader loader;

  private final Map<String, FebiPriceRecord> priceIndex = new ConcurrentHashMap<>();

  @PostConstruct
  public void init() {
    reload();
  }

  public ReloadResult reload() {
    if (!StringUtils.hasText(properties.getPriceListPath())) {
      log.warn("integration.febi.price-list-path not configured; prices will be empty");
      priceIndex.clear();
      return new ReloadResult(0, null, null, null);
    }

    File priceList = new File(properties.getPriceListPath());
    Map<String, FebiPriceRecord> loaded = loader.load(priceList);
    priceIndex.clear();
    priceIndex.putAll(loaded);
    return new ReloadResult(
        priceIndex.size(),
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

  public Optional<PriceQuote> findPrice(String articleNumber) {
    if (!StringUtils.hasText(articleNumber)) {
      return Optional.empty();
    }
    String normalized = normalize(articleNumber, false);
    String normalizedNoZeros = normalize(articleNumber, true);

    FebiPriceRecord record =
        Optional.ofNullable(priceIndex.get(normalized))
            .orElse(priceIndex.get(normalizedNoZeros));

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

  public Optional<Integer> findPackagingUnit(String articleNumber) {
    if (!StringUtils.hasText(articleNumber)) {
      return Optional.empty();
    }
    String normalized = normalize(articleNumber, false);
    String normalizedNoZeros = normalize(articleNumber, true);

    FebiPriceRecord record =
        Optional.ofNullable(priceIndex.get(normalized))
            .orElse(priceIndex.get(normalizedNoZeros));

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

  public record PriceQuote(
      String articleNumber, BigDecimal purchasePrice, BigDecimal sellingPrice, String currency) {}

  public record ReloadResult(Integer count, String path, Long lastModified, Long sizeBytes) {}

  public record PriceFileInfo(String path, Long lastModified, Long sizeBytes) {}
}
