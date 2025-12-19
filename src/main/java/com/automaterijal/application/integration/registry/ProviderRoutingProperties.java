package com.automaterijal.application.integration.registry;

import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "integration.providers")
public class ProviderRoutingProperties {

  private List<Rule> rules = new ArrayList<>();

  @Data
  public static class Rule {
    private String provider;
    private Boolean enabled = true;
    private Integer priority;
    private Set<ProviderRoutingPurpose> purposes = new HashSet<>();
    private Set<String> brands = new HashSet<>();
    private Set<String> groups = new HashSet<>();
    private Integer minLocalMatchCount;
    private Integer maxLocalMatchCount;
    private Integer minLocalAvailableCount;
    private Integer maxLocalAvailableCount;
  }
}
