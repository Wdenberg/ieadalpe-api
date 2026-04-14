package com.ieadalpe.ieadalpeapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "solicitacoes_obreiros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitacaoObreiro extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 180)
    private String email;

    @Column(name = "matricula", nullable = false, length = 50)
    private String matricula;

    @Column(name = "senha_temp", nullable = false, length = 255)
    private String senhaTemp;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "setor", length = 120)
    private String setor;

    @Column(name = "congregacao", length = 120)
    private String congregacao;

    @Column(name = "status", nullable = false, length = 50)
    @Builder.Default
    private String status = "pendente";

    @Column(name = "motivo_rejeicao", length = 500)
    private String motivoRejeicao;
}