package com.automaterijal.application.configuration;

import com.automaterijal.application.services.security.AuthEntryPointJwt;
import com.automaterijal.application.services.security.AuthTokenFilter;
import com.automaterijal.application.utils.LoginStaticUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableScheduling
@EnableWebSecurity
public class SecurityConfiguration {
  @Autowired private UserDetailsService userDetailsService;

  @Autowired private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.cors()
        .and()
        .csrf()
        .disable()
        .sessionManagement()
        .maximumSessions(10)
        .sessionRegistry(sessionRegistry())
        .and()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(unauthorizedHandler)
        .and()
        .authorizeHttpRequests(
            (requests) ->
                requests
                    .requestMatchers(
                        "/api/auth/signin",
                        "/static/**",
                        "/",
                        "/*.js",
                        "/*.ico",
                        "/*.css",
                        "/assets/slike/**")
                    .permitAll()
                    .requestMatchers("/api/**")
                    .permitAll()
                    .requestMatchers(
                        "/sitemap.xml",
                        "/sitemap-brands.xml",
                        "/sitemap-brand-pages.xml",
                        "/sitemap-categories.xml",
                        "/sitemap-blog.xml",
                        "/sitemap-products**",
                        "/sitemap-static.xml",
                        "/webshop/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .logout(
            (logout) ->
                logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/api/roba")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .permitAll());

    http.addFilterBefore(
        authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new PasswordEncoder() {
      @Override
      public String encode(CharSequence rawPassword) {
        return LoginStaticUtils.md5Password(rawPassword.toString());
      }

      @Override
      public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return LoginStaticUtils.md5Password(rawPassword.toString()).equals(encodedPassword);
      }
    };
  }

  @Bean
  public SessionRegistry sessionRegistry() {
    return new SessionRegistryImpl();
  }

  @Bean
  public HttpSessionEventPublisher httpSessionEventPublisher() {
    return new HttpSessionEventPublisher();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(
        List.of(
            "https://automaterijal.com",
            "https://automaterijal.com",
            "http://localhost:4200",
            "http://127.0.0.1:4200",
            "http://localhost:4000",
            "http://127.0.0.1:4000"));
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
    configuration.setAllowCredentials(true); // Allow credentials for these specific origins
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
