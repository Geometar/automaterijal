package com.automaterijal.application.services;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleDirectSearchById3Record;
import com.automaterijal.application.tecdoc.ArticlesByIds6Record;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocService {

    @Autowired
    TecDocClient tecDocClient;

    @Autowired
    TecDocAtributiRepository tecDocAtributiRepository;

    @Autowired
    TecDocBrandsRepository tecDocBrandsRepository;

    @Autowired
    TecDocMapper tecDocMapper;

    //    ******************** TecDoc Pretraga  ********************

    public List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocPretragaPoTrazenojReci(String trazenaRec, Integer brandId, Integer numbertype) {
        return tecDocClient.tecDocPretraga(trazenaRec, brandId, numbertype);
    }

    public List<ArticlesByIds6Record> vratiDetaljeArtikla(Long articleId) {
        return tecDocClient.vratiDetaljeArtikla(Arrays.asList(articleId));
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

    //    ******************** TecDoc Logika  ********************
    public void batchVracanjeICuvanjeTDAtributa(List<RobaDto> robaDtos) {

        List<Long> artikliBezSacuvanihPodataka = new ArrayList<>();
        Map<String, String> zameneKatBr = new HashMap<>();
        robaDtos.forEach(robaDto -> {
            TecDocProizvodjaci tdProizvodjaci = TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid());
            String katBr = tdProizvodjaci.getDodatak() != null ? robaDto.getKatbr().replaceAll(tdProizvodjaci.getDodatak(), "") : robaDto.getKatbr();
            if (tdProizvodjaci != null) {
                List<TecDocAtributi> tecDocAtributi = tecDocAtributiRepository.findByRobaId(robaDto.getRobaid());
                if (tecDocAtributi.isEmpty()) {
                    List<ArticleDirectSearchAllNumbersWithStateRecord> directSearch = tecDocClient.tecDocPretraga(katBr, tdProizvodjaci.getTecDocId(), 0);
                    if (directSearch.isEmpty()) {
                        directSearch = tecDocClient.tecDocPretraga(katBr, tdProizvodjaci.getTecDocId(), 2);
                    }
                    if (!directSearch.isEmpty()) {
                        Long tdArticleId = directSearch.stream()
                                .filter(rekord -> rekord.getArticleNo().equals(katBr))
                                .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
                                .findFirst().orElse(null);

                        if (tdArticleId == null) {
                            tdArticleId = directSearch.stream()
                                    .filter(rekord -> rekord.getArticleSearchNo().replaceAll("\\s+", "").equals(katBr))
                                    .filter(rekord -> rekord.getBrandNo().intValue() == tdProizvodjaci.getTecDocId())
                                    .peek(rekord -> zameneKatBr.put(katBr, rekord.getArticleNo()))
                                    .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
                                    .findFirst().orElse(null);
                        }
                        if (tdArticleId != null) {
                            artikliBezSacuvanihPodataka.add(tdArticleId);
                        }
                    } else {
                        // Setuj prazar rekord, nema u tecdocu nema potrebe da se pretrazuje ponovo
                        TecDocAtributi atributi = new TecDocAtributi();
                        atributi.setRobaId(robaDto.getRobaid());
                        atributi.setKatbr(robaDto.getKatbr());
                        sacuvajTecDocAtribute(atributi);
                        log.info("Artikal katBr {} - proizvodjac {} ne postoji u TD", robaDto.getKatbr(), robaDto.getProizvodjac().getProid());
                    }
                }
            }
        });

        if (!artikliBezSacuvanihPodataka.isEmpty()) {
            for (int i = 0; i < artikliBezSacuvanihPodataka.size(); i = i + 24) {
                List<Long> artiklId;
                if (i + 24 > artikliBezSacuvanihPodataka.size()) {
                    artiklId = artikliBezSacuvanihPodataka.subList(i, artikliBezSacuvanihPodataka.size());
                } else {
                    artiklId = artikliBezSacuvanihPodataka.subList(i, i + 24);
                }
                List<ArticlesByIds6Record> detaljiArtikala = tecDocClient.vratiDetaljeArtikla(artiklId);

                detaljiArtikala.forEach(detalji -> {
                    if (detalji.getDirectArticle() != null) {
                        ArticleDirectSearchById3Record directArticle = detalji.getDirectArticle();
                        Optional<RobaDto> dtoOptional = robaDtos.stream()
                                .filter(robaDto -> {
                                    TecDocProizvodjaci tdProizvodjaci = TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid());
                                    String katBr = tdProizvodjaci.getDodatak() != null ? robaDto.getKatbr().replaceAll(tdProizvodjaci.getDodatak(), "") : robaDto.getKatbr();
                                    return katBr.equals(directArticle.getArticleNo().replaceAll("\\s+", ""));
                                })
                                .findFirst();

                        if (!dtoOptional.isPresent()) {
                            dtoOptional = robaDtos.stream()
                                    .filter(robaDto -> {
                                        String alternativniKataloskoBroj = zameneKatBr.get(robaDto.getKatbr());
                                        return alternativniKataloskoBroj != null && alternativniKataloskoBroj.equals(directArticle.getArticleNo().replaceAll("\\s+", ""));
                                    })
                                    .findFirst();
                        }
                        if (dtoOptional.isPresent()) {
                            RobaDto robaDto = dtoOptional.get();
                            TecDocProizvodjaci tecDocProizvodjaci = TecDocProizvodjaci.pronadjiPoNazivu(robaDto.getProizvodjac().getProid());
                            if (detalji.getArticleAttributes() != null && detalji.getArticleAttributes().getArray() != null) {
                                detalji.getArticleAttributes().getArray().forEach(att -> {
                                    TecDocAtributi atributi = tecDocMapper.map(
                                            att,
                                            robaDto,
                                            directArticle.getArticleId(),
                                            tecDocProizvodjaci.getTecDocId()
                                    );
                                    sacuvajTecDocAtribute(atributi);
                                });
                            }

                            if (detalji.getArticleThumbnails() != null && detalji.getArticleThumbnails().getArray() != null) {
                                List<ThumbnailByArticleIdRecord> thumbnailByArticle = detalji.getArticleThumbnails().getArray();
                                if (thumbnailByArticle != null && thumbnailByArticle.size() > 0) {
                                    ThumbnailByArticleIdRecord thumbnail = thumbnailByArticle.get(0);
                                    if (thumbnail.getThumbDocId() != null) {
                                        byte[] dokumentSlike = vratiDokument(thumbnail.getThumbDocId(), 0);
                                        robaDto.setDokumentSlikaId(thumbnail.getThumbDocId());
                                        robaDto.setDokument(dokumentSlike);

                                        // Kesiranje slike u bazi
                                        TecDocAtributi atributi = tecDocMapper.map(
                                                thumbnail,
                                                robaDto,
                                                directArticle.getArticleId(),
                                                tecDocProizvodjaci.getTecDocId());
                                        atributi.setDokument(dokumentSlike);
                                        sacuvajTecDocAtribute(atributi);

                                        SlikaDto slikaDto = new SlikaDto();
                                        slikaDto.setSlikeByte(dokumentSlike);
                                        slikaDto.setUrl(false);
                                        robaDto.setSlika(slikaDto);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
