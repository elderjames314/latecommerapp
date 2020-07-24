package com.aapeliltd.latecommerapp.v1.backend.repository;

import com.aapeliltd.latecommerapp.v1.backend.model.Resumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumptionRepository extends JpaRepository<Resumption, Integer> {

}
