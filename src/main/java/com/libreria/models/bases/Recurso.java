package com.libreria.models.bases;

import com.libreria.scripts.Scripts;

public class Recurso {

    private static int contadorIsbn = 0;
    protected String titulo;
    protected String autor;
    protected int isbn;
    protected String editorial;
    protected int anhoPublicacion;
    protected double precio;
    protected String tipoRecurso;
    protected EstadosRecursos estadoLibro = EstadosRecursos.DISPONIBLE;

    public Recurso(String titulo, String autor, String editorial, int anhoPublicacion, double precio, String tipoRecurso){
        this.isbn = ++contadorIsbn;
        this.titulo = Scripts.capitalizeFirstCharacter(titulo);
        this.autor = autor.toUpperCase();
        this.editorial = Scripts.capitalizeFirstCharacter(editorial);
        this.anhoPublicacion = anhoPublicacion;
        this.precio = precio;
        this.tipoRecurso = tipoRecurso;
    }

    public EstadosRecursos getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(EstadosRecursos estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = Scripts.capitalizeFirstCharacter(titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor.toUpperCase();
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = Scripts.capitalizeFirstCharacter(editorial) ;
    }

    public int getAnhoPublicacion() {
        return anhoPublicacion;
    }

    public void setAnhoPublicacion(int anhoPublicacion) {
        this.anhoPublicacion = anhoPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getTipoRecurso() {
        return tipoRecurso;
    }
    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recurso{");
        sb.append("Isbn: ").append(isbn).append('\'');;
        sb.append(", Título: '").append(titulo).append('\'');
        sb.append(", Autor: '").append(autor).append('\'');
        sb.append(", Editorial: '").append(editorial).append('\'');
        sb.append(", Año de publicación: ").append(anhoPublicacion).append('\'');;
        sb.append(", Precio: $").append(precio).append('\'');;
        sb.append(", Tipo de recurso: ").append(tipoRecurso).append('\'');;
        sb.append(", Estado: ").append(estadoLibro).append('\'');;
        sb.append('}');
        return sb.toString();
    }

}
