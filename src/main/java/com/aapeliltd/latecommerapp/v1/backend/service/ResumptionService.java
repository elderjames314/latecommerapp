package com.aapeliltd.latecommerapp.v1.backend.service;

import com.aapeliltd.latecommerapp.v1.backend.model.Employee;
import com.aapeliltd.latecommerapp.v1.backend.model.Fee;
import com.aapeliltd.latecommerapp.v1.backend.model.Resumption;
import com.aapeliltd.latecommerapp.v1.backend.model.Setting;
import com.aapeliltd.latecommerapp.v1.backend.repository.ResumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumptionService {
    @Autowired
    private ResumptionRepository resumptionRepository;

    @Autowired
    private SettingService settingService;

    @Autowired
    private LatecommerService latecommerService;

    public List<Resumption> getResumptions() {
        return resumptionRepository.findAll();
    }

    public String employeeClockIn(Employee employee, Resumption resumption) {
        //we will have one setting
        //can be updated regulary like changing late fees or late comming time...
        Setting  setting = settingService.getSettingById(1);

        if(setting == null)
            return "You will need to update setting first like late fee and late time";

        //add employee to resumption
        resumption.setEmployee(employee);
        //set resumption to employee

        employee.getResumptions().add(resumption);

        //save resumption
        resumptionRepository.save(resumption);

        Fee fee = new Fee();

        //check if this employee is late
        if(resumption.getClockIn().after(setting.getThresholdTime())) {
            //employee is late
            //update late fees

            long diffInSecond = resumption.getClockIn().getTime() - setting.getThresholdTime().getTime();
            diffInSecond = diffInSecond/1000;
            int diffInMinutes = (int) diffInSecond / 60;
            fee.setLateCommingInMinute(diffInMinutes);
            double amount = diffInMinutes * setting.getLateFee();

            fee.setAmount(amount);

            fee.setResumption(resumption);

            resumption.setLatecommer(fee);

            latecommerService.saveLateFee(fee);

        }



        return "Employee clocked in successfully";

    }


}
