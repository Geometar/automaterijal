package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.tecdoc.ArticleDirectSearchById3Record;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecord;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecordSeq;
import java.awt.Color;
import java.awt.Graphics2D;
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
          tecDocAttributeService.cacheThumbnailAttribute(robaLightDto, thumbnail, directArticle);
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
    File jpgFile = new File(putDoSlike + robaId + ".jpg");
    try {
      boolean saved = ImageIO.write(image, "jpg", jpgFile);
      if (!saved) {
        BufferedImage rgbImage = convertToRgb(image);
        saved = ImageIO.write(rgbImage, "jpg", jpgFile);
      }

      if (!saved) {
        File pngFile = new File(putDoSlike + robaId + ".png");
        boolean fallbackSaved = ImageIO.write(image, "png", pngFile);
        if (fallbackSaved) {
          log.warn("TecDoc slika za robu {} sačuvana kao PNG zbog alfa kanala", robaId);
        } else {
          log.error("Nije moguće snimiti TecDoc sliku za robu {} ni kao JPG ni kao PNG", robaId);
        }
      }
    } catch (IOException e) {
      log.error("Greška pri snimanju slike na disk", e);
    }
  }

  private BufferedImage convertToRgb(BufferedImage source) {
    BufferedImage converted =
        new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = converted.createGraphics();
    try {
      graphics.setColor(Color.WHITE);
      graphics.fillRect(0, 0, source.getWidth(), source.getHeight());
      graphics.drawImage(source, 0, 0, null);
    } finally {
      graphics.dispose();
    }
    return converted;
  }
}
