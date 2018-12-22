package com.automaterijal.application.utils;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.CurrentUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;

@UtilityClass
public class PartnerStaticUtils {

    public Partner vratiPartneraIsSesije(final Authentication authentication) {
        Partner retVal = null;
        if(authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof CurrentUser) {
            retVal = ((CurrentUser) authentication.getPrincipal()).vratiPartnera();
        }
        return retVal;
    }
}
