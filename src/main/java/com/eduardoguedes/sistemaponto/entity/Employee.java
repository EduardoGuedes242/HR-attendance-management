package com.eduardoguedes.sistemaponto.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ely_id;

  @Column(name = "cpn_id")
  private Long cpnId;

  private Long dpt_id;
  private String ely_name;
  private String ely_cpf;
  private String ely_email;
  private Date ely_date_birth;

  public Employee() {}

  public Employee(Long ely_id, Long cpnId, Long dpt_id, String ely_name, String ely_cpf, String ely_email, Date ely_date_birth) {
    this.ely_id = ely_id;
    this.cpnId = cpnId;
    this.dpt_id = dpt_id;
    this.ely_name = ely_name;
    this.ely_cpf = ely_cpf;
    this.ely_email = ely_email;
    this.ely_date_birth = ely_date_birth;
  }

  public Long getEly_id() {
    return ely_id;
  }

  public void setEly_id(Long ely_id) {
    this.ely_id = ely_id;
  }

  public long getCpnId() {
    return cpnId;
  }

  public void setCpnId(long cpnId) {
    this.cpnId = cpnId;
  }
  public Long getDpt_id() {
    return dpt_id;
  }
  public void setDpt_id(Long dpt_id) {
    this.dpt_id = dpt_id;
  }

  public String getEly_name() {
    return ely_name;
  }

  public void setEly_name(String ely_name) {
    this.ely_name = ely_name;
  }

  public String getEly_cpf() {
    return ely_cpf;
  }

  public void setEly_cpf(String ely_cpf) {
    this.ely_cpf = ely_cpf;
  }

  public String getEly_email() {
    return ely_email;
  }

  public void setEly_email(String ely_email) {
    this.ely_email = ely_email;
  }

  public Date getEly_date_birth() {
    return ely_date_birth;
  }

  public void setEly_date_birth(Date ely_date_birth) {
    this.ely_date_birth = ely_date_birth;
  }
}
