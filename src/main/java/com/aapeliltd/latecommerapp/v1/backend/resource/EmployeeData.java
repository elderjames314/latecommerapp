package com.aapeliltd.latecommerapp.v1.backend.resource;

import java.util.List;

public class EmployeeData {
    private int totalPages;
    private List<EmployeeResource> employeeResources;

    public List<EmployeeResource> getEmployeeResources() {
        return employeeResources;
    }

    public void setEmployeeResources(List<EmployeeResource> employeeResources) {
        this.employeeResources = employeeResources;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
