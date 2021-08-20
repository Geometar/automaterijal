package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.SlikeUtility;
import com.automaterijal.application.domain.entity.TDBrands;
import com.automaterijal.application.domain.entity.roba.RobaSlika;
import com.automaterijal.application.domain.repository.TDBrandsRepository;
import com.automaterijal.application.services.roba.RobaSlikaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlikeService {

    @NonNull
    final TDBrandsRepository tdBrandsRepository;

    @NonNull
    final RobaSlikaService robaSlikaService;

    final List<SlikeUtility> slikeUtilities = SlikeUtility.vratiSveUtilitySlike();

    @Value("${roba.slika.prefixTabela}")
    String prefixTabela;

    @Value("${roba.slika.prefixThumbs}")
    String prefixThumbs;

    @Value("${roba.slika.tdPrefix}")
    String tdPrefix;

    private static final String SLIKA_NIJE_DOSTUPNA_URL = "assets/slike/ui/roba/slikanijedostupna.jpg";

    public String vratiPutanjuDoSlike(String proid, String katBar, Long robaId) {
        String retVal = null;
        Optional<TDBrands> tdBrandsOptional = tdBrandsRepository.findByProid(proid);
        Optional<RobaSlika> robaSlika = robaSlikaService.pronadjiPutanjuSlikePoId(robaId);
        if (tdBrandsOptional.isPresent() && !robaSlika.isPresent()) {
            TDBrands tdBrands = tdBrandsOptional.get();
            boolean postojiKonstanta = false;
            for (int i = 0; i < slikeUtilities.size(); i++) {
                SlikeUtility slikeUtility = slikeUtilities.get(i);
                if (slikeUtility.getProid().equals(proid) && katBar.contains(slikeUtility.getSadrzaj())) {
                    retVal = tdPrefix + tdBrands.getBraId() + "/" + slikeUtility.getKonstanta();
                    postojiKonstanta = true;
                    break;
                }
            }
            if (!postojiKonstanta) {
                if (tdBrands.getRemoveChar() != null) {
                    katBar = katBar.replace(tdBrands.getRemoveChar(), "");
                }
                if (tdBrands.getRemoveSufix() != null && tdBrands.getRemoveSufix().length() > 0 && katBar.indexOf(tdBrands.getRemoveSufix()) == katBar.length() - tdBrands.getRemoveSufix().length()) {
                    katBar = katBar.substring(0, katBar.length() - tdBrands.getRemoveSufix().length());
                }
                if (tdBrands.getRemovePrefix() != null && tdBrands.getRemovePrefix().length() > 0 && katBar.indexOf(tdBrands.getRemovePrefix()) == 0) {
                    katBar = katBar.substring(katBar.length() - tdBrands.getRemovePrefix().length());
                }
                retVal = tdPrefix + tdBrands.getBraId() + "/" + tdBrands.getAddPrefix() + katBar + tdBrands.getAddSufix() + ".jpg";
            }
        } else {
            if (robaSlika.isPresent()) {
                retVal = prefixTabela + prefixThumbs + robaSlika.get().getSlika();
            } else {
                retVal = SLIKA_NIJE_DOSTUPNA_URL;
            }
        }

        return retVal;
    }

}
