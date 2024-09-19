package com.eduardoguedes.sistemaponto.repository;

import com.eduardoguedes.sistemaponto.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
