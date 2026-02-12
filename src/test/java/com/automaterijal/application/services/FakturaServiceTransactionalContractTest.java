package com.automaterijal.application.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.exception.CheckoutConflictException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

class FakturaServiceTransactionalContractTest {

  @Test
  void submitMustRollbackOnCheckoutConflict() throws NoSuchMethodException {
    Method method =
        FakturaService.class.getMethod("submitujFakturu", FakturaDto.class, Partner.class);
    Transactional transactional = method.getAnnotation(Transactional.class);

    assertThat(transactional).isNotNull();
    assertThat(Arrays.asList(transactional.noRollbackFor()))
        .doesNotContain(CheckoutConflictException.class);
  }
}
