package com.aapeliltd.latecommerapp.v1.backend.service;

import com.aapeliltd.latecommerapp.v1.backend.model.Setting;
import com.aapeliltd.latecommerapp.v1.backend.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    public void addSetting(Setting setting) {
        settingRepository.save(setting);
    }

    public Setting getSettingById(int id) {
        Optional<Setting> setting =  settingRepository.findById(id);
        return setting.get();
    }

}
