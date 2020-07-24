package com.aapeliltd.latecommerapp.v1.backend.repository;

import com.aapeliltd.latecommerapp.v1.backend.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LatecommerRepository extends JpaRepository<Fee, Integer> {
}
