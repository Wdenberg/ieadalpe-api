package com.ieadalpe.ieadalpeapi.controller;

import com.ieadalpe.ieadalpeapi.dto.request.NoticiaCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.NoticiaResponse;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;
import com.ieadalpe.ieadalpeapi.service.interfaces.NoticiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/noticias")
@RequiredArgsConstructor
@Tag(name = "Noticias", description = "Endpoint de Operações de Gerenciamento dos Noticias")
public class NoticiaController {

    private final NoticiaService noticiaService;

    @Operation(summary = "Cria Noticias")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoticiaResponse create(@Valid @RequestBody NoticiaCreateRequest request) {
        return noticiaService.create(request);
    }
    @Operation(summary = "Buscar Noticias por ID")
    @GetMapping("/{id}")
    public NoticiaResponse findById(@PathVariable UUID id) {
        return noticiaService.findById(id);
    }

    @Operation(summary = "Busca Lista Noticias")
    @GetMapping
    public PagedResponse<NoticiaResponse> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return noticiaService.findAll(page, size);
    }
    @Operation(summary = "Busca Noticias Publicadas ")
    @GetMapping("/publicadas")
    public PagedResponse<NoticiaResponse> findPublished(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return noticiaService.findPublished(page, size);
    }

    @Operation(summary = "Deletar uma Noticia")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {noticiaService.delete(id);}
}