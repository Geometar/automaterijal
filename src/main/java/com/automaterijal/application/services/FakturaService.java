package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.entity.Faktura;
import com.automaterijal.application.domain.entity.FakturaDetalji;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.mapper.FakturaMapper;
import com.automaterijal.application.domain.repository.FakturaDetaljiRepository;
import com.automaterijal.application.domain.repository.FakturaRepository;
import com.automaterijal.application.domain.repository.MestaIsporukeRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPlacanjaRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPrevozaRepository;
import com.automaterijal.application.domain.repository.valuehelp.StatusRepository;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.RobaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FakturaService {

    @NonNull
    final FakturaRepository fakturaRepository;
    @NonNull
    final FakturaDetaljiRepository fakturaDetaljiRepository;
    @NonNull
    final StatusRepository statusRepository;
    @NonNull
    final NacinPlacanjaRepository nacinPlacanjaRepository;
    @NonNull
    final NacinPrevozaRepository nacinPrevozaRepository;
    @NonNull
    final MestaIsporukeRepository mestaIsporukeRepository;
    @NonNull
    final RobaService robaService;
    @NonNull
    final RobaCeneService robaCeneService;
    @NonNull
    final ProizvodjacService proizvodjacService;
    @NonNull
    final PartnerService partnerService;

    @NonNull
    final FakturaMapper mapper;

    public FakturaDto sacuvajFakturu(final FakturaDto fakturaDto, final Partner partner) {
        final Faktura faktura = mapper.map(fakturaDto);
        mapper.popuniFakuturu(faktura, partner, vratiPoslednjiIdFakturuKorisnikaPovecan(partner.getPpid()));
        faktura.getDetalji().forEach(fakturaDetalji -> fakturaDetaljiRepository.save(fakturaDetalji));
        final Faktura fakturaDatabase = fakturaRepository.save(faktura);
        partnerService.povecanPartnerovOrderCount(partner);
        skiniRobuSaSastanja(faktura.getDetalji());
        return obogatiDto(mapper.map(fakturaDatabase), partner);
    }

    private void skiniRobuSaSastanja(final List<FakturaDetalji> detalji) {
        detalji.forEach(fakturaDetalji -> {
            robaService.skiniNarucenuRobuSaStanja(fakturaDetalji.getRobaId(), fakturaDetalji.getKolicina());
        });
    }

    @Transactional(readOnly = true)
    public Page<FakturaDto> vratiSveFaktureUlogovanogKorisnika(
            final Partner partner,
            final Integer page,
            final Integer pageSize) {
        final PageRequest pageRequest = PageRequest.of(page, pageSize, new Sort(Sort.Direction.ASC, "orderId"));
        return fakturaRepository.findByPpidOrderByDataSentDesc(partner.getPpid(), pageRequest)
                .map(mapper::map)
                .map(fakturaDto -> obogatiDto(fakturaDto, partner));
    }

    private FakturaDto obogatiDto(final FakturaDto fakturaDto, final Partner partner) {
        statusRepository.findById(fakturaDto.getStatus().getId()).ifPresent(status -> mapper.map(fakturaDto, status));
        nacinPlacanjaRepository.findById(fakturaDto.getNacinPlacanja().getId()).ifPresent(nacinPlacanja -> mapper.map(fakturaDto, nacinPlacanja));
        nacinPrevozaRepository.findById(fakturaDto.getNacinPrevoza().getId()).ifPresent(nacinPrevoza -> mapper.map(fakturaDto, nacinPrevoza));
        mestaIsporukeRepository.findById(fakturaDto.getAdresa().getId()).ifPresent(adresa -> mapper.map(fakturaDto, adresa));
        fakturaDto.setBrojStavki(
                fakturaDetaljiRepository.findByOrderId(fakturaDto.getId()).size()
        );
        if (fakturaDto.getDetalji() != null && !fakturaDto.getDetalji().isEmpty()) {
            fakturaDto.getDetalji().stream().forEach(fakturaDetaljiDto -> obogatiDetalje(fakturaDetaljiDto, partner));
        }
        return fakturaDto;
    }

    private void obogatiDetalje(final FakturaDetaljiDto dto, final Partner partner) {
        statusRepository.findById(dto.getStatus().getId()).ifPresent(status -> mapper.map(dto, status));
        robaService.pronadjiRobuPoPrimarnomKljucu(dto.getRobaId()).ifPresent(roba -> {
            mapper.map(dto, roba);
            proizvodjacService.vratiProizvodjacaPoPk(roba.getProid()).ifPresent(proizvodjac -> mapper.map(dto, proizvodjac));
            dto.setCena(
                    robaCeneService.vratiCenuRobePoRobiId(roba, partner).doubleValue()
            );
        });
    }

    @Transactional(readOnly = true)
    public FakturaDto vratiFakuturuPojedinacno(final Partner partner, final Integer id) {
        FakturaDto fakturaDto = null;
        final Optional<Faktura> faktura = fakturaRepository.findByPpidAndId(partner.getPpid(), id);
        if (faktura.isPresent()) {
            fakturaDto = faktura.map(mapper::map)
                    .map(dto -> obogatiDto(dto, partner)).get();
        }
        return fakturaDto;
    }

    @Transactional(readOnly = true)
    public Integer vratiPoslednjiIdFakturuKorisnikaPovecan(final Integer ppid) {
        Integer orderId = 1;
        final Optional<Faktura> faktura = fakturaRepository.findFirstByPpidOrderByOrderIdDesc(ppid);
        if (faktura.isPresent()) {
            orderId = faktura.get().getOrderId();
            ++orderId;
        }
        return orderId;
    }
}
