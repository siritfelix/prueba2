package com.challenge.prueba2.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.challenge.prueba2.dto.EmployeeDto;
import com.challenge.prueba2.dto.EmployeeMaxSalaryGroupDepartamentDto;
import com.challenge.prueba2.dto.SegmentDto;
import com.challenge.prueba2.dto.adapterJpa.IAverageSalaryMore10EmployeesByDepartamentDto;
import com.challenge.prueba2.dto.adapterJpa.IGeneralInfoDto;
import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentDto;

public interface CompanyService {

    public ResponseEntity<IQuantityEmployeeBySegmentDto> getEmployeeBySegment();

    public ResponseEntity<Map<String, SegmentDto>> getEmployeeBySegmentGroupByDepartament();

    public ResponseEntity<List<EmployeeMaxSalaryGroupDepartamentDto>> getEmployeeMaxSalaryGroupDepartamentDto();

    public ResponseEntity<List<EmployeeDto>> getEmployeeManager15Year();

    public ResponseEntity<List<IAverageSalaryMore10EmployeesByDepartamentDto>> getAverageSalaryMore10EmployeesByDepartament();

    public ResponseEntity<List<IGeneralInfoDto>> getGeneralnfoDto();
}
