package com.ieadalpe.ieadalpeapi.service.interfaces;

import com.ieadalpe.ieadalpeapi.dto.request.NoticiaCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.NoticiaResponse;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;

import java.util.UUID;

public interface NoticiaService {
    NoticiaResponse create(NoticiaCreateRequest request);
    NoticiaResponse findById(UUID id);
    PagedResponse<NoticiaResponse> findAll(int page, int size);
    PagedResponse<NoticiaResponse> findPublished(int page, int size);
    void delete(UUID id);
}
