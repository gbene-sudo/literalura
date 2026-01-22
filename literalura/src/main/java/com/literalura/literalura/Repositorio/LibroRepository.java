package com.literalura.literalura.Repositorio;

import com.literalura.literalura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String nom);
    Optional<Libro> findByApiId(Integer apiId);
    List<Libro> findByIdiomaIgnoreCase(String idioma);
}
