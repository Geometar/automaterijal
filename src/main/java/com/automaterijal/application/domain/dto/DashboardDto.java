package com.automaterijal.application.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DashboardDto {
    Integer brojArtikala;
    Integer brojProizvodjaca;
    Integer brojFaktura;
}
