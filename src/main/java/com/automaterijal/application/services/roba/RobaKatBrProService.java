package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.domain.repository.RobaKatBrProRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaKatBrProService {

    @NonNull
    final RobaKatBrProRepository katBrProRepository;

    public List<RobaKatBrPro> pronadjiPoPretrazi(final String pretraga) {
        final Set<RobaKatBrPro> svaRoba = new HashSet<>();
        svaRoba.addAll(katBrProRepository.findByKatbrContainingOrKatbrproContaining(pretraga, pretraga));
        if(svaRoba.size() == 0) {
            final String searchTermWihoutWhiteSpaces = pretraga.replaceAll("\\s+","");
            svaRoba.addAll(katBrProRepository.findByKatbrContainingOrKatbrproContaining(searchTermWihoutWhiteSpaces, searchTermWihoutWhiteSpaces));
        }
        return new ArrayList<>(svaRoba);
    }

    public List<RobaKatBrPro> pronadjuKatBrProPoKataloskimBrojevima(final List<String> katBrPros) {
        return katBrProRepository.findByKatbrproIn(katBrPros);
    }

}
