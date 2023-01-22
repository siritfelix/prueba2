package com.challenge.prueba2.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.challenge.prueba2.dto.EmployeeDto;
import com.challenge.prueba2.dto.EmployeeMaxSalaryGroupDepartamentDto;
import com.challenge.prueba2.dto.SegmentDto;
import com.challenge.prueba2.dto.adapterJpa.IAverageSalaryMore10EmployeesByDepartamentDto;
import com.challenge.prueba2.dto.adapterJpa.IEmployeeMaxSalaryGroupDepartamentDto;
import com.challenge.prueba2.dto.adapterJpa.IGeneralInfoDto;
import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentDto;
import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentGroupDepartamentDto;
import com.challenge.prueba2.repository.EmployeeRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompanyServiceImpl implements CompanyService {
    private EmployeeRepository employeeRepository;

    public CompanyServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<IQuantityEmployeeBySegmentDto> getEmployeeBySegment() {
        return new ResponseEntity<>(employeeRepository
                .getEmployeeBySegmentGroupByDepartament(),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, SegmentDto>> getEmployeeBySegmentGroupByDepartament() {
        List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentAGroupDepartamentDto = employeeRepository
                .getEmployeeBySegmentAGroupByDepartament();
        List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentBGroupDepartamentDto = employeeRepository
                .getEmployeeBySegmentBGroupByDepartament();
        List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentCGroupDepartamentDto = employeeRepository
                .getEmployeeBySegmentCGroupByDepartament();
        log.info(iQuantityEmployeeBySegmentAGroupDepartamentDto.size());
        Map<String, SegmentDto> mapDepartament = new HashMap<>();
        iQuantityEmployeeBySegmentAGroupDepartamentDto.forEach(
                result -> {
                    if (Objects.isNull(mapDepartament.get(result.getDepartament()))) {
                        mapDepartament.put(result.getDepartament(), new SegmentDto(result.getQuantity(), 0L, 0L));
                    } else {
                        mapDepartament.get(result.getDepartament()).setSegmentA(
                                mapDepartament.get(result.getDepartament()).getSegmentA() + result.getQuantity());
                    }
                });
        iQuantityEmployeeBySegmentBGroupDepartamentDto.forEach(
                result -> {
                    if (Objects.isNull(mapDepartament.get(result.getDepartament()))) {
                        mapDepartament.put(result.getDepartament(), new SegmentDto(0L, result.getQuantity(), 0L));
                    } else {
                        mapDepartament.get(result.getDepartament()).setSegmentB(
                                mapDepartament.get(result.getDepartament()).getSegmentB() + result.getQuantity());
                    }
                });
        iQuantityEmployeeBySegmentCGroupDepartamentDto.forEach(
                result -> {
                    if (Objects.isNull(mapDepartament.get(result.getDepartament()))) {
                        mapDepartament.put(result.getDepartament(), new SegmentDto(0L, 0L, result.getQuantity()));
                    } else {
                        mapDepartament.get(result.getDepartament()).setSegmentC(
                                mapDepartament.get(result.getDepartament()).getSegmentC() + result.getQuantity());
                    }
                });
        return new ResponseEntity<>(mapDepartament, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<EmployeeMaxSalaryGroupDepartamentDto>> getEmployeeMaxSalaryGroupDepartamentDto() {

        List<IEmployeeMaxSalaryGroupDepartamentDto> iEmployeeMaxSalaryGroupDepartamentDtos = employeeRepository
                .getEmployeeMaxSalaryGroupDepartamentDto();
        Map<String, EmployeeMaxSalaryGroupDepartamentDto> mapEmployee = new HashMap<>();

        List<EmployeeMaxSalaryGroupDepartamentDto> employeeMaxSalaryGroupDepartamentDtos = EmployeeMaxSalaryGroupDepartamentDto
                .convertToDto(iEmployeeMaxSalaryGroupDepartamentDtos);
        employeeMaxSalaryGroupDepartamentDtos.forEach(result -> {
            if (Objects.isNull(mapEmployee.get(result.getDepartament()))) {
                mapEmployee.put(result.getDepartament(), result);
            } else {
                if (result.getMaxSalary() > mapEmployee.get(result.getDepartament()).getMaxSalary()) {
                    mapEmployee.put(result.getDepartament(), result);
                }

            }
        });
        return new ResponseEntity<>(new ArrayList<>(mapEmployee.values()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> getEmployeeManager15Year() {
        ModelMapper modelMapper = new ModelMapper();
        List<EmployeeDto> employeeDtos = employeeRepository.getEmployeeManager15Year().stream()
                .map(result -> modelMapper.map(result, EmployeeDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<IAverageSalaryMore10EmployeesByDepartamentDto>> getAverageSalaryMore10EmployeesByDepartament() {
        return new ResponseEntity<>(employeeRepository.getAverageSalaryMore10EmployeesByDepartament(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<IGeneralInfoDto>> getGeneralnfoDto() {
        return new ResponseEntity<>(employeeRepository.getGeneralnfoDto(), HttpStatus.OK);
    }
}
