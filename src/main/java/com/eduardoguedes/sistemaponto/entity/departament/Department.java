package com.eduardoguedes.sistemaponto.entity.departament;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dpt_id")
  private Long dptId;

  @Column(name = "cpn_id")
  private Long cpnId;

  @Column(name = "dpt_description")
  private String dptDescription;

  public Department() {}

  public Department(Long dptId, Long cpnId, String dptDescription) {
    this.dptId = dptId;
    this.cpnId = cpnId;
    this.dptDescription = dptDescription;
  }

  public Department(Long cpnId, String dptDescription) {
    this.cpnId = cpnId;
    this.dptDescription = dptDescription;
  }

  public Long getDptId() {
    return dptId;
  }

  public void setDptId(Long dptId) {
    this.dptId = dptId;
  }

  public Long getCpnId() {
    return cpnId;
  }

  public void setCpnId(Long cpnId) {
    this.cpnId = cpnId;
  }

  public String getDptDescription() {
    return dptDescription;
  }

  public void setDptDescription(String dptDescription) {
    this.dptDescription = dptDescription;
  }
}
