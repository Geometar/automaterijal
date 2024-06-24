package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.constants.StatusiKonstante;
import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.entity.Faktura;
import com.automaterijal.application.domain.entity.FakturaDetalji;
import com.automaterijal.application.domain.entity.MestaIsporuke;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.valuehelp.NacinPlacanja;
import com.automaterijal.application.domain.entity.valuehelp.NacinPrevoza;
import com.automaterijal.application.domain.entity.valuehelp.Status;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class FakturaMapper {

  @Mapping(target = "vremePorucivanja", source = "dataSent")
  @Mapping(target = "status.id", source = "status")
  @Mapping(target = "nacinPlacanja.id", source = "nuid")
  @Mapping(target = "nacinPrevoza.id", source = "niid")
  @Mapping(target = "adresa.id", source = "mestoIsporuke")
  @Mapping(target = "partner", source = "ppid")
  public abstract FakturaDto map(Faktura faktura);

  public void popuniFakuturu(Faktura faktura, Partner partner, Integer orderId) {
    faktura.setOrderId(orderId);
    faktura.setDataSent(Timestamp.valueOf(LocalDateTime.now()));
    faktura.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
    faktura.setPpid(partner.getPpid());
    //default values
    faktura.setRealizovati(1);
    faktura.setBackOrder(0);
    faktura.setCreatedByPpid(partner.getPpid());
    faktura.setIznosPotvrdjen(0.0);
    faktura.setStatus(StatusiKonstante.NIJE_UZETA_U_OBRADU.getFieldValue());
    faktura.setPrid(1);

    popuniFakturaDetalje(faktura);
  }

  protected void popuniFakturaDetalje(Faktura faktura) {
    faktura.getDetalji().forEach(fakturaDetalji -> {
      fakturaDetalji.setOrderId(faktura.getOrderId());
      fakturaDetalji.setPotvrdjenaKolicina(0.0);
      fakturaDetalji.setKolicine(1);
      fakturaDetalji.setStatus(StatusiKonstante.NIJE_UZETA_U_OBRADU.getFieldValue());
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

  public Integer map(ValueHelpDto valueHelpDto) {
    Integer retVal = null;
    if (valueHelpDto != null) {
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
  public abstract FakturaDetaljiDto map(FakturaDetalji fakturaDetalji);

  @Mapping(target = "status.id", source = "id")
  @Mapping(target = "status.naziv", source = "opis")
  public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Status status);

  @Mapping(target = "kataloskiBroj", source = "katbr")
  @Mapping(target = "kataloskiBrojProizvodjaca", source = "katbrpro")
  @Mapping(target = "slika.robaSlika", source = "slika")
  public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Roba roba);

  @Mapping(target = "naziv", ignore = true)
  public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Proizvodjac proizvodjac);

}
