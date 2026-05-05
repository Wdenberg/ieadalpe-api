package com.ieadalpe.ieadalpeapi.service.interfaces;

import com.ieadalpe.ieadalpeapi.dto.request.SolicitacaoObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;
import com.ieadalpe.ieadalpeapi.dto.response.SolicitacaoObreiroResponse;

public interface SolicitacaoObreiroService {
    SolicitacaoObreiroResponse create(SolicitacaoObreiroCreateRequest request);
    PagedResponse<SolicitacaoObreiroResponse> findByStatus(String status, int page, int size);
}