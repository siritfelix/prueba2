package com.challenge.prueba2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.challenge.prueba2.dto.adapterJpa.IAverageSalaryMore10EmployeesByDepartamentDto;
import com.challenge.prueba2.dto.adapterJpa.IEmployeeMaxSalaryGroupDepartamentDto;
import com.challenge.prueba2.dto.adapterJpa.IGeneralInfoDto;
import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentDto;
import com.challenge.prueba2.dto.adapterJpa.IQuantityEmployeeBySegmentGroupDepartamentDto;
import com.challenge.prueba2.repository.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(nativeQuery = true, value = "SELECT segmentA, segmentB ,segmentC " +
            "FROM (SELECT COUNT(*) as segmenta from employees e1 WHERE e1.SALARY <3500 ) T1 " +
            "INNER JOIN (SELECT COUNT(*) as segmentb from employees e2 WHERE e2.SALARY  >= 3500 and e2.SALARY  < 8000) T2 "
            + "INNER JOIN (SELECT COUNT(*) as segmentc from employees e WHERE e.SALARY  >=  8000) T3;")
    public IQuantityEmployeeBySegmentDto getEmployeeBySegmentGroupByDepartament();

    @Query(nativeQuery = true, value = "SELECT d.DEPARTMENT_NAME as departament , count(*) as quantity " +
            "from employees e join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID   WHERE e.SALARY  <  3500 GROUP BY d.DEPARTMENT_NAME;")
    public List<IQuantityEmployeeBySegmentGroupDepartamentDto> getEmployeeBySegmentAGroupByDepartament();

    @Query(nativeQuery = true, value = "SELECT d.DEPARTMENT_NAME as departament ,count(*) as quantity " +
            "from employees e join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID WHERE e.SALARY  >= 3500 AND e.SALARY  < 8000 GROUP BY d.DEPARTMENT_NAME;")
    public List<IQuantityEmployeeBySegmentGroupDepartamentDto> getEmployeeBySegmentBGroupByDepartament();

    @Query(nativeQuery = true, value = "SELECT d.DEPARTMENT_NAME as departament ,count(*) as quantity " +
            "from employees e join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID WHERE e.SALARY  >= 8000 GROUP BY d.DEPARTMENT_NAME;")
    public List<IQuantityEmployeeBySegmentGroupDepartamentDto> getEmployeeBySegmentCGroupByDepartament();

    @Query(nativeQuery = true, value = "SELECT d.DEPARTMENT_NAME as departament ,e.SALARY as maxSalary, e.EMPLOYEE_ID as employeeId, "
            + "e.FIRST_NAME as firstName, e.LAST_NAME as lastName, e.EMAIL as email , e.PHONE_NUMBER as phoneNumber, "
            + "e.HIRE_DATE as hireDate, e.JOB_ID as jobId, e.COMMISSION_PCT as commissionPct, e.MANAGER_ID as managerId "
            + "from employees e join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID GROUP BY d.DEPARTMENT_NAME, e.EMPLOYEE_ID")
    public List<IEmployeeMaxSalaryGroupDepartamentDto> getEmployeeMaxSalaryGroupDepartamentDto();

    @Query(nativeQuery = true, value = "SELECT e.EMPLOYEE_ID as employeeId, e.FIRST_NAME as firstName, e.LAST_NAME as lastName, "
            + "e.EMAIL as email , e.PHONE_NUMBER as phoneNumber, e.HIRE_DATE as hireDate, " +
            "e.JOB_ID as jobId,e.SALARY as salary, e.COMMISSION_PCT as commissionPct, " +
            "e.MANAGER_ID  as managerId, e.DEPARTMENT_ID as departament  from employees e " +
            "WHERE TIMESTAMPDIFF(YEAR,e.HIRE_DATE ,CURDATE())>15 AND e.JOB_ID in(SELECT j.JOB_ID  from jobs j WHERE j.JOB_TITLE LIKE '%Manager%');")
    public List<IEmployeeMaxSalaryGroupDepartamentDto> getEmployeeManager15Year();

    @Query(nativeQuery = true, value = "SELECT d.DEPARTMENT_NAME as departament ,COUNT(*) as quantity ,AVG(e.SALARY) as avgSalary "
            + "from employees e join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID  GROUP BY d.DEPARTMENT_NAME HAVING COUNT(*) > 10;")
    public List<IAverageSalaryMore10EmployeesByDepartamentDto> getAverageSalaryMore10EmployeesByDepartament();

    @Query(nativeQuery = true, value = "    SELECT  c.COUNTRY_NAME AS country ,COUNT(*)  AS quantityEmployee ,AVG(e.SALARY) AS avgSalary, "
            + "MAX(e.SALARY) AS maxSalary , Min(e.SALARY) AS minSalary, AVG( TIMESTAMPDIFF(YEAR,e.HIRE_DATE ,CURDATE())) as avgHireDate FROM "
            + "employees e JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID JOIN locations l ON d.LOCATION_ID =l.LOCATION_ID "
            + "JOIN countries c ON c.COUNTRY_ID =l.COUNTRY_ID GROUP BY c.COUNTRY_NAME; ")
    public List<IGeneralInfoDto> getGeneralnfoDto();

}
