package com.tienhuynh_tn.service;

import com.tienhuynh_tn.dto.APIResponseDto;
import com.tienhuynh_tn.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
