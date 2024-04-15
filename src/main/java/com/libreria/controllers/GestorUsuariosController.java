package com.libreria.controllers;

import com.libreria.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestorUsuariosController {
    private static List<Usuario> usuarioList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public GestorUsuariosController(){}

    public static void agregarUsuario(){
        try{
            System.out.println("Oprima enter");
            scanner.nextLine();
            System.out.print("Ingrese el nombre completo del usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la edad del usuario: ");
            int edad = scanner.nextInt();
            Usuario usuario = new Usuario(nombre, edad);
            usuarioList.add(usuario);
            System.out.println("Usuario agregado correctamente con el id: " + usuario.getId());
        }catch (Exception e){
            System.out.println("Los datos ingresados no fueron correctos, intentalo de nuevo");
        }
    }
    public static void eliminarUsuario(){
        System.out.print("Ingrese el id del usuario: ");
        int id = scanner.nextInt();
        Usuario usuario = GestorUsuariosController.consultarUsuarioPorId(id);
        if (usuario != null){
            System.out.println("Estás seguro que desea eliminar a "+usuario.getNombre());
            System.out.println("1. Confirmar");
            System.out.println("2. Cancelar");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            if (opcion == 1){
                System.out.println("Usuario "+usuario.getNombre()+" fue eliminado correctamente.");
                usuarioList.remove(usuario);
            }else {
                System.out.println("Solicitud cancelada.");
            }


        }else {
            System.out.println("El usuario no existe.");
        }

    }
    public static void consultarUsuarioPorNombre(){
        System.out.println("Oprima enter");
        scanner.nextLine();
        System.out.print("Ingrese el nombre completo del usuario: ");
        String nombre = scanner.nextLine().toUpperCase(Locale.ROOT);
        Usuario usuarioBuscado = null;
        for (Usuario usuario: usuarioList){
            if (usuario.getNombre().equals(nombre)){
                usuarioBuscado =  usuario;
            }
        }
        if (usuarioBuscado!=null){
            System.out.println(usuarioBuscado);
        }else {
            System.out.println("Usuario no encontrado");
        }

    }
    public static Usuario consultarUsuarioPorId(){
        System.out.print("Ingrese el id del usuario: ");
        int id = scanner.nextInt();
        Usuario usuarioBuscado = null;
        for (Usuario usuario: usuarioList){
            if (usuario.getId()== id){
                usuarioBuscado =  usuario;
            }
        }if (usuarioBuscado==null){
            System.out.println("Usuario no encontrado");
        }
        return usuarioBuscado;
    }
    public static void cambiarEstado(){
        Usuario usuario = consultarUsuarioPorId();
        System.out.println(usuario.getNombre());
        System.out.println("Ingrese 1 para activar o 0 para suspender");
        int opcion = scanner.nextInt();
        Boolean estado;
        if (opcion == 1){
            estado = true;
            System.out.println("Usuario Activado");
        }else {
            estado = false;
            System.out.println("Usuario suspendido");
        }
        if (usuario != null){
            usuario.setEstadoCuenta(estado);
        }else{
            System.out.println("Usuario no encontrado");
        }
    }
    public static void buscarUsuarioYVerHistorial(){
        Usuario usuario = consultarUsuarioPorId();
        if (usuario !=null){
            usuario.verHistorialPrestamos();
        }else{
            System.out.println("Usuario no encontrado");
        }
    }
    public static void verTodosLosUsuarios(){
        if (!usuarioList.isEmpty()){
            System.out.println("Lista de usuarios");
            for (Usuario usuario: usuarioList){
                System.out.println(usuario);
                System.out.println("Cantidad de usuarios registrados: "+usuarioList.size());
            }
        }else{
            System.out.println("No hay usuarios registrados");
        }

    }



    public static void agregarUsuario(Usuario usuario){
        usuarioList.add(usuario);
    }
    public static Usuario consultarUsuarioPorId(int id){
        Usuario usuarioBuscado = null;
        for (Usuario usuario: usuarioList){
            if (usuario.getId()== id){
                usuarioBuscado =  usuario;
            }
        }
        return usuarioBuscado;
    }
}
