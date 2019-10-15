package com.automaterijal.application.services.roba.grupe;

import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.repository.PodGrupaRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PodGrupaService {

    @NonNull
    final PodGrupaRepository podGrupaRepository;

    public String vratiNazivPodGrupe(final int podGrupaId, final String grupaId) {
        String retVal = null;
        final Optional<PodGrupa> podGrupa = podGrupaRepository.findByPodGrupaIdAndGrupaId(podGrupaId, grupaId);
        if (podGrupa.isPresent()) {
            retVal = podGrupa.get().getNaziv();
        }
        return retVal;
    }

    public List<Integer> vratiSvePodGrupeIdPoNazivu(final String naziv) {
        return podGrupaRepository.findByNazivIn(naziv)
                .stream()
                .map(PodGrupa::getPodGrupaId)
                .collect(Collectors.toList());
    }

    public List<Integer> vratiSvePodGrupePoNazivima(final List<String> nazivi) {
        return podGrupaRepository.findByNazivIn(nazivi)
                .stream()
                .map(PodGrupa::getPodGrupaId)
                .collect(Collectors.toList());
    }
}
