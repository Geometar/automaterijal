package com.automaterijal.application.services.security;

import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.utils.JwtUtils;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

public class AuthTokenFilter extends OncePerRequestFilter {

  @Autowired private JwtUtils jwtUtils;

  @Autowired private UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String jwt = parseJwt(request);
    if (jwt != null) {
      try {
        if (jwtUtils.validateJwtToken(jwt)) {
          String username = jwtUtils.getUserNameFromJwtToken(jwt);

          CurrentUser currentUser = userDetailsService.loadUserByUsername(username);
          UsernamePasswordAuthenticationToken authentication =
              new UsernamePasswordAuthenticationToken(
                  currentUser, null, currentUser.getAuthorities());
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

          SecurityContextHolder.getContext().setAuthentication(authentication);
        }
      } catch (ResponseStatusException ex) {
        SecurityContextHolder.clearContext();
        response.sendError(ex.getStatusCode().value(), ex.getReason());
        return;
      } catch (JwtException ex) {
        SecurityContextHolder.clearContext();
        response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid JWT token");
        return;
      } catch (RuntimeException ex) {
        SecurityContextHolder.clearContext();
        response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        return;
      }
    }

    filterChain.doFilter(request, response);
  }

  private String parseJwt(HttpServletRequest request) {
    String headerAuth = request.getHeader("Authorization");

    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
      String token = headerAuth.substring(7).trim();
      if (!StringUtils.hasText(token)) {
        return null;
      }
      if ("null".equalsIgnoreCase(token) || "undefined".equalsIgnoreCase(token)) {
        return null;
      }
      return token;
    }

    return null;
  }
}
