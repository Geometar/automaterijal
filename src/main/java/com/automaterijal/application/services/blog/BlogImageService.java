package com.automaterijal.application.services.blog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class BlogImageService {

  static final long MAX_BYTES = 2L * 1024 * 1024;
  private static final Set<String> ALLOWED_CONTENT_TYPES =
      Set.of("image/jpeg", "image/png");

  final Path storageDirectory;

  public BlogImageService(@Value("${blog.cover-image.directory:../uploads/blog}") String directory) {
    this.storageDirectory = Paths.get(directory).toAbsolutePath().normalize();
  }

  public StoredImage saveCoverImage(
      String identifier,
      String base64Payload,
      String declaredContentType,
      String previousRelativePath) {

    if (!StringUtils.hasText(base64Payload)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cover image payload is empty");
    }

    String sanitizedBase64 = stripWhitespace(base64Payload);
    byte[] bytes = decodeBase64(sanitizedBase64);

    if (bytes.length > MAX_BYTES) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cover image exceeds 2MB limit");
    }

    String contentType = resolveContentType(bytes, declaredContentType);
    String extension = extensionFor(contentType);

    ensureDirectoryExists();

    if (StringUtils.hasText(previousRelativePath)) {
      deleteCoverImage(previousRelativePath);
    }

    String fileName = identifier + "-" + System.currentTimeMillis() + extension;
    Path target = resolvePath(fileName);

    try {
      Files.write(target, bytes);
    } catch (IOException ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save cover image", ex);
    }

    return new StoredImage(fileName, sanitizedBase64, contentType);
  }

  public void deleteCoverImage(String relativePath) {
    if (!StringUtils.hasText(relativePath)) {
      return;
    }
    Path path;
    try {
      path = resolvePath(relativePath);
    } catch (ResponseStatusException ex) {
      log.debug("Skipping deletion for unmanaged cover image path: {}", relativePath);
      return;
    }
    try {
      Files.deleteIfExists(path);
    } catch (IOException ex) {
      log.warn("Failed to delete cover image {}", path, ex);
    }
  }

  public Optional<ImagePayload> loadCoverImage(String relativePath) {
    if (!StringUtils.hasText(relativePath)) {
      return Optional.empty();
    }
    Path path;
    try {
      path = resolvePath(relativePath);
    } catch (ResponseStatusException ex) {
      log.debug("Skipping load for unmanaged cover image path: {}", relativePath);
      return Optional.empty();
    }
    if (!Files.exists(path)) {
      return Optional.empty();
    }
    try {
      byte[] bytes = Files.readAllBytes(path);
      String base64 = Base64.getEncoder().encodeToString(bytes);
      String contentType = Files.probeContentType(path);
      if (!StringUtils.hasText(contentType)) {
        contentType = detectContentType(bytes).orElse(null);
      }
      return Optional.of(new ImagePayload(base64, contentType));
    } catch (IOException ex) {
      log.warn("Failed to read cover image {}", path, ex);
      return Optional.empty();
    }
  }

  private void ensureDirectoryExists() {
    try {
      Files.createDirectories(storageDirectory);
    } catch (IOException ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot prepare image storage", ex);
    }
  }

  private Path resolvePath(String relativePath) {
    Path resolved = storageDirectory.resolve(relativePath).normalize();
    if (!resolved.startsWith(storageDirectory)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid image path");
    }
    return resolved;
  }

  private static byte[] decodeBase64(String base64) {
    try {
      return Base64.getDecoder().decode(base64);
    } catch (IllegalArgumentException ex) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cover image payload is invalid", ex);
    }
  }

  private static String stripWhitespace(String value) {
    StringBuilder builder = new StringBuilder(value.length());
    for (int i = 0; i < value.length(); i++) {
      char c = value.charAt(i);
      if (!Character.isWhitespace(c)) {
        builder.append(c);
      }
    }
    return builder.toString();
  }

  private String resolveContentType(byte[] bytes, String declaredContentType) {
    String normalizedDeclared = normalizeContentType(declaredContentType);
    if (normalizedDeclared != null) {
      ensureAllowed(normalizedDeclared);
      return normalizedDeclared;
    }
    return detectContentType(bytes)
        .filter(ct -> {
          try {
            ensureAllowed(ct);
            return true;
          } catch (ResponseStatusException ex) {
            return false;
          }
        })
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported image type"));
  }

  private static String normalizeContentType(String contentType) {
    if (!StringUtils.hasText(contentType)) {
      return null;
    }
    return contentType.trim().toLowerCase();
  }

  private static Optional<String> detectContentType(byte[] bytes) {
    Objects.requireNonNull(bytes, "bytes");
    if (bytes.length >= 3 && bytes[0] == (byte) 0xFF && bytes[1] == (byte) 0xD8 && bytes[2] == (byte) 0xFF) {
      return Optional.of("image/jpeg");
    }
    if (bytes.length >= 8
        && bytes[0] == (byte) 0x89
        && bytes[1] == (byte) 0x50
        && bytes[2] == (byte) 0x4E
        && bytes[3] == (byte) 0x47
        && bytes[4] == (byte) 0x0D
        && bytes[5] == (byte) 0x0A
        && bytes[6] == (byte) 0x1A
        && bytes[7] == (byte) 0x0A) {
      return Optional.of("image/png");
    }
    return Optional.empty();
  }

  private void ensureAllowed(String contentType) {
    if (!ALLOWED_CONTENT_TYPES.contains(contentType)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported image type");
    }
  }

  private static String extensionFor(String contentType) {
    return switch (contentType) {
      case "image/png" -> ".png";
      case "image/jpeg" -> ".jpg";
      default -> throw new IllegalArgumentException("Unsupported content type: " + contentType);
    };
  }

  public record StoredImage(String relativePath, String base64, String contentType) {}

  public record ImagePayload(String base64, String contentType) {}
}
