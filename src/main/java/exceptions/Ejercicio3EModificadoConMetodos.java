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
public class Ejercicio3EModificadoConMetodos {
    
    public static void main(String[] args) {

        // Creamos el primer bucle, donde si la opcion es diferente a calcular o terminar
        // se vuelve a pedir
        String opcion;
        String opcionTexto;
        String codigoProducto;

        // Costes mano obra
        double manoObra;

        // Margen de beneficio por unidad
        final double BENEFICIO_M1_M2_P1 = 0.5; // 50%
        final double BENEFICIO_T1_2 = 0.65;    // 65%

        // Beneficio final
        final double BENEFICIO_VENTAS = 2500;

        // Rango precio materia prima
        final double LIMITE_INFERIOR_MATERIA = 0.1;
        final double LIMITE_SUPERIOR_MATERIA = 1;

        // Rango coste mano de obra
        final double LIMITE_INFERIOR_OBRA = 0.5;
        final double LIMITE_SUPERIOR_OBRA = 0.9;

        // Variables
        double precioMateriaPrima = 0;
        double costeProduccion = 0;
        double precioVentaU = 0;
        int unidadesParaBeneficio = 0;

        do { // Bucle del menú inicial

            // Mostramos el menú inicial
            
            opcion = UtilidadesEjercicio3E.pedirOpcion(); // Apartado 1
            
            // Leemos 
            
            if (opcion.equals("CALCULAR")) {
                // Creamos lo que pasa si introduces calcular

                do { //Bucle  al introducir el calcular
                    opcion
                            = JOptionPane.showInputDialog("Introduce el código del producto o salir");
                    opcion = opcion.toUpperCase();

                    // Si el código es válido o quiere salir              
                    switch (opcion) {
                        case "M1","M2","T1","T2", "P1":

                            // Pedimos la materia prima y repite si no es válido
                            do {
                                precioMateriaPrima = Double.parseDouble(
                                        JOptionPane.showInputDialog("Introduce precio materia prima"
                                                + " entre 0.1 y 1"));
                            } while (!(precioMateriaPrima >= LIMITE_INFERIOR_MATERIA
                                    && precioMateriaPrima <= LIMITE_SUPERIOR_MATERIA));

                            // Pedimos la mano de obra y repite si no es válido
                            do {
                                manoObra = Double.parseDouble(
                                        JOptionPane.showInputDialog("Introduce el coste de"
                                                + " la mano de obra (entre 0.5 y 0.9)"));
                            } while (!(manoObra >= LIMITE_INFERIOR_OBRA
                                    && manoObra <= LIMITE_SUPERIOR_OBRA));

                            // Hacemos los cálculos
                            // Calculamos el coste de producción
                            costeProduccion = precioMateriaPrima + manoObra;

                            // Seleccionamos el beneficio que sea
                            double beneficio = ((opcion.equals("T2")
                                    || opcion.equals("T1"))) ? BENEFICIO_T1_2 : BENEFICIO_M1_M2_P1;

                            // Calculamos el precio de venta unitario
                            precioVentaU = costeProduccion + (beneficio * costeProduccion);

                            // Calculamos el beneficio
                            beneficio = precioVentaU - costeProduccion;

                            // Calculamos las unidades para obtener beneficio
                            unidadesParaBeneficio = (int) Math.ceil(BENEFICIO_VENTAS / beneficio);

                            String resultados = """
                                                El coste de producción es %.2f
                                                El precio de venta unitario es %.2f
                                                Las unidades para beneficio son %d"""
                                    .formatted(costeProduccion, precioVentaU,
                                            unidadesParaBeneficio);

                            JOptionPane.showMessageDialog(null, resultados);
                            break;
                        case "SALIR":
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "El código no es valido");
                    }
                } while (!(opcion.equals("M1") || opcion.equals("M2")
                        || opcion.equals("T1") || opcion.equals("T2")
                        || opcion.equals("P1") || opcion.equals("SALIR")));
            }
        } while (!opcion.equals("SALIR"));
    }
    
}
