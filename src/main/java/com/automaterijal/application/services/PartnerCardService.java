package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardDocumentDetailsDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardDocumentDetailsExternalDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardDocumentExternalItemDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardDocumentItemDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardExternalItemDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardGroupDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardItemDto;
import com.automaterijal.application.domain.dto.partner.PartnerCardResponseDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.roba.RobaCene;
import com.automaterijal.application.domain.repository.roba.RobaRepository;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.services.roba.util.RobaHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
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
  static final String PARTNER_CARD_DETAILS_URL_TEMPLATE =
      "https://1clicksoft.rs/erpsrv/test/erpsrv.php?compid=302353&ppid=101022&actionid=12s&skey=d266f2f31cf903c870027659030e967e&usrid=%d&vrdok=%s&brdok=%s";
  private static final Set<String> DOZVOLJENI_VR_DOK = Set.of("4", "04", "13", "15", "32");
  private static final List<String> PRIORITET_VR_DOK = List.of("04", "4", "32");

  @NonNull RestTemplate restTemplate;
  @NonNull ObjectMapper objectMapper;
  @NonNull PartnerService partnerService;
  @NonNull ProizvodjacService proizvodjacService;
  @NonNull ArticleGroupService articleGroupService;
  @NonNull ArticleSubGroupService articleSubGroupService;
  @NonNull RobaRepository robaRepository;
  @NonNull RobaCeneService robaCeneService;
  @NonNull RobaHelper robaHelper;

  public PartnerCardResponseDto vratiKarticuZaPartnera(Integer partnerPpid) {
    final String targetUrl = PARTNER_CARD_URL_TEMPLATE.formatted(partnerPpid);
    String responseBody;
    try {
      responseBody = restTemplate.getForObject(targetUrl, String.class);
    } catch (RestClientException exception) {
      log.error(
          "Neuspesan poziv kartice partnera za partnera {} prema url-u {}",
          partnerPpid,
          targetUrl,
          exception);
      throw new ResponseStatusException(
          HttpStatus.BAD_GATEWAY, "Greska pri preuzimanju kartice partnera");
    }

    if (responseBody == null || responseBody.isBlank()) {
      return praznaKartica();
    }

    final String trimmed = sanitize(responseBody);
    if (!trimmed.startsWith("[")) {
      log.warn(
          "Neocuvan format kartice partnera (nije JSON array). Partner {}, url {}, odgovor: {}",
          partnerPpid,
          targetUrl,
          skrati(trimmed));
      return praznaKartica();
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

    final List<PartnerCardExternalItemDto> prikazaniZapisi =
        poslovniZapisi.stream()
            .filter(item -> isDozvoljenVrDok(item.getVrDok()))
            .filter(item -> !item.getTip().equals("Novcana stavka"))
            .collect(Collectors.toCollection(ArrayList::new));

    if (prikazaniZapisi.isEmpty()) {
      return praznaKartica();
    }

    final Map<String, List<PartnerCardExternalItemDto>> grupisanoPoTipu =
        prikazaniZapisi.stream()
            .collect(
                Collectors.groupingBy(
                    item ->
                        Optional.ofNullable(item.getTip())
                            .map(String::trim)
                            .filter(s -> !s.isEmpty())
                            .orElse("Nepoznat tip"),
                    LinkedHashMap::new,
                    Collectors.toList()));

    final List<PartnerCardGroupDto> groups =
        grupisanoPoTipu.entrySet().stream()
            .map(entry -> mapToGroup(entry.getKey(), entry.getValue()))
            .toList();

    final PartnerCardResponseDto retVal = new PartnerCardResponseDto();
    retVal.setGroups(groups);
    retVal.setUkupnoDuguje(normalize(sum(prikazaniZapisi, PartnerCardExternalItemDto::getDuguje)));
    retVal.setUkupnoPotrazuje(
        normalize(sum(prikazaniZapisi, PartnerCardExternalItemDto::getPotrazuje)));
    retVal.setUkupnoStanje(normalize(sum(prikazaniZapisi, PartnerCardExternalItemDto::getStanje)));

    return retVal;
  }

  public PartnerCardDocumentDetailsDto vratiDetaljeDokumenta(
      Integer partnerPpid, String vrDok, String brDok, boolean adminPregled) {
    if (!isDozvoljenVrDok(vrDok)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nepodrzan tip dokumenta");
    }
    final String vrDokNormalized = normalizeVrDokValue(vrDok);

    final String targetUrl = PARTNER_CARD_DETAILS_URL_TEMPLATE.formatted(partnerPpid, vrDok, brDok);
    String responseBody;
    try {
      responseBody = restTemplate.getForObject(targetUrl, String.class);
    } catch (RestClientException exception) {
      log.error(
          "Neuspesan poziv detalja dokumenta (vrdok {}, brdok {}) za partnera {} prema url-u {}",
          vrDok,
          brDok,
          partnerPpid,
          targetUrl,
          exception);
      throw new ResponseStatusException(
          HttpStatus.BAD_GATEWAY, "Greska pri preuzimanju detalja dokumenta");
    }

    if (responseBody == null || responseBody.isBlank()) {
      return prazniDetalji();
    }

    final String trimmed = sanitize(responseBody);
    if (!trimmed.startsWith("{")) {
      log.warn(
          "Neocuvan format detalja dokumenta (nije JSON object). Partner {}, url {}, odgovor: {}",
          partnerPpid,
          targetUrl,
          skrati(trimmed));
      return prazniDetalji();
    }

    PartnerCardDocumentDetailsExternalDto external;
    try {
      external = objectMapper.readValue(trimmed, PartnerCardDocumentDetailsExternalDto.class);
    } catch (JsonProcessingException exception) {
      log.error(
          "Nepravilan odgovor detalja dokumenta. Partner {}, url {}, odgovor: {}",
          partnerPpid,
          targetUrl,
          skrati(trimmed),
          exception);
      throw new ResponseStatusException(
          HttpStatus.BAD_GATEWAY, "Greska pri obradi detalja dokumenta");
    }

    final List<PartnerCardDocumentExternalItemDto> stavke =
        Optional.ofNullable(external.getStavke()).orElse(List.of()).stream()
            .filter(Objects::nonNull)
            .toList();

    if (stavke.isEmpty()) {
      return prazniDetalji(external);
    }

    final Partner partner = partnerService.vratiPartnera(partnerPpid);
    final Map<Long, Roba> robaPoId = ucitajRobu(stavke);
    final Map<Long, RobaCene> cenePoId = ucitajCene(stavke);
    final Map<String, String> proizvodjacNazivi = ucitajProizvodjace(robaPoId.values());
    final Map<String, String> grupaNazivi = ucitajGrupe(robaPoId.values());
    final Map<Integer, String> podgrupaNazivi = ucitajPodgrupe(robaPoId.values());

    final List<PartnerCardDocumentItemDto> mapped =
        stavke.stream()
            .map(
                item ->
                    mapToDocumentItemDto(
                        vrDokNormalized,
                        item,
                        robaPoId.get(item.getRobaId()),
                        cenePoId.get(item.getRobaId()),
                        adminPregled,
                        proizvodjacNazivi,
                        grupaNazivi,
                        podgrupaNazivi))
            .toList();

    final PartnerCardDocumentDetailsDto retVal = new PartnerCardDocumentDetailsDto();
    retVal.setErrorCode(external.getErrorCode());
    retVal.setErrorMessage(external.getErrorMessage());
    retVal.setStavke(mapped);
    return retVal;
  }

  private PartnerCardGroupDto mapToGroup(String tip, List<PartnerCardExternalItemDto> items) {
    final PartnerCardGroupDto group = new PartnerCardGroupDto();
    group.setTip(tip);
    group.setTotalDuguje(normalize(sum(items, PartnerCardExternalItemDto::getDuguje)));
    group.setTotalPotrazuje(normalize(sum(items, PartnerCardExternalItemDto::getPotrazuje)));
    group.setTotalStanje(normalize(sum(items, PartnerCardExternalItemDto::getStanje)));
    group.setStavke(
        items.stream()
            .sorted((left, right) -> compareDatesDesc(left.getDatum(), right.getDatum()))
            .map(this::mapToItemDto)
            .toList());
    return group;
  }

  private boolean isDozvoljenVrDok(String vrDok) {
    if (vrDok == null) {
      return false;
    }
    final String normalized = vrDok.trim();
    return DOZVOLJENI_VR_DOK.contains(normalized);
  }

  private PartnerCardItemDto mapToItemDto(PartnerCardExternalItemDto item) {
    final PartnerCardItemDto dto = new PartnerCardItemDto();
    dto.setTip(item.getTip());
    dto.setNazivDok(item.getNazivDok());
    dto.setVrDok(item.getVrDok());
    dto.setBrojDokumenta(item.getBrDok());
    dto.setDatum(item.getDatum());
    dto.setDatumRoka(item.getDatRoka());
    dto.setDuguje(normalize(item.getDuguje()));
    dto.setPotrazuje(normalize(item.getPotrazuje()));
    dto.setStanje(normalize(item.getStanje()));
    return dto;
  }

  private PartnerCardDocumentItemDto mapToDocumentItemDto(
      String vrDok,
      PartnerCardDocumentExternalItemDto item,
      Roba roba,
      RobaCene cene,
      boolean adminPregled,
      Map<String, String> proizvodjacNazivi,
      Map<String, String> grupaNazivi,
      Map<Integer, String> podgrupaNazivi) {
    final PartnerCardDocumentItemDto dto = new PartnerCardDocumentItemDto();
    dto.setId(item.getId());
    dto.setStavkaId(item.getStavkaId());
    dto.setRobaId(item.getRobaId());
    dto.setKolicina(normalize(item.getKolicina()));
    dto.setNabavnaCena(adminPregled ? normalize(item.getNabavnaCena()) : null);
    dto.setProdajnaCena(normalize(item.getProdajnaCena()));
    dto.setProdajnaCenaBezPdv(normalize(item.getProdajnaCenaBezPdv()));
    dto.setProdajnaCenaSaPdv(normalize(item.getProdajnaCenaSaPdv()));
    dto.setRabat(normalize(item.getRabat()));
    dto.setPorez(normalize(item.getPorez()));
    dto.setNaziv(item.getNaziv());
    dto.setRobaNaziv(item.getRobaNaziv());
    dto.setKatbr(item.getKatbr());
    dto.setKatbrPro(item.getKatbrPro());
    dto.setBarkod(item.getBarkod());
    if (roba != null) {
      dto.setProizvodjacNaziv(proizvodjacNazivi.get(roba.getProid()));
      dto.setGrupa(roba.getGrupaid());
      dto.setGrupaNaziv(grupaNazivi.get(roba.getGrupaid()));
      Integer podgrupaId = roba.getPodgrupaid();
      dto.setPodgrupa(podgrupaId);
      dto.setPodgrupaNaziv(podgrupaNazivi.get(podgrupaId));
    }
    dto.setSlika(resolveSlika(roba));

    final String vrDokNormalized = normalizeVrDokValue(vrDok);
    final boolean erpPunaCena = isVrDokFullPrice(vrDokNormalized);

    final BigDecimal erpSaPdv = normalize(punaCenaSaPdv(item));
    final BigDecimal erpBezPdv =
        normalize(
            izracunajBezPdv(
                erpSaPdv,
                item != null ? item.getPorez() : null,
                item != null ? item.getProdajnaCenaBezPdv() : null));

    dto.setProdajnaCenaSaPdv(erpSaPdv);
    dto.setProdajnaCenaBezPdv(erpBezPdv);

    BigDecimal punaSaPdv;
    BigDecimal punaBezPdv;
    BigDecimal partnerSaPdv;
    BigDecimal partnerBezPdv;

    if (erpPunaCena) {
      // ERP vraca punu cenu -> primeni rabat da dobijes cenu partnera
      final BigDecimal rabatFaktor = partnerRabatFaktor(item);
      punaSaPdv = erpSaPdv;
      punaBezPdv = erpBezPdv;
      partnerSaPdv = multiplyRaw(punaSaPdv, rabatFaktor);
      partnerBezPdv = multiplyRaw(punaBezPdv, rabatFaktor);
    } else {
      // ERP vraca cenu partnera -> puna cena iz anon cenovnika
      partnerSaPdv = erpSaPdv;
      partnerBezPdv = erpBezPdv;
      final BigDecimal punaSaPdvIzCenovnika =
          Optional.ofNullable(izracunajPunaCenuAnon(roba, cene, item)).orElse(erpSaPdv);
      punaSaPdv = normalize(punaSaPdvIzCenovnika);
      BigDecimal pdvZaPunu =
          Optional.ofNullable(cene != null ? cene.getPdvstopa() : null)
              .orElse(item != null ? item.getPorez() : null);
      punaBezPdv = normalize(izracunajBezPdv(punaSaPdv, pdvZaPunu, null));
    }

    dto.setCenaPartneraSaPdv(normalize(partnerSaPdv));
    dto.setCenaPartneraBezPdv(normalize(partnerBezPdv));
    dto.setCenaPartnera(dto.getCenaPartneraSaPdv());
    dto.setCenaPartneraUkupno(multiply(dto.getCenaPartneraSaPdv(), dto.getKolicina()));

    dto.setPunaCenaSaPdv(punaSaPdv);
    dto.setPunaCenaBezPdv(punaBezPdv);
    final BigDecimal puniSaPdvZaUkupno =
        Optional.ofNullable(punaSaPdv).orElse(dto.getCenaPartneraSaPdv());
    dto.setPunaCena(puniSaPdvZaUkupno);
    dto.setPunaCenaUkupno(multiply(puniSaPdvZaUkupno, dto.getKolicina()));
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

  private BigDecimal multiply(BigDecimal first, BigDecimal second) {
    if (first == null || second == null) {
      return null;
    }
    return first.multiply(second).setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal punaCenaSaPdv(PartnerCardDocumentExternalItemDto item) {
    if (item == null) {
      return null;
    }
    if (item.getProdajnaCenaSaPdv() != null) {
      return item.getProdajnaCenaSaPdv();
    }
    if (item.getProdajnaCena() != null) {
      return item.getProdajnaCena();
    }
    if (item.getProdajnaCenaBezPdv() != null) {
      BigDecimal multiplier = vatMultiplier(item.getPorez());
      return item.getProdajnaCenaBezPdv().multiply(multiplier);
    }
    return null;
  }

  private BigDecimal izracunajPunaCenuAnon(
      Roba roba, RobaCene cene, PartnerCardDocumentExternalItemDto item) {
    if (roba == null || cene == null) {
      return izracunajPunaCenuFallback(cene, item);
    }

    // koristi isti algoritam kao za listu robe, ali sa anon partnerom
    BigDecimal cena =
        robaCeneService.vratiCenuRobeBatch(cene, roba.getGrupaid(), roba.getProid(), null);
    if (cena != null) {
      return normalize(cena);
    }
    return izracunajPunaCenuFallback(cene, item);
  }

  private BigDecimal izracunajPunaCenuFallback(
      RobaCene cene, PartnerCardDocumentExternalItemDto item) {
    if (cene != null && cene.getProdajnacena() != null) {
      BigDecimal multiplier =
          vatMultiplier(
              Optional.ofNullable(cene.getPdvstopa())
                  .orElse(item != null ? item.getPorez() : null));
      return normalize(cene.getProdajnacena().multiply(multiplier));
    }
    if (cene != null && cene.getDeviznacena() != null) {
      // devizna cena (EUR) * 120 je postojeca logika za RSD sa PDV
      return normalize(cene.getDeviznacena().multiply(BigDecimal.valueOf(120)));
    }
    return null;
  }

  private BigDecimal vatMultiplier(BigDecimal porez) {
    BigDecimal pdv = Optional.ofNullable(porez).orElse(BigDecimal.valueOf(20));
    return BigDecimal.ONE.add(pdv.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP));
  }

  private BigDecimal izracunajBezPdv(
      BigDecimal cenaSaPdv, BigDecimal porez, BigDecimal fallbackBezPdv) {
    if (fallbackBezPdv != null) {
      return fallbackBezPdv;
    }
    if (cenaSaPdv == null) {
      return null;
    }
    BigDecimal multiplier = vatMultiplier(porez);
    if (multiplier.compareTo(BigDecimal.ZERO) == 0) {
      return null;
    }
    return cenaSaPdv.divide(multiplier, 2, RoundingMode.HALF_UP);
  }

  private BigDecimal multiplyRaw(BigDecimal first, BigDecimal second) {
    if (first == null || second == null) {
      return null;
    }
    return first.multiply(second);
  }

  private BigDecimal partnerRabatFaktor(PartnerCardDocumentExternalItemDto item) {
    return Optional.ofNullable(item)
        .map(PartnerCardDocumentExternalItemDto::getRabat)
        .map(r -> r.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP))
        .map(oneMinus -> BigDecimal.ONE.subtract(oneMinus))
        .orElse(BigDecimal.ONE);
  }

  private String normalizeVrDokValue(String vrDok) {
    if (vrDok == null) {
      return "";
    }
    String trimmed = vrDok.trim();
    return trimmed.replaceFirst("^0+(?!$)", "");
  }

  private boolean isVrDokFullPrice(String vrDokNormalized) {
    return Set.of("4", "13").contains(vrDokNormalized);
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

  private String sanitize(String value) {
    if (value == null) {
      return "";
    }
    // remove potential BOM and trim spaces
    return value.replace("\uFEFF", "").trim();
  }

  private SlikaDto resolveSlika(Roba roba) {
    if (roba == null) {
      return robaHelper.resolveImage(null, null);
    }
    return robaHelper.resolveImage(roba.getRobaid(), new SlikaDto(roba.getSlika()));
  }

  private Map<String, String> ucitajProizvodjace(Collection<Roba> roba) {
    if (roba == null || roba.isEmpty()) {
      return Collections.emptyMap();
    }
    final Set<String> ids =
        roba.stream()
            .map(Roba::getProid)
            .filter(Objects::nonNull)
            .map(String::trim)
            .filter(id -> !id.isEmpty())
            .collect(Collectors.toSet());
    if (ids.isEmpty()) {
      return Collections.emptyMap();
    }
    return proizvodjacService.vratiProizvodjacePoId(ids).values().stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toMap(Proizvodjac::getProid, Proizvodjac::getNaziv));
  }

  private Map<String, String> ucitajGrupe(Collection<Roba> roba) {
    if (roba == null || roba.isEmpty()) {
      return Collections.emptyMap();
    }
    final List<String> ids =
        roba.stream()
            .map(Roba::getGrupaid)
            .filter(Objects::nonNull)
            .map(String::trim)
            .filter(id -> !id.isEmpty())
            .distinct()
            .toList();
    if (ids.isEmpty()) {
      return Collections.emptyMap();
    }
    return articleGroupService.findAll().stream()
        .filter(Objects::nonNull)
        .filter(grupa -> ids.contains(grupa.getGrupaid()))
        .collect(Collectors.toMap(grupa -> grupa.getGrupaid(), grupa -> grupa.getNaziv()));
  }

  private Map<Integer, String> ucitajPodgrupe(Collection<Roba> roba) {
    if (roba == null || roba.isEmpty()) {
      return Collections.emptyMap();
    }
    final List<Integer> ids =
        roba.stream().map(Roba::getPodgrupaid).filter(id -> id != 0).distinct().toList();
    if (ids.isEmpty()) {
      return Collections.emptyMap();
    }
    return articleSubGroupService.vratiPodgrupuPoKljucu(ids).stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toMap(PodGrupa::getPodGrupaId, PodGrupa::getNaziv));
  }

  private Map<Long, Roba> ucitajRobu(List<PartnerCardDocumentExternalItemDto> stavke) {
    final List<Long> ids =
        stavke.stream()
            .map(PartnerCardDocumentExternalItemDto::getRobaId)
            .filter(Objects::nonNull)
            .distinct()
            .toList();
    if (ids.isEmpty()) {
      return Collections.emptyMap();
    }
    return robaRepository.findByRobaidIn(ids).stream()
        .collect(Collectors.toMap(Roba::getRobaid, Function.identity()));
  }

  private Map<Long, RobaCene> ucitajCene(List<PartnerCardDocumentExternalItemDto> stavke) {
    final List<Long> ids =
        stavke.stream()
            .map(PartnerCardDocumentExternalItemDto::getRobaId)
            .filter(Objects::nonNull)
            .distinct()
            .toList();
    if (ids.isEmpty()) {
      return Collections.emptyMap();
    }
    return robaCeneService.pronadjiCeneZaRobuBatch(ids).stream()
        .collect(Collectors.toMap(RobaCene::getRobaid, Function.identity(), (left, right) -> left));
  }

  private PartnerCardDocumentDetailsDto prazniDetalji() {
    final PartnerCardDocumentDetailsDto retVal = new PartnerCardDocumentDetailsDto();
    retVal.setErrorCode(null);
    retVal.setErrorMessage(null);
    retVal.setStavke(Collections.emptyList());
    return retVal;
  }

  private PartnerCardDocumentDetailsDto prazniDetalji(
      PartnerCardDocumentDetailsExternalDto external) {
    final PartnerCardDocumentDetailsDto retVal = new PartnerCardDocumentDetailsDto();
    retVal.setErrorCode(external.getErrorCode());
    retVal.setErrorMessage(external.getErrorMessage());
    retVal.setStavke(Collections.emptyList());
    return retVal;
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
