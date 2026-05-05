package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.LogoDepartamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LogoDepartamentoRepository extends JpaRepository<LogoDepartamento, UUID> {
    List<LogoDepartamento> findByAtivoTrue();
}
