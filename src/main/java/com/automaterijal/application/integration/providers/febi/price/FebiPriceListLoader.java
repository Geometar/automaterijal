package com.automaterijal.application.integration.providers.febi.price;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FebiPriceListLoader {

  private static final String COL_BRAND = "brend";
  private static final String COL_ARTICLE = "bilstein group broj";
  private static final String COL_LEVEL3 = "level 3";
  private static final String COL_NET_PRICE = "neto cena";
  private static final String COL_CURRENCY = "valuta";

  public Map<String, FebiPriceRecord> load(File priceFile) {
    Map<String, FebiPriceRecord> records = new HashMap<>();
    if (priceFile == null || !priceFile.exists() || !priceFile.isFile()) {
      log.warn("Febi price list file not found: {}", priceFile);
      return records;
    }

    try (FileInputStream fis = new FileInputStream(priceFile);
        Workbook workbook = WorkbookFactory.create(fis)) {
      Sheet sheet = workbook.getSheetAt(0);
      if (sheet == null) {
        log.warn("Febi price list sheet is missing in {}", priceFile.getAbsolutePath());
        return records;
      }

      Map<String, Integer> headerIndex = readHeader(sheet.getRow(0));
      if (headerIndex.isEmpty()) {
        log.warn("Febi price list header not recognized in {}", priceFile.getAbsolutePath());
        return records;
      }

      for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        Row row = sheet.getRow(i);
        if (row == null) continue;

        String brand = readString(row, headerIndex.get(COL_BRAND));
        String article = readString(row, headerIndex.get(COL_ARTICLE));
        String level3 = readString(row, headerIndex.get(COL_LEVEL3));
        BigDecimal netPrice = readDecimal(row, headerIndex.get(COL_NET_PRICE));
        String currency = readString(row, headerIndex.get(COL_CURRENCY));

        if (article == null || netPrice == null) {
          continue;
        }

        FebiPriceRecord record =
            buildRecord(brand, article, level3, netPrice, currency);
        records.put(record.getNormalizedArticleNumber(), record);
        if (record.getNormalizedArticleNumberNoLeadingZeros() != null) {
          records.put(record.getNormalizedArticleNumberNoLeadingZeros(), record);
        }
      }

      log.info("Loaded {} Febi price records from {}", records.size(), priceFile.getAbsolutePath());
    } catch (IOException ex) {
      log.warn("Failed to read Febi price list {}: {}", priceFile.getAbsolutePath(), ex.getMessage());
    }
    return records;
  }

  private Map<String, Integer> readHeader(Row headerRow) {
    Map<String, Integer> headerIndex = new HashMap<>();
    if (headerRow == null) {
      return headerIndex;
    }
    for (Cell cell : headerRow) {
      String name = readCellAsString(cell);
      if (name == null) continue;
      headerIndex.put(name.trim().toLowerCase(Locale.ROOT), cell.getColumnIndex());
    }
    return headerIndex;
  }

  private String readString(Row row, Integer index) {
    if (row == null || index == null) return null;
    Cell cell = row.getCell(index);
    return readCellAsString(cell);
  }

  private BigDecimal readDecimal(Row row, Integer index) {
    if (row == null || index == null) return null;
    Cell cell = row.getCell(index);
    if (cell == null) return null;

    if (cell.getCellType() == CellType.NUMERIC) {
      return BigDecimal.valueOf(cell.getNumericCellValue());
    }
    String value = readCellAsString(cell);
    if (value == null) {
      return null;
    }
    // normalize "1.681,79" -> "1681.79"
    String normalized = value.replace(".", "").replace(",", ".").replace(" ", "");
    try {
      return new BigDecimal(normalized);
    } catch (NumberFormatException ex) {
      return null;
    }
  }

  private String readCellAsString(Cell cell) {
    if (cell == null) return null;
    if (cell.getCellType() == CellType.NUMERIC) {
      double num = cell.getNumericCellValue();
      return BigDecimal.valueOf(num).toPlainString();
    }
    return Optional.ofNullable(cell.getStringCellValue())
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .orElse(null);
  }

  private FebiPriceRecord buildRecord(
      String brand, String article, String level3, BigDecimal netPrice, String currency) {
    String normalized = normalizeArticle(article, false);
    String normalizedNoZeros = normalizeArticle(article, true);
    return FebiPriceRecord.builder()
        .brand(brand)
        .rawArticleNumber(article)
        .normalizedArticleNumber(normalized)
        .normalizedArticleNumberNoLeadingZeros(normalizedNoZeros)
        .level3(level3)
        .netPrice(netPrice)
        .currency(currency)
        .build();
  }

  private String normalizeArticle(String article, boolean removeLeadingZeros) {
    if (article == null) return null;
    String normalized = article.replace(" ", "").trim().toUpperCase(Locale.ROOT);
    if (removeLeadingZeros) {
      normalized = normalized.replaceFirst("^0+(?!$)", "");
    }
    return normalized;
  }
}
