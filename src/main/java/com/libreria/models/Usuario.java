package com.libreria.models;

import com.libreria.models.bases.Persona;
import com.libreria.models.bases.Recurso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Usuario extends Persona {
    private List<Recurso> historialPrestamos = new ArrayList<>();

    private boolean estadoCuenta = true;
    public Usuario(String nombre, int edad) {
        super(nombre.toUpperCase(Locale.ROOT), edad);
    }
    public void agregarAlHistorialDePrestamos(Recurso recurso){
        historialPrestamos.add(recurso);
    }
    public void verHistorialPrestamos(){
        if (!historialPrestamos.isEmpty()){
            System.out.println("El usuario "+this.getNombre()+" a prestado y devuelto "+historialPrestamos.size()+" recursos:");
            for (Recurso recurso: historialPrestamos){
                System.out.println("+ "+recurso.getTipoRecurso()+": "+ recurso.getTitulo()+", Isbn: "+recurso.getIsbn());
            }
        }else {
            System.out.println("El usuario aún no cuenta con historial");
        }
    }
    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("Id: ").append(id);
        sb.append(", Nombre: '").append(nombre).append('\'');
        sb.append(", Edad: ").append(edad);
        sb.append(", Estado de cuenta: ").append(estadoCuenta? "Activo":"Suspendido");
        sb.append('}');
        return sb.toString();
    }
}
