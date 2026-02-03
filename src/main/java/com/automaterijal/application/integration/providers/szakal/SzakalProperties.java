package com.automaterijal.application.integration.providers.szakal;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "integration.szakal")
public class SzakalProperties {
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
}
