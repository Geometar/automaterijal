package com.automaterijal.application.utils;

import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

@UtilityClass
public class GeneralUtil {

    public LocalDate timestampToLDT(final Long timestamp) {
        return LocalDate.ofInstant(
                Instant.ofEpochMilli(timestamp),
                TimeZone.getDefault().toZoneId()
        );
    }
    public Timestamp LDTToTimestamp(final LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

}
