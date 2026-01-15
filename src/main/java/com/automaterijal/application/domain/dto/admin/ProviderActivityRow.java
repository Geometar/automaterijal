package com.automaterijal.application.domain.dto.admin;

import java.sql.Timestamp;

public interface ProviderActivityRow {
  String getProviderKey();

  Timestamp getLastItemAt();

  Long getLast10dCount();

  Long getBackorderCount10d();

  Long getMessageCount10d();
}
