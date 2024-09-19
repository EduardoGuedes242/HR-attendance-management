package com.eduardoguedes.sistemaponto.service;

import com.eduardoguedes.sistemaponto.entity.Employee;
import com.eduardoguedes.sistemaponto.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> findAllEmployee() {
    return employeeRepository.findAll();
  }

  public void createEmployee(Employee employee) {
    employeeRepository.save(employee);
  }


  public List<Employee> findAllEmployeeCpnId() {
    return employeeRepository.findByCpnId(2l);
  }
}
