package com.automaterijal.application.services.security;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Users;
import com.automaterijal.application.domain.mapper.UsersMapper;
import com.automaterijal.application.domain.repository.UsersRepository;
import com.automaterijal.application.utils.LoginStaticUtils;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UsersService {

  @NonNull
  final UsersRepository usersRepository;

  @NonNull
  final UsersMapper mapper;

  public Optional<Users> pronadjiUseraPoIdu(final Integer id) {
    return usersRepository.findById(id);
  }

  public void logovanomUseruPovecajKolikoSePutaLogovao(final Integer id) {
    final Optional<Users> users = pronadjiUseraPoIdu(id);
    if (users.isPresent()) {
      final Users user = users.get();
      user.setLoginCount(user.getLoginCount() + 1);
      user.setLastLogin(Timestamp.valueOf(LocalDateTime.now()));
    }
  }

  public Users sacuvajUsera(final Partner partner) {
    final var users = mapper.map(partner);
    users.setPassword(LoginStaticUtils.md5Password(partner.getPpid().toString()));
    return usersRepository.save(users);
  }
}
