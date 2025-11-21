package com.automaterijal.application.utils;

import lombok.experimental.UtilityClass;

import java.text.Normalizer;
import java.util.Locale;

@UtilityClass
public class SlugUtil {
  public static String toSlug(String input) {
    return normalizeSlug(input);
  }

  public static String slugifyWithFallback(String input, String fallback) {
    String slug = normalizeSlug(input);
    if (!slug.isBlank()) {
      return slug;
    }
    String fallbackSlug = normalizeSlug(fallback);
    return fallbackSlug.isBlank() ? "n-a" : fallbackSlug;
  }

  private static String normalizeSlug(String input) {
    if (input == null || input.isBlank()) {
      return "";
    }

    String normalized =
        Normalizer.normalize(input, Normalizer.Form.NFD)
            .replaceAll("\\p{M}", "") // skini dijakritike
            .toLowerCase(Locale.ROOT)
            .replaceAll("[^a-z0-9\\s-]", "")
            .trim()
            .replaceAll("\\s+", "-");

    return normalized.replaceAll("-{2,}", "-").replaceAll("^-|-$", "");
  }
}
