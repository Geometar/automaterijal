package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.izvestaj.FirmaDto;
import com.automaterijal.application.domain.dto.izvestaj.KomentarDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Firma;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Komentar;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.KreirajIzvestaj;
import java.sql.Timestamp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IzvetajMapper {

  @Mapping(target = "id", source = "komentar.id")
  @Mapping(target = "podsetnik", source = "komentar.podsetnik")
  @Mapping(target = "datumKreiranja", source = "komentar.datumKreiranja")
  @Mapping(target = "komentar", source = "komentar.komentar")
  @Mapping(target = "firma", source = "komentar.firma")
  @Mapping(target = "ppid", source = "komentar.ppid")
  @Mapping(target = "komercijalista", source = "partner.naziv")
  KomentarDto map(Komentar komentar, Partner partner);

  FirmaDto map(Firma firma);

  @Mapping(target = "komentar", source = "izvestaj.komentar")
  @Mapping(target = "firma", source = "firma.id")
  @Mapping(target = "datumKreiranja", source = "izvestaj.datumKreiranja")
  @Mapping(target = "podsetnik", source = "izvestaj.podsetnik")
  @Mapping(target = "ppid", source = "partner.ppid")
  @Mapping(target = "id", ignore = true)
  Komentar mapIzvestaj(KreirajIzvestaj izvestaj, Firma firma, Partner partner);

  @Mapping(target = "id", source = "izvestaj.firmaId")
  @Mapping(target = "mesto", source = "izvestaj.mesto")
  @Mapping(target = "ime", source = "izvestaj.ime")
  @Mapping(target = "adresa", source = "izvestaj.adresa")
  @Mapping(target = "kontakt", source = "izvestaj.kontakt")
  @Mapping(target = "sektor", source = "izvestaj.sektor")
  @Mapping(target = "osnovniAsortiman", source = "izvestaj.osnovniAsortiman")
  @Mapping(target = "konkurent", source = "izvestaj.konkurent")
  @Mapping(target = "ppid", source = "partner.ppid")
  Firma mapirajFirmu(KreirajIzvestaj izvestaj, Partner partner);

  default Timestamp map(Long time) {
    return new Timestamp(time);
  }
}
