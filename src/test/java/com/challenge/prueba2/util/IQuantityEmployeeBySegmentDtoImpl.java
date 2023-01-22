package com.challenge.prueba2.util;

import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentDto;

public class IQuantityEmployeeBySegmentDtoImpl implements IQuantityEmployeeBySegmentDto {

    @Override
    public Long getSegmentA() {
        return 10L;
    }

    @Override
    public Long getSegmentB() {
        return 20L;
    }

    @Override
    public Long getSegmentC() {
        return 30L;
    }

}
