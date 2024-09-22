package com.eduardoguedes.sistemaponto.service.departament;

import com.eduardoguedes.sistemaponto.entity.departament.Department;
import com.eduardoguedes.sistemaponto.repository.departament.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  public List<Department> findAllDepartment(Long cpnId) {
    return departmentRepository.findByCpnId(cpnId);
  }

  public void createDepartment(Department department) {
    departmentRepository.save(department);
  }
}
