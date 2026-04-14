package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

public interface NoticiaRepository extends JpaRepository<Noticia, UUID> {
    Optional<Noticia> findByPublicadaTrue(Pageable pageable);
    Optional<Noticia> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);

}
