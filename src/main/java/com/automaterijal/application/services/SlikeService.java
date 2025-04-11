package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.ImageRecord;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlikeService {

  @Value("${roba.slika.tdPrefix}")
  String tdPrefix;

  private static final String SLIKA_NIJE_DOSTUPNA_URL = "images/no-image/no-image.png";

  public SlikaDto vratiSlikuRobe(String slikaUrl) {
    SlikaDto slikaDto = new SlikaDto();
    String url = tdPrefix + (slikaUrl.contains(".jpg") ? slikaUrl : slikaUrl + ".jpg");
    try {
      final ByteArrayResource inputStream =
          new ByteArrayResource(Files.readAllBytes(Paths.get(url)));
      slikaDto.setSlikeByte(inputStream.getByteArray());
      slikaDto.setUrl(false);
    } catch (IOException exception) {
      slikaDto.setSlikeUrl(SLIKA_NIJE_DOSTUPNA_URL);
      slikaDto.setUrl(true);
    }

    return slikaDto;
  }

  public SlikaDto getImageFromTD(ArticleRecord articleRecord) {
    SlikaDto slikaDto = new SlikaDto();
    slikaDto.setUrl(true);
    if (articleRecord.getImages() != null && !articleRecord.getImages().isEmpty()) {
      ImageRecord imageRecord = articleRecord.getImages().getFirst();
      slikaDto.setSlikeUrl(
          imageRecord.getImageURL200() != null
              ? imageRecord.getImageURL200()
              : imageRecord.getImageURL100());

      return slikaDto;
    } else {
      slikaDto.setSlikeUrl(SLIKA_NIJE_DOSTUPNA_URL);
    }
    return slikaDto;
  }

  public String getImageForBrandLogo(TecDocBrands tecDocBrands) {
    byte[] logoBytes = tecDocBrands.getBrand();
    if (logoBytes == null || logoBytes.length == 0) {
      return null;
    }
    String mimeType;
    try {
      mimeType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(logoBytes));
    } catch (IOException e) {
      throw new RuntimeException("Failed to detect mime type", e);
    }
    if (mimeType == null) mimeType = "image/jpeg"; // fallback ako guess ne uspe

    String base64 = Base64.getEncoder().encodeToString(logoBytes);
    return "data:" + mimeType + ";base64," + base64;
  }
}
