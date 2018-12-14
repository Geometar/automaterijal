package com.automaterijal.application.domain.mapper;

import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Mapper
public interface MapperUtil {

    default LocalDateTime map(final Timestamp timestamp) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timestamp.getTime()),
                TimeZone.getDefault().toZoneId()
        );
    }
    default Timestamp map(final LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    default String mapToString(final LocalDateTime ldt) {
        return LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute(), ldt.getSecond())
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy-hh:mm"));
    }
}
