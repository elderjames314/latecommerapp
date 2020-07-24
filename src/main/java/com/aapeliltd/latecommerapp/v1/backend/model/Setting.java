package com.aapeliltd.latecommerapp.v1.backend.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Setting {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @DateTimeFormat(pattern="HH:mm:ss" )
    @Temporal(TemporalType.TIME)
    @Column(name = "threshold_time")
    private Date thresholdTime;
    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;
    @NotNull
    private double lateFee;

    public Setting() {

    }

    public Setting(Date thresholdTime, double lateFee) {
        this.thresholdTime = thresholdTime;
        this.lateFee = lateFee;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getThresholdTime() {
        return thresholdTime;
    }

    public void setThresholdTime(Date thresholdTime) {
        this.thresholdTime = thresholdTime;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }
}
