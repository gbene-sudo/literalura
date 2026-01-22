package com.literalura.literalura.Model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true) // id que viene de la API (opcional pero recomendado)
    private Integer apiId;
    private String titulo;
    private String idioma;
    private boolean copyright;
    private double numeroDescargas;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //@ManyToMany porque un libro puede tener varios autores, un autor puede tener varios libros
    private List<Autor> autores;

    public Libro(){};//constructor default para que JPA no tire errrores

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "---- LIBRO ----" + "\n" +
                " Titulo: " + titulo + "\n" +
                " Idioma: " + idioma + "\n" +
                " Copyright: " + copyright+ "\n" +
                " NumeroDescargas:" + numeroDescargas +"\n" +
                " Autores: " + autores + "\n";
    }
}
