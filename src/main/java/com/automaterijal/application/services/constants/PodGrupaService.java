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

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PodGrupaService {

    @NonNull
    final PodGrupaRepository podGrupaRepository;

    List<PodGrupa> podGrupe;

    public void pronadjiSvePodGrupe() {
        podGrupe = podGrupaRepository.findAll();
    }

    public String vratiNazivPodGrupe(final int podGrupaId, final String grupaId) {
        String retVal = null;
        final Optional<String> naziv = podGrupe.stream()
                .filter(podGrupa -> podGrupa.getGrupaId().equals(grupaId) && podGrupa.getPodGrupaId() == podGrupaId)
                .map(PodGrupa::getNaziv)
                .findFirst();
        if(naziv.isPresent()) {
            retVal = naziv.get();
        }
        return retVal;
    }
}
