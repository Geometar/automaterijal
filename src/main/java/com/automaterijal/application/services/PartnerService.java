package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.ResetovanjeSifreDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Users;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.services.security.UsersService;
import com.automaterijal.application.utils.LoginStaticUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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

    @NonNull
    final UsersService usersService;

    public boolean promeniSifruPartnera(final ResetovanjeSifreDto resetovanjeSifreDto, final boolean isPrvaPromena) {
        boolean uspesnaPromenaSifre = false;
        final Optional<Partner> partnerOptinal = partnerRepository.findByPpid(resetovanjeSifreDto.getPpid());
        if (partnerOptinal.isPresent()) {
            final Partner partner = partnerOptinal.get();
            if(isPrvaPromena) {
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

    public Optional<Partner> vratiPartneraPomocuKorisnickogImena(final String korisnickoIme) {
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

    public void povecanPartnerovOrderCount(final Partner partner) {
        final Optional<Partner> partnerHibernate = partnerRepository.findById(partner.getPpid());
        partnerHibernate.ifPresent(partnerBaza -> {
           final Users users = partnerBaza.getUsers();
           users.setOrderCount(users.getOrderCount() + 1);
        });
    }
}
