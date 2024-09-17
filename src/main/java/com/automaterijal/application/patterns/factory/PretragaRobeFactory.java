package com.automaterijal.application.patterns.factory;

import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.patterns.strategy.roba.PretragaBezFilteraStrategija;
import com.automaterijal.application.patterns.strategy.roba.PretragaRobeStrategija;
import com.automaterijal.application.patterns.strategy.roba.PretragaSaFilteromStrategija;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PretragaRobeFactory {


    @NonNull PretragaBezFilteraStrategija pretragaBezFiltera;
    @NonNull PretragaSaFilteromStrategija pretragaSaFilterom;

    // Biranje strategije na osnovu parametara pretrage
    public PretragaRobeStrategija getPretragaStrategija(UniverzalniParametri parametri) {
        if (parametri.getTrazenaRec() == null && parametri.getProizvodjac() == null
                && parametri.getGrupa() == null && parametri.getPodgrupaZaPretragu() == null) {
            return pretragaBezFiltera;
        } else {
            return pretragaSaFilterom;
        }
    }
}
