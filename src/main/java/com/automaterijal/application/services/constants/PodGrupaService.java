package com.automaterijal.application.services.constants;

import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.repository.PodGrupaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PodGrupaService {

    @NonNull
    final PodGrupaRepository podGrupaRepository;

    public List<PodGrupa> pronadjiSvePodGrupe() {
       return podGrupaRepository.findAll();
    }

    public String vratiNazivPodGrupe(final int podGrupaId, final String grupaId) {
        String retVal = null;
        final Optional<String> naziv = pronadjiSvePodGrupe().stream()
                .filter(podGrupa -> podGrupa.getGrupaId().equals(grupaId) && podGrupa.getPodGrupaId() == podGrupaId)
                .map(PodGrupa::getNaziv)
                .findFirst();
        if (naziv.isPresent()) {
            retVal = naziv.get();
        }
        return retVal;
    }

    public List<Integer> vratiSvePodGrupeIdPoNazivu(final String naziv) {
        return pronadjiSvePodGrupe().stream()
                .filter(podGrupa -> podGrupa.getNaziv().equals(naziv))
                .map(PodGrupa::getPodGrupaId)
                .collect(Collectors.toList());
    }
}
