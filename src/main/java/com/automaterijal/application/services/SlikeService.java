package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.SlikaDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlikeService {

    @Value("${roba.slika.tdPrefix}")
    String tdPrefix;

    private static final String SLIKA_NIJE_DOSTUPNA_URL = "assets/slike/ui/roba/slikanijedostupna.jpg";

    public SlikaDto vratiSlikuRobe(String slikaUrl) {
        SlikaDto slikaDto = new SlikaDto();
        String url = tdPrefix + (slikaUrl.contains(".jpg") ? slikaUrl : slikaUrl + ".jpg");
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

        return slikaDto;
    }

}
