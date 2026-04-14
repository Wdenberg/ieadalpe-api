package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<Documento, UUID> {
    List<Documento> findByVisibilidadeIgnoreCase(String visibilidade);
}
