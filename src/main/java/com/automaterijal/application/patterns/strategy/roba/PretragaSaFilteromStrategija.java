package com.automaterijal.application.patterns.strategy.roba;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaHelper;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PretragaSaFilteromStrategija {
  @NonNull final RobaAdapterService robaAdapter;
  @NonNull final TecDocService tecDocService;
  @NonNull final RobaHelper robaHelper;

  public MagacinDto pretrazi(UniverzalniParametri parametri, Partner ulogovaniPartner) {

    MagacinDto magacinDto =
        parametri.getTrazenaRec() != null
            ? logikaZaMagacinSaTrazenomRecju(parametri)
            : robaAdapter.vratiRobuFiltriranuBezPretrage(parametri);

    if (!magacinDto.getRobaDto().isEmpty()) {
      tecDocService.batchVracanjeICuvanjeTDAtributa(magacinDto.getRobaDto().getContent());
      robaHelper.setujZaTabelu(magacinDto.getRobaDto().getContent(), ulogovaniPartner);
    }

    return magacinDto;
  }

  private MagacinDto logikaZaMagacinSaTrazenomRecju(UniverzalniParametri parametri) {
    final Set<String> kataloskiBrojevi = new HashSet<>();
    Set<Long> robaId = new HashSet<>();

    robaAdapter.pronadjiPoKatBroju(kataloskiBrojevi, robaId, parametri);
    if (!kataloskiBrojevi.isEmpty()) {
      robaAdapter.pomocniKveriPoRobiOld(kataloskiBrojevi);
      robaAdapter.pronadjiPoKatBrojuIn(kataloskiBrojevi, robaId);
    }

    // Pokusaj pretrage pomocu naziva
    if (kataloskiBrojevi.isEmpty()
        && robaAdapter.pronadjiPoNazivu(parametri, kataloskiBrojevi, robaId)) {
      return robaAdapter.pronadjiPoRobaId(parametri, robaId);
    }

    // Ukljucujemo tecdoc u pretragu
    pretragaPomocuTecDoca(parametri, kataloskiBrojevi);

    return robaAdapter.vratiArtikleIzTecDoca(parametri, kataloskiBrojevi);
  }

  private void pretragaPomocuTecDoca(UniverzalniParametri parametri, Set<String> kataloskiBrojevi) {

    // TecDoc pretraga na osnovu tačne reči, tip pretrage je 10 (trazimo sve)
    List<ArticleDirectSearchAllNumbersWithStateRecord> response =
        tecDocService.tecDocPretragaPoTrazenojReci(parametri.getTrazenaRec(), null, 10);
    parametri.setKesiranDirectArticleSearch(response);

    // Obrada rezultata TecDoc pretrage
    response.forEach(
        rekord -> {
          String katBr = rekord.getArticleNo();
          // Pronalazi proizvođača na osnovu ID brenda
          TecDocProizvodjaci tecDocProizvodjaci =
              TecDocProizvodjaci.pronadjiPoKljucu(rekord.getBrandNo().intValue());
          kataloskiBrojevi.add(katBr);

          // Ako proizvođač ima dodatak, kreira se alternativni kataloški broj
          if (tecDocProizvodjaci != null && tecDocProizvodjaci.getDodatak() != null) {
            String alternativiKatBr;
            if (tecDocProizvodjaci.isDodatakNaKraju()) {
              alternativiKatBr = katBr + tecDocProizvodjaci.getDodatak();
            } else {
              alternativiKatBr = tecDocProizvodjaci.getDodatak() + katBr;
            }
            kataloskiBrojevi.add(alternativiKatBr);
          }
        });

    // Dodavanje tačne tražene reči kao kataloškog broja
    kataloskiBrojevi.add(parametri.getTrazenaRec());
  }
}
