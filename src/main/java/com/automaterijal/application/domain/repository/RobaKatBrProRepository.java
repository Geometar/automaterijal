package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.RobaKatBrPro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RobaKatBrProRepository extends JpaRepository<RobaKatBrPro, Long> {

    List<RobaKatBrPro> findByKatbrContainingOrKatbrproContaining(String katBr, String katBrPr);
    List<RobaKatBrPro> findByKatbrproIn(List<String> katBrPr);


}
