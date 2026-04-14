package com.ieadalpe.ieadalpeapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "documentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Documento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "titulo", nullable = false, length = 180)
    private String titulo;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "arquivo_url", nullable = false)
    private String arquivoUrl;

    @Column(name = "tipo", length = 80)
    private String tipo;

    @Column(name = "visibilidade", nullable = false, length = 50)
    @Builder.Default
    private String visibilidade = "obreiros";
}