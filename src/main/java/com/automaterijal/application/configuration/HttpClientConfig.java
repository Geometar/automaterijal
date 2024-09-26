package com.automaterijal.application.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Duration;
import java.util.Collections;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HttpClientConfig {
  
  @Bean
  public WebClient webClient(WebClient.Builder builder) {
    return builder.build();
  }

  @Bean
  public RestTemplate getRestClient(RestTemplateBuilder builder) {
    RestTemplate restClient = builder.setConnectTimeout(Duration.ofSeconds(10))
            .setReadTimeout(Duration.ofSeconds(10)).build();

    // Add one interceptor like in your example, except using anonymous class.
    restClient.setInterceptors(Collections.singletonList((request, body, execution) ->
            execution.execute(request, body)
    ));

    return restClient;
  }

  @Bean
  public ObjectMapper objectMapper() {
    final ObjectMapper objectMapper = new ObjectMapper();

    // Register JavaTimeModule to handle LocalDateTime and other Java 8 time types
    objectMapper.registerModule(new JavaTimeModule());

    // Disable writing dates as timestamps to use ISO-8601 format
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    // Other configurations
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    objectMapper.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);
    objectMapper.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
    objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

    return objectMapper;
  }
}
