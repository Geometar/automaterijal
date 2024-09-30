package com.automaterijal.application.utils;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.services.PartnerService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PartnerSpringBeanUtils {

  @NonNull PartnerService partnerService;

  public Partner vratiPartneraIsSesije(Authentication authentication) {
    Partner retVal = null;
    if (authentication != null
        && authentication.isAuthenticated()
        && authentication.getPrincipal() instanceof CurrentUser currentUser) {
      Integer ppid = currentUser.vratiPartnera().getPpid();
      retVal = partnerService.pronadjiPartneraPoId(ppid);
    }
    return retVal;
  }
}
