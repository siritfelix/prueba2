package com.challenge.prueba2.util;

import com.challenge.prueba2.dto.adapterJpa.IAverageSalaryMore10EmployeesByDepartamentDto;

public class IAverageSalaryMore10EmployeesByDepartamentDtoImpl
        implements IAverageSalaryMore10EmployeesByDepartamentDto {

    @Override
    public String getDepartament() {
        return "IT";
    }

    @Override
    public Double getAvgSalary() {
        return 5800.0;
    }

    @Override
    public Long getQuantity() {

        return 10L;
    }

}
