package com.ieadalpe.ieadalpeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    @GetMapping
    public Map<String, Object> health(){
        return Map.of(
                "status", "UP",
                "service","IEADALPE API",
                "timestamp", OffsetDateTime.now()
        );
    }

}
