package com.ieadalpe.ieadalpeapi.controller;

import com.ieadalpe.ieadalpeapi.dto.request.ObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.request.ObreiroUpdateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.ObreiroResponse;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;
import com.ieadalpe.ieadalpeapi.service.interfaces.ObreiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/obreiros")
@RequiredArgsConstructor
@Tag(name = "Obreiro", description = "Endpoint de Operações de gerenciamento dos Obreiros")
public class ObreiroController {

    private final ObreiroService obreiroService;

    @Operation(summary = "Cria Obreiro", description = "Cria um Novo Obreiro")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ObreiroResponse create(@Valid @RequestBody ObreiroCreateRequest request) {
        return obreiroService.create(request);
    }

    @Operation(summary = "Atualizar Obreiro")
    @PutMapping("/{id}")
    public ObreiroResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody ObreiroUpdateRequest request
    ) {
        return obreiroService.update(id, request);
    }

    @Operation(summary = "Buscar Obreiro Por ID")
    @GetMapping("/{id}")
    public ObreiroResponse findById(@PathVariable UUID id) {
        return obreiroService.findById(id);
    }

    @Operation(summary = "Lista Obreiros ")
    @GetMapping
    public PagedResponse<ObreiroResponse> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return obreiroService.findAll(page, size);
    }

    @Operation(summary = "Deletar um Obreiro")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        obreiroService.delete(id);
    }
}