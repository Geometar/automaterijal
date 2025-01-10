package com.automaterijal.application.services;

import com.automaterijal.application.domain.entity.LogWeb;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.repository.LogWebJooqRepository;
import com.automaterijal.application.domain.repository.LogWebRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogWebService {

  @NonNull final LogWebRepository logWebRepository;

  @NonNull final LogWebJooqRepository logWebJooqRepository;

  @Async
  public void log(Partner partner, List<String> filter, List<String> proizvodjac, String pretraga) {
    if (partner == null
        || partner.getPrivilegije() > 2042
        || (filter == null && proizvodjac == null && pretraga == null)) {
      return;
    }
    LocalDateTime datumDanas = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
    if (!logWebJooqRepository.daLiJeVecUBaziLog(
        partner, proizvodjac, filter, pretraga, datumDanas)) {
      LogWeb logWeb = napraviLog(partner, filter, proizvodjac, pretraga, datumDanas);
      logWebJooqRepository.sacuvajLog(logWeb);
    }
  }

  public Page<LogWeb> vratiLogove(Integer ppid, Pageable pageable) {
    return logWebRepository.findByPpidOrderByVremePretrageDescIdDesc(ppid, pageable);
  }

  private LogWeb napraviLog(
      Partner partner,
      List<String> filter,
      List<String> proizvodjac,
      String pretraga,
      LocalDateTime datumDanas) {
    LogWeb logWeb = new LogWeb();
    logWeb.setPpid(partner.getPpid());
    logWeb.setFilter(filter.toString());
    logWeb.setProizvodjac(proizvodjac.toString());
    logWeb.setPretraga(pretraga);
    logWeb.setVremePretrage(datumDanas);
    return logWeb;
  }
}
