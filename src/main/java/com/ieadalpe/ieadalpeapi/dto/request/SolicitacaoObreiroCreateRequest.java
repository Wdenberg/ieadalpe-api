package com.ieadalpe.ieadalpeapi.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record SolicitacaoObreiroCreateRequest(

        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 150)
        String nome,

        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "Email inválido.")
        @Size(max = 180)
        String email,

        @NotBlank(message = "A matrícula é obrigatória.")
        @Size(max = 50)
        String matricula,

        @NotBlank(message = "A senha temporária é obrigatória.")
        @Size(max = 255)
        String senhaTemp,

        LocalDate dataNascimento,

        @Size(max = 120)
        String setor,

        @Size(max = 120)
        String congregacao
) {
}
