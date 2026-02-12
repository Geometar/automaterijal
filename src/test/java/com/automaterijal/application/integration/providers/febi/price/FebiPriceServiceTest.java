package com.automaterijal.application.integration.providers.febi.price;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.providers.febi.FebiProperties;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
class FebiPriceServiceTest {

  @Mock private FebiPriceListLoader loader;
  @Mock private JdbcTemplate jdbcTemplate;
  @Mock private FebiPriceListItemRepository repository;

  private FebiProperties properties;
  private FebiPriceService service;

  @BeforeEach
  void setUp() {
    properties = new FebiProperties();
    service = new FebiPriceService(properties, loader, jdbcTemplate, repository);
  }

  @Test
  void reloadWhenPathMissingReturnsEmpty() {
    properties.setPriceListPath(null);

    FebiPriceService.ReloadResult result = service.reload();

    assertThat(result.count()).isZero();
    assertThat(result.path()).isNull();
    assertThat(result.lastModified()).isNull();
    assertThat(result.sizeBytes()).isNull();
    when(
            repository.findByNormalizedArticleNumberInOrNormalizedArticleNumberNoLeadingZerosIn(
                anyCollection(), anyCollection()))
        .thenReturn(List.of());
    assertThat(service.findPrice("123")).isEmpty();
  }

  @Test
  void reloadPopulatesIndexAndReturnsCount() {
    File tempFile = null;
    try {
      tempFile = File.createTempFile("febi", ".xlsx");
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    properties.setPriceListPath(tempFile.getAbsolutePath());
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
    when(jdbcTemplate.update(any(String.class))).thenReturn(0);
    when(jdbcTemplate.batchUpdate(any(String.class), any(BatchPreparedStatementSetter.class)))
        .thenReturn(new int[] {1});
    FebiPriceListItem item = new FebiPriceListItem();
    item.setNormalizedArticleNumber("0001");
    item.setNormalizedArticleNumberNoLeadingZeros("1");
    item.setRawArticleNumber("0001");
    item.setLevel3("Hemijski proizvodi");
    item.setNetPrice(new BigDecimal("10.00"));
    item.setCurrency("EUR");
    when(
            repository.findByNormalizedArticleNumberInOrNormalizedArticleNumberNoLeadingZerosIn(
                anyCollection(), anyCollection()))
        .thenReturn(List.of(item));

    FebiPriceService.ReloadResult result = service.reload();

    assertThat(result.count()).isEqualTo(1);
    assertThat(result.path()).contains(tempFile.getAbsolutePath());
    Optional<FebiPriceService.PriceQuote> quote = service.findPrice("0001");
    assertThat(quote).isPresent();
    assertThat(quote.get().purchasePrice()).isEqualByComparingTo("10.00");
    assertThat(result.lastModified()).isNotNull();
    assertThat(result.sizeBytes()).isNotNull();
  }
}
