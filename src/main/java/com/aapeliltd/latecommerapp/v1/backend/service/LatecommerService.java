package com.aapeliltd.latecommerapp.v1.backend.service;

import com.aapeliltd.latecommerapp.v1.backend.model.Fee;
import com.aapeliltd.latecommerapp.v1.backend.repository.LatecommerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LatecommerService {

    @Autowired
    private LatecommerRepository latecommerRepository;

    public void saveLateFee(Fee fee) {
        latecommerRepository.save(fee);
    }
}
