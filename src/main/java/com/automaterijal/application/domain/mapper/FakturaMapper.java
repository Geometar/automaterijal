package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.entity.*;
import com.automaterijal.application.domain.entity.valuehelp.NacinPlacanja;
import com.automaterijal.application.domain.entity.valuehelp.NacinPrevoza;
import com.automaterijal.application.domain.entity.valuehelp.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public abstract class FakturaMapper {

    @Mapping(target = "vremePorucivanja", source = "dataSent")
    @Mapping(target = "status.id", source = "status")
    @Mapping(target = "nacinPlacanja.id", source = "nuid")
    @Mapping(target = "nacinPrevoza.id", source = "niid")
    @Mapping(target = "adresa.id", source = "mestoIsporuke")
    public abstract FakturaDto map(Faktura faktura);

    public void popuniFakuturu(final Faktura faktura, final Partner partner, final Integer orderId) {
        faktura.setOrderId(orderId);
        faktura.setDataSent(Timestamp.valueOf(LocalDateTime.now()));
        faktura.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
        faktura.setPpid(partner.getPpid());
        //default values
        faktura.setRealizovati(1);
        faktura.setBackOrder(0);
        faktura.setCreatedByPpid(partner.getPpid());
        faktura.setIznosPotvrdjen(0.0);
        faktura.setStatus(3);
        faktura.setPrid(1);

        popuniFakturaDetalje(faktura);
    }

    protected void popuniFakturaDetalje(final Faktura faktura) {
        faktura.getDetalji().forEach(fakturaDetalji -> {
            fakturaDetalji.setOrderId(faktura.getOrderId());
            fakturaDetalji.setPotvrdjenaKolicina(0.0);
            fakturaDetalji.setKolicine(1);
            fakturaDetalji.setStatus(3);
            fakturaDetalji.setPdv(20.0);
            fakturaDetalji.setMagacinId(1);
            fakturaDetalji.setInsertDatetime(Timestamp.valueOf(LocalDateTime.now()));
            fakturaDetalji.setPpid(faktura.getPpid());
        });
    }

    @Mapping(target = "nuid", source = "nacinPlacanja.id")
    @Mapping(target = "niid", source = "nacinPrevoza.id")
    @Mapping(target = "mestoIsporuke", source = "adresa.id")
    public abstract Faktura map(FakturaDto faktura);

    public Integer map(final ValueHelpDto valueHelpDto) {
        Integer retVal = null;
        if(valueHelpDto != null) {
            retVal = valueHelpDto.getId();
        }
        return retVal;
    }

    @Mapping(target = "nacinPlacanja.id", source = "id")
    @Mapping(target = "nacinPlacanja.naziv", source = "naziv")
    @Mapping(target = "id", ignore = true)
    public abstract FakturaDto map(@MappingTarget FakturaDto fakturaDto, NacinPlacanja nacinPlacanja);

    @Mapping(target = "nacinPrevoza.id", source = "id")
    @Mapping(target = "nacinPrevoza.naziv", source = "naziv")
    @Mapping(target = "id", ignore = true)
    public abstract FakturaDto map(@MappingTarget FakturaDto fakturaDto, NacinPrevoza nacinPrevoza);

    @Mapping(target = "adresa.id", source = "ppid")
    @Mapping(target = "adresa.naziv", source = "adresa")
    @Mapping(target = "id", ignore = true)
    public abstract FakturaDto map(@MappingTarget FakturaDto fakturaDto, MestaIsporuke mestaIsporuke);

    @Mapping(target = "status.id", source = "id")
    @Mapping(target = "status.naziv", source = "opis")
    @Mapping(target = "id", ignore = true)
    public abstract FakturaDto map(@MappingTarget FakturaDto fakturaDto, Status status);

    @Mapping(target = "kolicina", source = "kolicina")
    @Mapping(target = "status.id", source = "status")
    public abstract FakturaDetaljiDto map(final FakturaDetalji fakturaDetalji);

    @Mapping(target = "status.id", source = "id")
    @Mapping(target = "status.naziv", source = "opis")
    public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Status status);

    @Mapping(target = "kataloskiBroj", source = "katbr")
    @Mapping(target = "kataloskiBrojProizvodjaca", source = "katbrpro")
    public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Roba roba);
    public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Proizvodjac proizvodjac);

}
