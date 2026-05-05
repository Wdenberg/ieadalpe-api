package com.ieadalpe.ieadalpeapi.controller;

import com.ieadalpe.ieadalpeapi.integration.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class HealthIntegrationTest extends AbstractIntegrationTest {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnHealthUp() {
        ResponseEntity<String> response =
                restTemplate.getForEntity("http://localhost:" + port + "/api/v1/health", String.class);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().contains("UP"));
    }
}
