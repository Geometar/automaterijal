package com.automaterijal.application.domain.repository.tecdoc;

import com.automaterijal.application.domain.entity.tecdoc.TecDocBrands;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecDocBrandsRepository extends JpaRepository<TecDocBrands, String> {
  Optional<TecDocBrands> findFirstByBrandId(Long brandId);
}
