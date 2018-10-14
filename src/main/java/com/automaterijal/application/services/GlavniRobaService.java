package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.services.constants.GrupaService;
import com.automaterijal.application.services.constants.PodGrupaService;
import com.automaterijal.application.services.constants.ProizvodjacService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class GlavniRobaService {

    @NonNull
    final ProizvodjacService proizvodjacService;
    @NonNull
    final GrupaService grupaService;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaCeneService robaCeneService;
    @NonNull
    final RobaService robaService;
    @NonNull
    final RobaKatBrProService robaKatBrProService;

    @NonNull
    final EntityManager manager;
    final RobaMapper mapper = RobaMapper.INSTANCE;

    public Page<RobaDto> pronadjiRobuPoPretrazi(
            final Integer page,
            final Integer pageSize,
            final RobaSortiranjePolja sortiranjePolja,
            final Sort.Direction direction,
            final String searchTerm,
            final String filterProizvodjac,
            final Boolean filterRaspolozivost
    ) {
        final List<Roba> katBr = robaService.pronadjuSvuRobuPoPretrazi(searchTerm);
        final List<RobaKatBrPro> katBrProLista = robaKatBrProService.pronadjiPoPretrazi(searchTerm);
        final List<String> katBrojevi = vratiSveKataloskeBrojeve(katBr, katBrProLista);
        final Page<Roba> roba = vratiSvuPoKatBrojevima(
          katBrojevi.stream().filter(katBroj -> !katBroj.isEmpty()).collect(Collectors.toList()),
                proizvodjacService.vratiProizvodjacaPoNazivu(filterProizvodjac),
                filterRaspolozivost,
          PageRequest.of(page, pageSize, new Sort(direction, sortiranjePolja.getFieldName()))
        );

        return roba.map(this::pretvoriUDTO);
    }

    private Page<Roba> vratiSvuPoKatBrojevima(final List<String> katBrojevi, final String filterProizvodjac, final Boolean filterRaspolozivostfinal, final Pageable pageable) {
        final Set<Long> robaId = new HashSet<>();
        robaId.addAll(robaService.pronadjiRobuPoKatBrojevima(katBrojevi).stream().map(Roba::getRobaid).collect(Collectors.toSet()));
        robaId.addAll(robaKatBrProService.pronadjuKatBrProPoKataloskimBrojevima(katBrojevi).stream().map(RobaKatBrPro::getRobaid).collect(Collectors.toSet()));

        return robaService.pronadjiRobuPoKljucevima(robaId, filterProizvodjac, filterRaspolozivostfinal, pageable);
    }

    private List<String> vratiSveKataloskeBrojeve(final List<Roba> katBr, final List<RobaKatBrPro> katBrProLista) {
        final List<String> listaKataloskihBrojeva = new ArrayList<>();
        if(!katBr.isEmpty()) {
            katBr.forEach(roba -> {
                listaKataloskihBrojeva.add(roba.getKatbr());
                listaKataloskihBrojeva.add(roba.getKatbrpro());
            });
        }
        if(!katBrProLista.isEmpty()) {
            katBrProLista.forEach(robaKatBrPro -> {
                listaKataloskihBrojeva.add(robaKatBrPro.getKatbrpro());
            });
        }
        return new ArrayList(new HashSet(listaKataloskihBrojeva));
     }

     private RobaDto pretvoriUDTO(final Roba roba) {
        manager.clear();
        final RobaDto dto = mapper.map(roba);
        dto.setProizvodjac(
                proizvodjacService.vrateNazivProizvodjacaPoId(roba.getProid())
        );
        dto.setCena(
                robaCeneService.vratiCenuRobePoRobiId(roba.getRobaid())
        );
        return dto;
     }
}
