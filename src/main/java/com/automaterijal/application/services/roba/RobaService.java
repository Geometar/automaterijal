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
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaService {

    @NonNull
    RobaRepository robaRepository;

    public Optional<Roba> pronadjiRobuPoPrimarnomKljucu(final Long id) {
        return robaRepository.findById(id);
    }

    public List<Roba> pronadjiSvuRobu() {
        return robaRepository.findAll();
    }

    public Page<Roba> pronadjiSvuRobu(final boolean naStanju, final Pageable pageable) {
        if (naStanju) {
            return robaRepository.findByStanjeGreaterThan(0, pageable);
        } else {
            return robaRepository.findAll(pageable);
        }
    }

    public List<Roba> pronadjuSvuRobuPoGrupiIdNaStanju(final List<String> grupeId) {
        return robaRepository.findByGrupaidInAndStanjeGreaterThan(grupeId, 0);
    }

    public Page<Roba> pronadjiSvuRobuPoPodGrupiId(final List<Integer> podGrupaId, final boolean naStanju, final Pageable pageable) {
        Page<Roba> roba = null;
        if (naStanju) {
            roba = robaRepository.findByPodgrupaidInAndStanjeGreaterThan(podGrupaId, 0, pageable);
        } else {
            roba = robaRepository.findByPodgrupaidInAndStanjeGreaterThan(podGrupaId, -1, pageable);
        }
        return roba;
    }

    public List<Roba> pronadjiSvuRobuPoPodGrupiIdLista(final List<Integer> podGrupaId) {
        return robaRepository.findByPodgrupaidInAndStanjeGreaterThan(podGrupaId, 0);
    }

    public Page<Roba> pronadjiSvuRobuPoGrupiIdNaStanju(final List<String> grupaId, final boolean naStanju, final Pageable pageable) {
        Page<Roba> roba = null;
        if (naStanju) {
            roba = robaRepository.findByGrupaidInAndStanjeGreaterThan(grupaId, 0, pageable);
        } else {
            roba = robaRepository.findByGrupaidInAndStanjeGreaterThan(grupaId, -1, pageable);
        }
        return roba;
    }
}
