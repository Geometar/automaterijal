package com.automaterijal.application.integration.shared.exception;

public class ProviderRateLimitException extends ProviderException {
  public ProviderRateLimitException(String message) {
    super(message);
  }

  public ProviderRateLimitException(String message, Throwable cause) {
    super(message, cause);
  }
}
