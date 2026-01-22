package com.literalura.literalura.Repositorio;

import com.literalura.literalura.Model.DatosDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<DatosDTO, Long> {
    Optional<DatosDTO> findByTituloContainsIgnoreCase(String nom);
}
