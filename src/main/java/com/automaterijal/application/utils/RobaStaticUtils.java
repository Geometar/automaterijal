package com.automaterijal.application.utils;

import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.constants.VrstaUlja;
import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.domain.entity.roba.Roba;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@UtilityClass
public class RobaStaticUtils {

    public List<String> miksujSveKatBrojeve(List<Roba> katBr, List<RobaKatBrPro> katBrProLista) {
        Set<String> kataloskiBrojevi = new HashSet<>();
        if (!katBr.isEmpty()) {
            katBr.forEach(roba -> {
                if (!StringUtils.isEmpty(roba.getKatbr()) && !" ".equals(roba.getKatbr())) {
                    kataloskiBrojevi.add(roba.getKatbr());
                }

                if (!StringUtils.isEmpty(roba.getKatbrpro()) && !" ".equals(roba.getKatbrpro())) {
                    kataloskiBrojevi.add(roba.getKatbrpro());
                }
            });
        }
        if (!katBrProLista.isEmpty()) {
            katBrProLista.forEach(robaKatBrPro -> {
                if (!StringUtils.isEmpty(robaKatBrPro.getKatbr()) && !" ".equals(robaKatBrPro.getKatbr())) {
                    kataloskiBrojevi.add(robaKatBrPro.getKatbr());
                }

                if (!StringUtils.isEmpty(robaKatBrPro.getKatbrpro()) && !" ".equals(robaKatBrPro.getKatbrpro())) {
                    kataloskiBrojevi.add(robaKatBrPro.getKatbrpro());
                }
            });
        }
        return new ArrayList(kataloskiBrojevi);
    }

    public List<String> pronadjiSveVrsteUlja(String vrstaUlja) {
        List<String> grupa = new ArrayList<>();
        if (VrstaUlja.MOTORNA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.MOTORNA_ULJA_SHELL);
            grupa.add(GrupeKonstante.MOTORNA_ULJA_OSTALO);
        } else if (VrstaUlja.MENJACKA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.MENJACKA_ULJA_SHELL);
            grupa.add(GrupeKonstante.MENJACKA_ULJA_OSTALO);
        } else if (VrstaUlja.KOCIONA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.KOCIONO_ULJA_SHELL);
            grupa.add(GrupeKonstante.KOCIONO_ULJA_OSTALO);
        } else if (VrstaUlja.ANTIFRIZ.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.ANTIFRIZ);
        } else if (VrstaUlja.HIDRAULICNA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.HIDRAULICNO_ULJA_SHELL);
            grupa.add(GrupeKonstante.HIDRAULICNO_ULJA_OSTALO);
        } else if (VrstaUlja.KOMPRESORSKA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.KOMPRESORSKA_ULJA_SHELL);
            grupa.add(GrupeKonstante.KOMPRESORSKA_ULJA_OSTALO);
        } else if (VrstaUlja.REDUTKORSKA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.REDUTKORSKA_ULJA);
        } else if (VrstaUlja.TRANSFORMATORSKA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.TRANSFORMATORSKA_ULJA);
        } else if (VrstaUlja.TURBINSKA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.TURBINSKA_ULJA);
        } else if (VrstaUlja.PNEUMATSKA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.PNEUMATSKA_ULJA);
        } else if (VrstaUlja.KLIZNA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.KLIZNA_ULJA);
        } else if (VrstaUlja.PREONOSNA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.PRENOSNA_ULJA);
        } else if (VrstaUlja.INDUSTRIJA.getFieldName().equals(vrstaUlja)) {
            grupa.add(GrupeKonstante.HIDRAULICNO_ULJA_SHELL);
            grupa.add(GrupeKonstante.HIDRAULICNO_ULJA_OSTALO);
            grupa.add(GrupeKonstante.KOMPRESORSKA_ULJA_SHELL);
            grupa.add(GrupeKonstante.KOMPRESORSKA_ULJA_OSTALO);
            grupa.add(GrupeKonstante.REDUTKORSKA_ULJA);
            grupa.add(GrupeKonstante.TRANSFORMATORSKA_ULJA);
            grupa.add(GrupeKonstante.TURBINSKA_ULJA);
            grupa.add(GrupeKonstante.PNEUMATSKA_ULJA);
            grupa.add(GrupeKonstante.KLIZNA_ULJA);
            grupa.add(GrupeKonstante.PRENOSNA_ULJA);
        }
        return grupa;
    }
}
