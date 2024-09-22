package com.eduardoguedes.sistemaponto.controller;

import com.eduardoguedes.sistemaponto.entity.users.AuthenticationDTO;
import com.eduardoguedes.sistemaponto.entity.users.RegisterDTO;
import com.eduardoguedes.sistemaponto.entity.users.TokenDTO;
import com.eduardoguedes.sistemaponto.entity.users.Users;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.service.users.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UsersService usersService;

  @Autowired
  private TokenService tokenService;


  @PostMapping("/login")
  public ResponseEntity login(@RequestBody AuthenticationDTO body) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(body.login(), body.password());

    var auth = this.authenticationManager.authenticate(usernamePassword);

    var token = tokenService.generateToken((Users) auth.getPrincipal());

    return ResponseEntity.ok(new TokenDTO(token));
  }

  @GetMapping("/cpn")
  public String cpn(HttpServletRequest request) {

    String token = tokenService.recoverToken(request);

    Long cpnId = tokenService.getCpnIdFromToken(token);

    return "O cpn do user é: "+ cpnId;
  }

  @PostMapping("/register")
  public ResponseEntity registerNewUsers(@RequestBody RegisterDTO user) {

    String encryptPassword = new BCryptPasswordEncoder().encode(user.usrPassword());

    Users newUser = new Users(
            user.cpnId(),
            user.usrName(),
            user.usrLogin(),
            encryptPassword,
            user.usrRole()
    );

    usersService.createUser(newUser);

    return ResponseEntity.ok().build();
  }

}
