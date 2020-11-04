/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jfervic933
 */
public class InputMismatchEjemplo {

    private static Scanner flujo = new Scanner(System.in);

    public static void main(String[] args) {

        leerCalificacion();
        leerCalificacionSinErrores();
        leerCalificacionSinErroresBucle();

    }

    // El siguiente método no controla ninguna excepción
    private static void leerCalificacion() {
        System.out.println("Introduce una calificación entera (0 - 10): ");

        int calificacion = flujo.nextInt();

        System.out.println("La calificación es: " + calificacion);
    }

    private static void leerCalificacionSinErrores() {

        System.out.println("Introduce una calificación entera (0 - 10): ");
        int calificacion = 0;
        // Se pone dentro del bloque try la sentencia que puede producir 
        // el error
        try {
            calificacion = flujo.nextInt();
            System.out.println("La calificación es: " + calificacion);
        } catch (InputMismatchException ime) {
            // En caso de error
            System.out.println("No se puede imprimir la calificación");
            // Limpieza del buffer
            flujo.nextLine();
        }
    }

    private static void leerCalificacionSinErroresBucle() {

        int calificacion = 0;
        boolean repetir = true;
        // Se pone dentro del bloque try la sentencia que puede producir 
        // el error
        do {
            System.out.println("Introduce una calificación entera (0 - 10): ");
            try {
                calificacion = flujo.nextInt();
                // La calificación es válida. Imprimo y salgo del bucle
                System.out.println("La calificación es: " + calificacion);
                repetir = false;
            } catch (InputMismatchException ime) {
                // En caso de error
                System.out.println("No se puede imprimir la calificación");
                // Limpieza del buffer
                flujo.nextLine();
            }
        } while (repetir);
    }
}
