package com.challenge.prueba2.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.prueba2.dto.EmployeeDto;
import com.challenge.prueba2.dto.EmployeeMaxSalaryGroupDepartamentDto;
import com.challenge.prueba2.dto.SegmentDto;
import com.challenge.prueba2.dto.adapterJpa.IAverageSalaryMore10EmployeesByDepartamentDto;
import com.challenge.prueba2.dto.adapterJpa.IGeneralInfoDto;
import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentDto;
import com.challenge.prueba2.services.CompanyService;

@RestController
@RequestMapping(CompanyController.URI)
public class CompanyController {
    public static final String URI = "/api/v1";
    public static final String RESOURCE = "/employee";
    public static final String BY_SEGMENT = "/segment";
    public static final String GROUP_DEPARTAMENT = "/group-departament";
    public static final String SALARY = "/salary";
    public static final String OLD_15 = "/old-15";
    public static final String MORE_THAN_10 = "/more-than-10";
    public static final String GENERAL_INFO = "/general-info";

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(RESOURCE + BY_SEGMENT)
    public ResponseEntity<IQuantityEmployeeBySegmentDto> getEmployeeBySegment() {
        return companyService.getEmployeeBySegment();
    }

    @GetMapping(RESOURCE + BY_SEGMENT + GROUP_DEPARTAMENT)
    public ResponseEntity<Map<String, SegmentDto>> getEmployeeBySegmentGroupByDepartament() {
        return companyService.getEmployeeBySegmentGroupByDepartament();
    }

    @GetMapping(RESOURCE + SALARY + GROUP_DEPARTAMENT)
    public ResponseEntity<List<EmployeeMaxSalaryGroupDepartamentDto>> getEmployeeMaxSalaryGroupDepartamentDto() {
        return companyService.getEmployeeMaxSalaryGroupDepartamentDto();
    }

    @GetMapping(RESOURCE + OLD_15)
    public ResponseEntity<List<EmployeeDto>> getEmployeeManager15Year() {
        return companyService.getEmployeeManager15Year();
    }

    @GetMapping(RESOURCE + SALARY + MORE_THAN_10)
    public ResponseEntity<List<IAverageSalaryMore10EmployeesByDepartamentDto>> getAverageSalaryMore10EmployeesByDepartament() {
        return companyService.getAverageSalaryMore10EmployeesByDepartament();
    }

    @GetMapping(RESOURCE + GENERAL_INFO)
    public ResponseEntity<List<IGeneralInfoDto>> getGeneralnfoDto() {
        return companyService.getGeneralnfoDto();
    }

}
