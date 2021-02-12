package com.thymeleafcrud.demoapp.service;

import com.thymeleafcrud.demoapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Optional<Employee> getEmployeeById(long id);
}
