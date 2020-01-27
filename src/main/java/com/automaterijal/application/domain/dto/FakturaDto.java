package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FakturaDto {
    Integer id;
    Integer orderId;
    String vremePorucivanja;
    ValueHelpDto status;
    ValueHelpDto nacinPlacanja;
    ValueHelpDto nacinPrevoza;
    ValueHelpDto adresa;
    String napomena;
    Double iznosNarucen;
    Double iznosPotvrdjen;
    Integer brojStavki;
    List<FakturaDetaljiDto> detalji;
}
