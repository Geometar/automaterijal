package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.ExternalRobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.external.PartnerB2bId;
import com.automaterijal.application.domain.entity.external.PartnerB2bProizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.ExternalRobaMapper;
import com.automaterijal.application.domain.repository.external.PartnerB2bIdRepository;
import com.automaterijal.application.domain.repository.external.PartnerB2bProizvodjacRepository;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.RobaService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PartnerExternalService {

  @NonNull
  final PartnerB2bIdRepository b2bIdRepository;

  @NonNull
  final PartnerB2bProizvodjacRepository b2bProizvodjacRepository;

  @NonNull
  final PartnerService partnerService;

  @NonNull
  final RobaService robaService;

  @NonNull
  final ExternalRobaMapper mapper;

  @NonNull
  final RobaCeneService robaCeneService;

  @NonNull
  final TdAutomaterijalService tdAutomaterijalService;

  public Optional<PartnerB2bId> pronadjiPartneraPoUuid(String uuid) {
    return b2bIdRepository.findByUuid(uuid);
  }

  public ExternalRobaDto pronadjiRobu(Integer ppid, String itemNo, Integer brandID) {
    ExternalRobaDto retVal;
    itemNo = itemNo.replaceAll("\\s+", "");
    // Pronadji sve proizvodjace koje partner moze da ima i samog partnera izvuci iz baze
    List<PartnerB2bProizvodjac> listaProizvodjaca = b2bProizvodjacRepository.findByProizvodjacKljuceviPpid(
        ppid);
    Partner partner = partnerService.pronadjiPartneraPoId(ppid);
    List<String> kljuceviProizvodjaca = listaProizvodjaca.stream()
        .map(b2bProizvodjac -> b2bProizvodjac.getProizvodjacKljucevi().getProid())
        .collect(Collectors.toList());

    // U slucaju da postoji brand id filtrirati kljuceve proizvodjaca samo da sadrzi taj ID
    if (brandID != null && tdAutomaterijalService.vratiNasProIdIzTecDoca(brandID).isPresent()) {
      String proId = tdAutomaterijalService.vratiNasProIdIzTecDoca(brandID).orElse("");
      kljuceviProizvodjaca = kljuceviProizvodjaca.stream().filter(kljuc -> kljuc.equals(proId))
          .collect(Collectors.toList());
    }

    Roba roba = robaService.pronadjiPoPretaziIProizvodjacima(itemNo, kljuceviProizvodjaca);

    if (roba != null) {
      log.info("B2B: Partneru {} vracena roba sa katBr {}", partner.getMestaIsporuke().getNaziv(),
          itemNo);
      BigDecimal cena = robaCeneService.vratiRobuB2BKomunikacija(roba.getRobaid(),
              roba.getGrupaid(), roba.getProizvodjac().getProid(), partner)
          .setScale(2, RoundingMode.CEILING);
      retVal = mapper.map(roba, cena.doubleValue());
    } else {
      log.info("B2B: Partneru {} nije nadjena roba sa katBr {}",
          partner.getMestaIsporuke().getNaziv(), itemNo);
      retVal = new ExternalRobaDto();
      retVal.setSucess(true);
    }

    return retVal;
  }
}
