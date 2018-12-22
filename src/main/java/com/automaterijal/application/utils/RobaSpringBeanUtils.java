package com.automaterijal.application.utils;


import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.RobaKatBrProService;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.services.roba.grupe.GrupaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaSpringBeanUtils {

    @NonNull
    final RobaService robaService;
    @NonNull
    final ProizvodjacService proizvodjacService;
    @NonNull
    final GrupaService grupaService;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaKatBrProService robaKatBrProService;
    @NonNull
    final RobaCeneService robaCeneService;
    @NonNull
    final EntityManager manager;

    final RobaMapper mapper = RobaMapper.INSTANCE;

    public RobaDto pretvoriUDTO(final Roba roba, final Partner partner) {
        manager.clear();
        final RobaDto dto = mapper.map(roba);
        dto.setProizvodjac(proizvodjacService.vrateNazivProizvodjacaPoId(roba.getProid()));
        dto.setCena(robaCeneService.vratiCenuRobePoRobiId(roba, partner));
        dto.setGrupa(grupaService.vratiNazivGrupePoId(roba.getGrupaid()));
        dto.setPodGrupa(podGrupaService.vratiNazivPodGrupe(roba.getPodgrupaid(), roba.getGrupaid()));
        return dto;
    }

    public List<String> vratiSveKataloskeBrojevePoPodGrupi(final List<Integer> podGrupeId) {
        final List<Roba> robaPoPodGrupi = robaService.pronadjuSvuRobuPodGrupomId(podGrupeId);
        final List<String> katBrojevi = robaPoPodGrupi.stream().map(Roba::getKatbr).collect(Collectors.toList());
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }

    public Page<Roba> pronadjiRobuPoIzvucenimKatBrojevima(final List<String> kataloskiBrojevi, final List<Integer> sveFilterPodGrupeId, final String proizvodjacId, final Boolean naStanju, final Pageable pageable) {
        final Set<Long> robaId = new HashSet<>();
        robaId.addAll(robaService.pronadjiRobuPoKatBrojevima(kataloskiBrojevi).stream().map(Roba::getRobaid).collect(Collectors.toSet()));
        robaId.addAll(robaKatBrProService.pronadjuKatBrProPoKataloskimBrojevima(kataloskiBrojevi).stream().map(RobaKatBrPro::getRobaid).collect(Collectors.toSet()));

        return robaService.pronadjiRobuPoKljucevimaIPodGrupi(robaId, sveFilterPodGrupeId, proizvodjacId, naStanju, pageable);
    }

    public List<String> vratiSveKataloskeBrojevePoTrazenojReciIPodGrupi(final String searchTerm, final List<Integer> svePodGrupeId) {
        final List<Roba> robaPoPodGrupi = robaService.pronadjuSvuRobuPodGrupomId(svePodGrupeId);
        final List<Roba> katBr = robaPoPodGrupi.stream().filter(roba -> roba.getKatbr().contains(searchTerm) || roba.getKatbrpro().contains(searchTerm)).collect(Collectors.toList());
        final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiPoPretrazi(searchTerm);
        final List<String> katBrojevi = RobaStaticUtils.miksujSveKatBrojeve(katBr, katBrProLista);
        return katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList());
    }
}
