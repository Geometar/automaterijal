package com.automaterijal.application.domain.dto.admin;

public record HogwartsRevenueMetrics(
    Long orders,
    Double revenue,
    Long activePartners,
    Double aov,
    Double ordersPerActivePartner) {}

