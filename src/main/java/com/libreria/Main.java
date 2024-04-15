package com.libreria;

import com.libreria.controllers.GestorUsuariosController;
import com.libreria.controllers.PrestamosYDevolucionesController;
import com.libreria.controllers.RecursosController;
import com.libreria.models.Libreria;
import com.libreria.scripts.Scripts;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        GestorUsuariosController usuariosController = new GestorUsuariosController();

        Scripts.agregarElementosRamdon(libreria);
        //*************************************************************************************//

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("////////////////");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1) Agregar Recurso");
            System.out.println("2) Buscar por Título");
            System.out.println("3) Buscar por Autor");
            System.out.println("4) Mostrar inventario");
            System.out.println("5) Gestionar Recurso");
            System.out.println("6) Gestión de préstamos");
            System.out.println("7) Gestión de usuario");
            System.out.println("0) Salir");
            System.out.print("Elija una opción: ");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Agregar libro");
                    RecursosController.agregar(libreria);
                    Scripts.pressEnter();
                    break;
                case 2:
                    System.out.println("Buscar recurso por título");
                    RecursosController.buscarPorTitulo(libreria);
                    Scripts.pressEnter();
                    break;
                case 3:
                    System.out.println("Buscar recurso por autor");
                    RecursosController.buscarPorAutor(libreria);
                    Scripts.pressEnter();
                    break;
                case 4:
                    System.out.println("Mostrar inventario");
                    RecursosController.verInventario(libreria);
                    Scripts.pressEnter();
                    break;
                case 5:
                    System.out.println(" ////////////////");
                    System.out.println(" Gestionar Libro");
                    System.out.println(" 1. Editar Recurso");
                    System.out.println(" 2. Eliminar Recurso");
                    System.out.print("Elija una opción: ");
                    int optionRecurso = scanner.nextInt();
                    if (optionRecurso == 1){
                        RecursosController.editarRecurso(libreria);
                    } else if (optionRecurso == 2) {
                        RecursosController.eliminarRecurso(libreria);
                    }else {
                        System.out.println("Opción invalida");
                    }

                    break;
                case 6:
                    int opcionPrestamos;
                    do {
                        System.out.println(" ////////////////");
                        System.out.println(" Gestionar prestamos de recursos");
                        System.out.println(" 1. Realizar prestamo");
                        System.out.println(" 2. Devolver");
                        System.out.println(" 3. Ver estado de prestamo");
                        System.out.println(" 0. Volver atrás");
                        System.out.print("Elija una opción: ");
                        opcionPrestamos = scanner.nextInt();
                        switch (opcionPrestamos){
                            case 1:
                                System.out.println("Realizar prestamo");
                                PrestamosYDevolucionesController.generarPrestamo(libreria);
                                Scripts.pressEnter();
                                break;
                            case 2:
                                System.out.println("Devolver");
                                PrestamosYDevolucionesController.devolverRecurso();
                                Scripts.pressEnter();
                                break;
                            case 3:
                                System.out.println("Ver estado de prestamo");
                                PrestamosYDevolucionesController.getPrestamo();
                                Scripts.pressEnter();
                                break;
                            default:
                                System.out.println("Elija una opción valida");

                        }

                    }while (opcionPrestamos != 0);
                    break;
                case 7:
                    int optionUser;
                    do {
                        System.out.println(" ////////////////");
                        System.out.println(" Sistema de gestión de usuarios");
                        System.out.println(" 1. Agregar usuario");
                        System.out.println(" 2. Eliminar usuario");
                        System.out.println(" 3. Cambiar estado de usuario");
                        System.out.println(" 4. Ver historial de prestamos");
                        System.out.println(" 5. Ver todos los usuarios");
                        System.out.println(" 6. Buscar usuario por id");
                        System.out.println(" 7. Buscar usuario por nombre");
                        System.out.println(" 0. Volver atrás");
                        System.out.print(" Elija una opción: ");
                        optionUser = scanner.nextInt();

                        switch (optionUser){
                            case 1:
                                System.out.println("Agregar usuario");
                                GestorUsuariosController.agregarUsuario();
                                Scripts.pressEnter();
                                break;
                            case 2:
                                System.out.println("Eliminar usuario");
                                GestorUsuariosController.eliminarUsuario();
                                Scripts.pressEnter();
                                break;
                            case 3:
                                System.out.println("Cambiar estado de usuario");
                                GestorUsuariosController.cambiarEstado();
                                Scripts.pressEnter();
                                break;
                            case 4:
                                System.out.println("Ver historial de prestamos");
                                GestorUsuariosController.buscarUsuarioYVerHistorial();
                                Scripts.pressEnter();
                                break;
                            case 5:
                                System.out.println("Ver todos los usuarios");
                                GestorUsuariosController.verTodosLosUsuarios();
                                Scripts.pressEnter();
                                break;
                            case 6:
                                System.out.println("Buscar usuario por id");
                                System.out.println(GestorUsuariosController.consultarUsuarioPorId());
                                Scripts.pressEnter();
                                break;
                            case 7:
                                System.out.println("Buscar usuario por nombre");
                                GestorUsuariosController.consultarUsuarioPorNombre();
                                Scripts.pressEnter();
                                break;
                            default:
                                System.out.println("Elija una opción valida");

                        }
                    }while (optionUser !=0);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                default:
                    System.out.println("Elija una opción valida");
                    break;
            }

        }while (option!=0);
    }



}