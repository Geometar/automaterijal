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
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    final PartnerMapper mapper = PartnerMapper.INSTANCE;

    @Override
    public CurrentUser loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<Partner> partner = partnerRepository.findByWebKorisnik(username);
        if (!partner.isPresent()) {
            throw new UsernameNotFoundException("Partner not found with username " + username);
        }
        return new CurrentUser(partner.get());
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
