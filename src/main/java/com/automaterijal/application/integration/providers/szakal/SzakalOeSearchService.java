package com.automaterijal.application.integration.providers.szakal;

import com.automaterijal.application.integration.providers.szakal.model.SzakalMasterProduct;
import com.automaterijal.application.integration.providers.szakal.model.SzakalPriceListItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class SzakalOeSearchService {
  private static final Pattern NON_ALNUM = Pattern.compile("[^A-Za-z0-9]");
  private static final int OE_SHORT_MAX_LENGTH = 160;
  private static final int IN_CLAUSE_LIMIT = 500;

  private final JdbcTemplate jdbcTemplate;
  private final SzakalMasterProductRepository masterRepository;
  private final SzakalPriceListItemRepository priceListRepository;
  private final SzakalProperties properties;

  public List<OeSearchResult> searchByOe(String oeNumber) {
    String normalized = normalizeOeShort(oeNumber);
    if (!StringUtils.hasText(normalized)) {
      return List.of();
    }

    List<OeLinkRow> links =
        jdbcTemplate.query(
            "select glid, oe_short, oe, maker, tecdoc_name from szakal_oe_links where oe_short = ?",
            (rs, rowNum) ->
                new OeLinkRow(
                    rs.getString("glid"),
                    rs.getString("oe_short"),
                    rs.getString("oe"),
                    rs.getString("maker"),
                    rs.getString("tecdoc_name")),
            normalized);

    if (links.isEmpty()) {
      return List.of();
    }

    Set<String> glids =
        links.stream()
            .map(OeLinkRow::glid)
            .filter(StringUtils::hasText)
            .collect(Collectors.toSet());
    if (glids.isEmpty()) {
      return List.of();
    }

    Map<String, SzakalMasterProduct> masterByGlid = new HashMap<>();
    for (SzakalMasterProduct product : masterRepository.findAllById(glids)) {
      if (product != null && StringUtils.hasText(product.getGlid())) {
        masterByGlid.putIfAbsent(product.getGlid(), product);
      }
    }

    List<SzakalPriceListItem> priceItems = priceListRepository.findByGlidIn(glids);
    Map<String, SzakalPriceListItem> bestByGlid = selectFastest(priceItems);

    List<OeSearchResult> results = new ArrayList<>();
    for (OeLinkRow link : links) {
      if (link == null || !StringUtils.hasText(link.glid())) {
        continue;
      }
      SzakalPriceListItem best = bestByGlid.get(link.glid());
      if (best == null || best.getStock() == null || best.getStock() <= 0) {
        continue;
      }
      SzakalMasterProduct product = masterByGlid.get(link.glid());
      results.add(
          new OeSearchResult(
              link.glid(),
              link.oeShort(),
              link.oe(),
              link.maker(),
              link.tecdocName(),
              product != null ? product.getBrandName() : null,
              product != null ? product.getNameRs() : null,
              product != null ? product.getNameEn() : null,
              product != null ? product.getArticleCodeNorm() : null,
              product != null ? product.getTecdocArtnrNorm() : null,
              product != null ? product.getUnit() : null,
              best.getStock(),
              best.getUnitPrice(),
              best.getListNo(),
              best.getOrderDeadline(),
              best.getToken(),
              best.getQuantum(),
              best.getNotReturnable(),
              resolveLeadTime(best.getListNo())));
    }

    return results;
  }

  public List<OeSearchResult> searchByTecdocKeys(
      List<TecdocKey> keys, int maxOeNumbers, int maxResults) {
    if (keys == null || keys.isEmpty() || maxOeNumbers <= 0 || maxResults <= 0) {
      return List.of();
    }

    Map<Long, List<String>> artnrsByDlnr = new HashMap<>();
    for (TecdocKey key : keys) {
      if (key == null || key.dlnr() == null || !StringUtils.hasText(key.artnrNorm())) {
        continue;
      }
      artnrsByDlnr.computeIfAbsent(key.dlnr(), ignored -> new ArrayList<>()).add(key.artnrNorm());
    }
    if (artnrsByDlnr.isEmpty()) {
      return List.of();
    }

    Set<String> glids = new LinkedHashSet<>();
    for (Map.Entry<Long, List<String>> entry : artnrsByDlnr.entrySet()) {
      List<String> artnrs =
          entry.getValue().stream().filter(StringUtils::hasText).distinct().toList();
      if (artnrs.isEmpty()) {
        continue;
      }
      for (SzakalMasterProduct product :
          masterRepository.findByTecdocDlnrAndTecdocArtnrNormIn(entry.getKey(), artnrs)) {
        if (product != null && StringUtils.hasText(product.getGlid())) {
          glids.add(product.getGlid());
        }
      }
    }

    if (glids.isEmpty()) {
      return List.of();
    }

    List<String> oeShorts = loadOeShortsForGlids(glids, maxOeNumbers);
    if (oeShorts.isEmpty()) {
      return List.of();
    }

    List<OeSearchResult> results = new ArrayList<>();
    Set<String> seenGlids = new LinkedHashSet<>();
    for (String oeShort : oeShorts) {
      if (!StringUtils.hasText(oeShort)) {
        continue;
      }
      for (OeSearchResult match : searchByOe(oeShort)) {
        if (match == null || !StringUtils.hasText(match.glid())) {
          continue;
        }
        if (!seenGlids.add(match.glid())) {
          continue;
        }
        results.add(match);
        if (results.size() >= maxResults) {
          return results;
        }
      }
    }
    return results;
  }

  private Map<String, SzakalPriceListItem> selectFastest(List<SzakalPriceListItem> items) {
    Map<String, SzakalPriceListItem> best = new HashMap<>();
    if (CollectionUtils.isEmpty(items)) {
      return best;
    }

    items.stream()
        .filter(Objects::nonNull)
        .filter(item -> item.getStock() != null && item.getStock() > 0)
        .sorted(Comparator.comparingInt(item -> item.getListNo() != null ? item.getListNo() : 9))
        .forEach(
            item -> {
              String glid = item.getGlid();
              if (!StringUtils.hasText(glid)) {
                return;
              }
              best.putIfAbsent(glid, item);
            });
    return best;
  }

  private Integer resolveLeadTime(Integer listNo) {
    int list = listNo != null ? listNo : 3;
    return switch (list) {
      case 0 -> properties.getLeadTimeList0();
      case 1 -> properties.getLeadTimeList1();
      case 2 -> properties.getLeadTimeList2();
      case 3 -> properties.getLeadTimeList3();
      default -> properties.getLeadTimeList3();
    };
  }

  private String normalizeOeShort(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    String trimmed = value.trim().toUpperCase(Locale.ROOT);
    if (trimmed.endsWith("-OE")) {
      trimmed = trimmed.substring(0, trimmed.length() - 3);
    }
    String cleaned = NON_ALNUM.matcher(trimmed).replaceAll("");
    if (!StringUtils.hasText(cleaned)) {
      return null;
    }
    if (cleaned.length() > OE_SHORT_MAX_LENGTH) {
      return cleaned.substring(0, OE_SHORT_MAX_LENGTH);
    }
    return cleaned;
  }

  private List<String> loadOeShortsForGlids(Set<String> glids, int limit) {
    if (glids == null || glids.isEmpty() || limit <= 0) {
      return List.of();
    }

    List<String> glidList = new ArrayList<>(glids);
    LinkedHashSet<String> oeShorts = new LinkedHashSet<>();
    int offset = 0;
    while (offset < glidList.size() && oeShorts.size() < limit) {
      int end = Math.min(offset + IN_CLAUSE_LIMIT, glidList.size());
      List<String> chunk = glidList.subList(offset, end);
      String placeholders = chunk.stream().map(value -> "?").collect(Collectors.joining(","));
      String sql =
          "select distinct oe_short from szakal_oe_links where glid in ("
              + placeholders
              + ")";
      List<String> rows =
          jdbcTemplate.query(
              sql,
              chunk.toArray(),
              (rs, rowNum) -> rs.getString("oe_short"));
      for (String oe : rows) {
        if (!StringUtils.hasText(oe)) {
          continue;
        }
        oeShorts.add(oe);
        if (oeShorts.size() >= limit) {
          break;
        }
      }
      offset = end;
    }
    return new ArrayList<>(oeShorts);
  }

  private record OeLinkRow(
      String glid, String oeShort, String oe, String maker, String tecdocName) {}

  public record TecdocKey(Long dlnr, String artnrNorm) {}

  public record OeSearchResult(
      String glid,
      String oeShort,
      String oe,
      String maker,
      String tecdocName,
      String brandName,
      String nameRs,
      String nameEn,
      String articleCodeNorm,
      String tecdocArtnrNorm,
      String unit,
      Integer stock,
      java.math.BigDecimal unitPrice,
      Integer listNo,
      String orderDeadline,
      String token,
      Integer quantum,
      Boolean notReturnable,
      Integer leadTimeDays) {}
}
