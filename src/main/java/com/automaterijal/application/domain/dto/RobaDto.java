package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.services.SlikeService;
import com.automaterijal.application.tecdoc.ArticleRecord;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDto {
  Long robaid;
  SlikaDto slika;
  String katbr;
  String katbrpro;
  String naziv;
  ProizvodjacDTO proizvodjac;
  byte[] proizvodjacLogo;
  String grupa;
  int podGrupa;
  String podGrupaNaziv;
  BigDecimal cena;
  Double rabat;
  String dokumentSlikaId;
  byte[] dokument;
  double stanje;
  List<RobaTehnickiOpisDto> tehnickiOpis;

  public void setProizvodjacDto(Proizvodjac proizvodjac) {
    ProizvodjacDTO proizvodjacDTO = new ProizvodjacDTO();
    proizvodjacDTO.setProizvodjac(proizvodjac);
    setProizvodjac(proizvodjacDTO);
  }

  public static RobaDto fromTecdocArticle(
      ArticleRecord articleRecord,
      TecDocProizvodjaci tecDocProizvodjaci,
      SlikeService slikeService) {
    String katBr =
        TecDocProizvodjaci.generateAlternativeCatalogNumber(
            articleRecord.getArticleNumber(), tecDocProizvodjaci);

    RobaDto data = new RobaDto();
    data.setKatbr(katBr);
    data.setNaziv(articleRecord.getGenericArticles().get(0).getGenericArticleDescription());

    ProizvodjacDTO proizvodjacDTO = new ProizvodjacDTO();
    proizvodjacDTO.setProid(tecDocProizvodjaci.name());
    data.setProizvodjac(proizvodjacDTO);

    data.setPodGrupaNaziv("Tecdoc artikli");
    data.setGrupa("Dodatno");
    data.setPodGrupa(0);
    data.setSlika(slikeService.getImageFromTD(articleRecord));

    // Convert technical descriptions
    List<RobaTehnickiOpisDto> tehnickiOpisi =
        RobaTehnickiOpisDto.fromArticleCriteria(articleRecord.getArticleCriteria());
    tehnickiOpisi = tehnickiOpisi.stream().limit(4).collect(Collectors.toList());
    tehnickiOpisi.sort(Comparator.comparing(RobaTehnickiOpisDto::getType));
    data.setTehnickiOpis(tehnickiOpisi);

    return data;
  }
}
