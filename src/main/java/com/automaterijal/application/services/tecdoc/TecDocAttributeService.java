package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.domain.constants.GlobalConstants;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaAtributesDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaExpandedDto;
import com.automaterijal.application.domain.dto.tecdoc.TecDocDokumentacija;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.tecdoc.ArticleDirectSearchById3Record;
import com.automaterijal.application.tecdoc.AssignedArticleAttributs2RecordSeq;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
@Slf4j
public class TecDocAttributeService {

  @NonNull TecDocMapper tecDocMapper;
  @NonNull TecDocAtributiRepository tecDocAtributiRepository;

  public List<TecDocAtributi> findAll() {
    return tecDocAtributiRepository.findAll();
  }

  public List<TecDocAtributi> findByRobaId(Long robaId) {
    return tecDocAtributiRepository.findByRobaId(robaId);
  }

  public List<TecDocAtributi> findByRobaIds(List<Long> robaIds) {
    return tecDocAtributiRepository.findByRobaIdIn(robaIds);
  }

  public void saveAttributes(
      AssignedArticleAttributs2RecordSeq attributes,
      RobaLightDto robaLightDto,
      ArticleDirectSearchById3Record directArticle) {

    if (attributes != null && attributes.getArray() != null) {
      attributes
          .getArray()
          .forEach(
              att -> {
                TecDocAtributi entity =
                    tecDocMapper.map(
                        att,
                        robaLightDto,
                        directArticle.getArticleId(),
                        TecDocProizvodjaci.pronadjiPoNazivu(
                                robaLightDto.getProizvodjac().getProid())
                            .getTecDocId());
                tecDocAtributiRepository.save(entity);
              });
    }
  }

  public void addManualTehnicalDetails(RobaLightDto dto, List<TecDocAtributi> tecDocAttributes) {

    List<RobaTehnickiOpisDto> tehnickiOpis = new ArrayList<>();

    for (TecDocAtributi rekord : tecDocAttributes) {
      if (!GlobalConstants.ROBA_MANUAL_ATTRIBUTES.contains(rekord.getAttrType())) {
        continue;
      }

      RobaTehnickiOpisDto data = new RobaTehnickiOpisDto();
      data.setOznaka(rekord.getAttrShortName());
      data.setVrednost(rekord.getAttrValue());
      data.setJedinica(rekord.getAttrUnit());

      tehnickiOpis.add(data);
    }

    if (!tehnickiOpis.isEmpty()) {
      dto.getTehnickiOpis().addAll(tehnickiOpis);
    }
  }

  public void addManualDocuments(RobaExpandedDto dto, List<TecDocAtributi> tecDocAttributes) {
    Map<String, List<TecDocDokumentacija>> docs =
        dto.getDokumentacija() != null ? dto.getDokumentacija() : new HashMap<>();

    for (TecDocAtributi rekord : tecDocAttributes) {
      if (!GlobalConstants.ROBA_MANUAL_YOUTUBE_ATTRIBUTES.contains(rekord.getAttrType())) {
        continue;
      }

      String url = rekord.getAttrValue();
      if (url == null || !url.toLowerCase().contains("youtube")) {
        continue;
      }

      String key = rekord.getAttrShortName();
      if (key == null || key.isBlank()) {
        continue;
      }

      List<TecDocDokumentacija> documents = docs.getOrDefault(key, new ArrayList<>());

      TecDocDokumentacija tecDocDokumentacija = new TecDocDokumentacija();
      tecDocDokumentacija.setDocUrl(url);
      tecDocDokumentacija.setDocFileTypeName("URL");

      documents.add(tecDocDokumentacija);

      docs.put(key, documents);
    }

    // Assign the updated map back to the DTO
    if (!docs.isEmpty()) {
      dto.setDokumentacija(docs);
    }
  }

  public void cacheThumbnailAttribute(
      RobaLightDto robaLightDto,
      ThumbnailByArticleIdRecord thumbnail,
      byte[] imageBytes,
      ArticleDirectSearchById3Record article) {
    TecDocAtributi entity =
        tecDocMapper.map(
            thumbnail,
            robaLightDto,
            article.getArticleId(),
            TecDocProizvodjaci.pronadjiPoNazivu(robaLightDto.getProizvodjac().getProid())
                .getTecDocId());

    tecDocAtributiRepository.save(entity);

    // Previously we propagated raw image bytes into the DTO; with CDN-backed images this is no longer needed.
  }

  public void saveAttributesManually(List<RobaAtributesDto> dtos) {
    dtos.stream().map(tecDocMapper::map).forEach(tecDocAtributiRepository::save);
  }

  public void deleteAttributesForRobaId(Long robaId) {
    tecDocAtributiRepository.deleteByRobaId(robaId);
  }

  public void saveAttribute(TecDocAtributi atributi) {
    tecDocAtributiRepository.save(atributi);
  }
}
