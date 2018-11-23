package com.automaterijal.application.services.security;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Users;
import com.automaterijal.application.domain.mapper.PartnerMapper;
import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    public PartnerRepository partnerRepository;

    @Autowired
    public UsersRepository usersRepository;

    final PartnerMapper mapper = PartnerMapper.INSTANCE;

    @Override
    public CurrentUser loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Partner partner = partnerRepository.findByWebKorisnik(username);
        if (partner == null) {
            throw new UsernameNotFoundException("Partner not found with username " + username);
        }
        final Optional<Users> usersOptional = usersRepository.findById(partner.getPpid());
        if (!usersOptional.isPresent()) {
            throw new UsernameNotFoundException("Users not found with username " + username);
        }
        return new CurrentUser(partner, usersOptional.get().getPassword());
    }

    public PartnerDto vratiUlogovanogKorisnika() {
        PartnerDto partnerDto = null;
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof CurrentUser) {
            final CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            partnerDto = mapper.map(currentUser.vratiPartnera());
        }

        return partnerDto;
    }
}
