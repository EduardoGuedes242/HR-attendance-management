package com.eduardoguedes.sistemaponto.repository.employee;

import com.eduardoguedes.sistemaponto.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  List<Employee> findByCpnId(Long CpnId);
}

