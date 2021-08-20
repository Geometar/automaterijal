package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlikeUtility {

    String proid;
    String sadrzaj;
    String konstanta;

    public static List<SlikeUtility> vratiSveUtilitySlike() {
        return Arrays.asList(
                new SlikeUtility("CONTI", "6PK", "31_PROFPIC_6PK.jpg"),
                new SlikeUtility("CONTI", "5PK", "31_PROFPIC_5PK.jpg"),
                new SlikeUtility("CONTI", "4PK", "31_PROFPIC_4PK.jpg"),
                new SlikeUtility("CONTI", "3PK", "31_PROFPIC_3PK.jpg"),
                new SlikeUtility("CONTI", "7PK", "31_PROFPIC_7PK.jpg"),
                new SlikeUtility("CONTI", "8PK", "31_PROFPIC_8PK.jpg"),
                new SlikeUtility("CONTI", "9PK", "31_PROFPIC_9PK.jpg"),
                new SlikeUtility("CONTI", "10PK", "31_PROFPIC_10PK.jpg"),
                new SlikeUtility("CONTI", "11PK", "31_PROFPIC_11PK.jpg")
        );
    }

}
