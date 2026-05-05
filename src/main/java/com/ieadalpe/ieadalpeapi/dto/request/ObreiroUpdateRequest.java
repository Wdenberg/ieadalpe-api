package com.ieadalpe.ieadalpeapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ObreiroUpdateRequest(

        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 150)
        String nome,

        @Size(max = 100)
        String funcao,

        @Size(max = 120)
        String setor,

        @Size(max = 120)
        String congregacao,

        @Size(max = 30)
        String telefone,

        LocalDate dataNascimento,
        LocalDate dataBatismo,
        Integer anosObreiro,
        String fotoUrl,
        Boolean bloqueado
) {
}