package com.eduardoguedes.sistemaponto.entity.company;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Date;

public record CompanyRequestDTO(
        @NotBlank(message = "Name is required")
        String cpnName,

        @NotBlank(message = "Number document is requerid")
        @CNPJ(message = "Invalid CNPJ format")
        String cpnCnpj,

        @Email(message = "Invalid email format")
        String cpnEmail,

        Date cpnDate) {}
