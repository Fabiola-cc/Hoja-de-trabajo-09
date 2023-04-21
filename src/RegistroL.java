import BST.ComparadorPalabras;
import BST.EstructuraArbol;
import BST.Palabra;
import BST.structure5.Association;

import java.io.FileNotFoundException;

public class RegistroL {
    static EstructuraArbol<Palabra> inglesK;

    /**
     * Llama a la clase readFile para leer el documento deseado y retornar los datos
     * del archivo en el formato adecuado
     * 
     * @param reader
     * @throws FileNotFoundException
     */
    public static void saveInfo(readFile reader, EstructuraArbol<Palabra> tree) throws FileNotFoundException {
        inglesK = reader._readEnglish(tree);

    }

}