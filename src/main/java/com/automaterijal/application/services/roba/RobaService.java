package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.domain.repository.RobaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@TransactionScoped
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaService {

    @NonNull
    final RobaRepository robaRepository;

    public Optional<Roba> pronadjiRobuPoPrimarnomKljucu(final Long id) {
        return robaRepository.findById(id);
    }

    public List<Roba> pronadjiSvuRobu() {
        return robaRepository.findAll();
    }

    public List<Roba> pronadjiSvuRobuPoProId(final String proId) {
        return robaRepository.findByProid(proId);
    }

    public Page<Roba> pronadjiSvuRobu(final boolean naStanju, final Pageable pageable) {
        if (naStanju) {
            return robaRepository.findByStanjeGreaterThan(0, pageable);
        } else {
            return robaRepository.findAll(pageable);
        }
    }

    public List<Roba> pronadjuSvuRobuPoPretrazi(final String searchTerm) {
        return robaRepository.findByKatbrContainingOrKatbrproContaining(searchTerm, searchTerm);
    }

    public List<Roba> pronadjuSvuRobuPodGrupomId(final List<Integer> podGrupeId) {
        return robaRepository.findByPodgrupaidIn(podGrupeId);
    }

    public List<Roba> pronadjuSvuRobuPoGrupiId(final List<String> GrupeId) {
        return robaRepository.findByGrupaidIn(GrupeId);
    }

    public List<Roba> pronadjuSvuRobuPoGrupiIdNaStanju(final List<String> grupeId) {
        return robaRepository.findByGrupaidInAndStanjeGreaterThan(grupeId, 0);
    }

    public List<Roba> pronadjiRobuPoKatBrojevima(final List<String> katBrojevi) {
        return robaRepository.findByKatbrIn(katBrojevi);
    }

    public Page<Roba> pronadjiRobuPoKljucevima(final Set<Long> ids, final String proizvdojacId, final Boolean naStanju, final Pageable pageable) {
        final Page<Roba> retVal;
        if (naStanju == false) {
            retVal = pronadjiSvuRobu(ids, proizvdojacId, pageable);
        } else {
            retVal = pronadjiSvuRobuNaStanju(ids, proizvdojacId, pageable);
        }
        return retVal;
    }

    public Page<Roba> pronadjiRobuPoKljucevimaIPodGrupi(final Set<Long> ids, final List<Integer> podGrupe, final String proizvdojacId, final Boolean naStanju, final Pageable pageable) {
        final Page<Roba> retVal;
        if (naStanju == false) {
            retVal = pronadjiSvuRobuPodGrupe(ids, podGrupe, proizvdojacId, pageable);
        } else {
            retVal = pronadjiSvuRobuNaStanjuPodGrupe(ids, podGrupe, proizvdojacId, pageable);
        }
        return retVal;
    }

    public Page<Roba> pronadjiRobuPoKljucevimaIGrupiId(final Set<Long> ids, final List<String> grupeId, final String proizvdojacId, final Boolean naStanju, final Pageable pageable) {
        final Page<Roba> retVal;
        if (naStanju == false) {
            retVal = pronadjiSvuRobuGrupeId(ids, grupeId, proizvdojacId, pageable);
        } else {
            retVal = pronadjiSvuRobuNaStanjuGrupeId(ids, grupeId, proizvdojacId, pageable);
        }
        return retVal;
    }

    public Page<Roba> pronadjiSvuRobuPoPodGrupiIdNaStanju(final List<Integer> podGrupaId, final Pageable pageable) {
        return robaRepository.findByPodgrupaidInAndStanjeGreaterThan(podGrupaId, 0, pageable);
    }

    public Page<Roba> pronadjiSvuRobuPoPodGrupiId(final List<Integer> podGrupaId, final Pageable pageable) {
        return robaRepository.findByPodgrupaidInAndStanjeGreaterThan(podGrupaId, -1, pageable);
    }

    public List<Roba> pronadjiSvuRobuPoPodGrupiIdLista(final List<Integer> podGrupaId) {
        return robaRepository.findByPodgrupaidInAndStanjeGreaterThan(podGrupaId, 0);
    }


    public Page<Roba> pronadjiSvuRobuPoGrupiIdNaStanju(final List<String> grupaId, final Pageable pageable) {
        return robaRepository.findByGrupaidInAndStanjeGreaterThan(grupaId, 0, pageable);
    }

    public Page<Roba> pronadjiSvuRobuPoGrupiId(final List<String> grupaId, final Pageable pageable) {
        return robaRepository.findByGrupaidInAndStanjeGreaterThan(grupaId, -1, pageable);
    }

    private Page<Roba> pronadjiSvuRobuNaStanju(final Set<Long> ids, final String filterProizvodjac, final Pageable pageable) {
        if (filterProizvodjac != null) {
            return robaRepository.findByRobaidInAndStanjeGreaterThanAndProid(ids, 0, filterProizvodjac, pageable);
        } else {
            return robaRepository.findByRobaidInAndStanjeGreaterThan(ids, 0, pageable);
        }
    }


    private Page<Roba> pronadjiSvuRobuNaStanjuGrupeId(final Set<Long> ids, final List<String> grupeId, final String proizvdojacId, final Pageable pageable) {
        if (proizvdojacId != null) {
            return robaRepository.findByRobaidInAndProidAndGrupaidInAndStanjeGreaterThan(ids, proizvdojacId, grupeId, 0, pageable);
        } else {
            return robaRepository.findByRobaidInAndGrupaidInAndStanjeGreaterThan(ids, grupeId, 0, pageable);
        }
    }

    private Page<Roba> pronadjiSvuRobuGrupeId(final Set<Long> ids, final List<String> grupeId, final String proizvdojacId, final Pageable pageable) {
        if (proizvdojacId != null) {
            return robaRepository.findByRobaidInAndProidAndGrupaidIn(ids, proizvdojacId, grupeId, pageable);
        } else {
            return robaRepository.findByRobaidInAndGrupaidIn(ids, grupeId, pageable);
        }
    }

    private Page<Roba> pronadjiSvuRobuNaStanjuPodGrupe(final Set<Long> ids, final List<Integer> podGrupe, final String proizvdojacId, final Pageable pageable) {
        if (proizvdojacId != null) {
            return robaRepository.findByRobaidInAndProidAndPodgrupaidInAndStanjeGreaterThan(ids, proizvdojacId, podGrupe, 0, pageable);
        } else {
            return robaRepository.findByRobaidInAndPodgrupaidInAndStanjeGreaterThan(ids, podGrupe, 0, pageable);
        }
    }

    private Page<Roba> pronadjiSvuRobuPodGrupe(final Set<Long> ids, final List<Integer> podGrupe, final String proizvdojacId, final Pageable pageable) {
        if (proizvdojacId != null) {
            return robaRepository.findByRobaidInAndProidAndPodgrupaidIn(ids, proizvdojacId, podGrupe, pageable);
        } else {
            return robaRepository.findByRobaidInAndPodgrupaidIn(ids, podGrupe, pageable);
        }
    }

    private Page<Roba> pronadjiSvuRobu(final Set<Long> ids, final String filterProizvodjac, final Pageable pageable) {
        if (filterProizvodjac != null) {
            return robaRepository.findByRobaidInAndProid(ids, filterProizvodjac, pageable);
        } else {
            return robaRepository.findByRobaidIn(ids, pageable);
        }
    }
}
