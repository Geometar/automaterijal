package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.repository.roba.RobaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaService {

    @NonNull
    final RobaRepository robaRepository;

    public Optional<Roba> pronadjiRobuPoPrimarnomKljucu(Long id) {
        return robaRepository.findById(id);
    }

    public List<Roba> pronadjiRobuPoPrimarnomKljucuBatch(List<Long> ids) {
        return robaRepository.findByRobaidIn(ids);
    }

    public Page<Roba> pronadjiSvuRobu(boolean naStanju, Pageable pageable) {
        if (naStanju) {
            return robaRepository.findByStanjeGreaterThan(0, pageable);
        } else {
            return robaRepository.findAll(pageable);
        }
    }

    public List<Roba> pronadjiSvuRobuPoPodGrupiIdListaSvaStanja(List<Integer> podGrupaId) {
        return robaRepository.findByPodgrupaidIn(podGrupaId);
    }

    public Roba pronadjiPoPretaziIProizvodjacima(String katBr, List<String> proizvodjaci) {
        return robaRepository.findByKatbrAndProizvodjacProidInAndStanjeGreaterThan(katBr, proizvodjaci,
                0);
    }

    public Page<Roba> pronadjiSvuRobuPoGrupiIdNaStanju(List<String> grupaId, boolean naStanju,
                                                       Pageable pageable) {
        return naStanju ? robaRepository.findByGrupaidInAndStanjeGreaterThan(grupaId, 0, pageable) : robaRepository.findByGrupaidInAndStanjeGreaterThan(grupaId, -1, pageable);
    }

    public List<Roba> pronadjiRobuPoKataloskomBroju(String katBr) {
        return robaRepository.findByKatbr(katBr);
    }

}
