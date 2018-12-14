package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.entity.Faktura;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.mapper.FakturaMapper;
import com.automaterijal.application.domain.repository.FakturaDetaljiRepository;
import com.automaterijal.application.domain.repository.FakturaRepository;
import com.automaterijal.application.domain.repository.MestaIsporukeRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPlacanjaRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPrevozaRepository;
import com.automaterijal.application.domain.repository.valuehelp.StatusRepository;
import com.automaterijal.application.services.constants.ProizvodjacService;
import com.automaterijal.application.services.roba.RobaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
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

    final FakturaMapper MAPPER = FakturaMapper.INSTANCE;

    public Page<FakturaDto> vratiSveFaktureUlogovanogKorisnika(
            final Partner partner,
            final Integer page,
            final Integer pageSize) {
        final PageRequest pageRequest = PageRequest.of(page, pageSize, new Sort(Sort.Direction.ASC, "orderId"));
        return fakturaRepository.findByPpidOrderByDataSentDesc(partner.getPpid(), pageRequest)
                .map(MAPPER::map)
                .map(fakturaDto -> obogatiDto(fakturaDto, partner));
    }

    private FakturaDto obogatiDto(final FakturaDto fakturaDto, final Partner partner) {
        statusRepository.findById(fakturaDto.getStatus().getId()).ifPresent(status -> MAPPER.map(fakturaDto, status));
        nacinPlacanjaRepository.findById(fakturaDto.getNacinPlacanja().getId()).ifPresent(nacinPlacanja -> MAPPER.map(fakturaDto, nacinPlacanja));
        nacinPrevozaRepository.findById(fakturaDto.getNacinPrevoza().getId()).ifPresent(nacinPrevoza -> MAPPER.map(fakturaDto, nacinPrevoza));
        mestaIsporukeRepository.findById(fakturaDto.getAdresa().getId()).ifPresent(adresa -> MAPPER.map(fakturaDto, adresa));
        fakturaDto.setBrojStavki(
                fakturaDetaljiRepository.findByOrderId(fakturaDto.getId()).size()
        );
        if (fakturaDto.getDetalji() != null && !fakturaDto.getDetalji().isEmpty()) {
            fakturaDto.getDetalji().stream().forEach(fakturaDetaljiDto -> obogatiDetalje(fakturaDetaljiDto, partner));
        }
        return fakturaDto;
    }

    private void obogatiDetalje(final FakturaDetaljiDto dto, final Partner partner) {
        statusRepository.findById(dto.getStatus().getId()).ifPresent(status -> MAPPER.map(dto, status));
        robaService.pronadjiRobuPoPrimarnomKljucu(dto.getRobaId()).ifPresent(roba -> {
            MAPPER.map(dto, roba);
            proizvodjacService.vratiProizvodjacaPoPk(roba.getProid()).ifPresent(proizvodjac -> MAPPER.map(dto, proizvodjac));
            dto.setCena(
                    robaCeneService.vratiCenuRobePoRobiId(roba, partner).doubleValue()
            );
        });
    }

    public FakturaDto vratiFakuturuPojedinacno(final Partner partner, final Integer id) {
        FakturaDto fakturaDto = null;
        final Optional<Faktura> faktura = fakturaRepository.findByPpidAndId(partner.getPpid(), id);
        if (faktura.isPresent()) {
            fakturaDto = faktura.map(MAPPER::map)
                    .map(dto -> obogatiDto(dto, partner)).get();
        }
        return fakturaDto;
    }
}
