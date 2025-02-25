package com.automaterijal.application.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@UtilityClass
public class GeneralUtil {

  public LocalDate timestampToLDT(Long timestamp) {
    return LocalDate.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
  }

  public String cyrillicToLatinic(String text) {
    String[] abcCyr = {"Š", "Đ", "Ć", "Č", "Ž"};
    String[] abcLat = {"S", "D", "C", "C", "Z"};
    return StringUtils.replaceEach(text, abcCyr, abcLat);
  }

  public Timestamp ldtToTimestamp(LocalDateTime localDateTime) {
    return Timestamp.valueOf(localDateTime);
  }

  public static <T> Page<T> createPageable(List<T> items, int pageSize, int pageNumber) {
    int start = pageSize * pageNumber;
    int end = Math.min((start + pageSize), items.size());
    return new PageImpl<>(
        items.subList(start, end), PageRequest.of(pageNumber, pageSize), items.size());
  }
}
