package com.ieadalpe.ieadalpeapi.controller;

import com.ieadalpe.ieadalpeapi.dto.request.DocumentoCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.DocumentoResponse;
import com.ieadalpe.ieadalpeapi.service.interfaces.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/documentos")
@RequiredArgsConstructor
@Tag(name = "Documentos", description = "Endpoint de Operações de gerenciamento dos Documentos")
public class DocumentoController {

    private final DocumentoService service;

    @Operation(summary = "Cria Documento")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentoResponse create(@Valid @RequestBody DocumentoCreateRequest request) {
        return service.create(request);
    }

    @Operation(summary = "Busca Documento por ID")
    @GetMapping("/{id}")
    public DocumentoResponse findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @Operation(summary = "Busca Lista de Docuementos")
    @GetMapping
    public List<DocumentoResponse> findByVisibilidade(
            @RequestParam(defaultValue = "obreiros") String visibilidade
    ) {
        return service.findByVisibilidade(visibilidade);
    }

    @Operation(summary = "Deletar um Documento")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {service.delete(id);}
}