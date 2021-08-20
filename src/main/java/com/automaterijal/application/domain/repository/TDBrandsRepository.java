package com.automaterijal.application.domain.repository;

import com.automaterijal.application.domain.entity.TDBrands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TDBrandsRepository extends JpaRepository<TDBrands, Integer> {

    Optional<TDBrands> findByProid(String proid);
}
