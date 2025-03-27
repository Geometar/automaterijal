package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.LogWebDto;
import com.automaterijal.application.domain.entity.LogWeb;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.LogWebJooqRepository;
import com.automaterijal.application.domain.repository.LogWebRepository;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

  @NonNull final PodGrupaService podGrupaService;

  @Async
  public void log(Partner partner, UniverzalniParametri parametri) {
    List<String> proizvodjac = parametri.resolveProizvodjac();
    List<String> filter = new ArrayList<>();
    if (!parametri.getPodgrupeZaPretragu().isEmpty()) {
      filter =
          this.podGrupaService.vratiPodgrupuPoKljucu(parametri.getPodgrupeZaPretragu()).stream()
              .map(PodGrupa::getNaziv)
              .collect(Collectors.toList());
    }

    String pretraga = parametri.getTrazenaRec();

    if (partner == null
        || partner.getPrivilegije() > 2042
        || (filter.isEmpty() && proizvodjac.isEmpty() && pretraga == null)) {
      return;
    }

    LocalDateTime datumDanas = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
    if (!logWebJooqRepository.daLiJeVecUBaziLog(
        partner, proizvodjac, filter, pretraga, datumDanas)) {
      LogWeb logWeb = napraviLog(partner, filter, proizvodjac, pretraga, datumDanas);
      logWebJooqRepository.sacuvajLog(logWeb);
    }
  }

  public Page<LogWebDto> vratiLogove(Integer ppid, Pageable pageable) {
    return logWebRepository
        .findByPpidOrderByVremePretrageDescIdDesc(ppid, pageable)
        .map(
            log ->
                new LogWebDto(
                    log.getId(),
                    log.getPpid(),
                    trimWithEllipsis(log.getProizvodjac(), 20),
                    trimWithEllipsis(log.getFilter(), 20),
                    log.getPretraga(),
                    log.getVremePretrage()));
  }

  private LogWeb napraviLog(
      Partner partner,
      List<String> filter,
      List<String> proizvodjac,
      String pretraga,
      LocalDateTime datumDanas) {

    LogWeb logWeb = new LogWeb();
    logWeb.setPpid(partner.getPpid());

    // Convert lists to comma-separated strings or fallback to empty string
    logWeb.setFilter((filter != null && !filter.isEmpty()) ? String.join(", ", filter) : "");
    logWeb.setProizvodjac(
        (proizvodjac != null && !proizvodjac.isEmpty()) ? String.join(", ", proizvodjac) : "");

    logWeb.setPretraga(pretraga);
    logWeb.setVremePretrage(datumDanas);

    return logWeb;
  }

  private String trimWithEllipsis(String input, int maxLength) {
    if (input == null) return null;
    if (input.length() <= maxLength) return input;

    return input.substring(0, maxLength).trim() + "...";
  }
}
