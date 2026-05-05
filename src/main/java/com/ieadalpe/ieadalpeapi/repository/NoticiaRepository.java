package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.Noticia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoticiaRepository extends JpaRepository<Noticia, UUID> {
    Page<Noticia> findByPublicadaTrue(Pageable pageable);
    Page<Noticia> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);

}
