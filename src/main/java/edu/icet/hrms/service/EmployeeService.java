package edu.icet.hrms.service;

import edu.icet.hrms.dto.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee registerEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee retrieveEmployee(Employee employee);
    void removeEmployee(Employee employee);
    List<Employee> retrieveAllEmployeesByDepartment(UUID departmentId);
    List<Employee> retriveAllByEmployeeRole(UUID employeeRoleId);
    List<Employee> retrieveAllEmployees();
}
