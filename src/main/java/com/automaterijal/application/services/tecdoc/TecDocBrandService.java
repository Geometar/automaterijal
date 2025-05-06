package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import com.automaterijal.application.domain.repository.tecdoc.TecDocBrandsRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocBrandService {

  @NonNull TecDocBrandsRepository tecDocBrandsRepository;

  public Optional<TecDocBrands> findById(String proId) {
    return tecDocBrandsRepository.findById(proId);
  }
}
