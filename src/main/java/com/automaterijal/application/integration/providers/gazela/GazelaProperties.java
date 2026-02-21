package com.automaterijal.application.integration.providers.gazela;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "integration.gazela")
public class GazelaProperties {

  private boolean enabled = false;
  private String currency = "RSD";
  // Kept for backward compatibility with existing config.
  private Integer warehouseSabacId = 9;
  // Kept for backward compatibility with existing config.
  private Integer defaultDeliveryBusinessDays = 1;
  private DeliveryProfile deliveryProfile = new DeliveryProfile();
  private Api api = new Api();

  public boolean cityBranchAwareEnabled() {
    return deliveryProfile != null && Boolean.TRUE.equals(deliveryProfile.getCityBranchAware());
  }

  public List<Integer> cityWarehouseIds() {
    if (deliveryProfile != null && deliveryProfile.getCityWarehouseIds() != null) {
      List<Integer> configured =
          deliveryProfile.getCityWarehouseIds().stream()
              .filter(Objects::nonNull)
              .filter(id -> id > 0)
              .distinct()
              .toList();
      if (!configured.isEmpty()) {
        return configured;
      }
    }
    if (warehouseSabacId != null && warehouseSabacId > 0) {
      return List.of(warehouseSabacId);
    }
    return List.of();
  }

  public int defaultDeliveryBusinessDaysMin() {
    Integer configured =
        deliveryProfile != null ? deliveryProfile.getDefaultDeliveryBusinessDaysMin() : null;
    if (configured != null && configured > 0) {
      return configured;
    }
    if (defaultDeliveryBusinessDays != null && defaultDeliveryBusinessDays > 0) {
      return defaultDeliveryBusinessDays;
    }
    return 1;
  }

  public int defaultDeliveryBusinessDaysMax() {
    Integer configured =
        deliveryProfile != null ? deliveryProfile.getDefaultDeliveryBusinessDaysMax() : null;
    int min = defaultDeliveryBusinessDaysMin();
    if (configured != null && configured > 0) {
      return Math.max(configured, min);
    }
    if (defaultDeliveryBusinessDays != null && defaultDeliveryBusinessDays > 0) {
      return Math.max(defaultDeliveryBusinessDays, min);
    }
    return Math.max(2, min);
  }

  @Data
  public static class DeliveryProfile {
    private Boolean cityBranchAware = true;
    private List<Integer> cityWarehouseIds = new ArrayList<>();
    private Integer defaultDeliveryBusinessDaysMin = 1;
    private Integer defaultDeliveryBusinessDaysMax = 2;
  }

  @Data
  public static class Api {
    private String baseUrl;
    private Integer userId;
    private String password;
    private Integer connectTimeoutMs = 10000;
    private Integer readTimeoutMs = 10000;
    private Integer maxBatchSize = 20;
    private Long referenceCacheTtlMs = 86400000L;
  }
}
