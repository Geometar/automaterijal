package com.automaterijal.application.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LogWebDto {
  Long id;
  Integer ppid;
  String proizvodjac;
  String filter;
  String pretraga;
  LocalDateTime vremePretrage;
}
