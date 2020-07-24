package com.aapeliltd.latecommerapp.v1.backend.controller;

import com.aapeliltd.latecommerapp.v1.backend.model.Resumption;
import com.aapeliltd.latecommerapp.v1.backend.service.ResumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/latecommer/v1/resumptions")
public class ResumptionController {

    @Autowired
    private ResumptionService resumptionService;

    @GetMapping
    public ResponseEntity<List<Resumption>> getAllResumptions() {
        List<Resumption> resumptions = resumptionService.getResumptions();
        return new ResponseEntity<>(resumptions, HttpStatus.OK);
    }
}
