package com.ieadalpe.ieadalpeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ieadalpe.ieadalpeapi.dto.request.ObreiroCreateRequest;
import com.ieadalpe.ieadalpeapi.dto.response.ObreiroResponse;
import com.ieadalpe.ieadalpeapi.service.interfaces.ObreiroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ObreiroController.class)
class ObreiroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ObreiroService obreiroService;

    @Test
    void shouldCreateObreiroAndReturn201() throws Exception {
        UUID userId = UUID.randomUUID();
        UUID obreiroId = UUID.randomUUID();

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
                2,
                null
        );

        ObreiroResponse response = new ObreiroResponse(
                obreiroId,
                userId,
                "MAT-001",
                "João da Silva",
                "Diácono",
                "Louvor",
                "Sede",
                "81999999999",
                null,
                null,
                2,
                null,
                false,
                null,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        Mockito.when(obreiroService.create(Mockito.any())).thenReturn(response);

        mockMvc.perform(post("/api/v1/obreiros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.matricula").value("MAT-001"))
                .andExpect(jsonPath("$.nome").value("João da Silva"));
    }
}
