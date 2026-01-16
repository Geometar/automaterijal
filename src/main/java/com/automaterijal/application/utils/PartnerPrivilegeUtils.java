package com.automaterijal.application.utils;

import com.automaterijal.application.domain.entity.Partner;

public final class PartnerPrivilegeUtils {
  public static final int ADMIN_PRIVILEGIJE = 2047;
  public static final int SUPER_ADMIN_PPID = 3456;

  private PartnerPrivilegeUtils() {}

  public static boolean isInternal(Partner partner) {
    return partner != null
        && partner.getPrivilegije() != null
        && partner.getPrivilegije().intValue() == ADMIN_PRIVILEGIJE;
  }

  public static boolean isSuperAdmin(Partner partner) {
    return isInternal(partner)
        && partner.getPpid() != null
        && partner.getPpid().intValue() == SUPER_ADMIN_PPID;
  }
}
