package com.automaterijal.application.domain.model;


import com.automaterijal.application.domain.entity.Partner;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.authority.AuthorityUtils;

@EqualsAndHashCode
public class CurrentUser extends org.springframework.security.core.userdetails.User {

  private final Partner partner;

  public CurrentUser(final Partner partner) {
    super(partner.getWebKorisnik(), partner.getUsers().getPassword(),
        AuthorityUtils.createAuthorityList(partner.getPrivilegije().toString()));
    this.partner = partner;
  }

  public Partner vratiPartnera() {
    return partner;
  }

  public Integer getId() {
    return partner.getPpid();
  }

  public String getRole() {
    return partner.getPrivilegije(
    ).toString();
  }

}
