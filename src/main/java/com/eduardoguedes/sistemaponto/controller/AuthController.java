package com.eduardoguedes.sistemaponto.controller;

import com.eduardoguedes.sistemaponto.entity.users.AuthenticationDTO;
import com.eduardoguedes.sistemaponto.entity.users.RegisterDTO;
import com.eduardoguedes.sistemaponto.entity.users.TokenDTO;
import com.eduardoguedes.sistemaponto.entity.users.Users;
import com.eduardoguedes.sistemaponto.infra.security.TokenService;
import com.eduardoguedes.sistemaponto.service.users.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
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

  @Operation(summary = "Register new user", method = "POST", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "New user register with success"),
          @ApiResponse(responseCode = "400", description = "Data invalid"),
          @ApiResponse(responseCode = "403", description = "User not authenticated"),
          @ApiResponse(responseCode = "500", description = "Problem server"),
  })
  @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity registerNewUsers(@RequestBody RegisterDTO user) {

    String encryptPassword = new BCryptPasswordEncoder().encode(user.password());

    Users newUser = new Users(user);

    newUser.setUsrPassword(encryptPassword);

    usersService.createUser(newUser);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
