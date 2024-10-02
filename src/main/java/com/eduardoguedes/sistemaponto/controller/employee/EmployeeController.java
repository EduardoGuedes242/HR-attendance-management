package com.eduardoguedes.sistemaponto.controller.employee;

import com.eduardoguedes.sistemaponto.entity.employee.Employee;
import com.eduardoguedes.sistemaponto.entity.employee.EmployeeRequestDTO;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.service.employee.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

  @Operation(summary = "Register new employee", method = "POST", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "New employee register with success"),
          @ApiResponse(responseCode = "400", description = "Data invalid"),
          @ApiResponse(responseCode = "403", description = "User not authenticated"),
          @ApiResponse(responseCode = "500", description = "Problem server"),
  })
  @PostMapping
  public void createEmployee(@RequestBody EmployeeRequestDTO employeeDTO, HttpServletRequest request) {
    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    Employee employee = new Employee(cpnId ,employeeDTO);

    employeeService.createEmployee(employee);
  }
}
