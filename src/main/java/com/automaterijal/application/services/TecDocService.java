package com.automaterijal.application.services;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.tecdoc.ArticleDirectSearchAllNumbersWithStateRecord;
import com.automaterijal.application.tecdoc.ArticleDirectSearchById3Record;
import com.automaterijal.application.tecdoc.ArticlesByIds6Record;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocService {

    @Autowired
    TecDocClient tecDocClient;

    @Autowired
    RobaService robaService;

    @Autowired
    RobaMapper robaMapper;

    @Autowired
    TecDocAtributiRepository tecDocAtributiRepository;

    @Autowired
    TecDocBrandsRepository tecDocBrandsRepository;

    @Autowired
    TecDocMapper tecDocMapper;


    @Value("${roba.slika.tdPrefix}")
    String putDoSlike;
    //    ******************** TecDoc Pretraga  ********************

    public List<ArticleDirectSearchAllNumbersWithStateRecord> tecDocPretragaPoTrazenojReci(String trazenaRec, Integer brandId, Integer numbertype) {
        return tecDocClient.tecDocPretraga(trazenaRec, brandId, numbertype);
    }

    public List<ArticlesByIds6Record> vratiDetaljeArtikla(Long articleId) {
        return tecDocClient.vratiDetaljeArtikla(Arrays.asList(articleId));
    }


    //    ******************** TecDoc Atributi  ********************

    public List<TecDocAtributi> vratiTecDocAtributePrekoRobeId(Long robaId) {
        return tecDocAtributiRepository.findByRobaId(robaId);
    }

    public byte[] vratiDokument(String dokumentId, Integer tipSlike) {
        return tecDocClient.vratiDokument(dokumentId, tipSlike);
    }

    public byte[] vratiDokumentPoRobaId(Long robaId) {
        List<TecDocAtributi> tecDocAtributi = vratiTecDocAtributePrekoRobeId(robaId);
        if (tecDocAtributi.isEmpty()) {
            return null;
        }
        Optional<TecDocAtributi> tecDocAtribut = tecDocAtributi.stream().filter(atributi -> atributi.getDokument() != null).findFirst();
        byte[] retVal = null;
        if (tecDocAtribut.isPresent()) {
            retVal = tecDocAtribut.get().getDokument();
        }
        return retVal;
    }

    public void sacuvajTecDocAtribute(TecDocAtributi atributi) {
        if(atributi.getDokument() != null) {
            ByteArrayInputStream bis = new ByteArrayInputStream(atributi.getDokument());
            BufferedImage bImage2 = null;
            try {
                bImage2 = ImageIO.read(bis);
                ImageIO.write(bImage2, "jpg", new File(putDoSlike + atributi.getRobaId() + ".jpg"));
            } catch (IOException e) {
                log.error("Pukao bajka cuvanje slike iz nekog nepoznatog razloga.");
            }
        } else {
            tecDocAtributiRepository.save(atributi);
        }
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
            if (tdProizvodjaci != null) {
                String katBr = tdProizvodjaci.getDodatak() != null ? robaDto.getKatbr().replaceAll(tdProizvodjaci.getDodatak(), "") : robaDto.getKatbr();
                List<TecDocAtributi> tecDocAtributi = tecDocAtributiRepository.findByRobaId(robaDto.getRobaid());
                if (tecDocAtributi.isEmpty()) {
                    List<ArticleDirectSearchAllNumbersWithStateRecord> directSearch = tecDocClient.tecDocPretraga(katBr, tdProizvodjaci.getTecDocId(), 0);
                    if (directSearch.isEmpty() && tdProizvodjaci != TecDocProizvodjaci.HP) {
                        directSearch = tecDocClient.tecDocPretraga(katBr, tdProizvodjaci.getTecDocId(), 2);
                    } else if (directSearch.isEmpty()) {
                        directSearch = tecDocClient.tecDocPretraga(katBr, tdProizvodjaci.getTecDocId(), 1);
                    }
                    if (!directSearch.isEmpty()) {
                        Long tdArticleId = directSearch.stream()
                                .filter(rekord -> daLiSeBrojeviPodudaraju(katBr, rekord.getArticleNo(), null))
                                .map(ArticleDirectSearchAllNumbersWithStateRecord::getArticleId)
                                .findFirst().orElse(null);

                        if (tdArticleId == null) {
                            tdArticleId = directSearch.stream()
                                    .filter(rekord -> daLiSeBrojeviPodudaraju(katBr, rekord.getArticleSearchNo(), null))
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
                                    String katBr = tdProizvodjaci != null && tdProizvodjaci.getDodatak() != null ? robaDto.getKatbr().replaceAll(tdProizvodjaci.getDodatak(), "") : robaDto.getKatbr();
                                    return daLiSeBrojeviPodudaraju(katBr, directArticle.getArticleNo(), tdProizvodjaci);
                                })
                                .findFirst();

                        if (!dtoOptional.isPresent()) {
                            dtoOptional = robaDtos.stream()
                                    .filter(robaDto -> {
                                        String alternativniKataloskoBroj = zameneKatBr.get(robaDto.getKatbr());
                                        return daLiSeBrojeviPodudaraju(alternativniKataloskoBroj, directArticle.getArticleNo(), null);
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

    private boolean daLiSeBrojeviPodudaraju(String katBr, String tecDocKatBr, TecDocProizvodjaci tecDocProizvodjaci) {
        if (katBr == null || tecDocKatBr == null) {
            return false;
        }
        if (tecDocProizvodjaci != null && tecDocProizvodjaci.getDodatak() != null) {
            katBr = katBr.replaceAll(tecDocProizvodjaci.getDodatak(), "");
        }
        katBr = katBr.replaceAll("[-,./]", "").replaceAll("\\s+", "").replaceAll("-LUČ", "");
        tecDocKatBr = tecDocKatBr.replaceAll("[-,./]", "").replaceAll("\\s+", "");
        return katBr.equals(tecDocKatBr);
    }
}
