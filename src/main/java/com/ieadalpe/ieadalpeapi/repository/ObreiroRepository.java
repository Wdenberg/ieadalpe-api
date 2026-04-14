package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.Obreiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ObreiroRepository extends JpaRepository<Obreiro, UUID> {
    Optional<Obreiro> findByMatricula(String matricula);
    Optional<Obreiro> findByUserId(UUID userId);
    boolean existsByMatricula(String matricula);
}
