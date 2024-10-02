package com.eduardoguedes.sistemaponto.entity.users;

public record RegisterDTO(Long cpnId, String name, String login, String password, UsersRole role) {
}
