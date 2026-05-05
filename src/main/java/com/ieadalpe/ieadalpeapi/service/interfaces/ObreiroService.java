package com.ieadalpe.ieadalpeapi.service.interfaces;

import com.ieadalpe.ieadalpeapi.dto.request.ObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.request.ObreiroUpdateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.ObreiroResponse;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;

import java.util.UUID;

public interface ObreiroService {
    ObreiroResponse create(ObreiroCreateRequest request);
    ObreiroResponse update(UUID id, ObreiroUpdateRequest request);
    ObreiroResponse findById(UUID id);
    PagedResponse<ObreiroResponse> findAll(int page, int size);
    void delete(UUID id);
}