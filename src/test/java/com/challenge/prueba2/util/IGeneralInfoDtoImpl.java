package com.challenge.prueba2.util;

import com.challenge.prueba2.dto.adapterJpa.IGeneralInfoDto;

public class IGeneralInfoDtoImpl implements IGeneralInfoDto {

    @Override
    public String getCountry() {
        return "Canada";
    }

    @Override
    public Long getQuantityEmployee() {
        return 99L;
    }

    @Override
    public Double getAvgSalary() {
        return 5800.0;
    }

    @Override
    public Double getMaxSalary() {
        return 5800.0;
    }

    @Override
    public Double getMinSalary() {
        return 5800.0;
    }

    @Override
    public Integer getAvgHireDate() {
        return 15;
    }

}
