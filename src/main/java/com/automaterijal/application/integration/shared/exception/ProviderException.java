package com.automaterijal.application.integration.shared.exception;

public class ProviderException extends RuntimeException {

  public ProviderException(String message) {
    super(message);
  }

  public ProviderException(String message, Throwable cause) {
    super(message, cause);
  }
}
