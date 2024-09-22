package com.eduardoguedes.sistemaponto.entity.company;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "company")
public class Company {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cpn_id")
  private Long cpnId;

  @Column(name = "cpn_name")
  private String cpnName;

  @Column(name = "cpn_cnpj")
  private String cpnCnpj;

  @Column(name = "cpn_email")
  private String cpnEmail;

  @Column(name = "cpn_date")
  private Date cpnDate;

  public Company() {}

  public Company(Long cpnId, String cpnName, String cpnCnpj, String cpnEmail, Date cpnDate) {
    this.cpnId = cpnId;
    this.cpnName = cpnName;
    this.cpnCnpj = cpnCnpj;
    this.cpnEmail = cpnEmail;
    this.cpnDate = cpnDate;
  }

  public Long getCpnId() {
    return cpnId;
  }

  public void setCpnId(Long cpnId) {
    this.cpnId = cpnId;
  }

  public String getCpnName() {
    return cpnName;
  }

  public void setCpnName(String cpnName) {
    this.cpnName = cpnName;
  }

  public String getCpnCnpj() {
    return cpnCnpj;
  }

  public void setCpnCnpj(String cpnCnpj) {
    this.cpnCnpj = cpnCnpj;
  }

  public String getCpnEmail() {
    return cpnEmail;
  }

  public void setCpnEmail(String cpnEmail) {
    this.cpnEmail = cpnEmail;
  }

  public Date getCpnDate() {
    return cpnDate;
  }

  public void setCpnDate(Date cpnDate) {
    this.cpnDate = cpnDate;
  }
}
