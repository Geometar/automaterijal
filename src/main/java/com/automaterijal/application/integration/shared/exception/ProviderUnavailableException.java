package com.automaterijal.application.integration.shared.exception;

public class ProviderUnavailableException extends ProviderException {
  public ProviderUnavailableException(String message) {
    super(message);
  }

  public ProviderUnavailableException(String message, Throwable cause) {
    super(message, cause);
  }
}
