package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Faktura;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.FakturaMapper;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.FakturaDetaljiRepository;
import com.automaterijal.application.domain.repository.FakturaRepository;
import com.automaterijal.application.domain.repository.MestaIsporukeRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPlacanjaRepository;
import com.automaterijal.application.domain.repository.valuehelp.NacinPrevozaRepository;
import com.automaterijal.application.domain.repository.valuehelp.StatusRepository;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.services.roba.RobaSlikaService;
import com.automaterijal.application.utils.GeneralUtil;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @NonNull
    final RobaSlikaService slikaService;
    @NonNull
    final RobaMapper robaMapper;

    @Value("${roba.slika.prefixTabela}")
    String prefixTabela;

    @Value("${roba.slika.prefixThumbs}")
    String prefixThumbs;

    public List<RobaDto> submitujFakturu(FakturaDto fakturaDto, Partner partner) {
        List<RobaDto> dozvoljenaKolicina = new ArrayList<>();
        proveraMagacinaIKolicina(dozvoljenaKolicina, fakturaDto);
        if (dozvoljenaKolicina.isEmpty()) {
            sacuvajFakturu(fakturaDto, partner);
        }
        return dozvoljenaKolicina;
    }

    private void proveraMagacinaIKolicina(List<RobaDto> dozvoljenaKolicina, FakturaDto fakturaDto) {
        fakturaDto.getDetalji().forEach(detalji -> {
            Optional<Roba> robaOptional = robaService.pronadjiRobuPoPrimarnomKljucu(detalji.getRobaId());
            if (robaOptional.isPresent()) {
                Roba roba = robaOptional.get();
                if (roba.getStanje() < detalji.getKolicina()) {
                    dozvoljenaKolicina.add(robaMapper.map(roba));
                }
            }
        });
    }

    private void sacuvajFakturu(FakturaDto fakturaDto, Partner partner) {
        Faktura faktura = mapper.map(fakturaDto);
        mapper.popuniFakuturu(faktura, partner, vratiPoslednjiIdFakturuKorisnikaPovecan(partner.getPpid()));
        faktura.getDetalji().forEach(fakturaDetalji -> fakturaDetaljiRepository.save(fakturaDetalji));

        fakturaRepository.save(faktura);
        partnerService.povecanPartnerovOrderCount(partner);
    }

    @Transactional(readOnly = true)
    public Page<FakturaDto> vratiSveFaktureUlogovanogKorisnika(
            Partner partner,
            Integer page,
            Integer pageSize,
            LocalDateTime vremeOd,
            LocalDateTime vremeDo) {
        var pageRequest = PageRequest.of(page, pageSize, new Sort(Sort.Direction.ASC, "orderId"));
        return fakturaRepository.findByPpidAndDataSentGreaterThanAndDataSentLessThanOrderByDataSentDesc(
                partner.getPpid(),
                pageRequest,
                GeneralUtil.LDTToTimestamp(vremeOd),
                GeneralUtil.LDTToTimestamp(vremeDo)

        ).map(mapper::map)
                .map(fakturaDto -> obogatiDto(fakturaDto, partner));
    }

    private FakturaDto obogatiDto(FakturaDto fakturaDto, Partner partner) {
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
        formatirajCenuFakture(fakturaDto);
        return fakturaDto;
    }

    private void formatirajCenuFakture(FakturaDto fakturaDto) {
        var formater = new DecimalFormat("#.##");
        formater.setRoundingMode(RoundingMode.UP);
        BigDecimal bigDecimal = new BigDecimal(0);
        for (FakturaDetaljiDto dto : fakturaDto.getDetalji()) {
            if (dto.getPotvrdjenaKolicina() > 0) {
                double ukupnaCenaDela = dto.getPotvrdjenaKolicina() * dto.getCena();
                bigDecimal = bigDecimal.add(new BigDecimal(ukupnaCenaDela));
            }
            dto.setCena(Double.valueOf(formater.format(dto.getCena())));
        }

        var iznosNarucen = Double.valueOf(formater.format(fakturaDto.getIznosNarucen()));
        fakturaDto.setIznosNarucen(iznosNarucen);
        fakturaDto.setIznosPotvrdjen(bigDecimal.doubleValue());
    }

    private void obogatiDetalje(FakturaDetaljiDto dto, Partner partner) {
        slikaService.pronadjiPutanjuSlikePoId(dto.getRobaId()).ifPresent(robaSlika -> {
            dto.setSlikaId(prefixTabela + prefixThumbs + robaSlika.getSlika());
        });
        statusRepository.findById(dto.getStatus().getId()).ifPresent(status -> mapper.map(dto, status));
        robaService.pronadjiRobuPoPrimarnomKljucu(dto.getRobaId()).ifPresent(roba -> {
            mapper.map(dto, roba);
            proizvodjacService.vratiProizvodjacaPoPk(roba.getProizvodjac().getProid()).ifPresent(proizvodjac -> mapper.map(dto, proizvodjac));
            dto.setCena(
                    robaCeneService.vratiCenuRobePoRobiId(roba.getRobaid(), roba.getGrupaid(), roba.getProizvodjac().getProid(), partner).doubleValue()
            );
        });
    }

    @Transactional(readOnly = true)
    public FakturaDto vratiFakuturuPojedinacno(Partner partner, Integer id) {
        FakturaDto fakturaDto = null;
        Optional<Faktura> faktura = fakturaRepository.findByPpidAndId(partner.getPpid(), id);
        if (faktura.isPresent()) {
            fakturaDto = faktura.map(mapper::map)
                    .map(dto -> obogatiDto(dto, partner)).get();
        }
        return fakturaDto;
    }

    @Transactional(readOnly = true)
    public Integer vratiPoslednjiIdFakturuKorisnikaPovecan(Integer ppid) {
        Integer orderId = 1;
        Optional<Faktura> faktura = fakturaRepository.findFirstByPpidOrderByOrderIdDesc(ppid);
        if (faktura.isPresent()) {
            orderId = faktura.get().getOrderId();
            ++orderId;
        }
        return orderId;
    }

    @Transactional(readOnly = true)
    public List<Faktura> vratiUpdejtovaneFakture(Timestamp timestamp) {
        return fakturaRepository.findByLastUpdateGreaterThan(timestamp);
    }
}
