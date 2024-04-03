package com.libreria;

import com.libreria.models.Libreria;
import com.libreria.models.Libro;
import com.libreria.models.MetodosEspeciales;
import com.libreria.models.Revista;
import com.libreria.models.bases.Recurso;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        //Los siguientes datos se añaden solo para probar las demás funciones sin necesidad de agregar nuevos datos
        libreria.agregar(new Libro("La sombra del viento", "Carlos Ruiz Zafón", "Planeta", 2015, 15000.0, "Libro"));
        libreria.agregar(new Revista("National Geographic", "Varios autores", "National Geographic Society", 2022, 5000.0, "Revista"));
        libreria.agregar(new Libro("Cien años de soledad", "Gabriel Garcia", "Sudamericana", 1967, 12000.0, "Libro"));
        libreria.agregar(new Revista("Time", "Varios autores", "Time USA, LLC", 2022, 4000.0, "Revista"));
        libreria.agregar(new Libro("El código Da Vinci", "Dan Brown", "Doubleday", 2003, 18000.0, "Libro"));
        libreria.agregar(new Libro("El amor en los tiempos del cólera", "Gabriel Garcia", "Sudamericana", 1985, 13000.0, "Libro"));
        //*************************************************************************************//

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("////////////////");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1) Agregar libro");
            System.out.println("2) Buscar por Título");
            System.out.println("3) Buscar por Autor");
            System.out.println("4) Mostrar inventario");
            System.out.println("5) Realizar préstamo");
            System.out.println("6) Devolver libro");
            System.out.println("0) Salir");
            System.out.print("Elija una opción: ");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    try {
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
                    MetodosEspeciales.pressEnter();
                    break;
                case 2:
                    System.out.println("Buscar recurso por título");
                    System.out.print("Ingrese el nombre del recurso (No es sensible a mayúsculas o minúsculas): ");
                    scanner.nextLine();
                    libreria.buscarTitulo(MetodosEspeciales.capitalizeFirstCharacter(scanner.nextLine()));
                    MetodosEspeciales.pressEnter();
                    break;
                case 3:
                    System.out.println("Buscar recurso por autor");
                    System.out.print("Ingrese el autor del recurso (No es sensible a mayúsculas o minúsculas): ");
                    scanner.nextLine();
                    libreria.buscarPorAutor(scanner.nextLine().toUpperCase());
                    MetodosEspeciales.pressEnter();
                    break;
                case 4:
                    libreria.mostrarInventario();
                    MetodosEspeciales.pressEnter();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                default:
                    break;
            }

        }while (option!=0);
    }



}