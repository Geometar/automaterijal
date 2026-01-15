package com.automaterijal.application.domain.dto.admin;

public record HogwartsStuckOrder(
    Integer id,
    Integer orderId,
    Integer ppid,
    String partnerName,
    Integer status,
    Long lastUpdate,
    Long ageMinutes,
    Double total) {}
