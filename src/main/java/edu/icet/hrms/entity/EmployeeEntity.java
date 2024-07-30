package edu.icet.hrms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "employee_id")
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private UUID departmentId;
    private UUID roleId;
}
