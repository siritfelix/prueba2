package com.challenge.prueba2.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.challenge.prueba2.dto.adapterJpa.IEmployeeMaxSalaryGroupDepartamentDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMaxSalaryGroupDepartamentDto {

    private String departament;
    private Double maxSalary;
    private EmployeeDto employee;

    public static List<EmployeeMaxSalaryGroupDepartamentDto> convertToDto(
            List<IEmployeeMaxSalaryGroupDepartamentDto> iEmployeeMaxSalaryGroupDepartamentDtos) {
        ModelMapper modelMapper = new ModelMapper();
        return iEmployeeMaxSalaryGroupDepartamentDtos.stream()
                .map(result -> new EmployeeMaxSalaryGroupDepartamentDto(result.getDepartament(), result.getMaxSalary(),
                        modelMapper.map(result, EmployeeDto.class)))
                .collect(Collectors.toList());
    }

}
