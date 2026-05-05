package com.ieadalpe.ieadalpeapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record NoticiaCreateRequest(

        @NotBlank(message = "O título é obrigatório.")
        @Size(max = 200)
        String titulo,

        @NotBlank(message = "O conteúdo é obrigatório.")
        String conteudo,

        @Size(max = 500)
        String resumo,

        String imagemUrl,

        @NotNull(message = "O autorId é obrigatório.")
        UUID autorId,

        Boolean publicada
) {
}