package com.automaterijal.application.services.security;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.mapper.PartnerMapper;
import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @NonNull
    final PartnerRepository partnerRepository;

    @NonNull
    final UsersService usersService;

    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    final PartnerMapper mapper = PartnerMapper.INSTANCE;

    @Override
    public CurrentUser loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<Partner> optionalPartner = partnerRepository.findByWebKorisnik(username);
        if (!optionalPartner.isPresent()) {
            throw new UsernameNotFoundException("Partner not found with username " + username);
        }
        final Partner partner = optionalPartner.get();
        if (partner.getUsers() == null) {
            final var user = usersService.sacuvajUsera(partner);
            partner.setUsers(user);
        }

        return new CurrentUser(partner);
    }

    public PartnerDto vratiUlogovanogKorisnika(final Authentication authentication) {
        PartnerDto partnerDto = null;
        final Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if (partner != null) {
            partnerDto = mapper.map(partner);
        }

        return partnerDto;
    }
}
