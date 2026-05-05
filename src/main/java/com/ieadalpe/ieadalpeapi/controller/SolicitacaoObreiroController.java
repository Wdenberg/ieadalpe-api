package com.ieadalpe.ieadalpeapi.controller;

import com.ieadalpe.ieadalpeapi.dto.request.SolicitacaoObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;
import com.ieadalpe.ieadalpeapi.dto.response.SolicitacaoObreiroResponse;
import com.ieadalpe.ieadalpeapi.service.interfaces.SolicitacaoObreiroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/solicitacoes-obreiros")
@RequiredArgsConstructor
public class SolicitacaoObreiroController {

    private final SolicitacaoObreiroService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SolicitacaoObreiroResponse create(@Valid @RequestBody SolicitacaoObreiroCreateRequest request) {
        return service.create(request);
    }

    @GetMapping
    public PagedResponse<SolicitacaoObreiroResponse> findByStatus(
            @RequestParam(defaultValue = "pendente") String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.findByStatus(status, page, size);
    }
}