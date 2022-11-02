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
    
    public static String pedirOpcion(){
        String opcion;
        do {            
            opcion = mostrarMenuInicial();
        } while (!esOpcionMenuInicialValida(opcion));
        return opcion;
    }
    
    public static boolean esOpcionMenuInicialValida(String opcion){
        
        return opcion.equalsIgnoreCase("salir")|| opcion.equalsIgnoreCase("calcular");
    }
    
    public static String mostrarMenuInicial() {

        String opcion;
        String opcionTexto = """
                          ----------------------------------------------------------------
                                                    MENÚ
                          ----------------------------------------------------------------
                          Para realizar los cálculos: calcular
                          Para terminar el programa: salir
                          ----------------------------------------------------------------""";

        opcion = JOptionPane.showInputDialog(opcionTexto);
        opcion = opcion.toUpperCase();
        
        return opcion;
    }

}
