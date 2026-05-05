package com.ieadalpe.ieadalpeapi.dto.response;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public record ObreiroResponse(
        UUID id,
        UUID userId,
        String matricula,
        String nome,
        String funcao,
        String setor,
        String congregacao,
        String telefone,
        LocalDate dataNascimento,
        LocalDate dataBatismo,
        Integer anosObreiro,
        String fotoUrl,
        Boolean bloqueado,
        OffsetDateTime ultimoAcesso,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}