package com.aapeliltd.latecommerapp.v1.backend.resource;

public class Account {
    private double lateInMinutes;
    private double fees;


    public double getLateInMinutes() {
        return lateInMinutes;
    }

    public void setLateInMinutes(double lateInMinutes) {
        this.lateInMinutes = lateInMinutes;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}
