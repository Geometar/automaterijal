package com.automaterijal.application.services.onstartup;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import com.automaterijal.application.tecdoc.AmBrandsRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
@Slf4j
public class OnStartUpService {

    @Autowired
    TecDocClient tecDocClient;

    @Autowired
    TecDocBrandsRepository tecDocBrandsRepository;

    @Autowired
    TecDocAtributiRepository tecDocAtributiRepository;

    @Value("${roba.slika.tdPrefix}")
    String putDoSlike;

    public void loadTecDocAmBrands() {
        List<AmBrandsRecord> records = tecDocClient.vrateTecDocAmBrands();
        records.forEach(record -> {
            var initializeEnum = TecDocProizvodjaci.ATE;
            var tecDocProizvodjaci = TecDocProizvodjaci.pronadjiPoKljucu(record.getBrandId().intValue());
            if (tecDocProizvodjaci != null) {
                TecDocBrands brands = new TecDocBrands();
                brands.setBrandId(record.getBrandId());
                brands.setBrandLogoID(record.getBrandLogoID());
                brands.setProid(tecDocProizvodjaci.name());
                brands.setBrand(tecDocClient.vratiDokument(record.getBrandLogoID(), 0));
                tecDocBrandsRepository.saveAndFlush(brands);
            }
        });
    }

    public void izvadiSlikeIzAtributaIStoruj() {
        tecDocAtributiRepository.findAll().stream().filter(atributi -> atributi.getDokument() != null).forEach(atributi -> {
            ByteArrayInputStream bis = new ByteArrayInputStream(atributi.getDokument());
            BufferedImage bImage2 = null;
            try {
                bImage2 = ImageIO.read(bis);
                ImageIO.write(bImage2, "jpg", new File(putDoSlike + atributi.getRobaId() + ".jpg"));
            } catch (IOException e) {
                log.error("Pukao bajka cuvanje slike iz nekog nepoznatog razloga.");
            }
        });
    }

}
