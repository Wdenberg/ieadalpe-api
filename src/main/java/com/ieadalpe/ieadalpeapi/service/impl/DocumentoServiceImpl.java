package com.ieadalpe.ieadalpeapi.service.impl;

import com.ieadalpe.ieadalpeapi.domain.entity.Documento;
import com.ieadalpe.ieadalpeapi.dto.request.DocumentoCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.DocumentoResponse;
import com.ieadalpe.ieadalpeapi.exception.ResourceNotFoundException;
import com.ieadalpe.ieadalpeapi.repository.DocumentoRepository;
import com.ieadalpe.ieadalpeapi.service.interfaces.DocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImpl implements DocumentoService {

    private final DocumentoRepository repository;

    @Override
    @Transactional
    public DocumentoResponse create(DocumentoCreateRequest request) {
        Documento entity = Documento.builder()
                .titulo(request.titulo())
                .descricao(request.descricao())
                .arquivoUrl(request.arquivoUrl())
                .tipo(request.tipo())
                .visibilidade(request.visibilidade())
                .build();

        Documento saved = repository.save(entity);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentoResponse findById(UUID id) {
        Documento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento não encontrado."));
        return toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentoResponse> findByVisibilidade(String visibilidade) {
        return repository.findByVisibilidadeIgnoreCase(visibilidade)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private DocumentoResponse toResponse(Documento entity) {
        return new DocumentoResponse(
                entity.getId(),
                entity.getTitulo(),
                entity.getDescricao(),
                entity.getArquivoUrl(),
                entity.getTipo(),
                entity.getVisibilidade(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
