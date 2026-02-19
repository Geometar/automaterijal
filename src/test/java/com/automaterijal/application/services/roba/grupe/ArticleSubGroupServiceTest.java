package com.automaterijal.application.services.roba.grupe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.repository.PodGrupaRepository;
import com.automaterijal.application.domain.repository.roba.PodgrupeJooqRepository;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArticleSubGroupServiceTest {

  @Mock private PodGrupaRepository podGrupaRepository;
  @Mock private PodgrupeJooqRepository podgrupeJooqRepository;

  private ArticleSubGroupService service;

  @BeforeEach
  void setUp() {
    service = new ArticleSubGroupService(podGrupaRepository, podgrupeJooqRepository);
  }

  @Test
  void buildCategoriesFromPodgrupaIds_groupsByDisplayGroupName() {
    PodgrupaDto dto = new PodgrupaDto();
    dto.setId(301);
    dto.setNaziv("Lamela");
    dto.setGrupaId("ZAM");
    dto.setGrupa("ZAMAJAC");

    when(podgrupeJooqRepository.findAllPodgrupeWithGrupa(Set.of(301))).thenReturn(List.of(dto));

    Map<String, List<PodgrupaDto>> categories = service.buildCategoriesFromPodgrupaIds(Set.of(301));

    assertThat(categories).containsOnlyKeys("ZAMAJAC");
    assertThat(categories.get("ZAMAJAC")).extracting(PodgrupaDto::getId).containsExactly(301);
    assertThat(categories.get("ZAMAJAC")).extracting(PodgrupaDto::getGrupaId).containsExactly("ZAM");
  }

  @Test
  void buildCategoriesFromPodgrupaIds_keepsFallbackCategory() {
    Map<String, List<PodgrupaDto>> categories = service.buildCategoriesFromPodgrupaIds(Set.of(0));

    assertThat(categories).containsKey(ArticleSubGroupService.ANONIMNA_GRUPA);
    assertThat(categories.get(ArticleSubGroupService.ANONIMNA_GRUPA))
        .extracting(PodgrupaDto::getId)
        .contains(0);
  }
}
