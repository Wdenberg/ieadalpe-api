package com.ieadalpe.ieadalpeapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "noticias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Noticia extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Lob
    @Column(name = "conteudo", nullable = false)
    private String conteudo;

    @Column(name = "resumo", length = 500)
    private String resumo;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @Column(name = "publicada", nullable = false)
    @Builder.Default
    private Boolean publicada = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Profile autor;

    @Column(name = "autor_nome", length = 150)
    private String autorNome;
}