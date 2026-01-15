package com.automaterijal.application.domain.dto.admin;

import java.util.List;

public record HogwartsOverviewResponse(
    Long generatedAt,
    List<HogwartsStatusSnapshot> statuses,
    List<HogwartsStuckOrder> stuckOrders,
    List<HogwartsProviderSnapshot> providers) {}
