package com.ieadalpe.ieadalpeapi.dto.response;

import java.time.LocalDateTime;
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
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
