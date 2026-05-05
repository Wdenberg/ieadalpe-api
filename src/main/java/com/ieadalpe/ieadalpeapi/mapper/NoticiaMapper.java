package com.ieadalpe.ieadalpeapi.mapper;

import com.ieadalpe.ieadalpeapi.domain.entity.Noticia;
import com.ieadalpe.ieadalpeapi.dto.request.NoticiaCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.NoticiaResponse;

public final class NoticiaMapper {

    private NoticiaMapper() {
    }

    public static Noticia toEntity(NoticiaCreateRequest request) {
        Noticia noticia = new Noticia();
        noticia.setTitulo(request.titulo());
        noticia.setConteudo(request.conteudo());
        noticia.setResumo(request.resumo());
        noticia.setImagemUrl(request.imagemUrl());
        noticia.setPublicada(request.publicada() != null ? request.publicada() : false);
        return noticia;
    }

    public static NoticiaResponse toResponse(Noticia entity) {
        return new NoticiaResponse(
                entity.getId(),
                entity.getTitulo(),
                entity.getConteudo(),
                entity.getResumo(),
                entity.getImagemUrl(),
                entity.getPublicada(),
                entity.getAutor() != null ? entity.getAutor().getId() : null,
                entity.getAutorNome(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
