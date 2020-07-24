package com.automaterijal.application.domain.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class JwtResponse {
    String token;
    int id;
    String username;
    String email;
    List<String> roles;
}
