package com.automaterijal.application.domain.model;

import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniverzalniParametri {

  Integer page;
  Integer pageSize;
  List<String> proizvodjac;
  List<String> mandatoryProid;
  boolean naStanju;
  String trazenaRec;
  List<String> grupa;
  List<Integer> podgrupeZaPretragu;
  List<ArticleDirectSearchAllNumbersWithStateRecord> kesiranDirectArticleSearch;
  boolean tecdocPretraga;

  public List<String> resolveProizvodjac() {
    List<String> proizvodjac = this.getProizvodjac();
    if (proizvodjac != null && !proizvodjac.isEmpty()) {
      return proizvodjac;
    }

    List<String> mandatoryProid = this.getMandatoryProid();
    if (mandatoryProid != null && !mandatoryProid.isEmpty()) {
      return mandatoryProid;
    }

    return new ArrayList<>();
  }
}
