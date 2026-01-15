package com.automaterijal.application.domain.dto.admin;

import java.util.List;

public record HogwartsRevenueOverviewResponse(
    Long generatedAt,
    Integer days,
    Integer years,
    Long currentFrom,
    Long currentTo,
    HogwartsRevenueMetrics current,
    List<HogwartsRevenuePeriodRow> history) {}

