package com.automaterijal.application.services.security;

import com.automaterijal.application.domain.entity.Users;
import com.automaterijal.application.domain.repository.UsersRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UsersService {

    @NonNull
    final UsersRepository usersRepository;
    final

    public Optional<Users> pronadjiUseraPoIdu(final Integer id) {
        return usersRepository.findById(id);
    }

    @Transactional
    public void logovanomUseruPovecajKolikoSePutaLogovao(final Integer id) {
       final Optional<Users> users = pronadjiUseraPoIdu(id);
//       if(users.isPresent()) {
//           final Users user = users.get();
//           user.setLoginCount(user.getLoginCount() + 1);
//           user.setLastLogin(Timestamp.valueOf(LocalDateTime.now()));
//       }
    }
}
