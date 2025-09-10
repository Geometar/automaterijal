package com.automaterijal.application.utils;

import lombok.experimental.UtilityClass;

import java.text.Normalizer;

@UtilityClass
public class SlugUtil {
  public static String toSlug(String input) {
    if (input == null || input.isBlank()) return "";

    String normalized =
        Normalizer.normalize(input, Normalizer.Form.NFD)
            .replaceAll("\\p{M}", "") // skini dijakritike
            .toLowerCase()
            .replaceAll("[^a-z0-9\\s-]", "")
            .trim()
            .replaceAll("\\s+", "-");

    return normalized.replaceAll("-{2,}", "-").replaceAll("^-|-$", "");
  }
}
