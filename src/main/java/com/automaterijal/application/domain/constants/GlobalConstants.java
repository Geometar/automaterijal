package com.automaterijal.application.domain.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GlobalConstants {
  public static Integer TECDOC_PODGRUPA_KEY = 1000000;
  public static String TECDOC_PODGRUPA_VALUE = "Tecdoc artikli";

  public static final List<String> ROBA_MANUAL_ATTRIBUTES =
      Collections.unmodifiableList(Arrays.asList("manual-a"));
  public static final List<String> ROBA_MANUAL_YOUTUBE_ATTRIBUTES =
      Collections.unmodifiableList(Arrays.asList("manual-y"));
}
