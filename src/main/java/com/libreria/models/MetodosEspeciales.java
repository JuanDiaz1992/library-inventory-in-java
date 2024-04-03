package com.libreria.models;

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
}
