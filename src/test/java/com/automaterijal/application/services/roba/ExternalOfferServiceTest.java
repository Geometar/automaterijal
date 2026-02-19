package com.automaterijal.application.services.roba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.services.tecdoc.TecDocBrandService;
import com.automaterijal.application.services.tecdoc.TecDocGenericArticleMappingService;
import com.automaterijal.application.services.tecdoc.TecDocPreviewService;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExternalOfferServiceTest {

  @Mock private ExternalAvailabilityService externalAvailabilityService;
  @Mock private TecDocGenericArticleMappingService mappingService;
  @Mock private ArticleSubGroupService articleSubGroupService;
  @Mock private ArticleGroupService articleGroupService;
  @Mock private TecDocPreviewService tecDocPreviewService;
  @Mock private ProviderBrandResolver providerBrandResolver;
  @Mock private TecDocService tecDocService;
  @Mock private TecDocBrandService tecDocBrandService;
  @Mock private ProizvodjacService proizvodjacService;

  private ExternalOfferService service;

  @BeforeEach
  void setUp() {
    service =
        new ExternalOfferService(
            externalAvailabilityService,
            mappingService,
            articleSubGroupService,
            articleGroupService,
            tecDocPreviewService,
            providerBrandResolver,
            tecDocService,
            tecDocBrandService,
            proizvodjacService);
  }

  @Test
  void buildInternalCategories_usesGroupIdForInternalGroupAndNameForDisplay() throws Exception {
    PodgrupaDto dto = new PodgrupaDto();
    dto.setId(201);
    dto.setNaziv("Lamela");
    dto.setGrupaId("ZAM");
    dto.setGrupa("ZAMAJAC");

    when(articleSubGroupService.loadPodgrupeWithGrupa(Set.of(201))).thenReturn(Map.of(201, dto));
    when(articleGroupService.groupNamesById()).thenReturn(Map.of("ZAM", "Zamajac from groups"));

    Map<Long, Object> result = invokeBuildInternalCategories(Map.of(9001L, 201));
    Object category = result.get(9001L);

    assertThat(category).isNotNull();
    assertThat(readComponent(category, "groupId")).isEqualTo("ZAM");
    assertThat(readComponent(category, "groupName")).isEqualTo("ZAMAJAC");
    assertThat(readComponent(category, "subGroupId")).isEqualTo(201);
    assertThat(readComponent(category, "subGroupName")).isEqualTo("Lamela");
  }

  @Test
  void buildInternalCategories_skipsEntriesWithoutGroupId() throws Exception {
    PodgrupaDto dto = new PodgrupaDto();
    dto.setId(202);
    dto.setNaziv("Set kvacila");
    dto.setGrupaId(null);
    dto.setGrupa("ZAMAJAC");

    when(articleSubGroupService.loadPodgrupeWithGrupa(Set.of(202))).thenReturn(Map.of(202, dto));
    when(articleGroupService.groupNamesById()).thenReturn(Map.of("ZAM", "Zamajac from groups"));

    Map<Long, Object> result = invokeBuildInternalCategories(Map.of(9002L, 202));

    assertThat(result).isEmpty();
  }

  @Test
  void buildInternalCategories_usesGroupNameMapWhenPodgrupaGroupNameMissing() throws Exception {
    PodgrupaDto dto = new PodgrupaDto();
    dto.setId(203);
    dto.setNaziv("Korpa kvacila");
    dto.setGrupaId("ZAM");
    dto.setGrupa(" ");

    when(articleSubGroupService.loadPodgrupeWithGrupa(Set.of(203))).thenReturn(Map.of(203, dto));
    when(articleGroupService.groupNamesById()).thenReturn(Map.of("ZAM", "ZAMAJAC"));

    Map<Long, Object> result = invokeBuildInternalCategories(Map.of(9003L, 203));
    Object category = result.get(9003L);

    assertThat(category).isNotNull();
    assertThat(readComponent(category, "groupId")).isEqualTo("ZAM");
    assertThat(readComponent(category, "groupName")).isEqualTo("ZAMAJAC");
  }

  @SuppressWarnings("unchecked")
  private Map<Long, Object> invokeBuildInternalCategories(Map<Long, Integer> mappedPodgrupeByGeneric)
      throws Exception {
    Method method =
        ExternalOfferService.class.getDeclaredMethod("buildInternalCategories", Map.class);
    method.setAccessible(true);
    return (Map<Long, Object>) method.invoke(service, mappedPodgrupeByGeneric);
  }

  private Object readComponent(Object recordInstance, String component) throws Exception {
    Method accessor = recordInstance.getClass().getDeclaredMethod(component);
    accessor.setAccessible(true);
    return accessor.invoke(recordInstance);
  }
}
