package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Popusti;
import com.automaterijal.application.domain.entity.roba.RobaCene;
import com.automaterijal.application.domain.repository.roba.RobaCeneRepository;
import com.automaterijal.application.services.PartnerService;
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

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaCeneService {

  @NonNull final RobaCeneRepository robaCeneRepository;
  @NonNull final PartnerService partnerService;

  static final Long GLAVNIMAGACIN = 1L;

  public BigDecimal vratiRobuB2BKomunikacija(
      Long robaId, String grupaId, String proID, Partner partner) {
    BigDecimal retVal = null;
    Double popust = 1.0;
    if (partner != null) {
      popust = preracunajPopustNaArtkalZaUlogovanogPartnera(grupaId, proID, partner);
    }
    Optional<RobaCene> robaCene =
        robaCeneRepository.findByMagacinidAndRobaid(GLAVNIMAGACIN, robaId);
    if (robaCene.isPresent()) {
      RobaCene cene = robaCene.get();
      if (partner.getVpcid() != 5) {
        String vpcid = vratiVpcid(grupaId, proID, partner);
        if (vpcid.equals("1")) {
          retVal = cene.getProdajnacena().multiply(BigDecimal.valueOf(popust));
        } else {
          retVal =
              cene.getDeviznacena()
                  .multiply(BigDecimal.valueOf(popust))
                  .multiply(BigDecimal.valueOf(100));
        }
      } else if (partner.getVpcid() == 5) {
        // Partner ima pravo da vidi nabavne cene BEZ PDV i stanje robe na WEB-u
        retVal = cene.getNabavnacena().multiply(BigDecimal.valueOf(popust));
      }
    }
    return retVal;
  }

  public BigDecimal vratiCenuRobeBatch(
      RobaCene robaCene, String grupaId, String proID, Partner partner) {
    partner = getDefaultPartnerIfNotExist(partner);
    BigDecimal retVal = null;
    Double popust = 1.0;
    if (partner != null) {
      popust = preracunajPopustNaArtkalZaUlogovanogPartnera(grupaId, proID, partner);
    }
    if (robaCene != null) {
      if (partner == null) {
        retVal =
            robaCene
                .getDeviznacena()
                .multiply(BigDecimal.valueOf(popust))
                .multiply(BigDecimal.valueOf(120))
                .setScale(0, RoundingMode.CEILING);
      } else if (partner.getVpcid() != 5) {
        String vpcid = vratiVpcid(grupaId, proID, partner);
        if (vpcid.equals("1")) {
          retVal =
              robaCene
                  .getProdajnacena()
                  .multiply(BigDecimal.valueOf(popust))
                  .multiply(BigDecimal.valueOf(1.2));
        } else {
          retVal =
              robaCene
                  .getDeviznacena()
                  .multiply(BigDecimal.valueOf(popust))
                  .multiply(BigDecimal.valueOf(120));
        }
      } else if (partner.getVpcid() == 5) {
        //                Partner ima pravo da vidi nabavne cene BEZ PDV i stanje robe na WEB-u
        retVal = robaCene.getNabavnacena().multiply(BigDecimal.valueOf(popust));
      }
    }
    return retVal;
  }

  public BigDecimal vratiCenuRobePoRobiId(
      Long robaId, String grupaId, String proID, Partner partner) {
    partner = getDefaultPartnerIfNotExist(partner);
    BigDecimal retVal = null;
    Double popust = 1.0;
    if (partner != null) {
      popust = preracunajPopustNaArtkalZaUlogovanogPartnera(grupaId, proID, partner);
    }
    Optional<RobaCene> robaCene =
        robaCeneRepository.findByMagacinidAndRobaid(GLAVNIMAGACIN, robaId);
    if (robaCene.isPresent()) {
      RobaCene cene = robaCene.get();
      if (partner == null) {
        retVal =
            cene.getDeviznacena()
                .multiply(BigDecimal.valueOf(popust))
                .multiply(BigDecimal.valueOf(120))
                .setScale(0, RoundingMode.CEILING);
      } else if (partner.getVpcid() != 5) {
        String vpcid = vratiVpcid(grupaId, proID, partner);
        if (vpcid.equals("1")) {
          retVal =
              cene.getProdajnacena()
                  .multiply(BigDecimal.valueOf(popust))
                  .multiply(BigDecimal.valueOf(1.2));
        } else {
          retVal =
              cene.getDeviznacena()
                  .multiply(BigDecimal.valueOf(popust))
                  .multiply(BigDecimal.valueOf(120));
        }
      } else if (partner.getVpcid() == 5) {
        //                Partner ima pravo da vidi nabavne cene BEZ PDV i stanje robe na WEB-u
        retVal = cene.getNabavnacena().multiply(BigDecimal.valueOf(popust));
      }
    }
    return retVal;
  }

  public Double vratiRabatPartneraNaArtikal(String proId, String grupaId, Partner partner) {
    partner = getDefaultPartnerIfNotExist(partner);
    Double popust = 0.0;
    if (partner != null) {
      popust = preracunajPopustNaArtkalZaUlogovanogPartnera(grupaId, proId, partner);
      if (popust > 0) {
        popust = popust * 100 - 100;
      }
    }
    return Math.abs(popust);
  }

  private Double preracunajPopustNaArtkalZaUlogovanogPartnera(
      String grupaId, String proId, Partner partner) {
    Optional<Double> retVal = Optional.empty();
    if (partner.getPopustiList() != null) {
      retVal =
          partner.getPopustiList().stream()
              .filter(
                  popusti ->
                      (grupaId != null && grupaId.equals(popusti.getGrupaid()))
                          || (proId != null && proId.equals(popusti.getProid())))
              .map(Popusti::getProcenat)
              .findFirst();
    }

    return retVal.isPresent() ? 1 + retVal.get() / 100 : 1 + partner.getProcpc() / 100;
  }

  private String vratiVpcid(String grupaId, String proId, Partner partner) {
    Optional<String> retVal = Optional.empty();
    if (partner.getPopustiList() != null) {
      retVal =
          partner.getPopustiList().stream()
              .filter(
                  popusti ->
                      (grupaId != null && grupaId.equals(popusti.getGrupaid()))
                          || (proId != null && proId.equals(popusti.getProid())))
              .map(Popusti::getVpcid)
              .findFirst();
    }
    return retVal.isPresent() ? retVal.get() : "7";
  }

  public List<RobaCene> pronadjiCeneZaRobuBatch(List<Long> robaIds) {
    return robaCeneRepository.findByMagacinidAndRobaidIn(GLAVNIMAGACIN, robaIds);
  }

  private Partner getDefaultPartnerIfNotExist(Partner partner) {
    if (partner != null) {
      return partner;
    }
    return partnerService.findDefaultPartner();
  }
}
