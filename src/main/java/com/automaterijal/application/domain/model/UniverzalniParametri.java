package com.automaterijal.application.domain.model;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UniverzalniParametri {

    Integer page;
    Integer pageSize;
    String proizvodjac;
    Boolean naStanju;
    RobaSortiranjePolja sortiranjePolja;
    Sort.Direction direction;
    String trazenKatBroj;
}
