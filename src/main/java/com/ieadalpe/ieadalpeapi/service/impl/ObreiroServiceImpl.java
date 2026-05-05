package com.ieadalpe.ieadalpeapi.service.impl;

import com.ieadalpe.ieadalpeapi.domain.entity.Obreiro;
import com.ieadalpe.ieadalpeapi.domain.entity.Profile;
import com.ieadalpe.ieadalpeapi.dto.request.ObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.request.ObreiroUpdateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.ObreiroResponse;
import com.ieadalpe.ieadalpeapi.dto.response.PagedResponse;
import com.ieadalpe.ieadalpeapi.exception.DuplicateResourceException;
import com.ieadalpe.ieadalpeapi.exception.ResourceNotFoundException;
import com.ieadalpe.ieadalpeapi.mapper.ObreiroMapper;
import com.ieadalpe.ieadalpeapi.repository.ObreiroRepository;
import com.ieadalpe.ieadalpeapi.repository.ProfileRepository;
import com.ieadalpe.ieadalpeapi.service.interfaces.ObreiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ObreiroServiceImpl implements ObreiroService {

    private final ObreiroRepository obreiroRepository;
    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public ObreiroResponse create(ObreiroCreateRequest request) {
        if (obreiroRepository.existsByMatricula(request.matricula())) {
            throw new DuplicateResourceException("Já existe um obreiro com essa matrícula.");
        }

        Profile profile = profileRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("Perfil do usuário não encontrado."));

        obreiroRepository.findByUserId(request.userId()).ifPresent(o -> {
            throw new DuplicateResourceException("Esse usuário já possui cadastro de obreiro.");
        });

        Obreiro entity = ObreiroMapper.toEntity(request);
        entity.setUser(profile);

        Obreiro saved = obreiroRepository.save(entity);
        return ObreiroMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public ObreiroResponse update(UUID id, ObreiroUpdateRequest request) {
        Obreiro entity = obreiroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obreiro não encontrado."));

        ObreiroMapper.updateEntity(entity, request);
        Obreiro updated = obreiroRepository.save(entity);

        return ObreiroMapper.toResponse(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public ObreiroResponse findById(UUID id) {
        Obreiro entity = obreiroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obreiro não encontrado."));
        return ObreiroMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<ObreiroResponse> findAll(int page, int size) {
        Page<Obreiro> result = obreiroRepository.findAll(
                PageRequest.of(page, size, Sort.by("nome").ascending())
        );

        return new PagedResponse<>(
                result.getContent().stream().map(ObreiroMapper::toResponse).toList(),
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.isFirst(),
                result.isLast()
        );
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Obreiro entity = obreiroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obreiro não encontrado."));
        obreiroRepository.delete(entity);
    }
}