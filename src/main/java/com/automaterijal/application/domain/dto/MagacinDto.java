package com.automaterijal.application.domain.dto;

import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

/**
 * DTO koji predstavlja rezultat pretrage/artikala za FE.
 *
 * <p>U ovom projektu imamo dve vrste stavki:
 *
 * <ul>
 *   <li><b>Lokalna roba</b> ({@link #robaDto}) – artikli koji postoje u našoj bazi (imaju {@code robaId},
 *       interne {@code grupa/podGrupa} itd.). Za njih se koristi standardni flow (cena, rabat, stanje...).
 *   <li><b>External-only ponude</b> – artikli koji <i>ne postoje</i> u našoj bazi (nema {@code robaId}),
 *       ali su dostupni kod providera kada je upit u režimu {@code dostupno=true}. U tom režimu backend
 *       ih projicira u {@link #robaDto} kao {@code RobaLightDto} sa {@code robaId=null}, a cenu/količinu
 *       nosi {@code providerAvailability}.
 * </ul>
 *
 * <p>{@link #categories} služe da FE ima jedan jedinstven filter po internim kategorijama (grupa/podgrupa)
 * i predstavljaju uniju kategorija prisutnih u lokalnim rezultatima + external ponude. Kada mapping za
 * TecDoc genericArticleId još ne postoji, external-only stavke dobijaju fallback kategoriju {@code OSTALO}
 * i ona se takođe pojavljuje u categories.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MagacinDto {

  Page<RobaLightDto> robaDto;
  Map<String, List<PodgrupaDto>> categories;
  List<ProizvodjacDTO> proizvodjaci;
}
