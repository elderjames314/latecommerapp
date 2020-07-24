package com.aapeliltd.latecommerapp.v1.backend.resource;

public class EmployeeResource {
    private int id;
    private String name;
    private String email;
    private String address;
    private double minutes;
    private double fee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
