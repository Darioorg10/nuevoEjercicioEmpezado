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

        String codigoProducto;

        // Mostramos el menú inicial
        String opcion = "";
        do {

            opcion = UtilidadesEjercicio3E.pedirOpcion(); // Apartado 1

            // Si no es salir, pido el código de producto
            if (!opcion.equalsIgnoreCase("salir")) {

                // Pedir y filtrar el código del producto                
                codigoProducto = UtilidadesEjercicio3E.pedirCodigoProducto();

                // Si código producto no es salir, realizo los cálculos                
                if (!codigoProducto.equalsIgnoreCase("salir")) {

                    // Solicitar y filtrar materia prima
                    double materiaPrima = UtilidadesEjercicio3E.pedirMateriaPrima();

                    // Solicitar y filtrar mano de obra
                    double manoObra = UtilidadesEjercicio3E.pedirManoObra();

                    // Calcular coste de producción
                    double costeProduccion = (materiaPrima + manoObra);

                    // Calcular beneficio
                    double beneficio = UtilidadesEjercicio3E.calcularBeneficio(codigoProducto, costeProduccion);

                    // Calcular precio venta unitario
                    double precioVentaUnitario = (costeProduccion + beneficio);

                    // Calcular unidades hasta llegar al beneficio
                    int unidadesParaBeneficio = UtilidadesEjercicio3E.calcularUnidadesParaBeneficio(beneficio);

                    // Mostrar toda la información
                    String mostrarInformacion = """
                                              El coste de producción es %.2f
                                              El precio de venta es %.2f
                                              Y las unidades para beneficio %d""".formatted(costeProduccion,
                             precioVentaUnitario, unidadesParaBeneficio);
                    JOptionPane.showMessageDialog(null, mostrarInformacion);

                } else { // Si es salir
                    opcion = "salir";
                }
            }

        } while (opcion.equalsIgnoreCase("calcular"));
    }

}
