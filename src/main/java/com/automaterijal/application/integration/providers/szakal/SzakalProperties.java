package com.automaterijal.application.integration.providers.szakal;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "integration.szakal")
public class SzakalProperties {
  public enum OrderMode {
    DISABLED,
    MOCK,
    LIVE
  }

  private boolean enabled = false;
  private String dataDir;
  private String currency = "RSD";
  private Integer leadTimeList0 = 1;
  private Integer leadTimeList1 = 2;
  private Integer leadTimeList2 = 3;
  private Integer leadTimeList3 = 5;
  private Integer deliveryToCustomerBusinessDaysMin;
  private Integer deliveryToCustomerBusinessDaysMax;
  private String warehouseName = "SZAKAL";
  private Sftp sftp = new Sftp();
  private Sync sync = new Sync();
  private Search search = new Search();
  private Order order = new Order();
  private Api api = new Api();

  @Data
  public static class Sftp {
    private String host;
    private Integer port = 22;
    private String username;
    private String password;
    private String remoteDir = "down";
    private Integer connectTimeoutMs = 10000;
    private Integer readTimeoutMs = 60000;
    private String hostKeyFingerprint;
  }

  @Data
  public static class Sync {
    private boolean enabled = false;
    private boolean runOnStart = false;
    private boolean runWeeklyOnStart = false;
    private Integer maxRetries = 3;
    private Long retryBackoffMs = 2000L;
  }

  @Data
  public static class Search {
    private boolean oeExpansionEnabled = true;
    private Integer oeExpansionMinAvailable = 5;
    private Integer oeExpansionMaxOe = 10;
    private Integer oeExpansionMaxResults = 50;
    private Integer oeFallbackMinAvailable = 2;
  }

  @Data
  public static class Order {
    private OrderMode mode = OrderMode.DISABLED;
  }

  @Data
  public static class Api {
    private String baseUrl = "https://webservice.szakalmetal.hu";
    private String username;
    private String password;
    private Integer connectTimeoutMs = 10000;
    private Integer readTimeoutMs = 10000;
    private Long cacheTtlMs = 120000L;
    private Integer stockCheckMaxConcurrency = 3;
  }
}
