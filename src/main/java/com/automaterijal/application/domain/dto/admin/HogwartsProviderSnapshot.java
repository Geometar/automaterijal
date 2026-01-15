package com.automaterijal.application.domain.dto.admin;

public record HogwartsProviderSnapshot(
    String providerKey,
    Long lastOrderAt,
    Long ordersLast10d,
    Long backorderCountLast10d,
    Long messageCountLast10d) {}
