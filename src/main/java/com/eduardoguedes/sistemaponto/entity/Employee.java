package com.eduardoguedes.sistemaponto.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ely_id;
  private Long cpn_id;
  private Long dpt_id;
  private String ely_name;
  private String ely_cpf;
  private String ely_email;
  private Date ely_date_birth;

  public Employee() {}

  public Employee(Long ely_id, Long cpn_id, Long dpt_id, String ely_name, String ely_cpf, String ely_email, Date ely_date_birth) {
    this.ely_id = ely_id;
    this.cpn_id = cpn_id;
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

  public Long getCpn_id() {
    return cpn_id;
  }
  public void setCpn_id(Long cpn_id) {
    this.cpn_id = cpn_id;
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
