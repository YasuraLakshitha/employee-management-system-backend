package edu.icet.hrms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.hrms.dto.Employee;
import edu.icet.hrms.entity.EmployeeEntity;
import edu.icet.hrms.repository.EmployeeRepository;
import edu.icet.hrms.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ObjectMapper objectMapper;

    @Override
    public Employee registerEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.save(objectMapper.convertValue(employee, EmployeeEntity.class));
        return objectMapper.convertValue(employeeEntity, Employee.class);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.save(objectMapper.convertValue(employee, EmployeeEntity.class));
        return objectMapper.convertValue(employeeEntity, Employee.class);
    }

    @Override
    public Employee retrieveEmployee(Employee employee) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employee.getEmployeeId());
        return employeeEntity.map(entity -> objectMapper.convertValue(entity, Employee.class)).orElse(null);
    }

    @Override
    public void removeEmployee(Employee employee) {
        employeeRepository.deleteById(employee.getEmployeeId());
    }

    @Override
    public List<Employee> retrieveAllEmployeesByDepartment(UUID departmentId) {
        List<EmployeeEntity> allByDepartmentId = employeeRepository.findAllByDepartmentId(departmentId);
        if (!allByDepartmentId.isEmpty())
            return allByDepartmentId.stream()
                    .map(employeeEntity -> objectMapper.convertValue(employeeEntity, Employee.class)).toList();
        return null;
    }

    @Override
    public List<Employee> retriveAllByEmployeeRole(UUID employeeRoleId) throws NullPointerException {
        List<EmployeeEntity> allByRoleId = employeeRepository.findAllByRoleId(employeeRoleId);
        if (!allByRoleId.isEmpty())
            return allByRoleId.stream()
                    .map(employeeEntity -> objectMapper.convertValue(employeeEntity, Employee.class)).toList();
        return null;
    }

    @Override
    public List<Employee> retrieveAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        if (!employeeEntityList.isEmpty())
            return employeeEntityList.stream()
                    .map(employeeEntity -> objectMapper.convertValue(employeeEntity, Employee.class)).toList();
        return null;
    }
}
