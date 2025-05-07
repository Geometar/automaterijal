package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.domain.mapper.TecDocMapper;
import com.automaterijal.application.domain.repository.tecdoc.TecDocAtributiRepository;
import com.automaterijal.application.tecdoc.ArticleDirectSearchById3Record;
import com.automaterijal.application.tecdoc.AssignedArticleAttributs2RecordSeq;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecord;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
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

    SlikaDto slikaDto = new SlikaDto();
    slikaDto.setSlikeByte(imageBytes);
    slikaDto.setUrl(false);
    robaLightDto.setSlika(slikaDto);
  }

  public void saveAttribute(TecDocAtributi atributi) {
    tecDocAtributiRepository.save(atributi);
  }
}
