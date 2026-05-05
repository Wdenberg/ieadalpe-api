package com.ieadalpe.ieadalpeapi.service.impl;

import com.ieadalpe.ieadalpeapi.domain.entity.SolicitacaoObreiro;
import com.ieadalpe.ieadalpeapi.dto.request.SolicitacaoObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;
import com.ieadalpe.ieadalpeapi.dto.response.SolicitacaoObreiroResponse;
import com.ieadalpe.ieadalpeapi.exception.DuplicateResourceException;
import com.ieadalpe.ieadalpeapi.repository.SolicitacaoObreiroRepository;
import com.ieadalpe.ieadalpeapi.service.interfaces.SolicitacaoObreiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SolicitacaoObreiroServiceImpl implements SolicitacaoObreiroService {

    private final SolicitacaoObreiroRepository repository;

    @Override
    @Transactional
    public SolicitacaoObreiroResponse create(SolicitacaoObreiroCreateRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("Já existe uma solicitação com esse email.");
        }

        if (repository.existsByMatricula(request.matricula())) {
            throw new DuplicateResourceException("Já existe uma solicitação com essa matrícula.");
        }

        SolicitacaoObreiro entity = SolicitacaoObreiro.builder()
                .nome(request.nome())
                .email(request.email())
                .matricula(request.matricula())
                .senhaTemp(request.senhaTemp())
                .dataNascimento(request.dataNascimento())
                .setor(request.setor())
                .congregacao(request.congregacao())
                .status("pendente")
                .build();

        SolicitacaoObreiro saved = repository.save(entity);

        return new SolicitacaoObreiroResponse(
                saved.getId(),
                saved.getNome(),
                saved.getEmail(),
                saved.getMatricula(),
                saved.getDataNascimento(),
                saved.getSetor(),
                saved.getCongregacao(),
                saved.getStatus(),
                saved.getMotivoRejeicao(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<SolicitacaoObreiroResponse> findByStatus(String status, int page, int size) {
        var pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        var result = repository.findAll(pageable);

        return new PagedResponse<>(
                result.getContent().stream().map(item -> new SolicitacaoObreiroResponse(
                        item.getId(),
                        item.getNome(),
                        item.getEmail(),
                        item.getMatricula(),
                        item.getDataNascimento(),
                        item.getSetor(),
                        item.getCongregacao(),
                        item.getStatus(),
                        item.getMotivoRejeicao(),
                        item.getCreatedAt(),
                        item.getUpdatedAt()
                )).toList(),
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.isFirst(),
                result.isLast()
        );
    }
}
