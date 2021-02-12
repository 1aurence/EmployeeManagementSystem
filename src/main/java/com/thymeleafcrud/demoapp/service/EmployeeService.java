package com.thymeleafcrud.demoapp.service;

import com.thymeleafcrud.demoapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
}
