package com.eduardoguedes.sistemaponto.entity.employee;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ely_id")
  private Long elyId;

  @Column(name = "cpn_id")
  private Long cpnId;

  @Column(name = "dpt_id")
  private Long dptId;

  @Column(name = "ely_name")
  private String elyName;

  @Column(name = "ely_cpf")
  private String elyCpf;

  @Column(name = "ely_email")
  private String elyEmail;

  @Column(name = "ely_date_birth")
  private Date elyDateBirth;

  public Employee() {}

  public Employee(Long elyId, Long cpnId, Long dptId, String elyName, String elyCpf, String elyEmail, Date elyDateBirth) {
    this.elyId = elyId;
    this.cpnId = cpnId;
    this.dptId = dptId;
    this.elyName = elyName;
    this.elyCpf = elyCpf;
    this.elyEmail = elyEmail;
    this.elyDateBirth = elyDateBirth;
  }

  public Employee(Long cpnId, EmployeeRequestDTO employeeDTO) {
    this.cpnId = cpnId;
    this.dptId = employeeDTO.dptId();
    this.elyName = employeeDTO.name();
    this.elyCpf = employeeDTO.cpf();
    this.elyEmail = employeeDTO.email();
    this.elyDateBirth = employeeDTO.elyDateBirth();
  }

  public Long getElyId() {
    return elyId;
  }

  public void setElyId(Long elyId) {
    this.elyId = elyId;
  }

  public long getCpnId() {
    return cpnId;
  }

  public void setCpnId(long cpnId) {
    this.cpnId = cpnId;
  }
  public Long getDptId() {
    return dptId;
  }
  public void setDptId(Long dptId) {
    this.dptId = dptId;
  }

  public String getElyName() {
    return elyName;
  }

  public void setElyName(String elyName) {
    this.elyName = elyName;
  }

  public String getElyCpf() {
    return elyCpf;
  }

  public void setElyCpf(String elyCpf) {
    this.elyCpf = elyCpf;
  }

  public String getElyEmail() {
    return elyEmail;
  }

  public void setElyEmail(String elyEmail) {
    this.elyEmail = elyEmail;
  }

  public Date getElyDateBirth() {
    return elyDateBirth;
  }

  public void setElyDateBirth(Date elyDateBirth) {
    this.elyDateBirth = elyDateBirth;
  }
}
