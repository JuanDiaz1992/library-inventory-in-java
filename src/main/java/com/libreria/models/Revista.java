package com.libreria.models;

import com.libreria.models.bases.Recurso;

public class Revista extends Recurso {

    public Revista(String titulo, String autor, String editorial, int anhoPublicacion, double precio, String tipoRecurso) {
        super(titulo, autor, editorial, anhoPublicacion, precio, tipoRecurso);
    }
}
