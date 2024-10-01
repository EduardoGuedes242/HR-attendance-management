package com.eduardoguedes.sistemaponto.controller.departament;

import com.eduardoguedes.sistemaponto.entity.departament.Department;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.service.departament.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @Autowired
  private TokenService tokenService;


  @Operation(summary = "Get all Departments for IdCompany", method = "GET")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Empresa criada com sucesso"),
          @ApiResponse(responseCode = "422", description = "Dados invalidos"),
          @ApiResponse(responseCode = "401", description = "Usuario não Autenticado"),
  })
  @GetMapping
  public List<Department> getAllDepartments(HttpServletRequest request) {

    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    return departmentService.findAllDepartment(cpnId);
  }

  @Operation(summary = "New register Department", method = "POST")
  @PostMapping
  public void createDepartment(@RequestBody String dptDescription, HttpServletRequest request) {
    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    Department department = new Department(cpnId, dptDescription);
    departmentService.createDepartment(department);
  }

}
