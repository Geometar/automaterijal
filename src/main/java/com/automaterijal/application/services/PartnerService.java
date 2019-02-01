package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.dto.ResetovanjeSifreDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.mapper.PartnerMapper;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.utils.LoginStaticUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerService {

    @NonNull
    final PartnerRepository partnerRepository;

    final PartnerMapper mapper = PartnerMapper.INSTANCE;

    public PartnerDto updejtPartnera(final PartnerDto partnerDto, final Authentication authentication) {
        PartnerDto retVal = null;
        final Optional<Partner> optionalPartner = partnerRepository.findById(partnerDto.getPpid());
        if (optionalPartner.isPresent()) {
            final Partner partner = optionalPartner.get();
            if (partnerDto.getStariPassword() != null || partnerDto.getNoviPassword() != null) {
                if (LoginStaticUtils.md5Password(partnerDto.getStariPassword()).equals(partner.getUsers().getPassword())) {
                    partnerDto.setNoviPassword(LoginStaticUtils.md5Password(partnerDto.getNoviPassword()));
                } else {
                    return retVal;
                }
            }
            mapper.map(partner, partnerDto);
            retVal = mapper.map(partner);
        }
        return retVal;
    }

    public boolean promeniSifruPartnera(final ResetovanjeSifreDto resetovanjeSifreDto) {
        boolean uspesnaPromenaSifre = false;
        final Optional<Partner> partnerOptinal = partnerRepository.findByPpidAndUsersPassword(resetovanjeSifreDto.getPpid(), resetovanjeSifreDto.getStaraSifra());
        if (partnerOptinal.isPresent()) {
            final Partner partner = partnerOptinal.get();
            partner.getUsers().setPassword(LoginStaticUtils.md5Password(resetovanjeSifreDto.getSifra()));
            uspesnaPromenaSifre = true;
        } else {
            uspesnaPromenaSifre = false;
        }
        return uspesnaPromenaSifre;
    }

    @Transactional(readOnly = true)
    public boolean daLiPostojiVecZauzetaRegistracije(final PartnerDto partnerDto) {
        return partnerRepository.findByWebKorisnik(partnerDto.getWebKorisnik()).isPresent();
    }

    public Optional<Partner> vratiPartneraPomocuKorisnickogImena(String korisnickoIme) {
        return partnerRepository.findByWebKorisnik(korisnickoIme);
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

    @Transactional(readOnly = true)
    public Optional<Partner> pronadjiPartneraPoMejlu(final String email) {
        return partnerRepository.findByEmail(email);
    }
}
