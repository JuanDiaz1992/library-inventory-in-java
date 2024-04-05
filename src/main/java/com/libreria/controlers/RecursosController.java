package com.libreria.controlers;

import com.libreria.models.Libreria;
import com.libreria.models.Libro;
import com.libreria.models.Revista;
import com.libreria.models.bases.EstadosLibros;
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
        System.out.println("Oprima enter");
        scanner.nextLine();
        System.out.print("Ingrese el nombre del recurso (No es sensible a mayúsculas o minúsculas): ");
        Recurso recurso = libreria.buscarTitulo(MetodosEspeciales.capitalizeFirstCharacter(scanner.nextLine()));
        if (recurso!=null){
            System.out.println("Se encontro una coincidencia: ");
            System.out.println(recurso);
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

    public static void editarRecurso(Libreria libreria) {
        System.out.print("Ingrese el ISBN del recurso: ");
        int isbn = scanner.nextInt();
        Recurso recurso = libreria.buscarIbsn(isbn);
        if (recurso == null){
            System.out.println("Recurso no encontrado");
            MetodosEspeciales.pressEnter();
        }else if(recurso.getEstadoLibro() != EstadosLibros.DISPONIBLE){
            System.out.println("El recurso no puede ser modificado ya que se en estado: "+ recurso.getEstadoLibro());
            MetodosEspeciales.pressEnter();
        }else{
            int opcionModificar;
            do {System.out.println("  ////////////////");
                System.out.println("  Indica que quieres modificar del recurso");
                System.out.println("  "+recurso);
                System.out.println("  1. Titulo");
                System.out.println("  2. Autor");
                System.out.println("  3. Editorial");
                System.out.println("  4. Año publicación");
                System.out.println("  5. Precio");
                System.out.println("  0. Para ir atrás");
                System.out.print("Elija una opción: ");
                opcionModificar = scanner.nextInt();
                switch (opcionModificar){
                    case 1:
                        System.out.println("Titulo");
                        scanner.nextLine();
                        System.out.print("Ingrese el nuevo titulo: ");
                        String titulo = scanner.nextLine();
                        libreria.eliminarRecurso(recurso); // Se debe eliminar de la librería ya que la clave con la que se encuentra es el mismo titulo
                        recurso.setTitulo(titulo);
                        libreria.agregar(recurso); //Aquí se guarda nuevamente en la librería con el nuevo titulo
                        System.out.println("Titulo cambiado correctamente");
                        MetodosEspeciales.pressEnter();
                        break;
                    case 2:
                        System.out.println("Autor");
                        scanner.nextLine();
                        System.out.print("Ingrese el nuevo Autor: ");
                        String autor = scanner.nextLine();
                        recurso.setAutor(autor);
                        System.out.println("Autor cambiado correctamente");
                        MetodosEspeciales.pressEnter();
                        break;
                    case 3:
                        System.out.println("Editorial");
                        scanner.nextLine();
                        System.out.print("Ingrese la nueva Editorial: ");
                        String editorial = scanner.nextLine();
                        recurso.setEditorial(editorial);
                        System.out.println("Editorial cambiada correctamente");
                        MetodosEspeciales.pressEnter();
                        break;
                    case 4:
                        System.out.println("Año publicación");
                        System.out.print("Ingrese el nuevo Año de Publicación: ");
                        int anho = scanner.nextInt();
                        recurso.setAnhoPublicacion(anho);
                        System.out.println("Año de Publicación cambiado correctamente ");
                        MetodosEspeciales.pressEnter();
                        break;
                    case 5:
                        System.out.println("Precio");
                        System.out.print("Ingrese el nuevo Precio: ");
                        double precio = scanner.nextInt();
                        recurso.setPrecio(precio);
                        System.out.println("Precio cambiado correctamente");
                        MetodosEspeciales.pressEnter();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Elija una opción valida");
                }
            }while (opcionModificar !=0);
        }
    }

    public static void eliminarRecurso(Libreria libreria) {
        System.out.print("Ingrese el ISBN del recurso: ");
        int isbn = scanner.nextInt();
        Recurso recurso = libreria.buscarIbsn(isbn);
        if (recurso == null){
            System.out.println("Recurso no encontrado");
            MetodosEspeciales.pressEnter();
        }else if(recurso.getEstadoLibro() != EstadosLibros.DISPONIBLE){
            System.out.println("El recurso no puede ser eliminado ya que se encuentra en estado: "+ recurso.getEstadoLibro());
            MetodosEspeciales.pressEnter();
        }else{
            System.out.println("Está seguro que desea eliminar el recurso: ");
            System.out.println(recurso);
            System.out.println("1. Continúar");
            System.out.println("2. Cancelar");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            if (opcion == 1){
                System.out.println(recurso.getTipoRecurso()+" "+recurso.getTitulo() + " eliminado correctamente.");
                libreria.eliminarRecurso(recurso);
            }else {
                System.out.println("Solicitud de eliminación cancelada");
                MetodosEspeciales.pressEnter();
            }
        }
    }
}
