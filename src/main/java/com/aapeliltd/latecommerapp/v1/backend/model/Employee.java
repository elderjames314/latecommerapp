package com.aapeliltd.latecommerapp.v1.backend.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String address;
    @CreationTimestamp
    private Date created_at;
    @CreationTimestamp
    private Date updated_at;
    @OneToMany(mappedBy = "employee")
    private List<Resumption> resumptions;

    public List<Resumption> getResumptions() {
        return resumptions;
    }

    public void setResumptions(List<Resumption> resumptions) {
        this.resumptions = resumptions;
    }

    public Employee(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Employee() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
