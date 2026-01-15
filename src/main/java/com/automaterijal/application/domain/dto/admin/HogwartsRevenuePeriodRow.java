package com.automaterijal.application.domain.dto.admin;

public record HogwartsRevenuePeriodRow(
    Integer year,
    Long from,
    Long to,
    HogwartsRevenueMetrics metrics) {}

