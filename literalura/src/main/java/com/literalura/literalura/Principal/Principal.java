package com.literalura.literalura.Principal;

import com.literalura.literalura.Repositorio.LibroRepository;
import com.literalura.literalura.Servicio.ConsumoAPI;
import com.literalura.literalura.Servicio.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books?ids=";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private LibroRepository repositorio;


    public Principal(LibroRepository repository) {
        this.repositorio = repository;
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

//    private void buscarLibroTitulo() {
//        System.out.println("Ingrese el nombre del libro: ");
//        var nom = teclado.nextLine();
//        Optional<Datos> libroBuscado = repositorio.findByTituloContainsIgnoreCase(nom);
//        if (libroBuscado.isPresent()){
//            System.out.println(libroBuscado.get());
//        }else {
//            System.out.println("Libro no encontrado");
//        }
//    }

}
