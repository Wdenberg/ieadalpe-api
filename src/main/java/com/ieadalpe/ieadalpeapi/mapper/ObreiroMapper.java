package com.ieadalpe.ieadalpeapi.mapper;

import com.ieadalpe.ieadalpeapi.domain.entity.Obreiro;
import com.ieadalpe.ieadalpeapi.dto.request.ObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.request.ObreiroUpdateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.ObreiroResponse;

public final class ObreiroMapper {

    private ObreiroMapper() {
    }

    public static Obreiro toEntity(ObreiroCreateRequest request) {
        Obreiro obreiro = new Obreiro();
        obreiro.setMatricula(request.matricula());
        obreiro.setNome(request.nome());
        obreiro.setFuncao(request.funcao());
        obreiro.setSetor(request.setor());
        obreiro.setCongregacao(request.congregacao());
        obreiro.setTelefone(request.telefone());
        obreiro.setDataNascimento(request.dataNascimento());
        obreiro.setDataBatismo(request.dataBatismo());
        obreiro.setAnosObreiro(request.anosObreiro());
        obreiro.setFotoUrl(request.fotoUrl());
        obreiro.setBloqueado(false);
        return obreiro;
    }

    public static void updateEntity(Obreiro entity, ObreiroUpdateRequest request) {
        entity.setNome(request.nome());
        entity.setFuncao(request.funcao());
        entity.setSetor(request.setor());
        entity.setCongregacao(request.congregacao());
        entity.setTelefone(request.telefone());
        entity.setDataNascimento(request.dataNascimento());
        entity.setDataBatismo(request.dataBatismo());
        entity.setAnosObreiro(request.anosObreiro());
        entity.setFotoUrl(request.fotoUrl());
        entity.setBloqueado(request.bloqueado());
    }

    public static ObreiroResponse toResponse(Obreiro entity) {
        return new ObreiroResponse(
                entity.getId(),
                entity.getUser().getId(),
                entity.getMatricula(),
                entity.getNome(),
                entity.getFuncao(),
                entity.getSetor(),
                entity.getCongregacao(),
                entity.getTelefone(),
                entity.getDataNascimento(),
                entity.getDataBatismo(),
                entity.getAnosObreiro(),
                entity.getFotoUrl(),
                entity.getBloqueado(),
                entity.getUltimoAcesso(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}