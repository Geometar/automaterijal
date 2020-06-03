package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExternalRobaDto {

    String ItemNo;
    String Description;
    Double Quantity;
    Double Price;
    boolean Sucess;
    String ErrorMessage;

}
