package com.ieadalpe.ieadalpeapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "contatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 180)
    private String email;


    @Column(name = "mensagem", nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Column(name = "lida", nullable = false)
    @Builder.Default
    private Boolean lida = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private java.time.OffsetDateTime createdAt;
}