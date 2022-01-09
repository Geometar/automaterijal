package com.automaterijal.application.services;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticlesByIds6Record;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocService {

    @Autowired
    TecDocClient tecDocClient;

    @Autowired
    TecDocAtributiRepository tecDocAtributiRepository;

    @Autowired
    TecDocBrandsRepository tecDocBrandsRepository;

    //    ******************** TecDoc Pretraga  ********************

    public List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocPretragaPoTrazenojReci(String trazenaRec, Integer brandId, Integer numbertype) {
        return tecDocClient.tecDocPretraga(trazenaRec, brandId, numbertype);
    }

    public List<ArticlesByIds6Record> vratiDetaljeArtikla(Long articleId) {
        return tecDocClient.vratiDetaljeArtikla(articleId);
    }

    public byte[] vratiDokument(String dokumentId, Integer tipSlike) {
        return tecDocClient.vratiDokument(dokumentId, tipSlike);
    }


    //    ******************** TecDoc Atributi  ********************

    public List<TecDocAtributi> vratiTecDocAtributePrekoRobeId(Long robaId) {
        return tecDocAtributiRepository.findByRobaId(robaId);
    }

    public void sacuvajTecDocAtribute(TecDocAtributi atributi) {
        tecDocAtributiRepository.save(atributi);
    }

    //    ******************** TecDoc Brendovi  ********************

    public Optional<TecDocBrands> vratiTecDocBrendovePrekoProId(String proId) {
        return tecDocBrandsRepository.findById(proId);
    }
}
