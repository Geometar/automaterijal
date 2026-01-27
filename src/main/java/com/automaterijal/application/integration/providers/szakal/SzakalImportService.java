package com.automaterijal.application.integration.providers.szakal;

import com.automaterijal.application.utils.CatalogNumberUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class SzakalImportService {
  private static final int MASTER_COLUMNS = 12;
  private static final int PRICELIST_COLUMNS = 7;
  private static final int OE_COLUMNS = 5;
  private static final int BATCH_SIZE = 1000;
  private static final int OE_SHORT_MAX_LENGTH = 160;
  private static final int OE_MAX_LENGTH = 255;

  private final JdbcTemplate jdbcTemplate;
  private final SzakalProperties properties;

  public ImportSummary importAll() {
    ImportResult master = importMaster(resolveMasterFile().orElse(null));
    List<ImportResult> priceLists = new ArrayList<>();
    for (int listNo = 0; listNo <= 3; listNo++) {
      priceLists.add(importPriceList(listNo, resolvePriceListFile(listNo).orElse(null)));
    }
    return new ImportSummary(master, priceLists);
  }

  public ImportSummary importMasterOnly() {
    return new ImportSummary(importMaster(resolveMasterFile().orElse(null)), List.of());
  }

  public ImportSummary importPriceListsOnly() {
    List<ImportResult> priceLists = new ArrayList<>();
    for (int listNo = 0; listNo <= 3; listNo++) {
      priceLists.add(importPriceList(listNo, resolvePriceListFile(listNo).orElse(null)));
    }
    return new ImportSummary(null, priceLists);
  }

  public ImportResult importBarcodesOnly() {
    return importBarcodes(resolveBarcodeFile().orElse(null));
  }

  public ImportResult importOeOnly() {
    return importOeLinks(resolveOeFile().orElse(null));
  }

  public StatusSummary status() {
    Integer masterCount =
        jdbcTemplate.queryForObject("select count(*) from szakal_master_products", Integer.class);
    java.sql.Timestamp masterUpdatedAt =
        jdbcTemplate.queryForObject(
            "select max(updated_at) from szakal_master_products", java.sql.Timestamp.class);

    List<PriceListStatus> priceLists =
        jdbcTemplate.query(
            "select list_no, count(*) as cnt from szakal_pricelist_items group by list_no order by list_no",
            (rs, rowNum) -> new PriceListStatus(rs.getInt("list_no"), rs.getInt("cnt")));

    java.sql.Timestamp priceUpdatedAt =
        jdbcTemplate.queryForObject(
            "select max(updated_at) from szakal_pricelist_items", java.sql.Timestamp.class);

    return new StatusSummary(masterCount, masterUpdatedAt, priceLists, priceUpdatedAt);
  }

  public FilesSummary files() {
    Path base = resolveDataDir();
    List<FileInfo> candidates = new ArrayList<>();
    if (base == null) {
      return new FilesSummary(null, candidates);
    }
    resolveMasterFile()
        .ifPresent(path -> candidates.add(buildFileInfo("master", path)));
    resolveBarcodeFile()
        .ifPresent(path -> candidates.add(buildFileInfo("barcode", path)));
    resolveOeFile()
        .ifPresent(path -> candidates.add(buildFileInfo("oe_link", path)));
    for (int listNo = 0; listNo <= 3; listNo++) {
      final int listIndex = listNo;
      resolvePriceListFile(listNo)
          .ifPresent(path -> candidates.add(buildFileInfo("pricelist_" + listIndex, path)));
    }
    return new FilesSummary(base.toString(), candidates);
  }

  public ImportResult importMaster(Path file) {
    if (file == null) {
      log.warn("Szakal master file not found; skipping import");
      return new ImportResult(null, 0, 0);
    }

    Instant start = Instant.now();
    jdbcTemplate.update("delete from szakal_master_products");

    String sql =
        "insert into szakal_master_products (glid, tecdoc_dlnr, tecdoc_artnr_norm, "
            + "article_code_norm, size_norm, unit, brand_name, name_rs, name_en, "
            + "weight_grams, customtariff, deposit_glid, updated_at) "
            + "values (?,?,?,?,?,?,?,?,?,?,?,?, current_timestamp) "
            + "on duplicate key update "
            + "tecdoc_dlnr=values(tecdoc_dlnr), "
            + "tecdoc_artnr_norm=values(tecdoc_artnr_norm), "
            + "article_code_norm=values(article_code_norm), "
            + "size_norm=values(size_norm), "
            + "unit=values(unit), "
            + "brand_name=values(brand_name), "
            + "name_rs=values(name_rs), "
            + "name_en=values(name_en), "
            + "weight_grams=values(weight_grams), "
            + "customtariff=values(customtariff), "
            + "deposit_glid=values(deposit_glid), "
            + "updated_at=current_timestamp";

    int rows = 0;
    List<Object[]> batch = new ArrayList<>(BATCH_SIZE);
    try (InputStream input = openFile(file);
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
      String line = reader.readLine(); // header
      while ((line = reader.readLine()) != null) {
        if (!StringUtils.hasText(line)) {
          continue;
        }
        String[] parts = line.split("\t", -1);
        if (parts.length < MASTER_COLUMNS) {
          continue;
        }
        String glid = trimToNull(parts[0]);
        if (!StringUtils.hasText(glid)) {
          continue;
        }
        String articleCodeNorm = normalize(parts[1]);
        String sizeNorm = normalize(parts[2]);
        String unit = trimToNull(parts[3]);
        String brandName = trimToNull(parts[4]);
        String nameRs = trimToNull(parts[5]);
        String nameEn = trimToNull(parts[6]);
        Integer weight = parseInt(parts[7]);
        String customtariff = trimToNull(parts[8]);
        String depositGlid = trimToNull(parts[9]);
        String artnrNorm = normalize(parts[10]);
        Long dlnr = parseLong(parts[11]);
        if (dlnr == null || !StringUtils.hasText(artnrNorm)) {
          continue;
        }
        batch.add(
            new Object[] {
              glid,
              dlnr,
              artnrNorm,
              articleCodeNorm,
              sizeNorm,
              unit,
              brandName,
              nameRs,
              nameEn,
              weight,
              customtariff,
              depositGlid
            });
        if (batch.size() >= BATCH_SIZE) {
          rows += flushBatch(sql, batch);
        }
      }
    } catch (IOException ex) {
      log.warn("Failed to import Szakal master file {}: {}", file, ex.getMessage());
      return new ImportResult(file.toString(), 0, durationMs(start));
    }
    rows += flushBatch(sql, batch);
    return new ImportResult(file.toString(), rows, durationMs(start));
  }

  public ImportResult importPriceList(int listNo, Path file) {
    if (file == null) {
      log.warn("Szakal price list {} file not found; skipping import", listNo);
      return new ImportResult(null, 0, 0);
    }

    Instant start = Instant.now();
    jdbcTemplate.update("delete from szakal_pricelist_items where list_no = ?", listNo);

    String sql =
        "insert into szakal_pricelist_items (list_no, glid, stock, unit_price, "
            + "not_returnable, quantum, order_deadline, token, updated_at) "
            + "values (?,?,?,?,?,?,?,?, current_timestamp) "
            + "on duplicate key update "
            + "stock=values(stock), "
            + "unit_price=values(unit_price), "
            + "not_returnable=values(not_returnable), "
            + "quantum=values(quantum), "
            + "order_deadline=values(order_deadline), "
            + "token=values(token), "
            + "updated_at=current_timestamp";

    int rows = 0;
    List<Object[]> batch = new ArrayList<>(BATCH_SIZE);
    try (InputStream input = openFile(file);
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
      String line = reader.readLine(); // header
      while ((line = reader.readLine()) != null) {
        if (!StringUtils.hasText(line)) {
          continue;
        }
        String[] parts = line.split("\t", -1);
        if (parts.length < PRICELIST_COLUMNS) {
          continue;
        }
        String glid = trimToNull(parts[0]);
        Integer stock = parseInt(parts[1]);
        BigDecimal unitPrice = parseDecimal(parts[2]);
        Boolean notReturnable = parseBoolean(parts[3]);
        Integer quantum = parseInt(parts[4]);
        String orderDeadline = trimToNull(parts[5]);
        String token = trimToNull(parts[6]);
        if (!StringUtils.hasText(glid) || unitPrice == null) {
          continue;
        }
        batch.add(
            new Object[] {
              listNo,
              glid,
              stock != null ? stock : 0,
              unitPrice,
              notReturnable,
              quantum,
              orderDeadline,
              token
            });
        if (batch.size() >= BATCH_SIZE) {
          rows += flushBatch(sql, batch);
        }
      }
    } catch (IOException ex) {
      log.warn("Failed to import Szakal price list {} from {}: {}", listNo, file, ex.getMessage());
      return new ImportResult(file.toString(), 0, durationMs(start));
    }
    rows += flushBatch(sql, batch);
    return new ImportResult(file.toString(), rows, durationMs(start));
  }

  public ImportResult importBarcodes(Path file) {
    if (file == null) {
      log.warn("Szakal barcode file not found; skipping import");
      return new ImportResult(null, 0, 0);
    }

    Instant start = Instant.now();
    String sql =
        "update szakal_master_products set barcode = ?, updated_at = current_timestamp "
            + "where glid = ?";

    int rows = 0;
    List<Object[]> batch = new ArrayList<>(BATCH_SIZE);
    try (InputStream input = openFile(file);
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
      String line = reader.readLine(); // header
      while ((line = reader.readLine()) != null) {
        if (!StringUtils.hasText(line)) {
          continue;
        }
        String[] parts = line.split("\t", -1);
        if (parts.length < 2) {
          continue;
        }
        String glid = trimToNull(parts[0]);
        String barcode = trimToNull(parts[1]);
        if (!StringUtils.hasText(glid) || !StringUtils.hasText(barcode)) {
          continue;
        }
        batch.add(new Object[] {barcode, glid});
        if (batch.size() >= BATCH_SIZE) {
          rows += flushBatch(sql, batch);
        }
      }
    } catch (IOException ex) {
      log.warn("Failed to import Szakal barcode file {}: {}", file, ex.getMessage());
      return new ImportResult(file.toString(), 0, durationMs(start));
    }
    rows += flushBatch(sql, batch);
    return new ImportResult(file.toString(), rows, durationMs(start));
  }

  public ImportResult importOeLinks(Path file) {
    if (file == null) {
      log.warn("Szakal OE link file not found; skipping import");
      return new ImportResult(null, 0, 0);
    }

    Instant start = Instant.now();
    jdbcTemplate.update("delete from szakal_oe_links");

    String sql =
        "insert into szakal_oe_links (glid, oe_short, oe, maker, tecdoc_name, updated_at) "
            + "values (?,?,?,?,?, current_timestamp) "
            + "on duplicate key update "
            + "oe=values(oe), "
            + "tecdoc_name=values(tecdoc_name), "
            + "updated_at=current_timestamp";

    int rows = 0;
    List<Object[]> batch = new ArrayList<>(BATCH_SIZE);
    try (InputStream input = openFile(file);
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
      String line = reader.readLine(); // header
      while ((line = reader.readLine()) != null) {
        if (!StringUtils.hasText(line)) {
          continue;
        }
        String[] parts = line.split("\t", -1);
        if (parts.length < OE_COLUMNS) {
          continue;
        }
        String glid = trimToNull(parts[0]);
        if (!StringUtils.hasText(glid)) {
          continue;
        }
        String tecdocName = trimNullLiteral(parts[1]);
        String oeShort = normalizeOeShort(parts[2]);
        String oe = trimNullLiteral(parts[3]);
        if (oe != null && oe.length() > OE_MAX_LENGTH) {
          oe = oe.substring(0, OE_MAX_LENGTH);
        }
        String maker = trimNullLiteral(parts[4]);
        if (!StringUtils.hasText(oeShort)) {
          oeShort = normalizeOeShort(oe);
        }
        if (!StringUtils.hasText(oeShort)) {
          continue;
        }
        batch.add(
            new Object[] {
              glid,
              oeShort,
              oe,
              maker != null ? maker : "",
              tecdocName
            });
        if (batch.size() >= BATCH_SIZE) {
          rows += flushBatch(sql, batch);
        }
      }
    } catch (IOException ex) {
      log.warn("Failed to import Szakal OE link file {}: {}", file, ex.getMessage());
      return new ImportResult(file.toString(), 0, durationMs(start));
    }
    rows += flushBatch(sql, batch);
    return new ImportResult(file.toString(), rows, durationMs(start));
  }

  private int flushBatch(String sql, List<Object[]> batch) {
    if (batch.isEmpty()) {
      return 0;
    }
    int[] counts = jdbcTemplate.batchUpdate(sql, batch);
    batch.clear();
    int total = 0;
    for (int count : counts) {
      total += Math.max(0, count);
    }
    return total;
  }

  private Optional<Path> resolveMasterFile() {
    Path base = resolveDataDir();
    if (base == null) {
      return Optional.empty();
    }
    return firstExisting(
        base,
        "products_rs.csv",
        "products_rs.csv.zip",
        "products_rs_all.csv.zip",
        "products_rs_all.csv");
  }

  private Optional<Path> resolvePriceListFile(int listNo) {
    Path base = resolveDataDir();
    if (base == null) {
      return Optional.empty();
    }
    return firstExisting(
        base,
        "pricelist_" + listNo + ".csv",
        "pricelist_" + listNo + ".csv.zip",
        "pricelist_export_" + listNo + ".csv",
        "pricelist_export_" + listNo + ".csv.zip");
  }

  private Optional<Path> resolveBarcodeFile() {
    Path base = resolveDataDir();
    if (base == null) {
      return Optional.empty();
    }
    return firstExisting(
        base,
        "barcode.csv",
        "barcode.csv.zip",
        "barcode_all.csv.zip",
        "barcode_all.csv");
  }

  private Optional<Path> resolveOeFile() {
    Path base = resolveDataDir();
    if (base == null) {
      return Optional.empty();
    }
    return firstExisting(
        base,
        "oe_link.csv",
        "oe_link.csv.zip",
        "oe_link_all.csv.zip",
        "oe_link_all.csv");
  }

  private Optional<Path> firstExisting(Path base, String... names) {
    for (String name : names) {
      Path candidate = base.resolve(name);
      if (Files.exists(candidate) && Files.isRegularFile(candidate)) {
        return Optional.of(candidate);
      }
    }
    return Optional.empty();
  }

  private Path resolveDataDir() {
    if (!StringUtils.hasText(properties.getDataDir())) {
      return null;
    }
    return Path.of(properties.getDataDir());
  }

  private InputStream openFile(Path file) throws IOException {
    InputStream raw = Files.newInputStream(file);
    String lower = file.toString().toLowerCase(Locale.ROOT);
    if (!lower.endsWith(".zip")) {
      return raw;
    }
    ZipInputStream zip = new ZipInputStream(raw);
    ZipEntry entry = zip.getNextEntry();
    if (entry == null) {
      zip.close();
      throw new IOException("Zip archive is empty");
    }
    return zip;
  }

  private String normalize(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    String cleaned = CatalogNumberUtils.cleanPreserveSeparators(value);
    return StringUtils.hasText(cleaned) ? cleaned : null;
  }

  private String trimToNull(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    return value.trim();
  }

  private String trimNullLiteral(String value) {
    String trimmed = trimToNull(value);
    if (!StringUtils.hasText(trimmed)) {
      return null;
    }
    return "NULL".equalsIgnoreCase(trimmed) ? null : trimmed;
  }

  private String normalizeOeShort(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    String cleaned = value.replaceAll("[^A-Za-z0-9]", "").toUpperCase(Locale.ROOT).trim();
    if (!StringUtils.hasText(cleaned)) {
      return null;
    }
    if (cleaned.length() > OE_SHORT_MAX_LENGTH) {
      return cleaned.substring(0, OE_SHORT_MAX_LENGTH);
    }
    return cleaned;
  }

  private Integer parseInt(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    try {
      return Integer.parseInt(value.trim());
    } catch (NumberFormatException ex) {
      return null;
    }
  }

  private Long parseLong(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    try {
      return Long.parseLong(value.trim());
    } catch (NumberFormatException ex) {
      return null;
    }
  }

  private BigDecimal parseDecimal(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    try {
      return new BigDecimal(value.trim());
    } catch (NumberFormatException ex) {
      return null;
    }
  }

  private Boolean parseBoolean(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    String trimmed = value.trim();
    if ("1".equals(trimmed)) {
      return true;
    }
    if ("0".equals(trimmed)) {
      return false;
    }
    return null;
  }

  private long durationMs(Instant start) {
    return Duration.between(start, Instant.now()).toMillis();
  }

  public record ImportResult(String file, int rows, long durationMs) {}

  public record ImportSummary(ImportResult master, List<ImportResult> priceLists) {}

  public record PriceListStatus(Integer listNo, Integer count) {}

  public record StatusSummary(
      Integer masterCount,
      java.sql.Timestamp masterUpdatedAt,
      List<PriceListStatus> priceLists,
      java.sql.Timestamp priceUpdatedAt) {}

  public record FileInfo(String key, String path, Long sizeBytes, Long lastModified) {}

  public record FilesSummary(String dataDir, List<FileInfo> files) {}

  private FileInfo buildFileInfo(String key, Path path) {
    try {
      return new FileInfo(
          key,
          path.toString(),
          Files.size(path),
          Files.getLastModifiedTime(path).toMillis());
    } catch (IOException ex) {
      return new FileInfo(key, path.toString(), null, null);
    }
  }
}
