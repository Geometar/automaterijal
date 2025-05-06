package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.tecdoc.ArticleDirectSearchById3Record;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecord;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecordSeq;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocImageService {

  @NonNull TecDocAttributeService tecDocAttributeService;

  @Value("${roba.slika.tdPrefix}")
  private String putDoSlike;

  public void saveImage(
      ThumbnailByArticleIdRecordSeq thumbnails,
      RobaLightDto robaLightDto,
      ArticleDirectSearchById3Record directArticle,
      byte[] dokumentSlike) {

    if (thumbnails != null && thumbnails.getArray() != null && !thumbnails.getArray().isEmpty()) {
      ThumbnailByArticleIdRecord thumbnail = thumbnails.getArray().get(0);
      if (thumbnail.getThumbDocId() != null) {
        BufferedImage bImage = procitajSliku(dokumentSlike);
        if (bImage != null) {
          snimiNaDisk(bImage, robaLightDto.getRobaid());
          tecDocAttributeService.cacheThumbnailAttribute(
              robaLightDto, thumbnail, dokumentSlike, directArticle);
        }
      }
    }
  }

  private BufferedImage procitajSliku(byte[] dokumentSlike) {
    try (ByteArrayInputStream bis = new ByteArrayInputStream(dokumentSlike)) {
      return ImageIO.read(bis);
    } catch (IOException e) {
      log.error("Greška pri čitanju slike iz bajtova", e);
      return null;
    }
  }

  private void snimiNaDisk(BufferedImage image, Long robaId) {
    try {
      ImageIO.write(image, "jpg", new File(putDoSlike + robaId + ".jpg"));
    } catch (IOException e) {
      log.error("Greška pri snimanju slike na disk", e);
    }
  }
}
