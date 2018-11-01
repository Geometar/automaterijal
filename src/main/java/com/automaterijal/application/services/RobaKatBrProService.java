package com.automaterijal.application.services;

import com.automaterijal.application.domain.entity.RobaKatBrPro;
import com.automaterijal.application.domain.repository.RobaKatBrProRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaKatBrProService {

    @NonNull
    final RobaKatBrProRepository katBrProRepository;

    public List<RobaKatBrPro> pronadjiSve() {
        return katBrProRepository.findAll();
    }

    public List<RobaKatBrPro> pronadjiPoPretrazi(final String pretraga) {
        return katBrProRepository.findByKatbrContainingOrKatbrproContaining(pretraga, pretraga);
    }

    public List<RobaKatBrPro> pronadjiPoPretraziUPodGrupi(final String pretraga) {
        return katBrProRepository.findByKatbrContainingOrKatbrproContaining(pretraga, pretraga);
    }

    public List<RobaKatBrPro> pronadjuKatBrProPoKataloskimBrojevima(final List<String> katBrPros) {
        return katBrProRepository.findByKatbrproIn(katBrPros);
    }

}
