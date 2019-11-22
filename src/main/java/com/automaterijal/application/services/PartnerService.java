package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.PartnerAkcije;
import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.dto.ResetovanjeSifreDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Users;
import com.automaterijal.application.domain.mapper.PartnerMapper;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.services.email.EmailService;
import com.automaterijal.application.services.security.UsersService;
import com.automaterijal.application.utils.LoginStaticUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PartnerService {

    @NonNull
    final PartnerRepository partnerRepository;

    @NonNull
    final UsersService usersService;

    @NonNull
    final PartnerMapper mapper;

    @NonNull
    final EmailService emailService;

    public boolean promeniSifruPartnera(final ResetovanjeSifreDto resetovanjeSifreDto, final boolean isPrvaPromena) {
        boolean uspesnaPromenaSifre = false;
        final Optional<Partner> partnerOptinal = partnerRepository.findByPpid(resetovanjeSifreDto.getPpid());
        if (partnerOptinal.isPresent()) {
            final Partner partner = partnerOptinal.get();
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

    /**
     * Servis za gde partner updejtuje informacije o sebi
     */
    public PartnerDto updejtPartnera(final PartnerDto partnerDto, final Partner partner, final PartnerAkcije akcije) {
        PartnerDto retVal = null;
        log.info("Partner {} trazio promenu {}", partner.getNaziv(), akcije);
        partnerDto.setNaziv(partner.getNaziv());
        switch (akcije) {
            case PROMENA_SIFRE:
                retVal = promenaSifrePrekoAkcija(partnerDto, partner);
                emailService.posaljiPromenaInformacijaMail(partnerDto, akcije);
                break;
            case PROMENA_IMENA:
                if ( partnerDto.getWebKorisnik() != null && !daLiPostojiVecZauzetaRegistracije(partnerDto)) {
                    mapper.map(partner, partnerDto);
                    retVal = mapper.map(partner);
                    partnerRepository.saveAndFlush(partner);
                    emailService.posaljiPromenaInformacijaMail(partnerDto, akcije);
                }
                break;
            case PROMENA_MEJLA:
            case PROMENA_ADRESE:
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

    private PartnerDto promenaSifrePrekoAkcija(final PartnerDto partnerDto, final Partner partner) {
        PartnerDto retVal = null;
        if (partnerDto.getStariPassword() != null || partnerDto.getNoviPassword() != null) {
            if (LoginStaticUtils.md5Password(partnerDto.getStariPassword()).equals(partner.getUsers().getPassword())) {
                partnerDto.setNoviPassword(LoginStaticUtils.md5Password(partnerDto.getNoviPassword()));
                mapper.map(partner, partnerDto);
                retVal = mapper.map(partner);
                partnerRepository.saveAndFlush(partner);
            }
        }
        return retVal;
    }

    private boolean daLiPostojiVecZauzetaRegistracije(final PartnerDto partnerDto) {
        return partnerRepository.findByWebKorisnik(partnerDto.getWebKorisnik()).isPresent();
    }

    @Transactional(readOnly = true)
    public Partner pronadjiPartneraPoId(final Integer id) {
        Partner retVal = null;
        final Optional<Partner> optionalPartner = partnerRepository.findById(id);
        if (optionalPartner.isPresent()) {
            retVal = optionalPartner.get();
        }
        return retVal;
    }

    /**
     * Servis za povecavanje broja logovanja korisnika
     */
    public void povecanPartnerovOrderCount(final Partner partner) {
        final Optional<Partner> partnerHibernate = partnerRepository.findById(partner.getPpid());
        partnerHibernate.ifPresent(partnerBaza -> {
            final Users users = partnerBaza.getUsers();
            users.setOrderCount(users.getOrderCount() + 1);
        });
    }
}
