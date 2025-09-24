package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowcaseLookupService {

  private final ArticleGroupService articleGroupService;
  private final ArticleSubGroupService articleSubGroupService;
  private final ProizvodjacRepository proizvodjacRepository;

  @Cacheable(value = "showcaseGroupNames")
  public Map<String, String> groupNameMap() {
    return articleGroupService.findAll().stream()
        .filter(g -> g.getGrupaid() != null && g.getNaziv() != null)
        .collect(Collectors.toMap(Grupa::getGrupaid, Grupa::getNaziv, (a, b) -> a));
  }

  @Cacheable(value = "showcaseSubGroupNames")
  public Map<Integer, String> subGroupNameMap() {
    return articleSubGroupService.findAll().stream()
        .filter(pg -> pg.getPodGrupaId() != null && pg.getNaziv() != null)
        .collect(Collectors.toMap(PodGrupa::getPodGrupaId, PodGrupa::getNaziv, (a, b) -> a));
  }

  @Cacheable(value = "showcaseManufacturerNames")
  public Map<String, String> manufacturerNameMap() {
    return proizvodjacRepository.findAll().stream()
        .filter(p -> p.getProid() != null && p.getNaziv() != null)
        .collect(Collectors.toMap(Proizvodjac::getProid, Proizvodjac::getNaziv, (a, b) -> a));
  }
}

