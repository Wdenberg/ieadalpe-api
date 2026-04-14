package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.SolicitacaoObreiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SolicitacaoObreiroRepository extends JpaRepository<SolicitacaoObreiro, UUID> {
    List<SolicitacaoObreiro> findByStatusIgnoreCase(String status);
    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);
}
