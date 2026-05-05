package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.SolicitacaoObreiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SolicitacaoObreiroRepository extends JpaRepository<SolicitacaoObreiro, UUID> {
   // List<SolicitacaoObreiro> findByStatusIgnoreCase(String status);
   Page<SolicitacaoObreiro> findByStatusIgnoreCase(String status, Pageable pageable);
    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);
}
