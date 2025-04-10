package com.automaterijal.application.services.security;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Users;
import com.automaterijal.application.domain.mapper.PartnerMapper;
import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.utils.LoginStaticUtils;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailsService
    implements org.springframework.security.core.userdetails.UserDetailsService {

  @NonNull final PartnerRepository partnerRepository;

  @NonNull final PartnerSpringBeanUtils partnerSpringBeanUtils;

  @NonNull final PartnerMapper mapper;

  /**
   * Izvlacimo korisnika iz baze po username-u za logovanje. Postoji 2 scenarija ovde 1) Korisnik
   * postoji u bazi kao i u tabeli user i sve prolazi regularno 2) Korisnik postoji u bazi ali ne i
   * u tabeli user, inicira se prvo logovanje 3) Ne postoji u bazi partner, bacamo u gresku i
   * pokazujemo na UI
   */
  @Override
  public CurrentUser loadUserByUsername(final String username) throws UsernameNotFoundException {
    final Optional<Partner> optionalPartner =
        partnerRepository.findByWebKorisnikAndWebStatusGreaterThan(username, 0);
    if (optionalPartner.isEmpty()) {
      throw new UsernameNotFoundException("Partner not found with username " + username);
    }
    final Partner partner = optionalPartner.get();
    if (partner.getUsers() == null) {
      final var users = new Users();
      users.setPassword(LoginStaticUtils.md5Password(partner.getWebKorisnik()));
      users.setLoginCount(0);
      partner.setUsers(users);
    }
    return new CurrentUser(partner);
  }

  public PartnerDto vratiUlogovanogKorisnika(final Authentication authentication) {
    PartnerDto partnerDto = null;
    final Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
    if (partner != null) {
      partnerDto = mapper.map(partner);
      partnerDto.setNaziv(partner.getNaziv());
    }

    return partnerDto;
  }
}
