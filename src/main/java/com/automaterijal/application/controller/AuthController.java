package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.JwtResponse;
import com.automaterijal.application.domain.dto.LoginRequestDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.services.PartnerService;
import com.automaterijal.application.utils.JwtUtils;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired AuthenticationManager authenticationManager;

  @Autowired PartnerService partnerService;

  @Autowired PasswordEncoder encoder;

  @Autowired JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<JwtResponse> authenticateUser(
      @Valid @RequestBody LoginRequestDto loginRequest) {
    Authentication authentication;
    try {
      authentication =
          authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                  loginRequest.getUsername(), loginRequest.getPassword()));

    } catch (AuthenticationException ex) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los zahtev");
    }

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    CurrentUser userDetails = (CurrentUser) authentication.getPrincipal();
    List<String> roles =
        userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
    Partner partner = partnerService.pronadjiPartneraPoId(userDetails.getId());

    return ResponseEntity.ok(
        new JwtResponse(
            jwt, userDetails.getId(), userDetails.getUsername(), partner.getEmail(), roles));
  }
}
