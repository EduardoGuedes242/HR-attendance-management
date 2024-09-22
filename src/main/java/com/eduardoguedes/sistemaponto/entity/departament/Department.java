package com.eduardoguedes.sistemaponto.entity.departament;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long dpt_id;
  private Long cpn_id;
  private String dpt_description;

  public Department() {}

  public Department(Long dpt_id, Long cpn_id, String dpt_description) {
    this.dpt_id = dpt_id;
    this.cpn_id = cpn_id;
    this.dpt_description = dpt_description;
  }

  public Long getDpt_id() {
    return dpt_id;
  }

  public void setDpt_id(Long dpt_id) {
    this.dpt_id = dpt_id;
  }

  public Long getCpn_id() {
    return cpn_id;
  }

  public void setCpn_id(Long cpn_id) {
    this.cpn_id = cpn_id;
  }

  public String getDpt_description() {
    return dpt_description;
  }

  public void setDpt_description(String dpt_description) {
    this.dpt_description = dpt_description;
  }
}
