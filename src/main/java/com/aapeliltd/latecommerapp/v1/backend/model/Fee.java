package com.aapeliltd.latecommerapp.v1.backend.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Fee {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(name = "late_time_in_minute")
    private int lateCommingInMinute;
    private double amount;
    @OneToOne
    private Resumption resumption;
    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getLateCommingInMinute() {
        return lateCommingInMinute;
    }

    public void setLateCommingInMinute(int lateCommingInMinute) {
        this.lateCommingInMinute = lateCommingInMinute;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Resumption getResumption() {
        return resumption;
    }

    public void setResumption(Resumption resumption) {
        this.resumption = resumption;
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
}
