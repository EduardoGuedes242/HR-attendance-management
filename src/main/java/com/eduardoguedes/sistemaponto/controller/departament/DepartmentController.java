package com.eduardoguedes.sistemaponto.controller.departament;

import com.eduardoguedes.sistemaponto.entity.departament.Department;
import com.eduardoguedes.sistemaponto.entity.departament.DepartmentRequestDTO;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.service.departament.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

  @Operation(summary = "Register new department",
          method = "POST",
          security = @SecurityRequirement(name = "bearerAuth"),
          description = "This Method is using to register new department"

  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "New department register with success"),
          @ApiResponse(responseCode = "400", description = "Data invalid"),
          @ApiResponse(responseCode = "403", description = "User not authenticated"),
          @ApiResponse(responseCode = "500", description = "Problem server"),
  })
  @PostMapping
  public void createDepartment(@RequestBody DepartmentRequestDTO departmentDTO, HttpServletRequest request) {
    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    Department department = new Department(cpnId, departmentDTO);
    departmentService.createDepartment(department);
  }

}
