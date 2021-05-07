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
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IzvestajService {

    @NonNull
    final KomentarRepository komentarRepository;

    @NonNull
    final FirmaRepository firmaRepository;

    @NonNull
    final IzvetajMapper izvetajMapper;

    @NonNull
    final PartnerService partnerService;

    @NonNull
    final IzvestajJooqRepository jooqRepository;

    public Page<IzvestajDto> vratiSveIzvestaje(
            Partner partner,
            String trazenaRec,
            Integer page,
            Integer pageSize,
            LocalDateTime vremeOd,
            LocalDateTime vremeDo,
            Integer komercijalista) {
        var pageable = PageRequest.of(
                page, pageSize
        );
        Page<Komentar> komentar = jooqRepository.pronadjiSveKomentarePoParametrima(partner, trazenaRec, GeneralUtil.LDTToTimestamp(vremeOd), GeneralUtil.LDTToTimestamp(vremeDo), komercijalista, pageable);
        List<IzvestajDto> izvestajiDto = map(komentar.getContent());

        return new PageImpl(izvestajiDto, komentar.getPageable(), komentar.getTotalElements());
    }

    /**
     * Logika za kreiranje izvestaja
     */
    public void kreirajIzvestaj(Partner partner, KreirajIzvestaj izvestaj) {
        Firma firma = izvetajMapper.mapirajFirmu(izvestaj, partner);
        Firma firmaSacuvana = firmaRepository.save(firma);

        Komentar komentar = izvetajMapper.mapIzvestaj(izvestaj, firmaSacuvana, partner);
        komentarRepository.save(komentar);
    }

    public List<Firma> vratiSveFirme() {
        return firmaRepository.findAll();
    }

    /**
     * Pravljenje detalja izvestaja
     */
    public Optional<IzvestajDto> vratiIzvestajPojedinacno(Long id, Partner ulogovaniPartner) {
        Optional<IzvestajDto> retVal = Optional.empty();
        Optional<Komentar> komentar = komentarRepository.findById(id);
        if (komentar.isPresent()) {
            Komentar vracenKomentar = komentar.get();
            if (ulogovaniPartner.getPrivilegije() != 2047 && ulogovaniPartner.getPpid().intValue() != vracenKomentar.getPpid().intValue()) {
                return retVal;
            }
            Partner partner = partnerService.pronadjiPartneraPoId(vracenKomentar.getPpid());
            IzvestajDto izvestajDto = new IzvestajDto();
            KomentarDto komentarDto = izvetajMapper.map(vracenKomentar, partner);
            FirmaDto firmaDto = izvetajMapper.map(
                    firmaRepository.findById(komentarDto.getFirma()).get()
            );

            izvestajDto.setKomentarDto(komentarDto);
            izvestajDto.setFirmaDto(firmaDto);
            retVal = Optional.of(izvestajDto);
        }
        return retVal;
    }

    public List<IzvestajDto> prinadjiIzvestajNaDanasnjiDan() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime danas = LocalDateTime.of(localDate, LocalTime.of(0, 0, 0));
        List<Komentar> komentari = komentarRepository.findByPodsetnik(GeneralUtil.LDTToTimestamp(danas));
        List<IzvestajDto> izvestajiDto = map(komentari);
        return izvestajiDto;
    }

    private List<IzvestajDto> map(List<Komentar> komentari) {
        return komentari.stream()
                .map(kom -> {
                    Partner partner = partnerService.pronadjiPartneraPoId(kom.getPpid());
                    return izvetajMapper.map(kom, partner);
                })
                .map(komDto -> {
                    IzvestajDto izvestajDto = new IzvestajDto();
                    izvestajDto.setKomentarDto(komDto);
                    firmaRepository.findById(komDto.getFirma()).ifPresent(firma -> {
                        izvestajDto.setFirmaDto(izvetajMapper.map(firma));
                    });
                    return izvestajDto;
                })
                .collect(Collectors.toList());
    }

}
