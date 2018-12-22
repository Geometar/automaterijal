package com.automaterijal.application.utils;

import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.constants.VrstaUlja;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@UtilityClass
public class RobaStaticUtils {

    public UniverzalniParametri popuniIVratiGenerickeParametreZaServis(final Integer page, final Integer pageSize, final RobaSortiranjePolja sortBy, final RobaSortiranjePolja sortBy1, final String proizvodjac, final Boolean naStanju, final RobaSortiranjePolja sortBy2, final Sort.Direction sortDirection, final String searchTerm) {
        final Integer iPage = page == null ? 0 : page;
        final Integer iPageSize = pageSize == null ? 10 : pageSize;
        final String iProizvodjac = proizvodjac == null ? null : proizvodjac;
        final Boolean iNaStanju = naStanju == null ? true : naStanju;
        final RobaSortiranjePolja iSortiranjePolja = sortBy == null ? RobaSortiranjePolja.KATBR : sortBy;
        final Sort.Direction iDirection = sortDirection == null ? Sort.Direction.ASC : sortDirection;
        final String iSearchTerm = searchTerm == null ? null : searchTerm.trim().toUpperCase();
        return popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iSortiranjePolja, iDirection, iSearchTerm);
    }

    private UniverzalniParametri popuniParametreZaServis(final Integer internalPage, final Integer internalPageSize, final String internalProizvodjac, final Boolean internalNaStanju, final RobaSortiranjePolja internalSortiranjePolja, final Sort.Direction internalDirection, final String internalSearchTerm) {
        return new UniverzalniParametri(internalPage, internalPageSize, internalProizvodjac, internalNaStanju, internalSortiranjePolja, internalDirection, internalSearchTerm);
    }

    public List<String> miksujSveKatBrojeve(final List<Roba> katBr, final List<RobaKatBrPro> katBrProLista) {
        final Set<String> kataloskiBrojevi = new HashSet<>();
        if (!katBr.isEmpty()) {
            katBr.forEach(roba -> {
                kataloskiBrojevi.add(roba.getKatbr());
                kataloskiBrojevi.add(roba.getKatbrpro());
            });
        }
        if (!katBrProLista.isEmpty()) {
            katBrProLista.forEach(robaKatBrPro -> {
                kataloskiBrojevi.add(robaKatBrPro.getKatbrpro());
            });
        }
        return new ArrayList(kataloskiBrojevi);
    }

    public String[] pronadjiSveVrsteUlja(final String vrstaUlja) {
        final String[] grupa = new String[2];
        if(VrstaUlja.MOTORNA.getFieldName().equals(vrstaUlja)) {
            grupa[0] = GrupeKonstante.MOTORNA_ULJA_SHELL;
            grupa[1] = GrupeKonstante.MOTORNA_ULJA_OSTALO;
        } else if(VrstaUlja.MENJACKA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.MENJACKA_ULJA_SHELL;
            grupa[1] = GrupeKonstante.MENJACKA_ULJA_OSTALO;
        } else if(VrstaUlja.KOCIONA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.KOCIONO_ULJA_SHELL;
            grupa[1] = GrupeKonstante.KOCIONO_ULJA_OSTALO;
        } else if(VrstaUlja.ANTIFRIZ.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.ANTIFRIZ;
        } else if(VrstaUlja.HIDRAULICNA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.HIDRAULICNO_ULJA_SHELL;
            grupa[1] = GrupeKonstante.HIDRAULICNO_ULJA_OSTALO;
        } else if(VrstaUlja.KOMPRESORSKA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.KOMPRESORSKA_ULJA_SHELL;
            grupa[1] = GrupeKonstante.KOMPRESORSKA_ULJA_OSTALO;
        } else if(VrstaUlja.REDUTKORSKA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.REDUTKORSKA_ULJA;
        } else if(VrstaUlja.TRANSFORMATORSKA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.TRANSFORMATORSKA_ULJA;
        } else if(VrstaUlja.TURBINSKA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.TURBINSKA_ULJA;
        } else if(VrstaUlja.PNEUMATSKA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.PNEUMATSKA_ULJA;
        } else if(VrstaUlja.KLIZNA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.KLIZNA_ULJA;
        } else if(VrstaUlja.PREONOSNA.getFieldName().equals(vrstaUlja)){
            grupa[0] = GrupeKonstante.PREONOSNA_ULJA;
        }
        return grupa;
    }
}
