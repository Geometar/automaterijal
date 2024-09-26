package com.automaterijal.application.domain.repository;

import static com.automaterijal.db.tables.Firma.FIRMA;
import static com.automaterijal.db.tables.Komentar.KOMENTAR;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Komentar;
import com.automaterijal.db.tables.records.FirmaRecord;
import com.automaterijal.db.tables.records.KomentarRecord;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.SelectWhereStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class IzvestajJooqRepository {

  @Autowired
  DSLContext dslContext;

  public Page<Komentar> pronadjiSveKomentarePoParametrima(Partner partner, String trazenaRec,
                                                          LocalDateTime vremeOd, LocalDateTime vremeDo, Integer komercijalista, Pageable pageable) {
    SelectWhereStep<KomentarRecord> komentarRecords = dslContext.selectFrom(KOMENTAR);
    SelectConditionStep<KomentarRecord> select = null;
    if (partner.getPrivilegije() == 2047) {
      select = komentarRecords.where("1=1");
    } else {
      select = komentarRecords.where(KOMENTAR.PPID.eq(partner.getPpid()));
    }

    if (trazenaRec != null) {
      List<Integer> sviId = vratiSveIdFirme(trazenaRec);
      select.and(KOMENTAR.FIRMA.in(sviId));
    }

    if (vremeDo != null) {
      select.and(KOMENTAR.DATUM_KREIRANJA.lessThan(vremeDo));
    }
    if (vremeOd != null) {
      select.and(KOMENTAR.DATUM_KREIRANJA.greaterOrEqual(vremeOd));
    }
    if (partner.getPrivilegije() == 2047 && komercijalista != null) {
      select.and(KOMENTAR.PPID.eq(komercijalista));
    }
    select.orderBy(KOMENTAR.DATUM_KREIRANJA.desc());
    List<Komentar> komentari = select.fetch()
        .stream()
        .map(this::napraviKomentar)
        .collect(Collectors.toList());
    int start = pageable.getPageSize() * pageable.getPageNumber();
    int end = Math.min((start + pageable.getPageSize()), komentari.size());
    List<Komentar> retVal = komentari.subList(start, end);
    return new PageImpl<>(retVal, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
        komentari.size());
  }

  private List<Integer> vratiSveIdFirme(String trazenaRec) {
    return dslContext
        .selectFrom(FIRMA)
        .where(FIRMA.MESTO.contains(trazenaRec).or(FIRMA.IME.contains(trazenaRec)))
        .fetch()
        .stream()
        .map(FirmaRecord::getId)
        .collect(Collectors.toList());
  }

  private Komentar napraviKomentar(KomentarRecord komentarRecord) {
    Komentar komentar = new Komentar();
    komentar.setKomentar(komentarRecord.getKomentar());
    komentar.setId(komentarRecord.getId().longValue());
    komentar.setFirma(komentarRecord.getFirma().longValue());
    komentar.setPodsetnik(komentarRecord.getPodsetnik());
    komentar.setDatumKreiranja(komentarRecord.getDatumKreiranja());
    komentar.setPpid(komentarRecord.getPpid());
    return komentar;
  }


}
