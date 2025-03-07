package com.automaterijal.application.services.onstartup;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import com.automaterijal.application.tecdoc.AmBrandsRecord;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
@Slf4j
public class OnStartUpService {

  @Autowired TecDocClient tecDocClient;

  @Autowired TecDocBrandsRepository tecDocBrandsRepository;

  @Autowired TecDocAtributiRepository tecDocAtributiRepository;

  @Value("${roba.slika.tdPrefix}")
  String putDoSlike;

  public void loadTecDocAmBrands() {
    List<AmBrandsRecord> records = tecDocClient.vrateTecDocAmBrands();
    records.forEach(
        amBrandsRecord -> {
          var tecDocProizvodjaci = TecDocProizvodjaci.pronadjiPoKljucu(amBrandsRecord.getBrandId());
          if (tecDocProizvodjaci != null) {
            TecDocBrands brands = new TecDocBrands();
            brands.setBrandId(amBrandsRecord.getBrandId());
            brands.setBrandLogoID(amBrandsRecord.getBrandLogoID());
            brands.setProid(tecDocProizvodjaci.getCleanName());
            if (StringUtils.hasText(amBrandsRecord.getBrandLogoID())) {
              brands.setBrand(tecDocClient.vratiDokument(amBrandsRecord.getBrandLogoID(), 0));
            }
            tecDocBrandsRepository.saveAndFlush(brands);
          }
        });
  }

  public void izvadiSlikeIzAtributaIStoruj() {
    tecDocAtributiRepository.findAll().stream()
        .filter(atributi -> atributi.getDokument() != null)
        .forEach(
            atributi -> {
              ByteArrayInputStream bis = new ByteArrayInputStream(atributi.getDokument());
              BufferedImage bImage2;
              try {
                bImage2 = ImageIO.read(bis);
                ImageIO.write(bImage2, "jpg", new File(putDoSlike + atributi.getRobaId() + ".jpg"));
              } catch (IOException e) {
                log.error("Pukao bajka cuvanje slike iz nekog nepoznatog razloga.");
              }
            });
  }
}
