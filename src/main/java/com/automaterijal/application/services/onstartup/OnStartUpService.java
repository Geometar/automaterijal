package com.automaterijal.application.services.onstartup;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import com.automaterijal.application.tecdoc.AmBrandsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OnStartUpService {

    @Autowired
    TecDocClient tecDocClient;

    @Autowired
    TecDocBrandsRepository tecDocBrandsRepository;

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

}
