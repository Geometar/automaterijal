package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.SlikeUtility;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.TDBrands;
import com.automaterijal.application.domain.entity.roba.RobaSlika;
import com.automaterijal.application.domain.repository.TDBrandsRepository;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.services.roba.RobaSlikaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlikeService {

    @NonNull
    final TDBrandsRepository tdBrandsRepository;

    @NonNull
    final TecDocAtributiRepository tecDocAtributiRepository;

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

    public SlikaDto vratiPutanjuDoSlike(String proid, String katBar, Long robaId) {
        SlikaDto slikaDto = new SlikaDto();
        if (robaId != null && tecDocAtributiRepository.findByRobaId(robaId) != null) {
            String url = tdPrefix + robaId + ".jpg";
            podesiSlikaByte(url, slikaDto);
            return slikaDto;
        }
        Optional<TDBrands> tdBrandsOptional = tdBrandsRepository.findByProid(proid);
        Optional<RobaSlika> robaSlika = robaSlikaService.pronadjiPutanjuSlikePoId(robaId);
        if (tdBrandsOptional.isPresent() && !robaSlika.isPresent()) {
            TDBrands tdBrands = tdBrandsOptional.get();
            boolean postojiKonstanta = false;

            // trenutno je ovo samo za kontinental kaiseve
            if ("CONTI".equals(proid)) {
                for (int i = 0; i < slikeUtilities.size(); i++) {
                    SlikeUtility slikeUtility = slikeUtilities.get(i);
                    if (slikeUtility.getProid().equals(proid) && katBar.contains(slikeUtility.getSadrzaj())) {
                        String url = tdPrefix + tdBrands.getBraId() + "/" + slikeUtility.getKonstanta();
                        podesiSlikaByte(url, slikaDto);
                        postojiKonstanta = true;
                        break;
                    }
                }
            }

            // Logika za zamenu URL-ova
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
                String url = tdPrefix + tdBrands.getBraId() + "/" + tdBrands.getAddPrefix() + katBar + tdBrands.getAddSufix() + ".jpg";
                podesiSlikaByte(url, slikaDto);
            }
        } else {
            if (robaSlika.isPresent()) {
                slikaDto.setSlikeUrl(prefixTabela + prefixThumbs + robaSlika.get().getSlika());
            } else {
                slikaDto.setSlikeUrl(SLIKA_NIJE_DOSTUPNA_URL);
            }
            slikaDto.setUrl(true);
        }

        return slikaDto;
    }

    private void podesiSlikaByte(String url, SlikaDto slikaDto) {
        try {
            final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                    url
            )));
            slikaDto.setSlikeByte(inputStream.getByteArray());
            slikaDto.setUrl(false);
        } catch (IOException exception) {
            slikaDto.setSlikeUrl(SLIKA_NIJE_DOSTUPNA_URL);
            slikaDto.setUrl(true);
        }
    }

}
