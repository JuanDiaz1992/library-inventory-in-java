package com.libreria.scripts;

import com.libreria.controlers.GestorUsuariosController;
import com.libreria.controlers.PrestamosYDevolucionesController;
import com.libreria.models.*;
import com.libreria.models.bases.Recurso;

import java.util.Scanner;

public class MetodosEspeciales {
    public static String capitalizeFirstCharacter (String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        } else {
            return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
        }
    }
    public static void pressEnter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona Enter para continúar");
        scanner.nextLine();
    }
    public static void agregarElementosRamdon(Libreria libreria){
        //Los siguientes datos se añaden solo para probar las demás funciones sin necesidad de agregar nuevos datos
        Recurso recurso = new Libro("La sombra del viento", "Carlos Ruiz Zafón", "Planeta", 2015, 15000.0, "Libro");
        libreria.agregar(recurso);
        libreria.agregar(new Revista("National Geographic", "Varios autores", "National Geographic Society", 2022, 5000.0, "Revista"));
        libreria.agregar(new Libro("Cien años de soledad", "Gabriel Garcia", "Sudamericana", 1967, 12000.0, "Libro"));
        libreria.agregar(new Revista("Time", "Varios autores", "Time USA, LLC", 2022, 4000.0, "Revista"));
        libreria.agregar(new Libro("El código Da Vinci", "Dan Brown", "Doubleday", 2003, 18000.0, "Libro"));
        libreria.agregar(new Libro("El amor en los tiempos del cólera", "Gabriel Garcia", "Sudamericana", 1985, 13000.0, "Libro"));

        //Se crean usuarios Ramdon
        Usuario usuario = new Usuario("Juan Camilo Díaz Valencia",32);
        GestorUsuariosController.agregarUsuario(usuario);
        GestorUsuariosController.agregarUsuario(new Usuario("María Fernanda López Gómez", 28));
        GestorUsuariosController.agregarUsuario(new Usuario("Luis Alberto Ramírez Rodríguez", 35));
        GestorUsuariosController.agregarUsuario(new Usuario("Ana María García Pérez", 40));
        GestorUsuariosController.agregarUsuario(new Usuario("Pedro José Martínez Herrera", 25));
        GestorUsuariosController.agregarUsuario(new Usuario("Carolina Sánchez Jiménez", 31));
        GestorUsuariosController.agregarUsuario(new Usuario("Andrés Felipe González Vargas", 22));


        //Se añade un prestamo y se genera un retraso para poder visualizar las funcionalidades
        PrestamosYDevolucionesController.generarPrestamoRecurso(recurso,usuario);
        Prestamo prestamo = PrestamosYDevolucionesController.getPrestamo(recurso);
        prestamo.setContadorDias(40);
        prestamo.validarRetraso();
    }
}
