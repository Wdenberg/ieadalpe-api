package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.LogAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LogAcessoRepository extends JpaRepository<LogAcesso, UUID> {
    List<LogAcesso> findByUserId(UUID userId);
}
