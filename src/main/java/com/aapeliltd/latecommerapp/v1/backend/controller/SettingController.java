package com.aapeliltd.latecommerapp.v1.backend.controller;

import com.aapeliltd.latecommerapp.v1.backend.model.Setting;
import com.aapeliltd.latecommerapp.v1.backend.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/latecommer/v1/settings")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @GetMapping
    public ResponseEntity<Setting> getSettings() {
        Setting setting = settingService.getSettingById(1);
        if(setting != null) {
            return new ResponseEntity<>(setting, HttpStatus.OK);
        }else
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
