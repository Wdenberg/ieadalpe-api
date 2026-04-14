package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.EboParticipacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EboParticipacaoRepository extends JpaRepository<EboParticipacao, UUID> {
    List<EboParticipacao> findByObreiroId(UUID obreiroId);
    List<EboParticipacao> findByAno(Integer ano);
}
