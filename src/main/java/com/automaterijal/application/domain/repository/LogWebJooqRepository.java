package com.automaterijal.application.domain.repository;

import static com.automaterijal.db.tables.LogWeb.LOG_WEB;

import com.automaterijal.application.domain.entity.LogWeb;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.db.tables.records.LogWebRecord;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class LogWebJooqRepository {
 
  @Autowired
  DSLContext dslContext;

  public boolean daLiJeVecUBaziLog(Partner partner, String proizvodjac, String filter,
      String pretraga, LocalDateTime datumDanas) {
    SelectConditionStep<LogWebRecord> logWebRecords = dslContext.selectFrom(LOG_WEB)
        .where(LOG_WEB.PPID.eq(partner.getPpid()));
    logWebRecords.and(LOG_WEB.VREME_PRETRAGE.eq(datumDanas));
    if (proizvodjac != null) {
      logWebRecords.and(LOG_WEB.PROIZVODJAC.eq(proizvodjac));
    }
    if (pretraga != null) {
      logWebRecords.and(LOG_WEB.PRETRAGA.eq(pretraga));
    }
    if (filter != null) {
      logWebRecords.and(LOG_WEB.FILTER.eq(filter));
    }
    return !logWebRecords.fetch().isEmpty();
  }

  public void sacuvajLog(LogWeb logWeb) {
    LogWebRecord logWebRecord = dslContext.newRecord(LOG_WEB);
    logWebRecord.setPpid(logWeb.getPpid());
    logWebRecord.setFilter(logWeb.getFilter());
    logWebRecord.setProizvodjac(logWeb.getProizvodjac());
    logWebRecord.setPretraga(logWeb.getPretraga());
    logWebRecord.setVremePretrage(logWeb.getVremePretrage());
    logWebRecord.store();
  }
}
