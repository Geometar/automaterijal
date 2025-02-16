package com.automaterijal.application.domain.dto.tecdoc;

public record Model(
    Long modelId,
    Integer favoriteFlag,
    String name,
    Integer constructedFrom,
    Integer constructedTo) {}
