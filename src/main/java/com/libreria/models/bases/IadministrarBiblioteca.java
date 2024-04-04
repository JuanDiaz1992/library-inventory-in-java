package com.libreria.models.bases;

import java.util.HashMap;

public interface IadministrarBiblioteca {
    HashMap<String, Recurso> inventario = null;
    void agregar(Recurso recurso);
    Recurso buscarTitulo(String titulo);
    void buscarPorAutor(String autor);
    void mostrarInventario();
}
