package com.ieadalpe.ieadalpeapi.dto.response;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public record SolicitacaoObreiroResponse(
        UUID id,
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento,
        String setor,
        String congregacao,
        String status,
        String motivoRejeicao,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}