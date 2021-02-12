package com.thymeleafcrud.demoapp.service;

import com.thymeleafcrud.demoapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
}
