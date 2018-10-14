package com.automaterijal.application.services;

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
import java.util.Set;

@Service
@TransactionScoped
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaService {

    @NonNull
    final RobaRepository robaRepository;

    public List<Roba> pronadjuSvuRobuPoPretrazi(final String searchTerm) {
        return robaRepository.findByKatbrContainingOrKatbrproContaining(searchTerm, searchTerm);
    }

    public List<Roba> pronadjiRobuPoKatBrojevima(final List<String> katBrojevi) {
        return robaRepository.findByKatbrIn(katBrojevi);
    }

    public Page<Roba> pronadjiRobuPoKljucevima(final Set<Long> ids, final String filterProizvodjac, final Boolean filterRaspolozivostfinal, final Pageable pageable) {
        final Page<Roba> retVal;
        if(filterRaspolozivostfinal == true) {
            retVal = pronadjiSvuRobu(ids, filterProizvodjac, pageable);
        } else {
            retVal = pronadjiSvuRobuNaStanju(ids, filterProizvodjac, pageable);
        }
        return retVal;
    }

    private Page<Roba> pronadjiSvuRobuNaStanju(final Set<Long> ids, final String filterProizvodjac, final Pageable pageable) {
        if(filterProizvodjac!=null) {
            return robaRepository.findByRobaidInAndStanjeGreaterThanAndProid(ids, 0, filterProizvodjac, pageable);
        } else {
            return robaRepository.findByRobaidInAndStanjeGreaterThan(ids, 0, pageable);
        }
    }

    private Page<Roba> pronadjiSvuRobu(final Set<Long> ids, final String filterProizvodjac, final Pageable pageable) {
        if(filterProizvodjac!=null) {
            return robaRepository.findByRobaidInAndProid(ids, filterProizvodjac, pageable);
        } else {
            return robaRepository.findByRobaidIn(ids,   pageable);
        }
    }
}
