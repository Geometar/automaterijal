package com.automaterijal.application.integration.shared.exception;

public class ProviderAuthenticationException extends ProviderException {
  public ProviderAuthenticationException(String message) {
    super(message);
  }

  public ProviderAuthenticationException(String message, Throwable cause) {
    super(message, cause);
  }
}
