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
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
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

  @NonNull final PartnerB2bIdRepository b2bIdRepository;

  @NonNull final PartnerB2bProizvodjacRepository b2bProizvodjacRepository;

  @NonNull final PartnerService partnerService;

  @NonNull final RobaDatabaseService robaDatabaseService;

  @NonNull final ExternalRobaMapper mapper;

  @NonNull final RobaCeneService robaCeneService;

  @NonNull final TdAutomaterijalService tdAutomaterijalService;

  public Optional<PartnerB2bId> pronadjiPartneraPoUuid(String uuid) {
    return b2bIdRepository.findByUuid(uuid);
  }

  public ExternalRobaDto pronadjiRobu(Integer ppid, String itemNo, Integer brandID) {
    ExternalRobaDto retVal;
    String cleanedItemNo = CatalogNumberUtils.cleanPreserveSeparators(itemNo); // normalize input
    Partner partner = partnerService.pronadjiPartneraPoId(ppid);

    // All manufacturer keys allowed for this partner (before optional brand filter)
    List<PartnerB2bProizvodjac> partnerManufacturers =
        b2bProizvodjacRepository.findByProizvodjacKljuceviPpid(ppid);
    List<String> allowedManufacturerIds =
        partnerManufacturers.stream()
            .map(b2bProizvodjac -> b2bProizvodjac.getProizvodjacKljucevi().getProid())
            .toList();
    allowedManufacturerIds = filterByBrandIfProvided(brandID, allowedManufacturerIds);

    Roba roba =
        robaDatabaseService.pronadjiPoPretaziIProizvodjacima(cleanedItemNo, allowedManufacturerIds);

    if (roba != null) {
      log.info(
          "B2B: Partner {} received item with catalog number {}",
          partner.getMestaIsporuke().getNaziv(),
          cleanedItemNo);

      BigDecimal cena =
          robaCeneService
              .vratiRobuB2BKomunikacija(
                  roba.getRobaid(), roba.getGrupaid(), roba.getProizvodjac().getProid(), partner)
              .setScale(2, RoundingMode.CEILING);

      retVal = mapper.map(roba, cena.doubleValue());
    } else {
      log.info(
          "B2B: Partner {} did not find item with catalog number {}",
          partner.getMestaIsporuke().getNaziv(),
          itemNo);
      retVal = new ExternalRobaDto();
      retVal.setSucess(true);
    }

    return retVal;
  }

  private List<String> filterByBrandIfProvided(
      Integer brandID, List<String> allowedManufacturerIds) {
    if (brandID == null || allowedManufacturerIds.isEmpty()) {
      return allowedManufacturerIds;
    }

    // If TecDoc brand ID is provided, narrow allowed manufacturers to that brand only
    return tdAutomaterijalService
        .vratiNasProIdIzTecDoca(brandID)
        .map(proId -> allowedManufacturerIds.stream().filter(pro -> pro.equals(proId)).toList())
        .orElse(allowedManufacturerIds);
  }
}
