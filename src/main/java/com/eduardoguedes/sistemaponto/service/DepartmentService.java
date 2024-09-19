package com.eduardoguedes.sistemaponto.service;

import com.eduardoguedes.sistemaponto.entity.Department;
import com.eduardoguedes.sistemaponto.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  public List<Department> findAllDepartment() {
    return departmentRepository.findAll();
  }

  public void createDepartment(Department department) {
    departmentRepository.save(department);
  }
}
