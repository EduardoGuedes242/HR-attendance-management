package com.eduardoguedes.sistemaponto.controller.departament;

import com.eduardoguedes.sistemaponto.entity.departament.Department;
import com.eduardoguedes.sistemaponto.service.departament.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping
  public List<Department> getAllDepartments() {
    return departmentService.findAllDepartment();
  }

  @PostMapping
  public void createDepartment(@RequestBody Department department) {
    departmentService.createDepartment(department);
  }

}
