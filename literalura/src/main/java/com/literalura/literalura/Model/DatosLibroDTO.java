package com.literalura.literalura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibroDTO(
        @JsonAlias("id") int id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors")List<DatosAutorDTO> autor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("copyright") Boolean copyright,
        @JsonAlias("download_count") Double numeroDeDescargas
) {
}
