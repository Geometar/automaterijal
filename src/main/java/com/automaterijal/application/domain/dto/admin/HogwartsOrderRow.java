package com.automaterijal.application.domain.dto.admin;

import java.sql.Timestamp;

public record HogwartsOrderRow(
    Integer id,
    Integer orderId,
    Integer ppid,
    Integer status,
    Timestamp lastUpdate,
    Double total) {}
