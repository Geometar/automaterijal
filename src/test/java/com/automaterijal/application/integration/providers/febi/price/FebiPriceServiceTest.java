package com.automaterijal.application.integration.providers.febi.price;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.providers.febi.FebiProperties;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FebiPriceServiceTest {

  @Mock private FebiPriceListLoader loader;

  private FebiProperties properties;
  private FebiPriceService service;

  @BeforeEach
  void setUp() {
    properties = new FebiProperties();
    service = new FebiPriceService(properties, loader);
  }

  @Test
  void reloadWhenPathMissingReturnsEmpty() {
    properties.setPriceListPath(null);

    FebiPriceService.ReloadResult result = service.reload();

    assertThat(result.count()).isZero();
    assertThat(result.path()).isNull();
    assertThat(result.lastModified()).isNull();
    assertThat(result.sizeBytes()).isNull();
    assertThat(service.findPrice("123")).isEmpty();
  }

  @Test
  void reloadPopulatesIndexAndReturnsCount() {
    properties.setPriceListPath("dummy.xlsx");
    FebiPriceRecord record =
        FebiPriceRecord.builder()
            .brand("FEBI")
            .rawArticleNumber("0001")
            .normalizedArticleNumber("0001")
            .normalizedArticleNumberNoLeadingZeros("1")
            .level3("Hemijski proizvodi")
            .netPrice(new BigDecimal("10.00"))
            .currency("EUR")
            .build();
    when(loader.load(any(File.class))).thenReturn(Map.of("0001", record));

    FebiPriceService.ReloadResult result = service.reload();

    assertThat(result.count()).isEqualTo(1);
    assertThat(result.path()).contains("dummy.xlsx");
    Optional<FebiPriceService.PriceQuote> quote = service.findPrice("0001");
    assertThat(quote).isPresent();
    assertThat(quote.get().purchasePrice()).isEqualByComparingTo("10.00");
    assertThat(result.lastModified()).isNotNull();
    assertThat(result.sizeBytes()).isNotNull();
  }
}
