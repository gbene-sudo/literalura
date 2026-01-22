package com.literalura.literalura.Servicio;

import com.literalura.literalura.Model.Autor;
import com.literalura.literalura.Model.DatosAutorDTO;
import com.literalura.literalura.Model.DatosLibroDTO;
import com.literalura.literalura.Model.Libro;

import java.util.List;

public class LibroMapper {
    public static Libro toEntity(DatosLibroDTO dto) {
        Libro libro = new Libro();
        libro.setApiId(dto.id());
        libro.setTitulo(dto.titulo());
        libro.setIdioma(dto.idioma().get(0));
        libro.setCopyright(dto.copyright());
        libro.setNumeroDescargas(dto.numeroDeDescargas());

    //creo una lista de autores, convirtiendo cada dato dto en una entidad Autor
        List<Autor> autores = dto.autor().stream()
                .map(LibroMapper::autorToEntity)
                .toList();
        libro.setAutores(autores);

        return libro;
    }
    private static Autor autorToEntity(DatosAutorDTO dto) {
        Autor autor = new Autor();
        autor.setNombre(dto.nombre());
        autor.setFechaNacimiento(
                dto.fechaNacimiento() != null && !dto.fechaNacimiento().isBlank()
                        ? Integer.valueOf(dto.fechaNacimiento()) : null);
        autor.setFechaMuerte(
                dto.fechaMuerte() != null && !dto.fechaMuerte().isBlank()
                        ? Integer.valueOf(dto.fechaMuerte()) : null);

        return autor;
    }
}
