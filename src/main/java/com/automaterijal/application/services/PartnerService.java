package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.PartnerAkcije;
import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.dto.PartnerLogovanjeDto;
import com.automaterijal.application.domain.dto.ResetovanjeSifreDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Users;
import com.automaterijal.application.domain.mapper.PartnerMapper;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.services.email.EmailService;
import com.automaterijal.application.services.security.UsersService;
import com.automaterijal.application.utils.LoginStaticUtils;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PartnerService {

  @NonNull final PartnerRepository partnerRepository;

  @NonNull final UsersService usersService;

  @NonNull final PartnerMapper mapper;

  @NonNull final EmailService emailService;

  public boolean promeniSifruPartnera(
      ResetovanjeSifreDto resetovanjeSifreDto, boolean isPrvaPromena) {
    boolean uspesnaPromenaSifre = false;
    Optional<Partner> partnerOptinal = partnerRepository.findByPpid(resetovanjeSifreDto.getPpid());
    if (partnerOptinal.isPresent()) {
      Partner partner = partnerOptinal.get();
      if (isPrvaPromena) {
        partner.setUsers(usersService.sacuvajUsera(partner));
      }
      partner.getUsers().setPassword(LoginStaticUtils.md5Password(resetovanjeSifreDto.getSifra()));
      if (partner.getUsers().getLoginCount() == 0) {
        partner.getUsers().setLoginCount(1);
      }
      uspesnaPromenaSifre = true;
    }
    return uspesnaPromenaSifre;
  }

  /** Servis za gde partner updejtuje informacije o sebi */
  public PartnerDto updejtPartnera(PartnerDto partnerDto, Partner partner, PartnerAkcije akcije) {
    PartnerDto retVal = null;
    log.info("Partner {} trazio promenu {}", partner.getNaziv(), akcije);
    partnerDto.setNaziv(partner.getNaziv());
    switch (akcije) {
      case PROMENA_SIFRE:
        retVal = promenaSifrePrekoAkcija(partnerDto, partner);
        if (retVal != null) {
          emailService.posaljiPromenaInformacijaMail(partnerDto, akcije);
        }
        break;
      case PROMENA_IMENA:
        if (partnerDto.getWebKorisnik() != null && !daLiPostojiVecZauzetaRegistracije(partnerDto)) {
          mapper.map(partner, partnerDto);
          retVal = mapper.map(partner);
          partnerRepository.saveAndFlush(partner);
          emailService.posaljiPromenaInformacijaMail(partnerDto, akcije);
        }
        break;
      case PROMENA_MEJLA, PROMENA_ADRESE:
        mapper.map(partner, partnerDto);
        retVal = mapper.map(partner);
        partnerRepository.saveAndFlush(partner);
        emailService.posaljiPromenaInformacijaMail(partnerDto, akcije);
        break;
      default:
        log.error("Partner {} nije nasao akciju {}", partnerDto.getNaziv(), akcije);
    }
    return retVal;
  }

  private PartnerDto promenaSifrePrekoAkcija(PartnerDto partnerDto, Partner partner) {
    PartnerDto retVal = null;
    if ((partnerDto.getStariPassword() != null || partnerDto.getNoviPassword() != null)
        && LoginStaticUtils.md5Password(partnerDto.getStariPassword())
            .equals(partner.getUsers().getPassword())) {
      partnerDto.setNoviPassword(LoginStaticUtils.md5Password(partnerDto.getNoviPassword()));
      mapper.map(partner, partnerDto);
      retVal = mapper.map(partner);
      partnerRepository.saveAndFlush(partner);
    }
    return retVal;
  }

  private boolean daLiPostojiVecZauzetaRegistracije(PartnerDto partnerDto) {
    return partnerRepository.findByWebKorisnik(partnerDto.getWebKorisnik()).isPresent();
  }

  @Transactional(readOnly = true)
  public Partner pronadjiPartneraPoId(Integer id) {
    Partner retVal = null;
    Optional<Partner> optionalPartner = partnerRepository.findById(id);
    if (optionalPartner.isPresent()) {
      retVal = optionalPartner.get();
    }
    return retVal;
  }

  public Partner findDefaultPartner() {
    return partnerRepository.findById(102044).orElse(null);
  }

  /** Servis za povecavanje broja logovanja korisnika */
  public void povecanPartnerovOrderCount(Partner partner) {
    Optional<Partner> partnerHibernate = partnerRepository.findById(partner.getPpid());
    partnerHibernate.ifPresent(
        partnerBaza -> {
          Users users = partnerBaza.getUsers();
          users.setOrderCount(users.getOrderCount() + 1);
        });
  }

  public Page<PartnerLogovanjeDto> vratiLogovanjePartnera(Integer page, Integer pageSize) {
    Page<Partner> partneri =
        partnerRepository.findAll(
            PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "users.lastLogin")));
    return partneri.map(mapper::mapLogovanje);
  }

  public List<Partner> vratiSveKomercijaliste() {
    return partnerRepository.findByPrivilegijeGreaterThanOrderByNazivAsc(2042);
  }

  public Partner vratiPartnera(Integer ppid) {
    return partnerRepository.findByPpid(ppid).orElse(null);
  }

  @Transactional(readOnly = true)
  public List<Partner> pretraziPartnerePoNazivu(String naziv) {
    return partnerRepository.findTop50ByNazivContainingIgnoreCaseOrderByNazivAsc(naziv);
  }
}
