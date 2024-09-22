package com.eduardoguedes.sistemaponto.entity.departament;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long dpt_id;

  @Column(name = "cpn_id")
  private Long cpnId;

  private String dpt_description;

  public Department() {}

  public Department(Long dpt_id, Long cpnId, String dpt_description) {
    this.dpt_id = dpt_id;
    this.cpnId = cpnId;
    this.dpt_description = dpt_description;
  }

  public Long getDpt_id() {
    return dpt_id;
  }

  public void setDpt_id(Long dpt_id) {
    this.dpt_id = dpt_id;
  }

  public Long getCpnId() {
    return cpnId;
  }

  public void setCpnId(Long cpnId) {
    this.cpnId = cpnId;
  }

  public String getDpt_description() {
    return dpt_description;
  }

  public void setDpt_description(String dpt_description) {
    this.dpt_description = dpt_description;
  }
}
