package com.thymeleafcrud.demoapp.controller;


import com.thymeleafcrud.demoapp.model.Employee;
import com.thymeleafcrud.demoapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/employees")
    public List<Employee> viewHomePage() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    //Test mappings
    @GetMapping("/showTestForm")
    public String showTestForm(Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(1);
        model.addAttribute("employee_name", employee.get().getFirstName());
        return "test_form";
    }
}
