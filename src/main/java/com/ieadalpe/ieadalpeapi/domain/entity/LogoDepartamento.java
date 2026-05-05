package com.ieadalpe.ieadalpeapi.domain.entity;

import com.ieadalpe.ieadalpeapi.config.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "logos_departamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogoDepartamento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_departamento", nullable = false, length = 120)
    private String nomeDepartamento;

    @Column(name = "arquivo_url", nullable = false)
    private String arquivoUrl;

    @Column(name = "formato", length = 20)
    private String formato;

    @Column(name = "ativo", nullable = false)
    @Builder.Default
    private Boolean ativo = true;
}