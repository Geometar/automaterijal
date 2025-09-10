package com.automaterijal.application.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SlugUtil {
  public String toSlug(String input) {
    if (input == null || input.isBlank()) return "";

    String normalized =
        input
            .toLowerCase()
            .replaceAll("[čć]", "c")
            .replaceAll("đ", "dj")
            .replaceAll("š", "s")
            .replaceAll("ž", "z")
            .replaceAll("[^a-z0-9\\s-]", "") // izbaci specijalne znakove
            .trim()
            .replaceAll("\\s+", "-"); // whitespace -> -

    // spoji duple crtice i ukloni na krajevima
    return normalized.replaceAll("-{2,}", "-").replaceAll("^-|-$", "");
  }
}
