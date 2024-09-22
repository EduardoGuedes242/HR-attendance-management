package com.eduardoguedes.sistemaponto.entity.users;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements UserDetails {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "usr_id")
  private Long usrId;

  @Column(name = "cpn_id")
  private Long cpnId;

  @Column(name = "usr_name")
  private String usrName;

  @Column(name = "usr_login")
  private String usrLogin;

  @Column(name = "usr_password")
  private String usrPassword;

  @Column(name = "usr_role")
  private UsersRole usrRole;


  public Users() {}

  public Users(Long usrId, Long cpnId, String usrName, String usrLogin, String usrPassword, UsersRole usrRole) {
    this.usrId = usrId;
    this.cpnId = cpnId;
    this.usrName = usrName;
    this.usrLogin = usrLogin;
    this.usrPassword = usrPassword;
    this.usrRole = usrRole;
  }

  public Users(Long cpnId, String usrName, String usrLogin, String usrPassword, UsersRole usrRole) {
    this.cpnId = cpnId;
    this.usrName = usrName;
    this.usrLogin = usrLogin;
    this.usrPassword = usrPassword;
    this.usrRole = usrRole;
  }

  public Long getUsrId() {
    return usrId;
  }

  public void setUsrId(Long usrId) {
    this.usrId = usrId;
  }

  public Long getCpnId() {
    return cpnId;
  }

  public void setCpnId(Long cpnId) {
    this.cpnId = cpnId;
  }

  public String getUsrName() {
    return usrName;
  }

  public void setUsrName(String usrName) {
    this.usrName = usrName;
  }

  public String getUsrLogin() {
    return usrLogin;
  }

  public void setUsrLogin(String usrLogin) {
    this.usrLogin = usrLogin;
  }

  public String getUsrPassword() {
    return usrPassword;
  }

  public void setUsrPassword(String usrPassword) {
    this.usrPassword = usrPassword;
  }

  public UsersRole getUsrRole() {
    return usrRole;
  }

  public void setUsrRole(UsersRole usrRole) {
    this.usrRole = usrRole;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if(this.usrRole == UsersRole.ADMIN) {
      return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
              new SimpleGrantedAuthority("ROLE_USER")
      );
    } else {
      return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
  }


  @Override
  public String getPassword() {
    return usrPassword;
  }

  @Override
  public String getUsername() {
    return usrLogin;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
