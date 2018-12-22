package com.automaterijal.application.services.security;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.mapper.PartnerMapper;
import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.domain.repository.UsersRepository;
import com.automaterijal.application.utils.PartnerStaticUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        return new CurrentUser(partner);
    }

    public PartnerDto vratiUlogovanogKorisnika(final Authentication authentication) {
        PartnerDto partnerDto = null;
        final Partner partner = PartnerStaticUtils.vratiPartneraIsSesije(authentication);
        if (partner != null) {
            partnerDto = mapper.map(partner);
        }

        return partnerDto;
    }
}
