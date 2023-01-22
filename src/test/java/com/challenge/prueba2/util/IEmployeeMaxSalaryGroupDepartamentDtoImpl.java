package com.challenge.prueba2.util;

import java.time.LocalDate;

import com.challenge.prueba2.dto.adapterJpa.IEmployeeMaxSalaryGroupDepartamentDto;

public class IEmployeeMaxSalaryGroupDepartamentDtoImpl implements IEmployeeMaxSalaryGroupDepartamentDto {

    @Override
    public String getDepartament() {
        return "Finance";
    }

    @Override
    public Double getMaxSalary() {
        return 2500.0;
    }

    @Override
    public Long getEmployeeId() {
        return 10L;
    }

    @Override
    public String getFirstName() {
        return "jhon";
    }

    @Override
    public String getLastName() {
        return "smith";
    }

    @Override
    public String getEmail() {
        return "mimail@mail.com";
    }

    @Override
    public String getPhoneNumber() {
        return "123456";
    }

    @Override
    public LocalDate getHireDate() {
        return LocalDate.now();
    }

    @Override
    public String getJobId() {
        return "JOB_DOC";
    }

    @Override
    public Double getSalary() {
        return 10.5;
    }

    @Override
    public Double getCommissionPct() {
        return 1.0;
    }

    @Override
    public Long getManagerId() {
        return 500L;
    }

}
