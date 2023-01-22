/*Obtener cantidad de empleados dentro de los siguientes segmentos de sueldo:*/
SELECT
    segmentA,
    segmentB,
    segmentC
FROM
    (
        SELECT
            COUNT(1) as segmentA
        from
            employees e1
        WHERE
            e1.SALARY < 3500
    ) T1
    INNER JOIN (
        SELECT
            COUNT(*) as segmentB
        from
            employees e2
        WHERE
            e2.SALARY >= 3500
            and e2.SALARY < 8000
    ) T2
    INNER JOIN (
        SELECT
            COUNT(*) as segmentC
        from
            employees e
        WHERE
            e.SALARY >= 8000
    ) T3
    /*Utilizando la tabla “departments” se requiere realizar la misma agrupación
     de segmentos de sueldo, pero por departamento.*/
SELECT
    d.DEPARTMENT_NAME as departament,
    count(*) as quantity
from
    employees e
    join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE
    e.SALARY < 3500
GROUP BY
    d.DEPARTMENT_NAME;

SELECT
    d.DEPARTMENT_NAME as departament,
    count(*) as quantity
from
    employees e
    join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE
    e.SALARY >= 3500
    AND e.SALARY < 8000
GROUP BY
    d.DEPARTMENT_NAME;

SELECT
    d.DEPARTMENT_NAME as departament,
    count(*) as quantity
from
    employees e
    join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE
    e.SALARY >= 8000
GROUP BY
    d.DEPARTMENT_NAME;

/*Información del empleado con mayor sueldo de cada departamento.*/
SELECT
    d.DEPARTMENT_NAME as departament,
    e.SALARY as maxSalary,
    e.EMPLOYEE_ID as employeeId,
    e.FIRST_NAME as firstName,
    e.LAST_NAME as lastName,
    e.EMAIL as email,
    e.PHONE_NUMBER as phoneNumber,
    e.HIRE_DATE as hireDate,
    e.JOB_ID as jobId,
    e.COMMISSION_PCT as commissionPct,
    e.MANAGER_ID as managerId
from
    employees e
    join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
GROUP BY
    d.DEPARTMENT_NAME,
    e.EMPLOYEE_ID;

/*Información de los gerentes que hayan sido contratados hace más de 15
 años.*/
SELECT
    e.EMPLOYEE_ID as employeeId,
    e.FIRST_NAME as firstName,
    e.LAST_NAME as lastName,
    e.EMAIL as email,
    e.PHONE_NUMBER as phoneNumber,
    e.HIRE_DATE as hireDate,
    e.JOB_ID as jobId,
    e.SALARY as salary,
    e.COMMISSION_PCT as commissionPct,
    e.MANAGER_ID as managerId,
    e.DEPARTMENT_ID as departament
from
    employees e
WHERE
    TIMESTAMPDIFF(YEAR, e.HIRE_DATE, CURDATE()) > 15
    AND e.JOB_ID in(
        SELECT
            j.JOB_ID
        from
            jobs j
        WHERE
            j.JOB_TITLE LIKE '%Manager%'
    );

/*Salario promedio de todos los departamentos que tengan más de 10
 empleados*/
SELECT
    d.DEPARTMENT_NAME as departament,
    COUNT(*) as quantity,
    AVG(e.SALARY) as avgSalary
from
    employees e
    join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
GROUP BY
    d.DEPARTMENT_NAME
HAVING
    COUNT(*) > 10;

/*Obtener la siguiente información agrupada por país: cantidad empleados,
 salario promedio, salario más alto, salario más bajo, promedio años
 antigüedad*/
SELECT
    c.COUNTRY_NAME AS country,
    COUNT(*) AS quantityEmployee,
    AVG(e.SALARY) AS avgSalary,
    MAX(e.SALARY) AS maxSalary,
    Min(e.SALARY) AS minSalary,
    AVG(TIMESTAMPDIFF(YEAR, e.HIRE_DATE, CURDATE())) as avgHireDate
FROM
    employees e
    JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
    JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID
    JOIN countries c ON c.COUNTRY_ID = l.COUNTRY_ID
GROUP BY
    c.COUNTRY_NAME;