package com.challenge.prueba2.dto.adapterJpa;

import java.time.LocalDate;

public interface IEmployeeMaxSalaryGroupDepartamentDto {
    public String getDepartament();

    public Double getMaxSalary();

    public Long getEmployeeId();

    public String getFirstName();

    public String getLastName();

    public String getEmail();

    public String getPhoneNumber();

    public LocalDate getHireDate();

    public String getJobId();

    public Double getSalary();

    public Double getCommissionPct();

    public Long getManagerId();    
}
