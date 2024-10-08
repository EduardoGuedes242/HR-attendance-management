package com.eduardoguedes.sistemaponto.repository.departament;

import com.eduardoguedes.sistemaponto.entity.departament.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  List<Department> findByCpnId(Long cpnId);
}
