package com.automaterijal.application.integration.providers.szakal;

import com.automaterijal.application.integration.providers.szakal.model.SzakalMasterProduct;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SzakalMasterProductRepository extends JpaRepository<SzakalMasterProduct, String> {
  List<SzakalMasterProduct> findByTecdocDlnrAndTecdocArtnrNormIn(
      Long tecdocDlnr, Collection<String> tecdocArtnrNorm);
}
