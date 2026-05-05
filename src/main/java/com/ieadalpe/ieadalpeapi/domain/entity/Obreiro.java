package com.ieadalpe.ieadalpeapi.domain.entity;

import com.ieadalpe.ieadalpeapi.config.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "obreiros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Obreiro extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private Profile user;

    @Column(name = "matricula", nullable = false, unique = true, length = 50)
    private String matricula;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "funcao", length = 100)
    private String funcao;

    @Column(name = "setor", length = 120)
    private String setor;

    @Column(name = "congregacao", length = 120)
    private String congregacao;

    @Column(name = "telefone", length = 30)
    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_batismo")
    private LocalDate dataBatismo;

    @Column(name = "anos_obreiro")
    private Integer anosObreiro;

    @Column(name = "foto_url")
    private String fotoUrl;

    @Column(name = "bloqueado", nullable = false)
    @Builder.Default
    private Boolean bloqueado = false;

    @Column(name = "ultimo_acesso")
    private OffsetDateTime ultimoAcesso;

    @OneToMany(mappedBy = "obreiro", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<EboParticipacao> participacoesEbo = new ArrayList<>();
}
