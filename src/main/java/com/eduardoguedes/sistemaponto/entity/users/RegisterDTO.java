package com.eduardoguedes.sistemaponto.entity.users;

public record RegisterDTO(Long cpnId, String usrName, String usrLogin, String usrPassword, UsersRole usrRole) {
}
