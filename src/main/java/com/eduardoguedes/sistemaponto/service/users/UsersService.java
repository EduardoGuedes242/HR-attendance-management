package com.eduardoguedes.sistemaponto.service.users;

import com.eduardoguedes.sistemaponto.entity.users.Users;
import com.eduardoguedes.sistemaponto.repository.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  private UsersRepository usersRepository;

  public void createUser(Users user) {
   usersRepository.save(user);
  }
}
