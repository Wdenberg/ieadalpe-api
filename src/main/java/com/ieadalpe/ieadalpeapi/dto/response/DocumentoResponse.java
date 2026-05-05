package com.ieadalpe.ieadalpeapi.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;

public record DocumentoResponse(
        UUID id,
        String titulo,
        String descricao,
        String arquivoUrl,
        String tipo,
        String visibilidade,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}