import BST.Palabra;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Traduccion {
    static ArrayList<String[]> toTraduce; //Guarda todas las fraces por traducir en el programa

    /**
     * Permite la traducción de frases a través de la lectura de un archivo y la
     * revisión del diccionario
     * 
     * @param reader
     * @throws FileNotFoundException
     */
    public static void traduce(readFile reader) throws FileNotFoundException {
        if (RegistroL.inglesK != null) { // Si hay datos registrados
            toTraduce = reader.Traduce(); // Lectura de archivo y registro de datos
            for (String[] frase : toTraduce) { // Por cada frase a traducir
                String traduccion = ""; //Frase traducida
                String original = ""; //Frase en inglés
                for (String palabra : frase) { // Por cada palabra encontrada
                    palabra = palabra.toLowerCase(); //minusculas
                    Palabra tempWord = new Palabra(palabra, ""); //Crea una instancia de tipo palabra para poder comparar su dato con los existentes y verificar su existencia en el diccionario
                    String temp1 = ""; //Abierta para guardar temporalmente la traducción de la palabra
                    if (RegistroL.inglesK.has(tempWord)) { // Si existe en el diccionario de ingles
                        temp1 = RegistroL.inglesK.get(tempWord).getSpanish() + " ";
                    } else { // Si no está registrada
                        temp1 = "*" + palabra + "* ";
                    }

                    // Agregar las palabras a una cadena, relacionando la frase completa
                    original += palabra + " ";
                    traduccion += temp1;
                }

                System.out.println("\n-->" + original); // Frase inicial
                System.out.println("\tTraducido: " + traduccion);
            }
        } else {
            System.out.println("Cuidado, aún no se han ingresado datos al diccionario");
        }

    }
}