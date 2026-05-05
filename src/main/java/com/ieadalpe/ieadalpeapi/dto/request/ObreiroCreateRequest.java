package com.ieadalpe.ieadalpeapi.dto.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.UUID;
public record ObreiroCreateRequest(

        @NotNull(message = "O userId é obrigatório.")
        UUID userId,

        @NotBlank(message = "A matrícula é obrigatória.")
        @Size(max = 50)
        String matricula,

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

        @Past(message = "A data de nascimento deve ser uma data passada.")
        LocalDate dataNascimento,

        @PastOrPresent(message = "A data de batismo não pode ser futura.")
        LocalDate dataBatismo,

        @PositiveOrZero(message = "Anos de obreiro deve ser um número positivo.")
        Integer anosObreiro,

        @URL(message = "A URL da foto deve ser válida.")
        String fotoUrl
) {
}
