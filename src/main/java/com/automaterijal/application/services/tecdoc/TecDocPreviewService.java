package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.services.ImageService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.tecdoc.ArticleDocuments2Record;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.ArticlesByIds6Record;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecord;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Centralizuje "preview" (slika + tehnicki opis) koji koristimo u search flow-u i u TecDoc vehicle
 * flow-u, tako da FE uvek dobije isti shape u {@code RobaLightDto} (bilo da postoji {@code robaId}
 * ili je external-only).
 *
 * <p>Napomena: za external-only artikle ne čuvamo TecDoc atribute u bazi (nema {@code robaId}),
 * nego ih vraćamo "on the fly" iz TecDoc-a.
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TecDocPreviewService {

  @NonNull TecDocService tecDocService;
  @NonNull ImageService imageService;

  public record TecDocPreview(SlikaDto slika, List<RobaTehnickiOpisDto> tehnickiOpis) {}

  public TecDocPreview fromArticleRecord(ArticleRecord article) {
    if (article == null) {
      return null;
    }
    SlikaDto slika = imageService.getImageFromTD(article);
    List<RobaTehnickiOpisDto> tech =
        article.getArticleCriteria() != null
            ? RobaTehnickiOpisDto.fromArticleCriteria(article.getArticleCriteria())
            : List.of();
    return new TecDocPreview(slika, normalizeTechList(tech));
  }

  public Map<Long, TecDocPreview> previewsByArticleId(List<Long> articleIds) {
    if (articleIds == null || articleIds.isEmpty()) {
      return Map.of();
    }

    List<Long> ids = articleIds.stream().filter(Objects::nonNull).distinct().toList();
    if (ids.isEmpty()) {
      return Map.of();
    }

    List<ArticlesByIds6Record> details = tecDocService.vratiDetaljeArtiklaBatch(ids);
    if (details == null || details.isEmpty()) {
      return Map.of();
    }

    Map<Long, TecDocPreview> previews = new HashMap<>();
    for (ArticlesByIds6Record record : details) {
      if (record == null) {
        continue;
      }

      Long articleId = extractArticleId(record);
      if (articleId == null) {
        continue;
      }

      TecDocPreview preview = fromDetailsRecord(record);
      if (preview != null) {
        previews.putIfAbsent(articleId, preview);
      }
    }

    return previews;
  }

  public TecDocPreview fromDetailsRecord(ArticlesByIds6Record record) {
    if (record == null) {
      return null;
    }

    SlikaDto slika = resolvePreviewImage(record);
    List<RobaTehnickiOpisDto> tech = extractPreviewTechnical(record);
    return new TecDocPreview(slika, tech);
  }

  private Long extractArticleId(ArticlesByIds6Record record) {
    if (record == null) {
      return null;
    }
    if (record.getDirectArticle() != null && record.getDirectArticle().getArticleId() != null) {
      return record.getDirectArticle().getArticleId();
    }
    if (record.getAssignedArticle() != null && record.getAssignedArticle().getArticleId() != null) {
      return record.getAssignedArticle().getArticleId();
    }
    return null;
  }

  private SlikaDto resolvePreviewImage(ArticlesByIds6Record record) {
    String url = null;

    if (record != null && record.getArticleThumbnails() != null) {
      List<ThumbnailByArticleIdRecord> thumbs = record.getArticleThumbnails().getArray();
      if (thumbs != null) {
        for (ThumbnailByArticleIdRecord thumb : thumbs) {
          if (thumb == null) {
            continue;
          }
          if (StringUtils.hasText(thumb.getThumbDocId())) {
            url = buildDocumentUrl(thumb.getThumbDocId().trim(), 0);
            break;
          }
          if (StringUtils.hasText(thumb.getThumbFileName())) {
            String candidate = thumb.getThumbFileName().trim();
            if (isLikelyImage(candidate, candidate, "image")) {
              url = candidate;
              break;
            }
          }
        }
      }
    }

    if (!StringUtils.hasText(url) && record != null && record.getArticleDocuments() != null) {
      List<ArticleDocuments2Record> docs = record.getArticleDocuments().getArray();
      if (docs != null) {
        for (ArticleDocuments2Record doc : docs) {
          if (doc == null) {
            continue;
          }
          String candidateId = StringUtils.hasText(doc.getDocId()) ? doc.getDocId().trim() : null;
          if (!StringUtils.hasText(candidateId)) {
            continue;
          }
          String candidateUrl = StringUtils.hasText(doc.getDocUrl()) ? doc.getDocUrl().trim() : null;
          String candidateFileName =
              StringUtils.hasText(doc.getDocFileName()) ? doc.getDocFileName().trim() : null;
          String candidateTypeName =
              StringUtils.hasText(doc.getDocFileTypeName()) ? doc.getDocFileTypeName().trim() : null;

          if (isLikelyImage(candidateUrl, candidateFileName, candidateTypeName)) {
            url = buildDocumentUrl(candidateId, 0);
            break;
          }
        }
      }
    }

    SlikaDto slika = new SlikaDto();
    slika.setUrl(true);
    slika.setSlikeUrl(StringUtils.hasText(url) ? url : imageService.getFallbackImageUrl());
    return slika;
  }

  private String buildDocumentUrl(String docId, int tipSlike) {
    return "/api/tecdoc/dokument/" + docId + "?tipSlike=" + tipSlike;
  }

  private boolean isLikelyImage(String url, String fileName, String fileTypeName) {
    if (StringUtils.hasText(url)) {
      String lower = url.trim().toLowerCase(Locale.ROOT);
      if (lower.contains("youtube.com") || lower.contains("youtu.be")) {
        return false;
      }
      if (lower.startsWith("http")
          && (lower.contains(".png")
              || lower.contains(".jpg")
              || lower.contains(".jpeg")
              || lower.contains(".webp"))) {
        return true;
      }
    }

    if (StringUtils.hasText(fileName)) {
      String lower = fileName.trim().toLowerCase(Locale.ROOT);
      if (lower.endsWith(".png")
          || lower.endsWith(".jpg")
          || lower.endsWith(".jpeg")
          || lower.endsWith(".webp")) {
        return true;
      }
    }

    if (StringUtils.hasText(fileTypeName)) {
      String lower = fileTypeName.trim().toLowerCase(Locale.ROOT);
      return lower.contains("image")
          || lower.contains("jpeg")
          || lower.contains("jpg")
          || lower.contains("png");
    }

    return false;
  }

  private List<RobaTehnickiOpisDto> extractPreviewTechnical(ArticlesByIds6Record record) {
    List<RobaTehnickiOpisDto> tech = new ArrayList<>();

    if (record != null && record.getImmediateAttributs() != null) {
      record.getImmediateAttributs().getArray().stream()
          .filter(Objects::nonNull)
          .forEach(
              attr -> {
                RobaTehnickiOpisDto dto = new RobaTehnickiOpisDto();
                dto.setType(attr.getAttrType());
                dto.setOznaka(
                    StringUtils.hasText(attr.getAttrShortName())
                        ? attr.getAttrShortName()
                        : attr.getAttrName());
                dto.setJedinica(attr.getAttrUnit());
                dto.setVrednost(attr.getAttrValue());
                tech.add(dto);
              });
    }

    if (record != null && record.getArticleAttributes() != null) {
      record.getArticleAttributes().getArray().stream()
          .filter(Objects::nonNull)
          .forEach(
              attr -> {
                RobaTehnickiOpisDto dto = new RobaTehnickiOpisDto();
                dto.setType(attr.getAttrType());
                dto.setOznaka(
                    StringUtils.hasText(attr.getAttrShortName())
                        ? attr.getAttrShortName()
                        : attr.getAttrName());
                dto.setJedinica(attr.getAttrUnit());
                dto.setVrednost(attr.getAttrValue());
                tech.add(dto);
              });
    }

    if (record != null && record.getImmediateInfo() != null) {
      record.getImmediateInfo().getArray().stream()
          .filter(Objects::nonNull)
          .forEach(
              info -> {
                if (!StringUtils.hasText(info.getInfoText())) {
                  return;
                }
                RobaTehnickiOpisDto dto = new RobaTehnickiOpisDto();
                dto.setType("INFO");
                dto.setOznaka(
                    StringUtils.hasText(info.getInfoTypeName()) ? info.getInfoTypeName() : "INFO");
                dto.setVrednost(info.getInfoText());
                tech.add(dto);
              });
    }

    return normalizeTechList(tech);
  }

  private List<RobaTehnickiOpisDto> normalizeTechList(List<RobaTehnickiOpisDto> tech) {
    if (tech == null || tech.isEmpty()) {
      return List.of();
    }

    return tech.stream()
        .filter(Objects::nonNull)
        .filter(
            t ->
                StringUtils.hasText(t.getOznaka())
                    || StringUtils.hasText(t.getVrednost())
                    || StringUtils.hasText(t.getJedinica()))
        .distinct()
        .sorted(
            Comparator.comparing(
                    RobaTehnickiOpisDto::getType, Comparator.nullsFirst(Comparator.naturalOrder()))
                .thenComparing(
                    RobaTehnickiOpisDto::getOznaka,
                    Comparator.nullsFirst(Comparator.naturalOrder())))
        .toList();
  }
}
