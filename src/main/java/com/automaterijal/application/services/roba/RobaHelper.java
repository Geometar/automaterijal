package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.RobaCene;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.services.SlikeService;
import com.automaterijal.application.services.TecDocService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaHelper {

  @NonNull final RobaCeneService robaCeneService;
  @NonNull final SlikeService slikeService;
  @NonNull final TecDocService tecDocService;

  public void setujZaTabelu(List<RobaDto> robaDtos, Partner partner) {
    List<Long> listaRobeId = robaDtos.stream().map(RobaDto::getRobaid).toList();
    List<TecDocAtributi> tecDocAtributiSvi =
        tecDocService.vratiTecDocAtributePrekoRobeIds(listaRobeId);

    List<RobaCene> robaCene = robaCeneService.pronadjiCeneZaRobuBatch(listaRobeId);

    robaDtos.stream()
        .filter(robaDto -> robaDto.getRobaid() != null)
        .forEach(
            robaDto -> {
              List<TecDocAtributi> tecDocAtributi =
                  tecDocAtributiSvi.stream()
                      .filter(atributi -> Objects.equals(atributi.getRobaId(), robaDto.getRobaid()))
                      .collect(Collectors.toList());

              setupTehnickeAtributeTabela(tecDocAtributi, robaDto);
              setCenuRobeTabela(robaDto, robaCene, partner);
              robaDto.setSlika(vratiSliku(robaDto.getRobaid(), robaDto.getSlika()));
            });
  }

  private void setupTehnickeAtributeTabela(List<TecDocAtributi> tecDocAtributi, RobaDto robaDto) {
    List<RobaTehnickiOpisDto> tehnickiOpisi = new ArrayList<>();
    for (TecDocAtributi dto : tecDocAtributi) {
      if (dto.getTecDocArticleId() != null) {
        if (dto.getDokumentId() == null
            && dto.getAttrType() != null
            && (dto.getAttrType().equals("N") || dto.getAttrType().equals("A"))) {
          RobaTehnickiOpisDto tehnickiOpisDto = new RobaTehnickiOpisDto();
          tehnickiOpisDto.setType(dto.getAttrType());
          tehnickiOpisDto.setOznaka(dto.getAttrShortName());
          tehnickiOpisDto.setJedinica(dto.getAttrUnit());
          tehnickiOpisDto.setVrednost(dto.getAttrValue());
          tehnickiOpisi.add(tehnickiOpisDto);
        } else if (dto.getDokumentId() != null) {
          robaDto.setDokumentSlikaId(dto.getDokumentId());
          robaDto.setDokument(dto.getDokument());
        }
      }
    }

    if (tehnickiOpisi.isEmpty()) {
      for (TecDocAtributi dto : tecDocAtributi) {
        if (dto.getTecDocArticleId() != null && dto.getDokumentId() == null) {
          RobaTehnickiOpisDto tehnickiOpisDto = new RobaTehnickiOpisDto();
          tehnickiOpisDto.setOznaka(dto.getAttrShortName());
          tehnickiOpisDto.setJedinica(dto.getAttrUnit());
          tehnickiOpisDto.setVrednost(dto.getAttrValue());
          tehnickiOpisi.add(tehnickiOpisDto);
        }
      }
    }

    tehnickiOpisi.sort(
        Comparator.comparing(
            RobaTehnickiOpisDto::getType, Comparator.nullsFirst(Comparator.naturalOrder())));
    robaDto.setTehnickiOpis(tehnickiOpisi);
  }

  public void setCenuRobeTabela(RobaDto robaDto, List<RobaCene> robaCene, Partner partner) {

    RobaCene cene =
        robaCene.stream()
            .filter(cena -> cena.getRobaid().equals(robaDto.getRobaid()))
            .findFirst()
            .orElse(null);
    robaDto.setCena(
        robaCeneService.vratiCenuRobeBatch(
            cene, robaDto.getGrupa(), robaDto.getProizvodjac().getProid(), partner));
    robaDto.setRabat(
        robaCeneService.vratiRabatPartneraNaArtikal(
            robaDto.getProizvodjac().getProid(), robaDto.getGrupa(), partner));
  }

  public SlikaDto vratiSliku(Long robaId, SlikaDto slikaDto) {
    String url =
        slikaDto != null && slikaDto.getRobaSlika() != null && !slikaDto.getRobaSlika().isEmpty()
            ? slikaDto.getRobaSlika()
            : robaId.toString();
    return slikeService.vratiSlikuRobe(url);
  }
}
