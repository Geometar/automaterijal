package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
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
    @NonNull final RobaRepository robaRepository;
    final RobaMapper mapper = RobaMapper.INSTANCE;

    public Page<RobaDto> findAll(final Integer page, final Integer pageSize) {
        return robaRepository.findAll(PageRequest.of(page, pageSize))
                .map(this::pretvoriUDTO);
    }

    private RobaDto pretvoriUDTO(final Roba roba) {
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
        return dto;
    }
}
