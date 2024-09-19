package com.eduardoguedes.sistemaponto.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cpn_id;
  private String cpn_name;
  private String cpn_cnpj;
  private String cpn_email;
  private String cpn_date;

  public Company() {}

  public Company(long cpn_id, String cpn_name, String cpn_cnpj, String cpn_email, String cpn_date) {
    this.cpn_id = cpn_id;
    this.cpn_name = cpn_name;
    this.cpn_cnpj = cpn_cnpj;
    this.cpn_email = cpn_email;
    this.cpn_date = cpn_date;
  }

  public long getCpn_id() {
    return cpn_id;
  }

  public void setCpn_id(long cpn_id) {
    this.cpn_id = cpn_id;
  }

  public String getCpn_name() {
    return cpn_name;
  }

  public void setCpn_name(String cpn_name) {
    this.cpn_name = cpn_name;
  }

  public String getCpn_cnpj() {
    return cpn_cnpj;
  }

  public void setCpn_cnpj(String cpn_cnpj) {
    this.cpn_cnpj = cpn_cnpj;
  }

  public String getCpn_email() {
    return cpn_email;
  }

  public void setCpn_email(String cpn_email) {
    this.cpn_email = cpn_email;
  }

  public String getCpn_date() {
    return cpn_date;
  }

  public void setCpn_date(String cpn_date) {
    this.cpn_date = cpn_date;
  }
}
