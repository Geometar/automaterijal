package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.ImageRecord;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class SlikeService {

  @Value("${roba.slika.tdPrefix}")
  String tdPrefix;

  private static final String[] allowed_extension = {".jpg", ".jpeg", ".png", ".webp"};

  private static final String SLIKA_NIJE_DOSTUPNA_URL = "images/no-image/no-image.png";

  public SlikaDto fetchImageFromFileSystem(String slikaBaseName) {
    SlikaDto slikaDto = new SlikaDto();

    for (String ext : allowed_extension) {
      Path path = Paths.get(tdPrefix, slikaBaseName + ext);
      if (Files.exists(path)) {
        try {
          byte[] bytes = Files.readAllBytes(path);
          slikaDto.setSlikeByte(bytes);
          slikaDto.setUrl(false);
          return slikaDto;
        } catch (IOException e) {
          break; // fall through to default below
        }
      }
    }

    // If not found, return fallback image
    slikaDto.setSlikeUrl(SLIKA_NIJE_DOSTUPNA_URL);
    slikaDto.setUrl(true);
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

  public String saveImage(Long robaId, MultipartFile file) {
    String extension =
        Optional.ofNullable(file.getOriginalFilename())
            .filter(f -> f.contains("."))
            .map(f -> f.substring(f.lastIndexOf(".")))
            .orElse(".jpg");

    String fileName = robaId + extension;
    Path savePath = Paths.get(tdPrefix, fileName);

    // 1. Clean old files with known extensions
    for (String ext : allowed_extension) {
      Path existing = Paths.get(tdPrefix, robaId + ext);
      try {
        Files.deleteIfExists(existing);
      } catch (IOException e) {
        // Optionally log but do not fail

        log.error("Failed to delete existing image: " + existing);
      }
    }

    // 2. Save new image
    try {
      Files.write(savePath, file.getBytes());
    } catch (IOException e) {
      throw new RuntimeException("Failed to save image: " + fileName, e);
    }

    return fileName;
  }

  public void deleteImage(Long robaId) {
    for (String ext : allowed_extension) {
      Path filePath = Paths.get(tdPrefix, robaId + ext);
      try {
        if (Files.deleteIfExists(filePath)) {
          log.info("Deleted image: {}", filePath);
        }
      } catch (IOException e) {
        log.warn("Failed to delete image: {}", filePath, e);
      }
    }
  }
}
