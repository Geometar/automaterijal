package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.entity.roba.RobaOpis;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.repository.roba.RobaTehnickiOpisRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RobaTehnickiOpisServis {

    @NonNull
    RobaTehnickiOpisRepository repository;

    @NonNull
    RobaMapper mapper;

    public List<RobaTehnickiOpisDto> vratiTehnickiOpisPoIdRobe(Long robaId) {
        List<RobaOpis> tehnickiOpisi = repository.findByRobaId(robaId);
        tehnickiOpisi.forEach(robaOpis -> {
            if ((robaOpis.getJedinica() == null || robaOpis.getJedinica().trim().isEmpty()) && (robaOpis.getOznaka() == null || robaOpis.getOznaka().trim().isEmpty())) {
                robaOpis.setOznaka(robaOpis.getVrednost());
                robaOpis.setVrednost(null);
            }
        });
        return mapper.map(tehnickiOpisi);
    }
}
