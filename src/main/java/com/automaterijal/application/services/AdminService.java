package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.PartnerLogovanjeDto;
import com.automaterijal.application.domain.model.CurrentUser;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class AdminService {

    @NonNull
    final PartnerService partnerService;
    @NonNull
    final
    SessionRegistry sessionRegistry;

    public Page<PartnerLogovanjeDto> vratiLogovanjePartnera(Integer page, Integer pageSize) {
        return partnerService.vratiLogovanjePartnera(page, pageSize);
    }

    public List<String> uzmiKorisnikeIzSesije() {
        List<String> ulogovaniPartneri = new ArrayList<>();
        sessionRegistry.getAllPrincipals()
                .stream()
                .filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
                .forEach(o -> {
                    if (o instanceof CurrentUser) {
                        ulogovaniPartneri.add(((CurrentUser) o).vratiPartnera().getMestaIsporuke().getNaziv());
                    }
                });
        return ulogovaniPartneri;
    }
}
