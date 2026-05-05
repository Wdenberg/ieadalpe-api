package com.ieadalpe.ieadalpeapi.service.interfaces;

import com.ieadalpe.ieadalpeapi.dto.request.DocumentoCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.DocumentoResponse;

import java.util.List;
import java.util.UUID;

public interface DocumentoService {
    DocumentoResponse create(DocumentoCreateRequest request);
    DocumentoResponse findById(UUID id);
    List<DocumentoResponse> findByVisibilidade(String visibilidade);
    void delete(UUID id);
}