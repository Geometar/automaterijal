package com.automaterijal.application.utils;

import java.util.Locale;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

@UtilityClass
public class CatalogNumberUtils {
  private static final Pattern WHITESPACE = Pattern.compile("\\s+");

  public String cleanPreserveSeparators(String value) {
    if (!StringUtils.hasText(value)) {
      return value;
    }
    String withoutWhitespace = WHITESPACE.matcher(value).replaceAll("");
    return withoutWhitespace.replace("-LUČ", "").toUpperCase(Locale.ROOT).trim();
  }

  public String stripWhitespace(String value) {
    return value == null ? null : WHITESPACE.matcher(value).replaceAll("");
  }

  public boolean equalsWhenCleaned(String left, String right) {
    String first = cleanPreserveSeparators(left);
    String second = cleanPreserveSeparators(right);
    if (first == null || second == null) {
      return false;
    }
    return first.equalsIgnoreCase(second);
  }
}
