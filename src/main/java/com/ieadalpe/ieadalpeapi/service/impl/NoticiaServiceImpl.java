package com.ieadalpe.ieadalpeapi.service.impl;

import com.ieadalpe.ieadalpeapi.domain.entity.Documento;
import com.ieadalpe.ieadalpeapi.domain.entity.Noticia;
import com.ieadalpe.ieadalpeapi.domain.entity.Profile;
import com.ieadalpe.ieadalpeapi.dto.request.NoticiaCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.NoticiaResponse;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;
import com.ieadalpe.ieadalpeapi.exception.ResourceNotFoundException;
import com.ieadalpe.ieadalpeapi.mapper.NoticiaMapper;
import com.ieadalpe.ieadalpeapi.repository.NoticiaRepository;
import com.ieadalpe.ieadalpeapi.repository.ProfileRepository;
import com.ieadalpe.ieadalpeapi.service.interfaces.NoticiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoticiaServiceImpl implements NoticiaService {

    private final NoticiaRepository noticiaRepository;
    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public NoticiaResponse create(NoticiaCreateRequest request) {
        Profile autor = profileRepository.findById(request.autorId())
                .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado."));

        Noticia noticia = NoticiaMapper.toEntity(request);
        noticia.setAutor(autor);
        noticia.setAutorNome(autor.getNome());

        Noticia saved = noticiaRepository.save(noticia);
        return NoticiaMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public NoticiaResponse findById(UUID id) {
        Noticia noticia = noticiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notícia não encontrada."));
        return NoticiaMapper.toResponse(noticia);
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<NoticiaResponse> findAll(int page, int size) {
        Page<Noticia> result = noticiaRepository.findAll(
                PageRequest.of(page, size, Sort.by("createdAt").descending())
        );

        return toPagedResponse(result);
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<NoticiaResponse> findPublished(int page, int size) {
        Page<Noticia> result = noticiaRepository.findByPublicadaTrue(
                PageRequest.of(page, size, Sort.by("createdAt").descending())
        );

        return toPagedResponse(result);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Noticia entity = noticiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento não encontrado."));
        noticiaRepository.delete(entity);
    }

    private PagedResponse<NoticiaResponse> toPagedResponse(Page<Noticia> result) {
        return new PagedResponse<>(
                result.getContent().stream().map(NoticiaMapper::toResponse).toList(),
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.isFirst(),
                result.isLast()
        );
    }
}