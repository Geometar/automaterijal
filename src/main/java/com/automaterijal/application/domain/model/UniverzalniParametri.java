package com.automaterijal.application.domain.model;

import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniverzalniParametri {

    Integer page;
    Integer pageSize;
    String proizvodjac;
    boolean naStanju;
    String trazenaRec;
    String grupa;
    String podgrupaZaPretragu;
    RobaKategorije robaKategorije;
    List<PodGrupa> podGrupe;
    List<ArticleDirectSearchAllNumbersWithStateRecord> kesiranDirectArticleSearch;
}
