package com.tienhuynh_tn.repository;

import com.tienhuynh_tn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
