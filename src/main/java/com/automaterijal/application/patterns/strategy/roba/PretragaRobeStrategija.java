package com.automaterijal.application.patterns.strategy.roba;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;

public interface PretragaRobeStrategija {
    MagacinDto pretrazi(UniverzalniParametri parametri, Partner ulogovaniPartner);
}
