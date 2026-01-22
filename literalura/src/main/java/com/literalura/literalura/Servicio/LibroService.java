package com.literalura.literalura.Servicio;

import com.literalura.literalura.Model.*;
import com.literalura.literalura.Repositorio.AutorRepository;
import com.literalura.literalura.Repositorio.LibroRepository;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private static final String URL_BASE = "https://gutendex.com/books/?search=";
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final ConsumoAPI consumoAPI;
    private final ConvierteDatos conversor;

    public LibroService(AutorRepository Arepository,LibroRepository Lrepository, ConsumoAPI consumoAPI, ConvierteDatos conversor) {
        this.libroRepository = Lrepository;
        this.autorRepository = Arepository;
        this.consumoAPI = consumoAPI;
        this.conversor = conversor;
    }

    public Optional<Libro> buscarLibroPorTitulo(String titulo) {
        String url = URL_BASE + titulo.replace(" ", "%20");
        String json = consumoAPI.obtenerDatos(url);

        DatosDTO datos = conversor.obtenerDatos(json, DatosDTO.class);
        if (datos.resultados().isEmpty()){
            return Optional.empty();
        }

        DatosLibroDTO libroDTO = datos.resultados().get(0);
        return libroRepository.findByTituloContainsIgnoreCase(libroDTO.titulo())
                .or(() -> Optional.of(libroRepository.save(mapeoLibro(libroDTO))));

    }

    private Libro mapeoLibro(DatosLibroDTO dto){ //toma los datos crudos de la API en json y los convierte en entidades para despues poder guardarlas en la db
        Libro libro = new Libro();
        libro.setTitulo(dto.titulo());
        libro.setIdioma(dto.idioma().get(0));
        libro.setNumeroDescargas(dto.numeroDeDescargas());

    //Hay que hacer esto porque setAutores() pide como parametro una lista
        List<Autor> autores = dto.autor()
                .stream()
                .map(this::mapeoAutor)
                .toList();

        libro.setAutores(autores);
        return libro;
    };
    private Autor mapeoAutor(DatosAutorDTO dto){
        Autor autor = new Autor();
        autor.setNombre(dto.nombre());
        autor.setFechaNacimiento(
                dto.fechaNacimiento() != null
                        ? Integer.valueOf(dto.fechaNacimiento()) : null);
        autor.setFechaMuerte(
                dto.fechaMuerte() != null
                        ? Integer.valueOf(dto.fechaMuerte()) : null);

        return autor;
    };

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }
    public List<Autor> listarAutoresVivos(int anio) {
        return autorRepository.autoresVivosEn(anio);
    }
    public List<Libro> listadoPorIdioma(String idioma) {
        return libroRepository.findByIdiomaIgnoreCase(idioma);
    }
}
