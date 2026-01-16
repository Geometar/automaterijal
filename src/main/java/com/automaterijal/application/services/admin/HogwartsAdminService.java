package com.automaterijal.application.services.admin;

import com.automaterijal.application.domain.constants.StatusiKonstante;
import com.automaterijal.application.domain.dto.admin.HogwartsOrderRow;
import com.automaterijal.application.domain.dto.admin.HogwartsOverviewResponse;
import com.automaterijal.application.domain.dto.admin.HogwartsProviderSnapshot;
import com.automaterijal.application.domain.dto.admin.HogwartsRevenueAggRow;
import com.automaterijal.application.domain.dto.admin.HogwartsRevenueMetrics;
import com.automaterijal.application.domain.dto.admin.HogwartsRevenueOverviewResponse;
import com.automaterijal.application.domain.dto.admin.HogwartsRevenuePeriodRow;
import com.automaterijal.application.domain.dto.admin.HogwartsStatusSnapshot;
import com.automaterijal.application.domain.dto.admin.HogwartsStuckOrder;
import com.automaterijal.application.domain.dto.admin.PartnerNameRow;
import com.automaterijal.application.domain.dto.admin.ProviderActivityRow;
import com.automaterijal.application.domain.repository.FakturaRepository;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.domain.repository.weborder.WebOrderItemRepository;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HogwartsAdminService {

  static final int STUCK_LIMIT = 20;
  static final int MAX_P95_SAMPLE = 2000;
  static final int LOOKBACK_DAYS = 10;
  static final int REVENUE_DAYS_DEFAULT = 30;
  static final int REVENUE_YEARS_DEFAULT = 10;

  @NonNull FakturaRepository fakturaRepository;
  @NonNull WebOrderItemRepository webOrderItemRepository;
  @NonNull PartnerRepository partnerRepository;

  public HogwartsOverviewResponse fetchOverview() {
    Instant now = Instant.now();
    Timestamp lookbackStart = Timestamp.from(now.minus(Duration.ofDays(LOOKBACK_DAYS)));
    List<HogwartsStatusSnapshot> statuses =
        List.of(
            buildStatusSnapshot(StatusiKonstante.NIJE_UZETA_U_OBRADU, 30, now, lookbackStart),
            buildStatusSnapshot(StatusiKonstante.OBRADA_U_TOKU, 60, now, lookbackStart));

    return new HogwartsOverviewResponse(
        now.toEpochMilli(),
        statuses,
        buildStuckOrders(now, lookbackStart),
        buildProviderSnapshots(now, lookbackStart));
  }

  public HogwartsRevenueOverviewResponse fetchRevenueOverview(Integer days, Integer years) {
    int effectiveDays = days != null && days > 0 ? days : REVENUE_DAYS_DEFAULT;
    int effectiveYears = years != null && years > 0 ? years : REVENUE_YEARS_DEFAULT;

    ZoneId zone = ZoneId.systemDefault();
    ZonedDateTime now = ZonedDateTime.now(zone);
    ZonedDateTime currentTo = now;
    ZonedDateTime currentFrom = now.minusDays(effectiveDays);

    HogwartsRevenueMetrics current =
        computeRevenueMetrics(Timestamp.from(currentFrom.toInstant()), Timestamp.from(currentTo.toInstant()));

    List<HogwartsRevenuePeriodRow> history = new ArrayList<>();
    for (int i = 0; i < effectiveYears; i++) {
      ZonedDateTime from = currentFrom.minusYears(i);
      ZonedDateTime to = currentTo.minusYears(i);
      HogwartsRevenueMetrics metrics =
          computeRevenueMetrics(Timestamp.from(from.toInstant()), Timestamp.from(to.toInstant()));
      history.add(
          new HogwartsRevenuePeriodRow(
              to.getYear(), from.toInstant().toEpochMilli(), to.toInstant().toEpochMilli(), metrics));
    }
    history.sort(Comparator.comparing(HogwartsRevenuePeriodRow::year).reversed());

    return new HogwartsRevenueOverviewResponse(
        currentTo.toInstant().toEpochMilli(),
        effectiveDays,
        effectiveYears,
        currentFrom.toInstant().toEpochMilli(),
        currentTo.toInstant().toEpochMilli(),
        current,
        history);
  }

  private HogwartsRevenueMetrics computeRevenueMetrics(Timestamp from, Timestamp to) {
    HogwartsRevenueAggRow row = fakturaRepository.fetchRevenueAgg(from, to);
    long orders = row != null && row.getOrders() != null ? row.getOrders() : 0L;
    double revenue = row != null && row.getRevenue() != null ? row.getRevenue() : 0.0;
    long activePartners = row != null && row.getActivePartners() != null ? row.getActivePartners() : 0L;

    Double aov = orders > 0 ? revenue / orders : null;
    Double ordersPerActivePartner = activePartners > 0 ? (double) orders / activePartners : null;

    return new HogwartsRevenueMetrics(orders, revenue, activePartners, aov, ordersPerActivePartner);
  }

  private HogwartsStatusSnapshot buildStatusSnapshot(
      StatusiKonstante status, int windowMinutes, Instant now, Timestamp lookbackStart) {
    Integer statusValue = status.getFieldValue();
    long count = fakturaRepository.countByStatusAndLastUpdateAfter(statusValue, lookbackStart);
    Timestamp oldest =
        fakturaRepository.findOldestUpdateByStatusSince(statusValue, lookbackStart);
    Timestamp windowStart = Timestamp.from(now.minus(Duration.ofMinutes(windowMinutes)));
    Timestamp windowBoundary = windowStart.after(lookbackStart) ? windowStart : lookbackStart;
    long updatedLastWindow =
        fakturaRepository.countByStatusAndLastUpdateAfter(statusValue, windowBoundary);
    Long oldestMinutes = toMinutes(oldest, now);
    Long p95Minutes = null;
    if (count > 0 && count <= MAX_P95_SAMPLE) {
      p95Minutes =
          percentileMinutes(
              fakturaRepository.findUpdatesByStatusSince(statusValue, lookbackStart),
              now,
              0.95);
    }

    return new HogwartsStatusSnapshot(
        statusValue, count, windowMinutes, updatedLastWindow, oldestMinutes, p95Minutes);
  }

  private List<HogwartsStuckOrder> buildStuckOrders(Instant now, Timestamp lookbackStart) {
    List<Integer> statuses =
        List.of(
            StatusiKonstante.NIJE_UZETA_U_OBRADU.getFieldValue(),
            StatusiKonstante.OBRADA_U_TOKU.getFieldValue());
    List<HogwartsOrderRow> rows =
        fakturaRepository.findStuckOrders(
            statuses, lookbackStart, PageRequest.of(0, STUCK_LIMIT));
    Map<Integer, String> partnerNames = resolvePartnerNames(rows);

    return rows.stream()
        .map(
            row ->
                new HogwartsStuckOrder(
                    row.id(),
                    row.orderId(),
                    row.ppid(),
                    partnerNames.get(row.ppid()),
                    row.status(),
                    row.lastUpdate() != null ? row.lastUpdate().getTime() : null,
                    toMinutes(row.lastUpdate(), now),
                    row.total()))
        .collect(Collectors.toList());
  }

  private List<HogwartsProviderSnapshot> buildProviderSnapshots(
      Instant now, Timestamp lookbackStart) {
    List<ProviderActivityRow> rows = webOrderItemRepository.fetchProviderActivity(lookbackStart);
    return rows.stream()
        .map(
            row ->
                new HogwartsProviderSnapshot(
                    normalizeProviderKey(row.getProviderKey()),
                    row.getLastItemAt() != null ? row.getLastItemAt().getTime() : null,
                    safeLong(row.getLast10dCount()),
                    safeLong(row.getBackorderCount10d()),
                    safeLong(row.getMessageCount10d())))
        .sorted(
            Comparator.comparing(
                    HogwartsProviderSnapshot::lastOrderAt,
                    Comparator.nullsLast(Comparator.naturalOrder()))
                .reversed())
        .collect(Collectors.toList());
  }

  private Map<Integer, String> resolvePartnerNames(List<HogwartsOrderRow> rows) {
    if (rows == null || rows.isEmpty()) {
      return Map.of();
    }
    List<Integer> ppids =
        rows.stream()
            .map(HogwartsOrderRow::ppid)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
    if (ppids.isEmpty()) {
      return Map.of();
    }

    Map<Integer, String> names = new HashMap<>();
    for (PartnerNameRow row : partnerRepository.findByPpidIn(ppids)) {
      if (row.getPpid() != null) {
        names.put(row.getPpid(), row.getNaziv());
      }
    }
    return names;
  }

  private Long percentileMinutes(List<Timestamp> updates, Instant now, double percentile) {
    if (updates == null || updates.isEmpty()) {
      return null;
    }
    List<Long> ages = new ArrayList<>();
    for (Timestamp timestamp : updates) {
      if (timestamp == null) {
        continue;
      }
      ages.add(Math.max(0, Duration.between(timestamp.toInstant(), now).toMinutes()));
    }
    if (ages.isEmpty()) {
      return null;
    }
    Collections.sort(ages);
    int index = (int) Math.ceil(percentile * ages.size()) - 1;
    index = Math.min(Math.max(index, 0), ages.size() - 1);
    return ages.get(index);
  }

  private Long toMinutes(Timestamp timestamp, Instant now) {
    if (timestamp == null) {
      return null;
    }
    return Math.max(0, Duration.between(timestamp.toInstant(), now).toMinutes());
  }

  private String normalizeProviderKey(String providerKey) {
    if (providerKey == null) {
      return null;
    }
    String trimmed = providerKey.trim();
    return trimmed.isEmpty() ? null : trimmed;
  }

  private Long safeLong(Long value) {
    return value == null ? 0L : value;
  }
}
