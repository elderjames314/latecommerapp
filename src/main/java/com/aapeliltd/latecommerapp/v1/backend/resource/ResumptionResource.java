package com.aapeliltd.latecommerapp.v1.backend.resource;

import java.util.Date;

public class ResumptionResource {
    private Integer Id;
    private String clockIn;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getClockin() {
        return clockIn;
    }

    public void setClockin(String clockin) {
        this.clockIn = clockin;
    }
}
