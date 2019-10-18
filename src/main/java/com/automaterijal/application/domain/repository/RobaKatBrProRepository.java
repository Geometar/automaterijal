package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.RobaKatBrPro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RobaKatBrProRepository extends JpaRepository<RobaKatBrPro, Long> {

    List<RobaKatBrPro> findByKatbrContainingOrKatbrproContainingOrKatbrContainingOrKatbrproContaining(String katBr, String katBrPr, String katBrNoSpace, String katBrPrNoSpace);

}
