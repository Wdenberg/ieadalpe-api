package com.ieadalpe.ieadalpeapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ebo_participacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EboParticipacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "obreiro_id", nullable = false)
    private Obreiro obreiro;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "status", nullable = false, length = 60)
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}