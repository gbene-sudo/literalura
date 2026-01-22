package com.literalura.literalura.Repositorio;

import com.literalura.literalura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    @Query("""
            SELECT a FROM Autor a WHERE a.fechaNacimiento <= :anio
            AND (a.fechaMuerte IS NULL OR a.fechaMuerte >= :anio)
            """)
    List<Autor> autoresVivosEn(@Param("anio") int anio);
}
