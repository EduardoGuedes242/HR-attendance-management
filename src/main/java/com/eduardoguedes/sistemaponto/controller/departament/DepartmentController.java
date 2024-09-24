package com.eduardoguedes.sistemaponto.controller.departament;

import com.eduardoguedes.sistemaponto.entity.departament.Department;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.service.departament.DepartmentService;
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

  @GetMapping
  public List<Department> getAllDepartments(HttpServletRequest request) {

    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);

    return departmentService.findAllDepartment(cpnId);
  }

  @PostMapping
  public void createDepartment(@RequestBody Department department, HttpServletRequest request) {
    String token = tokenService.recoverToken(request);
    Long cpnId = tokenService.getCpnIdFromToken(token);
    department.setCpnId(cpnId);
    departmentService.createDepartment(department);
  }

}
