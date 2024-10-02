package com.eduardoguedes.sistemaponto.entity.employee;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record EmployeeRequestDTO(
        @NotBlank(message = "Id of Department is required")
        Long dptId,

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Number CPF is required")
        String cpf,

        @NotBlank(message = "Email is required")
        String email,

        Date elyDateBirth) {
}
