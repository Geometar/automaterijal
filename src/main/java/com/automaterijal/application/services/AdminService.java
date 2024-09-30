package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.PartnerLogovanjeDto;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class AdminService {

    @NonNull
    final PartnerService partnerService;

    public Page<PartnerLogovanjeDto> vratiLogovanjePartnera(Integer page, Integer pageSize) {
        return partnerService.vratiLogovanjePartnera(page, pageSize);
    }
}
