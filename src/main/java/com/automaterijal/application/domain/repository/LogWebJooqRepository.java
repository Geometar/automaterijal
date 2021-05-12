package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.LogWeb;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.db.tables.records.LogWebRecord;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Timestamp;

import static com.automaterijal.db.tables.LogWeb.LOG_WEB;

@Component
@Transactional
public class LogWebJooqRepository {

    @Autowired
    DSLContext dslContext;

    public boolean daLiJeVecUBaziLog(Partner partner, String proizvodjac, String filter, String pretraga, Timestamp datumDanas) {
        SelectConditionStep<LogWebRecord> logWebRecords = dslContext.selectFrom(LOG_WEB).where(LOG_WEB.PPID.eq(partner.getPpid()));
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
        return logWebRecords.fetch().size() > 0;
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
