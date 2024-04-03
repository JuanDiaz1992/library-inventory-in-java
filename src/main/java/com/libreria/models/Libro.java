package com.libreria.models;

import com.libreria.models.bases.Recurso;

public class Libro extends Recurso {


    public Libro(String titulo, String autor, String editorial, int anhoPublicacion, double precio, String tipoRecurso) {
        super(titulo, autor, editorial, anhoPublicacion, precio, tipoRecurso);
    }
}
