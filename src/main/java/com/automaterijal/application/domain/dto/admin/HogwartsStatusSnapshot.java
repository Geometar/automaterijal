package com.automaterijal.application.domain.dto.admin;

public record HogwartsStatusSnapshot(
    Integer status,
    Long count,
    Integer windowMinutes,
    Long updatedLastWindow,
    Long oldestMinutes,
    Long p95Minutes) {}
