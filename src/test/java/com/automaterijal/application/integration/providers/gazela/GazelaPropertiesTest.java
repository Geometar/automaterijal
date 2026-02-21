package com.automaterijal.application.integration.providers.gazela;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GazelaPropertiesTest {

  @Test
  void cityWarehouseIdsFallsBackToLegacyWarehouseWhenDeliveryProfileListIsEmpty() {
    GazelaProperties properties = new GazelaProperties();
    properties.setWarehouseSabacId(15);
    properties.getDeliveryProfile().setCityWarehouseIds(List.of());

    assertThat(properties.cityWarehouseIds()).containsExactly(15);
  }

  @Test
  void cityWarehouseIdsUsesDeliveryProfileWhenConfigured() {
    GazelaProperties properties = new GazelaProperties();
    properties.setWarehouseSabacId(15);
    properties.getDeliveryProfile().setCityWarehouseIds(List.of(9, 11));

    assertThat(properties.cityWarehouseIds()).containsExactly(9, 11);
  }
}
