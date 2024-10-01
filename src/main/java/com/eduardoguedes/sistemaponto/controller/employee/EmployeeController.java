package com.eduardoguedes.sistemaponto.controller.employee;

import com.eduardoguedes.sistemaponto.entity.employee.Employee;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.service.employee.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
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

  @Operation(summary = "Get All Employees for IdCompany", method = "GET")
  @GetMapping
  public List<Employee> getAllEmployees(HttpServletRequest request) {
    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    return employeeService.findAllEmployeeCpnId(cpnId);
  }

  @Operation(summary = "New register Employee", method = "POST")
  @PostMapping
  public void createEmployee(@RequestBody Employee employee, HttpServletRequest request) {
    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    employee.setCpnId(cpnId);
    employeeService.createEmployee(employee);
  }
}
