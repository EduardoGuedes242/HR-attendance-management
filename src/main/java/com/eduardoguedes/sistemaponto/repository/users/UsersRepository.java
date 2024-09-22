package com.eduardoguedes.sistemaponto.repository.users;

import com.eduardoguedes.sistemaponto.entity.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, Long> {
  UserDetails findByUsrLogin(String usrLogin);
}
