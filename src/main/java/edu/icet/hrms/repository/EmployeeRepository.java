package edu.icet.hrms.repository;

import edu.icet.hrms.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
    List<EmployeeEntity> findAllByDepartmentId(UUID departmentId);
    List<EmployeeEntity> findAllByRoleId(UUID roleId);
}
