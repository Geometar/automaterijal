package com.automaterijal.application.domain.dto.email;

public abstract class Email {

  protected Email() {
    throw new IllegalStateException("Utility class");
  }

  public static final String EMAIL_ZA_SLANJE = "webshop@automaterijal.com";
  public static final String EMAIL_ZA_PRIMANJE = "radespasoje@gmail.com";
  public static final String RADOV_EMAIL = "radespasoje@gmail.com";
}
