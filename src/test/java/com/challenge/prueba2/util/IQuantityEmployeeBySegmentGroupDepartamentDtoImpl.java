package com.challenge.prueba2.util;

import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentGroupDepartamentDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IQuantityEmployeeBySegmentGroupDepartamentDtoImpl
        implements IQuantityEmployeeBySegmentGroupDepartamentDto {

    private String departament;
    private Long quantity;

    @Override
    public String getDepartament() {
        return this.departament;
    }

    @Override
    public Long getQuantity() {
        return this.quantity;
    }

}
