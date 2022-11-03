/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author dario
 */
public class UtilidadesEjercicio3E {

    // Métodos para mostrar opciones generales del programa
    // y filtrarlas hasta que sean correctas
    public static String pedirOpcion() {
        String opcion;
        do {
            opcion = mostrarMenuInicial();
        } while (!esOpcionMenuInicialValida(opcion));
        return opcion;
    }

    public static boolean esOpcionMenuInicialValida(String opcion) {

        return opcion.equalsIgnoreCase("salir") || opcion.equalsIgnoreCase("calcular");
    }

    public static String mostrarMenuInicial() {

        String texto = """
                          ----------------------------------------------------------------
                                                    MENÚ
                          ----------------------------------------------------------------
                          Para realizar los cálculos: calcular
                          Para terminar el programa: salir
                          ----------------------------------------------------------------""";

        String opcion = JOptionPane.showInputDialog(texto);
        return opcion;
    }

    // Métodos para mostrar códigos de productos
    // y filtrarlos hasta que sean correctos
    public static String pedirCodigoProducto() {
        String codigo;
        do {
            codigo = mostrarMenuCodigos();
        } while (!esCodigoProductoValido(codigo));
        return codigo;
    }

    public static String mostrarMenuCodigos() {

        String texto = """
                          Introduce el código del producto:
                          M1 - Mantecados de limón
                          P1 - Polvorones
                          T1 - Turrón de chocolate
                          T2 - Turrón clásico
                          M2- Mazapanes
                          
                          ----------------------------------------------------------------""";

        String opcion = JOptionPane.showInputDialog(texto);

        return opcion;
    }

    public static boolean esCodigoProductoValido(String codigo) {
//        if(codigo.equalsIgnoreCase("m1")||codigo.equalsIgnoreCase("p1")
//                ||codigo.equalsIgnoreCase("t1")){
//            return true;
//        }
//        else{
//            return false;
//        }
        return codigo.equalsIgnoreCase("m1") || codigo.equalsIgnoreCase("p1")
                || codigo.equalsIgnoreCase("t1") || codigo.equalsIgnoreCase("salir")
                || codigo.equalsIgnoreCase("t2") || codigo.equalsIgnoreCase("m2");
    }

    // Métodos para pedir materia prima y filtrarla hasta que sea válida
    public static double pedirMateriaPrima() {
        String texto = """
                     Introduce el precio de la materia prima (entre 0.1 y 1)""";
        double materiaPrima = 0;
        do {
            try {
                materiaPrima = Double.parseDouble(JOptionPane.showInputDialog(texto));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "No has introducido "
                        + "el número correctamente");
            }
        } while (esMateriaPrimaValida(materiaPrima));
        return materiaPrima;
    }

    public static boolean esMateriaPrimaValida(double materiaPrima) {
        return 0.1 > materiaPrima || materiaPrima > 1;
    }

    // Métodos para pedir mano de obra y filtrarla hasta que sea válida
    public static double pedirManoObra() {
        String texto = """
                     Introduce el precio de la mano de obra (entre 0.5 y 0.9)""";
        double manoObra = 0;
        do {
            try {
                manoObra = Double.parseDouble(JOptionPane.showInputDialog(texto));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "No has introducido "
                        + "el número correctamente");
            }
        } while (esManoObraValida(manoObra));
        return manoObra;
    }

    public static boolean esManoObraValida(double manoObra) {
        return 0.5 > manoObra || manoObra > 0.9;
    }

    // Métodos para calcular el beneficio y las unidades para el beneficio
    public static double calcularBeneficio(String codigoProducto, double costeProduccion) {
        double beneficio = 0;

        if (codigoProducto.equalsIgnoreCase("t1")
                || codigoProducto.equalsIgnoreCase("t2")) {
            beneficio = (0.65 * costeProduccion);
        } else {
            beneficio = (0.5 * costeProduccion);
        }
        return beneficio;
    }

    public static int calcularUnidadesParaBeneficio(double beneficio) {
        final double BENEFICIO_VENTAS = 2500;
        int unidadesParaBeneficio = (int) Math.ceil(BENEFICIO_VENTAS / beneficio);
        return unidadesParaBeneficio;
    }

}
