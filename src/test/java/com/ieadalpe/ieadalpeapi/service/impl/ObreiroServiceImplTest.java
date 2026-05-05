package com.ieadalpe.ieadalpeapi.service.impl;

import com.ieadalpe.ieadalpeapi.domain.entity.Obreiro;
import com.ieadalpe.ieadalpeapi.domain.entity.Profile;
import com.ieadalpe.ieadalpeapi.dto.request.ObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.exception.DuplicateResourceException;
import com.ieadalpe.ieadalpeapi.exception.ResourceNotFoundException;
import com.ieadalpe.ieadalpeapi.repository.ObreiroRepository;
import com.ieadalpe.ieadalpeapi.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObreiroServiceImplTest {

    @Mock
    private ObreiroRepository obreiroRepository;

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ObreiroServiceImpl obreiroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateObreiroSuccessfully() {
        UUID userId = UUID.randomUUID();

        ObreiroCreateRequest request = new ObreiroCreateRequest(
                userId,
                "MAT-001",
                "João da Silva",
                "Diácono",
                "Louvor",
                "Sede",
                "81999999999",
                null,
                null,
                5,
                null
        );

        Profile profile = Profile.builder()
                .id(userId)
                .nome("João da Silva")
                .email("joao@email.com")
                .build();

        when(obreiroRepository.existsByMatricula("MAT-001")).thenReturn(false);
        when(profileRepository.findById(userId)).thenReturn(Optional.of(profile));
        when(obreiroRepository.findByUserId(userId)).thenReturn(Optional.empty());
        when(obreiroRepository.save(any(Obreiro.class))).thenAnswer(invocation -> {
            Obreiro obreiro = invocation.getArgument(0);
            obreiro.setId(UUID.randomUUID());
            return obreiro;
        });

        var response = obreiroService.create(request);

        assertNotNull(response);
        assertEquals("MAT-001", response.matricula());
        assertEquals("João da Silva", response.nome());
        verify(obreiroRepository, times(1)).save(any(Obreiro.class));
    }

    @Test
    void shouldThrowWhenMatriculaAlreadyExists() {
        UUID userId = UUID.randomUUID();

        ObreiroCreateRequest request = new ObreiroCreateRequest(
                userId, "MAT-001", "João", null, null, null, null, null, null, null, null
        );

        when(obreiroRepository.existsByMatricula("MAT-001")).thenReturn(true);

        assertThrows(DuplicateResourceException.class, () -> obreiroService.create(request));
    }

    @Test
    void shouldThrowWhenProfileNotFound() {
        UUID userId = UUID.randomUUID();

        ObreiroCreateRequest request = new ObreiroCreateRequest(
                userId, "MAT-001", "João", null, null, null, null, null, null, null, null
        );

        when(obreiroRepository.existsByMatricula("MAT-001")).thenReturn(false);
        when(profileRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> obreiroService.create(request));
    }
}