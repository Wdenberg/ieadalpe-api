package com.ieadalpe.ieadalpeapi.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;

public record NoticiaResponse(
        UUID id,
        String titulo,
        String conteudo,
        String resumo,
        String imagemUrl,
        Boolean publicada,
        UUID autorId,
        String autorNome,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
