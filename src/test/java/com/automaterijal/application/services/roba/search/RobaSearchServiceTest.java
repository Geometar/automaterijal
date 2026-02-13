package com.automaterijal.application.services.roba.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.integration.providers.szakal.SzakalOeSearchService;
import com.automaterijal.application.integration.providers.szakal.SzakalProperties;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.ExternalOfferService;
import com.automaterijal.application.services.roba.ExternalOfferService.ExternalOfferPayload;
import com.automaterijal.application.services.roba.ProviderPricingService;
import com.automaterijal.application.services.roba.RobaEnrichmentService;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.services.roba.sort.RobaSortService;
import com.automaterijal.application.services.tecdoc.TecDocGenericArticleMappingService;
import com.automaterijal.application.tecdoc.ArticlesResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;

@ExtendWith(MockitoExtension.class)
class RobaSearchServiceTest {

  @Mock private RobaAdapterService robaAdapterService;
  @Mock private TecDocService tecDocService;
  @Mock private RobaEnrichmentService robaEnrichmentService;
  @Mock private ExternalOfferService externalOfferService;
  @Mock private TecDocGenericArticleMappingService tecDocGenericArticleMappingService;
  @Mock private ArticleSubGroupService articleSubGroupService;
  @Mock private RobaSortService robaSortService;
  @Mock private SzakalOeSearchService szakalOeSearchService;
  @Mock private SzakalProperties szakalProperties;
  @Mock private ProviderPricingService providerPricingService;

  private RobaSearchService service;
  private Partner partner;

  @BeforeEach
  void setUp() {
    service =
        new RobaSearchService(
            robaAdapterService,
            tecDocService,
            robaEnrichmentService,
            externalOfferService,
            tecDocGenericArticleMappingService,
            articleSubGroupService,
            robaSortService,
            szakalOeSearchService,
            szakalProperties,
            providerPricingService);

    partner = new Partner();
    partner.setPpid(1001);

    when(robaSortService.sortByGroup(anyList())).thenAnswer(invocation -> invocation.getArgument(0));
    when(robaSortService.sortByGroupWithExact(anyList(), any()))
        .thenAnswer(invocation -> invocation.getArgument(0));
    when(articleSubGroupService.buildCategoriesFromPodgrupaIds(anySet())).thenReturn(Map.of());
  }

  @Test
  void searchProducts_externalSearchFlow_preservesCoreFiltersWhenLoadingFullLocalScope() {
    UniverzalniParametri parametri = new UniverzalniParametri();
    parametri.setTrazenaRec("FILTERTERM");
    parametri.setPage(2);
    parametri.setPageSize(25);
    parametri.setNaStanju(false);
    parametri.setGrupa(List.of("MOTOR"));
    parametri.setPodgrupeZaPretragu(List.of(10, 20));
    parametri.setProizvodjac(List.of("FEBI", "BOSCH"));

    when(tecDocService.tecDocPretragaPoTrazenojReci(any(), isNull(), anyInt())).thenReturn(List.of());
    when(robaAdapterService.searchProductsByName(any(), anySet(), anySet()))
        .thenAnswer(
            invocation -> {
              @SuppressWarnings("unchecked")
              Set<Long> productIds = invocation.getArgument(2);
              productIds.add(101L);
              return true;
            });

    RobaLightDto local = roba("FEBI", 10, 5, ArticleAvailabilityStatus.IN_STOCK, "F-1");
    when(robaAdapterService.searchProductsByIds(any(), anySet())).thenReturn(magacin(local));

    ExternalOfferPayload payload = payloadWithProbes(List.of());
    when(externalOfferService.prepareFromTecDocSearch(anyList(), any(MagacinDto.class), any(), any()))
        .thenReturn(payload);
    when(externalOfferService.materializeExternalOffers(eq(payload), any())).thenReturn(List.of());

    service.searchProducts(parametri, partner, false);

    ArgumentCaptor<UniverzalniParametri> paramsCaptor =
        ArgumentCaptor.forClass(UniverzalniParametri.class);
    verify(robaAdapterService).searchProductsByIds(paramsCaptor.capture(), anySet());

    UniverzalniParametri forwarded = paramsCaptor.getValue();
    assertThat(forwarded.getGrupa()).containsExactly("MOTOR");
    assertThat(forwarded.getPodgrupeZaPretragu()).containsExactly(10, 20);
    assertThat(forwarded.getProizvodjac()).containsExactly("FEBI", "BOSCH");
    assertThat(forwarded.getPage()).isZero();
    assertThat(forwarded.getPageSize()).isEqualTo(Integer.MAX_VALUE);
    assertThat(forwarded.isPaged()).isFalse();
  }

