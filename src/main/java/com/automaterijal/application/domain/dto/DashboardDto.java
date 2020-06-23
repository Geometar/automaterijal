package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DashboardDto {
    Integer brojArtikala;
    Integer brojProizvodjaca;
    Integer brojFaktura;
}
