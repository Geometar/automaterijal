package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.ImageRecord;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ImageService {

  @Value("${roba.slika.tdPrefix}")
  String tdPrefix;

  @Value("${roba.slika.publicPrefix:/images/roba/}")
  String publicPrefix;

  @Value("${roba.slika.noImageUrl:/images/no-image/no-image.png}")
  String noImageUrl;

  @Value("${site.base-url:https://automaterijal.com}")
  String siteBaseUrl;

  private static final String[] allowed_extension = {".jpg", ".jpeg", ".png", ".webp"};

  @Cacheable(
      value = "imageCache",
      key = "#root.target.normalizeCacheKey(#slikaBaseName)",
      unless = "#result == null || #root.target.isFallbackImage(#result.getSlikeUrl())")
  public SlikaDto fetchImageFromFileSystem(String slikaBaseName) {
    SlikaDto slikaDto = new SlikaDto();

    if (!StringUtils.hasText(slikaBaseName)) {
      slikaDto.setSlikeUrl(resolveNoImageUrl());
      slikaDto.setUrl(true);
      return slikaDto;
    }

    int dotIndex = slikaBaseName.lastIndexOf('.');
    String baseName = (dotIndex != -1) ? slikaBaseName.substring(0, dotIndex) : slikaBaseName;

    for (String ext : allowed_extension) {
      Path path = Paths.get(tdPrefix, baseName + ext);
      if (Files.exists(path)) {
        slikaDto.setUrl(true);
        String fileName = baseName + ext;
        slikaDto.setSlikeUrl(buildPublicPath(fileName));
        slikaDto.setRobaSlika(fileName);
        return slikaDto;
      }
    }

    slikaDto.setSlikeUrl(resolveNoImageUrl());
    slikaDto.setUrl(true);
    return slikaDto;
  }

  public String normalizeCacheKey(String slikaBaseName) {
    if (slikaBaseName == null) {
      return "no-image";
    }
    String trimmed = slikaBaseName.trim();
    int dotIndex = trimmed.lastIndexOf('.');
    String baseName = dotIndex != -1 ? trimmed.substring(0, dotIndex) : trimmed;
    return baseName.toLowerCase();
  }

  private String buildPublicPath(String fileName) {
    String sanitizedFileName = fileName.startsWith("/") ? fileName.substring(1) : fileName;
    String prefix = normalizedPublicPrefix();
    if (!prefix.endsWith("/")) {
      prefix = prefix + "/";
    }
    return prefix + sanitizedFileName;
  }

  private String normalizedPublicPrefix() {
    String absolute = toAbsoluteUrl(publicPrefix);
    if (StringUtils.hasText(absolute)) {
      return trimTrailingSlash(absolute);
    }
    String base = StringUtils.hasText(siteBaseUrl) ? siteBaseUrl.trim() : "";
    return trimTrailingSlash(base);
  }

  private String trimTrailingSlash(String value) {
    if (!StringUtils.hasText(value)) {
      return value;
    }
    int end = value.length();
    while (end > 0 && value.charAt(end - 1) == '/') {
      end--;
    }
    return value.substring(0, end);
  }

  private String resolveNoImageUrl() {
    return toAbsoluteUrl(noImageUrl);
  }

  private String toAbsoluteUrl(String value) {
    if (!StringUtils.hasText(value)) {
      return value;
    }
    String trimmed = value.trim();
    if (trimmed.startsWith("http://") || trimmed.startsWith("https://")) {
      return trimmed;
    }
    String base = StringUtils.hasText(siteBaseUrl) ? trimTrailingSlash(siteBaseUrl.trim()) : "";
    String path = trimmed.startsWith("/") ? trimmed : "/" + trimmed;
    if (StringUtils.hasText(base)) {
      return base + path;
    }
    return path;
  }

  public boolean isFallbackImage(String url) {
    if (!StringUtils.hasText(url)) {
      return false;
    }
    String normalizedUrl = url.trim();
    String fallback = resolveNoImageUrl();
    if (StringUtils.hasText(fallback) && fallback.equalsIgnoreCase(normalizedUrl)) {
      return true;
    }
    return normalizedUrl.toLowerCase().contains("no-image");
  }

  public String getFallbackImageUrl() {
    return resolveNoImageUrl();
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
      slikaDto.setSlikeUrl(resolveNoImageUrl());
    }
    return slikaDto;
  }

  public String getImageForBrandLogo(TecDocBrands tecDocBrands) {
    byte[] logoBytes = tecDocBrands.getBrand();
    if (logoBytes == null || logoBytes.length == 0) return null;

    if (looksLikeUtf8OfJpeg(logoBytes)) {
      String utf8 = new String(logoBytes, StandardCharsets.UTF_8);
      logoBytes = utf8.getBytes(StandardCharsets.ISO_8859_1);
    }

    String mimeType = detectMimeByMagic(logoBytes);
    if (mimeType == null) {
      try (ByteArrayInputStream bais = new ByteArrayInputStream(logoBytes)) {
        mimeType = URLConnection.guessContentTypeFromStream(bais);
      } catch (IOException ignore) {
        // ByteArrayInputStream praktično ne baca IOException
      }
    }
    if (mimeType == null) mimeType = "image/jpeg";

    String base64 = Base64.getEncoder().encodeToString(logoBytes);
    return "data:" + mimeType + ";base64," + base64;
  }

  private static boolean looksLikeUtf8OfJpeg(byte[] b) {
    return b.length >= 4
        && b[0] == (byte) 0xC3
        && b[1] == (byte) 0xBF
        && b[2] == (byte) 0xC3
        && b[3] == (byte) 0x98;
  }

  private static String detectMimeByMagic(byte[] b) {
    if (b.length >= 3 && b[0] == (byte) 0xFF && b[1] == (byte) 0xD8 && b[2] == (byte) 0xFF)
      return "image/jpeg";
    if (b.length >= 8
        && b[0] == (byte) 0x89
        && b[1] == (byte) 0x50
        && b[2] == (byte) 0x4E
        && b[3] == (byte) 0x47
        && b[4] == (byte) 0x0D
        && b[5] == (byte) 0x0A
        && b[6] == (byte) 0x1A
        && b[7] == (byte) 0x0A) return "image/png";
    if (b.length >= 6
        && b[0] == (byte) 0x47
        && b[1] == (byte) 0x49
        && b[2] == (byte) 0x46
        && b[3] == (byte) 0x38
        && (b[4] == (byte) 0x39 || b[4] == (byte) 0x37)
        && b[5] == (byte) 0x61) return "image/gif";
    if (b.length >= 12
        && b[0] == (byte) 0x52
        && b[1] == (byte) 0x49
        && b[2] == (byte) 0x46
        && b[3] == (byte) 0x46
        && // "RIFF"
        b[8] == (byte) 0x57
        && b[9] == (byte) 0x45
        && b[10] == (byte) 0x42
        && b[11] == (byte) 0x50) return "image/webp";

    String head = new String(b, 0, Math.min(b.length, 64), StandardCharsets.UTF_8).trim();
    if (head.startsWith("<?xml") || head.startsWith("<svg")) return "image/svg+xml";
    return null;
  }

  @CacheEvict(
      value = "imageCache",
      key = "#root.target.normalizeCacheKey(#robaId != null ? #robaId.toString() : null)")
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

  @CacheEvict(
      value = "imageCache",
      key = "#root.target.normalizeCacheKey(#robaId != null ? #robaId.toString() : null)")
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