  @Test
  void searchProducts_naStanjuTrue_keepsOnlyAvailableAndBuildsFacetsFromVisibleItems() {
    UniverzalniParametri parametri = new UniverzalniParametri();
    parametri.setTrazenaRec("FILTERTERM");
    parametri.setPage(0);
    parametri.setPageSize(10);
    parametri.setNaStanju(true);

    when(tecDocService.tecDocPretragaPoTrazenojReci(any(), isNull(), anyInt())).thenReturn(List.of());
    when(robaAdapterService.searchProductsByName(any(), anySet(), anySet()))
        .thenAnswer(
            invocation -> {
              @SuppressWarnings("unchecked")
              Set<Long> productIds = invocation.getArgument(2);
              productIds.add(102L);
              return true;
            });

    RobaLightDto localAvailable = roba("FEBI", 10, 3, ArticleAvailabilityStatus.IN_STOCK, "F-10");
    RobaLightDto localOut = roba("BOSCH", 20, 0, ArticleAvailabilityStatus.OUT_OF_STOCK, "B-20");
    when(robaAdapterService.searchProductsByIds(any(), anySet()))
        .thenReturn(magacin(localAvailable, localOut));

    ExternalOfferPayload payload = payloadWithProbes(List.of());
    when(externalOfferService.prepareFromTecDocSearch(anyList(), any(MagacinDto.class), any(), any()))
        .thenReturn(payload);

    RobaLightDto externalAvailable =
        roba("SKF", 30, 0, ArticleAvailabilityStatus.AVAILABLE, "S-30");
    when(externalOfferService.materializeExternalOffers(eq(payload), any()))
        .thenReturn(List.of(externalAvailable));

    MagacinDto out = service.searchProducts(parametri, partner, false);

    verify(robaEnrichmentService).applyPriceOnly(anyList(), eq(partner), eq(false));

    assertThat(out.getRobaDto().getContent())
        .extracting(RobaLightDto::getPodGrupa)
        .containsExactlyInAnyOrder(10, 30)
        .doesNotContain(20);

    assertThat(out.getProizvodjaci())
        .extracting(ProizvodjacDTO::getProid)
        .containsExactlyInAnyOrder("FEBI", "SKF")
        .doesNotContain("BOSCH");

    ArgumentCaptor<Set<Integer>> subGroupsCaptor = ArgumentCaptor.forClass(Set.class);
    verify(articleSubGroupService).buildCategoriesFromPodgrupaIds(subGroupsCaptor.capture());
    assertThat(subGroupsCaptor.getValue()).containsExactlyInAnyOrder(10, 30);
  }

  @Test
  void searchProducts_naStanjuTrue_withoutSearchTerm_prewarmsPriceAvailability() {
    UniverzalniParametri parametri = new UniverzalniParametri();
    parametri.setPage(0);
    parametri.setPageSize(10);
    parametri.setNaStanju(true);

    RobaLightDto local = roba("FEBI", 10, 2, ArticleAvailabilityStatus.IN_STOCK, "F-2");
    when(robaAdapterService.searchFilteredProductsWithoutSearchTerm(any())).thenReturn(magacin(local));

    service.searchProducts(parametri, partner, false);

    verify(robaEnrichmentService).applyPriceOnly(anyList(), eq(partner), eq(false));
  }

  @Test
  void getAssociatedArticles_respectsRequestedSubgroupFilterBeforeBuildingFacets() {
    UniverzalniParametri parametri = new UniverzalniParametri();
    parametri.setPage(0);
    parametri.setPageSize(10);
    parametri.setPodgrupeZaPretragu(List.of(10));

    ArticlesResponse tecDocResponse = new ArticlesResponse();
    when(tecDocService.getAssociatedArticles(anyInt(), any(), any())).thenReturn(tecDocResponse);

    RobaLightDto subgroup10 = roba("FEBI", 10, 2, ArticleAvailabilityStatus.IN_STOCK, "F-10");
    RobaLightDto subgroup20 = roba("BOSCH", 20, 2, ArticleAvailabilityStatus.IN_STOCK, "B-20");
    when(robaAdapterService.fetchProductsByTecDocArticles(anySet(), any(), anyList()))
        .thenReturn(magacin(subgroup10, subgroup20));

    ExternalOfferPayload payload = payloadWithProbes(List.of());
    when(externalOfferService.prepareFromAssociatedTecDocArticles(
            anyList(), any(MagacinDto.class), any(), any()))
        .thenReturn(payload);
    when(externalOfferService.materializeExternalOffers(eq(payload), any())).thenReturn(List.of());

    MagacinDto out = service.getAssociatedArticles(1, "P", "100350", parametri, partner);

    assertThat(out.getRobaDto().getContent())
        .extracting(RobaLightDto::getPodGrupa)
        .containsExactly(10);

    assertThat(out.getProizvodjaci())
        .extracting(ProizvodjacDTO::getProid)
        .containsExactly("FEBI");

    ArgumentCaptor<Set<Integer>> subGroupsCaptor = ArgumentCaptor.forClass(Set.class);
    verify(articleSubGroupService).buildCategoriesFromPodgrupaIds(subGroupsCaptor.capture());
    assertThat(subGroupsCaptor.getValue()).containsExactly(10);
  }

  private ExternalOfferPayload payloadWithProbes(List<RobaLightDto> probes) {
    ExternalOfferPayload payload = org.mockito.Mockito.mock(ExternalOfferPayload.class);
    when(payload.getProbes()).thenReturn(probes);
    return payload;
  }

  private MagacinDto magacin(RobaLightDto... items) {
    MagacinDto magacin = new MagacinDto();
    magacin.setRobaDto(new PageImpl<>(List.of(items)));
    return magacin;
  }

  private RobaLightDto roba(
      String manufacturerId,
      int podGrupa,
      double stanje,
      ArticleAvailabilityStatus availability,
      String katBr) {
    RobaLightDto dto = new RobaLightDto();
    dto.setKatbr(katBr);
    dto.setStanje(stanje);
    dto.setPodGrupa(podGrupa);
    dto.setPodGrupaNaziv("SUB-" + podGrupa);
    dto.setProizvodjac(proizvodjac(manufacturerId));
    dto.setAvailabilityStatus(availability);
    return dto;
  }

  private ProizvodjacDTO proizvodjac(String proid) {
    ProizvodjacDTO p = new ProizvodjacDTO();
    p.setProid(proid);
    p.setNaziv(proid);
    return p;
  }
}
