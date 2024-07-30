package edu.icet.hrms.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Employee {
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private UUID departmentId;
    private UUID roleId;
}
