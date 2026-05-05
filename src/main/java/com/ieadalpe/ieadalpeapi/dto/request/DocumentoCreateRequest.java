package com.ieadalpe.ieadalpeapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DocumentoCreateRequest(

        @NotBlank(message = "O título é obrigatório.")
        @Size(max = 180)
        String titulo,

        @Size(max = 500)
        String descricao,

        @NotBlank(message = "A URL do arquivo é obrigatória.")
        String arquivoUrl,

        @Size(max = 80)
        String tipo,

        @NotBlank(message = "A visibilidade é obrigatória.")
        @Size(max = 50)
        String visibilidade
) {
}
