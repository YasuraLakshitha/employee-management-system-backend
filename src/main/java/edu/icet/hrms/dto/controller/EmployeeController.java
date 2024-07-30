package edu.icet.hrms.dto.controller;

import edu.icet.hrms.dto.Employee;
import edu.icet.hrms.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    void persist(@RequestBody Employee employee) {
        employeeService.registerEmployee(employee);
    }

    @PutMapping("/update")
    void update(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/remove")
    void remove(@RequestBody Employee employee) {
        employeeService.removeEmployee(employee);
    }

    @GetMapping("/find")
    Employee getByReference(@RequestBody Employee employee) {
        return employeeService.retrieveEmployee(employee);
    }

    @GetMapping("/employees")
    List<Employee> getAll(){
        return employeeService.retrieveAllEmployees();
    }

    @GetMapping("/employees/byDepartment")
    List<Employee> getAllByDepartment(UUID departmentId) {
        return employeeService.retrieveAllEmployeesByDepartment(departmentId);
    }

    @GetMapping("/employees/byRole")
    List<Employee> getAllByRoleId(UUID roleId) {
        return employeeService.retriveAllByEmployeeRole(roleId);
    }
}

