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

  public void reload() {
    if (!StringUtils.hasText(properties.getPriceListPath())) {
      log.warn("integration.febi.price-list-path not configured; prices will be empty");
      priceIndex.clear();
      return;
    }
    Map<String, FebiPriceRecord> loaded =
        loader.load(new File(properties.getPriceListPath()));
    priceIndex.clear();
    priceIndex.putAll(loaded);
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
}
