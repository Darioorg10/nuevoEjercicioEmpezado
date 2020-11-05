package exceptions;


/**
 *
 * @author JCarlos F.Vico <jfervic933@maralboran.es>
 */
public class ArrayIndexOutOfBoundsEjemplo {
    
    public static void main(String[] args) {
        
        String texto = "Módulo de Programación";
        char[] arrayLetras = texto.toCharArray();
        
        
        System.out.println("Tamaño de la cadena de texto" + texto.length());
        System.out.println("Tamaño del array de letras " + arrayLetras.length);
        
        mostrarArrayLetras(arrayLetras);
        mostrarUnaLetra(arrayLetras, 3);
        //mostrarUnaLetra(arrayLetras, 100); // Excepción
        mostrarUnaLetraSinErrores(arrayLetras, 100); // Excepción
        
        // Si se intenta acceder a un caracter fuera del rango válido
        // del String texto entonces la excepción es StringOutOfBounds
        System.out.println(texto.charAt(100));
    }
    
    // Este método controla las posiciones válidas del array y no provoca
    // ninguna excepción ArrayIndexOutOfBounds
    private static void mostrarArrayLetras (char[] arrayLetras){
        // Mostramos el contenido del array
        for (int i = 0; i < arrayLetras.length; i++) {
            // En cada iteración se accede al contenido entre 0 y array.length-1
            // que son las posiciones válidas del array
            System.out.println("arrayLetras[" + i + "] = " + arrayLetras[i]);
        }
    }
    
    private static void mostrarUnaLetra(char[] arrayLetras, int posicion){
        // Si la posición no es válida --> excepción
        System.out.println("Contenido en la posición indicada: " + arrayLetras[posicion]);
    }
    
    private static void mostrarUnaLetraSinErrores(char[] arrayLetras, int posicion){
        // Si la posición no es válida --> excepción
        try{
            // El código expuesto a errores se pone dentro del try
            System.out.println("Contenido en la posición indicada: " + arrayLetras[posicion]);
        } catch (ArrayIndexOutOfBoundsException aiooe){
            System.out.println("La posición indicada no es válida");
        } 
    }
}
