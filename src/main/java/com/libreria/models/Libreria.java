package com.libreria.models;

import com.libreria.models.bases.IadministrarBiblioteca;
import com.libreria.models.bases.Recurso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Libreria implements IadministrarBiblioteca {
    private HashMap<String, Recurso> inventario = new HashMap<>();

    @Override
    public void agregar(Recurso recurso) {
        if (inventario.get(recurso.getTitulo()) == null){
            inventario.put(recurso.getTitulo(), recurso);
            System.out.println((recurso.getTipoRecurso() =="Libro"? "El libro ":"La revista ")+recurso.getTitulo()+" se agregó correctamente al inventario.");
        }else {
            System.out.println("El libro ingresado ya existe en el inventario");
        }

    }
    @Override
    public Recurso buscarTitulo(String titulo) {
        return inventario.get(titulo);
    }

    @Override
    public void buscarPorAutor(String autor) {
        ArrayList<Recurso> element = new ArrayList<>();
        for (HashMap.Entry<String, Recurso> entry : inventario.entrySet()) {
            if (autor.equals(entry.getValue().getAutor())) {
                element.add(entry.getValue());
            }
        }
        if (!element.isEmpty()){
            System.out.println(element.size()==1? "Se encontro una coincidencia: " : "Se encontraron " +element.size()+" conicidencias: " );
            for(Recurso recurso: element){
                System.out.println(recurso);
            }
        }else {
            System.out.println("No se encontró ninguna coincidencia");
        }
    }
    public Recurso buscarIbsn(int isbn) {
        Recurso recurso = null;
        for (HashMap.Entry<String, Recurso> entry : inventario.entrySet()) {
            if (isbn == entry.getValue().getIsbn()) {
                recurso = entry.getValue();
            }
        }
        return recurso;

    }

    @Override
    public void mostrarInventario() {
        if (!inventario.isEmpty()){
            for (Map.Entry<String, Recurso> entry: inventario.entrySet()){
                String key = entry.getKey();
                Recurso value = entry.getValue();
                System.out.println(" "+value);
            }
            System.out.println("Hay " + inventario.size() +" registros en total" );
        }else{
            System.out.println("Aun no se han agregado libros al inventario.");
        }

    }
    public void eliminarRecurso(Recurso recurso){
        inventario.remove(recurso.getTitulo());
    }
}
