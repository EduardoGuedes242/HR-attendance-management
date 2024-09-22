package com.eduardoguedes.sistemaponto.service.employee;

import com.eduardoguedes.sistemaponto.entity.employee.Employee;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.repository.employee.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public void createEmployee(Employee employee) {
    employeeRepository.save(employee);
  }

  public List<Employee> findAllEmployeeCpnId(Long cpnId) {
    return employeeRepository.findByCpnId(cpnId);
  }
}
