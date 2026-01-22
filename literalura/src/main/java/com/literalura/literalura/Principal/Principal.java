package com.literalura.literalura.Principal;

import com.literalura.literalura.Model.Libro;
import com.literalura.literalura.Repositorio.LibroRepository;
import com.literalura.literalura.Servicio.ConsumoAPI;
import com.literalura.literalura.Servicio.ConvierteDatos;
import com.literalura.literalura.Servicio.LibroService;

import java.util.Optional;
import java.util.Scanner;

public class Principal {
    //private ConsumoAPI consumoAPI = new ConsumoAPI();
    //private ConvierteDatos conversor = new ConvierteDatos();
    private final Scanner teclado = new Scanner(System.in);
    private final LibroService libroService;


    public Principal(LibroService libroService) {
        this.libroService = libroService;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroTitulo();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                   mostrarAutoresRegistrados();
                    break;
                case 4:
                    mostrarAutoresVivos();
                    break;
                case 5:
                    mostrarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }
    //TODOS LOS METODOS IMPLEMENTADOS EN LibroService
    private void buscarLibroTitulo() {
        System.out.println("Ingrese el nombre del libro:");
        String nom = teclado.nextLine();

        libroService.buscarLibroPorTitulo(nom).ifPresentOrElse(System.out::println, () -> System.out.println("Libro no encontrado"));
    }

    private void mostrarLibrosRegistrados() {
        libroService.listarLibros().forEach(System.out::println);
    }
    private void mostrarAutoresRegistrados() {
        libroService.listarAutores().forEach(System.out::println);
    }
    private void mostrarAutoresVivos() {
        System.out.println("Ingrese el año: ");
        int anio = teclado.nextInt();
        teclado.nextLine();

        var autores =libroService.listarAutoresVivos(anio);
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en ese año.");
        } else {
            autores.forEach(System.out::println);
        }
    }
    private void mostrarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma (ej: es, en):");
        String idioma = teclado.nextLine();

        var libros = libroService.listadoPorIdioma(idioma);

        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros en ese idioma.");
        } else {
            libros.forEach(System.out::println);
        }
    }









}
