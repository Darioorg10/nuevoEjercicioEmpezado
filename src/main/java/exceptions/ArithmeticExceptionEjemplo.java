/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author jfervic933
 */
public class ArithmeticExceptionEjemplo {

    public static void main(String[] args) {

        // Divisiones reales
        System.out.println("Resultado dividir 12.0 entre 3.0 es " + dividir(12.0, 3.0));
        // Operación aritmética imposible (dividir por cero)
        // NaN o Infinity significa que se quiere dividir por 0.0 (real)
        System.out.println("Resultado dividir 12.0 entre 0.0 es " + dividir(12.0, 0.0));

        // Divisiones enteras
        System.out.println("Resultado dividir 12 entre 3 es " + dividir(12, 3));
        // Operación aritmética imposible (dividir por cero)
        // NaN o Infinity significa que se quiere dividir por 0.0 (real)
        //System.out.println("Resultado dividir 12.0 entre 0.0 es " + dividir(12, 0));

        System.out.println("Resultado dividir 12.0 entre 0.0 es " + dividirExcepcion(12, 0));

    }

    private static double dividir(double numerador, double denominador) {
        double resultado = 0;

        resultado = numerador / denominador;

        return resultado;
    }

    private static int dividir(int numerador, int denominador) {
        int resultado = 0;

        resultado = numerador / denominador;

        return resultado;
    }

    private static int dividirExcepcion(int numerador, int denominador) {
        int resultado;
        // El código susceptible de provocar la excepción se engloba en el 
        // bloque try{}
        try {
            resultado = numerador / denominador;
        } catch (ArithmeticException ae) {
            resultado = numerador;
            System.out.println("Error. Se ha intentado dividir por cero.");
        }

        return resultado;
    }
}
