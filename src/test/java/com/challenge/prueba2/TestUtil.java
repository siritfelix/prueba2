package com.challenge.prueba2;

import java.util.ArrayList;
import java.util.List;

import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentGroupDepartamentDto;
import com.challenge.prueba2.util.IQuantityEmployeeBySegmentGroupDepartamentDtoImpl;

public class TestUtil {
        public static List<IQuantityEmployeeBySegmentGroupDepartamentDto> buildIQuantityEmployeeBySegmentGroupDepartamentDtosImplA() {
                List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentGroupDepartamentDtoImpls = new ArrayList<>();
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("IT", 3L));
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("Shipping", 3L));
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("Purchasing", 5L));
                return iQuantityEmployeeBySegmentGroupDepartamentDtoImpls;

        }

        public static List<IQuantityEmployeeBySegmentGroupDepartamentDto> buildIQuantityEmployeeBySegmentGroupDepartamentDtosImplB() {
                List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentGroupDepartamentDtoImpls = new ArrayList<>();
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("IT", 3L));
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("Administration", 10L));
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("Sales", 4L));
                return iQuantityEmployeeBySegmentGroupDepartamentDtoImpls;
        }

        public static List<IQuantityEmployeeBySegmentGroupDepartamentDto> buildIQuantityEmployeeBySegmentGroupDepartamentDtosImplC() {
                List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentGroupDepartamentDtoImpls = new ArrayList<>();
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("IT", 3L));
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("Accounting", 7L));
                iQuantityEmployeeBySegmentGroupDepartamentDtoImpls
                                .add(new IQuantityEmployeeBySegmentGroupDepartamentDtoImpl("IT", 9L));
                return iQuantityEmployeeBySegmentGroupDepartamentDtoImpls;

        }
}
