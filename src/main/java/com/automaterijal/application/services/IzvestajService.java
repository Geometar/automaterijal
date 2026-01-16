package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.izvestaj.FirmaDto;
import com.automaterijal.application.domain.dto.izvestaj.IzvestajDto;
import com.automaterijal.application.domain.dto.izvestaj.KomentarDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Firma;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Komentar;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.KreirajIzvestaj;
import com.automaterijal.application.domain.mapper.IzvetajMapper;
import com.automaterijal.application.domain.repository.FirmaRepository;
import com.automaterijal.application.domain.repository.IzvestajJooqRepository;
import com.automaterijal.application.domain.repository.KomentarRepository;
import com.automaterijal.application.utils.GeneralUtil;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IzvestajService {

  @NonNull final KomentarRepository komentarRepository;

  @NonNull final FirmaRepository firmaRepository;

  @NonNull final IzvetajMapper izvetajMapper;

  @NonNull final PartnerService partnerService;

  @NonNull final IzvestajJooqRepository jooqRepository;

  public Page<IzvestajDto> vratiSveIzvestaje(
      Partner partner,
      String searchTerm,
      Integer page,
      Integer pageSize,
      LocalDateTime vremeOd,
      LocalDateTime vremeDo,
      Integer komercijalista) {
    var pageable = PageRequest.of(page, pageSize);
    Page<Komentar> komentar =
        jooqRepository.pronadjiSveKomentarePoParametrima(
            partner, searchTerm, vremeOd, vremeDo, komercijalista, pageable);
    List<IzvestajDto> izvestajiDto = map(komentar.getContent());

    return new PageImpl<>(izvestajiDto, komentar.getPageable(), komentar.getTotalElements());
  }

  /** Logika za kreiranje izvestaja */
  public void kreirajIzvestaj(Partner partner, KreirajIzvestaj izvestaj) {
    Firma firma = izvetajMapper.mapirajFirmu(izvestaj, partner);
    Firma firmaSacuvana = firmaRepository.save(firma);

    Komentar komentar = izvetajMapper.mapIzvestaj(izvestaj, firmaSacuvana, partner);
    komentarRepository.save(komentar);
  }

  public List<Firma> vratiSveFirme() {
    return firmaRepository.findAll();
  }

  public Optional<IzvestajDto> update(
      Long salesReportId, IzvestajDto izvestajDto, Partner partner) {
    Komentar komentar =
        komentarRepository
            .findById(salesReportId)
            .orElseThrow(() -> new EntityNotFoundException("Komentar not found"));

    updateKomentarFromDto(komentar, izvestajDto.getKomentarDto());
    updateFirmaFromDto(komentar.getFirma(), izvestajDto.getFirmaDto());
    return vratiIzvestajPojedinacno(salesReportId, partner);
  }

  private void updateFirmaFromDto(Long firmaId, FirmaDto firmaDto) {
    Firma firma =
        firmaRepository
            .findById(firmaId)
            .orElseThrow(() -> new EntityNotFoundException("Firma not found"));

    if (firmaDto.getIme() != null && !firmaDto.getIme().equals(firma.getIme())) {
      firma.setIme(firmaDto.getIme());
    }

    if (firmaDto.getMesto() != null && !firmaDto.getMesto().equals(firma.getMesto())) {
      firma.setMesto(firmaDto.getMesto());
    }

    if (firmaDto.getAdresa() != null && !firmaDto.getAdresa().equals(firma.getAdresa())) {
      firma.setAdresa(firmaDto.getAdresa());
    }

    if (firmaDto.getKontakt() != null && !firmaDto.getKontakt().equals(firma.getKontakt())) {
      firma.setKontakt(firmaDto.getKontakt());
    }

    if (firmaDto.getSektor() != null && !firmaDto.getSektor().equals(firma.getSektor())) {
      firma.setSektor(firmaDto.getSektor());
    }

    if (firmaDto.getOsnovniAsortiman() != null
        && !firmaDto.getOsnovniAsortiman().equals(firma.getOsnovniAsortiman())) {
      firma.setOsnovniAsortiman(firmaDto.getOsnovniAsortiman());
    }

    if (firmaDto.getKonkurent() != null && !firmaDto.getKonkurent().equals(firma.getKonkurent())) {
      firma.setKonkurent(firmaDto.getKonkurent());
    }

    // Po potrebi možeš dodati i ppid update ako treba
    // if (...) { firma.setPpid(...) }

    firmaRepository.save(firma);
  }

  private void updateKomentarFromDto(Komentar komentar, KomentarDto komentarDto) {

    // Compare and update only if different
    if (komentarDto.getKomentar() != null
        && !komentarDto.getKomentar().equals(komentar.getKomentar())) {
      komentar.setKomentar(komentarDto.getKomentar());
    }

    if (komentarDto.getFirma() != null && !komentarDto.getFirma().equals(komentar.getFirma())) {
      komentar.setFirma(komentarDto.getFirma());
    }

    if (komentarDto.getPpid() != null && !komentarDto.getPpid().equals(komentar.getPpid())) {
      komentar.setPpid(komentarDto.getPpid());
    }

    if (komentarDto.getDatumKreiranja() != null) {
      LocalDateTime dtoDateTime =
          new java.sql.Timestamp(komentarDto.getDatumKreiranja().getTime()).toLocalDateTime();
      if (!dtoDateTime.equals(komentar.getDatumKreiranja())) {
        komentar.setDatumKreiranja(dtoDateTime);
      }
    }

    if (komentarDto.getPodsetnik() != null) {
      LocalDateTime podsetnikDateTime = komentarDto.getPodsetnik().atStartOfDay();
      if (!podsetnikDateTime.equals(komentar.getPodsetnik())) {
        komentar.setPodsetnik(podsetnikDateTime);
      }
    }

    komentarRepository.save(komentar);
  }

  /** Pravljenje detalja izvestaja */
  public Optional<IzvestajDto> vratiIzvestajPojedinacno(Long id, Partner ulogovaniPartner) {
    Optional<IzvestajDto> retVal = Optional.empty();
    Optional<Komentar> komentar = komentarRepository.findById(id);
    if (komentar.isPresent()) {
      Komentar vracenKomentar = komentar.get();
      if (!PartnerPrivilegeUtils.isInternal(ulogovaniPartner)
          && ulogovaniPartner.getPpid().intValue() != vracenKomentar.getPpid().intValue()) {
        return retVal;
      }
      Partner partner = partnerService.pronadjiPartneraPoId(vracenKomentar.getPpid());
      IzvestajDto izvestajDto = new IzvestajDto();
      KomentarDto komentarDto = izvetajMapper.map(vracenKomentar, partner);
      FirmaDto firmaDto =
          izvetajMapper.map(firmaRepository.findById(komentarDto.getFirma()).orElse(null));

      izvestajDto.setKomentarDto(komentarDto);
      izvestajDto.setFirmaDto(firmaDto);
      retVal = Optional.of(izvestajDto);
    }
    return retVal;
  }

  public List<IzvestajDto> prinadjiIzvestajNaDanasnjiDan() {
    LocalDate localDate = LocalDate.now();
    LocalDateTime danas = LocalDateTime.of(localDate, LocalTime.of(0, 0, 0));
    List<Komentar> komentari =
        komentarRepository.findByPodsetnik(GeneralUtil.ldtToTimestamp(danas));
    return map(komentari);
  }

  private List<IzvestajDto> map(List<Komentar> komentari) {
    return komentari.stream()
        .map(
            kom -> {
              Partner partner = partnerService.pronadjiPartneraPoId(kom.getPpid());
              return izvetajMapper.map(kom, partner);
            })
        .map(
            komDto -> {
              IzvestajDto izvestajDto = new IzvestajDto();
              izvestajDto.setKomentarDto(komDto);
              firmaRepository
                  .findById(komDto.getFirma())
                  .ifPresent(firma -> izvestajDto.setFirmaDto(izvetajMapper.map(firma)));
              return izvestajDto;
            })
        .toList();
  }
}
