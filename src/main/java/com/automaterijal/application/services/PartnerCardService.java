package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.partner.PartnerCardExternalItemDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardGroupDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardItemDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PartnerCardService {

  static final String PARTNER_CARD_URL_TEMPLATE =
      "https://1clicksoft.rs/erpsrv/test/erpsrv.php?compid=302353&ppid=101022&actionid=12&skey=d266f2f31cf903c870027659030e967e&usrid=%d";

  @NonNull RestTemplate restTemplate;
  @NonNull ObjectMapper objectMapper;

  public PartnerCardResponseDto vratiKarticuZaPartnera(Integer partnerPpid) {
    final String targetUrl = PARTNER_CARD_URL_TEMPLATE.formatted(partnerPpid);
    String responseBody;
    try {
      responseBody = restTemplate.getForObject(targetUrl, String.class);
    } catch (RestClientException exception) {
      log.error(
          "Neuspesan poziv kartice partnera za partnera {} prema url-u {}", partnerPpid, targetUrl,
          exception);
      throw new ResponseStatusException(
          HttpStatus.BAD_GATEWAY, "Greska pri preuzimanju kartice partnera");
    }

    if (responseBody == null || responseBody.isBlank()) {
      return praznaKartica();
    }

    final String trimmed = responseBody.trim();
    if (!trimmed.startsWith("[")) {
      log.error(
          "Neocuvan format kartice partnera (nije JSON array). Partner {}, url {}, odgovor: {}",
          partnerPpid,
          targetUrl,
          skrati(trimmed));
      throw new ResponseStatusException(
          HttpStatus.BAD_GATEWAY, "Nepoznat format kartice partnera");
    }

    PartnerCardExternalItemDto[] response;
    try {
      response = objectMapper.readValue(trimmed, PartnerCardExternalItemDto[].class);
    } catch (JsonProcessingException exception) {
      log.error(
          "Nepravilan odgovor kartice partnera. Partner {}, url {}, odgovor: {}",
          partnerPpid,
          targetUrl,
          skrati(trimmed),
          exception);
      throw new ResponseStatusException(
          HttpStatus.BAD_GATEWAY, "Greska pri obradi kartice partnera");
    }

    final List<PartnerCardExternalItemDto> items =
        Arrays.stream(response).filter(Objects::nonNull).toList();

    if (items.isEmpty()) {
      return praznaKartica();
    }

    final List<PartnerCardExternalItemDto> poslovniZapisi =
        items.stream().filter(item -> !item.isTotal()).toList();

    final Map<String, List<PartnerCardExternalItemDto>> grupisanoPoTipu =
        poslovniZapisi.stream()
            .collect(
                Collectors.groupingBy(
                    item -> Optional.ofNullable(item.getTip()).map(String::trim).filter(s -> !s.isEmpty()).orElse("Nepoznat tip"),
                    LinkedHashMap::new,
                    Collectors.toList()));

    final List<PartnerCardGroupDto> groups =
        grupisanoPoTipu.entrySet().stream()
            .map(entry -> mapToGroup(entry.getKey(), entry.getValue()))
            .toList();

    final PartnerCardExternalItemDto totalItem =
        items.stream().filter(PartnerCardExternalItemDto::isTotal).findFirst().orElse(null);

    final PartnerCardResponseDto retVal = new PartnerCardResponseDto();
    retVal.setGroups(groups);
    retVal.setUkupnoDuguje(
        totalItem != null && totalItem.getDuguje() != null
            ? normalize(totalItem.getDuguje())
            : normalize(sum(poslovniZapisi, PartnerCardExternalItemDto::getDuguje)));
    retVal.setUkupnoPotrazuje(
        totalItem != null && totalItem.getPotrazuje() != null
            ? normalize(totalItem.getPotrazuje())
            : normalize(sum(poslovniZapisi, PartnerCardExternalItemDto::getPotrazuje)));
    retVal.setUkupnoStanje(
        totalItem != null && totalItem.getStanje() != null
            ? normalize(totalItem.getStanje())
            : normalize(sum(poslovniZapisi, PartnerCardExternalItemDto::getStanje)));

    return retVal;
  }

  private PartnerCardGroupDto mapToGroup(
      String tip, List<PartnerCardExternalItemDto> items) {
    final PartnerCardGroupDto group = new PartnerCardGroupDto();
    group.setTip(tip);
    group.setTotalDuguje(normalize(sum(items, PartnerCardExternalItemDto::getDuguje)));
    group.setTotalPotrazuje(normalize(sum(items, PartnerCardExternalItemDto::getPotrazuje)));
    group.setTotalStanje(normalize(sum(items, PartnerCardExternalItemDto::getStanje)));
    group.setStavke(
        items.stream()
            .sorted(
                (left, right) ->
                    compareDatesDesc(left.getDatum(), right.getDatum()))
            .map(this::mapToItemDto)
            .toList());
    return group;
  }

  private PartnerCardItemDto mapToItemDto(PartnerCardExternalItemDto item) {
    final PartnerCardItemDto dto = new PartnerCardItemDto();
    dto.setTip(item.getTip());
    dto.setNazivDok(item.getNazivDok());
    dto.setBrojDokumenta(item.getBrDok());
    dto.setDatum(item.getDatum());
    dto.setDatumRoka(item.getDatRoka());
    dto.setDuguje(normalize(item.getDuguje()));
    dto.setPotrazuje(normalize(item.getPotrazuje()));
    dto.setStanje(normalize(item.getStanje()));
    return dto;
  }

  private BigDecimal sum(
      List<PartnerCardExternalItemDto> items,
      Function<PartnerCardExternalItemDto, BigDecimal> extractor) {
    return items.stream()
        .map(extractor)
        .filter(Objects::nonNull)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private BigDecimal normalize(BigDecimal value) {
    return value != null ? value.setScale(2, RoundingMode.HALF_UP) : null;
  }

  private int compareDatesDesc(String first, String second) {
    LocalDate firstDate = parseDate(first);
    LocalDate secondDate = parseDate(second);

    if (firstDate == null && secondDate == null) {
      return 0;
    } else if (firstDate == null) {
      return 1;
    } else if (secondDate == null) {
      return -1;
    }
    return secondDate.compareTo(firstDate);
  }

  private LocalDate parseDate(String value) {
    if (value == null) {
      return null;
    }
    try {
      return LocalDate.parse(value);
    } catch (DateTimeParseException ignored) {
      return null;
    }
  }

  private String skrati(String value) {
    if (value == null) {
      return null;
    }
    return value.length() > 300 ? value.substring(0, 300) + "..." : value;
  }

  private PartnerCardResponseDto praznaKartica() {
    final PartnerCardResponseDto retVal = new PartnerCardResponseDto();
    retVal.setGroups(Collections.emptyList());
    final BigDecimal zero = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    retVal.setUkupnoDuguje(zero);
    retVal.setUkupnoPotrazuje(zero);
    retVal.setUkupnoStanje(zero);
    return retVal;
  }
}
