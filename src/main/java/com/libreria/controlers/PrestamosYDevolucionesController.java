package com.libreria.controlers;

import com.libreria.models.Libreria;
import com.libreria.models.Prestamo;
import com.libreria.models.Usuario;
import com.libreria.models.bases.EstadosLibros;
import com.libreria.models.bases.Recurso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrestamosYDevolucionesController {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Prestamo> prestamoList = new ArrayList<>();


    /*Metodos*/
    public static void generarPrestamo(Libreria libreria){
        System.out.print("Ingrese el ISBN del recurso: ");
        int isbn = scanner.nextInt();
        Recurso recurso = libreria.buscarIbsn(isbn);
        if (recurso.getEstadoLibro() == EstadosLibros.DISPONIBLE){
            System.out.println("+"+recurso.getTipoRecurso()+" "+recurso.getTitulo());
            Usuario usuario = GestorUsuariosController.consultarUsuarioPorId();
            if (usuario!=null && usuario.isEstadoCuenta()){
                System.out.println("Usuario: "+ usuario.getNombre());
                Prestamo prestamo = new Prestamo(recurso,usuario);
                recurso.setEstadoLibro(EstadosLibros.PRESTADO);
                prestamoList.add(prestamo);
                System.out.println("Se realizo el prestamo, el usuario cuenta con 30 días para devolverlo");
            }else{
                System.out.println(usuario==null?"Usuario no encontrado":"USUARIO "+usuario.getNombre()+" BLOQUEADO POR RETRASOS");
            }
        }else if(recurso == null){
            System.out.println("Recurso no encontrado.");
        }else{
            System.out.println("El recurso ingresado no puede ser prestado, se encuentra en estado '"+ recurso.getEstadoLibro()+"'");
        }

    }
    public static void getPrestamo(){
        System.out.print("Ingrese el ISBN del recurso: ");
        int isbn = scanner.nextInt();
        boolean existeElPrestamo = false;
        for (Prestamo prestamo: prestamoList){
            if (prestamo.getRecurso().getIsbn() == isbn ){
                System.out.println(prestamo);
            }
        }
        if (!existeElPrestamo){
            System.out.println("El recurso aun no ha sido prestado.");
        }


    }
    public static void devolverRecurso(){
        System.out.print("Ingrese el ISBN del recurso: ");
        int isbn = scanner.nextInt();
        Recurso recurso = null;
        Usuario usuario  = null;
        Prestamo prestamo1 = null;
        for (Prestamo prestamo: prestamoList){
            if (prestamo.getRecurso().getIsbn() == isbn){
                recurso = prestamo.getRecurso();
                usuario = prestamo.getUsuario();
                prestamo1 = prestamo;

            }
        }
        if (prestamo1!=null) {
            if (prestamo1.isTieneMulta()) {
                System.out.println("//////////////////////////////////////////////");
                System.out.println(
                                "Este " + recurso.getTipoRecurso() +
                                " cuenta con una multa de $" + prestamo1.getValorMulta() +
                                "\npor un retraso de " + (prestamo1.getContadorDias() - prestamo1.getCantDiasPrestamo()) +" dias"+
                                "\nrecuerda generar el cobro antes de recibir"
                );
                System.out.println("//////////////////////////////////////////////");
            }
            System.out.println("Revise que el recurso se encuentre en buenas condiciones para la devolución");
            System.out.println("1. Continuar");
            System.out.println("2. Cancelar");
            System.out.print("Desea continuar la devolución? ");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
                prestamoList.remove(prestamo1);
                if (!usuario.isEstadoCuenta()){
                    usuario.setEstadoCuenta(true);
                }
                usuario.agregarAlHistorialDePrestamos(recurso);
                recurso.setEstadoLibro(EstadosLibros.DISPONIBLE);
                System.out.println("La devolución se realizó correctamente");
            } else {
                System.out.println("Se a cancelado el proceso de devolución");
            }
        }else{
            System.out.println("El recurso aun no ha sido prestado.");
        }

    }




/***********************************************************************************************************************/
    //Estos métodos se crearon especificamente para usarse con lo datos ramdon que se ejecutan al iniciar el programa
    public static void generarPrestamoRecurso(Recurso recurso,Usuario usuario){
        Prestamo prestamo = new Prestamo(recurso,usuario);
        recurso.setEstadoLibro(EstadosLibros.PRESTADO);
        prestamoList.add(prestamo);
        System.out.println("Se realizo el prestamo, el usuario cuenta con 30 días para devolverlo");

    }
    public static Prestamo getPrestamo(Recurso recurso){
        Prestamo prestamoR = null;
        for (Prestamo prestamo: prestamoList){
            if (prestamo.getRecurso().equals(recurso) ){
                prestamoR = prestamo;
            }
        }
        return prestamoR;
    }
/***********************************************************************************************************************/
}
