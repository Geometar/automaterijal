package com.automaterijal.application.domain.model;

import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
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
  boolean naStanju;
  String trazenaRec;
  List<String> grupa;
  List<String> podgrupeZaPretragu;
  RobaKategorije robaKategorije;
  List<PodGrupa> podGrupe;
  List<ArticleDirectSearchAllNumbersWithStateRecord> kesiranDirectArticleSearch;
}
