/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author jfervic933
 */
public class NumberFormatEjemplo {

    public static void main(String[] args) {
        int edad1 = leerNumeroEntero();
        System.out.println("Edad 1: " + edad1);
        int edad2 = leerNumeroEnteroSinErrores();
        System.out.println("Edad 2: " + edad2);
    }

    private static int leerNumeroEntero() {
        String tmp = JOptionPane.showInputDialog("Introduce tu edad: ");
        int edad = Integer.parseInt(tmp);
        return edad;
    }

    private static int leerNumeroEnteroSinErrores() {

        boolean repetir = true;
        int edad = -1; // Edad no válida
        
        do {
            String tmp = JOptionPane.showInputDialog("Introduce tu edad: ");
            try {
                edad = Integer.parseInt(tmp);
                repetir = false;
            } catch (NumberFormatException nfe) {
                JOptionPane.showConfirmDialog(null, "No has introducido un número entero.");
            }
        } while (repetir);
        
        return edad;
    }
}
