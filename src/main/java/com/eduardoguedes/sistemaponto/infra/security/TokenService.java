package com.eduardoguedes.sistemaponto.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.eduardoguedes.sistemaponto.entity.users.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(Users user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      // Adicionando o cpnId como uma claim extra
      String token = JWT.create()
              .withIssuer("auth-api")
              .withSubject(user.getUsrLogin())  // Login como subject
              .withClaim("cpnId", user.getCpnId())  // cpnId como claim
              .withExpiresAt(genExpirationDate())  // Data de expiração
              .sign(algorithm);

      return token;
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Erro ao gerar token: " + exception.getMessage(), exception);
    }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      // Validar token e retornar subject
      return JWT.require(algorithm)
              .withIssuer("auth-api")
              .build()
              .verify(token)
              .getSubject();

    } catch (JWTVerificationException exception) {
      return "";
    }
  }

  public String recoverToken(HttpServletRequest request) {
    var authHeader = request.getHeader("Authorization");
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      return null;
    }
    return authHeader.replace("Bearer ", "");
  }

  // Método para recuperar o cpnId da claim
  public Long getCpnIdFromToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
              .withIssuer("auth-api")
              .build()
              .verify(token)
              .getClaim("cpnId").asLong();  // Recupera o cpnId como Long
    } catch (JWTVerificationException exception) {
      throw new RuntimeException("Erro ao verificar token: " + exception.getMessage(), exception);
    }
  }

  private Instant genExpirationDate() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}
