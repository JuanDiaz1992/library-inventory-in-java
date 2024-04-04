package com.libreria.models.bases;

import java.util.List;

public class Persona {
    protected int id;
    private static int contadorId = 0;
    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad){
        this.id = ++contadorId;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("Id=").append(id);
        sb.append(", Nombre='").append(nombre).append('\'');
        sb.append(", Edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
}
