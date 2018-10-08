package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.RobaRepository;
import com.automaterijal.application.services.constants.GrupaService;
import com.automaterijal.application.services.constants.PodGrupaService;
import com.automaterijal.application.services.constants.ProizvodjacService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.TransactionScoped;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@TransactionScoped
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaService {

    @NonNull
    final ProizvodjacService proizvodjacService;
    @NonNull
    final GrupaService grupaService;
    @NonNull
    final PodGrupaService podGrupaService;
    @NonNull
    final RobaCeneService robaCeneService;
    @NonNull
    final RobaRepository robaRepository;
    @NonNull
    final RobaKatBrProService robaKatBrProService;

    @NonNull
    final EntityManager manager;
    static final double STANJE_VECE = 0;

    final RobaMapper mapper = RobaMapper.INSTANCE;

    public Page<RobaDto> findAll(
            final Integer page,
            final Integer pageSize,
            final RobaSortiranjePolja sortiranjePolja,
            final Sort.Direction direction,
            final String searchTerm
    ) {
        Page<Roba> retVal = null;

        if (searchTerm == null) {
            retVal = robaRepository.findByStanjeGreaterThan(STANJE_VECE ,PageRequest.of(page, pageSize, new Sort(direction, sortiranjePolja.getFieldName())));
        } else {
            retVal = vratiStranicuPoslePretrage(searchTerm, page, pageSize, direction, sortiranjePolja.getFieldName());
        }
        return retVal.map(this::pretvoriUDTO);
    }

    private Page<Roba> vratiStranicuPoslePretrage(final String searchTerm, final Integer page, final Integer pageSize, final Sort.Direction direction, final String fieldName) {
        final List<Roba> robaLista = robaRepository.findByKatbrContainingOrKatbrproContaining(searchTerm, searchTerm);
        final List<RobaKatBrPro> robaKatBtLista = robaKatBrProService.pronadjiPoPretrazi(searchTerm);
        final List<Long> katBrojevi = ubaciKatBrojeveUListu(robaLista, robaKatBtLista);
        final List<Roba> roba = katBrojevi.stream()
                                            .map(robaRepository::getOne)
                                            .filter(robaBaza -> robaBaza.getStanje() > 0 )
                                            .collect(Collectors.toList());
        if(direction != null || fieldName != null) {
            sortirajListu(roba, direction, fieldName);
        }
        List<Roba> retVal = null;
        if(page != null && pageSize != null) {
            retVal = vratiStranicuTrazenu(roba, page, pageSize);
        } else {
            retVal = roba;
        }
        return new PageImpl(retVal, PageRequest.of(page, pageSize, new Sort(direction, fieldName)), roba.size());
    }

    private List<Roba> vratiStranicuTrazenu(final List<Roba> roba, final Integer page, final Integer pageSize) {
        int internalPageSize = page == 0 ? pageSize : ((page * pageSize + pageSize) > roba.size()) ? roba.size() : (page * pageSize + pageSize);
        final int internalPage = page == 0 ? page : page * pageSize;
        if(internalPageSize > roba.size()) {
            internalPageSize = roba.size();
        }
        return roba.subList(internalPage, internalPageSize);
    }


    private void sortirajListu(final List<Roba> roba, final Sort.Direction direction, final String fieldName) {
        if(RobaSortiranjePolja.KATBR.getFieldName().equals(fieldName) && direction == Sort.Direction.ASC) {
            roba.sort(Comparator.comparing(Roba::getKatbr));
        } else if(RobaSortiranjePolja.KATBR.getFieldName().equals(fieldName) && direction == Sort.Direction.DESC) {
            roba.sort(Comparator.comparing(Roba::getKatbr).reversed());
        } else if(RobaSortiranjePolja.KATBRPRO.getFieldName().equals(fieldName) && direction == Sort.Direction.ASC) {
            roba.sort(Comparator.comparing(Roba::getKatbrpro));
        } else if(RobaSortiranjePolja.KATBRPRO.getFieldName().equals(fieldName) && direction == Sort.Direction.DESC) {
            roba.sort(Comparator.comparing(Roba::getKatbrpro).reversed());
        }
    }

    private List<Long> ubaciKatBrojeveUListu(final List<Roba> robaLista, final List<RobaKatBrPro> robaKatBtLista) {
       final List<Long> katBr = robaLista.stream().map(Roba::getRobaid).collect(Collectors.toList());
        robaKatBtLista.forEach(robaKatBrPro -> {
            if(!katBr.contains(robaKatBrPro.getRobaid())) {
                katBr.add(robaKatBrPro.getRobaid());
            }
        });
        return katBr;
    }

    private RobaDto pretvoriUDTO(final Roba roba) {
        manager.clear();
        final RobaDto dto = mapper.map(roba);
        dto.setGrupa(
                grupaService.vratiNazivGrupePoId(roba.getGrupaid())
        );
        dto.setPodGrupa(
                podGrupaService.vratiNazivPodGrupe(roba.getPodgrupaid(), roba.getGrupaid())
        );
        dto.setProizvodjac(
                proizvodjacService.vrateNazivProizvodjacaPoId(roba.getProid())
        );
        dto.setCena(
                robaCeneService.vratiCenuRobePoRobiId(roba.getRobaid())
        );
        return dto;
    }
}
