package com.eduardoguedes.sistemaponto.controller;

import com.eduardoguedes.sistemaponto.entity.Employee;
import com.eduardoguedes.sistemaponto.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeService.findAllEmployee();
  }

  @GetMapping("/teste")
  public List<Employee> getAllEmployeesCpnId() {
    return employeeService.findAllEmployeeCpnId();
  }

  @PostMapping
  public void createEmployee(@RequestBody Employee employee) {
    employeeService.createEmployee(employee);
  }
}
