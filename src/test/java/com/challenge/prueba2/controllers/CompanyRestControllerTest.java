package com.challenge.prueba2.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.challenge.prueba2.TestUtil;
import com.challenge.prueba2.dto.adapterJpa.IAverageSalaryMore10EmployeesByDepartamentDto;
import com.challenge.prueba2.dto.adapterJpa.IEmployeeMaxSalaryGroupDepartamentDto;
import com.challenge.prueba2.dto.adapterJpa.IGeneralInfoDto;
import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentDto;
import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentGroupDepartamentDto;
import com.challenge.prueba2.repository.EmployeeRepository;
import com.challenge.prueba2.services.CompanyService;
import com.challenge.prueba2.util.IAverageSalaryMore10EmployeesByDepartamentDtoImpl;
import com.challenge.prueba2.util.IEmployeeMaxSalaryGroupDepartamentDtoImpl;
import com.challenge.prueba2.util.IGeneralInfoDtoImpl;
import com.challenge.prueba2.util.IQuantityEmployeeBySegmentDtoImpl;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@ActiveProfiles(profiles = "test")
public class CompanyRestControllerTest {

        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private CompanyService companyService;
        @MockBean
        private EmployeeRepository employeeRepository;

        @BeforeEach
        public void load() {
                IQuantityEmployeeBySegmentDto iQuantityEmployeeBySegmentDto = new IQuantityEmployeeBySegmentDtoImpl();
                List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentGroupDepartamentDtosA = TestUtil
                                .buildIQuantityEmployeeBySegmentGroupDepartamentDtosImplA();
                List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentGroupDepartamentDtosB = TestUtil
                                .buildIQuantityEmployeeBySegmentGroupDepartamentDtosImplB();
                List<IQuantityEmployeeBySegmentGroupDepartamentDto> iQuantityEmployeeBySegmentGroupDepartamentDtosC = TestUtil
                                .buildIQuantityEmployeeBySegmentGroupDepartamentDtosImplC();
                List<IEmployeeMaxSalaryGroupDepartamentDto> iEmployeeMaxSalaryGroupDepartamentDtos = new ArrayList<>();
                iEmployeeMaxSalaryGroupDepartamentDtos.add(new IEmployeeMaxSalaryGroupDepartamentDtoImpl());
                iEmployeeMaxSalaryGroupDepartamentDtos.add(new IEmployeeMaxSalaryGroupDepartamentDtoImpl());
                List<IAverageSalaryMore10EmployeesByDepartamentDto> iAverageSalaryMore10EmployeesByDepartamentDtos = new ArrayList<>();
                iAverageSalaryMore10EmployeesByDepartamentDtos
                                .add(new IAverageSalaryMore10EmployeesByDepartamentDtoImpl());
                List<IGeneralInfoDto> iGeneralInfoDtos = new ArrayList<>();
                iGeneralInfoDtos.add(new IGeneralInfoDtoImpl());
                when(employeeRepository.getEmployeeBySegmentGroupByDepartament())
                                .thenReturn(iQuantityEmployeeBySegmentDto);
                when(employeeRepository.getEmployeeBySegmentAGroupByDepartament())
                                .thenReturn(iQuantityEmployeeBySegmentGroupDepartamentDtosA);
                when(employeeRepository.getEmployeeBySegmentBGroupByDepartament())
                                .thenReturn(iQuantityEmployeeBySegmentGroupDepartamentDtosB);
                when(employeeRepository.getEmployeeBySegmentCGroupByDepartament())
                                .thenReturn(iQuantityEmployeeBySegmentGroupDepartamentDtosC);
                when(employeeRepository.getEmployeeMaxSalaryGroupDepartamentDto())
                                .thenReturn(iEmployeeMaxSalaryGroupDepartamentDtos);
                when(employeeRepository.getEmployeeManager15Year()).thenReturn(iEmployeeMaxSalaryGroupDepartamentDtos);
                when(employeeRepository.getAverageSalaryMore10EmployeesByDepartament())
                                .thenReturn(iAverageSalaryMore10EmployeesByDepartamentDtos);
                when(employeeRepository.getGeneralnfoDto()).thenReturn(iGeneralInfoDtos);

        }

    @Test
    public void Exepcion() throws Exception {

        when(companyService.getEmployeeBySegment()).thenThrow(new InternalError());
        this.mockMvc.perform(get(CompanyController.URI + CompanyController.RESOURCE+CompanyController.BY_SEGMENT)).andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje", Matchers.is("Error Interno del servidor")));
    }

        @Test
        public void getEmployeeBySegment() throws Exception {
                this.mockMvc.perform(
                                get(CompanyController.URI + CompanyController.RESOURCE + CompanyController.BY_SEGMENT))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.segmentA", Matchers.is(10)))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.segmentB", Matchers.is(20)));
        }

        @Test
        public void getEmployeeBySegmentGroupByDepartament() throws Exception {
                this.mockMvc.perform(get(CompanyController.URI + CompanyController.RESOURCE
                                + CompanyController.BY_SEGMENT + CompanyController.GROUP_DEPARTAMENT))
                                .andDo(print()).andExpect(status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.Shipping.segmentA", Matchers.is(3)))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.Administration.segmentB",
                                                Matchers.is(10)));
        }

        @Test
        public void getEmployeeMaxSalaryGroupDepartamentDto() throws Exception {
                this.mockMvc.perform(get(CompanyController.URI + CompanyController.RESOURCE
                                + CompanyController.SALARY + CompanyController.GROUP_DEPARTAMENT))
                                .andDo(print()).andExpect(status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departament", Matchers.is("Finance")));
        }

        @Test
        public void getEmployeeManager15Year() throws Exception {
                this.mockMvc.perform(get(CompanyController.URI + CompanyController.RESOURCE
                                + CompanyController.OLD_15))
                                .andDo(print()).andExpect(status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].employeeId", Matchers.is(10)));
        }

        @Test
        public void getAverageSalaryMore10EmployeesByDepartament() throws Exception {
                this.mockMvc.perform(get(CompanyController.URI + CompanyController.RESOURCE
                                + CompanyController.SALARY + CompanyController.MORE_THAN_10))
                                .andDo(print()).andExpect(status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departament", Matchers.is("IT")));
        }

        @Test
        public void getGeneralnfoDto() throws Exception {
                this.mockMvc.perform(get(CompanyController.URI + CompanyController.RESOURCE
                                + CompanyController.GENERAL_INFO))
                                .andDo(print()).andExpect(status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].country", Matchers.is("Canada")));
        }

}
