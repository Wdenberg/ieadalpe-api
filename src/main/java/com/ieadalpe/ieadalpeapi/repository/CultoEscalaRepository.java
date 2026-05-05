package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.CultoEscala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CultoEscalaRepository extends JpaRepository<CultoEscala, UUID> {
    List<CultoEscala> findByAtualTrue();
}
