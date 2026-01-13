package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FakturaDetaljiDto {

    Long robaId;
    Long tecDocArticleId;
    SlikaDto slika;
    String kataloskiBroj;
    String kataloskiBrojProizvodjaca;
    String naziv;
    Proizvodjac proizvodjac;
    Double kolicina;
    Double potvrdjenaKolicina;
    Double cena;
    ValueHelpDto status;
    Double rabat;
    String vremePorucivanja;
    String izvor;
    ProviderAvailabilityDto providerAvailability;
    ArticleAvailabilityStatus availabilityStatus;
    Boolean providerBackorder;
    String providerMessage;
    String providerDeliveryParty;

}
