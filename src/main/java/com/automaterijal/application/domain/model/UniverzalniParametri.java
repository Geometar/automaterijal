package com.automaterijal.application.domain.model;

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
  List<String> mandatoryProid;
  boolean naStanju;
  String trazenaRec;
  List<String> grupa;
  List<String> podgrupeZaPretragu;
  List<ArticleDirectSearchAllNumbersWithStateRecord> kesiranDirectArticleSearch;
}
