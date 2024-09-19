package com.eduardoguedes.sistemaponto.repository;

import com.eduardoguedes.sistemaponto.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
