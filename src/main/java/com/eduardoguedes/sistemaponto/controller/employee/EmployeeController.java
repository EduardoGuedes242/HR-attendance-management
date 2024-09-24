package com.eduardoguedes.sistemaponto.controller.employee;

import com.eduardoguedes.sistemaponto.entity.employee.Employee;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.service.employee.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private TokenService tokenService;

  @GetMapping
  public List<Employee> getAllEmployees(HttpServletRequest request) {
    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    return employeeService.findAllEmployeeCpnId(cpnId);
  }

  @PostMapping
  public void createEmployee(@RequestBody Employee employee, HttpServletRequest request) {
    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    employee.setCpnId(cpnId);
    employeeService.createEmployee(employee);
  }
}
