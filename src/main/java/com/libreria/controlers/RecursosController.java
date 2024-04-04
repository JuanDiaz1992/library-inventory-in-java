package com.libreria.controlers;

import com.libreria.models.Libreria;
import com.libreria.models.Libro;
import com.libreria.models.Revista;
import com.libreria.models.bases.Recurso;
import com.libreria.scripts.MetodosEspeciales;

import java.util.Scanner;

public class RecursosController {
    static Scanner scanner = new Scanner(System.in);
    public static void agregar(Libreria libreria){
    try{

        System.out.println("AGREGAR NUEVO RECURSO");
        System.out.println("Elija el tipo de recurso");
        System.out.println("1) Libro");
        System.out.println("2) Revista");
        System.out.print("Ingrese una opción: ");
        int opcionRecurso = scanner.nextInt();
        String tipoRecurso = null;
        if (opcionRecurso !=1 && opcionRecurso !=2){
            throw new RuntimeException("Error");
        } else if (opcionRecurso == 1) {
            tipoRecurso = "Libro";
        } else {
            tipoRecurso = "Revista";
        }
        System.out.print("Ingrese el nombre "+(opcionRecurso ==1? "del libro: ":"de la revista: "));
        scanner.nextLine();
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el primer nombre y primer apellido del autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el nombre de la editorial: ");
        String editorial = scanner.nextLine();
        System.out.print("Ingrese el año la publicación "+(opcionRecurso ==1? "del libro: ":"de la revista: "));
        int anhoPublicacion = scanner.nextInt();
        System.out.print("Ingrese el precio en COP: $");
        double precio = scanner.nextDouble();
        Recurso recurso = null;
        if (opcionRecurso == 1){
            recurso = new Libro(titulo,autor,editorial,anhoPublicacion,precio,tipoRecurso);
        }else{
            recurso = new Revista(titulo,autor,editorial,anhoPublicacion,precio,tipoRecurso);
        }
        libreria.agregar(recurso);

    }catch (Exception e){
        System.out.println("El valor ingresado es incorrecto, intentelo de nuevo");
    }
}

    public static void buscarPorTitulo(Libreria libreria){
        System.out.print("Ingrese el nombre del recurso (No es sensible a mayúsculas o minúsculas): ");
        Recurso recurso = libreria.buscarTitulo(MetodosEspeciales.capitalizeFirstCharacter(scanner.nextLine()));
        if (recurso!=null){
            System.out.println("Se encontro una coincidencia: "+recurso.getTitulo());
        }else {
            System.out.println("No se encontró ninguna coincidencia");
        }


    }
    public static void buscarPorAutor(Libreria libreria){
        System.out.print("Ingrese el autor del recurso (No es sensible a mayúsculas o minúsculas): ");
        //scanner.nextLine();
        libreria.buscarPorAutor(scanner.nextLine().toUpperCase());

    }
    public static void verInventario(Libreria libreria){
        libreria.mostrarInventario();
    }
}
