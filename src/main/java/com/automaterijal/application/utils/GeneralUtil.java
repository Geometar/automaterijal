package com.automaterijal.application.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

@UtilityClass
public class GeneralUtil {

    public LocalDate timestampToLDT(Long timestamp) {
        return LocalDate.ofInstant(
                Instant.ofEpochMilli(timestamp),
                TimeZone.getDefault().toZoneId()
        );
    }

    public String cyrillicToLatinic(String text) {
        String[] abcCyr = {"Š", "Đ", "Ć", "Č", "Ž"};
        String[] abcLat = {"S", "D", "C", "C", "Z"};
        return StringUtils.replaceEach(text, abcCyr, abcLat);
    }

    public Timestamp LDTToTimestamp(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

}
