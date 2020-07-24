package com.aapeliltd.latecommerapp.v1.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Resumption {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @NotNull
    @DateTimeFormat(pattern="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    @Column(name = "clock_in")
    private Date clockIn;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @OneToOne
    private Fee latecommer;

    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;

    public Fee getLatecommer() {
        return latecommer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setLatecommer(Fee latecommer) {
        this.latecommer = latecommer;
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getClockIn() {
        return clockIn;
    }

    public void setClockIn(Date clockIn) {
        this.clockIn = clockIn;
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
